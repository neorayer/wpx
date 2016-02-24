package com.skymiracle.wpx;

import java.io.File;
import java.util.List;

import com.skymiracle.io.Dir;
import com.skymiracle.mime.Attachment;
import com.skymiracle.mime.Mime;
import com.skymiracle.mime.MimeImpl;
import com.skymiracle.mime.MimeReader;
import com.skymiracle.mime.MimeReaderCachedImpl;

public class TestMime {
	public static void main(String[] args) throws Exception {
		
/**		
//		MimeReader mr = new MimeReaderCachedImpl("D:/wpx/cache/decode/");
//		String filepath = "D:/wpx/storage/nc.cn/test/mailbox/sent/3e502a6a-dd0a-4622-9be2-e5f215682df8";
//		Mime mime =  mr.loadMime(new File(filepath), "3e502a6a-dd0a-4622-9be2-e5f215682df8");
		
		Mime mime = null;
		String cachePath = "d:/faxcache/decode/3e502a6a-dd0a-4622-9be2-e5f215682df8/";
		Dir dir = new Dir(cachePath);
		dir.mkdirs();
		
		String filepath = "D:/wpx/storage/nc.cn/test/mailbox/sent/3e502a6a-dd0a-4622-9be2-e5f215682df8";
		Mime mime1 = new MimeImpl(filepath, true);
		mime1.save(cachePath);
		mime =  new MimeImpl(cachePath);
		
		
//		
		System.out.println(mime.getSubject());
//		
		List<Attachment>  attachs = mime.getDownableAttachments();
		for(Attachment a: attachs) {
			System.out.println(a.getFileName());
		}
		
		*/
		
		String a = "05798213";
		int an = Integer.parseInt(a);
		System.out.println(an);
		System.out.println(a);
	}
}
