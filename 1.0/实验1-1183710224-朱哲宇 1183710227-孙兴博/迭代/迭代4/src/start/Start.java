package start;

import other.Database;
import ui.AnswerUI;
import ui.GenerateUI;
import ui.TipUI;
/**
 * �����������
 * @author sunxingbo
 *
 */
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database.init();
		new GenerateUI();
		new  AnswerUI();
	}

}
