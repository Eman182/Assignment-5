package eg.edu.alexu.csd.datastructure.stack.csX22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStack {
	StackMethods s=new StackMethods();
	@Test
	void test() {
		s.push(0.1);	assertEquals(0.1, s.peek());
		s.push(1);		assertEquals(1, s.peek());
		s.push(2);      assertEquals(2, s.peek());
		s.push(3);		assertEquals(3, s.peek());
		s.push(4);		assertEquals(4, s.peek());
		s.push(5);		assertEquals(5, s.peek());
		assertEquals(6, s.size());
		s.pop();		assertEquals(4, s.peek());	assertEquals(5, s.size());
		s.pop();		assertEquals(3, s.peek());  assertEquals(4, s.size());
		s.pop();		assertEquals(2, s.peek());  assertEquals(3, s.size());
		assertEquals(false, s.isEmpty());
		s.pop();s.pop();s.pop();
		assertEquals(true, s.isEmpty());
		try {
			s.pop();
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
		try {
			s.peek();
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
	}

}
