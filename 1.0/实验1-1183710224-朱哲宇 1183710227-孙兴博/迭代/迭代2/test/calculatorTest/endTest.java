package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;
import panel.ApplyT;

public class endTest {
	ApplyT app = new ApplyT();
	@Test//û����
	public void test1() {
		app.end();
	}
	@Test//�������
	public void test2() {
		app.Generate("4", "4");
		assertEquals(4,app.all);
		app.end();
		assertEquals(0,app.all);
	}

}
