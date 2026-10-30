package util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import model.annotation.*;

public class AnnotationValidator {
    public static String[] validate(Object obj) {
        ArrayList<String> errors = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (field.isAnnotationPresent(Positive.class)) {
                    Positive rule = field.getAnnotation(Positive.class);
                    if (!(value instanceof Number) || ((Number)value).doubleValue() <= 0)
                        errors.add(field.getName() + ": " + rule.message());
                }
                if (field.isAnnotationPresent(MaxLength.class) && value instanceof String s) {
                    int max = field.getAnnotation(MaxLength.class).value();
                    if (s.length() > max) errors.add(field.getName() + ": maximum length is " + max);
                }
            } catch (IllegalAccessException e) { errors.add("Cannot read " + field.getName()); }
        }
        return errors.toArray(new String[0]);
    }
}
