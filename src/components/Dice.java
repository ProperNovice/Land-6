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
import utils.Lock;
import utils.Random;

public class Dice implements EventHandler<MouseEvent> {

	private ImageView imageView = null;
	protected ArrayList<Image> sides = new ArrayList<>();
	protected int sideNumberShowing = -1;
	private double x, y;

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
		this.x = x;
		this.y = y;
		this.imageView.relocate(this.x, this.y);
	}

	public void animateSynchronous(double endingX, double endingY) {

		this.x = endingX;
		this.y = endingY;

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

		resetSide();
		int step = 10;

		animateSynchronous(this.x + step, this.y);
		Lock.lock();
		animateSynchronous(this.x - step * 2, this.y);
		Lock.lock();
		animateSynchronous(this.x + step, this.y);
		Lock.lock();

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
