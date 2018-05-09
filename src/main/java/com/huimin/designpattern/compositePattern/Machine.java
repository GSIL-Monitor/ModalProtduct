package com.huimin.designpattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Machine implements MachineComponent{

	private boolean stop;
	
	private List<String> owners = new ArrayList<>();
	@Override
	public int getMachineComponent() {
		return 1;
	}

	@Override
	public boolean isCOmpletelyUp() {
		return !stop;
	}

	@Override
	public void stopAll() {
		this.stop = true;
	}

	@Override
	public List<String> getOwners() {
		return owners;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}


	public void setOwners(List<String> owners) {
		this.owners = owners;
	}

	public void addOwner(String owner) {
		owners.add(owner);
	}
}
