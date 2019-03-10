package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author ThinkPad HttpClient工具类
 */
public class HttpUtil {

	/**
	 * get请求
	 * 
	 * @return
	 */
	public static String doGet(String url) {
		String strResult = "";
		HttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				HttpEntity httpEntity = response.getEntity();
				strResult = EntityUtils.toString(httpEntity, "utf-8");
				if(strResult.contains("<!DOCTYPE HTML>")){
					strResult = "error";
				}
			}
		} catch (Exception e) {
			return "error";
		}
		return strResult;
	}
}