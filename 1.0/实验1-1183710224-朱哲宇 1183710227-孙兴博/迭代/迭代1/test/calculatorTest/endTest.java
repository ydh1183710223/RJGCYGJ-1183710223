package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.App;

public class endTest {
	App app = new App();
	@Test//û����
	public void test1() {
		app.end();
	}
	@Test//�������
	public void test2() throws IllegalCharacterException, OutstepException {
		app.Generate("4", "4");
		assertEquals(4,app.all);
		app.end();
		assertEquals(0,app.all);
	}

}
