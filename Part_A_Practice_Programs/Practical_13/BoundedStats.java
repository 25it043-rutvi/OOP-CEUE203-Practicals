public class BoundedStats {
    static <N extends Number> double average(N[] values){double sum=0;for(N n:values)sum+=n.doubleValue();return values.length==0?0:sum/values.length;}
    public static void main(String[] args){System.out.println(average(new Integer[]{1,2,3}));System.out.println(average(new Double[]{2.5,3.5}));System.out.println(average(new Long[]{10L,20L}));}
}
