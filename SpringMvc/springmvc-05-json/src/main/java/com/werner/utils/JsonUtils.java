package com.werner.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {

	public static String getJson(Object object) {
		return getJson(object, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getJson(Object object, String dateFormat) {
		ObjectMapper mapper = new ObjectMapper();

		//不使用時間戳的方式
		mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
		//自定義日期格式對象
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		//指定日期格式
		mapper.setDateFormat(sdf);

		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
