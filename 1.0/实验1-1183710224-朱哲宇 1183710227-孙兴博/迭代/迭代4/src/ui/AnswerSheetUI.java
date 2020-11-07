package ui;

import java.awt.Font;
import java.io.IOException;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import other.Database;
import other.LoggerFormatter;
/**
 * ��������
 * ��ʾ����������ʼ�����ݿ⣬������־
 * @author sunxingbo
 *
 */
public class AnswerSheetUI {
	JScrollPane jsp;
	JMenuBar jb;
	Logger logger;
	FileHandler fileHandler ;
	/**
	 * ���ɴ������
	 * @param time �������ļ�ʱʱ��
	 */
	public AnswerSheetUI(String time) 
	{
		log();
		int all=Database.all;
		int mRight=Database.mRight;
		int mWrong=Database.mWrong;
		List<String> question=Database.question;
		List<Integer> key=Database.key;
		List<Integer> WCollect=Database.WCollect;
		int[] wither=Database.wither;
		String[] hand=Database.hand;

		JFrame collect = new JFrame("�������");
		collect.setSize(600, 800);// ���ô�С
		collect.setLocationRelativeTo(null);// ���þ���
		collect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//// ���ÿɹر�

		JTextArea area = new JTextArea("");

		jb = new JMenuBar();
		jsp = new JScrollPane(area);

		collect.setJMenuBar(jb);

		Font fC = new Font("����", Font.BOLD, 20);
		area.setFont(fC);

		collect.add(jsp);

		String y = "";
		for (int i = 0; i < WCollect.size(); i++) {
			int x = WCollect.get(i);
			y = y + "���" + x + ": " + question.get(x - 1) + "  ��Ĵ���" + hand[x] + "  ��ȷ����" + key.get(x - 1) + "\n";
		}
		String y1 = "";
		for (int i = 1; i <= all; i++) {

			if (wither[i] == 0) {
				String t1 = "���" + i + ": " + question.get(i - 1);
				String t2 = "�𰸣�" + key.get(i - 1);
				y1 = y1 + t1;
				for (int j = 1; j <= 40 - t1.length(); j++) {
					y1 = y1 + " ";
				}
				y1 = y1 + t2 + "\n";
			}
		}
		String e = "��ʱ" + time + "\n" + "������:" + all + "  �������:" + mRight + "  �������:" + mWrong + "  δ��������:"
				+ (all - mRight - mWrong) + "\n\n" + "��Ĵ����ǣ�\n" + y + "\n" + "��δ�������Ŀ��\n" + y1;
		area.setText(e);
		area.setEditable(false);
		area.setCaretPosition(0);
		logger.info(e);
		
		fileHandler.close();
		
		Database.init();
		collect.setVisible(true);
	}
	/**
	 * ��־������������
	 */
	 public void log()
     {
   	  try {
 			logger = Logger.getLogger("��־");
 		    ConsoleHandler consoleHandler = new ConsoleHandler();
 		    logger.addHandler(consoleHandler);
 			fileHandler = new FileHandler("src/��ʷ��¼.txt",true);
 			fileHandler.setFormatter(new LoggerFormatter());
 			logger.addHandler(fileHandler);
 		} catch (SecurityException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
     }

}
