import java.util.ArrayList;

public class Warmup1_1028  {
    public int findsum(String s){
        int sum=0;
        if(s==null) return 0;
        String [] arr=s.split(" ");
        ArrayList<Integer> numbers=new ArrayList<>();
        for(String a:arr){
            try{
                numbers.add(Integer.parseInt(a));
            }
            catch (Exception e){
                numbers.add(null);
            }

        }
        for(Integer num:numbers){
            if(num==null) sum+=0;
            else sum+=num;

        }
        return sum;


    }
}
