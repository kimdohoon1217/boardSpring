package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileuploadUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileuploadUtil.class);
	/**
	* Method : getFilenameTest
	* 작성자 : PC-13
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로부터 파일이름 추출
	*/
	public static String getFilename(String contentDisposition) {
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\""
		String[] attrs = contentDisposition.split("; ");
		//attrs[0] form-data
		//attrs[1] name="file"
		//attrs[2] filename="brown.png"
		
		String filename="";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				logger.debug("keyValue[1].indexOf(\") : {}", keyValue[1].indexOf("\""));
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, keyValue[1].lastIndexOf("\""));
			break;
			}
		}
		return filename;
	}
	
	public static String getFileExtentsion(String contentDisposition) {
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\""
		
		String filename = getFilename(contentDisposition);
		
		if(filename.lastIndexOf(".")>0) {
			return filename.substring(filename.lastIndexOf("."), filename.length());
		}else {
			return "";
		}
	}

	/**
	* Method : getPath
	* 작성자 : PC-13
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드할 경로를 조회한다
	 */
	public static String getPath() {
		String basicPath = "e:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4,6);
		
		File yyyyDirectory = new File(basicPath+"\\"+yyyy+"\\"+mm);
		if(!yyyyDirectory.exists()) {
			yyyyDirectory.mkdirs();
		}
		
		return basicPath+"\\"+yyyy+"\\"+mm+"\\";
	}

}
