package gui;

import instances.Instances;
import utils.Text;
import enums.Dimensions;
import enums.TextGameEnum;

public class TextIndicator extends TextGame {

	public TextIndicator(TextGameEnum textGameEnum) {
		super(textGameEnum);
	}

	@Override
	protected void createText() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		super.text = new Text(this.textEnum.getText(), panelGame);
		super.text.setHeight(Dimensions.TEXT_INDICATOR.y());
		super.text.setVisible(false);

	}

}
