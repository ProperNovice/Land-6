package components;

import java.util.concurrent.atomic.AtomicBoolean;

import enums.Dimensions;
import gui.PanelGame;
import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.Executor;
import utils.ImageView;

public class CubeArmy implements EventHandler<MouseEvent> {

	private ImageView cube = null;
	private Tile tile = null;
	private AtomicBoolean isFlashing = new AtomicBoolean(false);

	public CubeArmy() {
		createCube();
	}

	private void createCube() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		String path = "cube.png";
		this.cube = new ImageView(path, panelGame);
		this.cube.setWidth(Dimensions.CUBE.x());
		this.cube.setOnMousePressed(this);

	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public void relocate(double x, double y) {
		this.cube.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.cube, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

		if (this.tile == null)
			return;

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().handleCubeArmyPressed(this.tile));

	}
	
	public boolean isFlashing() {
		return this.isFlashing.get();
	}

	public void flash() {

		Executor.runLater(() -> {
			this.isFlashing.set(true);
			this.cube.setVisible(false);
			Executor.sleep(1000);
			this.isFlashing.set(false);
			this.cube.setVisible(true);
		});

	}

}
