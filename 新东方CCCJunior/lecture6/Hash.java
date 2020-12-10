package demo;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

public class Hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("---Ternary Expression---");
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		String outputString = "";
//		if (n % 2 == 0) {
//			outputString = "Even number!";
//		} else {
//			outputString = "Odd number!"; 
//		}
//		System.out.println(outputString);
//		
//		String outputString2 = n % 2 == 0 ? "Even number!" : "Odd number!"; // exp1 : return boolean; [either return exp2 or exp3];
//		System.out.println(outputString2);
		
		System.out.println("---HashSet Demo---");
		HashSet<String> stringSet = new HashSet<>();
		stringSet.add("Toronto");
		stringSet.add("Ottawa");
		stringSet.add("Montreal");
		System.out.println("stringSet := " + stringSet.toString());
		
		System.out.println("stringSet contains Toronto := " + stringSet.contains("Toronto"));
		
		System.out.println("stringSet size := " + stringSet.size());
		
		stringSet.remove("Ottawa");
		System.out.println("new stringSet := " + stringSet.toString());
		
		
		System.out.println("new stringSet size := " + stringSet.size());
		
		System.out.println("---HashSet Iterator---");
		
		for (String city: stringSet) {
			System.out.print(city + ", ");
		}
		System.out.println();
		
		Iterator<String> it = stringSet.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println();
		
		stringSet.remove("Toronto");
		stringSet.remove("Montreal");
		
		System.out.println("Now stringset is emtpy := " + stringSet.isEmpty());
		
		System.out.println("---HashMap API---");
		HashMap<String, String> capitalCity = new HashMap<>();
		capitalCity.put("Canada", "Ottawa"); // HASHMAP.put(K, V);
		capitalCity.put("China", "Beijing");
		capitalCity.put("Iran", "Tehran");
		capitalCity.put("Russia", "Mosco");
		capitalCity.put("Germany", "Berlin");
		System.out.println("Print out capitalCity := " + capitalCity.toString());
		
		// update
		capitalCity.put("Germany", "BBerlin"); // method overloading.
		System.out.println("Print out capitalCity := " + capitalCity.toString());
		
		System.out.println("Get := " + capitalCity.get("Iran"));
		System.out.println("Get := " + capitalCity.get("Canada"));
		
		
		// containsKey O(1) is more important than containsValue O(N).
		System.out.println("capitalCity contains china as key := " + capitalCity.containsKey("China"));
		System.out.println("capitalCity contains Germany as value := " + capitalCity.containsValue("Germany")); 
		System.out.println("capitalCity contains Germany as key := " + capitalCity.containsKey("Germany"));
		System.out.println("capitalCity contains BBerlin as value := " + capitalCity.containsValue("BBerlin"));
		
		capitalCity.remove("Germany");
		System.out.println("Print out capitalCity := " + capitalCity.toString());
		
		System.out.println("--- HashMap Iterator ---");
		// .keySet() return keySet
		System.out.println("keySet := " + capitalCity.keySet().toString());
		
		for (String country: capitalCity.keySet() /* considered as set*/) {
			System.out.print(country + "=" + capitalCity.get(country) + ", ");
		}
		
		System.out.println();
		
		capitalCity.forEach( /*input a function*/ (country, capital_city) -> {
			System.out.print(country + "=" + capital_city + ", ");
		});
		
		System.out.println();
		
		System.out.println("capitalCity.isEmpty() := " + capitalCity.isEmpty());
		System.out.println("capitalCity.size() := " + capitalCity.size());
		
		
		
	}
	
	

}
