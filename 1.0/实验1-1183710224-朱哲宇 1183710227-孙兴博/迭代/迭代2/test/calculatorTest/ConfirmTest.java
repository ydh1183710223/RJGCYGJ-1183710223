package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;


import panel.ApplyT;

public class ConfirmTest {
	ApplyT app = new ApplyT();

	@Test//´ð¶Ô
	public void test4()
	{
		app.Generate("4","4");
		app.confirm(""+app.key.get(0));
		assertEquals(1,app.wither[1]);
	}
	@Test//´ð´í
	public void test5()
	{
		app.Generate("4","4");
		app.confirm("1"+app.key.get(0));
		assertEquals(-1,app.wither[1]);
	}

}
