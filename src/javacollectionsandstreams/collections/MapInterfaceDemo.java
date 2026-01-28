package javacollectionsandstreams.collections;

import java.time.LocalDate;
import java.util.*;

class Employee {
    String name, dept;
    Employee(String n, String d) { name = n; dept = d; }
}

public class MapInterfaceDemo {

    public static void main(String[] args) {

        // Word frequency
        String text = "Hello world hello Java";
        Map<String,Integer> freq = new HashMap<>();
        for (String w : text.toLowerCase().split("\\W+"))
            freq.put(w, freq.getOrDefault(w,0)+1);
        System.out.println(freq);

        // Invert map
        Map<String,Integer> map = Map.of("A",1,"B",2,"C",1);
        Map<Integer,List<String>> inverted = new HashMap<>();
        map.forEach((k,v) ->
                inverted.computeIfAbsent(v,x->new ArrayList<>()).add(k)
        );
        System.out.println(inverted);

        // Max value key
        System.out.println(Collections.max(map.entrySet(),
                Map.Entry.comparingByValue()).getKey());

        // Merge maps
        Map<String,Integer> m1 = new HashMap<>(Map.of("A",1,"B",2));
        Map<String,Integer> m2 = Map.of("B",3,"C",4);
        m2.forEach((k,v)->m1.merge(k,v,Integer::sum));
        System.out.println(m1);

        // Group employees
        List<Employee> emps = List.of(
                new Employee("Alice","HR"),
                new Employee("Bob","IT"),
                new Employee("Carol","HR")
        );

        Map<String,List<Employee>> grouped = new HashMap<>();
        for (Employee e : emps)
            grouped.computeIfAbsent(e.dept,x->new ArrayList<>()).add(e);

        grouped.forEach((k,v)->{
            System.out.print(k+": ");
            v.forEach(e->System.out.print(e.name+" "));
            System.out.println();
        });
    }
}

