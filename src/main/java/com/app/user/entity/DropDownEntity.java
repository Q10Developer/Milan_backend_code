package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drop_down_master")
public class DropDownEntity {

	@Id
	@GeneratedValue
	@Column(name = "drop_down_id")
	private Long dropDownId;

	@Column(name = "drop_down_name", nullable = false, unique = true)
	private String dropDownName;

	@Column(name = "drop_down_key", nullable = false, unique = true)
	private String dropDownKey;

	@Column(name = "is_child")
	private Boolean isChild;

	@Column(name = "parent_drop_down_id")
	private Long parentDropDownId;

	@Column(name = "active_status")
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
		builder.append("DropDownEntity [dropDownId=");
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
