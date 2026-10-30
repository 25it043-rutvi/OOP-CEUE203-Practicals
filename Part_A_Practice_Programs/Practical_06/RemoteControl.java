interface Switchable { void on();void off();default void toggle(){on();} }
class Fan implements Switchable { public void on(){System.out.println("Fan ON");}public void off(){System.out.println("Fan OFF");} }
class Light implements Switchable { public void on(){System.out.println("Light ON");}public void off(){System.out.println("Light OFF");} }
@FunctionalInterface interface Permission { boolean maySwitchOn(String device,int hour); }
public class RemoteControl {
    public static void main(String[] args){Switchable[] devices={new Fan(),new Light()};for(Switchable d:devices)d.toggle();
        Permission p=new Permission(){public boolean maySwitchOn(String d,int h){return h>=6&&h<=22;}};
        Permission lambda=(d,h)->h>=6&&h<=22;System.out.println(p.maySwitchOn("Fan",10));System.out.println(lambda.maySwitchOn("Light",23));}
}
