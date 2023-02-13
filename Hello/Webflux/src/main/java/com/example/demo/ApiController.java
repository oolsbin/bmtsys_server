package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import common.CommonUtillty;
import dto.ListVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

//@Tag(name = "air Controller", description = "항공관련 컨트롤러")//스프링 독
@RestController
//@RequestMapping
public class ApiController {
	private String key = "2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D";
	@Autowired(required=true) private CommonUtillty common;
	
	private String AirportURL = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/";
	
	
	@GetMapping("/find")
	@ApiOperation(value = "공항목록", notes="공항목록을 조회한다.")
//>	@Operation(summary = "화면", description = "화면을 출력합니다.")
	public String callapihttp(String airlineId, String airlineNm, Model model) {
		StringBuffer url = new StringBuffer(AirportURL);
			url.append("getAirmanList?serviceKey=").append(key);
			url.append("&airlineId=").append(airlineId);
			url.append("&airlineNm=").append(airlineNm);
			url.append("&_type=json");
			
			model.addAttribute("getAirmanList", common.requestAPItoMap(url));
		
////		System.out.println(airlineId);
////		System.out.println(airlineNm);
////		List<ListVO> vo = 
//		
//		ResponseEntity<ListVO> resultVO = null;
//		
////		Map<String, Object> map = new HashMap<>();
//		
////		map.put("airlineID", airlineId);
////		map.put("airlineNm", airlineNm);
//		
////		result.put("airlineId", result.get);
////		result.put("airlineNm", airlineNm);
//		
//		String response = "";
//		
//			System.out.println("airlineId = " + airlineId);
//			System.out.println("airlineNm = " + airlineNm);
//		
//
//    try {
//    	// 1. URL을 만들기 위한 StringBuilder
//        String urlBuilder = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getAirmanList?" +
//        			"serviceKey=s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"+
//        			"&airlineId=" + airlineId +
//        			"&airlineNm=" + airlineNm +
//        			"&_type=json";
//        
//        // 3. URL 객체 생성
//        URL url = new URL(urlBuilder);
//        System.out.println("요청URL = " + urlBuilder);
//
//        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             
//        // 5. 통신을 위한 메소드 SET
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        
//        int responseCode = conn.getResponseCode();
//        BufferedReader br;
//        if(responseCode==200) {
//        	br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//        } else {
//        	br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//        }
//        
//        System.out.println("Response code: " + conn.getResponseCode());
//        
//        String returnLine;
//        StringBuilder resultBuild = new StringBuilder();
//        while((returnLine = br.readLine()) !=null) {
//        	resultBuild.append(returnLine);
//        }
////        conn.disconnect();
//        br.close();
//        response = resultBuild.toString();
//    }catch(Exception e) {
//    	System.out.println(e);
//    }
//    System.out.println("연결됨");
//    
    return "find";
	}
	
	
	
	
	
	@Configuration
	public class WebConfig implements WebMvcConfigurer {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("*")
	                .allowedMethods("GET", "POST", "DELETE", "PUT");
	    }
	}
    
    
    
    
	@GetMapping("/apitest2")
	public String callapihttp2() {
		
	
		
	StringBuffer result = new StringBuffer();
		
    try {
    	// 1. URL을 만들기 위한 StringBuilder
        String urlBuilder = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList?"+
        				"serviceKey=s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"
        				+ "&depAirportId=NAARKJJ"
        				+ "&arrAirportId=NAARKPC"
        				+ "&depPlandTime=20211201"
        				+ "&airlineId=AAR&numOfRows=10"
        				+ "&pageNo=1"
        				+ "&_type=json";
        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKJJ", "UTF-8")); /*출발공항ID*/
//        urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
//        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201201", "UTF-8")); /*출발일*/
//        urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("AAR", "UTF-8")); /*항공사ID*/
        // 3. URL 객체 생성
        URL url = new URL(urlBuilder);
        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5. 통신을 위한 메소드 SET
        conn.setRequestMethod("GET");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        
        String returnLine;
//        result.append("<xmp>");
        while((returnLine = br.readLine()) !=null) {
        	result.append(returnLine + "/n");
        }
        conn.disconnect();
    }catch(Exception e) {
    	e.printStackTrace();
    }
	/* System.out.println(result); */
    return result+"";
	}
	
//	@GetMapping("/apitest3")
//	public String callapihttp3() {
//		
//	
//		
//	StringBuffer result = new StringBuffer();
//		
//    try {
//    	// 1. URL을 만들기 위한 StringBuilder
//        String urlBuilder = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getAirmanList?"+
//        				"serviceKey=s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"
//        				+ "&depAirportId=NAARKJJ"
//        				+ "&arrAirportId=NAARKPC"
//        				+ "&depPlandTime=20211201"
//        				+ "&airlineId=AAR&numOfRows=10"
//        				+ "&pageNo=1"
//        				+ "&_type=json";
//        // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키
////        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "s%2FJMx%2B0d4t%2Ffp3JEpST7EJe7bhAJ7Tvuh%2FXkexlOqbuUEzEZxeUBH2UZ%2BXHjwDN8%2Fywz%2F9a%2BFGIUE6k%2FqcmZTg%3D%3D"); /*Service Key*/
////        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
////        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
////        urlBuilder.append("&" + URLEncoder.encode("depAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKJJ", "UTF-8")); /*출발공항ID*/
////        urlBuilder.append("&" + URLEncoder.encode("arrAirportId","UTF-8") + "=" + URLEncoder.encode("NAARKPC", "UTF-8")); /*도착공항ID*/
////        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20201201", "UTF-8")); /*출발일*/
////        urlBuilder.append("&" + URLEncoder.encode("airlineId","UTF-8") + "=" + URLEncoder.encode("AAR", "UTF-8")); /*항공사ID*/
//        // 3. URL 객체 생성
//        URL url = new URL(urlBuilder);
//        // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        // 5. 통신을 위한 메소드 SET
//        conn.setRequestMethod("GET");
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//        
//        String returnLine;
//        result.append("<xmp>");
//        while((returnLine = br.readLine()) !=null) {
//        	result.append(returnLine + "/n");
//        }
//        conn.disconnect();
//    }catch(Exception e) {
//    	e.printStackTrace();
//    }
//	/* System.out.println(result); */
//    return result+"</xmp>";
//	}
}
        
//        // 6. 통신을 위한 Content-type SET
//        conn.setRequestProperty("Content-type", "application/json");
//        // 7. 통신 응답 코드 확인
//        System.out.println("Response code: " + conn.getResponseCode());
//        // 8. 전달받은 데이터를 BufferedReader 객체로 저장
////        BufferedReader rd;
////        
////    if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
////    	rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
////    } else {
////    	rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
////    }
//    
//    // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
//    StringBuilder sb = new StringBuilder();
//    String line;
//    
//    while ((line = rd.readLine()) != null) {
//    	sb.append(line);
//    }
//    
//    
//    // 10. 객체 해제
//    rd.close();
//    conn.disconnect();
//    System.out.println(sb.toString());
//	}
//}
//	
//}













//package com.example.demo;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class ApiController {
//	   @GetMapping("holidayInfoAPI")
//	    public ResponseEntity holidayInfoAPI(
//	            @PathParam("year") String year,
//	            @PathParam("month") String month
//	    ) {
//
//	        System.out.println("year = " + year);
//	        System.out.println("month = " + month);
//
//	        ArrayList<HashMap> responseHolidayArr = new ArrayList<>();
//
//	        try {
//	            Map<String, Object> holidayMap = RequestUtils.holidayInfoAPI(year, month);
//	            Map<String, Object> response = (Map<String, Object>) holidayMap.get("response");
//	            Map<String, Object> body = (Map<String, Object>) response.get("body");
//	            System.out.println("body = " + body);
//
//	            int totalCount = (int) body.get("totalCount");
//	            if (totalCount <= 0) {
//	                System.out.println("공휴일 없음");
//	            }
//	            if (totalCount == 1) {
//	                HashMap<String, Object> items = (HashMap<String, Object>) body.get("items");
//	                HashMap<String, Object> item = (HashMap<String, Object>) items.get("item");
//	                responseHolidayArr.add(item);
//	                System.out.println("item = " + item);
//	            }
//	            if (totalCount > 1) {
//	                HashMap<String, Object> items = (HashMap<String, Object>) body.get("items");
//	                ArrayList<HashMap<String, Object>> item = (ArrayList<HashMap<String, Object>>) items.get("item");
//	                for (HashMap<String, Object> itemMap : item) {
//	                    System.out.println("itemMap = " + itemMap);
//	                    responseHolidayArr.add(itemMap);
//	                }
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return ResponseEntity.ok().body(responseHolidayArr);
//	    }
//}
