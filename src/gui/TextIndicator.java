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

		super.text = new Text(super.textGameEnum.getText(), panelGame);

		super.height = Dimensions.TEXT_INDICATOR.y();

		if (super.textGameEnum.getText().contains("\n"))
			super.height += super.height;

		super.text.setHeight(super.height);
		super.text.setVisible(false);

	}

}
