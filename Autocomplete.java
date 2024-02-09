import java.util.Arrays;
import java.util.Comparator;

/**
 * Autocomplete.
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
	   if (terms == null){
           throw new NullPointerException();
      }
      this.terms = terms;
      Arrays.sort(terms);
    }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {
	   if (prefix == null){
               throw new NullPointerException();
      }
      Term term = new Term(prefix, 0);
      int length = prefix.length();
      Comparator<Term> comp = terms[0].byPrefixOrder(length);
      int firstIndex = BinarySearch.<Term>firstIndexOf(terms, term, comp);
      int lastIndex = BinarySearch.<Term>lastIndexOf(terms, term, comp);
      if (firstIndex == -1 && lastIndex == -1) {
         return new Term[0];
      }
      int matchesSize = (lastIndex - firstIndex) + 1;
      Term[] allMatches = new Term[matchesSize];
      allMatches = Arrays.copyOfRange(terms, firstIndex, lastIndex+1);
      Comparator<Term> comp2 = allMatches[0].byDescendingWeightOrder();
      Arrays.sort(allMatches, comp2);
         return allMatches;
      }
   
}