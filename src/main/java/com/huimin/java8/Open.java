package com.huimin.java8;

public class Open implements Action {

	private final Editor editor;
    public Open(Editor editor) {
		this.editor = editor;
	}
	@Override
	public void perForm() {
        editor.open();
	}

}
