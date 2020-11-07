package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;

public class JumpToFTest {

	@Test
	public void test() {
		new AnswerUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		JumpToF.act(2);
		assertEquals(2,Database.mark);
		
	}
	@Test
	public void test1() {
		new AnswerUI();
		Database.init();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		JumpToF.act(100);
		assertEquals(1,Database.mark);
		
	}

}
