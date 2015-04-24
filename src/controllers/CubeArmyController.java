package controllers;

import utils.ArrayList;

import components.CubeArmy;

import enums.Coordinates;
import enums.Dimensions;

public class CubeArmyController {

	private ArrayList<CubeArmy> cubeArmy = new ArrayList<>();
	private double topLeftX, topLeftY;

	public CubeArmyController() {

		this.topLeftX = Coordinates.CUBE_ARMY_TOP_LEFT.x();
		this.topLeftY = Coordinates.CUBE_ARMY_TOP_LEFT.y();

		createCubes();
		relocateCubes();

	}

	private void createCubes() {
		for (int counter = 1; counter <= 6; counter++)
			this.cubeArmy.add(new CubeArmy());
	}

	private void relocateCubes() {

		int diceInRow = 3, cubePlaced = 0;
		double x = this.topLeftX;
		double y = this.topLeftY;

		for (CubeArmy cube : this.cubeArmy) {

			cube.relocate(x, y);
			cubePlaced++;

			if (cubePlaced < diceInRow) {

				x += Dimensions.CUBE.x();
				x += Dimensions.GAP_BETWEEN_DICE.x();

			} else if (cubePlaced == diceInRow) {

				cubePlaced = 0;
				x = this.topLeftX;
				y += Dimensions.CUBE.y();
				y += Dimensions.GAP_BETWEEN_DICE.y();

			}

		}

	}

	public CubeArmy getDice() {
		return this.cubeArmy.removeLast();
	}

	public boolean isEmpty() {
		return this.cubeArmy.isEmpty();
	}

	public void addCube(CubeArmy cubeArmy) {

		this.cubeArmy.add(cubeArmy);

		int row = this.cubeArmy.indexOf(cubeArmy) / 3;
		int column = this.cubeArmy.indexOf(cubeArmy) - row * 3;

		double endingX = this.topLeftX + column
				* (Dimensions.CUBE.x() + Dimensions.GAP_BETWEEN_CUBES.x());
		double endingY = this.topLeftY + row
				* (Dimensions.CUBE.y() + Dimensions.GAP_BETWEEN_CUBES.y());

		cubeArmy.animateSynchronous(endingX, endingY);

	}

	public int size() {
		return this.cubeArmy.size();
	}
	
	public boolean contains(CubeArmy cubeArmy) {
		return this.cubeArmy.contains(cubeArmy);
	}

}
