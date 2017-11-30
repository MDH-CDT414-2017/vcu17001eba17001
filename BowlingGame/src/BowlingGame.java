import java.util.*;
import java.util.List;

/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student: Vasja Collaku & Ermal Bizhuta
 * @version 1.0
 * @date 2017-11-27
 */
public class BowlingGame {

	/**
	 * BowlingGame Score calculator constructor which require string as input
	 * 
	 * @param game
	 *            Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */
	
	List<Frame> frameList = new ArrayList<Frame>(); // global variable which contains the list of frames
	String game; // global variable which gets the input string

	public BowlingGame(String game) {
		
		// constructor for BowlingGame
		this.game = game;
	}

	public void getFinalFrameList(String game) {
		String[] frameInitial = game.split("]"); // removes the closing bracket
		
		for (String frameInside : frameInitial) {
			
			// removes the opening bracket by creating a substring that removes the 0-index element which is the [-bracket
			frameInside = frameInside.substring(1, frameInside.length());

			Frame frame = new Frame();
			String[] frameCorrect = frameInside.split(","); // separating the two elements
			
			// setting the first and the second score in each frame
			frame.setScore1(Integer.parseInt(frameCorrect[0]));
			//the if is in the occasion of frame nr11 which is a bonus throw when the last frame was a spare
			if (frameCorrect.length == 2) {
				frame.setScore2(Integer.parseInt(frameCorrect[1]));
			}

			// check if the frame is strike or spare
			frame.setStrike(checkStrike(frame));
			frame.setSpare(checkSpare(frame));
			this.frameList.add(frame); // adding the changed frames to our list of frames
		}
	}	
	
	//check if the frame is Strike
	public boolean checkStrike(Frame frameTest) {
		if (frameTest.getScore1() == 10 && frameTest.getScore2() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	//check if the frame is Spare
	public boolean checkSpare(Frame frameTest) {
		if ((frameTest.getScore1() + frameTest.getScore2()) == 10 && frameTest.getScore2() != 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is
	 *         -1
	 */
	public int getScore() {
		// return(-1);
		if (!checkStringFormat(this.game) && !checkLastStrikeFormat(this.game) && !checkLastSpareFormat(this.game)) {
			return -1;
		}		
		
		getFinalFrameList(this.game);
		
		if(!checkExtraThrow(this.frameList)) {
			return -1;
		}

		int score = 0;

		for (Frame frameTrial : this.frameList) {
			if (!checkSum(frameTrial) && this.frameList.indexOf(frameTrial) != 10) {
				return -1;
			}
			if (this.frameList.indexOf(frameTrial) == 10) {
				continue;
			} else if (frameTrial.isStrike() == true) {
				score = score + getScoreStrike(frameTrial);
			} else if (frameTrial.isSpare() == true) {
				score = score + getScoreSpare(frameTrial);
			} else {
				score = score + getScoreOpen(frameTrial);
			}
		}
		
		return score;
	}

	//method to calculate the score of the frame which is a strike aka this_frame+two_next_throws
	public int getScoreStrike(Frame frameTest) {
		
		int sum = 0;
		
		int index = this.frameList.indexOf(frameTest) + 1;
		sum = getScoreOpen(frameTest);
		
		if (checkStrike(this.frameList.get(index))) {
			sum = sum + 10 + this.frameList.get(index + 1).getScore1();
		}
		else {
			sum = sum + getScoreOpen(this.frameList.get(index));
		}
		
		return sum;
	}

	//normal frame score calculator
	public int getScoreOpen(Frame frameTest) {
		return frameTest.getScore1() + frameTest.getScore2();
	}

	//spare frame score calculator
	public int getScoreSpare(Frame frameTest) {
		
		int sum = 0;
		
		int index = this.frameList.indexOf(frameTest) + 1;
		sum = getScoreOpen(frameTest) + this.frameList.get(index).getScore1();
		return sum;
	}

	//checks if the extra throw was done
	public boolean checkExtraThrow(List<Frame> listOfFrames) {
		
		if(checkStringFormat(this.game)) {
			Frame ultimate = listOfFrames.get(9);
			if(ultimate.isSpare() || ultimate.isStrike()) {
				return false;
			}
			else {
				return true;
			}
		} else if(checkLastSpareFormat(this.game)) {
			Frame penultimate = listOfFrames.get(9);
			if(penultimate.isSpare()) {
				return true;
			}
			
		} else {
			Frame penultimate = listOfFrames.get(9);
			if(penultimate.isStrike()) {
				return true;
			}
			
		}
		
		return false; 
			
		
		
		
//		if(listOfFrames.size()==10) {
//			Frame ultimate = listOfFrames.get(9);
//			if(ultimate.isSpare() || ultimate.isStrike()) {
//				return false;
//			}
//			else {
//				return true;
//			}			
//		}		
//		
////		return true;
//		else {
//			Frame penultimate = listOfFrames.get(9);
//			Frame ultimate = listOfFrames.get(10);
//			
//			if(penultimate.isSpare() && ultimate.getScore2() != 0 ) {
//				return false;
//			}
//							
//			if(penultimate.isSpare() || penultimate.isStrike()){
//				return true;
//			}
//			else {
//				return false;
//			}
//			
//		}
	}
	
	
	//checks the format of the input string
	public boolean checkStringFormat(String game) {
		if(game != null) {
			return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}");
		}
		
		return false;		
	}

	//checks the format of the input string when the last frame was a strike
	public boolean checkLastStrikeFormat(String game) {
		if(game != null) {
			return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10),([0-9]|10)\\]");
		}
		
		return false;
	}

	//checks the string input format when the last frame was a spare
	public boolean checkLastSpareFormat(String game) {
		if(game != null) {
			return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10)\\]");
		}
		
		return false;		
	}

	//checks if the frame is correct by checking if the sum of the two scores/throws is 10 
	public boolean checkSum(Frame frameTest) {
		if (frameTest.getScore1() + frameTest.getScore2() > 10) {
			return false;
		}
		else {
			return true;
		}
	}
}
