package components;

import enums.Dimensions;
import gui.PanelGame;
import instances.Instances;
import javafx.scene.image.Image;
import utils.Animation;
import utils.Animation.AnimationSynch;
import utils.ArrayList;
import utils.ImageView;
import utils.Random;

public class Dice {

	private ImageView imageView = null;
	private ArrayList<Image> sides = new ArrayList<>();
	private Image blank = null;
	private int sideNumberShowing = -1;

	public Dice() {
		createSides();
		createDice();
	}

	private void createSides() {

		String pathStart = "/images/dice/";
		String pathEnd = ".png";

		for (int counter = 1; counter <= 6; counter++)
			this.sides.add(new Image(pathStart + Integer.toString(counter)
					+ pathEnd));

		this.blank = new Image(pathStart + "blank" + pathEnd);

	}

	private void createDice() {

		PanelGame panelGame = Instances.getPanelGameInstance();
		this.imageView = new ImageView(this.blank, panelGame);
		this.imageView.setWidth(Dimensions.DICE.x());
		
		rollDice();
		System.out.println(this.sideNumberShowing);

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
		setSide();
	}

	public void rollDice() {
		this.sideNumberShowing = Random.getRandomNumber(1, 6);
		setSide();
	}

	private void setSide() {
		this.imageView.setImage(this.sides.get(this.sideNumberShowing - 1));
	}

}
