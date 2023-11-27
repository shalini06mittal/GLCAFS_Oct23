package com.generics;

import java.util.ArrayList;
import java.util.Collections;

public class StateComparable {

	public static void main(String[] args) {
		// 2.1 to create arraylist object with type States
		ArrayList<States> states = new ArrayList<States>();
		
		// 2.2 Add multiple State object to the arraylist
		states.add(new States("Maharashtra", "MH"));
		states.add(new States("Uttar Pradesh", "UP"));
		states.add(new States("Madhya Pradesh", "MP"));
		states.add(new States("Andhra Prasdesh", "AP"));
		states.add(new States("Tamil Nadu", "TN"));
		
		// 2.3 Sort the arraylist object based on the created comparable class
		Collections.sort(states);
		
		// 2.4 Print all the objects in the arraylist after sorting based on state name
		for(States st :states)
			System.out.println(st.getStatename()+" "+st.getStatecode());
		}
}
