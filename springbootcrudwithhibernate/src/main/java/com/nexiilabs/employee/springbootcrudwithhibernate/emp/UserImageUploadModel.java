package com.nexiilabs.employee.springbootcrudwithhibernate.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_image_uploads")
public class UserImageUploadModel  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_image_uploads_id")
	private int attachmentId;
	@Column(name = "image_extension")
	private String fileType;
	@Column(name = "image_name")
	private String fileName;
	@Column(name = "image_location")
	private String fileLocation;
	@Column(name="fk_user_id")
	private int userId;
	@Column(name = "image_size")
	private String fileSize;
	@Column(name="fk_emp_id")
	private int empId;
	@Column(name = "created_by")
	private int createdBy;
	@Column(name = "updated_by")
	private int updatedBy;
	@Column(name = "deleted_by")
	private int deletedBy;
	@Column(name = "delete_status")
	private int deleteStatus;
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(int deletedBy) {
		this.deletedBy = deletedBy;
	}
	public int getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserImageUploadModel [attachmentId=");
		builder.append(attachmentId);
		builder.append(", fileType=");
		builder.append(fileType);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", fileLocation=");
		builder.append(fileLocation);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", empId=");
		builder.append(empId);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", deletedBy=");
		builder.append(deletedBy);
		builder.append(", deleteStatus=");
		builder.append(deleteStatus);
		builder.append("]");
		return builder.toString();
	}
	

}
