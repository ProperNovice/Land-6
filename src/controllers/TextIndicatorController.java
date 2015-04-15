package controllers;

import enums.Coordinates;
import enums.Dimensions;
import enums.TextIndicatorEnum;
import gui.TextIndicator;
import utils.ArrayList;

public class TextIndicatorController {

	private ArrayList<TextIndicator> textIndicators = new ArrayList<>();
	private ArrayList<TextIndicator> textIndicatorsShowing = new ArrayList<>();

	public TextIndicatorController() {
		createTextOptions();
	}

	private void createTextOptions() {

		for (TextIndicatorEnum textIndicatorEnum : TextIndicatorEnum.values())
			this.textIndicators.add(new TextIndicator(textIndicatorEnum));

	}

	public void setVisibleTrue(ArrayList<TextIndicatorEnum> list) {

		double x = Coordinates.TEXT_INDICATOR.x();
		double y = Coordinates.TEXT_INDICATOR.y();

		for (TextIndicatorEnum textIndicatorEnum : list)
			for (TextIndicator textIndicator : this.textIndicators) {

				if (!textIndicatorEnum.equals(textIndicator
						.getTextIndicatorEnum()))
					continue;

				this.textIndicatorsShowing.add(textIndicator);

				textIndicator.relocate(x, y);
				textIndicator.setVisible(true);

				y += Dimensions.TEXT_INDICATOR.y()
						+ Dimensions.GAP_BETWEEN_TEXTS.y();

			}

	}

	public void setVisibleTrue(TextIndicatorEnum textIndicatorEnum) {

		ArrayList<TextIndicatorEnum> list = new ArrayList<>();
		list.add(textIndicatorEnum);
		setVisibleTrue(list);

	}

	public void setVisibleFalse() {

		for (TextIndicator textIndicator : this.textIndicators)
			textIndicator.setVisible(false);

		this.textIndicatorsShowing.clear();

	}

}
