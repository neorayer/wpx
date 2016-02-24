package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.$NdFile;
import static com.skymiracle.wpx.Singletons.$NdFolder;

import java.io.File;

import com.skymiracle.http.HttpUploader.ProcListener;
import com.skymiracle.http.HttpUploader.TempUpFile;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.FnsQPCodec;
import com.skymiracle.wpx.models.netdisk.NdFolder;
import com.skymiracle.wpx.util.ByteTools;
@Sessioned
public class NetdiskCtr extends Ctr {
	
	@Layout("NOT")
	public void main() throws AppException, Exception {
		size();
		
		r.putMap("groupid", $("groupid", ""));
		
		//加载文件夹
		groups();
		
		//加载所有文件
		files();
	}
	
	@Layout("NOT")
	public void size() throws AppException, Exception {
		r.putMap("spaceSize", ByteTools.getViewSize($NdFolder.getSize(actor)));
	}
	
	
	@Layout("NOT")
	public void groups() throws AppException, Exception {
		r.putMap("grps", $NdFolder.findAll(actor));
	}
	
	@Layout("NOT")
	public void files() throws AppException, Exception {
		String folderPath =$("groupid", "");
		r.putMap("files", $NdFile.findAll(actor, "/"+folderPath));
	}
	

	@Layout("NOT")
	public void addFolder() throws AppException, Exception {
		if(!is_get){
			String name = $("name", "");
			if(null !=name && !name.equals("")){
				NdFolder folder = new NdFolder();
				folder.setParentUuid("/");
				folder.setName(name);
				$NdFolder.add(actor, folder);
				
				r.putMap("groupid", folder.getUuid());
			}
		}
	}
	
	@Layout("NOT")
	public void delFolder() throws AppException, Exception  {
		String uuid = $("uuid");
		NdFolder folder = new NdFolder();
		folder.setUuid(uuid);
		try {
			$NdFolder.del(actor, folder);
		}catch (Exception e) {
			throw new AppException("删除操作失败");
		}
	}
	
	@Layout("NOT")
	public void moveTo() throws AppException, Exception {
		$NdFile.moveFiles(actor, $$("uuid"), $("groupid"));
	}
	
	@Layout("NOT")
	public void del() throws AppException, Exception {
		$NdFile.del(actor, $$("uuid"));
	}
	
	@Layout("NOT")
	public void addFile() {
		try {
		String groupid =$("groupid");
		if(!is_get){
			TempUpFile tfile = $TFile();
			File file = new File(tfile.getTmpUpPath());
			$NdFile.add(actor, groupid, file, tfile.getOrginalName());
			
			r.setJs("parent.tipMsg('文件上传结束',parent.NetDisk.refresh());parent.NetDisk.refreshSize();");
		}
		
		r.putMap("groupid", groupid);
		}catch (Exception e) {
			r.setJs("alert('"+e.getMessage()+"');parent.NetDisk.refresh();");
		}
	}
	
	@Layout("NOT")
	public void download() throws AppException, Exception {
		String uuid =$("uuid");
		if(uuid.indexOf("../")!=-1)
			throw new AppException("非法访问");
		
		File file = $NdFile.getFile(actor, uuid);
		String fileName = FnsQPCodec.decode(file.getName(), "UTF-8");
		r.putFile(file, fileName);
	}

	// json 上传进度的方法
	public void composeProcess() throws AppException, Exception {
		ProcListener listener = request.getUploadProcess();
		if(listener == null)
			return;
		r.putMap("allLength", listener.getAllLength());
		r.putMap("curLength", listener.getCurLength());
	}

}
