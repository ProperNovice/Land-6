package controllers;

import utils.ArrayList;

import components.DiceArmy;
import components.Tile;

import enums.Dimensions;
import enums.SquareEnum;

public class TileController {

	private ArrayList<Tile> tiles = new ArrayList<>();

	public TileController() {
		createTiles();
		rotateTiles();
		relocateTiles();
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

	public void addStartingDice(DiceArmy dice) {
		this.tiles.get(5).getSquare(1).addDiceAnimateSynchronous(dice);
	}

}
