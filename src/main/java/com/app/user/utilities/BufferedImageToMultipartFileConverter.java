package com.app.user.utilities;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedImageToMultipartFileConverter {

	public static MultipartFile convert(BufferedImage bufferedImage, final String formatName) throws IOException {
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
			ImageIO.write(bufferedImage, formatName, byteArrayOutputStream);
			final byte[] bytes = byteArrayOutputStream.toByteArray();

			final Resource resource = new ByteArrayResource(bytes) {
				@Override
				public String getFilename() {
					return "image." + formatName;
				}
			};

			return new MultipartFile() {
				@Override
				public String getName() {
					return "image";
				}

				@Override
				public String getOriginalFilename() {
					return resource.getFilename();
				}

				@Override
				public String getContentType() {
					return "image/" + formatName;
				}

				@Override
				public boolean isEmpty() {
					return bytes.length == 0;
				}

				@Override
				public long getSize() {
					return bytes.length;
				}

				@Override
				public byte[] getBytes() throws IOException {
					return bytes;
				}

				@Override
				public InputStream getInputStream() throws IOException {
					return resource.getInputStream();
				}

				@Override
				public void transferTo(File dest) throws IOException, IllegalStateException {
					try (FileOutputStream fos = new FileOutputStream(dest)) {
						fos.write(bytes);
					}
				}
			};
		}
	}
}