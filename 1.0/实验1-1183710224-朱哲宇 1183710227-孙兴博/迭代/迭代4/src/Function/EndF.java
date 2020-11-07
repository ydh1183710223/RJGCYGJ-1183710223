package Function;

import other.Database;
import ui.AnswerSheetUI;
import ui.AnswerUI;
import ui.GenerateUI;

/**
 * 提交答卷按钮功能类
 * 使生成题目界面可见，作答界面不可见，初始化生成题目界面中文本框的信息，生成答卷
 * @author sunxingbo
 *
 */
public class EndF {
	public static void act(String time) {
		GenerateUI.makesubjectVisible(true);
		AnswerUI.AnswerVisible(false);
		new AnswerSheetUI(time);
		GenerateUI.clear();
	}

}
