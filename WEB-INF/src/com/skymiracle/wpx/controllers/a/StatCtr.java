package com.skymiracle.wpx.controllers.a;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.stat.SendMailStat;

import static com.skymiracle.wpx.Singletons.*;

public class StatCtr extends Ctr {

	public void sendMailList() throws AppException, Exception {
		String mail = $("mail", "");
		String stattype = $("stattype", "month");
		String fromtime = $("fromtime", "");
		String totime = $("totime", "");
		String ct = $("ct", "");
		int cv = $i("cv", 0);

		StringBuffer filter = new StringBuffer("stattype='" + stattype + "'");
		if (!mail.equals("")) {
			filter.append(" and mail = '" + mail + "'");
		}

		if (!fromtime.equals("")) {
			fromtime = fromtime.replaceAll("/", "-");
			filter.append(" and time >= '" + fromtime + "'");
		}
		if (!totime.equals("")) {
			totime = totime.replaceAll("/", "-");
			filter.append(" and time <= '" + totime + "'");
		}
		if (!ct.equals("")) {
			filter.append(" and count " + ct + " " + cv);
		}

		MdoMap das = new MdoMap();
		fillPagedDNA($SendMailStat, das, filter.toString(),
				$("sortby", "time"), $b("sortup", false));
	}

	public void sendMailStat() throws AppException, Exception {
		String stattype = $("stattype", "");
		SendMailStat.StatType st = Enum.valueOf(SendMailStat.StatType.class,
				stattype);
		$SendMailStat.stat(st);
	}
}
