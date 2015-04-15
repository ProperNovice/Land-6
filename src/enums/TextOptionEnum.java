package enums;

public enum TextOptionEnum {
	
	DEPLOY_AN_ARMY("Deploy an army"),
	MOVE_AN_ARMY("Move an army"),
	CANCEL("Cancel"),

	;

	private String textOption = null;

	private TextOptionEnum(String textOption) {
		this.textOption = textOption;
	}

	public String textOption() {
		return this.textOption;
	}

}
