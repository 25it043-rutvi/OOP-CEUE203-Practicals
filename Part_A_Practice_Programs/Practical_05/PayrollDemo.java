abstract class Employee { String name,id; Employee(String n,String i){name=n;id=i;} abstract double monthlySalary(); }
class FullTime extends Employee { double salary; FullTime(String n,String i,double s){super(n,i);salary=s;} double monthlySalary(){return salary;} }
class PartTime extends Employee { int hours;double rate;PartTime(String n,String i,int h,double r){super(n,i);hours=h;rate=r;}double monthlySalary(){return hours*rate;} }
class Intern extends Employee { double stipend;Intern(String n,String i,double s){super(n,i);stipend=s;}double monthlySalary(){return stipend;} }
public class PayrollDemo {
    public static void main(String[] args){Employee[] e={new FullTime("Asha","E1",40000),new PartTime("Ravi","E2",80,200),new Intern("Mira","E3",10000)};double total=0;for(Employee x:e){System.out.println(x.name+": "+x.monthlySalary()+(x instanceof Intern?" (Intern)":""));total+=x.monthlySalary();}System.out.println("Total: "+total);}
}
