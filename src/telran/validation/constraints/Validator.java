package telran.validation.constraints;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Validator {
private static List<String> errorsMesg;

	
	public static List<String> validate(Object obj) {
		Validator.errorsMesg = new ArrayList<>();
		Field[] fields = obj.getClass().getDeclaredFields();
		Object value = null;
		for(Field field: fields) {
			field.setAccessible(true);
			try {
				value = field.get(obj);
			} catch (Exception e) {
				
			}
			Annotation[] annotations = field.getAnnotations();
			if(annotations.length != 0) {
				for(Annotation annotation: annotations) {
					String annName = annotation.annotationType().getSimpleName().toLowerCase();
					Method method = null;
					try {
						if(value == null) {
							value = "";
						}
						method = Validator.class.getDeclaredMethod(annName, value.getClass(), Field.class);
						method.setAccessible(true);
						method.invoke(Validator.class, value, field);	
					} catch (Exception e) {
						
					}		
				}
			}
		}
		return errorsMesg;
	}
	@SuppressWarnings("unused")
	private static void min(String str, Field field) {
		Min min = field.getAnnotation(Min.class);
		if(str.length() < min.value()) {
			errorsMesg.add(min.message());
		}
	}
	@SuppressWarnings("unused")
	private static void max(String str, Field field) {
		Max max = field.getAnnotation(Max.class);
		if(str.length() > max.value()) {
			errorsMesg.add(max.message());
		}
	}
	@SuppressWarnings("unused")
	private static void min(Double num, Field field) {
		Min min = field.getAnnotation(Min.class);
		if(num < min.value()) {
			errorsMesg.add(min.message());
		}
	}
	@SuppressWarnings("unused")
	private static void max(Double num, Field field) {
		Max max = field.getAnnotation(Max.class);
		if(num > max.value()) {
			errorsMesg.add(max.message());
		}
	}
	@SuppressWarnings("unused")
	private static void pattern(String str, Field field) {
		Pattern pattern = field.getAnnotation(Pattern.class);
		if(!str.matches(pattern.value())) {
			errorsMesg.add(pattern.message());
		}
	}
	@SuppressWarnings("unused")
	private static void notempty(String str, Field field) {
		NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
		if(str.equals(null) || str.equals("")) {
			errorsMesg.add(notEmpty.message());
		}
	}
}
