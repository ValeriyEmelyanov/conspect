package stream_api.symmetric_difference;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The symmetric difference of two sets is the set that contains elements
 * that are in either of the sets but not in their intersection.
 * In other words, only those elements that are present in one set and not present in the other.
 */
public class Solution {

    /**
     * @return symmetric difference between set1 and set2
     */
    private static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        return Stream
                .concat(set1.stream(), set2.stream())
                .filter(Predicate.not(e -> set1.contains(e) && set2.contains(e)))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String strSet1 = scanner.nextLine();
        String strSet2 = scanner.nextLine();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        if (!Objects.equals(strSet1, "empty")) {
            Collections.addAll(set1, strSet1.split("\\s+"));
        }

        if (!Objects.equals(strSet2, "empty")) {
            Collections.addAll(set2, strSet2.split("\\s+"));
        }

        Set<String> resultSet = symmetricDifference(set1, set2);

        System.out.println(String.join(" ", resultSet));
    }

}
