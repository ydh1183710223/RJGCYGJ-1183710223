package other;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
/**
 * 日志格式类
 * @author sunxingbo
 *
 */
public class LoggerFormatter extends Formatter{

	@Override
	public String format(LogRecord arg0) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		String string = df.format(new Date())+"\n"+arg0.getMessage()+"\n"+"\n"+"\n";
		return string;
	}

}
