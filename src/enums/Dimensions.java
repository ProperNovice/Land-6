package enums;

public enum Dimensions {

	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	GAP_BETWEEN_DICE(4, 4),
	GAP_BETWEEN_CUBES(GAP_BETWEEN_DICE.x(), GAP_BETWEEN_DICE.y()),
	GAP_BETWEEN_OPTION_TEXT_BORDER_AND_OPTION(5, 2),
	GAP_BETWEEN_TEXTS(1, 1),
	TILE(312, 312),
	SQUARE(TILE.x() / 2, TILE.y() / 2),
	DICE(TILE.x() / 6, TILE.y() / 6),
	CUBE(TILE.x() / 6, TILE.y() / 6),
	BUTTON_OPTION(DICE.x(), DICE.y()),
	TEXT_OPTION(-1, TILE.y() * 0.15),
	TEXT_INDICATOR(-1, TEXT_OPTION.y()),
	FRAME(4 * TILE.x() + 2 * GAP_BETWEEN_BORDERS.x(), 2 * (TILE.y() + GAP_BETWEEN_BORDERS.y())),
	RESTART(40, 40),


	;

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
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
