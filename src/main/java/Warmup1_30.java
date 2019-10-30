import java.io.*;
import java.util.*;

public class Warmup1_30 {

    public String createString(){
        Random r=new Random();
        String s="";
        int len=r.nextInt(21)+10;
        while(s.length()<len){
            s=s+String.valueOf((char) (r.nextInt('z'-'a'+1)+'a'));
        }
        return s;
    }

    public List <String> createlist(){
        List<String> list=new ArrayList<>();
        while(list.size()<30){

            list.add(createString());
        }
        return list;
    }

      public void writetofile(List <String> a) throws Exception{
        FileWriter f=new FileWriter("warmup.txt");
        BufferedWriter b=new BufferedWriter(f);
          for(String word: a) {
             b.write(word+ System.lineSeparator() );
          }
          b.close();

      }
      public void readfile() throws Exception{
          String name="warmup.txt";
          List<String> list=new ArrayList<>();
          BufferedReader b=new BufferedReader(new FileReader(name));
          String line=null;
          while((line=b.readLine())!=null)
          {
              list.add(line);
              Collections.sort(list);

          }
          b.close();
          Collections.sort(list, new Comparator<String>() {
              @Override
              public int compare(String o1, String o2) {
                  return o1.length()-o2.length();
              }
          });
          System.out.println(list);

          FileWriter f2=new FileWriter("warmup2.txt");
          BufferedWriter b2=new BufferedWriter(f2);

          for(String word:list ) {
              b2.write(word+ System.lineSeparator() );
          }
          b2.close();


      }



    public static void main(String[] args) throws Exception {
        Warmup1_30 w=new Warmup1_30();
        List<String> list=w.createlist();


        w.writetofile(list);
        w.readfile();



    }



}
