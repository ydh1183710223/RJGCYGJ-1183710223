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
	
	
	
	public List<String> question ;//题目
	public List<Integer> key ;//答案
	public List<Integer> WCollect;//错题集合
	public String[] hand;//作答记录
	public String[] judge;//评判记录
	public int[] wither;//题目作答情况
	public int mark = 1;//题序号
	public int mRight = 0;//答对数
	public int mWrong = 0;//答错数
	public int all=0;//总题数
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
			if(e.getSource()==make)//生成题目
			{
				String num = JSum.getText().trim();//题数
				String ran = JRange.getText().trim();//运算范围
				
					Generate(num,ran);
			}
			else if(e.getSource()==ok) //确认键
			{
				String an = finish.getText().trim();
				confirm(an);
			}
			else if(e.getSource()==next)//下一题
			{
				nextSubject();
			}
			else if(e.getSource()==before)//上一题
			{
				lastSubject();
			}
			else if(e.getSource()==jump) //跳转
			{
				String num = jNumber.getText().trim();
				
			}
			else if(e.getSource()==end)//结束
			{
				end();
			}
			
		} catch (IllegalCharacterException e1) {
			
		} catch (OutstepException e1) {
			window.setTitle(e1.getMessage());
		}
		}
		public void Generate(String num,String ran) throws IllegalCharacterException //生成题目
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
			if(n<=0) throw new OutstepException("请输入范围合理的数字");
			all = n;
			
			
			if(ran.isEmpty()) throw new IllegalCharacterException();
			char[] cran = ran.toCharArray();
			for(int i =0;i<cran.length;i++)
			{
				if(cran[i]<48||cran[i]>57)
					throw new IllegalCharacterException();
			}
			int r = Integer.parseInt(ran);
			if(r<=2) throw new OutstepException("请输入范围合理的数字");
			
			window.setTitle("100以内加减法练习软件");
			operate = 1;
			
			question = new ArrayList<String>();//题目
			key = new ArrayList<Integer>();//答案
			WCollect = new ArrayList<Integer>();//错题集合
			
			JSum.setEditable(false);
			JRange.setEditable(false);
			
			JTime.setText(""+h1+h2+":"+m1+m2+":"+s1+s2);
			
			hand = new String[n+1];
			judge = new String[n+1];
			wither = new int[n+1];
			
			Random random = new Random();  //生成
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
			right.setText("答对题数：0");
			wrong.setText("答错题数：0");
			number.setText("题序号：1");
			
			
			}
			
	
			
		}
      
      public void confirm(String an) throws IllegalCharacterException
      {
    	 
    		 int w = 0;
    	  if(operate==1&&wither[mark] == 0)//确保提交过的不能再提交
			{
			if(an.isEmpty()) throw new IllegalCharacterException() ;
			hand[mark] = an;
			char[] can = an.toCharArray();
			for(int i=0;i<can.length;i++)
			{
				if(can[i]<48||can[i]>57)
				{
					wither[mark] = -1;
					answer.setText("答错，答案为"+key.get(mark-1));
					answer.setForeground(Color.RED);
					mWrong++;
					wrong.setText("答错题数："+mWrong);
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
				answer.setText("√");
				answer.setForeground(Color.GREEN);
				mRight++;
				right.setText("答对题数："+mRight);
			}
			else 
			{
				wither[mark] = -1;
				answer.setText("答错，答案为"+key.get(mark-1));
				answer.setForeground(Color.RED);
				mWrong++;
				wrong.setText("答错题数："+mWrong);
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
			    number.setText("题序号："+mark);
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
				number.setText("题序号："+mark);
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
			right.setText("答对题数：");
			wrong.setText("答错题数：");
			number.setText("题序号：");
		
			mark = 1;//题序号
			mRight = 0;//答对数
			mWrong = 0;//答错数
			all=0;//总题数
			h1=0;
		    h2=0;
			m1=0;
			m2=0;
			s1=0;
			s2=0;
			operate=0;
    	  }
    	  
      }
      public void answering() //生成答题情况
      {
    	  JFrame collect = new JFrame("答题情况");
		    collect.setSize(600,800);//设置大小
		    collect.setLocationRelativeTo(null);//设置居中
		    collect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);////设置可关闭
		    collect.setVisible(true);
		    
		    JTextArea area = new JTextArea("");
		    collect.add(area);
		    Font fC=new Font("宋体",Font.BOLD,20);
			area.setFont(fC);
		    String y = "";
		    for(int i=0;i<WCollect.size();i++)
		    {
		    	int x = WCollect.get(i);
		    	y = y+"序号"+x+": "+question.get(x-1)+"  你的答案是"+hand[x]+"  正确答案是"+key.get(x-1)+"\n";
		    }
		    String y1 = "";
		    for(int i=1;i<=all;i++)
		    {
		    	if(wither[i]==0)
		    	{
		    		y1 = y1+"序号"+i+": "+question.get(i-1)+"\n";
		    	}
		    }
		    String e = "计时"+JTime.getText()+"\n"+"总题数:"+all+"  答对题数:"+mRight+"  答错题数:"+mWrong+"\n\n"+"你的错题是：\n"+y+"\n"+"你未作答的题目：\n"+y1;
		    area.setText(e);	
		    
      }
      public void lay()
      {
    	window = new JFrame("100以内加减法练习软件");
  		window.setLayout(null);//设置布局
  		window.setSize(1300,800);//设置大小
  		window.setLocationRelativeTo(null);//设置居中
  		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);////设置可关闭
  		
  		
  		JSum = new JTextField("");
  		JSum.setBounds(150,60,100,30);
  		Font fJ=new Font("宋体",Font.BOLD,15);
  		JSum.setFont(fJ);
  		window.add(JSum);
  		
  		sum = new JLabel("设置题数：");
  		sum.setBounds(50,50,150,50);
  		Font fSum=new Font("宋体",Font.BOLD,20);
  		sum.setFont(fSum);
  		window.add(sum);
  		
  		
  		
  		make = new JButton("生成题目");
  		Font fMake=new Font("宋体",Font.BOLD,20);
  		make.setFont(fMake);
  		make.setBounds(550,60,120,40);
  		window.add(make);
  		make.addActionListener(this);
  		
  		right = new JLabel("答对题数：");
  		right.setBounds(50,150,150,100);
  		Font fRight=new Font("宋体",Font.BOLD,20);
  		right.setFont(fRight);
  		window.add(right);
  		
  		wrong = new JLabel("总错题数：");
  		wrong.setBounds(320,150,150,100);
  		Font fWrong=new Font("宋体",Font.BOLD,20);
  		wrong.setFont(fWrong);
  		window.add(wrong);
  		
  		number = new JLabel("题序号：");
  		number.setBounds(595,150,150,100);
  		Font fNumber=new Font("宋体",Font.BOLD,20);
  		number.setFont(fNumber);
  		window.add(number);
  		
  		time = new JLabel("计时：");
  		time.setBounds(950,50,100,50);
  		Font fTime=new Font("宋体",Font.BOLD,20);
  		time.setFont(fTime);
  		window.add(time);
  		
  		JTime = new JTextField("");
  		JTime.setBounds(1020,60,120,30);
  		Font fJTime=new Font("宋体",Font.BOLD,20);
  		JTime.setFont(fJTime);
  		JTime.setHorizontalAlignment(JTextField.CENTER);
  		window.add(JTime);
  		
  		end = new JButton("结束作答");
  		end.setBounds(700,600,140,40);
  		Font f3=new Font("宋体",Font.BOLD,20);
  		end.setFont(f3);
  		window.add(end);
  		end.addActionListener(this);
  		
  		ok = new JButton("确认");
  		ok.setBounds(100,600,80,40);
  		Font f1=new Font("宋体",Font.BOLD,20);
  		ok.setFont(f1);
  		window.add(ok);
  		ok.addActionListener(this);
  		
  	    next = new JButton("下一题");
  		next.setBounds(400,600,100,40);
  		Font f2=new Font("宋体",Font.BOLD,20);
  		next.setFont(f2);
  		window.add(next);
  		next.addActionListener(this);
  		
  		before = new JButton("上一题");
  		before.setBounds(300,600,100,40);
  		Font f4=new Font("宋体",Font.BOLD,20);
  		before.setFont(f4);
  		window.add(before);
  		before.addActionListener(this);
  		
  		subject = new JTextField("");
  		subject.setBounds(50,280,400,100);
  		subject.setBackground(Color.WHITE);
  		Font fSubject=new Font("宋体",Font.BOLD,35);
        subject.setFont(fSubject);
  		subject.setEditable(false);
  		subject.setHorizontalAlignment(JTextField.CENTER);
  		window.add(subject);
  		
  		ask = new JLabel("请输入答案：");
  		ask.setBounds(50,420,200,40);
  		Font fAsk=new Font("宋体",Font.BOLD,20);
  		ask.setFont(fAsk);
        window.add(ask);
          
        finish = new JTextField("");
  		finish.setBounds(200,425,100,30);
  		Font ff=new Font("宋体",Font.BOLD,20);
  		finish.setFont(ff);
  		
  		window.add(finish);
  		
  		answer = new JLabel("");
        answer.setBounds(400,425,300,40);
  		Font fAnswer=new Font("宋体",Font.BOLD,20);
  		answer.setFont(fAnswer);
        window.add(answer);
          
        jNumber = new JTextField("");
  		jNumber.setBounds(1020,184,100,30);
  		Font fj=new Font("宋体",Font.BOLD,20);
  		jNumber.setFont(fj);
  		window.add(jNumber);
  		
  		jump = new JButton("跳转");
  		jump.setBounds(920,180,80,35);
  		Font fjump=new Font("宋体",Font.BOLD,20);
  		jump.setFont(fjump);
  		window.add(jump);
  		jump.addActionListener(this);
          
  		range = new JLabel("以内");
  		range.setBounds(400,50,150,50);
  		Font frange=new Font("宋体",Font.BOLD,20);
  		range.setFont(frange);
  		window.add(range);
  	
  		JRange = new JTextField("");
  		JRange.setBounds(300,60,100,30);
  		Font fJRange=new Font("宋体",Font.BOLD,15);
  		JRange.setFont(fJRange);
  		window.add(JRange);
  		
  		
  		window.setVisible(true);//设置可见
  		
      }
     
      
		}
		
		
		
	


