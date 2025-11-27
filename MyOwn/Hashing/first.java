import java.util.*;

public class first {
    public static void main(String args[]){
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India",100);
        hm.put("China", 150);
        hm.put("US",50);

        System.out.println(hm);

        // //Get - O(1)
        // int population = hm.get("India");
        // System.out.println(population);

        // System.out.println(hm.get("Indonesia"));

        // //ContainsKey - O(1)
        // System.out.println(hm.containsKey("India")); //true because it is valid key
        // System.out.println(hm.containsKey("India")); //false because it is not valid

        // //remove - O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        // //Size
        // System.out.println(hm.size());

        //Is Empty
        // hm.clear(); //sab hta dega map ke andar ka 
        // System.out.println(hm.isEmpty());


        //Iterate 
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key=" +k+ ", value="+hm.get(k));
        }
    }
}