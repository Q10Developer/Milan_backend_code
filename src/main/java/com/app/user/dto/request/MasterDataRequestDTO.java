package com.app.user.dto.request;

public class MasterDataRequestDTO {

	private Long dataId;
	private Long dropDownId;
	private String dataKey;
	private int dataValue;
	private String dataLabel;
	private String dataType;
	private Long parentId;
	private int activeStatus;

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public Long getDropDownId() {
		return dropDownId;
	}

	public void setDropDownId(Long dropDownId) {
		this.dropDownId = dropDownId;
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
		builder.append("MasterDataRequestDTO [dataId=");
		builder.append(dataId);
		builder.append(", dropDownId=");
		builder.append(dropDownId);
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
