package components;

import instances.Instances;
import controllers.Controller;
import utils.Executor;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class DiceAction extends Dice {

	protected void createSides() {

		String pathStart = "/images/diceSea/";
		String pathEnd = ".png";

		this.sides.add(new Image(pathStart + "blank" + pathEnd));

		for (int counter = 1; counter <= 6; counter++)
			this.sides.add(new Image(pathStart + Integer.toString(counter)
					+ pathEnd));

	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		if (super.sideNumberShowing == 0)
			return;

		Controller controller = Instances.getControllerInstance();

		Executor.runLater(() -> controller.gameStateController()
				.handleDiceActionPressed());

	}

}
