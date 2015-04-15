package gui;

import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import utils.Executor;
import utils.Polyline;

import components.Square;

import enums.Dimensions;

public class ButtonOption implements EventHandler<MouseEvent> {

	private Polyline button = null;
	private Square square = null;

	public ButtonOption(Square square) {
		this.square = square;
		createButton();
	}

	private void createButton() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		this.button = new Polyline(Dimensions.BUTTON_OPTION.x(),
				Dimensions.BUTTON_OPTION.y(), panelGame);

		this.button.setStroke(null);
		this.button.setFill(Color.BLUE);
		this.button.setOnMousePressed(this);
		setVisible(false);

	}

	public void relocate(double x, double y) {
		this.button.relocate(x, y);
		this.button.toFront();
	}

	public void setVisible(boolean value) {
		this.button.setVisible(value);
	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		Executor.runLater(() -> this.square.handleSquarePressed());

	}

}
