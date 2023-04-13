package my.po.enums;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;

public enum ProcessState {
	CREATE_PROMOTION,
	WAITING_APPROVE,
	DONE;
	
	private String cmsPath = "/Promote/";

	public String getCmsValue() {
		String value = "";

		String path = getCmsPath();

		if (Ivy.cms().get(path).isPresent()) {
			value = Ivy.cms().coLocale(path, Ivy.session().getContentLocale());
		}

		return value;
	}

	public static List<String> getListForProcessChain() {
		List<String> pStates = new ArrayList<String>();
		for (ProcessState p : ProcessState.values()) {
			pStates.add(p.getCmsValue());
		}
		return pStates;
	}

	public int getStepForProcessChain() {
		int index = 0;
		index = this.ordinal();
		return index;
	}

	public String getCmsPath() {
		String value = cmsPath + this.name();
		return value;
	}
}
