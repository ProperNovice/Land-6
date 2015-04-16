package controllers;

import components.Square;

public class CredentialController {

	private Square squarePressed = null;

	public CredentialController() {

	}

	public void setSquarePressed(Square squarePressed) {
		this.squarePressed = squarePressed;
	}

	public Square getSquarePressed() {
		return this.squarePressed;
	}

}
