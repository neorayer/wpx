package com.skymiracle.wpx.models.mail;

import static com.skymiracle.wpx.Singletons.$BatchGroupCondition;

import com.skymiracle.util.UUID;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

// 群发分组条件
public class BatchGroupCondition extends WpxMdo<BatchGroupCondition> {

	public BatchGroupCondition() {
		super($BatchGroupCondition);
	}

	@Title("编号")
	private String uuid = new UUID().toShortString();

	@Title("名称")
	private String name;

	@Title("SQL")
	private String filter;

	@Title("分组编号")
	private String groupuuid;

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	@Override
	public String table() {
		return "tb_batch_group_condition";
	}

	public static class X extends WpxMdo_X<BatchGroupCondition> {

		public X() {
			super(BatchGroupCondition.class);
		}
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

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getGroupuuid() {
		return groupuuid;
	}

	public void setGroupuuid(String groupuuid) {
		this.groupuuid = groupuuid;
	}

}
