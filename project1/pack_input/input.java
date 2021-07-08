package pack_input;

import java.util.*;

public abstract class input{
   protected int n;
   protected ArrayList<Integer> pno = new ArrayList<Integer>(30);
   protected ArrayList<Integer> at = new ArrayList<Integer>(30);
   protected ArrayList<Integer> bt = new ArrayList<Integer>(30);
   
   protected void read(int n,ArrayList<Integer> pno,ArrayList<Integer> at,ArrayList<Integer> bt){
      this.n=n;
      this.pno.addAll(pno);
      this.at.addAll(at);
      this.bt.addAll(bt);
   }  
     
}
