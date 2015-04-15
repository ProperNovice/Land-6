package enums;

public enum Dimensions {

	FRAME(1366 - 66, 768 - 68),
	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	GAP_BETWEEN_DICE(2, 1),
	TILE(300, 300),
	DICE(TILE.x() / 6, TILE.y() / 6),

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
