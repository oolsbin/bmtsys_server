//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.common.net.HttpHeaders;
//
//import io.swagger.annotations.Contact;
//import io.swagger.annotations.Info;
//import io.swagger.models.SecurityRequirement;
//import io.swagger.v3.oas.models.OpenAPI;
//import springfox.documentation.service.SecurityScheme;
//
//@Configuration
//public class SpringDocsConfig {
//
//    @Bean
//    public OpenAPI openAPI(@Value("${springdoc.version}") String version) {
//
//        Info info = new Info()
//            .title("Example API 문서") // 타이틀
//            .version(version) // 문서 버전
//            .description("잘못된 부분이나 오류 발생 시 바로 말씀해주세요.") // 문서 설명
//            .contact(new Contact() // 연락처
//            	.name("beekei")
//                .email("beekei.shin@gmail.com")
//                .url("https://devbksheen.tistory.com/"));
//
//	    // Security 스키마 설정
//    	 SecurityScheme bearerAuth = new SecurityScheme()
//        	.type(SecurityScheme.Type.HTTP)
//            .scheme("bearer")
//            .bearerFormat("JWT")
//            .in(SecurityScheme.In.HEADER)
//            .name(HttpHeaders.AUTHORIZATION);
//	
//    	// Security 요청 설정
//        SecurityRequirement addSecurityItem = new SecurityRequirement();
//        addSecurityItem.addList("JWT");
//
//        return new OpenAPI()
//            // Security 인증 컴포넌트 설정
//            .components(new Components().addSecuritySchemes("JWT", bearerAuth))
//            // API 마다 Security 인증 컴포넌트 설정
//            .addSecurityItem(addSecurityItem)
//            .info(info);
//        }
//            
//    }
//
//}