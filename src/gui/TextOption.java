package gui;

import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.Polyline;
import utils.Text;
import enums.Dimensions;
import enums.TextOptionEnum;

public class TextOption implements EventHandler<MouseEvent> {

	private Text text = null;
	private Polyline border = null;
	private TextOptionEnum textOptionEnum = null;
	private OnMouseEntered onMouseEntered = new OnMouseEntered();
	private OnMouseExited onMouseExited = new OnMouseExited();

	public TextOption(TextOptionEnum textOptionEnum) {
		this.textOptionEnum = textOptionEnum;
		createText();
		createBorder();
	}

	private void createText() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		this.text = new Text(this.textOptionEnum.textOption(), panelGame);

		this.text.setHeight(Dimensions.TEXT_OPTION.y() - 4);
		this.text.setOnMouseEntered(this.onMouseEntered);
		this.text.setOnMouseExited(this.onMouseExited);
		this.text.setOnMousePressed(this);

	}

	private void createBorder() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		double textWidth = this.text.getWidth();

		this.border = new Polyline(textWidth + 2
				* Dimensions.GAP_BETWEEN_TEXT_BORDER_AND_OPTION.x(),
				Dimensions.TEXT_OPTION.y(), panelGame);

		this.border.setStroke(null);
		this.border.setFill(Color.WHEAT);
		this.border.setOnMouseEntered(this.onMouseEntered);
		this.border.setOnMouseExited(this.onMouseExited);
		this.border.setOnMousePressed(this);
		this.border.toBack();

	}

	public void relocate(double x, double y) {

		this.border.relocate(x, y);
		x += Dimensions.GAP_BETWEEN_TEXT_BORDER_AND_OPTION.x();
		this.text.relocate(x, y);

	}

	@Override
	public void handle(MouseEvent event) {
		
		this.border.setVisible(false);
		this.text.setVisible(false);

	}

	private class OnMouseEntered implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			border.setFill(Color.BLACK);
			text.setFill(Color.WHITE);

		}

	}

	private class OnMouseExited implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			border.setFill(Color.WHEAT);
			text.setFill(Color.BLACK);

		}

	}

}
