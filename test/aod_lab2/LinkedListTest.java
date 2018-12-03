package aod_lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import se.hig.aod.lab2.ExtendedList;
import se.hig.aod.lab2.LinkedList;
import se.hig.aod.lab2.MyListEmptyException;

public class LinkedListTest {
	
	private ExtendedList<Integer> objectUnderTest;
	private final int[] fixture = {1, 2, 3, 4, 5};
	@Rule
	public final ExpectedException expectedException = ExpectedException.none(); 

	@Before
	public void setUp() throws Exception {
		objectUnderTest = new LinkedList<>();
	}

	@After
	public void tearDown() throws Exception {
		objectUnderTest = null;
	}

	@Test
	public void Get_OnListWithOneElement_ReturnsTheElement() {
		objectUnderTest.insertFirst(fixture[0]);
		assertTrue("get() doesn't return the right object", objectUnderTest.get(0).equals(fixture[0]));
	}
	
	@Test
	public void Get_AtIndexFour_ReturnsNumberFive() {
		populateList();
		assertTrue("get() doesn't return the right object", objectUnderTest.get(4).equals(fixture[4]));
	}
	
	@Test
	public void Get_OnEmptyList_ThrowsMyListEmptyException() {
		expectedException.expect(MyListEmptyException.class);
		objectUnderTest.get(0);
	}
	
	@Test
	public void Get_OnIndexOutsideList_ThrowsIndexOutOfBoundsException() {
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.insertFirst(fixture[0]);
		objectUnderTest.get(fixture.length);
	}
	
	@Test
	public void Get_AtNegativeIndex_ThrowsIndexOutOfBoundsException() {
		objectUnderTest.insertFirst(fixture[0]);
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.get(-1);
	}
	
	@Test
	public void Insert_OnEmptyList_ListIsNotEmpty() {
		objectUnderTest.insert(fixture[0], 0);
		assertFalse("The list is empty after using ", objectUnderTest.isEmpty());
	}
	
	@Test
	public void Insert_OnNegativeIndex_ThrowsIndexOutOfBoundsException() {
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.insert(fixture[0], -1);
	}
	
	@Test
	public void Insert_OnIndexOutsideList_ThrowsIndexOutOfBoundsException() {
		populateList();
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.insert(1337, fixture.length + 1);
	}
	
	@Test
	public void Insert_InMiddleOfPopulatedList_InsertsInMiddleOfList() {
		populateList();
		objectUnderTest.insert(1337, fixture.length/2);
		assertTrue("", objectUnderTest.get(1).equals(fixture[1]));
		assertTrue("", objectUnderTest.get(2).equals(1337));
		assertTrue("", objectUnderTest.get(3).equals(fixture[2]));
	}
	
	@Test
	public void Remove_OnEmptyList_ThrowsListEmptyException() {
		expectedException.expect(MyListEmptyException.class);
		objectUnderTest.remove(0);
	}
	
	@Test
	public void Remove_OnListWithOneElement_MakesListEmpty() {
		objectUnderTest.insertFirst(fixture[0]);
		objectUnderTest.remove(0);
		assertTrue("The list is not empty after removing the only element!", objectUnderTest.isEmpty());
	}
	
	@Test
	public void Remove_OnNegativeIndex_ThrowsIndexOutOfBoundsException() {
		populateList();
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.remove(-1);
	}
	
	@Test
	public void Remove_OnIndexOutsideList_ThrowsIndexOutOfBoundsException() {
		populateList();
		expectedException.expect(IndexOutOfBoundsException.class);
		objectUnderTest.remove(fixture.length);
	}
	
	@Test
	public void Remove_OnMiddleOfPopulatedList_RemovesMiddleElement() {
		populateList();
		assertTrue("Wrong element removed!", objectUnderTest.remove(2).equals(fixture[2]));
		assertTrue("remove() has altered the list!", objectUnderTest.get(1).equals(fixture[1]));
		assertTrue("remove() has altered the list!", objectUnderTest.get(2).equals(fixture[3]));
	}
	
	@Test
	public void Remove_OnLastElement_RemovesLastElement() {
		populateList();
		assertEquals("Remove did not remove the last element", Integer.valueOf(fixture[4]), Integer.valueOf(objectUnderTest.remove(4)));
	}
	
	private void populateList() {
		for (int i = 0; i < fixture.length; i++) {
			objectUnderTest.insertLast(fixture[i]);
		}
	}

}
