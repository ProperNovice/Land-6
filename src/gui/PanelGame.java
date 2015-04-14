package gui;

import utils.Parent;
import controller.Controller;

public class PanelGame extends Parent {

	public PanelGame(Parent parent) {

		new Controller(this);

	}

}
