package enums;

public enum GameStateEnum {

	START_GAME("start game"),
	CHOOSE_SQUARE_DICE_ACTION("choose square dice"),
	SQUARE_CITY_PRESSED("square city pressed"),
	DEPLOY_ARMY("deploy army"),
	ANIMATING("animating"),
	MOVE_ARMY_ORIGIN("move army origin"),
	MOVE_ARMY_DESTINATION("move army destination"),
	LORD_OF_THE_CUBES_ACTION("lord of the cubes action"),
	REROLL_DICE("reroll dice"),
	CHOOSE_SEA_SQUARE_DICE("choose sea square dice"),
	CHOOSE_CITY_SQUARE_SUBSTRACT_ONE_POINT("choose city square substract one point"),
	FIGHT_LORD_OF_THE_CUBES("fight lord of the cubes"),
	CHOOSE_FOREST_SQUARE_SUBSTRACT_ONE_POINT("choose forest square substract one point"),
	CHOOSE_LORD_OF_THE_CUBES_ARMY_TO_REMOVE("choose lord of the cubes army to remove"),
	GAME_ENDED("game ended"),
	
	;

	private String text = null;

	private GameStateEnum(String text) {
		this.text = text;
	}

	public String text() {
		return this.text;
	}

}
