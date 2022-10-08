package com.werner.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static String getJson(Date date) {
		return getJson(date, "yyyy-MM-dd HH:mm::ss");
	}
	
	public static String getJson(Date date, String dataFormat){
		
		ObjectMapper mapper = new ObjectMapper();
				
		SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
		
		try {
			String json = mapper.writeValueAsString(sdf.format(date));
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
