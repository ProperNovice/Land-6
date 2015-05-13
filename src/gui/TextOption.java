package gui;

import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.Executor;
import utils.Polyline;
import utils.Text;
import controllers.Controller;
import enums.Dimensions;
import enums.TextGameEnum;

public class TextOption extends TextGame implements EventHandler<MouseEvent> {

	protected Polyline border = null;
	private Controller controller = Instances.getControllerInstance();

	public TextOption(TextGameEnum textGameEnum) {

		super(textGameEnum);
		createBorder();

	}

	@Override
	protected void createText() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		super.text = new Text(this.textGameEnum.getText(), panelGame);

		super.height = Dimensions.TEXT_OPTION.y();
		super.text.setHeight(Dimensions.TEXT_OPTION.y() - 4);
		super.text.setOnMouseEntered(new OnMouseEntered());
		super.text.setOnMouseExited(new OnMouseExited());
		super.text.setOnMousePressed(this);

	}

	protected void createBorder() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		double textWidth = super.text.getWidth();

		this.border = new Polyline(textWidth + 2
				* Dimensions.GAP_BETWEEN_OPTION_TEXT_BORDER_AND_OPTION.x(),
				Dimensions.TEXT_OPTION.y(), panelGame);

		this.border.setStroke(null);
		this.border.setFill(Color.WHEAT);
		this.border.setOnMouseEntered(new OnMouseEntered());
		this.border.setOnMouseExited(new OnMouseExited());
		this.border.setOnMousePressed(this);
		this.border.toBack();

		setVisible(false);
	}

	@Override
	public void relocate(double x, double y) {

		this.border.relocate(x, y);
		x += Dimensions.GAP_BETWEEN_OPTION_TEXT_BORDER_AND_OPTION.x();
		super.text.relocate(x, y);

	}

	@Override
	public void setVisible(boolean value) {
		super.text.setVisible(value);
		this.border.setVisible(value);
	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		Executor.runLater(() -> this.controller.gameStateController()
				.handleTextPressed(this.textGameEnum));

	}

	protected class OnMouseEntered implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			setFillBorder(Color.BLACK);
			setFillText(Color.WHITE);

		}

	}

	protected class OnMouseExited implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {

			setFillBorder(Color.WHEAT);
			setFillText(Color.BLACK);

		}

	}

	private void setFillText(Color color) {
		super.text.setFill(color);
	}

	private void setFillBorder(Color color) {
		this.border.setFill(color);
	}

}
