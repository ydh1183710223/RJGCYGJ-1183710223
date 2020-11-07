package Function;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Database;
import ui.AnswerUI;
import ui.GenerateUI;

public class endFTest {

	@Test
	public void test() {
		new AnswerUI();
		new GenerateUI();
		Database.all = 3;
		Database.Range = 10;
		GenerateF.act();
		EndF.act("01:01:01");
	}

}
