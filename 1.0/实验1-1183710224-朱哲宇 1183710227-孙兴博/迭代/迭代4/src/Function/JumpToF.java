package Function;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;

/**
 * ��ת��ť������
 * ��������ʱ�������ݿ��е�ǰ�����mark���������´������AnswerUI��Ϣ����������ת��Χ�򵯳����󴰿ڲ���ʾ������
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
			new TipUI("����������Χ!������Ϊ"+all);
		}
	}
}
