package com.lee.aafour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int v = 0;

	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee em : employees) {
			map.put(em.id, em);
		}
		return v;
	}

	public void getEmValue(int id, Map<Integer, Employee> map) {
		Employee em = map.get(id);
		v += em.importance;
		if (em.subordinates != null) {
			for (int i : em.subordinates) {
				getEmValue(i, map);
			}
		}
	}

}

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};
