package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Checks whether any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if every element in a collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Check the similarity between two strings.
     * The greater the result, the more different the strings are.
     * Set threshold?
     */
    public static int levenshteinDistance(String string1, String string2) {
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        int n1 = s1.length; int n2 = s2.length;
        int[][] d = new int[n1+1][n2+1];
        for (int i = 1; i < n1 + 1; i++) {
            d[i][0] = i;
        }
        for (int j = 1; j < n2 + 1; j++) {
            d[0][j] = j;
        }
        for (int j = 1; j < n2 + 1; j++) {
            for (int i = 1; i < n1 + 1; i++) {
                int substitutionCost;
                if (s1[i] == s2[j])
                    substitutionCost = 0;
                else
                    substitutionCost = 1;
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + substitutionCost);
            }
        }
        return d[n1][n2];
    }
}
