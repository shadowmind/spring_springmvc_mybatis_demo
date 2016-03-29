package org.shadow.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtils {

	public static String getCurrentTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(Calendar.getInstance().getTime());
		
		return time;
	}
}
