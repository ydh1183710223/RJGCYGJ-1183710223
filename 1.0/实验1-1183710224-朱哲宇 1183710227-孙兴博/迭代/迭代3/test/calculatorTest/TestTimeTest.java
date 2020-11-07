package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import Exception.IllegalCharacterException;
import Exception.OutstepException;
import panel.ApplyT;

public class TestTimeTest {
	ApplyT app=new ApplyT();
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void Test1() 
	{
		try {
			app.SetTestTime("q");
		} catch (IllegalCharacterException e) {
			// TODO Auto-generated catch block
			assertEquals(1,1);
		} catch (OutstepException e) {
			// TODO Auto-generated catch block
			assertEquals(2,1);
		}
	}
	@Test
	public void Test2() 
	{
		
		try {
			app.SetTestTime("-5");
		} catch (IllegalCharacterException e) {
			// TODO Auto-generated catch block
			assertEquals(1,1);
		} catch (OutstepException e) {
			// TODO Auto-generated catch block
			assertEquals(2,1);
		}

	}
	@Test
	public void test1() {
		String Ttime="-1";
		try {
			app.SetTestTime(Ttime);
		} catch (IllegalCharacterException e) {
			// TODO Auto-generated catch block
			assertEquals(1,1);
		} catch (OutstepException e) {
			// TODO Auto-generated catch block
			assertEquals(2,1);
		}
		
	}
	@Test
	public void test2()
	{
		exception.expect(OutstepException.class);
		try {
			app.SetTestTime("0");
		} catch (IllegalCharacterException e) {
			// TODO Auto-generated catch block
			assertEquals(2,1);
		} catch (OutstepException e) {
			// TODO Auto-generated catch block
			assertEquals(1,1);
		}
	}
	@Test
	public void test3() throws IllegalCharacterException, OutstepException
	{
		app.SetTestTime("1");
		assertEquals(1,app.TestTime);
	}
	@Test
	public void test4() throws IllegalCharacterException, OutstepException
	{
		app.SetTestTime("5");
		assertEquals(5,app.TestTime);
	}
	@Test
	public void test5() throws IllegalCharacterException, OutstepException
	{
		app.SetTestTime("300");
		assertEquals(300,app.TestTime);
	}

}
