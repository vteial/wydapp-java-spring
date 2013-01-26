package wyd.dto;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class Operation extends AbstractDTO {

	@Override
	public void setDefaultValues() {
		this.setId("");
		this.setName("");
	}
/*
	@Override
	public String toString() {
		ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", this.id);
		toStringHelper.add("name", this.name);
		toStringHelper.add("operations", this.uris);
		return toStringHelper.toString();
	}
*/
	
	
	
	private String id;

	@Override
	public String toString() {
		return "Operation [id=" + id + ", name=" + name + ", uris=" + uris
				+ "]";
	}

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

	private List<String> uris;

	public List<String> getUris() {
		return uris;
	}

	public void setUris(List<String> uris) {
		this.uris = uris;
	}
}