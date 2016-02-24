package com.skymiracle.wpx;
import static com.skymiracle.wpx.Singletons.appStore;

import java.util.Properties;

import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.log.MailLog;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.*;
import com.skymiracle.wpx.models.user.*;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class InitDB {

	public static void main(String[] args) throws AppException, Exception {
		Logger.setLevel(Logger.LEVEL_DEBUG);
//		appStore.createTableForce(TimerMail.class,true);
		//appStore.createTableForce(User.class,true);
		//appStore.createTableForce(BatchGroup.class,true);
		//appStore.createTableForce(BatchGroupCondition.class,true);
		//appStore.createTableForce(SysLog.class,true);
		//appStore.createTableForce(Dept.class,true);
		//appStore.createTableForce(GrpUser.class,true);
		//appStore.createTableForce(GrpUserMember.class,true);
		//appStore.createTableForce(MailLog.class,true);
		Properties props = System.getProperties();
		for(java.util.Map.Entry<Object, Object> entry: props.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
	
	}

}
  