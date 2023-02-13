package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service

public class CommonUtillty {
	
	public Map<String, Object> requestAPItoMap( StringBuffer apiURL ) {
		int count = 0; 
		JSONObject json = new JSONObject( requestAPI( apiURL ) );
		json = json.getJSONObject( "response" ); //header, body 
		int code = Integer.parseInt(
				 json.getJSONObject("header").getString("resultCode"));
		if( code==0 ) {
			json = json.getJSONObject( "body" ); // items,numOfRows,pageNo,totalCount
			if( json.has("totalCount") ) count = json.getInt( "totalCount" );
			json = json.getJSONObject( "items" ); //item 이 10개
		}else {
			json.put("item", new JSONObject());
		}
		json.put("count", count);
		return json.toMap();
	}
	
	public String requestAPI( StringBuffer apiURL ) {
		String response = "";
		try {
		      URL url = new URL(apiURL.toString());
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { // 정상 호출
		        br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		      } else {  // 에러 발생
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      response = res.toString();
		    } catch (Exception e) {
		      System.out.println(e);
		    }
			return response;
	}

	public String requestAPI( StringBuffer apiURL, String header ) {
		String response = "";
		try {
			URL url = new URL(apiURL.toString());
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/json");
			
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode="+responseCode);
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String returnLine;
			StringBuffer res = new StringBuffer();
			while ((returnLine = br.readLine()) != null) {
				res.append(returnLine);
			}
			br.close();
			response = res.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return response;
	}
	
}
