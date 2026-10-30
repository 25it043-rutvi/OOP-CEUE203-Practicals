package service;
import java.lang.reflect.Field;
import java.util.*;
import model.annotation.Id;

public class Repository<T> {
    private final Map<Object,T> data = new LinkedHashMap<>();
    private final Class<T> type;
    public Repository(Class<T> type) { this.type = type; }
    public void save(T value) {
        try {
            Field id = Arrays.stream(type.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Id.class)).findFirst()
                    .orElseThrow(() -> new IllegalStateException("Missing @Id"));
            id.setAccessible(true);
            data.put(id.get(value), value);
        } catch (ReflectiveOperationException e) { throw new IllegalStateException(e); }
    }
    public T findById(Object id) { return data.get(id); }
    public List<T> findAll() { return new ArrayList<>(data.values()); }
}
