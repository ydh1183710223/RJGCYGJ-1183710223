package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import panel.ApplyT;

public class lastSubjectTest {
	ApplyT app = new ApplyT();
	@Test//û����
	public void test1() {
		app.lastSubject();
		assertEquals(1,app.mark);
	}
	@Test//�������
	public void test2()  {
		app.Generate("4", "4");
		app.nextSubject();
		app.lastSubject();
		assertEquals(1,app.mark);
	}


}
