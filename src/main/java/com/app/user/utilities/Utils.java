package com.app.user.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Utils {

	public static String generateUniqueFileName(String uniqueKey, String originalFilename) {
		String extension = org.springframework.util.StringUtils.getFilenameExtension(originalFilename);
		return uniqueKey + "_" + UUID.randomUUID().toString() + "." + extension;
	}

	public static boolean compareDates(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		} else {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			cal1.set(Calendar.HOUR_OF_DAY, 0);
			cal1.set(Calendar.MINUTE, 0);
			cal1.set(Calendar.SECOND, 0);
			cal1.set(Calendar.MILLISECOND, 0);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			cal2.set(Calendar.HOUR_OF_DAY, 0);
			cal2.set(Calendar.MINUTE, 0);
			cal2.set(Calendar.SECOND, 0);
			cal2.set(Calendar.MILLISECOND, 0);
			return cal1.getTime().equals(cal2.getTime());
		}
	}
}
