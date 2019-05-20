

import java.util.Arrays;
public class Autocomplete {

private final Term[] tms;

public Autocomplete(Term[] tms) {
	
	if (tms == null) 
		throw new NullPointerException("Terms can't be null");
	this.tms = new Term[tms.length];
	for (int i = 0; i < tms.length; i++) 
		this.tms[i] = tms[i];
	Arrays.sort(this.tms);
}

public Term[] allMatches(String prefix) throws Exception {
	if (prefix == null) throw new NullPointerException("Prefix can't be null");
	
	int firstIndex = BinarySearchDeluxe.firstIndexOf(tms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
	if (firstIndex == -1) return new Term[0];
	int lastIndex  = BinarySearchDeluxe.lastIndexOf (tms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
	Term[] matchTerms = new Term[1 + lastIndex - firstIndex];
	
	for (int i = 0; i < matchTerms.length; i++)
		matchTerms[i] = tms[firstIndex++];

	Arrays.sort(matchTerms, Term.byReverseWeightOrder());
	
	return matchTerms;
}

public int numberOfMatches(String prefix) throws Exception {
	if (prefix == null) 
		throw new NullPointerException("No null prefixes");
	return 1 + BinarySearchDeluxe.lastIndexOf (tms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length())) - BinarySearchDeluxe.firstIndexOf(tms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
}

public static void main (String[] args) throws Exception {
}
}

