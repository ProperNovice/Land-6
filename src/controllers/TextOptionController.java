package controllers;

import enums.Coordinates;
import enums.Dimensions;
import enums.TextOptionEnum;
import gui.TextOption;
import utils.ArrayList;

public class TextOptionController {

	private ArrayList<TextOption> textOptions = new ArrayList<>();
	private ArrayList<TextOption> textOptionsShowing = new ArrayList<>();

	public TextOptionController() {
		createTextOptions();
	}

	private void createTextOptions() {

		for (TextOptionEnum textOptionEnum : TextOptionEnum.values())
			this.textOptions.add(new TextOption(textOptionEnum));

	}

	public void setVisibleTrue(ArrayList<TextOptionEnum> list) {

		double x = Coordinates.TEXT_OPTION.x();
		double y = Coordinates.TEXT_OPTION.y();

		for (TextOptionEnum textOptionEnum : list)
			for (TextOption textOption : this.textOptions) {

				if (!textOptionEnum.equals(textOption.getTextOptionEnum()))
					continue;

				this.textOptionsShowing.add(textOption);

				textOption.relocate(x, y);
				textOption.setVisible(true);

				y += Dimensions.TEXT_OPTION.y()
						+ Dimensions.GAP_BETWEEN_TEXTS.y();

			}
	}

	public void setVisibleFalse() {

		for (TextOption textOption : this.textOptionsShowing)
			textOption.setVisible(false);

		this.textOptionsShowing.clear();

	}

}
