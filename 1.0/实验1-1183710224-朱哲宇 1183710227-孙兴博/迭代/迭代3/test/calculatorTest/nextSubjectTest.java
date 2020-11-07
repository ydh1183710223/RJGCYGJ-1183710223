package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.ApplyT;

public class nextSubjectTest {
	ApplyT app = new ApplyT();
	@Test//没启动
	public void test1() {
		app.nextSubject();
		assertEquals(1,app.mark);
	}
	@Test//正常情况
	public void test2() throws IllegalCharacterException, OutstepException {
		app.Generate("4", "4");
		app.nextSubject();
		assertEquals(2,app.mark);
	}
	@Test//最后一题
	public void test3() throws IllegalCharacterException, OutstepException {
		app.Generate("1", "4");
		app.nextSubject();
		assertEquals(1,app.mark);
	}

}
