package com.saumya.JDBCTryWithResource;

public class Example {
	public static void main(String[] args) {
		Preference p = new Preference();
		p.aa = new AA();
		p.bb = new BB();
		System.out.println(p.aa.id());
		System.out.println(p.bb.name());
	}
}

class AA {
	public int id() {
		return 0;
	}
}

class BB {
	public String name() {
		return "Saumya";
	}
}

interface AAInterface {
	public int id();
}

interface BBInterface {
	public String name();
}

class Preference {
	AA aa;
	BB bb;

	public int id() {
		return aa.id();
	}

	public String name() {
		return bb.name();
	}
}
