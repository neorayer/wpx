package com.skymiracle.wpx;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.skymiracle.fax.FaxConfig;
import com.skymiracle.mdo5.RdbmsStore;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.wpx.auth.AuthLog;
import com.skymiracle.wpx.auth.WpxAuthMail;
import com.skymiracle.wpx.models.addrbook.AddrConf;
import com.skymiracle.wpx.models.addrbook.AddrGrp;
import com.skymiracle.wpx.models.addrbook.AddrPsn;
import com.skymiracle.wpx.models.admin.AddressbookAdmin;
import com.skymiracle.wpx.models.admin.DomainAdmin;
import com.skymiracle.wpx.models.admin.MultiDomainAdmin;
import com.skymiracle.wpx.models.admin.SuperAdmin;
import com.skymiracle.wpx.models.bookmark.BmFolder;
import com.skymiracle.wpx.models.bookmark.BmItem;
import com.skymiracle.wpx.models.conf.MBAPConfgier;
import com.skymiracle.wpx.models.conf.SMTPConfiger;
import com.skymiracle.wpx.models.conf.SingleConf;
import com.skymiracle.wpx.models.conf.SmtpTrustIp;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.domain.DomainAlias;
import com.skymiracle.wpx.models.fax.Fax;
import com.skymiracle.wpx.models.ipcontrol.IpFilterChange;
import com.skymiracle.wpx.models.ipcontrol.IpFilterItem;
import com.skymiracle.wpx.models.ipcontrol.IpSegiment;
import com.skymiracle.wpx.models.log.MailLog;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.BatchGroup;
import com.skymiracle.wpx.models.mail.BatchGroupCondition;
import com.skymiracle.wpx.models.mail.Mail;
import com.skymiracle.wpx.models.mail.MailClassX;
import com.skymiracle.wpx.models.mail.MailFolder;
import com.skymiracle.wpx.models.mail.MailInk;
import com.skymiracle.wpx.models.mail.TimerMail;
import com.skymiracle.wpx.models.netdisk.NdFile;
import com.skymiracle.wpx.models.netdisk.NdFolder;
import com.skymiracle.wpx.models.portal.ModFunc;
import com.skymiracle.wpx.models.stat.SendMailStat;
import com.skymiracle.wpx.models.user.Dept; //import com.skymiracle.wpx.models.user.GroupUser;
import com.skymiracle.wpx.models.user.GrpUser;
import com.skymiracle.wpx.models.user.GrpUserMember;
import com.skymiracle.wpx.models.user.Skin;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.models.user.UserAlias;
import com.skymiracle.wpx.note.Note;

public class Singletons {

	public static RdbmsStore appStore;
	public static RdbmsStore mailLogStore;
	public static XmlBeanFactory beanFactory;
	static {
		String rootPath = Singletons.class.getPackage().getName().replace('.',
				'/');
		Resource resource = new ClassPathResource(rootPath + "/spring.xml");
		beanFactory = new XmlBeanFactory(resource);

		PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
		cfg.setLocation(new ClassPathResource(rootPath + "/app.props"));
		cfg.postProcessBeanFactory(beanFactory);

		appStore = (RdbmsStore) beanFactory.getBean("AppStore");
		mailLogStore = (RdbmsStore) beanFactory.getBean("MailLogStore");
	}

	public static Domain.X $Domain = (Domain.X) beanFactory.getBean("DomainX");
	public static DomainAlias.X $DomainAlias = new DomainAlias.X();
	public static Dept.X $Dept = new Dept.X();
	public static User.X $User = new User.X();
	public static UserAlias.X $UserAlias = new UserAlias.X();

	public static StorageAccessorFactory saFactory = (StorageAccessorFactory) beanFactory
			.getBean("StorageAccessorFactory");

	// public static MimeReader mimeReader = (MimeReader) beanFactory
	// .getBean("mimeReader");

	public static Mail.X $Mail = (Mail.X) beanFactory.getBean("MailX");
	public static MailFolder.X $MailFolder = new MailFolder.X(saFactory);
	public static MailClassX $MailClass = new MailClassX(saFactory);
	public static MailInk.X $MailInk = new MailInk.X();
	public static AddrGrp.X $AddrGrp = new AddrGrp.X();
	public static AddrPsn.X $AddrPsn = new AddrPsn.X();
	public static AddrConf.X $AddrConf = new AddrConf.X();

	public static Note.X $Note = new Note.X();
	public static BmFolder.X $BmFolder = new BmFolder.X();
	public static BmItem.X $BmItem = new BmItem.X();
	public static NdFolder.X $NdFolder = new NdFolder.X(saFactory);
	public static NdFile.X $NdFile = new NdFile.X(saFactory);

	public static IpFilterItem.X $IpFilterItem = new IpFilterItem.X();
	public static IpSegiment.X $IpSegiment = new IpSegiment.X();
	public static IpFilterChange.X $IpFilterChange = new IpFilterChange.X();

	public static SuperAdmin.X $SuperAdmin = new SuperAdmin.X();
	public static AddressbookAdmin.X $AddressbookAdmin = new AddressbookAdmin.X();
	public static MultiDomainAdmin.X $MultiDomainAdmin = new MultiDomainAdmin.X();
	public static DomainAdmin.X $DomainAdmin = new DomainAdmin.X();

	public static SMTPConfiger smtpConfiger = (SMTPConfiger) beanFactory
			.getBean("smtpConfiger");

	public static MBAPConfgier mbapConfiger = (MBAPConfgier) beanFactory
			.getBean("mbapConfiger");

	// log
	public static SysLog.X $SysLog = new SysLog.X();
	public static AuthLog.X $AuthLog = (AuthLog.X) beanFactory
			.getBean("AuthLogX");
	public static MailLog.X $MailLog = (MailLog.X) beanFactory
			.getBean("MailLogX");

	public static TimerMail.X $TimerMail = (TimerMail.X) beanFactory
			.getBean("TimerMailX");

	public static WpxAuthMail WpxAuthMail = (WpxAuthMail) beanFactory
			.getBean("WpxAuthMail");

	public static GrpUser.X $GrpUser = new GrpUser.X();
	public static GrpUserMember.X $GrpUserMember = new GrpUserMember.X();
	

	public static ModFunc.X $ModFunc = (ModFunc.X) beanFactory
			.getBean("ModFuncX");
	public static SmtpTrustIp.X $SmtpTrustIp = new SmtpTrustIp.X();
	public static SingleConf.X $SingleConf = new SingleConf.X();

	public static Fax.X $Fax = new Fax.X();
	public static FaxConfig FaxConfig = (FaxConfig) beanFactory
			.getBean("FaxConfig");

	public static Skin.X $Skin = (Skin.X) beanFactory.getBean("SkinX");

	public static BatchGroup.X $BatchGroup = new BatchGroup.X();
	public static BatchGroupCondition.X $BatchGroupCondition = new BatchGroupCondition.X();

	public static SendMailStat.X $SendMailStat = new SendMailStat.X();
}
