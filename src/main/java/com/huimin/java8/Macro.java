package com.huimin.java8;

import java.util.ArrayList;
import java.util.List;

public class Macro {

	
	private final List<Action> actions = new ArrayList<>();
	
	public void record(Action action) {
		actions.add(action);
	}
	
	public void exe() {
		actions.forEach( Action:: perForm);
	}
}
