// JUnit 5 example. Add JUnit Jupiter to the project before compiling this file.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TaskServiceTest {
    @Test void addingTaskIncreasesCount(){TaskService s=new TaskService();s.add("Study");assertEquals(1,s.count());}
    @Test void invalidTaskThrows(){TaskService s=new TaskService();assertThrows(IllegalArgumentException.class,()->s.add(" "));}
}
