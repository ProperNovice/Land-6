package gameDifficulty;

public class GameDifficultyVeryHard extends GameDifficultyController {

	@Override
	public boolean gameBeginsWithCubeArmy() {
		return true;
	}

	@Override
	public boolean restrictionOnGrowingFieldSquare() {
		return true;
	}

}
