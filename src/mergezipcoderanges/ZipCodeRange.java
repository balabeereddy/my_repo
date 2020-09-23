/*
 * @author bbeereddy
 */



package mergezipcoderanges;


// TODO: Auto-generated Javadoc
/**
 * The Class ZipCodeRange.
 */
public class ZipCodeRange {

	/** The begin. */
	private String begin;

	/** The end. */
	private String end;

	/**
	 * Instantiates a new zip code range.
	 */
	ZipCodeRange() {
		this.begin = "0";
		this.end = "0";
	}

	/**
	 * Instantiates a new zip code range.
	 *
	 * @param begin the begin
	 * @param end   the end
	 */
	ZipCodeRange(String begin, String end) {
		this.begin = begin;
		this.end = end;
	}

	/**
	 * Gets the begin.
	 *
	 * @return the begin
	 */
	public String getBegin() {
		return this.begin;
	}

	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public String getEnd() {
		return this.end;
	}

	/**
	 * Sets the begin.
	 *
	 * @param begin the new begin
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * Sets the end.
	 *
	 * @param end the new end
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.begin + "," + this.end;
	}

}
