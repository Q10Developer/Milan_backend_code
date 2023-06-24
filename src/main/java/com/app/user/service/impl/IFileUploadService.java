package com.app.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.utilities.AmazonS3Client;
import com.app.user.utilities.Utils;

@Service
public class IFileUploadService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IFileUploadService.class);

	@Value("${upload.directory}")
	private String uploadDirectory;

	@Value("${static.images.resources}")
	private String staticImagesResources;

	@Autowired
	private AmazonS3Client amazonS3Client;

	public ServiceResponseDTO uploadToLocalDirectory(MultipartFile file, String key, String uniqueKey) {
		ServiceResponseDTO response = null;
		try {
			String uniqueFileName = Utils.generateUniqueFileName(uniqueKey, file.getOriginalFilename());
			String uploadFilesPath = uploadDirectory + File.separator + key;
			File uploadFilesDir = new File(uploadFilesPath);
			if (!uploadFilesDir.exists()) {
				uploadFilesDir.mkdirs();
			}
			Path filePath = Path.of(uploadFilesPath + File.separator + uniqueFileName);
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			String staticResourceURL = staticImagesResources + uniqueFileName;
			response = new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, staticResourceURL);
		} catch (IOException ioe) {
			LOGGER.error(
					"IOException occur in IFileUploadService class in method uploadToLocalDirectory with IOException {}",
					ioe.getMessage());
			response = new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500, ioe.getMessage());
		} catch (Exception ex) {
			LOGGER.error(
					"Exception occur in IFileUploadService class in method uploadToLocalDirectory with Exception {}",
					ex.getMessage());
			response = new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500, ex.getMessage());
		}
		return response;
	}

	public ServiceResponseDTO uploadToAwsS3(MultipartFile file, String key, String uniqueKey) {
		ServiceResponseDTO response = null;
		String publicS3ImageUrl = null;
		try {
			String updatedFilename = Utils.generateUniqueFileName(uniqueKey, file.getOriginalFilename());
			publicS3ImageUrl = amazonS3Client.uploadFile(key + "/", updatedFilename, file);
			if (!StringUtils.isEmpty(publicS3ImageUrl)) {
				response = new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
						ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, publicS3ImageUrl);
			}
			response = new ServiceResponseDTO(uniqueKey, updatedFilename, publicS3ImageUrl);
		} catch (Exception ex) {
			LOGGER.error("Exception occur in IFileUploadService class in method uploadToAwsS3 with Exception {}",
					ex.getMessage());
			response = new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500, ex.getMessage());
		}
		return response;
	}

}
