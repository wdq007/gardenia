package com.dawang.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class AccessToken {
	
	private final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private final String APPID="wx8ee3c7b701e38f2e";
    private final String CRED="f650b5e4dc2f20c4f82734ec254ad234";
    
    public void getToken(String appid, String cred) {
    	String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", cred);
    	StringBuffer buffer = new StringBuffer();
    	try {
    	URL url = new URL(requestUrl);
    	HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
    	httpUrlConn.setRequestMethod("GET");
    	httpUrlConn.connect();
    	InputStream inputStream = httpUrlConn.getInputStream();
    	InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
    	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    	String str = null;
    	while ((str = bufferedReader.readLine()) != null) {
    		buffer.append(str);
    	}
    	bufferedReader.close();
    	inputStreamReader.close();
    	inputStream.close();
    	httpUrlConn.disconnect();
    	System.out.println(buffer.toString());
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
    	AccessToken tk = new AccessToken();
    	tk.getToken(tk.APPID, tk.CRED);
    }
	
}
