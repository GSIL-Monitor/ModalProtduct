package com.huimin.designpattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class MachineComposite implements MachineComponent{

	private List<MachineComponent> machineComponents = new ArrayList<>();
	@Override
	public int getMachineComponent() {
		int sum = 0;
		for (MachineComponent machineComponent : machineComponents) {
			sum += machineComponent.getMachineComponent();
		}
		return sum;
	}

	public void addMachineComponent(MachineComponent component) {
		machineComponents.add(component);
	}

	@Override
	public boolean isCOmpletelyUp() {
		for (MachineComponent machine : machineComponents) {
			if (!machine.isCOmpletelyUp()) {
				return false;
			}
		}
		return true;
		//递归实现
		//return isCompetelyUp(this);
	}

	@SuppressWarnings("unused")
	private boolean isCompetelyUp(MachineComposite machineComposite) {
		List<MachineComponent> components = machineComposite.getMachineComponents();
		if (components.isEmpty()) {
			return false;
		}
		for (MachineComponent machineComponent : components) {
			if (machineComponent instanceof MachineComposite) {
				return isCompetelyUp((MachineComposite) machineComponent);
			}else {
				 boolean up = machineComponent.isCOmpletelyUp();
				 if (!up) {
					return false;
				}
			}
		}
		return true;
	}
	@Override
	public void stopAll() {
		for (MachineComponent machine : machineComponents) {
			machine.stopAll();
		}
	}

	@Override
	public List<String> getOwners() {
		List<String> owners = new ArrayList<>();
		for (MachineComponent machine : machineComponents) {
			owners.addAll(machine.getOwners());
		}
		return owners;
	}

	public List<MachineComponent> getMachineComponents() {
		return machineComponents;
	}

	public void setMachineComponents(List<MachineComponent> machineComponents) {
		this.machineComponents = machineComponents;
	}
	
}
