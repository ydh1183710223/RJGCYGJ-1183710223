package other;
import java.util.List;

/**
 * ���ݿ�
 * @author sunxingbo
 *
 */
public class Database {
	public static List<String> question ;//��Ŀ
	public static List<Integer> key ;//��
	public static List<Integer> WCollect;//���⼯��
	public static String[] hand;//�����¼
	public static String[] judge;//���м�¼
	public static int[] wither;//��Ŀ�������
	public static int mark = 1;//�����
	public static int mRight = 0;//�����
	public static int mWrong = 0;//�����
	public static int all=0;//������
	public static int TestTime=-1;//������ʱ
	public static int Range=0;//������Ŀ�ķ�Χ
	public static int operate=0;


	
	
	//��ʼ������
	public static void init()
	{
		question=null;
		key=null;
		WCollect=null;
		hand=null;
		judge=null;
		wither=null;
		mark=1;
		mRight=0;
		mWrong=0;
		all=0;
		TestTime=-1;
		Range=0;
	}
}
