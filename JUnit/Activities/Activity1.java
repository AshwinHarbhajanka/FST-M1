package activities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Activity1 {
	ArrayList<String> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<String>();
		list.add("alpha");
		list.add("beta");
	}

	@Test
	public void insertTest() {
		assertEquals(2, list.size());
		list.add(2, "charlie");
		assertEquals(3, list.size());
		assertEquals("alpha", list.get(0));
		assertEquals("beta", list.get(1));
		assertEquals("charlie", list.get(2));
	}

	@Test
	public void replaceTest() {
		list.set(0, "Ashwin");
		assertEquals("Ashwin", list.get(0));
		assertEquals("beta", list.get(1));
	}
}
