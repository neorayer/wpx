package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.skymiracle.client.tcpClient.smtpClient.SmtpClient;
import com.skymiracle.fax.FaxIOClient;
import com.skymiracle.http.HttpUploader.TempUpFile;
import com.skymiracle.io.PlainFile;
import com.skymiracle.mime.MimeCreater;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.wpx.models.fax.Fax;

public class FaxCtr extends Ctr {

	// 对发传真的人，回复一封邮件（网络传真 -> 用户界面）
	public void outFaxResult() throws AppException, Exception {
		String result = $("result");
//		String sendtime = $("sendtime");
		String email = $("uid");
		String sendnum = $("sendnum");
//		String content = $("content");

		if (sendnum == null)
			throw new AppException("您的传真号为空!");

		MimeCreater mc = new MimeCreater();
		String mailfrom = FaxConfig.getRelayEmail();
		mc.setFrom("网络传真", mailfrom);
		mc.setSubject("传真发送");
		mc.setTos(new String[] { email });
		String mailContent = "";
		if ("success".equals(result))
			mailContent += "发送传真至" + sendnum + "成功!";
		else {
			mailContent += "发送传真至" + sendnum + "失败!";
		}
		mc.setContent(mailContent);
		mc.setPlainContent(mailContent);

		File mimeTempFile = createTempFile();
		mc.saveToFile(mimeTempFile.getAbsolutePath());
		List<String> dataLines = PlainFile.readLines(mimeTempFile, "UTF-8");
		
		SmtpClient smtpClient = new SmtpClient();
		smtpClient.setFromEmail(mailfrom);
		smtpClient.sendWithRoute(mc.getRcpts(), dataLines);
	}

	// 收网络传真(网络传真 -> 邮箱队列)
	public void faxToEmail() throws AppException, Exception {
		String fname = $("fname");
		System.out.println(fname);
		String[] s = fname.split("_");
		String faxNum = s[1];
		System.out.println(faxNum);

		Fax fax = new Fax(faxNum);
		fax.load();
		

		MimeCreater mc = new MimeCreater();
		mc.setFrom("网络传真", FaxConfig.getRelayEmail());
		mc.setSubject("传真邮件");
		mc.setTos(new String[] { fax.getMail() });
		String mailContent = "此邮件为传真邮件,具体请查看附件";
		mc.setContent(mailContent);
		mc.setPlainContent(mailContent);

		TempUpFile tfile = $TFile();
		System.out.println(tfile.getOrginalName());
		mc.addAttachment(tfile.getTmpUpPath(), tfile.getOrginalName(), tfile
				.getOrginalName());

		File mimeTempFile = createTempFile();
		mc.saveToFile(mimeTempFile.getAbsolutePath());
		List<String> dataLines = PlainFile.readLines(mimeTempFile, "UTF-8");
		;
		SmtpClient smtpClient = new SmtpClient();
		smtpClient.setFromEmail(FaxConfig.getRelayEmail());
		smtpClient.sendWithRoute(mc.getRcpts(), dataLines);
	}

	/*
	 * // 发网络传真(用户界面 -> 网络传真) public void sendFax() throws AppException {
	 * String[] numbers=$$s("numbers", ","); String uid = $("uid"); String dc =
	 * $("dc"); String sender = uid + "@" + dc; File file = $File();
	 * 
	 * try{ // send fax file to faxServer String host = "127.0.0.1"; int port =
	 * 8799; FaxIOClient faxIOClient = new FaxIOClient(host, port);
	 * faxIOClient.doOutFax(file, sender, numbers);
	 *  // Prepare outFaxMission Dao, and save OutFaxMission ofm = new
	 * OutFaxMission(); ofm.setSender(sender); //
	 * ofm.setSendTime(DateUtil.getDateWithTime());
	 * ofm.setStatus(OutFaxMission.STATUS_Submitted);
	 * ofm.setTargetNumbers(numbers); // addDao(ofm); // return ofm;
	 * System.out.println("传真已发送至传真服务器!"); } catch(Exception e){
	 * e.printStackTrace(); System.out.println("传真发送失败!"); } }
	 */

	public void addfax() throws AppException, Exception {
		$M(Fax.class).create();
		page().redirectTo("fax.html");
	}

	public void delfax() throws AppException, Exception {
		$M(Fax.class).delete();
		page().redirectTo("fax.html");
	}

	public void synfaxs() throws AppException, Exception {
		FaxIOClient faxIOClient = new FaxIOClient(FaxConfig.getFaxServerHost(),
				FaxConfig.getFaxServerPort());
		
		List<Fax> faxs = $Fax.findAll();
		List<String> faxNumbers = new ArrayList<String>();
		faxNumbers.add(faxs.size() + "");
		for(Fax fax: faxs) {
			faxNumbers.add(fax.getId());
		}
		
		faxIOClient.doStor_UserDB(faxNumbers.toArray(new String[0]));
	}

}
