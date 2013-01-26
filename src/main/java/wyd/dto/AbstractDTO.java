package wyd.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public abstract class AbstractDTO implements DTO {

	@NotNull
	protected Date createdTime;

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	@NotNull
	protected Date updatedTime;

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}
}
