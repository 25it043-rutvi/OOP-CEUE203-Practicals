class SeatBooking { private int seatsLeft=5; synchronized boolean book(){if(seatsLeft>0){seatsLeft--;return true;}return false;}int remaining(){return seatsLeft;} }
public class SeatBookingRace {
    public static void main(String[] args)throws InterruptedException{SeatBooking b=new SeatBooking();Thread[] ts=new Thread[10];int[] success={0};for(int i=0;i<10;i++){ts[i]=new Thread(()->{if(b.book())synchronized(success){success[0]++;}});ts[i].start();}for(Thread t:ts)t.join();System.out.println("Successful bookings: "+success[0]+", seats left: "+b.remaining());}
}
