package enums;

public enum Coordinates {

	DICE_ARMY_TOP_LEFT(Dimensions.FRAME.x() - Dimensions.TILE.x() - Dimensions.GAP_BETWEEN_BORDERS.x() + (Dimensions.TILE.x() - 3 * Dimensions.DICE.x() - 2 * Dimensions.GAP_BETWEEN_DICE.x()) / 2, Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.TILE.y() / 2 + (Dimensions.TILE.y() / 2 - 2 * Dimensions.DICE.y() - Dimensions.GAP_BETWEEN_DICE.y()) / 2),
	TEXT_INDICATOR(Dimensions.FRAME.x() - Dimensions.GAP_BETWEEN_BORDERS.x() - Dimensions.TILE.x() + 10, Dimensions.GAP_BETWEEN_BORDERS.y()),
	TEXT_OPTION(TEXT_INDICATOR.x(), TEXT_INDICATOR.y()),
	CUBE_ARMY_TOP_LEFT(Dimensions.GAP_BETWEEN_BORDERS.x() + (Dimensions.TILE.x() - 3 * Dimensions.CUBE.x() - 2 * Dimensions.GAP_BETWEEN_CUBES.x()) / 2, Dimensions.GAP_BETWEEN_BORDERS.y() + (Dimensions.TILE.y() / 2 - 2 * Dimensions.DICE.y() - Dimensions.GAP_BETWEEN_DICE.y()) / 2),
	DICE_ACTION(Dimensions.GAP_BETWEEN_BORDERS.x() + (Dimensions.TILE.x() - Dimensions.DICE.x()) / 2, Dimensions.FRAME.y() - Dimensions.GAP_BETWEEN_BORDERS.y() - Dimensions.TILE.y() / 2 + (Dimensions.TILE.y() / 2 - Dimensions.DICE.y()) / 2),
	
	;

	private double x = -1, y = -1;

	private Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
