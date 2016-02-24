package com.skymiracle.wpx.models.user;

import static com.skymiracle.wpx.Singletons.*;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxMdo;

/**
 * GrpUser 组用户，是一种特殊的用户。虽然他不出现在User数据表中，但的确是可以通过uid@dc组成一个完整的邮件地址。
 * GrpUser下包含成员，存储在 GrpUserMember数据表中。所有发往uid@dc的邮件，都可以分发到所有的成员信箱中。
 *
 */
public class GrpUser extends WpxMdo<GrpUser> {

	public GrpUser() {
		super($GrpUser);
	}

	public GrpUser( String dc, String uid) {
		this();
		this.dc = dc;
		this.uid = uid;
	}

	private String uid; // Account uid

	private String dc; // Account dc

	private String name;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String[] keyNames() {
		return new String[]{"dc", "uid"};
	}
	
	@Override
	public String table() {
		return "tb_grpuser";
	}
	
	public GrpUser create() throws AppException, Exception {
		new User(dc, uid).throwExists();
		new UserAlias(dc, uid).throwExists();

		return super.create();
	}

	@Override
	public void delete() throws AppException, Exception {
		super.delete();

		// 删除群组用户的成员
		clearMembers();
	}
	
	public void clearMembers() throws AppException, Exception{
		$GrpUserMember.delete(this);
	}
	
	public static class X extends WpxMdo_X<GrpUser> {

		public X() {
			super(GrpUser.class);
		}

	}

	public MList<User> getMembers()  throws AppException, Exception{
		MList<GrpUserMember> gums = $GrpUserMember.find("dc, grpUid", dc, uid);
		MList<User> users = new MList<User>();
		for(GrpUserMember gum : gums) {
			users.add(gum.getUser());
		}
		return users;
	}


}
