package wyd.dto;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Strings;

public class User extends AbstractDTO {

	@Override
	public void setDefaultValues() {
		this.setId("");
		this.setPassword("");
		this.setName("");
		this.setEmailId("");
		this.setStatus(DTO.ENABLED);
	}

	@Override
	public String toString() {
		ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", this.id);
		toStringHelper.add("password", this.password);
		toStringHelper.add("name", this.name);
		toStringHelper.add("emailId", this.emailId);
		toStringHelper.add("status", this.status);
		if (this.role != null) {
			toStringHelper.add("roleId", this.role.getId());
		} else {
			toStringHelper.add("roleId", "NULL");
		}
		toStringHelper.add("createdTime", this.createdTime);
		toStringHelper.add("updatedTime", this.updatedTime);
		return toStringHelper.toString();
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	private String parentId;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	private String status;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		status = Strings.nullToEmpty(status);
		status = status.toLowerCase();
		if (status.equals(DTO.ENABLED)) {
			this.status = DTO.ENABLED;
		} else {
			this.status = DTO.DISABLED;
		}
	}

	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
