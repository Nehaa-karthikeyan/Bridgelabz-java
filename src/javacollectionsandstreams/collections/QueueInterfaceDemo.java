package javacollectionsandstreams.collections;

import java.util.*;

class Patient {
    String name;
    int severity;
    Patient(String n, int s) { name = n; severity = s; }
}

public class QueueInterfaceDemo {

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) s.push(q.remove());
        while (!s.isEmpty()) q.add(s.pop());
    }

    static List<String> generateBinary(int n) {
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String s = q.remove();
            res.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return res;
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>(List.of(10,20,30));
        reverseQueue(q);
        System.out.println(q);

        System.out.println(generateBinary(5));

        PriorityQueue<Patient> pq =
                new PriorityQueue<>((a,b) -> b.severity - a.severity);
        pq.add(new Patient("John",3));
        pq.add(new Patient("Alice",5));
        pq.add(new Patient("Bob",2));

        while(!pq.isEmpty())
            System.out.println(pq.remove().name);
    }
}

