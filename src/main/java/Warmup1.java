import java.util.ArrayList;
import java.util.Random;

public class Warmup1 {
    public static  void write(ArrayList<Integer> array){
    for(Integer a:array) {
        System.out.print(" ");
        System.out.print (a);

    }


    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Integer num = r.nextInt(100);
            array.add(num);
            if (num % 2 == 0) array2.add(num);
            else array1.add(num);
        }
        System.out.println("first array");
        write(array);
        System.out.println("second array");
        write(array1);
        System.out.println("third array");
        write(array2);
    }


}
