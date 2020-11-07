package other;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void test() {
		Database.mark = 2;
		assertEquals(2,Database.mark);
		Database.init();
		assertEquals(1,Database.mark);
	}

}
