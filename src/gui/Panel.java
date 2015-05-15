package gui;

import utils.ImageView;
import utils.Parent;
import utils.PlatformFX;
import enums.GameDifficultyEnum;

public class Panel extends Parent {

	private ImageView background = new ImageView("Background.png", this);
	private PanelOption panelOption = null;
	private PanelGame panelGame = null;

	public Panel() {

		this.background.toBack();

		createOptionScreen();

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
