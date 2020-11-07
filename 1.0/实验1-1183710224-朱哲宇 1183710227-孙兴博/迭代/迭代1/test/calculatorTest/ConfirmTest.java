package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.App;

public class ConfirmTest {
	App app = new App();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test //出现异常
	public void test1() throws IllegalCharacterException, OutstepException {
		app.Generate("4","4");
		exception.expect(IllegalCharacterException.class);
		app.confirm("");
	}
	@Test//没启动
	public void test2() throws IllegalCharacterException
	{
		app.confirm("");
	}
	@Test//答错
	public void test3() throws IllegalCharacterException, OutstepException
	{
		app.Generate("4","4");
		app.confirm("q");
		assertEquals(-1,app.wither[1]);
	}
	@Test//答对
	public void test4() throws IllegalCharacterException, OutstepException
	{
		app.Generate("4","4");
		app.confirm(""+app.key.get(0));
		assertEquals(1,app.wither[1]);
	}
	@Test//答错
	public void test5() throws IllegalCharacterException, OutstepException
	{
		app.Generate("4","4");
		app.confirm("1"+app.key.get(0));
		assertEquals(-1,app.wither[1]);
	}

}
