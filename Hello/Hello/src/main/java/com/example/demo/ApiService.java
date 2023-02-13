package com.example.demo;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.boot.json.JsonParser;

public class ApiService {
	public void init(String jsonData) {
		try {
			JSONObject jobj;
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj=(JSONObject)jsonParser.parse(jsonData);
			
			JSONObject parseResponse = (JSONObject) jsonParser.parse(jsonData);
			
		}
	}
}
