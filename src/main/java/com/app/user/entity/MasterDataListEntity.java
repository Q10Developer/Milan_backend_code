package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_data_list")
public class MasterDataListEntity {

	@Id
	@GeneratedValue
	@Column(name = "data_id")
	private Long dataId;

	@Column(name = "data_key", nullable = false)
	private String dataKey;

	@Column(name = "data_value", nullable = false)
	private int dataValue;

	@Column(name = "data_label", nullable = false)
	private String dataLabel;

	@Column(name = "data_type", nullable = false)
	private String dataType;

	@Column(name = "parent_id", nullable = false)
	private Long parentId;

	@Column(name = "active_status", nullable = false)
	private int activeStatus;

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public int getDataValue() {
		return dataValue;
	}

	public void setDataValue(int dataValue) {
		this.dataValue = dataValue;
	}

	public String getDataLabel() {
		return dataLabel;
	}

	public void setDataLabel(String dataLabel) {
		this.dataLabel = dataLabel;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
		builder.append("MasterDataListEntity [dataId=");
		builder.append(dataId);
		builder.append(", dataKey=");
		builder.append(dataKey);
		builder.append(", dataValue=");
		builder.append(dataValue);
		builder.append(", dataLabel=");
		builder.append(dataLabel);
		builder.append(", dataType=");
		builder.append(dataType);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
