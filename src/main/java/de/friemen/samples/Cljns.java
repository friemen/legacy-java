package de.friemen.samples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class Cljns {
	public final static String CLOJURE_CORE = "clojure.core";
	private final Map<String, IFn> cachedFns = Collections.synchronizedMap(new HashMap<String, IFn>());
	private final Map<String, Object> cachedKeywords = Collections.synchronizedMap(new HashMap<String, Object>());
	protected final String ns; 
	protected final static IFn REQUIRE = Clojure.var(CLOJURE_CORE, "require");
	protected final static IFn DEREF = Clojure.var(CLOJURE_CORE, "deref");
	public final static Cljns core = new Cljns(CLOJURE_CORE);
	
	public Cljns (String ns) {
		this.ns = ns;
		REQUIRE.invoke(Clojure.read(ns));
	}
	
	public String getName() {
		return ns;
	}
	
	public IFn fn(String symbolName) {
		IFn f = cachedFns.get(symbolName);
		if (f == null) {
			f = Clojure.var(ns, symbolName);
			cachedFns.put(symbolName, f);
		}
		return f;
	}
	
	public Object deref(String symbolName) { 
		return DEREF.invoke(fn(symbolName));
	}
	
	public Object keyword(String s) {
		final String kwKey = s.startsWith(":") ? s : ":" + s;
		Object kw = cachedKeywords.get(kwKey);
		if (kw == null) {
			kw = Clojure.read(":" + s);
			cachedKeywords.put(kwKey, kw);
		}
		return kw;
	}
}
