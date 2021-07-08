package pack_main;

import pack_shedule.*;
import java.util.*;

class main{
   int n;
   ArrayList<Integer> pno = new ArrayList<Integer>(30);
   ArrayList<Integer> at = new ArrayList<Integer>(30);
   ArrayList<Integer> bt = new ArrayList<Integer>(30);
   ArrayList<Integer> atime = new ArrayList<Integer>(30);
   Random rand = new Random();

   Scanner in = new Scanner(System.in);
      
   void read_byuser() {
      System.out.println("enter the arrival times and Burst time : ");
      System.out.println("process number \t arrival time \t burst time");
      for(int i=0;i<n;i++){
         pno.add(in.nextInt());
         at.add(in.nextInt());
         bt.add(in.nextInt());
         atime.add(0);
      
      }
   
   }

   void read_random() {
   
      for(int i=0;i<n;i++){
         pno.add((i+1));
         at.add(rand.nextInt(20));
         bt.add(rand.nextInt(20));
         atime.add(0);
      }
      
   }
   
   void clear(){
      pno.clear();
      at.clear();
      bt.clear();
      atime.clear();
   }
   
   void operation(){
      int choice=1,p=1;
      while(choice!=0){
         System.out.println("\n\nenter the number of processes : ");
         n = in.nextInt();
         clear();
         System.out.println("\n1-read by user\n2-read randomly");
         p=in.nextInt();
         if(p==1){
            read_byuser();
         }else if(p==2){
            read_random();
         }else{
            System.out.println("\nInvalid choice!!  ");
               continue;
         }
      
         System.out.println("\n\n1-fcfs with arrival time\n2-sjf with arrival time\n3-roundrobin without considering arrival time\n4-all and compare without considering arrival time\n0-end");
         choice=in.nextInt();
         switch(choice){
            case 1:
            {
               fcfs f = new fcfs(n,pno,at,bt);
               f.schedule();
               break;
            }
            case 2:
            {
               sjf s = new sjf(n,pno,at,bt);
               s.schedule();
               break;
            }
            case 3:
            {
               roundrobin r = new roundrobin(n,pno,atime,bt);
               r.schedule();
               break;
            }
            case 4:
            {
            
               fcfs f = new fcfs(n,pno,atime,bt);
               f.schedule();
               sjf s = new sjf(n,pno,atime,bt);
               s.schedule();
               roundrobin r = new roundrobin(n,pno,atime,bt);
               r.schedule();
               float fawt;
               float sawt;
               float rawt;
               fawt=f.get_avg_wt();
               sawt=s.get_avg_wt();
               rawt=r.get_avg_wt();
               System.out.println("\n\nFCFS Average waiting time : "+fawt);
                  System.out.println("\n\nSJF Average waiting time : "+sawt);
                  System.out.println("\n\nRoundRobin Average waiting time : "+rawt);

               if(fawt<sawt && fawt<rawt){
                  System.out.println("\n\nFCFS is best suitable for this problem");
               }else if(sawt<rawt){
                  System.out.println("SJF is best suitable for this problem");
               }else{
                  System.out.println("RoundRobin is best suitable for this problem");
               }
               System.out.println("The FCFS is better for a small burst time.\n The SJF is better if the process comes to processor simultaneously.\n The last algorithm, Round Robin, is better to adjust the average waiting time desired.");
               break;
            }
            case 0:
            {
               System.out.println("--Thank you--");
               break;
            }
            
            default:
            {
               System.out.println("Invalid choice!!");
               break;
            }
         }
      }
   
   }
  
   public static void main(String a[]){
      main m =new main();
      m.operation();
   }
   
   
      
}