package model;

import java.util.ArrayList;

public class Set <K,V>{
	
	private ArrayList<Map<K,V>> set;
	
	public Set (){
		this.set = new ArrayList<>();
	}
	
	public void put(K index,V par) {
		set.add(new Map<K,V>(index, par));
	}
	
	public ArrayList<Map<K,V>> entrySet(){
		return set;
	}
	
	public void delete() {
		
	}
	
	public K getElement() {
		return null;
	}
	
	public boolean hasElements() {
		boolean out = false;
		if(set.size() > 0) {
			out = true;
		}
		return out;
	}
	
	public int size() {
		return set.size();
		
	}
	
	
}
