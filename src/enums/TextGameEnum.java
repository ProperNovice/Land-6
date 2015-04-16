package enums;

public enum TextGameEnum {

	CHOOSE_SQUARE_DIE("Choose square die", TextGameType.INDICATOR),
	DEPLOY_AN_ARMY("Deploy an army", TextGameType.OPTION),
	MOVE_AN_ARMY("Move an army", TextGameType.OPTION),
	CANCEL("Cancel", TextGameType.OPTION),
	CHOOSE_SQUARE("Choose square", TextGameType.INDICATOR),

	;

	private String text = null;
	private TextGameType textGameType = null;

	private TextGameEnum(String text, TextGameType textGameType) {
		this.text = text;
		this.textGameType = textGameType;
	}

	public String getText() {
		return this.text;
	}

	public TextGameType getTextGameType() {
		return this.textGameType;
	}

}
