package other;
/**
 * 通用功能类
 * @author sunxingbo
 *
 */
public class NumTool {
	/**
	 * 检查文本内容
	 * @param text 所要检查的内容
	 * @return 当内容不为空且均为数字则返回true，否则均返回false
	 */
	public static boolean check(String text)
	{
		if(text.length()==0)
			return false;
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)>57||text.charAt(i)<48)
				return false;
		}
		return true;
	}
	/**
	 * 文本转换为数字
	 * @param text
	 * @return 
	 */
	public static int toint(String text)
	{
		int a=Integer.parseInt(text);
		return a;
	}
}
