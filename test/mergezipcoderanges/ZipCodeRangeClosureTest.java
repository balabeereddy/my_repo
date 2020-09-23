/*
 * @author bbeereddy
 */


package mergezipcoderanges;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * The Class ZipCodeRangeClosureTest.
 */
public class ZipCodeRangeClosureTest {

	/** The exec. */
	private ZipCodeRangeClosure exec;

	/** The expected. */
	private final String expected = "resources/expected/output0.csv";

	/** The input. */
	private final  String input = "resources/input/input0.csv";

	/** The actual. */
	private final  String actual = "resources/actual/actual0.csv";

	/** The merged expecteds. */
	private 	ArrayList<ZipCodeRange> mergedExpecteds;

	/** The merged actuals. */
	private  ArrayList<ZipCodeRange> mergedActuals;

	/**
	 * Before.
	 */
	@Before
	public void before(){
		exec = new ZipCodeRangeClosure();
		mergedExpecteds = new ArrayList<ZipCodeRange>();

		mergedExpecteds = exec.readInput(expected);
	}


	/**
	 * Test case.
	 */
	@Test
	public void testCase() {
		mergedActuals = new ArrayList<ZipCodeRange>();
		mergedActuals = exec.executeMe(input, actual);
		for (int i = 0; i < mergedActuals.size(); i++) {
			Assert.assertEquals(mergedExpecteds.get(i).toString(), mergedActuals.get(i).toString());
		}
	}

	/**
	 * After.
	 */
	@After
	public void after() {
		exec = null;

	}

}
