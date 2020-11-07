package Function;

import java.awt.Color;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;
/**
 * 下一题按钮功能类
 * 更新数据库当前题目序号mark变量，并更新答题界面AnswerUI信息，若当前题目为最后一题则弹出错误窗口
 * @author sunxingbo
 *
 */
public class nextSubjectF {
	 public static void act()//下一题实现方法
     {
		int mark=Database.mark;
		int all=Database.all;
   	  	if(mark<all)
		{
			Database.mark++;
			AnswerUI.update();
		}
   	  	else{
   	  		new TipUI("本题为最后一题!");
   	  	}
     }
}
