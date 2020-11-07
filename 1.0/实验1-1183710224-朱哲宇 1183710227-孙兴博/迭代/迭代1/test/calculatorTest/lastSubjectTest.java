package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.App;

public class lastSubjectTest {
	App app = new App();
	@Test//û����
	public void test1() {
		app.lastSubject();
		assertEquals(1,app.mark);
	}
	@Test//�������
	public void test2() throws IllegalCharacterException, OutstepException {
		app.Generate("4", "4");
		app.nextSubject();
		app.lastSubject();
		assertEquals(1,app.mark);
	}
	@Test//��һ��
	public void test3() throws IllegalCharacterException, OutstepException {
		app.Generate("2", "4");
		app.lastSubject();
		assertEquals(1,app.mark);
	}

}
