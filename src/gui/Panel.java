package gui;

import enums.GameDifficultyEnum;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.ImageView;
import utils.Parent;
import utils.PlatformFX;
import utils.ShutDown;

public class Panel extends Parent implements EventHandler<MouseEvent> {

	private ImageView background = new ImageView("Background.png", this);
	private PanelOption panelOption = null;
	private PanelGame panelGame = null;

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(this);

		createOptionScreen();

	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		ShutDown.execute();

	}

	public void createOptionScreen() {

		PlatformFX.runLater(() -> {

			if (this.panelGame != null) {
				this.panelGame.setVisible(false);
				this.getChildren().remove(this.panelGame);
			}

			this.panelOption = new PanelOption(this);
			this.getChildren().add(this.panelOption);

		});

	}

	public void createGame(GameDifficultyEnum gameDifficultyEnum) {

		PlatformFX.runLater(() -> {

			this.panelOption.setVisible(false);
			this.getChildren().remove(this.panelOption);
			this.panelGame = new PanelGame(gameDifficultyEnum, this);
			this.getChildren().add(this.panelGame);

		});

	}

}
