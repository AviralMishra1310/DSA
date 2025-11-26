import java.util.*;

public class itinerary {
    public static String getStart(Map<String, String> tickets) {
        Map<String, String> revMap = new HashMap<>();

        // Reverse mapping: destination -> origin
        for (String origin : tickets.keySet()) {
            String dest = tickets.get(origin);
            revMap.put(dest, origin);
        }

        // Find start: origin which is not a destination
        for (String origin : tickets.keySet()) {
            if (!revMap.containsKey(origin)) {
                return origin; // starting point
            }
        }

        return null; // no valid start found
    }

    public static void main(String args[]) {
        Map<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        if (start == null) {
            System.out.println("No valid starting city found!");
            return;
        }

        // Print itinerary
        System.out.print(start);
        while (tickets.containsKey(start)) {   // safe stop condition
            String next = tickets.get(start);
            System.out.print(" -> " + next);
            start = next;
        }

        System.out.println(); // new line at the end
    }
}
