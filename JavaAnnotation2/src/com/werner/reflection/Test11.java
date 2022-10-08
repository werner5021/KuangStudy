package com.werner.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//�q�L�Ϯg����x��
public class Test11 {
	public void test01(Map<String, User> map, List<User> list) {
		System.out.println("test01");
	}

	public Map<String, User> test02() {
		System.out.println("test02");
		return null;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = Test11.class.getMethod("test01", Map.class, List.class); // �����k

		Type[] genericParameterTypes = method.getGenericParameterTypes(); // �ϥΤ�k����x�����ѼƤ�����
		for (Type genericParameterType : genericParameterTypes) {
			System.out.println("#" + genericParameterType); // �L�X�x��������
			if (genericParameterType instanceof ParameterizedType) { // �P�_�x���������O���O�ѼƤ�����
				Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments(); // �p�G�O�ѼƤ������A�j��A�ե�getActualTypeArguments()��k�A��o�u��ѼưT��
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
