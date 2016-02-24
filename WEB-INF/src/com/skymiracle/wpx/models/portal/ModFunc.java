package com.skymiracle.wpx.models.portal;

import static com.skymiracle.wpx.Singletons.$ModFunc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

public class ModFunc extends WpxMdo<ModFunc> {

	public String funcId;

	public String funcName;

	public static final int STATUS_NORMAL = 0;

	public static final int STATUS_CLOSE = 3;

	public int status;

	public ModFunc(String funcId) {
		this();
		this.funcId = funcId;
	}

	public ModFunc() {
		super($ModFunc);
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "funcid" };
	}

	@Override
	public String table() {
		return "tb_modfunc";
	}

	public static class X extends WpxMdo_X<ModFunc> {

		public Map<String, ModFunc> modFuncsMap = new HashMap<String, ModFunc>();

		public boolean isModFuncsMapChanged = true;

		public X() {
			super(ModFunc.class);
		}

		public void setModFuncsMap(Map<String, ModFunc> modFuncsMap) {
			this.modFuncsMap = modFuncsMap;
		}

		public Map<String, ModFunc> getModFuncsMap() throws AppException,
				Exception {
			if (isModFuncsMapChanged) {
				List<ModFunc> modFuncs = findAll();
				for (ModFunc mf : modFuncs) {
					ModFunc fullMf = modFuncsMap.get(mf.getFuncId());
					if (fullMf != null) {
						fullMf.setStatus(mf.getStatus());
					}
				}
			}
			isModFuncsMapChanged = false;
			return modFuncsMap;
		}

		public void chgModFunc(String funcId, int status) throws AppException,
				Exception {
			isModFuncsMapChanged = true;

			ModFunc mf = new ModFunc(funcId);
			if (mf.exists()) {
				mf.update("status", status);
			} else {
				mf.setStatus(status);
				mf.create();
			}
		}

		public boolean isModFuncOpen(String funcId, int status) {
			ModFunc mf = modFuncsMap.get(funcId);
			if (mf == null)
				return false;

			if (mf.getStatus() != status)
				return false;

			return true;
		}
	}
}
