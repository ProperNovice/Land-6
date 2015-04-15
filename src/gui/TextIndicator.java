package gui;

import instances.Instances;
import utils.Text;
import enums.Dimensions;
import enums.TextIndicatorEnum;

public class TextIndicator {

	private TextIndicatorEnum textIndicatorEnum = null;
	private Text text = null;

	public TextIndicator(TextIndicatorEnum textIndicatorEnum) {
		this.textIndicatorEnum = textIndicatorEnum;
		createText();
	}

	private void createText() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		this.text = new Text(this.textIndicatorEnum.textIndicator(), panelGame);
		this.text.setHeight(Dimensions.TEXT_INDICATOR.y());
		this.text.setVisible(false);
	}
	
	public void setVisible(boolean value) {
		this.text.setVisible(value);
	}
	
	public void relocate(double x, double y) {
		this.text.relocate(x, y);
	}
	
	public TextIndicatorEnum getTextIndicatorEnum() {
		return this.textIndicatorEnum;
	}

}
