package com.omernaci.blog;

import java.lang.reflect.Field;

public class ValidationEngine {

	public void process(final Object object) {

		try {

			Class<?> clazz = object.getClass();
			Field[] declaredFields = clazz.getDeclaredFields();

			for (Field field : declaredFields) {

				ValidateString validateString = field.getAnnotation(ValidateString.class);

				if (validateString != null) {

					if (field.getType() == String.class) {

						field.setAccessible(true);

						String value = (String) field.get(object);

						String start = validateString.start();

						if (!value.startsWith(start)) {
							throw new IllegalArgumentException(value + " doesn't start with :  " + start);
						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
