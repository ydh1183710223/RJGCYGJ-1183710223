package other;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumToolTest {

	@Test
	public void Checktest() {
		assertEquals(true,NumTool.check("12"));
		assertEquals(false,NumTool.check(""));
		assertEquals(false,NumTool.check("q"));
	}
	@Test
	public void tointtest() {
		assertEquals(12,NumTool.toint("12"));
	}

}
