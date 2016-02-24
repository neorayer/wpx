package com.skymiracle.wpx.models.user;

import java.io.File;
import java.util.ArrayList;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.addrbook.AddrGrp;

import static com.skymiracle.wpx.Singletons.*;

public class GrpUserMember extends WpxMdo<GrpUserMember> {

	@Title("组用户名")
	public String grpUid;

	@Title("域名")
	public String dc;

	@Title("成员用户名")
	public String memberUid;

	public GrpUserMember() {
		super($GrpUserMember);
	}
	public GrpUserMember(String dc, String grpUid, String memberUid) {
		this();
		this.dc = dc;
		this.grpUid =grpUid;
		this.memberUid = memberUid;
	}

	public String getGrpUid() {
		return grpUid;
	}

	public void setGrpUid(String grpUid) {
		this.grpUid = grpUid;
	}

	public String getMemberUid() {
		return memberUid;
	}

	public void setMemberUid(String memberUid) {
		this.memberUid = memberUid;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public User getUser() throws AppException, Exception {
		return new User(dc, memberUid).load();
	}

	@Override
	public GrpUserMember create() throws AppException, Exception {
		if (!new User(dc, memberUid).exists())
			throw new AppException(memberUid + "不是系统内帐号，无法添加为群组成员");

		if (this.exists())
			throw new AppException(memberUid + "已经是群组成员，不能重复添加");

		return super.create();
	}
	
	@Override
	public String[] keyNames() {
		return new String[] {"dc", "grpuid", "memberuid" };
	}

	@Override
	public String table() {
		return "tb_grpuser_member";
	}

	public static class X extends WpxMdo_X<GrpUserMember> {

		public X() {
			super(GrpUserMember.class);
		}

		public void delete(GrpUser grpUser) throws AppException, Exception {
			find("dc,grpUid", grpUser.getDc(), grpUser.getUid()).delete();
		}
	}

	

}
