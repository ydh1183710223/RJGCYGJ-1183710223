package Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import other.Database;
import ui.AnswerUI;


/**
 * ���ɴ��ť������
 * ������Ŀ���𰸲���������ݿ��У���ʼ�����������Ϣ
 * @author sunxingbo
 *
 */
public class GenerateF {
	public static void act()
	{
		Database.operate = 1;
		
		List<String> question = new ArrayList<String>();//��Ŀ
		List<Integer> key = new ArrayList<Integer>();//��
		List<Integer> WCollect = new ArrayList<Integer>();//���⼯��

		int n=Database.all;
		int r=Database.Range;
		
		Database.hand = new String[n+1];
		Database.judge = new String[n+1];
		Database.wither = new int[n+1];
		
		Random random = new Random();  //����
		int i = 1;
		for(i=1;i<=n;i++)
		{
			int a = random.nextInt(r-1)+1;
			int b = random.nextInt(r-1)+1;
			int c = random.nextInt(2);
			if(c==0) 
			{
				if(a-b<0)
				{
					question.add(b+"-"+a);
					key.add(b-a);
				}
				else 
				{
					question.add(a+"-"+b);
					key.add(a-b);
				}
			}
			else if(c==1)
			{
				if(a+b>=r) i=i-1;
				else 
				{
					question.add(a+"+"+b);
					key.add(a+b);
				}
			}
		}
		
		Database.question=question;
		Database.key=key;
		Database.WCollect=WCollect;
		
		AnswerUI.init();
	}
}
