package Utilities;

import java.util.Date;

public class DateUtils {

	public static String getTymStamp() {
		
		Date date=new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
