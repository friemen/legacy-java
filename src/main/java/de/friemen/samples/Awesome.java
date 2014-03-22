package de.friemen.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import clojure.lang.LazySeq;

public class Awesome extends Cljns {
	private static Cljns data = new Cljns("clojure.java.data");
	
	public Awesome() {
		super("de.friemen.samples.awesome");
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> mapInc (Integer ...ints) {
		return new ArrayList<Integer>((LazySeq) fn("map-inc").invoke(ints));
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Integer> sumBy (String field, List<Employee> es) {
		return (Map<String, Integer>) 
				fn("sum-by").invoke(
						keyword(field), 
						data.fn("from-java").invoke(es));
	}
}
