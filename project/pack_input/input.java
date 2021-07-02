package pack_input;
import java.util.*;

public class input{
  public int n;
  public int pno[] = new int[30];
  public int at[] = new int[30];
  public int bt[] = new int[30];
  Scanner in = new Scanner(System.in);

  public void read() {
    System.out.println("enter the number of processes : ");
    n = in.nextInt();
    System.out.println("enter the arrival times and Burst time : ");
    System.out.println("process number \t arrival time \t burst time");
    for(int i=0;i<n;i++){
      pno[i]=in.nextInt();

    }
    for(int i=0;i<n;i++){

      at[i]=in.nextInt();

    }
    for(int i=0;i<n;i++){
      
      bt[i]=in.nextInt();
    }
  }

}
