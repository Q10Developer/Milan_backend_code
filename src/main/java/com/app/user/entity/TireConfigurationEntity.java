package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_tire_configuration")
public class TireConfigurationEntity {

	@Id
	@GeneratedValue
	@Column(name = "tire_configuration_id")
	private Long tireConfigurationId;

	@ManyToOne
	@JoinColumn(name = "tire_make_id")
	private TireMakeEntity tireMakeId;

	@Column(name = "tire_type")
	private String tireType;

	@Column(name = "tire_size")
	private String tireSize;

	@Column(name = "tire_pattern")
	private String tirePattern;

	@Column(name = "tire_thickness")
	private float tireThickness;

	@Column(name = " active_status")
	private int activeStatus;

	public Long getTireConfigurationId() {
		return tireConfigurationId;
	}

	public void setTireConfigurationId(Long tireConfigurationId) {
		this.tireConfigurationId = tireConfigurationId;
	}

	public TireMakeEntity getTireMakeId() {
		return tireMakeId;
	}

	public void setTireMakeId(TireMakeEntity tireMakeId) {
		this.tireMakeId = tireMakeId;
	}

	public String getTireType() {
		return tireType;
	}

	public void setTireType(String tireType) {
		this.tireType = tireType;
	}

	public String getTireSize() {
		return tireSize;
	}

	public void setTireSize(String tireSize) {
		this.tireSize = tireSize;
	}

	public String getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(String tirePattern) {
		this.tirePattern = tirePattern;
	}

	public float getTireThickness() {
		return tireThickness;
	}

	public void setTireThickness(float tireThickness) {
		this.tireThickness = tireThickness;
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
		builder.append("TireConfigurationEntity [tireConfigurationId=");
		builder.append(tireConfigurationId);
		builder.append(", tireMakeId=");
		builder.append(tireMakeId);
		builder.append(", tireType=");
		builder.append(tireType);
		builder.append(", tireSize=");
		builder.append(tireSize);
		builder.append(", tirePattern=");
		builder.append(tirePattern);
		builder.append(", tireThickness=");
		builder.append(tireThickness);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
