package Function;

import java.awt.Color;

import other.Database;
import ui.AnswerUI;
import ui.TipUI;
/**
 * ��һ�ⰴť������
 * �������ݿ⵱ǰ��Ŀ���mark�����������´������AnswerUI��Ϣ������ǰ��ĿΪ���һ���򵯳����󴰿�
 * @author sunxingbo
 *
 */
public class nextSubjectF {
	 public static void act()//��һ��ʵ�ַ���
     {
		int mark=Database.mark;
		int all=Database.all;
   	  	if(mark<all)
		{
			Database.mark++;
			AnswerUI.update();
		}
   	  	else{
   	  		new TipUI("����Ϊ���һ��!");
   	  	}
     }
}
