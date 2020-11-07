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
 * 答卷情况类
 * 显示答卷情况，初始化数据库，生成日志
 * @author sunxingbo
 *
 */
public class AnswerSheetUI {
	JScrollPane jsp;
	JMenuBar jb;
	Logger logger;
	FileHandler fileHandler ;
	/**
	 * 生成答题情况
	 * @param time 结束答卷的计时时间
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

		JFrame collect = new JFrame("答题情况");
		collect.setSize(600, 800);// 设置大小
		collect.setLocationRelativeTo(null);// 设置居中
		collect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//// 设置可关闭

		JTextArea area = new JTextArea("");

		jb = new JMenuBar();
		jsp = new JScrollPane(area);

		collect.setJMenuBar(jb);

		Font fC = new Font("宋体", Font.BOLD, 20);
		area.setFont(fC);

		collect.add(jsp);

		String y = "";
		for (int i = 0; i < WCollect.size(); i++) {
			int x = WCollect.get(i);
			y = y + "序号" + x + ": " + question.get(x - 1) + "  你的答案是" + hand[x] + "  正确答案是" + key.get(x - 1) + "\n";
		}
		String y1 = "";
		for (int i = 1; i <= all; i++) {

			if (wither[i] == 0) {
				String t1 = "序号" + i + ": " + question.get(i - 1);
				String t2 = "答案：" + key.get(i - 1);
				y1 = y1 + t1;
				for (int j = 1; j <= 40 - t1.length(); j++) {
					y1 = y1 + " ";
				}
				y1 = y1 + t2 + "\n";
			}
		}
		String e = "计时" + time + "\n" + "总题数:" + all + "  答对题数:" + mRight + "  答错题数:" + mWrong + "  未作答题数:"
				+ (all - mRight - mWrong) + "\n\n" + "你的错题是：\n" + y + "\n" + "你未作答的题目：\n" + y1;
		area.setText(e);
		area.setEditable(false);
		area.setCaretPosition(0);
		logger.info(e);
		
		fileHandler.close();
		
		Database.init();
		collect.setVisible(true);
	}
	/**
	 * 日志工具启动函数
	 */
	 public void log()
     {
   	  try {
 			logger = Logger.getLogger("日志");
 		    ConsoleHandler consoleHandler = new ConsoleHandler();
 		    logger.addHandler(consoleHandler);
 			fileHandler = new FileHandler("src/历史记录.txt",true);
 			fileHandler.setFormatter(new LoggerFormatter());
 			logger.addHandler(fileHandler);
 		} catch (SecurityException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
     }

}
