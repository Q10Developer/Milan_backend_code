package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.service.impl.IFileUploadService;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.FILE_SERVICE)
public class FileUploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private IFileUploadService fileUploadService;

	@Value("${is.aws.s3.enabled}")
	private boolean isAwsS3Enabled;

	@PostMapping(value = URLConstants.UPLOAD_FILE)
	public ServiceResponseDTO uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("key") String key,
			@RequestParam("uniqueKey") String uniqueKey) {
		LOGGER.info("Executing  uploadFile() method of FileUploadController");
		if (!isAwsS3Enabled) {
			return fileUploadService.uploadToLocalDirectory(file, key, uniqueKey);
		} else {
			return fileUploadService.uploadToAwsS3(file, key, uniqueKey);
		}
	}
}