package other;
import java.util.List;

/**
 * 数据库
 * @author sunxingbo
 *
 */
public class Database {
	public static List<String> question ;//题目
	public static List<Integer> key ;//答案
	public static List<Integer> WCollect;//错题集合
	public static String[] hand;//作答记录
	public static String[] judge;//评判记录
	public static int[] wither;//题目作答情况
	public static int mark = 1;//题序号
	public static int mRight = 0;//答对数
	public static int mWrong = 0;//答错数
	public static int all=0;//总题数
	public static int TestTime=-1;//测试用时
	public static int Range=0;//生成题目的范围
	public static int operate=0;


	
	
	//初始化函数
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
