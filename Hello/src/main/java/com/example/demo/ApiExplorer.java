//package com.example.demo;
//
///* Java 1.8 샘플 코드 */
//
//
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.json.XML;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//
//public class ApiExplorer {
////	public static Map<String, Object> FlightOpratInfoApi() throws Exception{
//		 public static void main(String[] args) throws IOException {
//		
//		Map<String, Object> resultMap = new HashMap<>();
//
////	    try {
//	    	// 1. URL을 만들기 위한 StringBuilder
//	        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"); /*URL*/
//	        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키
//	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"); /*Service Key*/
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//	        urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKJJ", "UTF-8")); /*출발공항ID*/
//	        urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
//	        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201201", "UTF-8")); /*출발일*/
//	        urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("AAR", "UTF-8")); /*항공사ID*/
//	        // 3. URL 객체 생성
//	        URL url = new URL(urlBuilder.toString());
//	        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        // 5. 통신을 위한 메소드 SET
//	        conn.setRequestMethod("GET");
//	        // 6. 통신을 위한 Content-type SET
//	        conn.setRequestProperty("Content-type", "application/json");
//	        // 7. 통신 응답 코드 확인
//	        System.out.println("Response code: " + conn.getResponseCode());
//	        // 8. 전달받은 데이터를 BufferedReader 객체로 저장
//	        BufferedReader rd;
//	        
//	    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	    	rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	    } else {
//	    	rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	    }
//	    
//	    // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
//	    StringBuilder sb = new StringBuilder();
//	    String line;
//	    
//	    while ((line = rd.readLine()) != null) {
//	    	sb.append(line);
//	    }
//	    
//	    
//	    // 10. 객체 해제
//	    rd.close();
//	    conn.disconnect();
//	    System.out.println(sb.toString());
//
////	    org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
////	    String xmlJSONObjString = xmlJSONObj.toString();
////	    System.out.println("### xmlJSONObjString=>"+xmlJSONObjString);
////
////	    ObjectMapper objectMapper = new ObjectMapper();
////	    Map<String, Object> map = new HashMap<>();
////	    map = objectMapper.readValue(xmlJSONObjString, new TypeReference <Map<String,Object>>(){});
////	    Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
////	    Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
////	    Map<String, Object> items = null;
////	    List<Map<String, Object>> itemList = null;
////
////	    items = (Map<String, Object>) body.get("items");
////	    itemList = (List<Map<String, Object>>) items.get("item");
////
////	    System.out.println("### map="+map);
////	    System.out.println("### dataResponse="+dataResponse);
////	    System.out.println("### body="+body);
////	    System.out.println("### items="+items);
////	    System.out.println("### itemList="+itemList);
////
////	    resultMap.put("Result", "0000");
////	    resultMap.put("numOfRows", body.get("numOfRows"));
////	    resultMap.put("pageNo", body.get("pageNo"));
////	    resultMap.put("totalCount", body.get("totalCount"));
////	    resultMap.put("data", itemList);
//
////	    } catch (Exception e){
////	        e.printStackTrace();
////	        resultMap.clear();
////	        resultMap.put("Result", "0001");
////	    }
//
////	    return resultMap;
//	}
//    
//    
//}