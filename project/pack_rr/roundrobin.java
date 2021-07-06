import java.util.Scanner;
public class roundrobin
{
  Scanner s=new Scanner(System.in);
  int num,quantum,total;

  int itr=0;
  int pno[]=new int[20];
  int ctime[] =new int[20];
  int wt[] =new int[20];
  int bt[] =new int[20];
  int rtime[] =new int[20];
  int tat[]=new int[20];
  int gpno[]=new int[40];
  int gctime[]=new int[40];

  void calculation(){
    System.out.println("Enter the Number of Process");
    num=s.nextInt();
    System.out.println("Enter process no");
    for(int i=0;i<num;i++)
    {
        System.out.println("\npnum-: ");
        pno[i]=s.nextInt();

    }
      System.out.println("Enter Brust time");
      for(int i=0;i<num;i++)
      {
          System.out.println("\nP["+(i+1)+"]: ");
          bt[i]=s.nextInt();
          rtime[i]=bt[i];
          wt[i]=0;
      }
      System.out.println("\nEnter the time quantum:");
      quantum=s.nextInt();

      int rp=num;
      int i=0;
      int time=0;
      wt[0]=0;
      while(rp!=0)
      {

          if(rtime[i]>quantum)
          {
              rtime[i]=rtime[i]-quantum;
              //System.out.print("| P["+(i+1)+"] | ");
              gpno[itr]=pno[i];
              time+=quantum;
              //System.out.println(time);
              gctime[itr]=time;

              itr++;
          }
          else if(rtime[i]<=quantum && rtime[i]>0)
          {
              time+=rtime[i];
              rtime[i]=rtime[i]-rtime[i];
              ctime[i]=time;
              //System.out.print("| P["+(i+1)+"] | ");
              gpno[itr]=pno[i];
              rp--;
             //System.out.println(time);
             gctime[itr]=time;
             itr++;
          }
          i++;
          if(i==num)
          {
              i=0;
          }
      }
  }

  void findavgtime(){
    calculation();
    for(int i=0;i<num;i++){
      wt[i]=ctime[i]-bt[i];
    }
    for(int i=0;i<num;i++){
      tat[i]=ctime[i];
    }

    System.out.print("Processes " + " Burst Time " + " Waiting Time " + " Turn-Around Time "+ " Completion Time \n");
  int total_wt = 0, total_tat = 0;
  for(int j=0;j<num;j++){
    total_wt = total_wt + wt[j];
      total_tat = total_tat + tat[j];
      System.out.println(j+1 + "\t\t" + bt[j] + "\t\t" + wt[j] + "\t\t "  + tat[j] + "\t\t " + ctime[j]);
  }
  System.out.print("Average waiting time = " + (float)total_wt / (float)num);
 System.out.print("\nAverage turn around time = " + (float)total_tat / (float)num);
  }

  void gannchart(){
    System.out.print("\nGann chart : ");
    System.out.print("\n0");
    for(int i=0;i<itr;i++){
      System.out.print(" ("+ gpno[i] + ") " + gctime[i]);
    }

  }

	public static void main(String[] args) {

		roundrobin r = new roundrobin();

    r.findavgtime();
    r.gannchart();

	}

}
