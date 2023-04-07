package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tyre_master")
public class TyreMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "tyre_id")
	private Long tyreId;

	@Column(name = "tyre_make", nullable = false)
	private Long tyreMake;

	@Column(name = "tyre_type", nullable = false)
	private Long tyreType;

	@Column(name = "tyre_number", nullable = false)
	private String tyreNumber;

	@Column(name = "tyre_size", nullable = false)
	private Long tyreSize;

	@Column(name = "tyre_pattern", nullable = false)
	private Long tyrePattern;

	@Column(name = "tyre_thickness", nullable = false)
	private Double tyreThickness;

	@Column(name = "tyre_recommended_pressure", nullable = false)
	private Double tyreRecommendedPressure;

	@Column(name = "active_status")
	private int activeStatus;

	public Long getTyreId() {
		return tyreId;
	}

	public void setTyreId(Long tyreId) {
		this.tyreId = tyreId;
	}

	public Long getTyreMake() {
		return tyreMake;
	}

	public void setTyreMake(Long tyreMake) {
		this.tyreMake = tyreMake;
	}

	public Long getTyreType() {
		return tyreType;
	}

	public void setTyreType(Long tyreType) {
		this.tyreType = tyreType;
	}

	public String getTyreNumber() {
		return tyreNumber;
	}

	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}

	public Long getTyreSize() {
		return tyreSize;
	}

	public void setTyreSize(Long tyreSize) {
		this.tyreSize = tyreSize;
	}

	public Long getTyrePattern() {
		return tyrePattern;
	}

	public void setTyrePattern(Long tyrePattern) {
		this.tyrePattern = tyrePattern;
	}

	public Double getTyreThickness() {
		return tyreThickness;
	}

	public void setTyreThickness(Double tyreThickness) {
		this.tyreThickness = tyreThickness;
	}

	public Double getTyreRecommendedPressure() {
		return tyreRecommendedPressure;
	}

	public void setTyreRecommendedPressure(Double tyreRecommendedPressure) {
		this.tyreRecommendedPressure = tyreRecommendedPressure;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TyreMasterEntity [tyreId=");
		builder.append(tyreId);
		builder.append(", tyreMake=");
		builder.append(tyreMake);
		builder.append(", tyreNumber=");
		builder.append(tyreNumber);
		builder.append(", tyreSize=");
		builder.append(tyreSize);
		builder.append(", tyrePattern=");
		builder.append(tyrePattern);
		builder.append(", tyreThickness=");
		builder.append(tyreThickness);
		builder.append(", tyreRecommendedPressure=");
		builder.append(tyreRecommendedPressure);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
