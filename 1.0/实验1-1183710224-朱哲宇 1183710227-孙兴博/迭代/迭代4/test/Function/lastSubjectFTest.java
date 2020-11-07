package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;

public class lastSubjectFTest {

	@Test
	public void test() {
		new AnswerUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		lastSubjectF.act();
		assertEquals(1,Database.mark);
	}
	@Test
	public void test1() {
		new AnswerUI();
		Database.init();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		nextSubjectF.act();
		nextSubjectF.act();
		lastSubjectF.act();
		assertEquals(2,Database.mark);
	}

}
