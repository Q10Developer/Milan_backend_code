package com.app.user.config.helper;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) {
		String generatedId = "MTSS" + getRandomSubstring(7);
		while (isInspectionIdExists(generatedId, session)) {
			generatedId = "MTSS" + getRandomSubstring(7);
		}
		return generatedId.toUpperCase();
	}

	private String getRandomSubstring(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

	private boolean isInspectionIdExists(String inspectionId, SharedSessionContractImplementor session) {
		Query query = session.createQuery(
				"SELECT COUNT(vi) FROM VehicleInspectionEntity vi WHERE " + "vi.inspectionId = :inspectionId");
		query.setParameter("inspectionId", inspectionId);
		Long count = (Long) query.getSingleResult();
		return count > 0;
	}
}
