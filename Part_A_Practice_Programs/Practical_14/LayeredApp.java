import java.util.*;
class Task {private final String name;Task(String n){name=n;}String name(){return name;}}
class TaskService {private final List<Task> tasks=new ArrayList<>();void add(String n){if(n==null||n.isBlank())throw new IllegalArgumentException("Task name required");tasks.add(new Task(n));}int count(){return tasks.size();}}
public class LayeredApp {
    public static void main(String[] args){TaskService service=new TaskService();service.add("Complete Java lab");service.add("Revise OOP");System.out.println("Task count: "+service.count());}
}
