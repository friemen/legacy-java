package de.friemen.samples;

import static de.friemen.samples.Cljns.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// access clojure.core lib
		core.fn("println").invoke("Hello Awesomeness!");
		
		
		final List<Integer> output = 
				(List<Integer>) 
				core.fn("map").invoke(
						core.fn("inc"), 
						new Integer[] { 1, 2, 3});
		for (Object x :output) {
			System.out.println(x);
		}
		
		// adhoc instantiate a namespace by name
		final Cljns awesome1 = new Cljns("de.friemen.samples.awesome");
		
		// invoke a function of this namespace
		final List<Integer> output2 = 
				(List<Integer>)
				awesome1.fn("map-inc").invoke(Arrays.asList(1, 2, 3));
		
		for (Object x : output2) {
			System.out.println(x);
		}
		
		
		// use a dedicated class to hold real Java wrappers for more convenience
		final Awesome awesome2 = new Awesome();
		final Map<String, Integer> result = awesome2.sumBy("branch", 
				Arrays.asList(
						new Employee("Donald Duck", "Bonn", 150),
						new Employee("Daisy Duck", "Bonn", 200),
						new Employee("Mini Mouse", "Luenen", 300),
						new Employee("Micky Mouse", "Luenen", 50)));
		System.out.println(result);
	}
}
