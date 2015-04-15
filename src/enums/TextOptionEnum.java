package enums;

public enum TextOptionEnum {
	
	DEPLOY_THE_ARMY("Deploy the army"),
	DEPLaOY_THE_ARMY("Deploy the army"),
	DEPLsOY_THE_ARMY("Deploy the army"),
	DEPLaaOY_THE_ARMY("Deploy the army"),

	;

	private String textOption = null;

	private TextOptionEnum(String textOption) {
		this.textOption = textOption;
	}

	public String textOption() {
		return this.textOption;
	}

}
