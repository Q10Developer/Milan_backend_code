package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_tire_pattern")
public class TirePatternEntity {

	@Id
	@GeneratedValue
	@Column(name = "tire_pattern_id")
	private Long tirePatternId;

	@Column(name = "tire_pattern")
	private String tirePattern;

	@ManyToOne
	@JoinColumn(name = "tire_make_id")
	private TireMakeEntity tireMakeId;

	@Column(name = "active_status")
	private int activeStatus;

	public Long getTirePatternId() {
		return tirePatternId;
	}

	public void setTirePatternId(Long tirePatternId) {
		this.tirePatternId = tirePatternId;
	}

	public String getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(String tirePattern) {
		this.tirePattern = tirePattern;
	}

	public TireMakeEntity getTireMakeId() {
		return tireMakeId;
	}

	public void setTireMakeId(TireMakeEntity tireMakeId) {
		this.tireMakeId = tireMakeId;
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
		builder.append("TirePatternEntity [tirePatternId=");
		builder.append(tirePatternId);
		builder.append(", tirePattern=");
		builder.append(tirePattern);
		builder.append(", tireMakeId=");
		builder.append(tireMakeId);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
