package pack_input;
import java.util.*;

public class input{
   protected int n;
   protected ArrayList<Integer> pno = new ArrayList<Integer>(n);
   protected ArrayList<Integer> at = new ArrayList<Integer>(n);
   protected ArrayList<Integer> bt = new ArrayList<Integer>(n);
   Scanner in = new Scanner(System.in);
   Random rand = new Random();

   protected void read_byuser() {
      System.out.println("enter the number of processes : ");
      n = in.nextInt();
      System.out.println("enter the arrival times and Burst time : ");
      System.out.println("process number \t arrival time \t burst time");
      for(int i=0;i<n;i++){
         pno.add(in.nextInt());
         at.add(in.nextInt());
         bt.add(in.nextInt());
      }
      
   }
   
   protected void read_random() {
      System.out.println("enter the number of processes : ");
      n = in.nextInt();
      System.out.println("enter the arrival times and Burst time : ");
      System.out.println("process number \t arrival time \t burst time");
      for(int i=0;i<n;i++){
         pno.add(i+1);
         at.add(rand.nextInt(20));
         bt.add(rand.nextInt(20));
      }
      
   }

   

}
