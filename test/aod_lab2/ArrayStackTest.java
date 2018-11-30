package aod_lab2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import se.hig.aod.lab2.ArrayStack;
import se.hig.aod.lab2.ArrayStackEmptyException;
import se.hig.aod.lab2.ArrayStackFullException;
import se.hig.aod.lab2.Stack;

public class ArrayStackTest {

	private ArrayStack<Integer> objectUnderTest;
	private final int[] fixture = {1, 2, 3, 4, 5};
	private final ByteArrayOutputStream testStream = new ByteArrayOutputStream();
	private final PrintStream sysOut = System.out;
	private final int num = 1;
	
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		objectUnderTest = new ArrayStack<>(5);
		System.setOut(new PrintStream(testStream));
	}

	@After
	public void tearDown() throws Exception {
		objectUnderTest = null;
		System.setOut(sysOut);
	}
	
	@Test
	public void IsEmpty_OnEmptyStack_ReturnsTrue() {
		assertTrue("Newly created stack is not empty!", objectUnderTest.isEmpty());
	}
	
	@Test
	public void Push_OnEmptyStack_StackNotEmpty() {
		objectUnderTest.push(num);
		assertFalse("Stack is empty after push(1)!", objectUnderTest.isEmpty());
	}
	
	@Test
	public void PushNull_OnEmptyStack_DoesNotGenerateException() {
		objectUnderTest.push(null);
	}
	
	@Test
	public void Push_OnFullStack_ThrowsArrayStackEmptyException() {
		expectedException.expect(ArrayStackFullException.class);
		
		populateStack();
		objectUnderTest.push(1);
	}
	
	@Test
	public void Pop_OnEmptyStack_ThrowsStackEmptyException() {
		expectedException.expect(ArrayStackEmptyException.class);
		objectUnderTest.pop();
	}
	
	@Test
	public void Pop_OnPopulatedStack_ReturnsLatestPushed() {
		populateStack();
		assertEquals(Integer.valueOf(fixture[4]), objectUnderTest.pop());
	}
	
	@Test
	public void Pop_OnStackWithNullValue_ReturnsNull() {
		objectUnderTest.push(null);
		objectUnderTest.pop();
	}
	
	@Test
	public void Clear_OnEmptyStack_DoesNotGenerateException() {
		objectUnderTest.clear();
	}
	
	@Test
	public void Clear_OnPopulatedStack_StackIsEmpty() {
		populateStack();
		objectUnderTest.clear();
		assertTrue("Populated Stack not empty after clear!", objectUnderTest.isEmpty());
	}
	
	@Test
	public void Clear_OnEmptyStack_PrintsMessage() {
		objectUnderTest.clear();
		assertEquals("clear() does not print expected message to System.out", "ArrayStack cleared!", testStream.toString());
	}
	
	@Test
	public void Top_OnEmptyStack_ThrowsArrayStackEmptyException() {
		expectedException.expect(ArrayStackEmptyException.class);
		objectUnderTest.top();
	}
	
	@Test
	public void Top_OnPopulatedStack_ReturnsLastPushed() {
		populateStack();
		assertTrue("Top does not return the object on top of the Stack!",
				objectUnderTest.top().equals(fixture[4])); 
	}
	
	@Test
	public void IsFull_OnEmptyStack_ReturnsFalse() {
		assertFalse("isFull() returned true for empty Stack!", objectUnderTest.isFull());
	}
	
	@Test
	public void IsFull_OnFullStack_ReturnsTrue() {
		populateStack();
		assertTrue("isFull() returned false for full Stack!", objectUnderTest.isFull());
	}
	
	private void populateStack() {
		for (int i : fixture) {
			objectUnderTest.push(i);
		}
	}

}
