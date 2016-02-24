package com.skymiracle.wpx.models.admin;

import static com.skymiracle.wpx.Singletons.$BatchGroup;
import static com.skymiracle.wpx.Singletons.$Domain;
import static com.skymiracle.wpx.Singletons.$MultiDomainAdmin;
import static com.skymiracle.wpx.Singletons.$TimerMail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.BatchGroup;
import com.skymiracle.wpx.models.mail.TimerMail;
import com.skymiracle.wpx.util.ByteTools;

@Title("多域管理员")
public class MultiDomainAdmin extends Admin<MultiDomainAdmin> {

	@Title("可管理的用户数")
	private String size;

	@Title("可管理的域数量")
	private String roomNumber;

	@Title("可管理的容量(M)")
	private String sizeLocate;

	@Title("描述")
	private String[] description;

	public MultiDomainAdmin() {
		super($MultiDomainAdmin);
	}

	public MultiDomainAdmin(String uid) {
		this();
		this.uid = uid;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getSizeLocate() {
		return sizeLocate;
	}

	public void setSizeLocate(String sizeLocate) {
		this.sizeLocate = sizeLocate;
	}

	@Override
	public String table() {
		return "tb_multiDomainAdmin";
	}

	public static class X extends Admin.X<MultiDomainAdmin> {
		public X() {
			super(MultiDomainAdmin.class);
		}

	}

	@Override
	public String getDc() {
		// nothing todo
		return null;
	}

	@Override
	public String getRoleID() {
		return Admin.TYPE_MULTIDOMAIN;
	}

	public Domain addDomain(Domain domain) throws AppException, Exception {
		this.load();

		long _roomNumber = 0;
		try {
			_roomNumber = Long.parseLong(roomNumber);
		} catch (Exception e) {
		}

		long _size = 0;
		try {
			_size = Long.parseLong(size);
		} catch (Exception e) {
		}

		long _sizeLocate = 0;
		try {
			_sizeLocate = Long.parseLong(sizeLocate);
		} catch (Exception e) {
		}

		long useedusernum = 0;
		long useedcapacitynum = 0;

		List<String> _list = new ArrayList<String>();
		for (String dc : description) {
			if (dc == null || dc.equals(""))
				continue;
			
			Domain _domain = new Domain(dc);
			_domain.load();
			
			useedusernum += domain.getUserMax();
			useedcapacitynum += ByteTools.byteToM(domain.getSize());
			_list.add(dc);
		}

		if (_roomNumber <= description.length - 1)
			throw new AppException("邮局新增失败! 您可管理的域数量为 ：" + roomNumber);

		if ((useedusernum + domain.getUserMax()) > _size)
			throw new AppException("邮局新增失败! 您可管理的用户数为 ：" + _size);

		if ((useedcapacitynum + ByteTools.byteToM(domain.getSize())) > _sizeLocate)
			throw new AppException("邮局新增失败! 您可管理的容量为 ：" + _sizeLocate);

		
		_list.add(domain.getDc());
		MdoMap mm = new MdoMap();
		mm.put("description", _list.toArray(new String[0]));
		
		domain.create(); 
		this.update(mm);

		// LOG
		SysLog.width(this).addMultiDomain(domain.getDc());

		return domain;
	}
	
	public void delDomain(Domain domain) throws AppException, Exception {
		domain.load();

		List<String> list = new ArrayList<String>();
		for (String desc : description) {
			if(desc == null || desc.equals("") || desc.equals(domain.getDc()))
				continue;
			
			list.add(desc);
		}

		String[] newdomainDescs = list.toArray(new String[0]);
		MdoMap das = new MdoMap();
		das.put("description", newdomainDescs);

		domain.delete();
		update(das);

		// LOG
		SysLog.width(this).deleteDomain(domain.getDc());
	}

	public List<Domain> listDomains(String sortby, boolean isasc, int pagenum,
			int perpagecount) throws AppException, Exception {
		PagedList<Domain> list = new PagedList<Domain>(pagenum, perpagecount,
				description.length, "");
		for (String desc : description) {
			if (desc == null || desc.equals(""))
				continue;
			list.add(new Domain(desc).load());
		}
		return list;
	}
	
	public List<Domain> listDomains() throws AppException, Exception {
		List<Domain> list = new MList<Domain>();
		for (String desc : description) {
			if (desc == null || desc.equals(""))
				continue;
			list.add(new Domain(desc).load());
		}
		return list;
	}

	@Override
	public String getUniqueId() throws AppException, Exception {
		return getRoleID() + Admin.SEP_UNIQUE_ID + uid;
	}
	
//	public List<TimerMail> listTimerMail(MdoMap mm) throws AppException, Exception {
//		List<TimerMail> list = new ArrayList<TimerMail>();
//		// self create
//		mm.put("", v)
//		list.addAll($TimerMail.find(mm, "time", false));
//		
//		
//		
//		return list;
//	}

}
