package pack_main;
import pack_schedule.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myexception extends Exception{
  myexception(String s){
    super(s);
  }
}

public class main{
   int n,tq;
   ArrayList<Integer> pno = new ArrayList<Integer>(30);
   ArrayList<Integer> at = new ArrayList<Integer>(30);
   ArrayList<Integer> bt = new ArrayList<Integer>(30);
   ArrayList<Integer> atime = new ArrayList<Integer>(30);
   Random rand = new Random();

   Scanner in = new Scanner(System.in);

   
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

   
   

   public static void main(String a[]){
      main obj = new main();
      usegui frame = new usegui(obj);
      frame.setLayout(null);
      frame.setVisible(true);
      frame.setBounds(100,100,800,800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

class usegui extends JFrame{

   JLabel l1 = new JLabel("CPU SCHEDULING ALGORITHMS");
   JLabel l2 = new JLabel("Enter the number of processes ");
   JTextField tf1 = new JTextField();
   JLabel l3 = new JLabel("SELECT YOUR CHOICE FOR THE INPUT : ");
   JButton b1 =new JButton("USER INPUT");
   JButton b2 = new JButton("RANDOM INPUT");

   JLabel lh1=new JLabel("PROCESS NUMBER");
   JLabel lh2=new JLabel("ARRIVAL TIME");
   JLabel lh3=new JLabel("BURST TIME");

   JLabel lpno[] = new JLabel[10];
   JLabel lat[] = new JLabel[10];
   JLabel lbt[] = new JLabel[10];

   JLabel choice = new JLabel("CHOOSE THE CPU SCHEDULING ALGORITHMS : ");
   JButton fcfs = new JButton("FCFS");
   JButton sjf =new JButton("SJF");
   JButton RoundRobin = new JButton("ROUND ROBIN");

   JLabel tq = new JLabel("ENTER TIME QUANTUM FOR RR");
   JTextField tqfield =new JTextField();

   usegui(main obj){



      Font f1 = new Font("Arial",Font.BOLD,25);
      Font f2 = new Font("Arial",Font.BOLD,15);
      Font f3 = new Font("Arial",Font.BOLD,17);
      Font f4 = new Font("Arial",Font.PLAIN,15);



      l1.setFont(f1);
      l2.setFont(f2);
      l3.setFont(f3);
      tf1.setFont(f4);
      b1.setFont(f4);
      b2.setFont(f4);
      lh1.setFont(f3);
      lh1.setBackground(new Color(95,158,160));
      lh1.setOpaque(true);
      lh2.setFont(f3);
      lh2.setBackground(new Color(95,158,160));
      lh2.setOpaque(true);
      lh3.setFont(f3);
      lh3.setBackground(new Color(95,158,160));
      lh3.setOpaque(true);
      for(int i=0;i<10;i++){
        lpno[i] = new JLabel("-");
        lpno[i].setFont(f4);
        lpno[i].setBackground(new Color(176,224,230));
        lpno[i].setOpaque(true);
        lbt[i] = new JLabel("- ");
        lbt[i].setFont(f4);
        lbt[i].setBackground(new Color(176,224,230));
        lbt[i].setOpaque(true);
        lat[i] = new JLabel("- ");
        lat[i].setFont(f4);
        lat[i].setBackground(new Color(176,224,230));
        lat[i].setOpaque(true);
      }
      choice.setFont(f3);
      fcfs.setFont(f4);
      sjf.setFont(f4);
      RoundRobin.setFont(f4);

      l1.setBounds(180,10,500,40);
      l2.setBounds(100,70,300,30);
      tf1.setBounds(350,70,100,30);
      l3.setBounds(80,120,400,30);
      b1.setBounds(410,120,180,30);
      b2.setBounds(600,120,180,30);

      lh1.setBounds(80,200,200,30);
      lh2.setBounds(280,200,200,30);
      lh3.setBounds(480,200,200,30);

      int y=230;
      for(int i=0;i<10;i++){
        lpno[i].setBounds(80,y,200,30);
        lat[i].setBounds(280,y,200,30);
        lbt[i].setBounds(480,y,200,30);
        y=y+30;
      }

      choice.setBounds(80,550,500,30);
      fcfs.setBounds(80,670,150,30);
      sjf.setBounds(250,670,150,30);
      RoundRobin.setBounds(420,670,150,30);

      tq.setFont(f2);
      tqfield.setFont(f3);
      tq.setBounds(80,610,400,30);
      tqfield.setBounds(420,610,150,30);


      add(l1);
      add(l2);
      add(tf1);
      add(l3);
      add(b1);
      add(b2);

      add(lh1);
      add(lh2);
      add(lh3);
      for(int i=0;i<10;i++){
        add(lpno[i]);
        add(lat[i]);
        add(lbt[i]);
      }
      add(choice);
      add(fcfs);
      add(sjf);
      add(RoundRobin);
      add(tq);
      add(tqfield);


      usegui objgui =this;

      b1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae){
          try{
            if(Integer.parseInt(tf1.getText())<1 || Integer.parseInt(tf1.getText())>10){
              throw new myexception("Process number should be b/w 1 to 10");
            }
            obj.n=Integer.parseInt(tf1.getText());
            obj.clear();
            reset();
            new userinput(objgui,obj);
          }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(objgui,"Enter only Integer values");
            System.out.println(e);
          }catch(myexception e){
              JOptionPane.showMessageDialog(objgui,"Process number should be b/w 1 to 10");
              System.out.println(e);
          }catch(Exception e){
              JOptionPane.showMessageDialog(objgui,"Invalid Entry");
              System.out.println(e);
          }

        }
      }

      );

      b2.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae){
          try{
            if(Integer.parseInt(tf1.getText())<1 || Integer.parseInt(tf1.getText())>10){
              throw new myexception("Process number should be b/w 1 to 10");
            }
          obj.n=Integer.parseInt(tf1.getText());
          obj.clear();
          reset();
          obj.read_random();
        }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(objgui,"Enter only Integer values");
          System.out.println(e);
        }catch(myexception e){
            JOptionPane.showMessageDialog(objgui,"Process number should be b/w 1 to 10");
            System.out.println(e);
        }catch(Exception e){
            JOptionPane.showMessageDialog(objgui,"Invalid Entry");
            System.out.println(e);
        }

          for(int i=0 ;i<obj.n;i++){
            lpno[i].setText(obj.pno.get(i).toString());
            lat[i].setText(obj.at.get(i).toString());
            lbt[i].setText(obj.bt.get(i).toString());
          }

        }
      }
      );

      fcfs.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e){
          new FCFS(obj);

        }
      }
      );

      sjf.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e){
          new SJF(obj);

        }
      }

      );

      RoundRobin.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ae){
          try{
            if(Integer.parseInt(tqfield.getText())<1){
              throw new myexception("Time Quantum should be > 0");
            }
              obj.tq=Integer.parseInt(tqfield.getText());
              new RR(obj);
            }
            catch(NumberFormatException e){
              JOptionPane.showMessageDialog(objgui,"Enter only Integer values");
              System.out.println(e);
            }catch(myexception e){
                JOptionPane.showMessageDialog(objgui,"Time Quantum should be > 0");
                System.out.println(e);
            }catch(Exception e){
                JOptionPane.showMessageDialog(objgui,"Invalid Entry");
                System.out.println(e);
            }
        }
      }
      );

   }

   void reset(){
     for(int i=0;i<10;i++){
       lpno[i].setText("-");
       lbt[i].setText("- ");
       lat[i].setText("- ");
     }
   }

}

class userinput extends JFrame{
  JLabel l = new JLabel("ENTER THE INPUTS: ");
  JLabel l1=new JLabel("PROCESS NUMBER");
  JLabel l2=new JLabel("ARRIVAL TIME");
  JLabel l3=new JLabel("BURST TIME");
  JTextField tpno[] = new JTextField[10];
  JTextField tbt[] = new JTextField[10];
  JTextField tat[] = new JTextField[10];
  JButton submit = new JButton("SUBMIT");
  JButton reset = new JButton("RESET");

  userinput(usegui obj1,main obj){
    Font f1 = new Font("Arial",Font.BOLD,15);
    Font f2 = new Font("Arial",Font.BOLD,17);
    Font f3 = new Font("Arial",Font.PLAIN,15);

    l.setFont(f2);
    l1.setFont(f2);
    l2.setFont(f2);
    l3.setFont(f2);
    for(int i=0;i<obj.n;i++){
      tpno[i] = new JTextField();
      tpno[i].setFont(f3);
      tbt[i] = new JTextField();
      tbt[i].setFont(f3);
      tat[i] = new JTextField();
      tat[i].setFont(f3);
    }
    submit.setFont(f3);
    reset.setFont(f3);

    int x=150;
    l.setBounds(50,20,400,30);
    l1.setBounds(50,100,200,30);
    l2.setBounds(280,100,200,30);
    l3.setBounds(500,100,200,30);
    for(int i=0;i<obj.n;i++){
      tpno[i].setBounds(50,x,200,30);
      tat[i].setBounds(280,x,200,30);
      tbt[i].setBounds(500,x,200,30);
      x=x+50;
    }
    submit.setBounds(200,x,150,30);
    reset.setBounds(500,x,150,30);

    add(l);
    add(l1);
    add(l2);
    add(l3);
    for(int i=0;i<obj.n;i++){
      add(tpno[i]);
      add(tat[i]);
      add(tbt[i]);
    }
    add(submit);
    add(reset);
     userinput objinput=this;
    submit.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent ae){
        try{
        for(int i=0;i<obj.n;i++){

            if(Integer.parseInt(tpno[i].getText())<0  || Integer.parseInt(tat[i].getText())<0  || Integer.parseInt(tbt[i].getText())<0 ){
              throw new myexception("Please enter positive number");
            }
           obj.pno.add(Integer.parseInt(tpno[i].getText()));
           obj.at.add(Integer.parseInt(tat[i].getText()));
           obj.bt.add(Integer.parseInt(tbt[i].getText()));
           obj.atime.add(0);

        }
        for(int i=0 ;i<obj.n;i++){
          obj1.lpno[i].setText(obj.pno.get(i).toString());
          obj1.lat[i].setText(obj.at.get(i).toString());
          obj1.lbt[i].setText(obj.bt.get(i).toString());
        }
      }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(objinput,"Enter only Integer values");
        System.out.println(e);
      }catch(myexception e){
          JOptionPane.showMessageDialog(objinput,"Please enter positive number");
          System.out.println(e);
      }catch(Exception e){
          JOptionPane.showMessageDialog(objinput,"Invalid Entry");
          System.out.println(e);
      }
        dispose();
      }
    }
    );
    reset.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        for(int i=0;i<obj.n;i++){
          tpno[i].setText("");
          tat[i].setText("");
          tbt[i].setText("");
        }
      }
    }
    );

    setLayout(null);
    setVisible(true);
    setBounds(100,100,800,800);
  }
}

class FCFS extends JFrame{
  JLabel head = new JLabel("FIRST COME FIRST SIRVE (FCFS)");
  JLabel h1 = new JLabel("PROCESS NO.");
  JLabel h2 = new JLabel("ARRIVAL TIME");
  JLabel h3 = new JLabel("BURST TIME");
  JLabel h4 = new JLabel("WAITING TIME");
  JLabel h5 = new JLabel("TURN AROUND TIME");
  JLabel h6 = new JLabel("COMPLETION TIME");
  JLabel pno[] = new JLabel[10];
  JLabel at[] = new JLabel[10];
  JLabel bt[] = new JLabel[10];
  JLabel wt[] = new JLabel[10];
  JLabel tat[] = new JLabel[10];
  JLabel ct[] = new JLabel[10];
  JLabel l1 = new JLabel("AVERAGE WAITING TIME : ");
  JLabel l2 = new JLabel("AVERAGE TURN AROUND TIME : ");



  FCFS(main obj){

    fcfs f = new fcfs(obj.n,obj.pno,obj.at,obj.bt);
    f.schedule();

    JLabel gpno[] = new JLabel[obj.n];
    JLabel gtime[] =new JLabel[obj.n];

    JLabel Atat = new JLabel(String.valueOf(f.Atat));
    JLabel Awt = new JLabel(String.valueOf(f.Awt));
    Font f1 = new Font("Arial",Font.BOLD,25);
    Font f2 = new Font("Arial",Font.BOLD,15);
    Font f3 = new Font("Arial",Font.PLAIN,15);

    head.setFont(f1);
    h1.setFont(f2);
    h1.setBackground(new Color(95,158,160));
    h1.setOpaque(true);
    h2.setFont(f2);
    h2.setBackground(new Color(95,158,160));
    h2.setOpaque(true);
    h3.setFont(f2);
    h3.setBackground(new Color(95,158,160));
    h3.setOpaque(true);
    h4.setFont(f2);
    h4.setBackground(new Color(95,158,160));
    h4.setOpaque(true);
    h5.setFont(f2);
    h5.setBackground(new Color(95,158,160));
    h5.setOpaque(true);
    h6.setFont(f2);
    h6.setBackground(new Color(95,158,160));
    h6.setOpaque(true);
    int y=80;
    for(int i=0;i<obj.n;i++){
      pno[i]=new JLabel(obj.pno.get(i).toString());
      pno[i].setFont(f3);
      pno[i].setBackground(new Color(176,224,230));
      pno[i].setOpaque(true);
      pno[i].setBounds(20,y,250,30);



      at[i]=new JLabel(obj.at.get(i).toString());
      at[i].setFont(f3);
      at[i].setBackground(new Color(176,224,230));
      at[i].setOpaque(true);
      at[i].setBounds(270,y,250,30);

      bt[i]=new JLabel(obj.bt.get(i).toString());
      bt[i].setFont(f3);
      bt[i].setBackground(new Color(176,224,230));
      bt[i].setOpaque(true);
      bt[i].setBounds(520,y,250,30);

      wt[i]=new JLabel(f.fcfs_wt.get(i).toString());
      wt[i].setFont(f3);
      wt[i].setBackground(new Color(176,224,230));
      wt[i].setOpaque(true);
      wt[i].setBounds(770,y,250,30);

      tat[i]=new JLabel(f.fcfs_tat.get(i).toString());
      tat[i].setFont(f3);
      tat[i].setBackground(new Color(176,224,230));
      tat[i].setOpaque(true);
      tat[i].setBounds(1020,y,250,30);

      ct[i]=new JLabel(f.fcfs_ct.get(i).toString());
      ct[i].setFont(f3);
      ct[i].setBackground(new Color(176,224,230));
      ct[i].setOpaque(true);
      ct[i].setBounds(1270,y,250,30);

      y+=30;
    }
    l1.setFont(f2);
    l2.setFont(f2);
    Awt.setFont(f3);
    Atat.setFont(f3);

    Color clr[] = new Color[10];

    clr[0]=new Color(255,99,71);
    clr[1]=new Color(188,143,143);
    clr[2]=new Color(240,230,140);
    clr[3]=new Color(154,205,50);
    clr[4]=new Color(152,251,152);
    clr[5]=new Color(0,250,154);
    clr[6]=new Color(102,205,170);
    clr[7]=new Color(0,206,209);
    clr[8]=new Color(175,238,238);
    clr[9]=new Color(148,0,211);

    JLabel gchart = new JLabel("GANTT CHART :");
    gchart.setFont(f1);
    gchart.setBounds(50,530,400,30);

    JLabel zero = new JLabel("0");
    zero.setFont(f2);
    zero.setBounds(46,630,50,30);
    int x=50,x1=96;
    for(int i=0;i<obj.n;i++){
      gpno[i]=new JLabel("P"+obj.pno.get(i).toString());
      gpno[i].setFont(f2);
      gpno[i].setBackground(clr[i]);
      gpno[i].setOpaque(true);
      gpno[i].setBounds(x,600,50,30);

      gtime[i]=new JLabel(f.fcfs_ct.get(i).toString());
      gtime[i].setFont(f2);
      gtime[i].setBounds(x1,630,50,30);
      x1=x1+50;
      x=x+50;
    }



    head.setBounds(20,20,500,30);
    h1.setBounds(20,50,250,30);
    h2.setBounds(270,50,250,30);
    h3.setBounds(520,50,250,30);
    h4.setBounds(770,50,250,30);
    h5.setBounds(1020,50,250,30);
    h6.setBounds(1270,50,250,30);
    l1.setBounds(50,430,350,30);
    Awt.setBounds(250,430,100,30);
    l2.setBounds(50,470,350,30);
    Atat.setBounds(300,470,100,30);

    add(head);
    add(h1);
    add(h2);
    add(h3);
    add(h4);
    add(h5);
    add(h6);
    for(int i=0;i<obj.n;i++){
      add(pno[i]);
      add(at[i]);
      add(bt[i]);
      add(wt[i]);
      add(tat[i]);
      add(ct[i]);
      add(gpno[i]);
      add(gtime[i]);
    }
    add(zero);
    add(l1);
    add(l2);
    add(Awt);
    add(Atat);
    add(gchart);

    setLayout(null);
    setVisible(true);
    setBounds(0,0,1700,800);
  }
}

class SJF extends JFrame{
  JLabel head = new JLabel("SHORTEST JOB FIRST (SJF)");
  JLabel h1 = new JLabel("PROCESS NO.");
  JLabel h2 = new JLabel("ARRIVAL TIME");
  JLabel h3 = new JLabel("BURST TIME");
  JLabel h4 = new JLabel("WAITING TIME");
  JLabel h5 = new JLabel("TURN AROUND TIME");
  JLabel h6 = new JLabel("COMPLETION TIME");
  JLabel pno[] = new JLabel[10];
  JLabel at[] = new JLabel[10];
  JLabel bt[] = new JLabel[10];
  JLabel wt[] = new JLabel[10];
  JLabel tat[] = new JLabel[10];
  JLabel ct[] = new JLabel[10];
  JLabel l1 = new JLabel("AVERAGE WAITING TIME : ");
  JLabel l2 = new JLabel("AVERAGE TURN AROUND TIME : ");
 SJF(main obj){

   sjf s = new sjf(obj.n,obj.pno,obj.at,obj.bt);
   s.schedule();

   JLabel gpno[] = new JLabel[obj.n];
   JLabel gtime[] =new JLabel[obj.n];

   JLabel Atat = new JLabel(String.valueOf(s.Atat));
   JLabel Awt = new JLabel(String.valueOf(s.Awt));
   Font f1 = new Font("Arial",Font.BOLD,25);
   Font f2 = new Font("Arial",Font.BOLD,15);
   Font f3 = new Font("Arial",Font.PLAIN,15);

   head.setFont(f1);
   h1.setFont(f2);
   h1.setBackground(new Color(95,158,160));
   h1.setOpaque(true);
   h2.setFont(f2);
   h2.setBackground(new Color(95,158,160));
   h2.setOpaque(true);
   h3.setFont(f2);
   h3.setBackground(new Color(95,158,160));
   h3.setOpaque(true);
   h4.setFont(f2);
   h4.setBackground(new Color(95,158,160));
   h4.setOpaque(true);
   h5.setFont(f2);
   h5.setBackground(new Color(95,158,160));
   h5.setOpaque(true);
   h6.setFont(f2);
   h6.setBackground(new Color(95,158,160));
   h6.setOpaque(true);
   int y=80;
   for(int i=0;i<obj.n;i++){
     pno[i]=new JLabel(obj.pno.get(i).toString());
     pno[i].setFont(f3);
     pno[i].setBackground(new Color(176,224,230));
     pno[i].setOpaque(true);
     pno[i].setBounds(20,y,250,30);



     at[i]=new JLabel(obj.at.get(i).toString());
     at[i].setFont(f3);
     at[i].setBackground(new Color(176,224,230));
     at[i].setOpaque(true);
     at[i].setBounds(270,y,250,30);

     bt[i]=new JLabel(obj.bt.get(i).toString());
     bt[i].setFont(f3);
     bt[i].setBackground(new Color(176,224,230));
     bt[i].setOpaque(true);
     bt[i].setBounds(520,y,250,30);

     wt[i]=new JLabel(s.sjf_wt.get(i).toString());
     wt[i].setFont(f3);
     wt[i].setBackground(new Color(176,224,230));
     wt[i].setOpaque(true);
     wt[i].setBounds(770,y,250,30);

     tat[i]=new JLabel(s.sjf_tat.get(i).toString());
     tat[i].setFont(f3);
     tat[i].setBackground(new Color(176,224,230));
     tat[i].setOpaque(true);
     tat[i].setBounds(1020,y,250,30);

     ct[i]=new JLabel(s.sjf_ct.get(i).toString());
     ct[i].setFont(f3);
     ct[i].setBackground(new Color(176,224,230));
     ct[i].setOpaque(true);
     ct[i].setBounds(1270,y,250,30);

     y+=30;
   }
   l1.setFont(f2);
   l2.setFont(f2);
   Awt.setFont(f3);
   Atat.setFont(f3);

   Color clr[] = new Color[10];

   clr[0]=new Color(255,99,71);
   clr[1]=new Color(188,143,143);
   clr[2]=new Color(240,230,140);
   clr[3]=new Color(154,205,50);
   clr[4]=new Color(152,251,152);
   clr[5]=new Color(0,250,154);
   clr[6]=new Color(102,205,170);
   clr[7]=new Color(0,206,209);
   clr[8]=new Color(175,238,238);
   clr[9]=new Color(148,0,211);

   JLabel gchart = new JLabel("GANTT CHART :");
   gchart.setFont(f1);
   gchart.setBounds(50,530,400,30);

   JLabel zero = new JLabel("0");
   zero.setFont(f2);
   zero.setBounds(46,630,50,30);
   int x=50,x1=96,z;
   for(int i=0;i<obj.n;i++){
     gpno[i]=new JLabel("P"+s.sjf_gpno.get(i).toString());
     gpno[i].setFont(f2);
     z=s.sjf_gpno.get(i);

     for(int j=0;j<obj.n;j++){
       if(obj.pno.get(j) == z){
         gpno[i].setBackground(clr[j]);
       }
     }
     gpno[i].setOpaque(true);
     gpno[i].setBounds(x,600,50,30);

     gtime[i]=new JLabel(s.sjf_gct.get(i).toString());
     gtime[i].setFont(f2);
     gtime[i].setBounds(x1,630,50,30);
     x1=x1+50;
     x=x+50;
   }

   head.setBounds(20,20,500,30);
   h1.setBounds(20,50,250,30);
   h2.setBounds(270,50,250,30);
   h3.setBounds(520,50,250,30);
   h4.setBounds(770,50,250,30);
   h5.setBounds(1020,50,250,30);
   h6.setBounds(1270,50,250,30);
   l1.setBounds(50,430,350,30);
   Awt.setBounds(250,430,100,30);
   l2.setBounds(50,470,350,30);
   Atat.setBounds(300,470,100,30);

   add(head);
   add(h1);
   add(h2);
   add(h3);
   add(h4);
   add(h5);
   add(h6);
   for(int i=0;i<obj.n;i++){
     add(pno[i]);
     add(at[i]);
     add(bt[i]);
     add(wt[i]);
     add(tat[i]);
     add(ct[i]);
     add(gpno[i]);
     add(gtime[i]);
   }
   add(zero);
   add(l1);
   add(l2);
   add(Awt);
   add(Atat);
   add(gchart);

   setLayout(null);
   setVisible(true);
   setBounds(0,0,1700,800);
 }
}

class RR extends JFrame{
  JLabel head = new JLabel("ROUND ROBIN (consider AT=0)");

  JLabel h1 = new JLabel("PROCESS NO.");
  JLabel h2 = new JLabel("ARRIVAL TIME");
  JLabel h3 = new JLabel("BURST TIME");
  JLabel h4 = new JLabel("WAITING TIME");
  JLabel h5 = new JLabel("TURN AROUND TIME");
  JLabel h6 = new JLabel("COMPLETION TIME");
  JLabel pno[] = new JLabel[10];
  JLabel at[] = new JLabel[10];
  JLabel bt[] = new JLabel[10];
  JLabel wt[] = new JLabel[10];
  JLabel tat[] = new JLabel[10];
  JLabel ct[] = new JLabel[10];
  JLabel l1 = new JLabel("AVERAGE WAITING TIME : ");
  JLabel l2 = new JLabel("AVERAGE TURN AROUND TIME : ");
  RR(main obj){

    Font f1 = new Font("Arial",Font.BOLD,25);
    Font f2 = new Font("Arial",Font.BOLD,15);
    Font f3 = new Font("Arial",Font.PLAIN,15);



    roundrobin r = new roundrobin(obj.n,obj.pno,obj.atime,obj.bt,obj.tq);

    r.schedule();

    JLabel gpno[] = new JLabel[r.itr];
    JLabel gtime[] =new JLabel[r.itr];

    JLabel Atat = new JLabel(String.valueOf(r.Atat));
    JLabel Awt = new JLabel(String.valueOf(r.Awt));


    head.setFont(f1);
    h1.setFont(f2);
    h1.setBackground(new Color(95,158,160));
    h1.setOpaque(true);
    h2.setFont(f2);
    h2.setBackground(new Color(95,158,160));
    h2.setOpaque(true);
    h3.setFont(f2);
    h3.setBackground(new Color(95,158,160));
    h3.setOpaque(true);
    h4.setFont(f2);
    h4.setBackground(new Color(95,158,160));
    h4.setOpaque(true);
    h5.setFont(f2);
    h5.setBackground(new Color(95,158,160));
    h5.setOpaque(true);
    h6.setFont(f2);
    h6.setBackground(new Color(95,158,160));
    h6.setOpaque(true);

    int y=80;
    for(int i=0;i<obj.n;i++){
      pno[i]=new JLabel(obj.pno.get(i).toString());
      pno[i].setFont(f3);
      pno[i].setBackground(new Color(176,224,230));
      pno[i].setOpaque(true);
      pno[i].setBounds(20,y,250,30);

      at[i]=new JLabel("0");
      at[i].setFont(f3);
      at[i].setBackground(new Color(176,224,230));
      at[i].setOpaque(true);
      at[i].setBounds(270,y,250,30);

      bt[i]=new JLabel(obj.bt.get(i).toString());
      bt[i].setFont(f3);
      bt[i].setBackground(new Color(176,224,230));
      bt[i].setOpaque(true);
      bt[i].setBounds(520,y,250,30);

      wt[i]=new JLabel(r.rr_wt.get(i).toString());
      wt[i].setFont(f3);
      wt[i].setBackground(new Color(176,224,230));
      wt[i].setOpaque(true);
      wt[i].setBounds(770,y,250,30);

      tat[i]=new JLabel(r.rr_tat.get(i).toString());
      tat[i].setFont(f3);
      tat[i].setBackground(new Color(176,224,230));
      tat[i].setOpaque(true);
      tat[i].setBounds(1020,y,250,30);

      ct[i]=new JLabel(r.rr_ct.get(i).toString());
      ct[i].setFont(f3);
      ct[i].setBackground(new Color(176,224,230));
      ct[i].setOpaque(true);
      ct[i].setBounds(1270,y,250,30);

      y+=30;
    }
    l1.setFont(f2);
    l2.setFont(f2);
    Awt.setFont(f3);
    Atat.setFont(f3);

    Color clr[] = new Color[10];

    clr[0]=new Color(255,99,71);
    clr[1]=new Color(188,143,143);
    clr[2]=new Color(240,230,140);
    clr[3]=new Color(154,205,50);
    clr[4]=new Color(152,251,152);
    clr[5]=new Color(0,250,154);
    clr[6]=new Color(102,205,170);
    clr[7]=new Color(0,206,209);
    clr[8]=new Color(175,238,238);
    clr[9]=new Color(148,0,211);


    JLabel gchart = new JLabel("GANTT CHART :");
    gchart.setFont(f1);
    gchart.setBounds(50,530,400,30);

    JLabel zero = new JLabel("0");
    zero.setFont(f2);
    zero.setBounds(46,630,50,30);
    int x=50,x1=96,z;
    for(int i=0;i<r.itr;i++){
      gpno[i]=new JLabel("P"+r.rr_gpno.get(i).toString());
      gpno[i].setFont(f2);
      z=r.rr_gpno.get(i);

      for(int j=0;j<obj.n;j++){
        if(obj.pno.get(j) == z){
          gpno[i].setBackground(clr[j]);
        }
      }


      gpno[i].setOpaque(true);
      gpno[i].setBounds(x,600,50,30);

      gtime[i]=new JLabel(r.rr_gct.get(i).toString());
      gtime[i].setFont(f2);
      gtime[i].setBounds(x1,630,50,30);
      x1=x1+50;
      x=x+50;
    }
    head.setBounds(20,20,500,30);
    h1.setBounds(20,50,250,30);
    h2.setBounds(270,50,250,30);
    h3.setBounds(520,50,250,30);
    h4.setBounds(770,50,250,30);
    h5.setBounds(1020,50,250,30);
    h6.setBounds(1270,50,250,30);
    l1.setBounds(50,430,350,30);
    Awt.setBounds(250,430,100,30);
    l2.setBounds(50,470,350,30);
    Atat.setBounds(300,470,100,30);

    add(head);


    add(h1);
    add(h2);
    add(h3);
    add(h4);
    add(h5);
    add(h6);
    for(int i=0;i<obj.n;i++){
      add(pno[i]);
      add(at[i]);
      add(bt[i]);
      add(wt[i]);
      add(tat[i]);
      add(ct[i]);
    }
    for(int i=0;i<r.itr;i++){
      add(gpno[i]);
      add(gtime[i]);

    }
    add(zero);
    add(l1);
    add(l2);
    add(Awt);
    add(Atat);
    add(gchart);


    setLayout(null);
    setVisible(true);
    setBounds(0,0,1700,800);
  }
}
