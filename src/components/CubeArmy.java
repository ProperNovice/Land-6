package components;

import enums.Dimensions;
import gui.PanelGame;
import instances.Instances;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ImageView;

public class CubeArmy {

	private ImageView cube = null;

	public CubeArmy() {
		createCube();
	}

	private void createCube() {

		PanelGame panelGame = Instances.getPanelGameInstance();

		String path = "cube.png";
		this.cube = new ImageView(path, panelGame);
		this.cube.setWidth(Dimensions.CUBE.x());

	}

	public void relocate(double x, double y) {
		this.cube.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.cube, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

}