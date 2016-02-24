package com.skymiracle.wpx.models.user;

import static com.skymiracle.wpx.Singletons.$Dept;
import static com.skymiracle.wpx.Singletons.$User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.skymiracle.csv.Csv;
import com.skymiracle.json.JSONTools;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo4.DaoAttrSet;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.UUID;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import com.skymiracle.wpx.models.admin.AddressbookAdmin;
import com.skymiracle.wpx.models.domain.Domain;

// UPDATE: 去掉uuid, parentuuid 改变为 parentOu
public class Dept extends WpxMdo<Dept> {

	public static final String DEPT_POS_TOP = "top";

	public static final String DEPT_POS_TAIL = "tail";

	@Title("部门代号")
	private String ou;

	@Title("部门名称")
	private String description;

	@Title("父部门编号")
	private String parentOu = "";

	@Title("所属域")
	private String domain;

	@Title("")
	private String symbol;

	@Title("排名")
	private int sortNum = 10000;

	@Title("部门人数")
	private long count = 0;

	public Dept() {
		super($Dept);
	}
	
	public Dept(String ou) {
		this();
		this.ou = ou;
	}

	public Dept(String domain, String ou) {
		this();
		setDomain(domain);
		setOu(ou);
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "ou" };
	}
	
	@Override
	public String table() {
		return "tb_department";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getParentOu() {
		return parentOu;
	}

	public void setParentOu(String parentOu) {
		this.parentOu = parentOu;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}


	public void delete() throws AppException, Exception {
		if(hasChildren())
			throw new AppException("该部门下还有子部门");
		
		if ($User.count("ou", ou) > 0)
			throw new AppException("该部门下还有员工！");
		super.delete();
	}

	public void countPlus(int i) throws AppException, Exception {
		load();
		long c = this.count + i > 0 ? this.count + i : 0;
		this.update("count", c);

		if(parentOu == null || parentOu.equals(""))
			return;
		
		Dept parentDept = new Dept(parentOu);
		if(parentDept.exists())
			parentDept.countPlus(i);
	}

//	private MList<Dept> getParentDepts() throws AppException, Exception {
//		if (parentOu != null && !parentOu.equals("")) {
//			return $Dept.find("ou", this.parentOu);
//		}
//		return null;
//	}
	

	// 是否有子部门
	public boolean hasChildren() throws AppException, Exception {
		return $Dept.count("parentOu", ou) > 0;
	}

	public long calcUserCount() throws AppException, Exception {
		// 自身有的用户数
		long selfC = $User.countShowingOfDept(this);
		
		// 子类用户数
		long childrenC = 0;
		if(hasChildren()) {
			List<Dept> children = getDirectChildren();
			for(Dept child: children) 
				childrenC += child.calcUserCount();
		}
		// 所有用户数
		long allC = selfC + childrenC;
		update("count", allC);
		return allC;
	}
	
	public MList<User> getAllUsers() throws AppException, Exception {
		// 自身有的用户, 不含子目录
		MList<User> users = $User.find("ou", ou);

		if(hasChildren()) {
			List<Dept> children = getDirectChildren();
			for(Dept child: children) 
				users.addAll(child.getAllUsers());
		}
		
		return users;
	}

	// 直接子部门
	public List<Dept> getDirectChildren() throws AppException, Exception {
		return $Dept.find("parentOu", ou);
	}
	
	public static class X extends WpxMdo_X<Dept> {

		public X() {
			super(Dept.class);
		}

		public class DeptTree {
			public Dept dept = null;

			public List<DeptTree> branchs = new LinkedList<DeptTree>();
		}
		
//		public void modifyDept(String dc, String oldou, String targetou)
//				throws AppException, Exception {
//			Dept oldDept = new Dept(dc, oldou);
//			Dept targetDept = new Dept(dc, targetou);
//
//			oldDept.load();
//			targetDept.load();
//
//			MList<Dept> depts = find("domain, parentuuid", dc, oldDept.getOu());
//			for (Dept dept : depts) {
//				if (!(dept.getOu().equals(targetDept.getOu()))) {
//					dept.update("parentuuid", targetDept.getOu());
//				} else {
//					dept.update("parentuuid", "");
//				}
//			}
//
//			Logger.info("WILL DELETE DEPT " + oldDept.getDescription());
//			oldDept.delete();
//		}

//		public void modifyDept(Dept dept, MdoMap mm) throws AppException,
//				Exception {
//			dept.load();
//			String ou = (String) mm.get("ou");
//			String description = (String) mm.get("description");
//			String domain = (String) mm.get("domain");
//			Dept det = new Dept();
//			det.setOu(ou);
//			det.setDescription(description);
//			det.setDomain(domain);
//			// this.modDao(dept, mm);
//		}

		// 找出所有符合条件的部门
		public List<Dept> getSafeDepts(MdoMap mdoMap) throws AppException,
				Exception {

			MList<Dept> depts = find(mdoMap, "sortNum", true);

			MList<Dept> safedpList = new MList<Dept>();
			for (Dept dp : depts) {
				if (dp.ou.equals(dp.parentOu))
					continue;
				safedpList.add(dp);
			}
			return safedpList;
		}

		public DeptTree getDeptsTree(MdoMap mdoMap) throws AppException,
				Exception {
			List<Dept> depts = getSafeDepts(mdoMap);

			DeptTree tree = new DeptTree();
			tree.dept = new Dept();
			// tree.dept.setUuid("");
			tree.dept.setParentOu("-1");
			buildDeptTree(tree, depts);
			return tree;
		}

		private void buildDeptTree(DeptTree tree, List<Dept> depts) {
			List<Dept> subDps = getAllChildren(depts, tree.dept.getOu());
			for (Dept dp : subDps) {
				DeptTree subTree = new DeptTree();
				subTree.dept = dp;
				buildDeptTree(subTree, depts);
			}
		}

		private List<Dept> getAllChildren(List<Dept> depts, String parentOu) {
			List<Dept> resList = new LinkedList<Dept>();
			for (Dept dp : depts) {
				if ((parentOu == null && dp.parentOu == null)
						|| parentOu.equals(dp.parentOu)) {
					resList.add(dp);
				}
			}
			return resList;
		}

		public Map<String, List<Dept>> getDeptTreeMap(List<Dept> depts) {
			Map<String, List<Dept>> map = new HashMap<String, List<Dept>>();
			for (Dept dp : depts) {
				List<Dept> parentList = map.get(dp.parentOu);
				if (parentList == null) {
					parentList = new LinkedList<Dept>();
					map.put(dp.parentOu, parentList);
				}
				parentList.add(dp);
			}
			return map;
		}

		// JSON格式的部门树
		public JSONObject getDeptTreeMapJSON(MdoMap mdoMap) {
			JSONObject jo = new JSONObject();
			try {
				Map<String, List<Dept>> map = getDeptTreeMap(getSafeDepts(mdoMap));
				for (Map.Entry<String, List<Dept>> entry : map.entrySet()) {
					String key = entry.getKey();
					if (key.length() == 0)
						key = "ROOT";
					jo.put(key, JSONTools.getJSONArray(entry.getValue()));
				}
			} catch (Exception e) {
				Logger.error("", e);
			}
			return jo;

		}

//		public void subNodeCheck(Dept dept) throws Exception {
//
//			MdoMap modMap = new MdoMap();
//			List<Dept> deptList = this.getSafeDepts(modMap);
//			for (Dept d : deptList) {
//				if (d.parentOu.equals(dept.getOu())) {
//					throw new AppException("MSGID_SUBNODE_ERR");
//				}
//			}
//
//			if ($User.count("dc, ou", dept.getDomain(), dept.getOu()) > 0) {
//				throw new AppException("部门下还有用户，请先删除部门下的用户");
//			}
//		}

//		public Dept gtDeptByOuWithDc(String domain, String ou)
//				throws AppException, Exception {
//			MdoMap modMap = new MdoMap();
//			modMap.put("domain", domain);
//			modMap.put("ou", ou);
//			List<Dept> list = this.getSafeDepts(modMap);
//			if (list.size() == 1)
//				return (Dept) list.get(0);
//			else
//				return null;
//		}

		public Dept getDeptByOu(String ou, String dc) throws AppException,
				Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("ou", ou);
			modMap.put("domain", dc);
			List<Dept> list = this.getSafeDepts(modMap);
			if (list.size() == 1)
				return (Dept) list.get(0);
			else
				return null;
		}

		public Dept getDeptByOu(String ou) throws AppException, Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("ou", ou);
			List<Dept> list = this.getSafeDepts(modMap);
			if (list.size() == 1)
				return (Dept) list.get(0);
			else
				return null;
		}

		public Dept getDeptByou(String ou) throws AppException, Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("ou", ou);
			List<Dept> list = this.getSafeDepts(modMap);
			if (list.size() == 1)
				return (Dept) list.get(0);
			else
				return null;
		}

//		public Dept getDeptBydescription(String description)
//				throws AppException, Exception {
//			MdoMap modMap = new MdoMap();
//			modMap.put("description", description);
//			List<Dept> list = this.getSafeDepts(modMap);
//			if (list.size() == 1)
//				return (Dept) list.get(0);
//			else
//				return null;
//		}

//		public List<Dept> getDeptByDc(String dc) throws AppException, Exception {
//			return this.find("domain", dc);
//		}

		public Dept getDept(String domain, String description)
				throws AppException, Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("description", description);
			modMap.put("domain", domain);
			List<Dept> list = this.getSafeDepts(modMap);
			if (list.size() == 1)
				return (Dept) list.get(0);
			else
				return null;
		}

//		@SuppressWarnings("unused")
//		private void modDept(String lable, String value, Dept dept)
//				throws AppException, Exception {
//			MdoMap modMap = new MdoMap();
//			modMap.put(lable, value);
//			this.update(dept, modMap);
//		}

//		private boolean checkDeptisChain(Dept parentdept, String domain,
//				boolean isRoot) {
//			List<Dept> list1 = new ArrayList<Dept>();
//			List<Dept> list2 = new ArrayList<Dept>();
//			DaoAttrSet das = new DaoAttrSet();
//			das.put("domain", domain);
//			if (!isRoot)
//				das.put("parentuuid", parentdept.getOu());
//			else
//				das.put("parentuuid", "");
//			if (list1.size() < 1 || list2.size() < 1)
//				return false;
//			else
//				return true;
//		}

//		@SuppressWarnings("unused")
//		private boolean checkDeptisChain(String uuid, String domain,
//				boolean isRoot) throws AppException, Exception {
//			Dept dept = getDeptByOu(uuid);
//			return checkDeptisChain(dept, domain, isRoot);
//		}

		// 某域下的部门
		public List<Dept> getDepts(String domain) throws AppException,
				Exception {
			MdoMap modMap = new MdoMap();
			if (domain != null && !domain.equals(""))
				modMap.put("domain", domain);

			return this.find(modMap, "sortNum", true);
		}

		// public List<Dept> getDeptlist(Dept dept,String domain,boolean isRoot)
		// throws WpxServiceException

		public List<Dept> getDeptlist(Dept dept, String domain, boolean isRoot)
				throws AppException, Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("domain", domain);
			if (!isRoot) {
				modMap.put("parentOu", dept.getOu());
			} else
				modMap.put("parentOu", "");
			return this.find(modMap, "sortNum", true);
		}

//		public List<Dept> getDeptlist(String domain, String parentOu)
//				throws AppException, Exception {
//			List<Dept> list = new ArrayList<Dept>();
//			if (parentOu.equals(""))
//				list = getDeptlist(null, domain, true);
//			else {
//				Dept dept = getDeptByOu(parentOu, domain);
//				list = getDeptlist(dept, domain, false);
//			}
//			return list;
//		}

		private List<Dept> getParentsDept(Dept dept) throws AppException,
				Exception {
			return this.find("parentOu", dept.getOu());
		}

		private List<Dept> getParentsDepts(Dept dept) throws AppException,
				Exception {
			List<Dept> parentsdepts = new ArrayList<Dept>();
			List<Dept> depts = this.getParentsDept(dept);
			for (int i = 0; i < depts.size(); i++) {
				parentsdepts.addAll(this.getParentsDepts(depts.get(i)));
			}
			parentsdepts.addAll(depts);
			return parentsdepts;
		}

		private List<Dept> getAllParentsDept(Dept dept) throws AppException,
				Exception {
			List<Dept> alldepts = new ArrayList<Dept>();
			alldepts.add(dept);
			List<Dept> parentdepts = this.getParentsDepts(dept);
			alldepts.addAll(parentdepts);
			return alldepts;
		}

		public List<Dept> getSearchDept(String dc, String description)
				throws AppException, Exception {
			MdoMap modMap = new MdoMap();
			modMap.put("domain", dc);
			String filter = "(description like '%" + description + "%')";

			return this.find(modMap, filter);

		}

		public List<Dept> getAddrAdmin(String uid, String dc) {
			AddressbookAdmin addradmin = new AddressbookAdmin(uid, dc);
			try {
				addradmin.load();
				Dept dept = new Dept(dc, addradmin.getOu());
				dept.load();
				List<Dept> list = this.getAllParentsDept(dept);
				return list;
			} catch (Exception e) {
				return null;
			}
		}

		// 导出部门
		public File exportCSV(File file, String charset) throws AppException,
				Exception {
			String[] labels = new String[] { "部门", "域名" };

			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for (Dept dept : this.findAll()) {
				String[] values = new String[] { dept.domain, dept.description };
				csv.insert(values);
			}
			return file;
		}

		// 导入部门
		public void importDepts(File csvFile) throws AppException, Exception {
			Csv csv = new Csv(csvFile.getAbsolutePath(), "UTF-8");
			ArrayList<String[]> lines = csv.getLineList();

			for (String[] values : lines) {
				if (values.length != 2)
					continue;
				int i = 0;
				try {
					Dept dept = new Dept(values[0], new UUID().toShortString());
					// 域名
					dept.setDescription(values[1]);

					// 插入操作
					if (!dept.exists())
						dept.create();

				} catch (Exception e) {
					Logger.error("import Dept error : " + values[0] + ","
							+ values[1] + "   " + e.getMessage());
					continue;
				}
				i++;

				if (i % 500 == 0)
					Thread.sleep(3000);
			}
		}
		
		// 顶级部门列表
		public List<Dept> getTopDepts() throws AppException, Exception {
			// TODO parentOu是""吗？？？
			return $Dept.find("parentOu", "");
		}
		
		public void resetAll() throws AppException, Exception { 
			// 从顶级部门开始计算
			List<Dept> topDepts = getTopDepts();
			for(Dept top: topDepts) {
				top.calcUserCount();
			}
		}

		public List<String> findChildrenOus(String depou) throws AppException, Exception {
			List<String> list = new ArrayList<String>();
			List<Dept> depts = find("parentOu", depou);
			for(Dept dept: depts) {
				list.add(dept.ou);
				list.addAll(findChildrenOus(dept.ou));
			}
			return list;
		}

	}
	
	public static class DeptWrapper {
		public Dept self;
		
		public List<DeptWrapper> children;
		
		public List<User> users;
	}
}
