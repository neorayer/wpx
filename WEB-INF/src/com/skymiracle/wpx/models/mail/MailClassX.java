package com.skymiracle.wpx.models.mail;

import java.util.LinkedList;
import java.util.List;

import com.skymiracle.fileBox.MailClass;
import com.skymiracle.fileBox.MailClassCodec;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IMailAccessor;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.user.User;

public class MailClassX {

	private StorageAccessorFactory saFactory;

	public MailClassX(StorageAccessorFactory saFactory) {
		this.saFactory = saFactory;
	}

	private IMailAccessor UMA(User user) throws Exception {
		return saFactory.getUserStorageMailAccessor(user.getUid(),
				user.getDc(), user.getStorageLocation());
	}

	public List<MailClass> findAll(User user) throws AppException, Exception {
		return new MailClassCodec("UTF-8").decode(UMA(user)
				.mailGetMailClasses());
	}

	public void add(User user, MailClass mc) throws AppException, Exception {
		UMA(user).mailAddClass(new MailClassCodec("UTF-8").encode(mc));
	}

	public void del(User user, String mailClassName) throws AppException,
			Exception {
		MailClass mc = new MailClass();
		mc.setMailClassName(mailClassName);
		mailClassName = new MailClassCodec("UTF-8").encode(mc).getMailClassName();
		UMA(user).mailRmMailClass(mailClassName);

	}

}
