package wyd.dto;

import java.io.Serializable;

public interface DTO extends Serializable {

	public static String ENABLED = "enabled";

	public static String DISABLED = "disabled";

	public static String ACTIVE = "active";

	public static String PASSIVE = "passive";

	void setDefaultValues();
}
