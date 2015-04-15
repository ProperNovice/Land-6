package components;

import javafx.scene.input.MouseEvent;

public class DiceArmy extends Dice {

	private Square square = null;

	public void setSquare(Square square) {
		this.square = square;
	}

	@Override
	public void handle(MouseEvent event) {
		
		if (this.square == null)
			return;
		
		this.square.handleSquarePressed();
		
	}

}
