package components;

import javafx.scene.image.Image;

public class DiceAction extends Dice {

	protected void createSides() {

		String pathStart = "/images/diceSea/";
		String pathEnd = ".png";

		this.sides.add(new Image(pathStart + "blank" + pathEnd));

		for (int counter = 1; counter <= 6; counter++)
			this.sides.add(new Image(pathStart + Integer.toString(counter)
					+ pathEnd));

	}

}
