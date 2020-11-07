package Function;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;
/**
 * 上一题按钮功能类
 * 更新数据库中当前题号mark变量并更新答题界面AnswerUI信息，若当前题目为第一题则弹出错误窗口
 * @author sunxingbo
 *
 */
public class lastSubjectF {
	 public static void act()//下一题实现方法
     {
		int mark=Database.mark;
   	  	if(mark>1)
		{
			Database.mark--;
			AnswerUI.update();
		}
   	  	else{
   	  		new TipUI("本题为第一题!");
   	  	}
     }
}
