package gameDifficulty;

public class GameDifficultyHard extends GameDifficultyController {

	@Override
	public boolean gameBeginsWithCubeArmy() {
		return true;
	}

	@Override
	public boolean restrictionOnGrowingFieldSquare() {
		return true;
	}

}