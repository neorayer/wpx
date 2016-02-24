package com.skymiracle.wpx.models.stat;

import java.util.Date;
import java.util.List;

import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.log.MailLog;

import static com.skymiracle.wpx.Singletons.*;

public class SendMailStat extends WpxMdo<SendMailStat> {
	public SendMailStat() {
		super($SendMailStat);
	}

	protected String time;

	protected String mail;

	protected long count;

	public static enum StatType {
		fivemin, hour, day, month, all
	}

	protected StatType statType = StatType.hour;

	protected boolean isPerfect = true;

	@Override
	public String[] keyNames() {
		return new String[] { "time", "mail" };
	}

	@Override
	public String table() {
		return "tb_send_mail_stat";
	}

	public static class X extends WpxMdo_X<SendMailStat> {

		public X() {
			super(SendMailStat.class);
		}

		public void stat(StatType st) throws AppException, Exception {
			// 找出最后一次挖掘的时间
			Date lastDigDate = getLastDigTime(st);
			if (lastDigDate == null)
				return;
			// 当前时间
			Date nowDigDate = new Date();
			if (!lastDigDate.before(nowDigDate)) {
				return;
			}

			String lastDigTime = CalendarUtil.dateToString(lastDigDate,
					"yyyy-MM-dd HH:mm:ss");
			String nowDigTime = CalendarUtil.dateToString(nowDigDate,
					"yyyy-MM-dd HH:mm:ss");

			String groupTime = String.format("substring(sendTime, 1, %s)",
					dateFormatIndex(st));

			String sql = "select ";
			sql += groupTime + " as time, ";
			sql += " mailFrom as mail, ";
			sql += "count(1) as count,";
			sql += String.format(" '%s' as stattype", st);
			sql += ", 'true' as isperfect from db_log.tb_mail_log ";
//			sql += ", 'true' as isperfect from tb_mail_log ";
			sql += " where mailType='DELIVER' and ";
			sql += String.format(" sendTime>='%s' and sendTime<='%s' ",
					lastDigTime, nowDigTime);
			sql += " group by " + groupTime + "," + "mailFrom";

			MList<SendMailStat> list = (MList<SendMailStat>) findBySQL(sql);
			for (SendMailStat stat : list)
				stat.createOrUpdate();
		}

		public Date getLastDigTime(StatType statType) throws AppException,
				Exception {
			String t = "";
			// 找出最后一次挖掘的记录
			MList<SendMailStat> lss = find("statType,time-:1", statType);
			// 如果没有, 就从登录日志最原始的时间开始
			if (lss.size() == 0) {
				List<MailLog> mailLogs = $MailLog.find("mailType,sendTime+:1",
						MailLog.MAILTYPE_D);
				if (mailLogs.size() == 0) {
					return null;
				} else {
					t = mailLogs.get(0).getSendTime();
				}
			} else {
				t = lss.getFirst().time;
			}

			return CalendarUtil.stringToDate(t, dateFormat(statType));
		}

		public String dateFormat(StatType statType) {
			if (statType.equals(StatType.fivemin)) {
				return "yyyy-MM-dd HH:mm";
			} else if (statType.equals(StatType.hour)) {
				return "yyyy-MM-dd HH";
			} else if (statType.equals(StatType.day)) {
				return "yyyy-MM-dd";
			} else if (statType.equals(StatType.month)) {
				return "yyyy-MM";
			} else
				return "yyyy-MM-dd HH:mm:ss";
		}

		public int dateFormatIndex(StatType statType) {
			if (statType.equals(StatType.fivemin)) {
				return 16;
			} else if (statType.equals(StatType.hour)) {
				return 13;
			} else if (statType.equals(StatType.day)) {
				return 10;
			} else if (statType.equals(StatType.month)) {
				return 7;
			} else
				return 19;
		}

	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public StatType getStatType() {
		return statType;
	}

	public void setStatType(StatType statType) {
		this.statType = statType;
	}

	public boolean getIsPerfect() {
		return isPerfect;
	}

	public void setIsPerfect(boolean isPerfect) {
		this.isPerfect = isPerfect;
	}
}
