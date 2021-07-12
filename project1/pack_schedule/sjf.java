package pack_schedule;
import pack_input.*;
import java.util.*;

public class sjf extends input{
   public ArrayList<Integer> sjf_wt = new ArrayList<Integer>(n); // sjf_ct means complete time
   public ArrayList<Integer> sjf_tat = new ArrayList<Integer>(n); // ta means turn around time
   public float Awt,Atat;
   ArrayList<Integer> f = new ArrayList<Integer>(n);  // f means it is flag it checks process is completed or not
   int st=0, tot=0; //system time & total no of process
   public ArrayList<Integer> sjf_ct = new ArrayList<Integer>(n);
   public ArrayList<Integer> sjf_gct = new ArrayList<Integer>(30);
   public ArrayList<Integer> sjf_gpno = new ArrayList<Integer>(30);

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


      int total_wt = 0, total_tat = 0;
      for(int i=0;i<n;i++){
         total_wt = total_wt + sjf_wt.get(i);
         total_tat = total_tat + sjf_tat.get(i);
         sjf_ct.set(i,sjf_tat.get(i) + at.get(i));
         sjf_gct.add(i,sjf_ct.get(i));

      }
      Awt=(float)total_wt / (float)n;

      Atat=(float)total_tat / (float)n;

   }



  

  public float get_avg_tat(){
  return Atat;
  }

  public float get_avg_wt(){
   return Awt;
  }


   public void schedule(){
   findavgtime();
   
  }

}
