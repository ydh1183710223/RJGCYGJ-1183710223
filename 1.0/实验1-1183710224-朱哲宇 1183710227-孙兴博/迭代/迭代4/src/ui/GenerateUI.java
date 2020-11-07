package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.GenerateF;
import other.Database;
import other.NumTool;

/**
 * ������Ŀ����
 * @author sunxingbo
 *
 */
public class GenerateUI {

	static JFrame makesubject;
	static JTextField JTestTime;
	JLabel range;
	static JTextField JRange;
	static JTextField JSum;
	JLabel sum;
	JButton make;
	
	TipUI t;

	public GenerateUI() {
		makesubject = new JFrame("100���ڼӼ���");
		makesubject.setLayout(null);
		makesubject.setSize(500, 300);
		makesubject.setLocationRelativeTo(null);
		makesubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel TestTime = new JLabel("�����ò���ʱ��(�ɲ���):");
		TestTime.setBounds(30, 120, 250, 30);
		Font JT = new Font("����", Font.BOLD, 20);
		TestTime.setFont(JT);
		makesubject.add(TestTime);

		JLabel fenzhong = new JLabel("����");
		fenzhong.setBounds(390, 120, 50, 30);
		fenzhong.setFont(JT);
		makesubject.add(fenzhong);

		JTestTime = new JTextField("");
		JTestTime.setBounds(280, 120, 100, 30);
		JTestTime.setFont(new Font("����", Font.BOLD, 15));
		makesubject.add(JTestTime);

		JSum = new JTextField("");
		JSum.setBounds(300, 30, 100, 30);
		Font fJ = new Font("����", Font.BOLD, 15);
		JSum.setFont(fJ);
		makesubject.add(JSum);

		sum = new JLabel("����������");
		sum.setBounds(30, 20, 150, 50);
		Font fSum = new Font("����", Font.BOLD, 20);
		sum.setFont(fSum);
		makesubject.add(sum);

		JLabel daoti = new JLabel("����");
		daoti.setBounds(400, 20, 150, 50);
		Font fdaoti = new Font("����", Font.BOLD, 20);
		daoti.setFont(fdaoti);
		makesubject.add(daoti);

		make = new JButton("������Ŀ");
		Font fMake = new Font("����", Font.BOLD, 20);
		make.setFont(fMake);
		make.setBounds(190, 190, 120, 40);
		makesubject.add(make);

		make.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sum = JSum.getText().trim();
				String range = JRange.getText().trim();
				String testtime = JTestTime.getText().trim();
				if (NumTool.check(sum)&&NumTool.toint(sum)!=0) {
					if (NumTool.check(range)&&NumTool.toint(range)>2) {
						if (testtime.isEmpty()){
							Database.all=NumTool.toint(sum);
							Database.Range=NumTool.toint(range);
							GenerateF.act();
							makesubject.setVisible(false);
							AnswerUI.AnswerVisible(true);
						}
						else if(NumTool.check(testtime)&&NumTool.toint(testtime)!=0) {
							Database.all=NumTool.toint(sum);
							Database.Range=NumTool.toint(range);
							
								Database.TestTime=NumTool.toint(testtime);
								GenerateF.act();
								makesubject.setVisible(false);
								AnswerUI.AnswerVisible(true);
						} else {
								t=new TipUI("��ʱ���������!");
							}
						}else {
						t=new TipUI("��Χ���������!");
					}}
					else {
					t=new TipUI("���������������!");
				} 
				
			}
		});
		range = new JLabel("����");
		range.setBounds(230, 20, 150, 50);
		Font frange = new Font("����", Font.BOLD, 20);
		range.setFont(frange);
		makesubject.add(range);

		JRange = new JTextField("");
		JRange.setBounds(130, 30, 100, 30);
		Font fJRange = new Font("����", Font.BOLD, 15);
		JRange.setFont(fJRange);
		makesubject.add(JRange);

		Background bgd1;
		bgd1 = new Background((new ImageIcon("src//bak4.jpg")).getImage());
		bgd1.setBounds(0, 0, 500, 300);
		makesubject.add(bgd1);

		makesubject.setVisible(true);
	}
	
	/**
	 * �ý����ı�����Ϣ��պ���
	 */
	public static void clear()
	{
		JTestTime.setText("");
		JSum.setText("");
		JRange.setText("");
	}

	/**
	 * �ý���ɼ����ú���
	 * @param o Booleanֵ
	 */
	public static void makesubjectVisible(boolean o) {
		makesubject.setVisible(o);
	}
}
