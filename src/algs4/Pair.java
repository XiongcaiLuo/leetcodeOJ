package algs4;

import java.util.ArrayList;

public class Pair<T extends Comparable<T>> {
	private T first;
	private T second;

	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}


	public T getFirst() {
		return first;
	}


	public T getSecond() {
		return second;
	}


	public void setFirst(T first) {
		this.first = first;
	}


	public void setSecond(T second) {
		this.second = second;
	}


	public static void main(String[] args) {
		Pair<Integer> p1 = new Pair<Integer>(1,2);
		Pair<Integer> p2 = new Pair<Integer>(1,22);
		System.out.println(p1.equals(p2));
		ArrayList<Pair<String>> ps = new ArrayList<Pair<String>>();
		ps.add(new Pair<String>("a","b"));
	}

}
