package Function;

import java.awt.Color;

import other.Database;
import ui.AnswerUI;
/**
 * ok按键的功能类
 * 判断答案，更新数据库中改题的作答情况，并且更新AnswerUI的信息
 * @author sunxingbo
 *
 */
public class ConfirmF {
	public static void act(String an) {
		int operate = Database.operate;
		int mark = Database.mark;
		if (operate == 1 && Database.wither[mark] == 0)// 确保提交过的不能再提交
		{
			int a = Integer.parseInt(an);
			if (a == Database.key.get(mark - 1)) {
				Database.wither[mark] = 1;
				Database.judge[mark] = ("√");
				Database.mRight++;
			} else {
				Database.wither[mark] = -1;
				Database.judge[mark] = "答错，答案为" + Database.key.get(mark - 1);
				Database.mWrong++;
				Database.WCollect.add(mark);
			}

		}
		AnswerUI.update();
	}
}
