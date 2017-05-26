package com.julse;

import android.graphics.Color;

public class ConfigWelcome {
	private  int pro_length=30;
	private  float text_size;//15--60
	private int text_color_id=0;
	public int[] color={Color.RED,Color.GREEN,Color.BLUE,Color.BLACK};
	
	public int getPro_length() {
		return pro_length;
	}
	public void setPro_length(int pro_length) {
		this.pro_length = pro_length;
		
	}
	public float getText_size() {
		return (float) (15+pro_length*45.0/100);
	}
	public void setText_size(float text_size) {
		this.text_size = text_size;
	}
	public int getText_color_id() {
		return text_color_id;
	}
	public void setText_color_id(int text_color_id) {
		this.text_color_id = text_color_id;
	}

	

	
}
