package Function;

import other.Database;
import ui.AnswerSheetUI;
import ui.AnswerUI;
import ui.GenerateUI;

/**
 * �ύ���ť������
 * ʹ������Ŀ����ɼ���������治�ɼ�����ʼ��������Ŀ�������ı������Ϣ�����ɴ��
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
