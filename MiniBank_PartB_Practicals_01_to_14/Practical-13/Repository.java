import java.lang.reflect.Field;
import java.util.*;

public class Repository<T> {
    private final Map<Object, T> data = new LinkedHashMap<>();
    private final Class<T> type;

    public Repository(Class<T> type) { this.type = type; }

    public void save(T item) {
        try {
            Field idField = Arrays.stream(type.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Id.class))
                    .findFirst().orElseThrow(() -> new IllegalStateException("No @Id field in " + type.getSimpleName()));
            idField.setAccessible(true);
            Object id = idField.get(item);
            data.put(id, item);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Unable to read @Id", e);
        }
    }
    public T findById(Object id) { return data.get(id); }
    public List<T> findAll() { return new ArrayList<>(data.values()); }
    public boolean deleteById(Object id) { return data.remove(id) != null; }
    public int count() { return data.size(); }
}
