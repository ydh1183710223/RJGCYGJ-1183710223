package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Exception.IllegalCharacterException;
import Exception.OutstepException;

public class ApplyT  implements ActionListener{
	JFrame window;
	JLabel sum;
	JLabel right;
	JLabel wrong;
	JLabel number;
	JLabel time;
	JLabel answer;
	JLabel lineOne;
	JLabel lineTwo;
	JLabel ask;
	JLabel range;
	JTextField JRange;
	JTextField JSum;
	JTextField subject;
	JTextField finish;
	JTextField jNumber;
	JTextField JTime;
	JButton make;
	JButton end;
	JButton ok;
	JButton next;
	JButton before;
	JButton jump;
	
  	JFrame makesubject;
  	JTextField JTestTime;
  	JScrollPane jsp;
  	JMenuBar jb;
  	
	JButton[] n = new JButton[10];
	
	public List<String> question ;//��Ŀ
	public List<Integer> key ;//��
	public List<Integer> WCollect;//���⼯��
	public String[] hand;//�����¼
	public String[] judge;//���м�¼
	public int[] wither;//��Ŀ�������
	public int mark = 1;//�����
	public int mRight = 0;//�����
	public int mWrong = 0;//�����
	public int all=0;//������
	public int h1=0;
	public int h2=0;
	public int m1=0;
	public int m2=0;
	public int s1=0;
	public int s2=0;
	public int operate=0;
	public int TestTime=-1;
	Timer timer;//��ʱ��
	TimerTask timerTask;
	Logger logger ;
	public ApplyT ()
	{
		makeui();
		lay();
		log();
	}
		
	public void SetTestTime(String Ttime) throws IllegalCharacterException, OutstepException
	{
		if(Ttime.isEmpty())
		{
			TestTime=-1;
		}else
		{
			for(int i =0;i<Ttime.length();i++)
			{
				if(Ttime.charAt(i)<48||Ttime.charAt(i)>57)
					throw new IllegalCharacterException();
			}
			int n = Integer.parseInt(Ttime);
			if(n<=0) throw new OutstepException("�����뷶Χ���������");
			else TestTime=n;
		}
	}
		public void actionPerformed(ActionEvent e) {//�¼���������������ת����
			try {
			if(e.getSource()==make)//������Ŀ
			{
				String num = JSum.getText().trim();//����
				String ran = JRange.getText().trim();//���㷶Χ
				String Ttime=JTestTime.getText().trim();//����ʱ��
				SetTestTime(Ttime);
					Generate(num,ran);
				
				makesubject.setVisible(false);
				window.setTitle("100���ڼӼ�����������:"+num+")");
				window.setVisible(true);
			}
			} catch (IllegalCharacterException e1) {
					
				} catch (OutstepException e1) {
					makesubject.setTitle(e1.getMessage());
				}	
		try {	
			 if(e.getSource()==ok) //ȷ�ϼ�
			{
				String an = finish.getText().trim();
				confirm(an);
			}
			else if(e.getSource()==next)//��һ��
			{
				nextSubject();
			}
			else if(e.getSource()==before)//��һ��
			{
				lastSubject();
			}
			else if(e.getSource()==jump) //��ת
			{
				String num = jNumber.getText().trim();
				jumpSubject(num);
			}
			else if(e.getSource()==end)//����
			{
				end();
			}
			else if(e.getSource()==n[0])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+0);
			}
			else if(e.getSource()==n[1])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+1);
			}
			else if(e.getSource()==n[2])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+2);
			}
			else if(e.getSource()==n[3])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+3);
			}
			else if(e.getSource()==n[4])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+4);
			}
			else if(e.getSource()==n[5])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+5);
			}
			else if(e.getSource()==n[6])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+6);
			}
			else if(e.getSource()==n[7])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+7);
			}
			else if(e.getSource()==n[8])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+8);
			}
			else if(e.getSource()==n[9])
			{
				if(operate==1&&wither[mark]==0)
				finish.setText(finish.getText()+9);
			}
		} catch (IllegalCharacterException e1) {
			
		} catch (OutstepException e1) {
			window.setTitle(e1.getMessage());
		}
		}
		public void Generate(String num,String ran) throws IllegalCharacterException //������Ŀ
, OutstepException
		{
			
			
				if(num.isEmpty()) throw new IllegalCharacterException();
			char[] cnum = num.toCharArray();    
			for(int i =0;i<cnum.length;i++)
			{
				if(cnum[i]<48||cnum[i]>57)
					throw new IllegalCharacterException();
			}
			int n = Integer.parseInt(num);
			if(n<=0) throw new OutstepException("�����뷶Χ���������");
			all = n;
			
			
			if(ran.isEmpty()) throw new IllegalCharacterException();
			char[] cran = ran.toCharArray();
			for(int i =0;i<cran.length;i++)
			{
				if(cran[i]<48||cran[i]>57)
					throw new IllegalCharacterException();
			}
			int r = Integer.parseInt(ran);
			if(r<=2) throw new OutstepException("�����뷶Χ���������");
			
			makesubject.setTitle("100���ڼӼ�����ϰ���");
			operate = 1;
			
			question = new ArrayList<String>();//��Ŀ
			key = new ArrayList<Integer>();//��
			WCollect = new ArrayList<Integer>();//���⼯��
			
			JSum.setEditable(false);
			JRange.setEditable(false);
			
			JTime.setText(""+h1+h2+":"+m1+m2+":"+s1+s2);
			
			hand = new String[n+1];
			judge = new String[n+1];
			wither = new int[n+1];
			
			Random random = new Random();  //����
			int i = 1;
			for(i=1;i<=n;i++)
			{
				int a = random.nextInt(r-1)+1;
				int b = random.nextInt(r-1)+1;
				int c = random.nextInt(2);
				if(c==0) 
				{
					if(a-b<0)
					{
						question.add(b+"-"+a);
						key.add(b-a);
					}
					else 
					{
						question.add(a+"-"+b);
						key.add(a-b);
					}
				}
				else if(c==1)
				{
					if(a+b>=r) i=i-1;
					else 
					{
						question.add(a+"+"+b);
						key.add(a+b);
					}
				}
			}
			subject.setText(question.get(0));
			right.setText("���������0");
			wrong.setText("���������0");
			number.setText("����ţ�1");
			timing();
		}
      public void timing() //��ʱ
      {
    	  timerTask = new TimerTask() {
				@Override
				public void run() {
					s2++;
			    	if(s2==10)
			    	{
			    		s2 = 0;
			    		s1++;
			    		if(s1==6)
			    	{
			    		s1 = 0;
			    		m2++;
			    		if(m2==10)
			    	{
			    		m2 = 0;
			    		m1 ++;
			    		if(m1==6)
			    	{
			    		m1 = 0;
			    		h2++;
			    		if(h2==10)
			    	{
			    		h2 = 0;
			    		h1++;
			    		if(h1==10)
			    	{
			    		h1 = 0;
			    		h2 = 0;
			    		m1 = 0;
			    		m2 = 0;
			    		s1 = 0;
			    		s2 = 0;
			    	}}}}}}
			    	JTime.setText(""+h1+h2+":"+m1+m2+":"+s1+s2);
			    	if(TestTime>0)
			    	if((h1+h2)*60+m1*10+m2>=TestTime)
			    	{
			    		end();
			    	}
			    }
			};
			
			timer = new Timer();
	        timer.schedule(timerTask, 1000, 1000);  //1���ִ�У�����ÿ��100�����ظ�ִ��
	         
      }
      public void confirm(String an) throws IllegalCharacterException
      {
    	 
    	  int w = 0;
    	  if(operate==1&&wither[mark] == 0)//ȷ���ύ���Ĳ������ύ
			{
			if(an.isEmpty()) throw new IllegalCharacterException() ;
			hand[mark] = an;
			char[] can = an.toCharArray();
			for(int i=0;i<can.length;i++)
			{
				if(can[i]<48||can[i]>57)
				{
					wither[mark] = -1;
					answer.setText("�����Ϊ"+key.get(mark-1));
					answer.setForeground(Color.RED);
					mWrong++;
					wrong.setText("���������"+mWrong);
					WCollect.add(mark);
					w=1;
					break;
				}
			}
			if(w==0)
			{
				int a = Integer.parseInt(an);
			if(a==key.get(mark-1))
			{
				wither[mark] = 1;
				answer.setText("��");
				answer.setForeground(Color.GREEN);
				mRight++;
				right.setText("���������"+mRight);
			}
			else 
			{
				wither[mark] = -1;
				answer.setText("�����Ϊ"+key.get(mark-1));
				answer.setForeground(Color.RED);
				mWrong++;
				wrong.setText("���������"+mWrong);
				WCollect.add(mark);
			}
			
			}
			
			judge[mark] = answer.getText();
			}
    	  
      }
      public void nextSubject()//��һ��ʵ�ַ���
      {
    	  if(mark<all)
			{
				mark++;
			    subject.setText(question.get(mark-1));
			    answer.setText(judge[mark]);
			   // if(wither[mark]!=0) finish.setEditable(false);
			    //else finish.setEditable(true);
			    if(wither[mark]==1) answer.setForeground(Color.GREEN);
			    else if(wither[mark]==-1) answer.setForeground(Color.RED);
			    finish.setText(hand[mark]);
			    number.setText("����ţ�"+mark);
			}
      }
      public void lastSubject()//��һ��ʵ�ַ���
      {
    	  if(mark>1)
			{
				mark--;
				subject.setText(question.get(mark-1));
				answer.setText(judge[mark]);
				//if(wither[mark]!=0) finish.setEditable(false);
			    //else finish.setEditable(true);
				if(wither[mark]==1) answer.setForeground(Color.GREEN);
			    else if(wither[mark]==-1) answer.setForeground(Color.RED);
				finish.setText(hand[mark]);
				number.setText("����ţ�"+mark);
			}
      }
      public void jumpSubject(String num) throws IllegalCharacterException, OutstepException//��ת����ʵ�ַ���
      {
    	  
    		  if(operate==1)
    		  {
    			   if(num.isEmpty()) throw new IllegalCharacterException();
    	    char[] cnum = num.toCharArray();
    	    for(int i=0;i<cnum.length;i++)
    	    {
    	    	if(cnum[i]<48||cnum[i]>57)
    	    	{
    	    		throw new IllegalCharacterException();
    	    	}
    	    }
			int n = Integer.parseInt(num);
			if(n<=0||n>all) throw new OutstepException("���������Χ������");
			window.setTitle("100���ڼӼ�����������:"+all+")");
			mark = n;
			subject.setText(question.get(mark-1));
			answer.setText(judge[mark]);
			//if(wither[mark]!=0) finish.setEditable(false);
		    //else finish.setEditable(true);
			if(wither[mark]==1) answer.setForeground(Color.GREEN);
		    else if(wither[mark]==-1) answer.setForeground(Color.RED);
			finish.setText(hand[mark]);
			number.setText("����ţ�"+mark);
			
		    jNumber.setText("");
    		  }
    	    
      }
      public void end()
      {
    	  if(operate==1)
    	  {
    		  makesubject.setVisible(true);
    		  window.setVisible(false);
    		  timer.cancel();  //��ֹ��ʱ�������������Ѱ��ŵ�����
		     
		     JSum.setEditable(true);
			 JRange.setEditable(true);
			 //finish.setEditable(true);
			 
			answering();
		     
			JRange.setText("");
			subject.setText("");
			finish.setText("");
			answer.setText("");
			JSum.setText("");
			JTime.setText("");
			JTestTime.setText("");
			right.setText("���������");
			wrong.setText("���������");
			number.setText("����ţ�");
		
			mark = 1;//�����
			mRight = 0;//�����
			mWrong = 0;//�����
			all=0;//������
			h1=0;
		    h2=0;
			m1=0;
			m2=0;
			s1=0;
			s2=0;
			TestTime=-1;
			operate=0;
    	  }
    	  
      }
      public void answering() //���ɴ������
      {
    	  JFrame collect = new JFrame("�������");
		    collect.setSize(600,800);//���ô�С
		    collect.setLocationRelativeTo(null);//���þ���
		    collect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);////���ÿɹر�
		    collect.setVisible(true);
		    
		    JTextArea area = new JTextArea("");
		    
		    jb=new JMenuBar();
		    jsp=new JScrollPane(area);
		    
		    collect.setJMenuBar(jb);
		   
		    Font fC=new Font("����",Font.BOLD,20);
			area.setFont(fC);
			
			collect.add(jsp);
			
		    String y = "";
		    for(int i=0;i<WCollect.size();i++)
		    {
		    	int x = WCollect.get(i);
		    	y = y+"���"+x+": "+question.get(x-1)+"  ��Ĵ���"+hand[x]+"  ��ȷ����"+key.get(x-1)+"\n";
		    }
		    String y1 = "";
		    for(int i=1;i<=all;i++)
		    {
		    	
		    	if(wither[i]==0)
		    	{
		    		String t1="���"+i+": "+question.get(i-1);
			    	String t2="�𰸣�"+key.get(i-1);y1 = y1+t1;
		    		for(int j=1;j<=40-t1.length();j++)
		    		{
		    			y1=y1+" ";
		    		}
		    		y1=y1+t2+"\n";
		    	}
		    }
		    String e = "��ʱ"+JTime.getText()+"\n"+"������:"+all+"  �������:"+mRight+"  �������:"+mWrong+"  δ��������:"+(all-mRight-mWrong)+"\n\n"+"��Ĵ����ǣ�\n"+y+"\n"+"��δ�������Ŀ��\n"+y1;
		    area.setText(e);
		    area.setEditable(false);
		    area.setCaretPosition(0);
		    logger.info(e);
      }
      public void makeui()
      {
    	  	makesubject=new JFrame("100���ڼӼ���");
    	  	makesubject.setLayout(null);
    	  	makesubject.setSize(500, 300);
    		makesubject.setLocationRelativeTo(null);
    		
    		JLabel TestTime=new JLabel("�����ò���ʱ��(�ɲ���):");
    		TestTime.setBounds(30, 120, 250, 30);
    		Font JT=new Font("����",Font.BOLD,20);
    		TestTime.setFont(JT);
    		makesubject.add(TestTime);
    		
    		JLabel fenzhong=new JLabel("����");
    		fenzhong.setBounds(390, 120, 50, 30);
    		fenzhong.setFont(JT);
    		makesubject.add(fenzhong);
    		
    		JTestTime=new JTextField("");
    		JTestTime.setBounds(280, 120, 100, 30);
    		JTestTime.setFont(new Font("����",Font.BOLD,15));
    		makesubject.add(JTestTime);
    	  
    	  	JSum = new JTextField("");
      		JSum.setBounds(300,30,100,30);
      		Font fJ=new Font("����",Font.BOLD,15);
      		JSum.setFont(fJ);
      		makesubject.add(JSum);
      		
      		sum = new JLabel("����������");
      		sum.setBounds(30,20,150,50);
      		Font fSum=new Font("����",Font.BOLD,20);
      		sum.setFont(fSum);
      		makesubject.add(sum);
      		
      		JLabel daoti = new JLabel("����");
      		daoti.setBounds(400,20,150,50);
      		Font fdaoti=new Font("����",Font.BOLD,20);
      		daoti.setFont(fdaoti);
      		makesubject.add(daoti);
      		
      		make = new JButton("������Ŀ");
      		Font fMake=new Font("����",Font.BOLD,20);
      		make.setFont(fMake);
      		make.setBounds(190,190,120,40);
      		makesubject.add(make);
      		make.addActionListener(this);
      		
      		range = new JLabel("����");
      		range.setBounds(230,20,150,50);
      		Font frange=new Font("����",Font.BOLD,20);
      		range.setFont(frange);
      		makesubject.add(range);
      		
      		JRange = new JTextField("");
      		JRange.setBounds(130,30,100,30);
      		Font fJRange=new Font("����",Font.BOLD,15);
      		JRange.setFont(fJRange);
      		makesubject.add(JRange);
      		
      		Background bgd1;
      		bgd1=new Background((new ImageIcon("src//bak4.jpg")).getImage());
      		bgd1.setBounds(0, 0,500, 300);
      		makesubject.add(bgd1);
      		
      		makesubject.setVisible(true);
      }
      public void lay()
      {
    	window = new JFrame("100���ڼӼ�����ϰ���");
  		window.setLayout(null);//���ò���
  		window.setSize(1000,550);//���ô�С
  		window.setLocationRelativeTo(null);//���þ���
  		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////���ÿɹر�
  		
  		
  		right = new JLabel("���������");
  		right.setBounds(50,0,150,100);
  		Font fRight=new Font("����",Font.BOLD,20);
  		right.setFont(fRight);
  		window.add(right);
  		
  		wrong = new JLabel("�ܴ�������");
  		wrong.setBounds(270,0,150,100);
  		Font fWrong=new Font("����",Font.BOLD,20);
  		wrong.setFont(fWrong);
  		window.add(wrong);
  		
  		number = new JLabel("����ţ�");
  		number.setBounds(480,0,150,100);
  		Font fNumber=new Font("����",Font.BOLD,20);
  		number.setFont(fNumber);
  		window.add(number);
  		
  		time = new JLabel("��ʱ��");
  		time.setBounds(750,70,100,50);
  		Font fTime=new Font("����",Font.BOLD,20);
  		time.setFont(fTime);
  		window.add(time);
  		
  		JTime = new JTextField("");
  		JTime.setBounds(820,80,100,30);
  		Font fJTime=new Font("����",Font.BOLD,20);
  		JTime.setFont(fJTime);
  		JTime.setHorizontalAlignment(JTextField.CENTER);
  		window.add(JTime);
  		
  		end = new JButton("��������");
  		end.setBounds(700,450,140,40);
  		Font f3=new Font("����",Font.BOLD,20);
  		end.setFont(f3);
  		window.add(end);
  		end.addActionListener(this);
  		
  		ok = new JButton("ȷ��");
  		ok.setBounds(100,450,80,40);
  		Font f1=new Font("����",Font.BOLD,20);
  		ok.setFont(f1);
  		window.add(ok);
  		ok.addActionListener(this);
  		
  	    next = new JButton("��һ��");
  		next.setBounds(400,450,100,40);
  		Font f2=new Font("����",Font.BOLD,20);
  		next.setFont(f2);
  		window.add(next);
  		next.addActionListener(this);
  		
  		before = new JButton("��һ��");
  		before.setBounds(300,450,100,40);
  		Font f4=new Font("����",Font.BOLD,20);
  		before.setFont(f4);
  		window.add(before);
  		before.addActionListener(this);
  		
  		subject = new JTextField("");
  		subject.setBounds(50,130,400,100);
  		subject.setBackground(Color.WHITE);
  		Font fSubject=new Font("����",Font.BOLD,35);
        subject.setFont(fSubject);
  		subject.setEditable(false);
  		subject.setHorizontalAlignment(JTextField.CENTER);
  		window.add(subject);
  		
  		ask = new JLabel("������𰸣�");
  		ask.setBounds(50,270,200,40);
  		Font fAsk=new Font("����",Font.BOLD,20);
  		ask.setFont(fAsk);
        window.add(ask);
          
        finish = new JTextField("");
  		finish.setBounds(200,275,100,30);
  		Font ff=new Font("����",Font.BOLD,20);
  		finish.setFont(ff);
  		finish.setEditable(false);
  		window.add(finish);
  		
  		answer = new JLabel("");
        answer.setBounds(400,275,300,40);
  		Font fAnswer=new Font("����",Font.BOLD,20);
  		answer.setFont(fAnswer);
        window.add(answer);
          
        jNumber = new JTextField("");
  		jNumber.setBounds(820,34,100,30);
  		Font fj=new Font("����",Font.BOLD,20);
  		jNumber.setFont(fj);
  		window.add(jNumber);
  		
  		jump = new JButton("��ת");
  		jump.setBounds(720,30,80,35);
  		Font fjump=new Font("����",Font.BOLD,20);
  		jump.setFont(fjump);
  		window.add(jump);
  		jump.addActionListener(this);

  		
  		for(int i=0;i<=9;i++)
  		{
  			n[i] = new JButton(""+i);
  			//����λ��
  	  		Font fn = new Font("����",Font.BOLD,20);
  	  	    n[i].setFont(fn);
  	  		window.add(n[i]);
  	  	    n[i].addActionListener(this);
  		}
  		
  		n[1].setBounds(600,180,45,45);
  		n[2].setBounds(645,180,45,45);
  		n[3].setBounds(690,180,45,45);
  		n[4].setBounds(600,225,45,45);
  		n[5].setBounds(645,225,45,45);
  		n[6].setBounds(690,225,45,45);
  		n[7].setBounds(600,270,45,45);
  		n[8].setBounds(645,270,45,45);
  		n[9].setBounds(690,270,45,45);
  		n[0].setBounds(600,315,45,45);
  		
  		Background bgd;
  		bgd=new Background((new ImageIcon("src//bak.jpg")).getImage());
  		bgd.setBounds(0, 0, 1000, 550);
  		window.add(bgd);
  		
//���ÿɼ�
      }
      public void log()
      {
    	  try {
  			logger = Logger.getLogger("��־");
  		    ConsoleHandler consoleHandler = new ConsoleHandler();
  		    logger.addHandler(consoleHandler);
  			FileHandler fileHandler = new FileHandler("src/��ʷ��¼.txt",true);
  			fileHandler.setFormatter(new LoggerFormatter());
  			logger.addHandler(fileHandler);
  		} catch (SecurityException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
      }
		}
		
		
	


