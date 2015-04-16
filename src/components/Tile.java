package components;

import instances.Instances;
import utils.ArrayList;
import utils.ImageView;
import utils.Random;
import enums.Dimensions;
import enums.SquareEnum;
import gui.PanelGame;

public class Tile {

	private int tileNumber = -1;
	private ArrayList<Square> squares = new ArrayList<>();
	private ImageView imageView = null;

	public Tile(int tileNumber, SquareEnum... squareList) {

		this.tileNumber = tileNumber;

		for (int counter = 0; counter < squareList.length; counter++)
			this.squares.add(new Square(squareList[counter]));

		createTile();
		createInternalAdjacencies();

	}

	private void createTile() {

		String path = "tiles/";
		path += Integer.toString(this.tileNumber);
		path += ".png";
		PanelGame panelGame = Instances.getPanelGameInstance();
		this.imageView = new ImageView(path, panelGame);
		this.imageView.setWidth(Dimensions.TILE.x());

	}

	private void createInternalAdjacencies() {

		this.squares.get(0).addAdjacent(this.squares.get(1));
		this.squares.get(1).addAdjacent(this.squares.get(0));
		this.squares.get(1).addAdjacent(this.squares.get(2));
		this.squares.get(2).addAdjacent(this.squares.get(1));
		this.squares.get(2).addAdjacent(this.squares.get(3));
		this.squares.get(3).addAdjacent(this.squares.get(2));
		this.squares.get(3).addAdjacent(this.squares.get(0));
		this.squares.get(0).addAdjacent(this.squares.get(3));

	}

	public void relocate(double x, double y) {

		this.imageView.relocate(x, y);

		this.squares.get(0).setTopLeftCoordinates(x, y);

		x += Dimensions.TILE.x() / 2;
		this.squares.get(1).setTopLeftCoordinates(x, y);

		y += Dimensions.TILE.x() / 2;
		this.squares.get(2).setTopLeftCoordinates(x, y);

		x -= Dimensions.TILE.x() / 2;
		this.squares.get(3).setTopLeftCoordinates(x, y);

	}

	public void setRotateTwice() {
		setRotate(2);
	}

	public void setRotateRandom() {

		int timesToRotate = Random.getRandomNumber(0, 3);
		setRotate(timesToRotate);

	}

	private void setRotate(int timesToRotate) {

		this.imageView.setRotate(90 * timesToRotate);

		for (int counter = 1; counter <= timesToRotate; counter++)
			this.squares.add(0, this.squares.remove(this.squares.size() - 1));

	}

	public Square getSquareId(int square) {
		return this.squares.get(square);
	}

	public ArrayList<Square> getAdjacenciesToCityThatContainDice() {

		ArrayList<Square> adjacencies = new ArrayList<>();

		for (Square square : this.squares) {

			if (!square.getSquareEnum().equals(SquareEnum.CITY))
				continue;

			if (!square.containsDice())
				continue;

			adjacencies.addAll(square.getAdjacenciesClone());
		}

		return adjacencies;
	}

}
