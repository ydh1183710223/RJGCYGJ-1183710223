package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.App;

public class GenerateTest {
	
	App app = new App();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test  //出现异常
	public void test1() throws IllegalCharacterException, OutstepException {
		exception.expect(IllegalCharacterException.class);
		app.Generate("q","q");
	}
	@Test
	public void test2() throws IllegalCharacterException, OutstepException {
		exception.expect(IllegalCharacterException.class);
		app.Generate("","4");
	}@Test
	public void test3() throws IllegalCharacterException, OutstepException {
		exception.expect(OutstepException.class);
		app.Generate("0","q");
	}@Test
	public void test4() throws IllegalCharacterException, OutstepException {
		exception.expect(IllegalCharacterException.class);
		app.Generate("3","");
	}@Test
	public void test5() throws IllegalCharacterException, OutstepException {
		exception.expect(IllegalCharacterException.class);
		app.Generate("3","q");
	}@Test
	public void test6() throws IllegalCharacterException, OutstepException {
		exception.expect(OutstepException.class);
		app.Generate("3","1");
	}@Test
	public void test7() throws IllegalCharacterException, OutstepException {
		exception.expect(OutstepException.class);
		app.Generate("3","2");
	}
	@Test//正常情况
	public void test8() throws IllegalCharacterException, OutstepException {
		app.Generate("3","4");
		assertEquals(3,app.all);
		assertEquals(1,app.operate);
		assertEquals(3,app.question.size());
		assertEquals(3,app.key.size());
	}
	
}
