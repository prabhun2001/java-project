package pack_sjf;

class sjf extends input{
   int ct[] = new int[n]; // ct means complete time
   int ta[] = new int[n]; // ta means turn around time
   

   public void findavgTime(){
      findWaitingTime();
      findTurnAroundTime();
   
      System.out.print("Processes " + " Burst Time " + " Arrival Time "+ " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
      int total_wt = 0, total_tat = 0;
      for(int i=0;i<n;i++){
         total_wt = total_wt + wt[i];
         total_tat = total_tat + tat[i];
         int compl_time = tat[i] + at[i];
         System.out.println(i+1 + "\t\t" + bt[i] + "\t\t"
            + at[i] + "\t\t" + wt[i] + "\t\t "
            + tat[i] + "\t\t " + compl_time);
      }
      System.out.print("Average waiting time = "
         + (float)total_wt / (float)n);
      System.out.print("\nAverage turn around time = "
         + (float)total_tat / (float)n);
   }

   
   public static void main(String[] a){
      sjf s = new sjf();
      s.read();
      s.findavgTime();
   }
}
