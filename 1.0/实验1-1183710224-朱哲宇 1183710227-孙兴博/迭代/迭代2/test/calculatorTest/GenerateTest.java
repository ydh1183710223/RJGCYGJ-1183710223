package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import panel.ApplyT;

public class GenerateTest {
	
	ApplyT app = new ApplyT();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test//正常情况
	public void test8() {
		app.Generate("3","4");
		assertEquals(3,app.all);
		assertEquals(1,app.operate);
		assertEquals(3,app.question.size());
		assertEquals(3,app.key.size());
	}
	
}
