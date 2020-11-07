package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;

public class ConfirmFTest {

	@Test
	public void test1() {
		new AnswerUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		ConfirmF.act("-2");
		assertEquals(-1,Database.wither[1]);
		assertEquals(1,Database.WCollect.size());
		assertEquals("´ð´í£¬´ð°¸Îª"+Database.key.get(0),Database.judge[1]);
		assertEquals(1,Database.mWrong);
	}
	@Test
	public void test2() {
		new AnswerUI();
		Database.init();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		ConfirmF.act(""+Database.key.get(0));
		assertEquals(1,Database.wither[1]);
		assertEquals(0,Database.WCollect.size());
		assertEquals("¡Ì",Database.judge[1]);
		assertEquals(0,Database.mWrong);
	}

}
