package panel;

import java.awt.Color;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Exception.IllegalCharacterException;
import Exception.OutstepException;

public class App  implements ActionListener{
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
	
	
	
	
	public App ()
	{
		lay();
		
	}
		
		public void actionPerformed(ActionEvent e) {
		try {	
			if(e.getSource()==make)//������Ŀ
			{
				String num = JSum.getText().trim();//����
				String ran = JRange.getText().trim();//���㷶Χ
				
					Generate(num,ran);
			}
			else if(e.getSource()==ok) //ȷ�ϼ�
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
				
			}
			else if(e.getSource()==end)//����
			{
				end();
			}
			
		} catch (IllegalCharacterException e1) {
			
		} catch (OutstepException e1) {
			window.setTitle(e1.getMessage());
		}
		}
		public void Generate(String num,String ran) throws IllegalCharacterException //������Ŀ
, OutstepException
		{
			if(operate==0)
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
			
			window.setTitle("100���ڼӼ�����ϰ���");
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
			
			
			}
			
	
			
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
      public void nextSubject()
      {
    	  if(mark<all)
			{
				mark++;
			    subject.setText(question.get(mark-1));
			    answer.setText(judge[mark]);
			  
			    if(wither[mark]==1) answer.setForeground(Color.GREEN);
			    else if(wither[mark]==-1) answer.setForeground(Color.RED);
			    finish.setText(hand[mark]);
			    number.setText("����ţ�"+mark);
			}
      }
      public void lastSubject()
      {
    	  if(mark>1)
			{
				mark--;
				subject.setText(question.get(mark-1));
				answer.setText(judge[mark]);
				
				if(wither[mark]==1) answer.setForeground(Color.GREEN);
			    else if(wither[mark]==-1) answer.setForeground(Color.RED);
				finish.setText(hand[mark]);
				number.setText("����ţ�"+mark);
			}
      }
     
      public void end()
      {
    	  if(operate==1)
    	  {
    		 
		     
		     JSum.setEditable(true);
			 JRange.setEditable(true);
			
			 
			answering();
		     
			JRange.setText("");
			subject.setText("");
			finish.setText("");
			answer.setText("");
			JSum.setText("");
			JTime.setText("");
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
		    collect.add(area);
		    Font fC=new Font("����",Font.BOLD,20);
			area.setFont(fC);
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
		    		y1 = y1+"���"+i+": "+question.get(i-1)+"\n";
		    	}
		    }
		    String e = "��ʱ"+JTime.getText()+"\n"+"������:"+all+"  �������:"+mRight+"  �������:"+mWrong+"\n\n"+"��Ĵ����ǣ�\n"+y+"\n"+"��δ�������Ŀ��\n"+y1;
		    area.setText(e);	
		    
      }
      public void lay()
      {
    	window = new JFrame("100���ڼӼ�����ϰ���");
  		window.setLayout(null);//���ò���
  		window.setSize(1300,800);//���ô�С
  		window.setLocationRelativeTo(null);//���þ���
  		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////���ÿɹر�
  		
  		
  		JSum = new JTextField("");
  		JSum.setBounds(150,60,100,30);
  		Font fJ=new Font("����",Font.BOLD,15);
  		JSum.setFont(fJ);
  		window.add(JSum);
  		
  		sum = new JLabel("����������");
  		sum.setBounds(50,50,150,50);
  		Font fSum=new Font("����",Font.BOLD,20);
  		sum.setFont(fSum);
  		window.add(sum);
  		
  		
  		
  		make = new JButton("������Ŀ");
  		Font fMake=new Font("����",Font.BOLD,20);
  		make.setFont(fMake);
  		make.setBounds(550,60,120,40);
  		window.add(make);
  		make.addActionListener(this);
  		
  		right = new JLabel("���������");
  		right.setBounds(50,150,150,100);
  		Font fRight=new Font("����",Font.BOLD,20);
  		right.setFont(fRight);
  		window.add(right);
  		
  		wrong = new JLabel("�ܴ�������");
  		wrong.setBounds(320,150,150,100);
  		Font fWrong=new Font("����",Font.BOLD,20);
  		wrong.setFont(fWrong);
  		window.add(wrong);
  		
  		number = new JLabel("����ţ�");
  		number.setBounds(595,150,150,100);
  		Font fNumber=new Font("����",Font.BOLD,20);
  		number.setFont(fNumber);
  		window.add(number);
  		
  		time = new JLabel("��ʱ��");
  		time.setBounds(950,50,100,50);
  		Font fTime=new Font("����",Font.BOLD,20);
  		time.setFont(fTime);
  		window.add(time);
  		
  		JTime = new JTextField("");
  		JTime.setBounds(1020,60,120,30);
  		Font fJTime=new Font("����",Font.BOLD,20);
  		JTime.setFont(fJTime);
  		JTime.setHorizontalAlignment(JTextField.CENTER);
  		window.add(JTime);
  		
  		end = new JButton("��������");
  		end.setBounds(700,600,140,40);
  		Font f3=new Font("����",Font.BOLD,20);
  		end.setFont(f3);
  		window.add(end);
  		end.addActionListener(this);
  		
  		ok = new JButton("ȷ��");
  		ok.setBounds(100,600,80,40);
  		Font f1=new Font("����",Font.BOLD,20);
  		ok.setFont(f1);
  		window.add(ok);
  		ok.addActionListener(this);
  		
  	    next = new JButton("��һ��");
  		next.setBounds(400,600,100,40);
  		Font f2=new Font("����",Font.BOLD,20);
  		next.setFont(f2);
  		window.add(next);
  		next.addActionListener(this);
  		
  		before = new JButton("��һ��");
  		before.setBounds(300,600,100,40);
  		Font f4=new Font("����",Font.BOLD,20);
  		before.setFont(f4);
  		window.add(before);
  		before.addActionListener(this);
  		
  		subject = new JTextField("");
  		subject.setBounds(50,280,400,100);
  		subject.setBackground(Color.WHITE);
  		Font fSubject=new Font("����",Font.BOLD,35);
        subject.setFont(fSubject);
  		subject.setEditable(false);
  		subject.setHorizontalAlignment(JTextField.CENTER);
  		window.add(subject);
  		
  		ask = new JLabel("������𰸣�");
  		ask.setBounds(50,420,200,40);
  		Font fAsk=new Font("����",Font.BOLD,20);
  		ask.setFont(fAsk);
        window.add(ask);
          
        finish = new JTextField("");
  		finish.setBounds(200,425,100,30);
  		Font ff=new Font("����",Font.BOLD,20);
  		finish.setFont(ff);
  		
  		window.add(finish);
  		
  		answer = new JLabel("");
        answer.setBounds(400,425,300,40);
  		Font fAnswer=new Font("����",Font.BOLD,20);
  		answer.setFont(fAnswer);
        window.add(answer);
          
        jNumber = new JTextField("");
  		jNumber.setBounds(1020,184,100,30);
  		Font fj=new Font("����",Font.BOLD,20);
  		jNumber.setFont(fj);
  		window.add(jNumber);
  		
  		jump = new JButton("��ת");
  		jump.setBounds(920,180,80,35);
  		Font fjump=new Font("����",Font.BOLD,20);
  		jump.setFont(fjump);
  		window.add(jump);
  		jump.addActionListener(this);
          
  		range = new JLabel("����");
  		range.setBounds(400,50,150,50);
  		Font frange=new Font("����",Font.BOLD,20);
  		range.setFont(frange);
  		window.add(range);
  	
  		JRange = new JTextField("");
  		JRange.setBounds(300,60,100,30);
  		Font fJRange=new Font("����",Font.BOLD,15);
  		JRange.setFont(fJRange);
  		window.add(JRange);
  		
  		
  		window.setVisible(true);//���ÿɼ�
  		
      }
     
      
		}
		
		
		
	


