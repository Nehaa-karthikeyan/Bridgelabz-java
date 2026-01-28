package javacollectionsandstreams.collections;

import java.time.LocalDate;
import java.util.*;

class Policy {
    int policyNo;
    String holder;
    LocalDate expiry;
    String type;
    double premium;

    Policy(int p, String h, LocalDate e, String t, double pr) {
        policyNo = p; holder = h; expiry = e; type = t; premium = pr;
    }

    public int hashCode() { return policyNo; }
    public boolean equals(Object o) {
        return o instanceof Policy && policyNo == ((Policy)o).policyNo;
    }
}

public class SetInterfaceDemo {

    public static void main(String[] args) {

        // Set equality
        Set<Integer> s1 = new HashSet<>(Set.of(1,2,3));
        Set<Integer> s2 = new HashSet<>(Set.of(3,2,1));
        System.out.println(s1.equals(s2));

        // Union & Intersection
        Set<Integer> union = new HashSet<>(s1);
        union.addAll(Set.of(3,4,5));
        System.out.println(union);

        Set<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(Set.of(3,4,5));
        System.out.println(intersection);

        // Symmetric difference
        Set<Integer> diff = new HashSet<>(union);
        diff.removeAll(intersection);
        System.out.println(diff);

        // Set to sorted list
        Set<Integer> hs = Set.of(5,3,9,1);
        List<Integer> sorted = new ArrayList<>(hs);
        Collections.sort(sorted);
        System.out.println(sorted);

        // Subset
        System.out.println(Set.of(2,3).containsAll(Set.of(2,3)));
    }
}
