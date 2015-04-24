package gui;

import utils.Text;
import enums.TextGameEnum;

public class TextGame {

	protected TextGameEnum textGameEnum = null;
	protected Text text = null;
	protected double height = -1;

	public TextGame(TextGameEnum textGameEnum) {
		this.textGameEnum = textGameEnum;
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
		return this.textGameEnum;
	}

	public double getHeight() {
		return this.height;
	}

}
