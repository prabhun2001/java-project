package pack_sjf;
import pack_input.*;

class sjf extends input{
   int wt[] = new int[30]; // ct means complete time
   int tat[] = new int[30]; // ta means turn around time
   float Awt=0,Atat=0;
   int f[] = new int[30];  // f means it is flag it checks process is completed or not
   int st=0, tot=0; //system time & total no of process
   int ct[] = new int[30];
   int gct[] = new int[30];
   int gpno[] = new int[30];

   public void findavgTime(){

     for(int i=0;i<n;i++)
    {
      f[i] = 0; //process is not completed
      gpno[i]=pno[i];//copied into gpno
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
    if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
    {
    min=bt[i];
    c=i;
    }
    }
    /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
    if (c==n)
    st++;
    else
    {
    ct[c]=st+bt[c];
    st+=bt[c];
    tat[c]=ct[c]-at[c];
    wt[c]=tat[c]-bt[c];
    f[c]=1;
    tot++;
    }
    }

      System.out.print("Processes " + " Burst Time " + " Arrival Time "+ " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
      int total_wt = 0, total_tat = 0;
      for(int i=0;i<n;i++){
         total_wt = total_wt + wt[i];
         total_tat = total_tat + tat[i];
         ct[i] = tat[i] + at[i];
         gct[i]=ct[i];
         System.out.println(i+1 + "\t\t" + bt[i] + "\t\t"  + at[i] + "\t\t" + wt[i] + "\t\t "  + tat[i] + "\t\t " + ct[i]);
      }
      System.out.print("Average waiting time = " + (float)total_wt / (float)n);
      System.out.print("\nAverage turn around time = " + (float)total_tat / (float)n);
   }

   void gannchart(){
     int temp;
     for(int i=0;i<n-1;i++){
       for(int j=0;j<n-1-i;j++){
         if(gct[j]>gct[j+1]){
           temp=gct[j];
           gct[j]=gct[j+1];
           gct[j+1]=temp;

           temp=gpno[j];
           gpno[j]=gpno[j+1];
           gpno[j+1]=temp;
         }
       }
     }
    System.out.println("\nGann chart : ");
    System.out.print("0 ");
    for(int i=0;i<n;i++){
      System.out.print(" (p" + gpno[i] + ") " + gct[i]);
    }

  }

   public static void main(String[] a){
      sjf s = new sjf();
      s.read();
      s.findavgTime();
      s.gannchart();
   }
}
