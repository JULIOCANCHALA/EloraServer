package com.canchala.julio.eloraserver;

public class RowItem {

	private String text1;
	private String text2;
	private int icon;

	public RowItem(String text1, String text2,int icon) {
		this.text1 = text1;
		this.text2 = text2;


		this.icon = icon;
	}

	public String getText1() {return text1;	}

	public String getText2() {return text2;	}

	public int getIcon() {
		return icon;
	}
}
