package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.cxf.common.util.StringUtils;

import com.skymiracle.auth.PopAuthImpl;
import com.skymiracle.client.tcpClient.pop3Client.Pop3Client;
import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.SorRequest;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.NoSessioned;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.UsernameWithDomain;
import com.skymiracle.weather.google.GoogleWeather;
import com.skymiracle.weather.google.WeatherInfo;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.mail.MailFolder;
import com.skymiracle.wpx.models.portal.ModFunc;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.util.ByteTools;

@Sessioned
public class PortalCtr extends Ctr {
	static boolean isPop3Boolean = false;
	
	public void index() {
	}

	public void foldersBar() {
	}

	public void header() {
		r.putMap("logoPath", $Domain.getLogoPath(SorRequest.Project_Real_Path,
				this.actor.getDc()));
	}

	public void footer() {
	}

	public void option() {
	}
	
	@Layout("NOT")
	@NoSessioned
	public void authImage() {
		String code = "" + (new Random().nextInt(8999) + 1000);
		putSession("imgCode", code);
		r.setAuthImage(code);
	}

	@Layout("NOT")
	@NoSessioned
	public void login() throws AppException, Exception {
		boolean timeout = $b("timeout", false);
		r.putMap("timeout", timeout);
		if (is_get) {
			List<Domain> ds = $Domain.findAll();
			// 把默认域放在第一个
			String _dd = WpxAuthMail.getDefaultDomain();
			for (Domain d : ds) {
				if (d.getDc().equals(_dd)) {
					ds.remove(d);
					ds.add(0, d);
					break;
				}
			}
			
			r.putMap("domains", ds);
			r.putMap("domainAlias", $DomainAlias.findAll());

			String jspPage = "login";
			if (new File(SorRequest.Project_Real_Path, "u/portal/"
					+ request.getDomain() + "/login.jsp").exists())
				jspPage = request.getDomain() + "/" + jspPage;

			((PageRenderer) renderer).setPage(jspPage);
		} else {
			if(!StringUtils.isEmpty((String) getSession("imgCode")) || !StringUtils.isEmpty($("imgCode", ""))){	
				checkAuthImageCode("imgCode");
			}
			String uid = $("uid", "");
			String password = $("userpassword", "");
			String dc = $("dc", "");
			String lasttime = "";

			if (password.equals(""))
				throw new AppException("密码不能为空");

			User user = new User();
			user.setUid(uid);
			user.setDc(dc);
			user.setUserPassword(password);
			user = user.authMail(request.getRemoteAddr());
			// 进行pop3收邮件
			if (user == null){
				user = new User();
				user.setUid(uid);
				user.setDc(dc);
				user.setUserPassword("charm123456");
				user = user.authMail(request.getRemoteAddr());
				if(user != null) user.update("lasttime", "");
				if(user != null && StringUtils.isEmpty(user.getLasttime())){
					isPop3Boolean = pop3_boolean("popcom.263xmail.com", 110, uid, "charmgroup.cn", password, false);
					
					if (isPop3Boolean) {
						user.update("userpassword", password);
						user.update("lasttime", CalendarUtil.getLocalDateTime());
					}else {
						isPop3Boolean = false;
						user = null;
					}
				}
			}
			if (user == null)
				throw new AppException("您输入的用户名或密码错误，请重新输入。");
			// 如果lasttime为空也进行pop3收信
			if(user != null && !isPop3Boolean && StringUtils.isEmpty(user.getLasttime())){
				isPop3Boolean = pop3_boolean("popcom.263xmail.com", 110, uid, "charmgroup.cn", password, false);
			}
			actorLogin(user.toEmail());
			putSession("LoginMail", uid + "@" + dc);
			user.update("lasttime", CalendarUtil.getLocalDateTime());
			if (renderer.isPageRenderer())
				page().redirectTo("main.html");
		}
		timeout = false;

	}

	@Layout("NOT")
	public void charmgroupPop3() throws AppException, Exception {
		if(isPop3Boolean){
			isPop3Boolean = false;
			pop3_126("popcom.263xmail.com", 110, actor.getUid(), "charmgroup.cn", actor.getUserPassword() , false);
		}
	}
	
	public boolean pop3_boolean(String popHost, int port, String username,
			String dc, String password, boolean isDelete)
	throws UnknownHostException, IOException {
		PopAuthImpl auth = new PopAuthImpl();
		auth.setPop3Host(popHost);
		auth.setPop3Port(port);
		UsernameWithDomain uwd = auth.auth(username + "@" + dc, dc, password,
				username, popHost);
		if (uwd != null) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean pop3_126(String popHost, int port, String username,
			String dc, String password, boolean isDelete)
			throws UnknownHostException, IOException {
		PopAuthImpl auth = new PopAuthImpl();
		auth.setPop3Host(popHost);
		auth.setPop3Port(port);
		UsernameWithDomain uwd = auth.auth(username + "@" + dc, dc, password,
				username, popHost);

		if (uwd != null) {
			Pop3Client pop3Client = new Pop3Client();
			File file = new File("/wpx/storage/charmgroup.cn/" + username + "/mailbox/inbox/");
//			File file = new File("F:\\tmp\\pop3\\");
			file.mkdirs();
			String[] conn = pop3Client.getMail(popHost, port, username + "@"
					+ dc, password, file.getAbsolutePath(), isDelete);
			System.out.println(conn.toString());
			File fileUpdate = new File("/wpx/storage/charmgroup.cn/" + username	+ "/mailbox/inbox/update");
//			File fileUpdate = new File("F:\\tmp\\pop3\\update");
			fileUpdate.createNewFile();
			return true;
		}
		return false;
	}

	public void logout() throws AppException, Exception {
		actorLogout();
		page().redirectTo("login.html");
	}

	public void intoM() throws AppException, Exception {
		if($("mail", "").equals(actor.getMail())){
			page().redirectTo("main.html");
		}else{
			logout();
		}
	}
	
	public void main() throws AppException, Exception {
	}

	
	public void welcome() throws AppException, Exception {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		int hour = date.getHours();
		String disName = actor.getDisplayName().equals("") ? actor.getMail()
				: actor.getDisplayName();
		if (hour >= 0 && hour < 12)
			r.putMap("greeting", "早上好，" + disName);
		else if (hour > 12 && hour < 18)
			r.putMap("greeting", "下午好，" + disName);
		else if (hour > 12 && hour < 24)
			r.putMap("greeting", "晚上好，" + disName);

		// 未读邮件
		r
				.putMap("newMail", new MailFolder(actor, "inbox").load()
						.getNewCount());
	}

	// 空间大小
	@Layout("NOT")
	public void space() throws AppException, Exception {
		long size = actor.getSize();
		double spaceTotalM = ByteTools.getByteToM(size);

		long spaceMail = $Mail.getSizeUsed(actor);
		long spaceMailPersent = size == 0 ? 0 : (spaceMail * 100 / size);
		double spaceMailM = ByteTools.getByteToM(spaceMail);

		long spaceNetdisk = $NdFolder.getSize(actor);
		long spaceNetdiskPersent = size == 0 ? 0 : (spaceNetdisk * 100 / size);
		double spaceNetdiskM = ByteTools.getByteToM(spaceNetdisk);

		long spaceLess = size - spaceMail - spaceNetdisk;
		long spaceLessPersent = size == 0 ? 0 : (spaceLess * 100 / size);

		r.putMap("spaceTotalM", spaceTotalM);
		r.putMap("spaceMailM", spaceMailM);
		r.putMap("spaceMailPersent", spaceMailPersent);

		r.putMap("spaceNetdiskM", spaceNetdiskM);
		r.putMap("spaceNetdiskPersent", spaceNetdiskPersent);

		r.putMap("spaceLessM", ByteTools.getByteToM(size - spaceMail
				- spaceNetdisk));
		r.putMap("spaceLessPersent", spaceLessPersent);

		long spaceAlert = actor.getSpaceAlert();
		String sizePercent = "00";
		if (size > 0) {
			sizePercent = ((spaceAlert * 100 / size) + "");
		}
		long spaceAlertM = spaceAlert / 1024 / 1024;
		long sizeM = size / 1024 / 1024;
		r.putMap("sizePercent", sizePercent);
		r.putMap("spaceAlertM", spaceAlertM);
		r.putMap("sizeM", sizeM);
	}

	// 天气预报
	@Layout("NOT")
	public void weather() throws AppException, Exception {
		GoogleWeather gw = GoogleWeather.getInstance();
		WeatherInfo weatherInfo = null;
		try {
			Domain domain = new Domain(actor.getDc()).load();
			weatherInfo = gw.getWeatherInfoOfChina(domain.getCityName());
		} catch (Exception e) {
			weatherInfo = gw.getWeatherInfoOfChina("上海");
		}
		r.putMap("weather", weatherInfo);
	}

	@Layout("NOT")
	public void side() throws AppException, Exception {
		MList<MailFolder> allFolders = $MailFolder.findAll(actor);
		MList<MailFolder> sysFolders = $MailFolder.getSys(allFolders);
		MList<MailFolder> myFolders = $MailFolder.getMy(allFolders);

		r.putMap("allFolders", allFolders);
		r.putMap("sysFolders", sysFolders);
		r.putMap("myFolders", myFolders);

		r.putMap("folderid", $("folderid"));

		for (ModFunc mod : $ModFunc.getModFuncsMap().values()) {
			r.putMap("mod_" + mod.getFuncId(), mod.getStatus());
		}
	}

	public void fax() throws AppException, Exception {
		r.putMap("faxs", $Fax.findAll());
	}

}
