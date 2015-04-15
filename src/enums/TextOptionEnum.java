package enums;

public enum TextOptionEnum {
	
	DEPLOY_THE_ARMY("Deploy the army"),

	;

	private String textOption = null;

	private TextOptionEnum(String textOption) {
		this.textOption = textOption;
	}

	public String textOption() {
		return this.textOption;
	}

}
