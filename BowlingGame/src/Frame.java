
public class Frame {

	private int score1;
	private int score2;
	private boolean strike;
	private boolean spare;
	
	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	@Override
	public String toString() {
		return "Frame [score1=" + score1 + ", score2=" + score2 + ", strike=" + strike + ", spare=" + spare + "]";
	}

	public int getScore1() {
		return score1;
	}
	
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}

	
	
	
	
}
