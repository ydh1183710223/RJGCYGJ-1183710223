package other;
/**
 * ͨ�ù�����
 * @author sunxingbo
 *
 */
public class NumTool {
	/**
	 * ����ı�����
	 * @param text ��Ҫ��������
	 * @return �����ݲ�Ϊ���Ҿ�Ϊ�����򷵻�true�����������false
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
	 * �ı�ת��Ϊ����
	 * @param text
	 * @return 
	 */
	public static int toint(String text)
	{
		int a=Integer.parseInt(text);
		return a;
	}
}
