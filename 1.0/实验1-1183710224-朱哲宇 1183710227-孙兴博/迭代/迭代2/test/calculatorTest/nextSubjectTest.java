package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;


import panel.ApplyT;

public class nextSubjectTest {
	ApplyT app = new ApplyT();
	@Test//û����
	public void test1() {
		app.nextSubject();
		assertEquals(1,app.mark);
	}
	@Test//�������
	public void test2()  {
		app.Generate("4", "4");
		app.nextSubject();
		assertEquals(2,app.mark);
	}


}
