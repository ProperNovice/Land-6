package gui;

import instances.Instances;
import utils.Parent;
import controllers.Controller;

public class PanelGame extends Parent {

	public PanelGame(Parent parent) {

		Instances.createPanelGame(this);
		new Controller(this);

	}

}
