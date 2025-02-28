package entity.unit;

import entity.base.Unit;

public class Unit_Normal extends Unit {

	public Unit_Normal(String name, int lv, int hp, int atk, int def,int xp) {
		super(name, lv, hp, atk, def);
		setXp(xp);
	}
	
	
}
