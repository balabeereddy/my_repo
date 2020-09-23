/*
 * @author bbeereddy
 */


package mergezipcoderanges;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


// TODO: Auto-generated Javadoc
/**
 * The Class ZipCodeRangeClosure.
 */
public class ZipCodeRangeClosure {

	/**
	 * Adds the range.
	 *
	 * @param range     the range
	 * @param rangeList the range list
	 */
	public void addRange(ZipCodeRange range, ArrayList<ZipCodeRange> rangeList) {
		rangeList.add(range);
	}

	/**
	 * Sort range.
	 *
	 * @param rangeList the range list
	 */
	public void sortRange(ArrayList<ZipCodeRange> rangeList) {
		Collections.sort(rangeList, new Comparator<ZipCodeRange>() {

			public int compare(ZipCodeRange range1, ZipCodeRange range2) {
				String r1 = range1.getBegin();
				String r2 = range2.getBegin();
				int comp = r1.compareTo(r2);

				if (comp != 0) {
					return comp;
				} else {
					String x1 = range1.getEnd();
					String x2 = range2.getEnd();
					return x1.compareTo(x2);
				}
			}
		});
	}

	/**
	 * Merge range.
	 *
	 * @param rangeList the range list
	 * @return the array list
	 */
	public ArrayList<ZipCodeRange> mergeRange(ArrayList<ZipCodeRange> rangeList) {
		int rangeListSize = rangeList.size();
		ArrayList<ZipCodeRange> mergedRangeList = new ArrayList<ZipCodeRange>();
		if (rangeListSize > 0) {
			sortRange(rangeList);




			ZipCodeRange tmp = rangeList.get(0);

			for (int i = 0; i < rangeListSize; i++) {
				if ((Integer.parseInt(tmp.getEnd()) + 1 == Integer.parseInt(rangeList.get(i).getBegin())
						|| Integer.parseInt(tmp.getEnd()) >= Integer.parseInt(rangeList.get(i).getBegin()))) {

/**					 Additional condition to ignore duplicate zip code pairs
					 and zip codes pairs such as [94100,94199] and
					 [94136,94136]
*/
					if (Integer.parseInt(tmp.getEnd()) < Integer.parseInt(rangeList.get(i).getEnd())
							&& Integer.parseInt(tmp.getBegin()) != Integer.parseInt(rangeList.get(i).getBegin())) {
						tmp.setEnd(rangeList.get(i).getEnd());
					}

				} else {
					mergedRangeList.add(tmp);
					tmp = rangeList.get(i);
				}
			}
			mergedRangeList.add(tmp);
		}
		return mergedRangeList;
	}

	/**
	 * Read input.
	 *
	 * @param inputFile the input file
	 * @return the array list
	 */
	public ArrayList<ZipCodeRange> readInput(String inputFile) {
		ArrayList<ZipCodeRange> rangeList = new ArrayList<ZipCodeRange>();
		BufferedReader br = null;

		String currentLine;
		try {
			br = new BufferedReader(new FileReader(inputFile));

			try {
				while ((currentLine = br.readLine()) != null) {
					String[] zipCodes = currentLine.split(",");
					if (validateInput(Integer.parseInt(zipCodes[0])) && validateInput(Integer.parseInt(zipCodes[1]))) {
						ZipCodeRange range = new ZipCodeRange();

						if (Integer.parseInt(zipCodes[0]) <= Integer.parseInt(zipCodes[1]))
							range = new ZipCodeRange(zipCodes[0], zipCodes[1]);
						else
							range = new ZipCodeRange(zipCodes[1], zipCodes[0]);

						addRange(range, rangeList);
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return rangeList;
	}

	/**
	 * Validate input.
	 *
	 * @param zipCode the zip code
	 * @return true, if successful
	 */
	public boolean validateInput(int zipCode) {
		if (zipCode <= 99999)
			return true;
		return false;
	}

	/**
	 * Write output.
	 *
	 * @param mergedRangeList the merged range list
	 * @param outputFile      the output file
	 */
	public void writeOutput(ArrayList<ZipCodeRange> mergedRangeList, String outputFile) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (mergedRangeList.size() > 0) {
			for (ZipCodeRange range : mergedRangeList) {
				try {
					writer.write(range.toString() + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Execute me.
	 *
	 * @param inputFile  the input file
	 * @param outputFile the output file
	 * @return the array list
	 */
	public ArrayList<ZipCodeRange> executeMe(String inputFile, String outputFile) {
		ArrayList<ZipCodeRange> mergedRangeList = new ArrayList<ZipCodeRange>();

		// Reading input Zip Code Range from the file.
		ArrayList<ZipCodeRange> rangeList = readInput(inputFile);

		// Sort and Merge the input as per the given requirement.
		mergedRangeList = mergeRange(rangeList);

		// Write output in the file.
		writeOutput(mergedRangeList, outputFile);

		System.out.println("Execution Completed!");

		return mergedRangeList;
	}

	/**
	 * Execute me.
	 *
	 * @param rangeList the range list
	 */
	public void executeMe(ArrayList<ZipCodeRange> rangeList) {
		ArrayList<ZipCodeRange> mergedRangeList = new ArrayList<ZipCodeRange>();


		// Sort and Merge the input as per the given requirement.
		mergedRangeList = mergeRange(rangeList);
		 for (ZipCodeRange range : mergedRangeList) {
		        System.out.println(range.toString());
		      }

		System.out.println("Execution Completed!");


	}
}
