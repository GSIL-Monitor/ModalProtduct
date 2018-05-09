package com.huimin.designpattern.compositePattern;

public class ComponentTest {

	public static void main(String[] args) {
		MachineComposite composite = new MachineComposite();
		composite.addMachineComponent(new Machine());
		MachineComposite composite2 = new MachineComposite();
		composite2.addMachineComponent(new  Machine());
		Machine machine = new Machine();
		machine.stopAll();
		composite2.addMachineComponent(machine);
		composite.addMachineComponent(composite2);
		System.out.println(composite.isCOmpletelyUp());
		System.out.println(composite.getMachineComponent());
	}
}
