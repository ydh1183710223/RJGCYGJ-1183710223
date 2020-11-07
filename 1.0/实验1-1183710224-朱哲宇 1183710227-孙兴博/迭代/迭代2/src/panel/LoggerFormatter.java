package panel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggerFormatter extends Formatter{

	@Override
	public String format(LogRecord arg0) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ");
		String string = df.format(new Date())+"\n"+arg0.getMessage()+"\n"+"\n"+"\n";
		return string;
	}

}
