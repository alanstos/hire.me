package org.hire.me.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataUtil {
	
	public static Calendar getAgora(){
		return Calendar.getInstance(new Locale("pt", "BR"));
	}
	
	public static long getAgoraInMillis(){
		return getAgora().getTimeInMillis();
	}	
	
	public static Date getAgoraDate(){
		return getAgora().getTime();
	}

}
