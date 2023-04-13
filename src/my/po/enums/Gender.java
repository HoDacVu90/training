package my.po.enums;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;

public enum Gender {
	MALE("Male"), FEMALE("Female"), OTHER("Other");

	private String title;
	
	Gender(){};

	Gender(String value) {
		this.title = value;
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
	public String getTitle() {
		return title;
	}

	public static Gender getKind(String enumName) {
		for (Gender menuKind : Gender.values()) {
			if (menuKind.name().equalsIgnoreCase(enumName)) {
				return menuKind;
			}
		}
		return null;
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

	public static List<String> getListGender() {
		List<String> genders = new ArrayList<String>();
		for (Gender p : Gender.values()) {
			genders.add(p.getCmsValue());
		}
		return genders;
	}

	public String getCmsPath() {
		String value = cmsPath + this.name();
		return value;
	}

}
