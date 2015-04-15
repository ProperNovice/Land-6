package components;

import utils.Executor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class DiceArmy extends Dice {

	private Square square = null;

	public void setSquare(Square square) {
		this.square = square;
	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		if (this.square == null)
			return;

		Executor.runLater(() -> this.square.handleSquarePressed());

	}

}
