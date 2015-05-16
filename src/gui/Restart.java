package gui;

import controllers.Controller;
import enums.Coordinates;
import enums.Dimensions;
import instances.Instances;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.ImageView;

public class Restart implements EventHandlerAble {

	private ImageView imageView = null;
	private Controller controller = Instances.getControllerInstance();

	public Restart() {

		createImageView();
		this.imageView.setOnMousePressed(new EventHandler(this));

	}

	private void createImageView() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		this.imageView = new ImageView("restart.png", panelGame);
		this.imageView.setWidth(Dimensions.RESTART.x());
		this.imageView.relocate(Coordinates.RESTART.x(),
				Coordinates.RESTART.y());
		this.imageView.setVisible(false);

	}

	@Override
	public void handleMouseButtonPrimary() {
		this.controller.gameStateController().handleRestartPressed();
	}

	public void setVisible(boolean value) {
		this.imageView.setVisible(value);
	}

}
