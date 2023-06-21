package com.app.user.utilities;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

@Service
public class AmazonS3Client {

	private AmazonS3 s3client;

	@Value("${AWS_S3_ENPOINT_URL}")
	private String endpointUrl;
	@Value("${AWS_S3_BUCKET_NAME}")
	private String globalBucketName;
	@Value("${AWS_S3_ACCESS_KEY_ID}")
	private String accessKey;
	@Value("${AWS_S3_SECRET_ACCESS_KEY}")
	private String secretKey;
	@Value("${AWS_S3_REGION}")
	private String s3Region;

	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = AmazonS3ClientBuilder.standard().withRegion(s3Region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}

	public String uploadFile(String bucketDirectory, String fileKeyName, MultipartFile multipartFile) {
		String fileUrl = "";
		try {
			File file = convertMultiPartToFile(multipartFile);
			String bucketName = globalBucketName;
			if (bucketDirectory.contains("bill-upload") || bucketDirectory.contains("create-group")
					|| bucketDirectory.contains("profile-picture")) {
				bucketName = globalBucketName;
			}
			uploadFileTos3bucket(bucketName, bucketDirectory + fileKeyName, file);
			file.delete();
			fileUrl = getS3ObjectUrl(bucketName, bucketDirectory + fileKeyName).toExternalForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private PutObjectResult uploadFileTos3bucket(String bucketName, String fileKeyName, File file) {
		return s3client.putObject(
				new PutObjectRequest(bucketName, fileKeyName, file).withCannedAcl(CannedAccessControlList.PublicRead));
	}

	private URL getS3ObjectUrl(String bucketname, String fileKeyName) {
		return s3client.getUrl(bucketname, fileKeyName);
	}

	public String deleteFileFromS3Bucket(String bucketDirectory, String fileKeyName) {
		String bucketName = globalBucketName;
		if (bucketDirectory.contains("bill-upload") || bucketDirectory.contains("create-group")
				|| bucketDirectory.contains("profile-picture")) {
			bucketName = globalBucketName;
		}
		s3client.deleteObject(new DeleteObjectRequest(bucketName, fileKeyName));
		return "Successfully deleted";
	}

}