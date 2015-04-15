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

		ArrayList<TextOptionEnum> a = new ArrayList<>(TextOptionEnum.values());
		a.printList();

	}

}
