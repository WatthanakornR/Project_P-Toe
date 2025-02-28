package Test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.base.Skill;
import entity.base.Unit;
import entity.skill.Skilll_0;
import entity.skill.Skilll_1;
import entity.unit.Unit_Boss;
import entity.unit.Unit_Normal;
import entity.unit.Unit_Player;

public class TestConstructor {
	Unit_Normal unit_1;
	Unit_Normal unit_2;
	Unit_Player myUnit;
	Unit_Boss Boss1;
	Skill skillTest;
	
	@BeforeEach
	void setUp() throws Exception {
		skillTest = new Skilll_0();
		
		unit_1 = new Unit_Normal("Normal Unit1",1,30,20,10,100000);
		unit_2 = new Unit_Normal("Normal Unit2",100,1000,200,100,10000);
		myUnit = new Unit_Player("MyUnit", 1, 100, 20, 10, skillTest);
		Boss1 = new Unit_Boss("Boss", 50, 100, 100, 50, 3, 1000000);
	}
	
	@Test
	void testConstructor_Normal() {
		// Validating the properties
        assertEquals("Normal Unit1", unit_1.getUnitName());
        assertEquals(1, unit_1.getLv());
        assertEquals(30, unit_1.getMaxHp());
        assertEquals(30, unit_1.getHp()); // Since hp should be set to maxHp
        assertEquals(20, unit_1.getAtk());
        assertEquals(10, unit_1.getDef());
        assertEquals(100000, unit_1.getXp());

        // Checking default values
        assertEquals(false, unit_1.isWounded());
        assertEquals(false, unit_1.isIncapacitated());
        assertEquals(0, unit_1.getDamageWounded());
	}
	
	@Test
    void testConstructor_Player() {
        // Validating the properties
        assertEquals("MyUnit", myUnit.getUnitName());
        assertEquals(1, myUnit.getLv());
        assertEquals(100, myUnit.getMaxHp());
        assertEquals(100, myUnit.getHp()); // Since hp should be set to maxHp
        assertEquals(20, myUnit.getAtk());
        assertEquals(10, myUnit.getDef());
        assertEquals(0, myUnit.getXp());

        // Checking default values
        assertEquals(false, myUnit.isWounded());
        assertEquals(false, myUnit.isIncapacitated());
        assertEquals(0, myUnit.getDamageWounded());
        assertEquals(skillTest, myUnit.getSkill());
        assertEquals(0, myUnit.getCooldown());
    }

    @Test
    void testAttack() {
        Unit enemy = new Unit_Normal("Enemy", 1, 50, 10, 5, 0);
        int damage = myUnit.attack(enemy);
        assertEquals(15, damage); // attack (20) - enemy's def (5)
        assertEquals(35, enemy.getHp()); // enemy's initial hp (50) - damage (15)
    }

    @Test
    void testSkillAttack() {
        int skillDamage = myUnit.skillAttack(unit_1);
        assertEquals(10, skillDamage); // skill uses the same attack method in this case
        assertEquals(20, unit_1.getHp()); // enemy's initial hp (50) - skillDamage (15)
        assertEquals(skillTest.getCooldown(), myUnit.getCooldown()); // cooldown should be set
    }

    @Test
    void testLevelUp() {
        int xpToLevelUp = 200;
        myUnit.levelup(xpToLevelUp);
        assertEquals(100, myUnit.getXp()); // remaining XP
        assertEquals(2, myUnit.getLv()); // level should increase
        assertEquals(200, myUnit.getMaxHp()); // increased max HP
        assertEquals(200, myUnit.getHp()); // full HP after level up
        assertEquals(40, myUnit.getAtk()); // increased attack
        assertEquals(20, myUnit.getDef()); // increased defense
    }
    
    @Test
    void testKillUnitToGainXpAndLevelUp() {
        // Initial values
        int initialLv = myUnit.getLv();
        int initialXp = myUnit.getXp();
        int gainedXp = 100000; // XP of unit_1

        // Simulate an attack until unit_1 is dead
        while (unit_1.getHp() > 0) {
            myUnit.attack(unit_1);
        }

        // Expected XP after killing unit_1
        int expectedXp = initialXp + gainedXp;

        // Calculate expected level and remaining XP after level up
        int expectedLv = initialLv;
        int xpThreshold = initialLv * 100;
        while (expectedXp >= xpThreshold) {
            expectedXp -= xpThreshold;
            expectedLv++;
            xpThreshold = expectedLv * 100;
        }

        // Check that unit_1 is dead
        assertEquals(true, unit_1.isDead());

        // Validate XP and level
        assertEquals(expectedXp, myUnit.getXp()); // Validate remaining XP
        assertEquals(expectedLv, myUnit.getLv()); // Validate level increase

        // Validate attributes after level up
        assertEquals(100 + (expectedLv - initialLv) * 100, myUnit.getMaxHp());
        assertEquals(20 + (expectedLv - initialLv) * 20, myUnit.getAtk());
        assertEquals(10 + (expectedLv - initialLv) * 10, myUnit.getDef());
    }


}
