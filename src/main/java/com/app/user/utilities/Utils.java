package com.app.user.utilities;

import java.util.UUID;

public class Utils {

	public static String generateUniqueFileName(String uniqueKey, String originalFilename) {
		String extension = org.springframework.util.StringUtils.getFilenameExtension(originalFilename);
		return uniqueKey + "_" + UUID.randomUUID().toString() + "." + extension;
	}
}
