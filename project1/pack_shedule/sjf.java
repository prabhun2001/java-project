package pack_shedule;
import pack_input.*;
import java.util.*;

public class sjf extends input{
   ArrayList<Integer> sjf_wt = new ArrayList<Integer>(n); // sjf_ct means complete time
   ArrayList<Integer> sjf_tat = new ArrayList<Integer>(n); // ta means turn around time
   float Awt,Atat;
   ArrayList<Integer> f = new ArrayList<Integer>(n);  // f means it is flag it checks process is completed or not
   int st=0, tot=0; //system time & total no of process
   ArrayList<Integer> sjf_ct = new ArrayList<Integer>(n);
   ArrayList<Integer> sjf_gct = new ArrayList<Integer>(30);
   ArrayList<Integer> sjf_gpno = new ArrayList<Integer>(30);
   
   public sjf(int n,ArrayList<Integer> pno,ArrayList<Integer> at,ArrayList<Integer> bt){
         read(n,pno,at,bt);
         
   }

      public void findavgtime(){

     for(int i=0;i<n;i++)
    {
      f.add(i,0); //process is not completed
      sjf_gpno.add(i,pno.get(i));//copied into sjf_gpno
      sjf_ct.add(0);//initialze
      sjf_tat.add(0);
      sjf_wt.add(0);
    }

    boolean a = true;
    while(true)
    {
    int c=n, min=999;
    if (tot == n) // total no of process = completed process loop will be terminated
    break;
    for (int i=0; i<n; i++)
    {
    /*
    * If i'th process arrival time <= system time and its flag=0 and burst<min
    * That process will be executed first
    */
    if ((at.get(i) <= st) && (f.get(i) == 0) && (bt.get(i)<min))
    {
    min=bt.get(i);
    c=i;
    }
    }
    /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
    if (c==n)
    st++;
    else
    {
    sjf_ct.set(c,st+bt.get(c));
    st+=bt.get(c);
    sjf_tat.set(c,sjf_ct.get(c)-at.get(c));
    sjf_wt.set(c,sjf_tat.get(c)-bt.get(c));
    f.set(c,1);
    tot++;
    }
    }

      System.out.print("Processes " + " Burst Time " + " Arrival Time "+ " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
      int total_wt = 0, total_tat = 0;
      for(int i=0;i<n;i++){
         total_wt = total_wt + sjf_wt.get(i);
         total_tat = total_tat + sjf_tat.get(i);
         sjf_ct.set(i,sjf_tat.get(i) + at.get(i));
         sjf_gct.add(i,sjf_ct.get(i));
         System.out.println(pno.get(i) + "\t\t" + bt.get(i) + "\t\t"  + at.get(i) + "\t\t" + sjf_wt.get(i) + "\t\t "  + sjf_tat.get(i) + "\t\t " + sjf_ct.get(i));
      }
      Awt=(float)total_wt / (float)n;
      System.out.print("Average waiting time = " + Awt);
      Atat=(float)total_tat / (float)n;
      System.out.print("\nAverage turn around time = " + Atat);
   }

   void gannchart(){
     int temp;
     for(int i=0;i<n-1;i++){
       for(int j=0;j<n-1-i;j++){
         if(sjf_gct.get(j)>sjf_gct.get(j+1)){
           temp=sjf_gct.get(j);
           sjf_gct.set(j,sjf_gct.get(j+1));
           sjf_gct.set((j+1),temp);

           temp=sjf_gpno.get(j);
           sjf_gpno.set(j,sjf_gpno.get(j+1));
           sjf_gpno.set((j+1),temp);
         }
       }
     }
    System.out.println("\nGann chart : ");
    System.out.print("0 ");
    for(int i=0;i<n;i++){
      System.out.print(" (p" + sjf_gpno.get(i) + ") " + sjf_gct.get(i));
    }

  }
  
   public float get_avg_tat(){
  return Atat;
  }
  
  public float get_avg_wt(){
   return Awt;
  }

      
   public void schedule(){
   findavgtime();
   gannchart();
  }

}
