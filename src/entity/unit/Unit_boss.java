package entity.unit;

import entity.base.Unit;

public class Unit_Boss extends Unit {
	private int life;
	private int xp;

	public Unit_Boss(String name, int lv, int hp, int atk, int def, int life,int xp) {
		super(name, lv, hp, atk, def);
		setXp(xp);
		this.life = life;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		if (life != 0 && getHp() == 0) {
			setLife(life - 1);
			receive();
		} 
		return super.isDead();
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = Math.max(0, life);
	}

}
