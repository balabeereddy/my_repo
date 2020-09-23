/*
 * @author bbeereddy
 */

package mergezipcoderanges;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Class Main.
 */
public class Main {
	private  static ZipCodeRangeClosure zipCodeRangeClosure=new ZipCodeRangeClosure();
	private  static 	ArrayList<ZipCodeRange> rangeList=new ArrayList<ZipCodeRange>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String... args) throws Exception {
		try {
		Scanner input=new Scanner(System.in);
		int entrie=input.nextInt();
	    for(int i=0;i<entrie;i++) {
	    String currentLine=input.next();

	   String zipCodes[]  =currentLine.split(",");

	   ZipCodeRange zipCodeRange;
	   if (Integer.parseInt(zipCodes[0]) <= Integer.parseInt(zipCodes[1]))
		   zipCodeRange = new ZipCodeRange(zipCodes[0], zipCodes[1]);
		else
			zipCodeRange = new ZipCodeRange(zipCodes[1], zipCodes[0]);

	   rangeList.add(zipCodeRange);
	    }
	    input.close();
		zipCodeRangeClosure.executeMe(rangeList);
	}
	catch(InputMismatchException e) {
		e.printStackTrace();



	}
	}

}
