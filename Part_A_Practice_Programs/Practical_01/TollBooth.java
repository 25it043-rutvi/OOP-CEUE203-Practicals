import java.util.*;
public class TollBooth {
    record Vehicle(String number, String type) {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0, bike = 0, car = 0, truck = 0;
        while (true) {
            System.out.print("Vehicle number (done to stop): ");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) break;
            System.out.print("Type (bike/car/truck): ");
            String type = sc.next().toLowerCase();
            Vehicle v = new Vehicle(number, type);
            int toll = switch (v.type()) {
                case "bike" -> { bike++; yield 20; }
                case "car" -> { car++; yield 50; }
                case "truck" -> { truck++; yield 150; }
                default -> { System.out.println("Unknown type"); yield 0; }
            };
            total += toll;
        }
        String most = bike >= car && bike >= truck ? "bike" : car >= truck ? "car" : "truck";
        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + (Math.max(bike, Math.max(car, truck)) == 0 ? "none" : most));
    }
}
