package com.skymiracle.wpx.models.mail;

import java.util.List;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.UUID;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.user.User;

import static com.skymiracle.wpx.Singletons.*;

// 群发组
public class BatchGroup extends WpxMdo<BatchGroup> {
	public BatchGroup() {
		super($BatchGroup);
	}

	public BatchGroup(String uuid) {
		this();
		this.uuid = uuid;
	}

	@Title("编号")
	private String uuid = new UUID().toShortString();

	@Title("名称")
	private String name;

	@Title("条件")
	private StringBuffer cdn;

	@Title("创建人")
	private String creator;

	@Title("创建时间")
	@Auto(Auto.Type.CreateDateTime)
	private String createDateTime;

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	@Override
	public String table() {
		return "tb_batch_group";
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class X extends WpxMdo_X<BatchGroup> {

		public X() {
			super(BatchGroup.class);
		}

	}

	public StringBuffer getCdn() {
		return cdn;
	}

	public void setCdn(StringBuffer cdn) {
		this.cdn = cdn;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public List<BatchGroupCondition> getCdns() throws AppException, Exception {
		return $BatchGroupCondition.find("groupuuid", uuid);
	}

	public void delete() throws AppException, Exception {
		MdoMap mm = new MdoMap();
		mm.put("groupuuid", uuid);
		$BatchGroupCondition.delete(mm);

		super.delete();
	}

	public List<User> getGroupUsers() throws AppException, Exception {
		return $User.find(new MdoMap(), this.cdn.toString());
	}
}
