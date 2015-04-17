package controllers;

import utils.ArrayList;
import components.Square;

public class CredentialController {

	private Square squarePressedCity = null;
	private Square squarePressedNonCity = null;
	private ArrayList<Square> squareButtons = null;
	private ArrayList<Square> squareAdjacencies = null;

	public CredentialController() {

	}

	public void setSquarePressedCity(Square squarePressed) {
		this.squarePressedCity = squarePressed;
	}

	public Square getSquarePressedCity() {
		return this.squarePressedCity;
	}

	public void setSquarePressedNonCity(Square squarePressed) {
		this.squarePressedNonCity = squarePressed;
	}

	public Square getSquarePressedNonCity() {
		return this.squarePressedNonCity;
	}

	public void setSquareButtons(ArrayList<Square> squareButtons) {
		this.squareButtons = squareButtons;
	}

	public ArrayList<Square> getSquareButtons() {
		return this.squareButtons;

	}

	public void setSquareAdjacencies(ArrayList<Square> squareAdjacencies) {
		this.squareAdjacencies = squareAdjacencies;
	}

	public ArrayList<Square> getSquareAdjacencies() {
		return this.squareAdjacencies;

	}

}
