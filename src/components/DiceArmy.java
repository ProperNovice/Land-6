package components;

import instances.Instances;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.Executor;

public class DiceArmy extends Dice {

	private Square square = null;

	public void setSquare(Square square) {
		this.square = square;
	}

	@Override
	protected void createSides() {

		String pathStart = "/images/diceArmy/";
		String pathEnd = ".png";

		super.sides.add(new Image(pathStart + "blank" + pathEnd));

		for (int counter = 1; counter <= 6; counter++)
			super.sides.add(new Image(pathStart + Integer.toString(counter)
					+ pathEnd));

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

	public boolean isMaxValue() {

		if (super.sideNumberShowing == 6)
			return true;
		else
			return false;

	}

	public boolean isMinValue() {

		if (super.sideNumberShowing == 0)
			return true;
		else
			return false;

	}

	public boolean isShowingAtLeast3() {

		if (super.sideNumberShowing >= 3)
			return true;
		else
			return false;

	}

}
