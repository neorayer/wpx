package com.skymiracle.wpx.models.album;

import com.skymiracle.mdo4.NullKeyException;
import com.skymiracle.mdo4.UuidDao;

public class PersistenceObject extends UuidDao{

	public PersistenceObject() {
		super();
	}

	public PersistenceObject(String uuid) {
		super(uuid);
	}
	
	
	@Override
	public String fatherDN(String baseDN) throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] objectClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selfDN() throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String table() {
		// TODO Auto-generated method stub
		return null;
	}

}
