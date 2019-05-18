package com.lee.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision399 {

	public static void main(String[] args) {
		EvaluateDivision399 obj = new EvaluateDivision399();

	}

	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, Map<String, Double>> divide = new HashMap<>();
		Set<String> set = new HashSet<>();
		Set<String> visited = new HashSet<>();

		for (int i = 0; i < equations.size(); i++) {
			double v = values[i];
			List<String> l = equations.get(i);
			String a = l.get(0);
			String b = l.get(1);
			set.add(a);
			set.add(b);
			if (!divide.containsKey(a)) {
				divide.put(a, new HashMap<String, Double>());
			}
			if (!divide.containsKey(b)) {
				divide.put(b, new HashMap<String, Double>());
			}
			divide.get(a).put(b, v);
			divide.get(b).put(a, 1/v);
		}

		double[] r = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			List<String> l = queries.get(i);
			String a = l.get(0);
			String b = l.get(1);
			if(!set.contains(a) || !set.contains(b)){
				r[i]=-1;
				continue;
			}
			visited.add(a);
			if (a.equals(b)) {
				r[i]=1;
				continue;
			}
			double t = getV(divide, a, b, visited);
			visited.remove(a);
			r[i]=t;
		}
		return r;

	}

	double getV(Map<String, Map<String, Double>> divide, String a, String b, Set<String> visited) {

		if (divide.containsKey(a)) {
			for (String key : divide.get(a).keySet()) {
				double t = divide.get(a).get(key);
				if (key.equals(b)) {
					return t;
				}
				if(visited.contains(key)){
					continue;
				}
				visited.add(key);
				double r = getV(divide, key, b,visited);
				visited.remove(key);
				if (r == -1) {
					continue;
				}
				return r * t;
			}
		}
		return -1;
	}

}
