package com.app.user.dto.request;

public class DropDownMasterDTO {

	private Long dropDownId;
	private String dropDownName;
	private String dropDownKey;
	private Boolean isChild;
	private Long parentDropDownId;
	private int activeStatus;

	public Long getDropDownId() {
		return dropDownId;
	}

	public void setDropDownId(Long dropDownId) {
		this.dropDownId = dropDownId;
	}

	public String getDropDownName() {
		return dropDownName;
	}

	public void setDropDownName(String dropDownName) {
		this.dropDownName = dropDownName;
	}

	public String getDropDownKey() {
		return dropDownKey;
	}

	public void setDropDownKey(String dropDownKey) {
		this.dropDownKey = dropDownKey;
	}

	public Boolean getIsChild() {
		return isChild;
	}

	public void setIsChild(Boolean isChild) {
		this.isChild = isChild;
	}

	public Long getParentDropDownId() {
		return parentDropDownId;
	}

	public void setParentDropDownId(Long parentDropDownId) {
		this.parentDropDownId = parentDropDownId;
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
		builder.append("DropDownMasterDTO [dropDownId=");
		builder.append(dropDownId);
		builder.append(", dropDownName=");
		builder.append(dropDownName);
		builder.append(", dropDownKey=");
		builder.append(dropDownKey);
		builder.append(", isChild=");
		builder.append(isChild);
		builder.append(", parentDropDownId=");
		builder.append(parentDropDownId);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
