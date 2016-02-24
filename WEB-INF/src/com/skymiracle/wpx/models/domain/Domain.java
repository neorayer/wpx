package com.skymiracle.wpx.models.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.skymiracle.csv.Csv;
import com.skymiracle.io.StreamPipe;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.license.Licenser;
import com.skymiracle.wpx.models.user.User;

import static com.skymiracle.wpx.Singletons.*;

public class Domain extends WpxMdo<Domain> {

	@Title("域名")
	public String dc;

	public String applyType;

	public String template;

	@Title("域别名???")
	public String alias;

	@Title("默认邮箱大小(b)")
	public long defaultboxsize;

	@Title("总容量(b)")
	public long size;

	@Title("已使用(b)")
	public long sizeLocate;

	@Title("上传附件大小(b)")
	public long attachmentSize;

	@Title("最大用户数")
	public long userMax;

	@Title("用户数")
	public long userLocate;

	@Title("说明")
	public String description;

	public int strangerfilter;

	@Title("是否显示公共通讯录")
	public String isHidePubAddress;

	public static int STRANGER_FILTER_OPEN = 0;

	public static int STRANGER_FILTER_CLOSED = 1;

	@Title("是否自动保存已发送 1:自动 0:不自动")
	private String savenew = "1";

	@Title("城市")
	@Desc("主要用于天气")
	private String cityName;
	
	public Domain() {
		super($Domain);
	}

	public Domain(String dc) {
		this();
		this.dc = dc;
	}

	public String getSavenew() {
		return savenew;
	}

	public void setSavenew(String savenew) {
		this.savenew = savenew;
	}

	public String getIsHidePubAddress() {
		return isHidePubAddress;
	}

	public void setIsHidePubAddress(String isHidePubAddress) {
		this.isHidePubAddress = isHidePubAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAttachmentSize() {
		return attachmentSize;
	}

	public void setAttachmentSize(long attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "dc" };
	}

	@Override
	public String table() {
		return "tb_domain";
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public long getDefaultboxsize() {
		return defaultboxsize;
	}

	public void setDefaultboxsize(long defaultboxsize) {
		this.defaultboxsize = defaultboxsize;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSizeLocate() {
		return sizeLocate;
	}

	public void setSizeLocate(long sizeLocate) {
		this.sizeLocate = sizeLocate;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public long getUserLocate() {
		return userLocate;
	}

	public void setUserLocate(long userLocate) {
		this.userLocate = userLocate;
	}

	public long getUserMax() {
		return userMax;
	}

	public void setUserMax(long userMax) {
		this.userMax = userMax;
	}

	public int getStrangerfilter() {
		return strangerfilter;
	}

	public void setStrangerfilter(int strangerfilter) {
		this.strangerfilter = strangerfilter;
	}

	@Override
	public Domain create() throws AppException, Exception {
		// 该域名不能已经是域别名
		new DomainAlias(dc).throwExists();

		long newusercount = $Domain.sumAll("userMax") + userMax;
		if (newusercount > $Domain.getLicenser().getUsersLicenseCount())
			throw new AppException("域名增加失败，原因：超出用户许可数量");

		return super.create();
	}

	@Override
	public void delete() throws AppException, Exception {
		StringBuffer sb = new StringBuffer();
		long userCount = userLocate;
		long deptCount = $Dept.count("domain", this.dc);
		long domainCount = $DomainAdmin.count("dc", dc);
		sb.append("域名(" + dc + ")删除失败!\r\n");

		if (userCount > 0)
			sb.append("域下还含有用户未删除\r\n");

		if (deptCount > 0)
			sb.append("域下还含有部门未删除\r\n");

		if (domainCount > 0)
			sb.append("域下还含有域管理员未删除\r\n");

		if (userCount > 0 || deptCount > 0 || domainCount > 0)
			throw new AppException(sb.toString());

		// 删除所有的别名
		$DomainAlias.find("aliasedObjectName", dc).delete();
		super.delete();
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public Domain update(MdoMap mdoMap) throws AppException, Exception {
		load();

		if (null != mdoMap.get("usermax")) {
			long newUseMax = (Long) mdoMap.get("usermax");
			long newusercount = $Domain.sumAll("userMax") - userMax + newUseMax;
			if (newusercount > $Domain.getLicenser().getUsersLicenseCount())
				throw new AppException("域名修改失败，原因：超出用户许可数量");
		}

		return super.update(mdoMap);
	}

	public MList<User> getUsers() throws AppException, Exception {
		return $User.find("dc", dc, 23);
	}

	/***************************************************************************
	 * 
	 * @author skymiracle
	 * 
	 */
	public static class X extends WpxMdo_X<Domain> {

		private Licenser licenser;

		// 邮局总容量(M)
		private long size;

		// 默认邮箱大小(M)
		private long defaultboxsize;

		// 最大用户数(M)
		private long userMax;

		// 上传附件大小(M)
		private long attachmentSize;

		public X() {
			super(Domain.class);
		}

		public Licenser getLicenser() {
			return licenser;
		}

		public void setLicenser(Licenser licenser) {
			this.licenser = licenser;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public long getDefaultboxsize() {
			return defaultboxsize;
		}

		public void setDefaultboxsize(long defaultboxsize) {
			this.defaultboxsize = defaultboxsize;
		}

		public long getUserMax() {
			return userMax;
		}

		public void setUserMax(long userMax) {
			this.userMax = userMax;
		}

		public long getAttachmentSize() {
			return attachmentSize;
		}

		public void setAttachmentSize(long attachmentSize) {
			this.attachmentSize = attachmentSize;
		}

		public long getAllUserLicenseLeft() throws AppException, Exception {
			return licenser.getUsersLicenseCount() - sumAll("userMax");
		}

		public void modSysLogoImg(File file, String realPath, String dc)
				throws IOException {
			String logoPath = realPath + "_logo/";
			File logo = new File(logoPath + dc + "_logo.gif");
			StreamPipe.fileToFile(file, logo);
		}

		public String getLogoPath(String realPath, String dc) {
			String logoPath = "_logo/";
			File logo = new File(realPath + logoPath + dc + "_logo.gif");
			if (!logo.exists())
				dc = "";
			return logoPath + dc + "_logo.gif";
		}

		// 导出数据
		public File exportCSV(File file, String charset) throws AppException,
				Exception {
			String[] labels = new String[] { "域名", "默认邮箱大小", "总容量", "上传附件大小",
					"最大用户数", "说明" };

			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for (Domain domain : this.findAll()) {
				String[] values = new String[] { domain.dc,
						domain.defaultboxsize + "", domain.size + "",
						domain.attachmentSize + "", domain.userMax + "",
						domain.description };
				csv.insert(values);
			}
			return file;
		}

		// 导入数据解析
		public void importDomains(File csvFile) throws AppException, Exception {

			Csv csv = new Csv(csvFile.getAbsolutePath(), "UTF-8");
			ArrayList<String[]> lines = csv.getLineList();

			for (String[] values : lines) {
				Domain domain = new Domain();
				if (values.length != 6)
					continue;
				int i = 1;
				try {
					// 域名
					domain.setDc(values[0]);
					// 默认邮箱大小
					domain.setDefaultboxsize(Long.parseLong(values[1]));
					// 总容量
					domain.setSize(Long.parseLong(values[2]));
					// 上传附件大小
					domain.setAttachmentSize(Long.parseLong(values[3]));
					// 最大用户数
					domain.setUserMax(Integer.parseInt(values[4]));
					// 说明
					domain.setDescription(values[5]);

					// 插入操作
					if (!domain.exists())
						domain.create();

				} catch (Exception e) {
					Logger.error("import Domain error : " + values[0] + "  "
							+ e.getMessage());
					continue;
				}
				i++;

				if (i % 500 == 0)
					Thread.sleep(3000);
			}

		}

		// 统计域数据
		public void resetAll() throws AppException, Exception {
			for (Domain domain : this.findAll()) {
				// 修改用户数,修改空间使用量
				domain.reset();
			}
		}

	}

	// 修改用户数,修改空间使用量
	public void reset() throws AppException, Exception {
		MdoMap mdoMap = new MdoMap();
		mdoMap.put("dc", dc);
		update("userLocate, sizeLocate", $User.count("dc", dc), $User.sum(
				"size", mdoMap, null));
	}

}