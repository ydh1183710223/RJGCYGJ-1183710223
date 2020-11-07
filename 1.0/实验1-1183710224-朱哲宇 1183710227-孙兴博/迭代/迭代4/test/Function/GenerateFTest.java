package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;

public class GenerateFTest {

	@Test
	public void test() {
	    new AnswerUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		assertEquals(3,Database.question.size());
		assertEquals(3,Database.key.size());
		assertEquals(0,Database.WCollect.size());
		assertEquals(4,Database.hand.length);
		assertEquals(4,Database.judge.length);
		assertEquals(4,Database.wither.length);
	
	}

}
