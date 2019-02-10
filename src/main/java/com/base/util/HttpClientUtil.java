package com.base.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


/**
 * 
 *@ClassName:HttpClientUtil.java
 *@Description:  Http请求工具类
 *@Author:lxt<839376636@qq.com>
 *@Date:2017年10月10日上午9:33:15
 *@Version:1.1.0
 */
public class HttpClientUtil {
	private static HttpClient httpClient = HttpClients.createDefault();

	/**
	 * 
	 * @Title: requestGet 
	 * @Description: Get请求
	 * @param url
	 * @param params
	 * @return String
	 */
	public static String requestGet(String url, List<NameValuePair> params) {
		if(url==null || "".equals(url)) {
			return null;
		}
		String body = null;
		try {
			// Get
			HttpGet httpget = new HttpGet(url);
			// put params
			if(params!=null && params.size()>0) {
				String str = EntityUtils.toString(new UrlEncodedFormEntity(params));
				httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
			}else {
				httpget.setURI(new URI(httpget.getURI().toString()));
			}
			// 发送请求
			HttpResponse httpresponse = httpClient.execute(httpget);
			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity);
			if (entity != null) {
				entity.getContent();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return body;
	}
	
	

	/**
	 * 
	 * @Title: requestPost 
	 * @Description: Post请求
	 * @param url
	 * @param params
	 * @return String
	 */
	public static String requestPost(String url, List<NameValuePair> params) {
		if(url==null || "".equals(url)) {
			return null;
		}
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		String jsonStr = null;
		HttpPost httppost = new HttpPost(url);
		try {
			if(params!=null && params.size()>0) {
				httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			}
			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			jsonStr = EntityUtils.toString(entity, "utf-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		httppost.releaseConnection();

		return jsonStr;
	}

}
