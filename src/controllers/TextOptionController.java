package controllers;

import enums.TextOptionEnum;
import gui.TextOption;
import utils.ArrayList;

public class TextOptionController {

	private ArrayList<TextOption> textOptions = new ArrayList<>();

	public TextOptionController() {
		createTextOptions();
	}

	private void createTextOptions() {

		for (TextOptionEnum textOptionEnum : TextOptionEnum.values())
			this.textOptions.add(new TextOption(textOptionEnum));

	}

}
