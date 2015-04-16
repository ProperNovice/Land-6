package controllers;

import utils.ArrayList;
import components.Square;

public class CredentialController {

	private Square squarePressed = null;
	private ArrayList<Square> squareButtons = null;

	public CredentialController() {

	}

	public void setSquarePressed(Square squarePressed) {
		this.squarePressed = squarePressed;
	}

	public Square getSquarePressed() {
		return this.squarePressed;
	}

	public void setSquareButtons(ArrayList<Square> squareButtons) {
		this.squareButtons = squareButtons;
	}

	public ArrayList<Square> getSquareButtons() {
		return this.squareButtons;

	}

}
