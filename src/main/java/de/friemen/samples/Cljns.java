package de.friemen.samples;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class Cljns {
	public final static String CLOJURE_CORE = "clojure.core";
	protected final static IFn REQUIRE = Clojure.var(CLOJURE_CORE, "require");
	protected final static IFn DEREF = Clojure.var(CLOJURE_CORE, "deref");
	protected final String ns; 
	public final static Cljns core = new Cljns(CLOJURE_CORE);
	
	public Cljns (String ns) {
		this.ns = ns;
		REQUIRE.invoke(Clojure.read(ns));
	}
	
	public String getName() {
		return ns;
	}
	
	public IFn fn(String symbolName) {
		return Clojure.var(ns, symbolName);
	}
	
	public Object deref(String symbolName) { 
		return DEREF.invoke(fn(symbolName));
	}
	
	public Object keyword(String s) {
		if (s.startsWith(":")) {
			return Clojure.read(s);
		}
		return Clojure.read(":" + s);
	}
}
