package gui;

import utils.Text;
import enums.TextGameEnum;

public class TextGame {

	protected TextGameEnum textEnum = null;
	protected Text text = null;

	public TextGame(TextGameEnum textEnum) {
		this.textEnum = textEnum;
		createText();
	}

	protected void createText() {

	}

	public void setVisible(boolean value) {
		this.text.setVisible(value);
	}

	public void relocate(double x, double y) {
		this.text.relocate(x, y);
	}

	public TextGameEnum getTextIndicatorEnum() {
		return this.textEnum;
	}

}
