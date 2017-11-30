/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import org.junit.Test;

import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
        
	public void testStringFormat() {
        BowlingGame bowlingGame = new BowlingGame("");
        assertEquals(-1, bowlingGame.getScore());
    }	

	public void testStringFormat2()	{
		BowlingGame bowlingGame = new BowlingGame("[5,5][3,5]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	public void testStringFormat3()	{
		BowlingGame bowlingGame = new BowlingGame("[4,5][][][][][]");
		assertEquals(false, bowlingGame.checkStringFormat(bowlingGame.game));
	}
	
	public void testOpenFrame() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, bowlingGame.getScore());
	}
	
	public void testStrikeFrame() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, bowlingGame.getScore());
	}
	
	public void testStrikeFrame2() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][1,1][0,0][0,0][0,0][0,0][0,0][0,0][0,0][1,0]");
		assertEquals(15, bowlingGame.getScore());
	}
	
	public void testSpareFrame() {
		BowlingGame bowlingGame = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, bowlingGame.getScore());
	}
	
	public void testSpareFrame2() {
		BowlingGame bowlingGame = new BowlingGame("[0,10][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, bowlingGame.getScore());
	}
	
	public void testFrameFormat() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,6][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6]");
		assertEquals(-1,bowlingGame.getScore());		
	}
	
	public void testFrameFormat2() {
		 BowlingGame bowlingGame = new BowlingGame("[10,0][-4,6][7,2][3,6][-4,4][5,3][3,3][4,5][8,1][2,6]");
		 assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testDoubleStrike() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        assertEquals(112, bowlingGame.getScore());
    }
	
	public void testDoubleSpare() {
        BowlingGame bowlingGame = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        assertEquals(98, bowlingGame.getScore());
    }
	
	public void testStrikeSpare() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        assertEquals(103, bowlingGame.getScore());
    }
	
	public void testPerfectGame() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
        assertEquals(300, bowlingGame.getScore());
    }
	
	public void testLastStrikeStringWithNegativeNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][-3,6][4,4][5,3][3,3][-4,5][8,1][2,6][10,10]");
		assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testLastSpareStringWithNegativeNumbers() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][10]");
		assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testWrongLastStrike() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][20,20]");
		assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testWrongLastSpare() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][20]");
		assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testFrameFormat3() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4]");
		assertEquals(-1,bowlingGame.getScore());
	}
	
	public void testFrameFormat4() {
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][-3,6][4,4][5,3][3,3][4,5][-8,1][2,6][10,3][10]");
		assertEquals(-1,bowlingGame.getScore());		
	}
	
	public void testLastDoubleSpare() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,2][2,8][7]");
        assertEquals(93, bowlingGame.getScore());
    }
	
	public void testLastDoubleStrike() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][10,0][10,0][7,2]");
        assertEquals(110, bowlingGame.getScore());
    }
	
	public void testLastSpare() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
        assertEquals(90, bowlingGame.getScore());
    }
	
	public void testLastStrike() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
        assertEquals(92, bowlingGame.getScore());
    }	
	
	public void testLastSpareStrike() {
		BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(93, bowlingGame.getScore());
	}
	
	//added test during the coverage test
	public void testCoverage() {
		BowlingGame bowlingGame = new BowlingGame("[9,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
		assertEquals(-1, bowlingGame.getScore());
	}
}