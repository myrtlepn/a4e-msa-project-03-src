package bymin4.share.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DtoConverter {
	public static <T, U> T convertObject(T source, U target) throws IllegalAccessException {
		Map<String, Field> sourceFields = generateFieldsMap(source);
		for (Field targetField : target.getClass().getDeclaredFields()) {
			if (sourceFields.containsKey(targetField.getName())) {
				targetField.setAccessible(true);
				Object o = targetField.get(target);
				if (Objects.nonNull(o)) {
					Field sourceField = sourceFields.get(targetField.getName());
					sourceField.setAccessible(true);
					sourceField.set(source, o);
				}
			}
		}
		return source;
	}

	private static <T> Map<String, Field> generateFieldsMap(T instance) {
		return Arrays.stream(instance.getClass().getDeclaredFields())
			.collect(Collectors.toMap(Field::getName, field -> field));
	}

}
