package arun.problems.ds.string;

/**
 * @author akumars
 *
 */
public abstract class StringPatternSearch {


	/**
	 * @param stringToBeSearched
	 * @param stringToSearch
	 * @return
	 */
	public abstract boolean searchPattern(final String stringToBeSearched,
										  final String stringToSearch);
	
	/**
	 * @param stringToBeSearched
	 * @param stringToSearch
	 * @return
	 */
	public abstract int firstStartingIndex(final String stringToBeSearched,
			  						  	   final String stringToSearch);
	
	/**
	 * @param stringToBeSearched
	 * @param stringToSearch
	 * @return
	 */
	public abstract int[] findAllMatchingIndexes(final String stringToBeSearched,
			  						  	   	     final String stringToSearch);
	
	/**
	 * @param stringToBeSearched
	 * @param stringToSearch
	 * @return
	 */
	public abstract int repeatationCount(final String stringToBeSearched,
										 final String stringToSearch);
	
	/**
	 * @param stringToBeSearched
	 * @param stringToSearch
	 * @return
	 */
	protected boolean canStringBeSubString(final String stringToBeSearched,
										 final String stringToSearch) {
		if(stringToBeSearched == null
				|| stringToSearch == null
				|| stringToBeSearched.equals("")
				|| stringToSearch.equals("")) 
			return false;
		
		if(stringToSearch.length() > stringToBeSearched.length())
			return false;
		
		return true;
	}
}
