package components;

import instances.Instances;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.Executor;

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

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().handleSquareDicePressed(this.square));

	}

	public void substractOnePoint() {

		super.sideNumberShowing--;
		super.updateSideImage();
	}

	public void addOnePoint() {

		super.sideNumberShowing++;
		super.updateSideImage();
	}

}
