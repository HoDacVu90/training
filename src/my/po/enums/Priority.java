package my.po.enums;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;

public enum Priority {
	LOW("Low"), MEDIUM("Medium"), HIGH("High"), CRITICAL("Critical");

	private String value;

	Priority(){}
	
	Priority(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	private String cmsPath = "/Promote/";

	public String getCmsValue() {
		String value = "";

		String path = getCmsPath();

		if (Ivy.cms().get(path).isPresent()) {
			value = Ivy.cms().coLocale(path, Ivy.session().getContentLocale());
		}

		return value;
	}

	public static List<String> getListPriority() {
		List<String> priorities = new ArrayList<String>();
		for (Priority p : Priority.values()) {
			priorities.add(p.getCmsValue());
		}
		return priorities;
	}

	public String getCmsPath() {
		String value = cmsPath + this.name();
		return value;
	}
	
}
