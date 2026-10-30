@FunctionalInterface interface Notifier { void send(String message); }
interface Urgent {}
class EmailNotifier implements Notifier { public void send(String m){System.out.println("Email: "+m);} }
class SmsNotifier implements Notifier, Urgent { public void send(String m){System.out.println("SMS: "+m);} }
public class NotificationDemo {
    public static void main(String[] args){Notifier email=m->System.out.println("Email: "+m);Notifier sms=new SmsNotifier();Notifier[] all={email,sms};for(Notifier n:all)n.send("Bank maintenance tonight");for(Notifier n:all)if(n instanceof Urgent)n.send("URGENT: service interruption");}
}
