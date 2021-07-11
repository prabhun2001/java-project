package pack_shedule;
import pack_input.*;
import java.util.*;

public class fcfs extends input implements methods {
  public ArrayList<Integer> fcfs_wt = new ArrayList<Integer>(n);
  public ArrayList<Integer> fcfs_tat = new ArrayList<Integer>(n);
  public ArrayList<Integer> fcfs_ct = new ArrayList<Integer>(n);
  public float Awt=0,Atat=0;

  public fcfs(int n,ArrayList<Integer> pno,ArrayList<Integer> at,ArrayList<Integer> bt){
      read(n,pno,at,bt);
  }

  public void findWaitingTime(){

      ArrayList<Integer> service_time = new ArrayList<Integer>(n);
      service_time.add(0,at.get(0));
      fcfs_wt.add(0,0);

      // calculating waiting time
      for (int i = 1; i < n ; i++)
      {
          //representing wasted time in queue
          int wasted=0;
          // Add burst time of previous processes
          service_time.add(i,service_time.get(i-1) + bt.get(i-1));

          // Find waiting time for current process =
          // sum - at[i]
          fcfs_wt.add(i, service_time.get(i) - at.get(i));

          // If waiting time for a process is in negative
          // that means it is already in the ready queue
          // before CPU becomes idle so its waiting time is 0
          // wasted time is basically time for process to wait after a process is over
          if (fcfs_wt.get(i) < 0) {
              wasted = Math.abs(fcfs_wt.get(i));
              fcfs_wt.set(i, 0);
          }
          //Add wasted time
          service_time.set(i, service_time.get(i) + wasted);
      }

  }

  public void findTurnAroundTime(){
    for(int i=0;i<n;i++){
      fcfs_tat.add(i,bt.get(i)+fcfs_wt.get(i));
    }
  }

  public void findavgtime(){
    findWaitingTime();
    findTurnAroundTime();

    System.out.print("Processes " + " Burst Time " + " Arrival Time "+ " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
    int total_wt = 0, total_tat = 0;
    for(int i=0;i<n;i++){
      total_wt = total_wt + fcfs_wt.get(i);
        total_tat = total_tat + fcfs_tat.get(i);
        fcfs_ct.add(i, fcfs_tat.get(i) + at.get(i));
        System.out.println(pno.get(i) + "\t\t" + bt.get(i) + "\t\t"
            + at.get(i) + "\t\t" + fcfs_wt.get(i) + "\t\t "
            + fcfs_tat.get(i) + "\t\t " + fcfs_ct.get(i));
    }

    Awt=(float)total_wt / (float)n;

    System.out.print("Average waiting time = "+Awt);

    Atat=(float)total_tat / (float)n;
    System.out.print("\nAverage turn around time = "+ Atat);


  }

  public void gannchart(){
    System.out.println("\nGann chart : ");
    System.out.print("0 ");
    for(int i=0;i<n;i++){
      System.out.print("(" + pno.get(i) + ")" + fcfs_ct.get(i));
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
