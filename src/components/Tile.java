package components;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import instances.Instances;
import utils.ArrayList;
import utils.ImageView;
import utils.Random;
import enums.Dimensions;
import enums.SquareEnum;
import gui.PanelGame;

public class Tile {

	private int tileNumber = -1;
	private ArrayList<SquareEnum> squares = new ArrayList<>();
	private ImageView imageView = null;

	public Tile(int tileNumber, SquareEnum... squareList) {

		this.tileNumber = tileNumber;

		for (int counter = 0; counter < squareList.length; counter++)
			this.squares.add(squareList[counter]);

		createTile();

		this.imageView.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				squares.printList();
			}
		});

	}

	private void createTile() {

		String path = "tiles/";
		path += Integer.toString(this.tileNumber);
		path += ".png";
		PanelGame panelGame = Instances.getPanelGameInstance();
		this.imageView = new ImageView(path, panelGame);
		this.imageView.setWidth(Dimensions.TILE.x());

	}

	public void relocate(double x, double y) {
		this.imageView.relocate(x, y);
	}

	public void setRotateTwice() {
		setRotate(2);
	}

	public void setRotateRandom() {
		
		int timesToRotate = Random.getRandomNumber(0, 3);
		setRotate(timesToRotate);

	}

	private void setRotate(int timesToRotate) {

		this.imageView.setRotate(90 * timesToRotate);

		for (int counter = 1; counter <= timesToRotate; counter++)
			this.squares.add(0, this.squares.remove(this.squares.size() - 1));

	}

}
