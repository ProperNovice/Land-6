package components;

import instances.Instances;
import utils.ArrayList;
import utils.ImageView;
import utils.Logger;
import utils.Random;
import enums.Dimensions;
import enums.SquareEnum;
import gui.PanelGame;

public class Tile {

	private int tileNumber = -1;
	private ArrayList<Square> squares = new ArrayList<>();
	private ImageView imageView = null;
	private double topLeftX, topLeftY;
	private ArrayList<CubeArmy> cubeArmy = new ArrayList<>();

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

		this.topLeftX = x;
		this.topLeftY = y;

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

			if (!square.containsDiceArmy())
				continue;

			adjacencies.addAll(square.getAdjacenciesClone());
		}

		return adjacencies;
	}

	public boolean containsAtLeastOneSquareDiceMovable() {

		boolean isMovable = false;

		for (Square square : this.squares) {

			if (square.getSquareEnum().equals(SquareEnum.CITY))
				continue;

			if (!square.containsDiceArmy())
				continue;

			isMovable = true;
			break;

		}

		return isMovable;

	}

	public boolean containsAtLeastOneSquareThatCanDeployArmy() {

		boolean canDeployArmy = false;

		for (Square squareTemp : this.squares) {

			if (!squareTemp.getSquareEnum().equals(SquareEnum.CITY))
				continue;

			if (!squareTemp.containsDiceArmy())
				continue;

			for (Square square : squareTemp.getAdjacenciesClone()) {

				if (square.containsDiceArmy())
					continue;

				canDeployArmy = true;
				break;

			}

			if (canDeployArmy)
				break;

		}

		return canDeployArmy;

	}

	public boolean cityContainsDiceArmy() {

		boolean containsCityDiceArmy = false;

		for (Square square : this.squares)
			if (square.getSquareEnum().equals(SquareEnum.CITY))
				if (square.containsDiceArmy())
					containsCityDiceArmy = true;

		return containsCityDiceArmy;

	}

	public void addOneToDiceArmyInNonGrowinfFieldSquare() {

		for (Square square : this.squares)
			if (!square.getSquareEnum().equals(SquareEnum.GROWING_FIELD))
				if (square.containsDiceArmy())
					if (!square.diceArmyIsMaxValue())
						square.addOnePointToDice();

	}

	public int getTileNumber() {
		return this.tileNumber;
	}

	public boolean containsCubeArmy() {
		if (this.cubeArmy.isEmpty())
			return false;
		else
			return true;
	}

	public boolean containsDiceArmy() {

		for (Square square : this.squares)
			if (square.containsDiceArmy())
				return true;

		return false;
	}

	public void addCubeArmyAnimateSynchronous(CubeArmy cubeArmy) {

		this.cubeArmy.add(cubeArmy);
		cubeArmy.setTile(this);

		double endingX = this.topLeftX
				+ (Dimensions.TILE.x() - Dimensions.CUBE.x()) / 2;
		double endingY = this.topLeftY
				+ (Dimensions.TILE.y() - Dimensions.CUBE.y()) / 2;

		cubeArmy.animateSynchronous(endingX, endingY);

	}

	public boolean seaSquareHasDice() {

		for (Square square : this.squares)
			if (square.getSquareEnum().equals(SquareEnum.SEA))
				return square.containsDiceArmy();

		Logger.logNewLine("should not be here - seaSquareHasDice");
		return false;

	}

	public ArrayList<Square> getSquaresWithDiceArmy() {

		ArrayList<Square> list = new ArrayList<>();

		for (Square square : this.squares)
			if (square.containsDiceArmy())
				list.add(square);

		return list;

	}

	public CubeArmy removeCubeArmy() {
		this.cubeArmy.get(0).setTile(null);
		return this.cubeArmy.remove(0);
	}

	public boolean containsForestSquareWithDiceAction() {

		for (Square square : this.squares)
			if (square.getSquareEnum().equals(SquareEnum.FOREST))
				return square.containsDiceArmy();

		Logger.logNewLine("should not be here - containsForestSquareWithDiceAction");
		return false;

	}

	public void flashCubeArmy() {
		this.cubeArmy.get(0).flash();
	}

	public boolean isFlashing() {
		return this.cubeArmy.get(0).isFlashing();
	}

	public boolean gameIsWon() {

		if (!this.cubeArmy.isEmpty())
			return false;

		Square citySquare = null;

		for (Square square : this.squares)
			if (square.getSquareEnum().equals(SquareEnum.CITY)) {
				citySquare = square;
				break;
			}

		if (!citySquare.containsDiceArmy())
			return false;

		if (!citySquare.diceArmyIsShowingAtLeast3())
			return false;

		return true;
	}

}
