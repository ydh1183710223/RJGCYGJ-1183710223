package Function;

import java.awt.Color;

import other.Database;
import ui.AnswerUI;
/**
 * ok�����Ĺ�����
 * �жϴ𰸣��������ݿ��и����������������Ҹ���AnswerUI����Ϣ
 * @author sunxingbo
 *
 */
public class ConfirmF {
	public static void act(String an) {
		int operate = Database.operate;
		int mark = Database.mark;
		if (operate == 1 && Database.wither[mark] == 0)// ȷ���ύ���Ĳ������ύ
		{
			int a = Integer.parseInt(an);
			if (a == Database.key.get(mark - 1)) {
				Database.wither[mark] = 1;
				Database.judge[mark] = ("��");
				Database.mRight++;
			} else {
				Database.wither[mark] = -1;
				Database.judge[mark] = "�����Ϊ" + Database.key.get(mark - 1);
				Database.mWrong++;
				Database.WCollect.add(mark);
			}

		}
		AnswerUI.update();
	}
}
