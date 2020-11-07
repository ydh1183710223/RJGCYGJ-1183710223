package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.ConfirmF;
import Function.EndF;
import Function.JumpToF;
import Function.lastSubjectF;
import Function.nextSubjectF;
import other.Database;
import other.NumTool;

public class AnswerUI {

	static JFrame window;// 窗口框架
	static JLabel right;// 正确题数
	static JLabel wrong;// 错误题数
	static JLabel number;//
	JLabel time;// 计时
	static JLabel answer;// 答题反馈

	JLabel ask;// 请输入答案
	static JTextField subject;// 题目文本框
	static JTextField finish;// 作答文本框
	JTextField jNumber;// 跳转题号文本框
	static JTextField JTime;// 计时显示文本框
	JButton end;// 交卷按钮
	JButton ok;// 确认按钮
	JButton next;// 下一题按钮
	JButton before;// 上一题按钮
	JButton jump;// 跳转按钮
	JButton delete;// 退格按钮
	JButton[] n = new JButton[10];// 数字按键

	public static int h1 = 0;
	public static int h2 = 0;
	public static int m1 = 0;
	public static int m2 = 0;
	public static int s1 = 0;
	public static int s2 = 0;
	static Timer timer;// 计时器
	static TimerTask timerTask;

	static ArrayList<String> question;// 题目缓存，减少访问数据库次数
	static ArrayList<Integer> key;// 答案缓存，减少访问数据库次数

	public AnswerUI() {
		window = new JFrame("100以内加减法练习软件");
		window.setLayout(null);// 设置布局
		window.setSize(1000, 550);// 设置大小
		window.setLocationRelativeTo(null);// 设置居中
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//// 设置可关闭

		right = new JLabel("答对题数：");
		right.setBounds(50, 0, 150, 100);
		Font fRight = new Font("宋体", Font.BOLD, 20);
		right.setFont(fRight);
		window.add(right);

		wrong = new JLabel("总错题数：");
		wrong.setBounds(270, 0, 150, 100);
		Font fWrong = new Font("宋体", Font.BOLD, 20);
		wrong.setFont(fWrong);
		window.add(wrong);

		number = new JLabel("题序号：");
		number.setBounds(480, 0, 150, 100);
		Font fNumber = new Font("宋体", Font.BOLD, 20);
		number.setFont(fNumber);
		window.add(number);

		time = new JLabel("计时：");
		time.setBounds(750, 70, 100, 50);
		Font fTime = new Font("宋体", Font.BOLD, 20);
		time.setFont(fTime);
		window.add(time);

		JTime = new JTextField("");
		JTime.setBounds(820, 80, 100, 30);
		Font fJTime = new Font("宋体", Font.BOLD, 20);
		JTime.setFont(fJTime);
		JTime.setHorizontalAlignment(JTextField.CENTER);
		window.add(JTime);

		end = new JButton("结束作答");
		end.setBounds(700, 450, 140, 40);
		Font f3 = new Font("宋体", Font.BOLD, 20);
		end.setFont(f3);
		window.add(end);
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 交卷
				String time = "" + h1 + h2 + ":" + m1 + m2 + ":" + s1 + s2;
				EndF.act(time);
				timer.cancel();
			}
		});

		ok = new JButton("确认");
		ok.setBounds(100, 450, 80, 40);
		Font f1 = new Font("宋体", Font.BOLD, 20);
		ok.setFont(f1);
		window.add(ok);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String an = finish.getText();
				// TODO Auto-generated method stub
				if (an.isEmpty() && Database.wither[Database.mark] == 0) {
					new TipUI("请输入答案!");
				} else if (an.isEmpty() && Database.wither[Database.mark] != 0) {
					new TipUI("该题已提交无法重复提交!");
				} else {
					ConfirmF.act(an);
				}
			}
		});

		next = new JButton("下一题");
		next.setBounds(400, 450, 100, 40);
		Font f2 = new Font("宋体", Font.BOLD, 20);
		next.setFont(f2);
		window.add(next);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nextSubjectF.act();
			}
		});

		before = new JButton("上一题");
		before.setBounds(300, 450, 100, 40);
		Font f4 = new Font("宋体", Font.BOLD, 20);
		before.setFont(f4);
		window.add(before);
		before.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lastSubjectF.act();
			}
		});

		subject = new JTextField("");
		subject.setBounds(50, 130, 400, 100);
		subject.setBackground(Color.WHITE);
		Font fSubject = new Font("宋体", Font.BOLD, 35);
		subject.setFont(fSubject);
		subject.setEditable(false);
		subject.setHorizontalAlignment(JTextField.CENTER);
		window.add(subject);

		ask = new JLabel("请输入答案：");
		ask.setBounds(50, 270, 200, 40);
		Font fAsk = new Font("宋体", Font.BOLD, 20);
		ask.setFont(fAsk);
		window.add(ask);

		finish = new JTextField("");
		finish.setBounds(200, 275, 100, 30);
		Font ff = new Font("宋体", Font.BOLD, 20);
		finish.setFont(ff);
		finish.setEditable(false);
		window.add(finish);

		answer = new JLabel("");
		answer.setBounds(400, 275, 300, 40);
		Font fAnswer = new Font("宋体", Font.BOLD, 20);
		answer.setFont(fAnswer);
		window.add(answer);

		jNumber = new JTextField("");
		jNumber.setBounds(820, 34, 100, 30);
		Font fj = new Font("宋体", Font.BOLD, 20);
		jNumber.setFont(fj);
		window.add(jNumber);

		jump = new JButton("跳转");
		jump.setBounds(720, 30, 80, 35);
		Font fjump = new Font("宋体", Font.BOLD, 20);
		jump.setFont(fjump);
		window.add(jump);

		jump.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int a;
				String jumpText = jNumber.getText().trim();
				// TODO Auto-generated method stub
				if (!jumpText.isEmpty()) {
					if (NumTool.check(jumpText)) {
						a = NumTool.toint(jumpText);
						JumpToF.act(a);
					} else {
						new TipUI("跳转框输入错误!");
					}
				} else {
					new TipUI("跳转框没有数据!");
				}
			}

		});

		for (int i = 0; i <= 9; i++) {
			n[i] = new JButton("" + i);
			// 设置位置
			Font fn = new Font("宋体", Font.BOLD, 20);
			n[i].setFont(fn);
			window.add(n[i]);
			n[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource() == n[0]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 0);
					} else if (e.getSource() == n[1]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 1);
					} else if (e.getSource() == n[2]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 2);
					} else if (e.getSource() == n[3]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 3);
					} else if (e.getSource() == n[4]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 4);
					} else if (e.getSource() == n[5]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 5);
					} else if (e.getSource() == n[6]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 6);
					} else if (e.getSource() == n[7]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 7);
					} else if (e.getSource() == n[8]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 8);
					} else if (e.getSource() == n[9]) {
						if (Database.operate == 1 && Database.wither[Database.mark] == 0)
							finish.setText(finish.getText() + 9);
					}
				}
			});
		}

		n[1].setBounds(600, 180, 45, 45);
		n[2].setBounds(645, 180, 45, 45);
		n[3].setBounds(690, 180, 45, 45);
		n[4].setBounds(600, 225, 45, 45);
		n[5].setBounds(645, 225, 45, 45);
		n[6].setBounds(690, 225, 45, 45);
		n[7].setBounds(600, 270, 45, 45);
		n[8].setBounds(645, 270, 45, 45);
		n[9].setBounds(690, 270, 45, 45);
		n[0].setBounds(600, 315, 45, 45);

		delete = new JButton("退格");
		Font fdelete = new Font("宋体", Font.BOLD, 20);
		delete.setFont(fdelete);
		delete.setBounds(645, 315, 90, 45);
		window.add(delete);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = finish.getText();
				if (Database.operate == 1 && Database.wither[Database.mark] == 0) {
					if (text.length() > 1) {
						finish.setText(text.substring(0, text.length() - 1));
					} else if (text.length() == 1) {
						finish.setText("");
					}
				}
			}

		});

		Background bgd;
		bgd = new Background((new ImageIcon("src//bak.jpg")).getImage());
		bgd.setBounds(0, 0, 1000, 550);
		window.add(bgd);
	}

	public static void timing() // 计时
	{
		timerTask = new TimerTask() {
			@Override
			public void run() {
				s2++;
				if (s2 == 10) {
					s2 = 0;
					s1++;
					if (s1 == 6) {
						s1 = 0;
						m2++;
						if (m2 == 10) {
							m2 = 0;
							m1++;
							if (m1 == 6) {
								m1 = 0;
								h2++;
								if (h2 == 10) {
									h2 = 0;
									h1++;
									if (h1 == 10) {
										h1 = 0;
										h2 = 0;
										m1 = 0;
										m2 = 0;
										s1 = 0;
										s2 = 0;
									}
								}
							}
						}
					}
				}
				JTime.setText("" + h1 + h2 + ":" + m1 + m2 + ":" + s1 + s2);
				if (Database.TestTime > 0)
					if ((h1 + h2) * 60 + m1 * 10 + m2 >= Database.TestTime) {
						// 启动交卷程序
						String time = "" + h1 + h2 + ":" + m1 + m2 + ":" + s1 + s2;
						EndF.act(time);
						timer.cancel();
					}
			}
		};

		timer = new Timer();
		timer.schedule(timerTask, 1000, 1000); // 1秒后执行，并且每隔100毫秒重复执行
	}

	/**
	 * 作答界面初始化函数
	 * 同步题目及答案信息，更新本界面显示信息
	 */
	public static void init() {
		question = (ArrayList<String>) Database.question;
		key = (ArrayList<Integer>) Database.key;
		update();
	}

	/**
	 * 更新函数，根据数据库中信息更新本界面显示信息
	 */
	public static void update() {
		int mark = Database.mark;
		subject.setText(question.get(mark - 1));
		right.setText("答对题数：" + Database.mRight);
		wrong.setText("答错题数：" + Database.mWrong);
		answer.setText(Database.judge[mark]);

		if (Database.wither[mark] == 1)
			answer.setForeground(Color.GREEN);
		else if (Database.wither[mark] == -1)
			answer.setForeground(Color.RED);
		finish.setText(Database.hand[mark]);
		number.setText("题序号：" + mark);
	}

	/**
	 * 本界面可见设置函数
	 * @param o boolean值
	 */
	public static void AnswerVisible(boolean o) {
		if (o) {
			timing();
		}
		window.setVisible(o);
	}

}
