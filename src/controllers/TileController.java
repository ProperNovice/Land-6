package controllers;

import instances.Instances;
import utils.ArrayList;
import utils.Logger;
import components.CubeArmy;
import components.DiceArmy;
import components.Square;
import components.Tile;
import enums.Dimensions;
import enums.SquareEnum;

public class TileController {

	private ArrayList<Tile> tiles = new ArrayList<>();

	public TileController() {
		createTiles();
		rotateTiles();
		relocateTiles();
		createExternalAdjacencies();
	}

	private void createTiles() {

		Tile startPlayer = new Tile(1, SquareEnum.SEA, SquareEnum.CITY,
				SquareEnum.GROWING_FIELD, SquareEnum.FOREST);
		Tile startOpponent = new Tile(6, SquareEnum.GROWING_FIELD,
				SquareEnum.CITY, SquareEnum.SEA, SquareEnum.FOREST);

		ArrayList<Tile> tilesTemp = new ArrayList<>();

		tilesTemp.add(new Tile(2, SquareEnum.SEA, SquareEnum.CITY,
				SquareEnum.FOREST, SquareEnum.GROWING_FIELD));
		tilesTemp.add(new Tile(3, SquareEnum.GROWING_FIELD, SquareEnum.CITY,
				SquareEnum.FOREST, SquareEnum.SEA));
		tilesTemp.add(new Tile(4, SquareEnum.FOREST, SquareEnum.CITY,
				SquareEnum.SEA, SquareEnum.GROWING_FIELD));
		tilesTemp.add(new Tile(5, SquareEnum.FOREST, SquareEnum.CITY,
				SquareEnum.GROWING_FIELD, SquareEnum.SEA));

		tilesTemp.shuffle();

		this.tiles.add(startOpponent);
		this.tiles.addAll(tilesTemp);
		this.tiles.add(startPlayer);

	}

	private void relocateTiles() {

		double x, y;
		double yMidRow = Dimensions.GAP_BETWEEN_BORDERS.y()
				+ Dimensions.TILE.y() / 2;
		double yTopRow = Dimensions.GAP_BETWEEN_BORDERS.y();
		double yBottomRow = yTopRow + Dimensions.TILE.y();

		x = Dimensions.GAP_BETWEEN_BORDERS.x();

		y = yMidRow;
		this.tiles.get(0).relocate(x, y);

		x += Dimensions.TILE.x();

		y = yTopRow;
		this.tiles.get(1).relocate(x, y);

		y = yBottomRow;
		this.tiles.get(2).relocate(x, y);

		x += Dimensions.TILE.x();

		y = yTopRow;
		this.tiles.get(3).relocate(x, y);

		y = yBottomRow;
		this.tiles.get(4).relocate(x, y);

		x += Dimensions.TILE.x();
		y = yMidRow;
		this.tiles.get(5).relocate(x, y);

	}

	private void rotateTiles() {

		this.tiles.get(0).setRotateTwice();

		for (int counter = 1; counter <= this.tiles.size() - 2; counter++)
			this.tiles.get(counter).setRotateRandom();

	}

	private void createExternalAdjacencies() {

		Square squareOne, squareTwo;

		squareOne = getSquare(0, 1);
		squareTwo = getSquare(1, 3);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(0, 2);
		squareTwo = getSquare(2, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(1, 1);
		squareTwo = getSquare(3, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(1, 2);
		squareTwo = getSquare(3, 3);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(2, 1);
		squareTwo = getSquare(4, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(2, 2);
		squareTwo = getSquare(4, 3);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(3, 2);
		squareTwo = getSquare(5, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(4, 1);
		squareTwo = getSquare(5, 3);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(1, 3);
		squareTwo = getSquare(2, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(1, 2);
		squareTwo = getSquare(2, 1);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(3, 3);
		squareTwo = getSquare(4, 0);
		createAdjacency(squareOne, squareTwo);

		squareOne = getSquare(3, 2);
		squareTwo = getSquare(4, 1);
		createAdjacency(squareOne, squareTwo);

	}

	private Square getSquare(int tile, int square) {
		return this.tiles.get(tile).getSquareId(square);
	}

	private void createAdjacency(Square squareOne, Square squareTwo) {
		squareOne.addAdjacent(squareTwo);
		squareTwo.addAdjacent(squareOne);
	}

	public void addStartingDice(DiceArmy dice) {
		this.tiles.get(5).getSquareId(1).addDiceAnimateSynchronous(dice);
	}

	public void enableButtonSquaresForDeployArmy() {

		ArrayList<Square> citiesAdjacencies = new ArrayList<>();
		ArrayList<Square> citiesAdjacenciesTemp = new ArrayList<>();

		for (Tile tile : this.tiles)
			citiesAdjacenciesTemp.addAll(tile
					.getAdjacenciesToCityThatContainDice());

		for (Square square : citiesAdjacenciesTemp) {

			if (citiesAdjacencies.contains(square))
				continue;

			if (square.containsDiceArmy())
				continue;

			citiesAdjacencies.add(square);
			square.setVisibleButtonOption(true);

		}

		Instances.getControllerInstance().credentialController()
				.setSquareButtons(citiesAdjacencies);

	}

	public boolean atLeastOneSquareIsAvailableToDeplyArmy() {

		boolean availableToDeploy = false;

		for (Tile tile : this.tiles) {

			if (!tile.containsAtLeastOneSquareThatCanDeployArmy())
				continue;

			availableToDeploy = true;
			break;

		}

		return availableToDeploy;
	}

	public boolean atLeastOneSquareDiceIsMovable() {

		boolean isMovable = false;

		for (Tile tile : this.tiles) {

			if (!tile.containsAtLeastOneSquareDiceMovable())
				continue;

			isMovable = true;
			break;

		}

		return isMovable;

	}

	public boolean moreThanOneCitiesContainDiceArmy() {

		int citiesThatContainDice = 0;

		for (Tile tile : this.tiles) {

			if (tile.cityContainsDiceArmy())
				citiesThatContainDice++;

			if (citiesThatContainDice < 2)
				continue;

			break;

		}

		if (citiesThatContainDice >= 2)
			return true;
		else
			return false;

	}

	public void addOneToDiceArmyInNonGrowinfFieldSquare() {

		for (Tile tile : this.tiles)
			tile.addOneToDiceArmyInNonGrowinfFieldSquare();

	}

	public void addCubeArmyAnimateSynchronous(CubeArmy cubeArmy,
			int numberOfTile) {

		for (Tile tile : this.tiles)
			if (tile.getTileNumber() == numberOfTile)
				tile.addCubeArmyAnimateSynchronous(cubeArmy);

	}

	public boolean tileContainsCubeArmy(int tileNumber) {

		for (Tile tile : this.tiles)
			if (tile.getTileNumber() == tileNumber)
				return tile.containsCubeArmy();

		Logger.logNewLine("should not be here - tileContainsCubeArmy");

		return false;
	}

	public boolean tileContainsDiceArmy(int tileNumber) {

		for (Tile tile : this.tiles)
			if (tile.containsDiceArmy())
				return true;

		return false;
	}

	public boolean atLeastOneSeaSquareHasDice() {

		for (Tile tile : this.tiles)
			if (tile.seaSquareHasDice())
				return true;

		return false;

	}

	public ArrayList<Square> getSquaresThatContainDiceOnTileNumber(
			int tileNumber) {

		for (Tile tile : this.tiles)
			if (tile.getTileNumber() == tileNumber)
				return tile.getSquaresWithDiceArmy();

		Logger.logNewLine("should not be here - getSquaresThatContainDiceOnTileNumber");

		return null;

	}

}
