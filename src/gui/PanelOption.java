package gui;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.ArrayList;
import utils.Parent;
import utils.Polyline;
import utils.Text;
import enums.Dimensions;
import enums.GameDifficultyEnum;
import enums.TextGameEnum;

public class PanelOption extends Parent {

	private ArrayList<TextGame> texts = new ArrayList<>();
	private Panel panel = null;

	public PanelOption(Panel panel) {

		this.panel = panel;
		createTexts();

	}

	private void createTexts() {

		this.texts.add(new OptionTextIndicator(
				TextGameEnum.CHOOSE_DIFFICULTY_LEVEL));
		this.texts.add(new OptionTextOption(TextGameEnum.EASY));
		this.texts.add(new OptionTextOption(TextGameEnum.NORMAL));
		this.texts.add(new OptionTextOption(TextGameEnum.HARD));
		this.texts.add(new OptionTextOption(TextGameEnum.VERY_HARD));

		double x = (Dimensions.FRAME.x() - this.texts.get(0).getWidth()) / 2;
		double y = (Dimensions.FRAME.y() - this.texts.size()
				* Dimensions.TEXT_OPTION.y() - 120) / 2;
		double height = Dimensions.TEXT_OPTION.y();

		this.texts.get(0).relocate(x, y);
		y += height;
		this.texts.get(1).relocate(x, y);
		y += height + 5;
		this.texts.get(2).relocate(x, y);
		y += height + 5;
		this.texts.get(3).relocate(x, y);
		y += height + 5;
		this.texts.get(4).relocate(x, y);

	}

	private class OptionTextIndicator extends TextIndicator {

		public OptionTextIndicator(TextGameEnum textGameEnum) {
			super(textGameEnum);
		}

		@Override
		protected void createText() {

			super.text = new Text(super.textGameEnum.getText(),
					PanelOption.this);

			super.height = Dimensions.TEXT_INDICATOR.y();

			if (super.textGameEnum.getText().contains("\n"))
				super.height += super.height;

			super.text.setHeight(super.height);

		}

	}

	private class OptionTextOption extends TextOption {

		public OptionTextOption(TextGameEnum textGameEnum) {
			super(textGameEnum);
		}

		@Override
		protected void createText() {

			super.text = new Text(this.textGameEnum.getText(), PanelOption.this);

			super.height = Dimensions.TEXT_OPTION.y();
			super.text.setHeight(Dimensions.TEXT_OPTION.y() - 4);
			super.text.setOnMouseEntered(new OnMouseEntered());
			super.text.setOnMouseExited(new OnMouseExited());
			super.text.setOnMousePressed(this);

		}

		@Override
		protected void createBorder() {

			double textWidth = super.text.getWidth();

			super.border = new Polyline(textWidth + 2
					* Dimensions.GAP_BETWEEN_OPTION_TEXT_BORDER_AND_OPTION.x(),
					Dimensions.TEXT_OPTION.y(), PanelOption.this);

			super.border.setStroke(null);
			super.border.setFill(Color.WHEAT);
			super.border.setOnMouseEntered(new OnMouseEntered());
			super.border.setOnMouseExited(new OnMouseExited());
			super.border.setOnMousePressed(this);
			super.border.toBack();

		}

		@Override
		public void handle(MouseEvent event) {

			if (!event.getButton().equals(MouseButton.PRIMARY))
				return;

			GameDifficultyEnum gameDifficultyEnum = null;

			switch (super.textGameEnum) {

			case EASY:
				gameDifficultyEnum = GameDifficultyEnum.EASY;
				break;

			case HARD:
				gameDifficultyEnum = GameDifficultyEnum.HARD;
				break;

			case NORMAL:
				gameDifficultyEnum = GameDifficultyEnum.NORMAL;
				break;

			case VERY_HARD:
				gameDifficultyEnum = GameDifficultyEnum.VERY_HARD;
				break;

			default:
				break;

			}

			panel.createGame(gameDifficultyEnum);

		}
	}

}
