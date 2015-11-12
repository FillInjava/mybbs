package com.mybbs.myhttp.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpTest {

	public static void main(String[] args) {
		//httptest1();
		httptest2();
	}
	
	public static void httptest3(){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("p1","v1"));
		params.add(new BasicNameValuePair("p2","v2"));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,Consts.UTF_8);
		
		HttpPost httpPost = new HttpPost("http://localhost:8080/");
		
		httpPost.setEntity(entity);
	}
	public static void httptest2(){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("http://localhost:8080/");
		
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			if(entity!=null){
//				Long len = entity.getContentLength();
//				if(len!=-1 && len<2048)
//					System.out.println(EntityUtils.toString(entity)); 
				entity=new BufferedHttpEntity(entity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void httptest1() {
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("www.baidu.com")
					.setPath("/aa/dd/bb")
					.setParameter("name", "lg")
					.setParameter("age", "1").build();
			
			System.out.println(uri);
			HttpGet httpGet = new HttpGet(uri);
			
			HttpResponse httpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
			
//			System.out.println(httpResponse.getProtocolVersion());
//			System.out.println(httpResponse.getStatusLine().getStatusCode());
//			System.out.println(httpResponse.getStatusLine().getReasonPhrase());
//			System.out.println(httpResponse.getStatusLine().toString());
			
			httpResponse.addHeader("Set-Cookie", "c1=a; path=/; domain=localhost");
			httpResponse.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
			
//			Header h1=httpResponse.getFirstHeader("Set-Cookie");
//			System.out.println(h1);
//			Header h2=httpResponse.getLastHeader("Set-Cookie");
//			System.out.println(h2);
			
			HeaderIterator ht = httpResponse.headerIterator("Set-Cookie");
//			while(ht.hasNext()){
//				System.out.println(ht.next());
//			}
			
			HeaderElementIterator het = new BasicHeaderElementIterator(ht);
			
			while(het.hasNext()){
				HeaderElement elem = het.nextElement();
				System.out.println(elem.getName()+"="+elem.getValue());
				
				NameValuePair[] params = elem.getParameters();
				for(int i=0;i<params.length;i++){
					System.out.println(" "+params[i]);
				}
			}
			
			StringEntity entity = new StringEntity("important message", 
											ContentType.create("text/plain", "UTF-8"));
			
			System.out.println(entity.getContentType());
			System.out.println(entity.getContentLength());
			System.out.println(EntityUtils.toString(entity));
			System.out.println(EntityUtils.toByteArray(entity).length);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
