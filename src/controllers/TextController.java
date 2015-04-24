package controllers;

import enums.Coordinates;
import enums.Dimensions;
import enums.TextGameEnum;
import gui.TextGame;
import gui.TextIndicator;
import gui.TextOption;
import utils.ArrayList;

public class TextController {

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();

	public TextController() {
		createTexts();
	}

	private void createTexts() {

		for (TextGameEnum textGameEnum : TextGameEnum.values()) {

			switch (textGameEnum.getTextGameType()) {

			case INDICATOR:
				this.textGame.add(new TextIndicator(textGameEnum));
				break;
			case OPTION:
				this.textGame.add(new TextOption(textGameEnum));
				break;

			}

		}

	}

	public void setVisibleTrue(ArrayList<TextGameEnum> list) {

		double x = Coordinates.TEXT_INDICATOR.x();
		double y = Coordinates.TEXT_INDICATOR.y();

		for (TextGameEnum textGameEnum : list)
			for (TextGame textGame : this.textGame) {

				if (!textGameEnum.equals(textGame.getTextIndicatorEnum()))
					continue;

				this.textGameShowing.add(textGame);

				textGame.relocate(x, y);
				textGame.setVisible(true);

				y += textGame.getHeight() + Dimensions.GAP_BETWEEN_TEXTS.y();

			}
	}

	public void setVisibleTrue(TextGameEnum textGameEnum) {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(textGameEnum);
		setVisibleTrue(list);

	}

	public void setVisibleFalse() {

		for (TextGame textGame : this.textGameShowing)
			textGame.setVisible(false);

		this.textGameShowing.clear();

	}

}
