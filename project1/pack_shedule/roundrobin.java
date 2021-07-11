package pack_shedule;
import java.util.*;
import pack_input.*;

public class roundrobin extends input implements methods{
  public ArrayList<Integer> rr_ct = new ArrayList<Integer>(n);
  public ArrayList<Integer> rr_wt = new ArrayList<Integer>(n);
  ArrayList<Integer> rtime = new ArrayList<Integer>(n);
public  ArrayList<Integer> rr_tat = new ArrayList<Integer>(n);
  public ArrayList<Integer> rr_gpno = new ArrayList<Integer>(30);
  public ArrayList<Integer> rr_gct = new ArrayList<Integer>(30);

  Scanner s=new Scanner(System.in);
  public int quantum;
  int total;
  public int itr=0;
  public float Awt,Atat;

  public roundrobin(int n,ArrayList<Integer> pno,ArrayList<Integer> at,ArrayList<Integer> bt,int tq){
      read(n,pno,at,bt);
      quantum=tq;
  }

  void calculation(){

      //System.out.println("\nEnter the time quantum:");
      //quantum=s.nextInt();

      int rp=n;
      int i=0;
      int time=0;
      rr_wt.set(0,0);
      while(rp!=0){

          if(rtime.get(i)>quantum)
          {
              rtime.set(i,rtime.get(i)-quantum);
              rr_gpno.add(pno.get(i));

              time+=quantum;
              rr_gct.add(time);

              itr++;
          }
          else if(rtime.get(i)<=quantum && rtime.get(i)>0)
          {
              time+=rtime.get(i);
              rtime.set(i,rtime.get(i)-rtime.get(i));
              rr_ct.set(i,time);

              rr_gpno.add(pno.get(i));
              rp--;

             rr_gct.add(time);
             itr++;
          }
          i++;
          if(i==n)
          {
              i=0;
          }
      }
  }

  public void findavgtime(){
   for(int i=0;i<n;i++){
        rr_ct.add(0);
        rr_wt.add(0);
        rtime.add(0);
        rr_tat.add(0);

    }
    for(int i=0;i<n;i++)
      {
         rtime.set(i,bt.get(i));
      }

    calculation();

    for(int i=0;i<n;i++){
      rr_wt.set(i,rr_ct.get(i)-bt.get(i));
       rr_tat.set(i,rr_ct.get(i));
    }

    System.out.print("Processes " + " Burst Time " + " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
  int total_wt = 0, total_tat = 0;
  for(int j=0;j<n;j++){
    total_wt = total_wt + rr_wt.get(j);
      total_tat = total_tat + rr_tat.get(j);
      System.out.println(pno.get(j) + "\t\t" + bt.get(j) + "\t\t" + rr_wt.get(j) + "\t\t "  + rr_tat.get(j) + "\t\t " + rr_ct.get(j));
  }
  Awt=(float)total_wt / (float)n;
  System.out.print("Average waiting time = " + Awt);
  Atat=(float)total_tat / (float)n;
  System.out.print("\nAverage turn around time = " + Atat);
  }

  public void gannchart(){
    System.out.print("\nGann chart : ");
    System.out.print("\n0");
    for(int i=0;i<itr;i++){
      System.out.print(" ("+ rr_gpno.get(i) + ") " + rr_gct.get(i));
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
