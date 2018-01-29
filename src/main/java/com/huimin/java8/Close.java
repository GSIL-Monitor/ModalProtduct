package com.huimin.java8;

public class Close implements Action {

	private final Editor editor;
	public Close(Editor editor) {
		this.editor = editor;
	}
	@Override
	public void perForm() {
       editor.close();
	}

}
