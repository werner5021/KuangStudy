package com.werner.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通過反射獲取泛型
public class Test11 {
	public void test01(Map<String, User> map, List<User> list) {
		System.out.println("test01");
	}

	public Map<String, User> test02() {
		System.out.println("test02");
		return null;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = Test11.class.getMethod("test01", Map.class, List.class); // 獲取方法

		Type[] genericParameterTypes = method.getGenericParameterTypes(); // 使用方法獲取泛型的參數化類型
		for (Type genericParameterType : genericParameterTypes) {
			System.out.println("#" + genericParameterType); // 印出泛型的類型
			if (genericParameterType instanceof ParameterizedType) { // 判斷泛型的類型是不是參數化類型
				Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments(); // 如果是參數化類型，強轉，調用getActualTypeArguments()方法，獲得真實參數訊息
				for (Type actualTypeArgument : actualTypeArguments) {
					System.out.println("@" + actualTypeArgument);
				}
			}
		}

		System.out.println("===================================");

		method = Test11.class.getMethod("test02", null);
		Type genericReturnType = method.getGenericReturnType();
		if (genericReturnType instanceof ParameterizedType) {
			Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
			for (Type actualTypeArgument : actualTypeArguments) {
				System.out.println("@" + actualTypeArgument);
			}
		}

	}
}
