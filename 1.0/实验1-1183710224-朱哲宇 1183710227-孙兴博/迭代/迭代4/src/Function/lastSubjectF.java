package Function;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;
/**
 * ��һ�ⰴť������
 * �������ݿ��е�ǰ���mark���������´������AnswerUI��Ϣ������ǰ��ĿΪ��һ���򵯳����󴰿�
 * @author sunxingbo
 *
 */
public class lastSubjectF {
	 public static void act()//��һ��ʵ�ַ���
     {
		int mark=Database.mark;
   	  	if(mark>1)
		{
			Database.mark--;
			AnswerUI.update();
		}
   	  	else{
   	  		new TipUI("����Ϊ��һ��!");
   	  	}
     }
}
