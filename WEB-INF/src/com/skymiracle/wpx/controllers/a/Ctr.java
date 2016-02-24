package com.skymiracle.wpx.controllers.a;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.skymiracle.mdo5.Mdo;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.Mdo_X;
import com.skymiracle.mdo5.NotExistException;
import com.skymiracle.sor.controller.WebController;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.wpx.models.admin.AddressbookAdmin;
import com.skymiracle.wpx.models.admin.Admin;
import com.skymiracle.wpx.models.admin.DomainAdmin;
import com.skymiracle.wpx.models.admin.MultiDomainAdmin;
import com.skymiracle.wpx.models.admin.SuperAdmin;

public class Ctr extends WebController<Admin<? extends Admin<?>>> {

	protected static String Role_Key = "com.skymiracle.wpx.controllers.a.role";

	protected static String Dc_Key = "com.skymiracle.wpx.controllers.a.dc";

	@Override
	protected void afterActorLogout() throws AppException {
		page().redirectTo("a/login.html");
	}

	@Override
	public void dealWithNoSession() {
		page().redirectTo("a/login.html");
	}

	@Override
	public Admin<? extends Admin<?>> getActorFromId() throws Exception {
		String role = (String) getSession(Role_Key);
		if (role == null)
			return null;

		String dc = (String) getSession(Dc_Key);

		Admin<?> admin = null;
		if (Admin.TYPE_SUPER.equals(role)) {
			admin = new SuperAdmin(actorId);
		} else if (Admin.TYPE_DOMAIN.equals(role)) {
			admin = new DomainAdmin(actorId, dc);
		} else if (Admin.TYPE_MULTIDOMAIN.equals(role)) {
			admin = new MultiDomainAdmin(actorId);
		} else if (Admin.TYPE_ADDRESSBOOK.equals(role)) {
			admin = new AddressbookAdmin(actorId, dc);
		} else
			return null;

		try {
			admin.load();
			admin.ip = request.getRemoteAddr();
			return admin;
		} catch (NotExistException e) {
			return null;
		}
	}

	@Override
	protected String getTheme() throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	protected <T extends Mdo<T>> void fillPagedDNA(Mdo_X<T> mdoX,
			MdoMap mdoMap, String filter) throws AppException, Exception {
		if (mdoMap == null)
			mdoMap = new MdoMap();
		r.putColl(mdoX.findPaged(mdoMap, filter, $("sortby"), $b("sortup"), $i(
				"pagenum", 1), $i("perpagecount")));
	}

	protected <T extends Mdo<T>> void fillPagedDNA(Mdo_X<T> mdoX,
			MdoMap mdoMap, String filter, String sortby, boolean isASC)
			throws AppException, Exception {
		if (mdoMap == null)
			mdoMap = new MdoMap();
		r.putColl(mdoX.findPaged(mdoMap, filter, sortby, isASC,
				$i("pagenum", 1), $i("perpagecount")));
	}

}
