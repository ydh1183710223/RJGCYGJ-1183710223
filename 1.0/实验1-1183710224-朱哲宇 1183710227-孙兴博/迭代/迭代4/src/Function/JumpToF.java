package Function;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;

/**
 * 跳转按钮功能类
 * 条件符合时更新数据库中当前题序号mark变量，更新答题界面AnswerUI信息，若超出跳转范围则弹出错误窗口并提示总题数
 * @author sunxingbo
 *
 */
public class JumpToF {
	public static void act(int x) {
		int all = Database.all;
		if (x <= all) {
			Database.mark = x;
			AnswerUI.update();
		}
		else {
			new TipUI("超出题数范围!总题数为"+all);
		}
	}
}
