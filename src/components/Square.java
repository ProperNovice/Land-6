package components;

import utils.ArrayList;
import enums.SquareEnum;

public class Square {

	public SquareEnum squareEnum = null;
	private ArrayList<Square> adjacencies = new ArrayList<>();

	public Square(SquareEnum squareEnum) {
		this.squareEnum = squareEnum;
	}

	public SquareEnum getSquareEnum() {
		return this.squareEnum;
	}

	public void addAdjacent(Square square) {
		this.adjacencies.add(square);
	}

	public boolean isAdjacent(Square square) {

		for (Square squareTemp : this.adjacencies)
			if (squareTemp.equals(square))
				return true;

		return false;
	}

}
