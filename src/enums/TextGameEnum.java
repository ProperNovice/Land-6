package enums;

public enum TextGameEnum {



	CHOOSE_SQUARE_DIE("Choose square die", TextGameType.INDICATOR),
	DEPLOY_AN_ARMY("Deploy an army", TextGameType.OPTION),
	MOVE_AN_ARMY("Move an army", TextGameType.OPTION),
	CANCEL("Cancel", TextGameType.OPTION),
	CHOOSE_SQUARE("Choose square", TextGameType.INDICATOR),
	CHOOSE_ARMY_TO_MOVE("Choose army to move", TextGameType.INDICATOR),
	CHOOSE_ARMY_DESTINATION("Choose destination", TextGameType.INDICATOR),
	CHOOSE_DICE_TO_REROLL("Choose dice to reroll", TextGameType.INDICATOR),
	REROLL_DICE("Reroll dice", TextGameType.OPTION),
	EXECUTE_DICE_ACTION("Execute dice action", TextGameType.OPTION),
	CHOOSE_SEA_SQUARE("Choose sea square", TextGameType.INDICATOR),
	CONTINUE_TILE_CONTAINS_DICE_ARMY("Continue", TextGameType.OPTION),
	ADDING_ARMY_CUBE_ON_TILE("Adding army cube", TextGameType.INDICATOR),
	CONTINUE_ADDDING_ARMY_CUBE_ON_TILE("Continue", TextGameType.OPTION),
	SUBSTRACT_ONE_POINT("Substract one point", TextGameType.INDICATOR),
	TO_EACH_DIE("to each die", TextGameType.INDICATOR),
	CHOOSE_CITY_SQUARE_TO_SUBSTRACT("Choose city die\nto substract", TextGameType.INDICATOR),
	CHOOSE_CUBE_ARMY("Choose cube army", TextGameType.INDICATOR),
	CONTINUE_NOTHING_HAPPENS("Continue", TextGameType.OPTION),
	NOTHING_HAPPENS("Nothing happens", TextGameType.INDICATOR),
	CHOOSE_FOREST_SQUARE_TO_SUBSTRACT("Choose forest die\nto substract", TextGameType.INDICATOR),
	CHOOSE_ARMY_CUBE("Choose army cube", TextGameType.INDICATOR),
	RESOLVE_FIGHT("Resolve fight", TextGameType.OPTION),
	SHOW_TILE_NUMBERS("Show tile numbers", TextGameType.OPTION),
	YOU_WON("You won", TextGameType.INDICATOR),
	YOU_LOST("You lost", TextGameType.INDICATOR),
	RESTART_GAME("Restart game", TextGameType.OPTION),
	FOR_YOUR_ACTION("for your action", TextGameType.INDICATOR),

	;

	public enum TextGameType {
		INDICATOR, OPTION
	}

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
