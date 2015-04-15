package enums;

public enum TextIndicatorEnum {

	CHOOSE_SQUARE_DIE("Choose square die"),

	;

	private String textIndicator = null;

	private TextIndicatorEnum(String textIndicator) {
		this.textIndicator = textIndicator;
	}

	public String textIndicator() {
		return this.textIndicator;
	}

}
