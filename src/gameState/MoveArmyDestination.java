package gameState;

import utils.ArrayList;
import components.DiceArmy;
import components.Square;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class MoveArmyDestination extends GameState {

	private ArrayList<Square> squareAdjacencies = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		this.squareAdjacencies.clear();

		showTextList();
		enableSquareButtonForMoveDestination();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {
		
		squareAdjacenciesSetVisibleFalse();
		setTextOptionVisibleFalse();
		
		DiceArmy diceArmy = square.getDiceArmy();
		System.out.println(diceArmy);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		squareAdjacenciesSetVisibleFalse();
		setTextOptionVisibleFalse();
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void enableSquareButtonForMoveDestination() {

		Square squareToMoveFrom = super.controller.credentialController()
				.getSquarePressed();

		this.squareAdjacencies.addAll(squareToMoveFrom.getAdjacenciesClone());

		for (Square square : this.squareAdjacencies)
			if (!square.containsDice())
				square.setVisibleButtonOption(true);

	}
	
	private void squareAdjacenciesSetVisibleFalse() {
		
		for (Square square : this.squareAdjacencies)
				square.setVisibleButtonOption(false);
		
	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_DESTINATION);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
