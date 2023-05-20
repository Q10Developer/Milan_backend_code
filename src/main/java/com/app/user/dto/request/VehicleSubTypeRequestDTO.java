package com.app.user.dto.request;

public class VehicleSubTypeRequestDTO {
     private  Long vehicleSubTypeId;
	private String vehiclesubTypeName;
	private  Long vehicleTypeId;
	private int  activeStatus;
	
	
	public VehicleSubTypeRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getVehicleSubTypeId() {
		return vehicleSubTypeId;
	}

	public void setVehicleSubTypeId(Long vehicleSubTypeId) {
		this.vehicleSubTypeId = vehicleSubTypeId;
	}

	public String getVehiclesubTypeName() {
		return vehiclesubTypeName;
	}

	public void setVehiclesubTypeName(String vehiclesubTypeName) {
		this.vehiclesubTypeName = vehiclesubTypeName;
	}

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "VehicleSubTypeRequestDTO [vehicleSubTypeId=" + vehicleSubTypeId + ", vehiclesubTypeName="
				+ vehiclesubTypeName + ", vehicleTypeId=" + vehicleTypeId + ", activeStatus=" + activeStatus + "]";
	}

	
}
