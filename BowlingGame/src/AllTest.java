import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ BowlingGameTest.class, BowlingGameUltimateTest.class })
public class AllTest {
	
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BowlingGameTest.class);
		suite.addTestSuite(BowlingGameUltimateTest.class);
		//$JUnit-END$
		return suite;
		
	}

}

