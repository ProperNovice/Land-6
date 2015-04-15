package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	CHOOSE_SQUARE_DICE("choose square dice"),
	SQUARE_CITY_PRESSED("square city pressed"),
	DEPLOY_ARMY("deploy army");
	
	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
