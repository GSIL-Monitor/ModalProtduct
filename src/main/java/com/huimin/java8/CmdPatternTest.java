package com.huimin.java8;

public class CmdPatternTest {
 public static void main(String[] args) {
	Macro macro = new Macro();
	Editor editor = new Editor() {
		@Override
		public void save() {
			System.out.println("save");
		}
		
		@Override
		public void open() {
			System.out.println("open");
		}
		
		@Override
		public void close() {
			System.out.println("close");
		}
	};
	
	macro.record(new Save(editor));
	macro.record(new Open(editor));
	macro.record(new Close(editor));
	macro.exe();
	
	macro.record(editor::save);
	macro.record(editor::open);
	macro.record(editor::close);
	macro.exe();
	
	Action action =() -> {
		System.out.println("测试action");
	};
	action.perForm();
}
}
