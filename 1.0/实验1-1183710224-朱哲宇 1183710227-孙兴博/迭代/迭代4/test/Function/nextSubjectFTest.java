package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;

public class nextSubjectFTest {

	@Test
	public void test() {
		new AnswerUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		nextSubjectF.act();
		assertEquals(2,Database.mark);
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
		nextSubjectF.act();
		nextSubjectF.act();
		nextSubjectF.act();
		assertEquals(3,Database.mark);
	}

}
