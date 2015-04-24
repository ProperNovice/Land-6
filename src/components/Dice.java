package components;

import enums.Dimensions;
import gui.PanelGame;
import instances.Instances;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.ImageView;
import utils.Random;

public class Dice implements EventHandler<MouseEvent> {

	private ImageView imageView = null;
	protected ArrayList<Image> sides = new ArrayList<>();
	protected int sideNumberShowing = -1;

	public Dice() {
		createSides();
		createDice();
	}

	protected void createSides() {

	}

	private void createDice() {

		PanelGame panelGame = Instances.getPanelGameInstance();
		this.imageView = new ImageView(this.sides.get(0), panelGame);
		this.imageView.setWidth(Dimensions.DICE.x());
		this.imageView.setOnMousePressed(this);

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void animateSynchronous(double endingX, double endingY) {
		Animation.animate(this.imageView, endingX, endingY,
				AnimationSynch.SYNCHRONOUS);
	}

	public void setSide(int number) {
		this.sideNumberShowing = number;
		updateSideImage();
	}

	public void resetSide() {
		setSide(0);
	}

	public void roll() {
		this.sideNumberShowing = Random.getRandomNumber(1, 6);
		updateSideImage();
	}

	protected void updateSideImage() {
		this.imageView.setImage(this.sides.get(this.sideNumberShowing));
	}

	@Override
	public void handle(MouseEvent event) {

		if (!event.getButton().equals(MouseButton.PRIMARY))
			return;

	}

	public int getSideNumberShowing() {
		return this.sideNumberShowing;
	}

}
