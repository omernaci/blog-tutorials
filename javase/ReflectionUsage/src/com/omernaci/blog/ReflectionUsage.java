package com.omernaci.blog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionUsage {

	public static void main(String[] args) {

		Class<Blog> clazz = Blog.class;
		
		System.out.println("******************* FIELDS");

		
		Field [] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
            System.out.println("Field : " + field.getName() + " type : " + field.getType());
            
            TitleValidation titleValidation = field.getAnnotation(TitleValidation.class);
            
            if (titleValidation != null) {
				System.out.println("Title annotation Pattern : " + titleValidation.pattern());
			}
			
		}
		
		System.out.println("******************* METHODS");
		
		Method [] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			
            System.out.println("Method : " + method.getName());
            
            //Class<?> returnType = method.getReturnType();
            
            Parameter[] parameters = method.getParameters();
            
            for (Parameter param : parameters) {
                System.out.println("Param name : " + param.getName() + " param type : " + param.getType());
            }
            	
		}
		
	}

}
