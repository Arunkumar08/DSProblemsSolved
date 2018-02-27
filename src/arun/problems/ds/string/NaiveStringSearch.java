package arun.problems.ds.string;

public class NaiveStringSearch extends StringPatternSearch {

	/* (non-Javadoc)
	 * @see arun.problems.ds.string.StringPatternSearch#searchPattern(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean searchPattern(final String stringToBeSearched,
								 final String stringToSearch) {
		
		if (!canStringBeSubString(stringToBeSearched, stringToSearch))
			return false;
		
		char[] mainString = stringToBeSearched.toCharArray();
		char[] subString = stringToSearch.toCharArray();
		
		int indexToStart = 0;
		int i = 0;
		int j = 0;
		boolean patternFound = false;

		while(i < subString.length
				&& j < mainString.length) {
			
			
			if(mainString[j] == subString[i]) {
				patternFound = true;
				if((subString.length - i) >= (mainString.length - j))
					return false;
				if(i==0)
					indexToStart = j;
				i++;
				j++;
			} else {
				i = 0;
				j = indexToStart;
				patternFound = false;
			}
			j++;
		}
			
		return patternFound;
	}

	@Override
	public int firstStartingIndex(final String stringToBeSearched,
								  final String stringToSearch) {
		return 0;
	}

	@Override
	public int[] findAllMatchingIndexes(final String stringToBeSearched,
										final String stringToSearch) {
		return null;
	}

	@Override
	public int repeatationCount(final String stringToBeSearched,
								final String stringToSearch) {
		return 0;
	}

	public static void main(String a[]) {
		String one = "This is an example";
		String two = "is";
		
		StringPatternSearch search = new NaiveStringSearch();
		search.searchPattern(one, two);
	}
}
