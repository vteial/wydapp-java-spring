package wyd.dto;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Strings;

public class Role extends AbstractDTO {

	@Override
	public void setDefaultValues() {
		this.setId("");
		this.setName("");
	}

	@Override
	public String toString() {
		ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", this.id);
		toStringHelper.add("name", this.name);
		toStringHelper.add("status", this.status);
		toStringHelper.add("operations", this.operations);
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

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	private String operations;

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
