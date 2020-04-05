package eg.edu.alexu.csd.datastructure.stack.csX22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvaluateTest {

	@Test
	void test() {
		Evaluator e=new Evaluator();
		assertEquals(5,e.evaluate(e.infixToPostfix("13*2/4-4--3"+".")));
		assertEquals(15,e.evaluate(e.infixToPostfix("-(((-5)))*3"+".")));
		assertEquals(5,e.evaluate("5 "));
		assertEquals(7,e.evaluate("7"));
		assertEquals(47, e.evaluate("47"));
		assertEquals(5,e.evaluate("10 2 / "));
		assertEquals(30, e.evaluate(e.infixToPostfix("-(6)*(-(-(-(5))))"+".")));
		try {
			e.evaluate("5/0--4");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}
		try {
			e.evaluate("5 0 * +");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("1 n");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("5 0");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("5 0 / ");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("m n *");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("m*");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate("");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}
		try {
			e.evaluate(" ");
		}
		catch(RuntimeException kk) {
			System.out.println(kk.getMessage());
		}	
		try {
			e.evaluate("");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}
		try {
			e.evaluate(e.infixToPostfix(""+"."));
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}
		try {
			e.evaluate("a");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}
		try {
			e.evaluate("/ 1 2");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}
		try {
			e.evaluate("");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}try {
			e.evaluate("1 / 2");
		}
		catch(RuntimeException k) {
			System.out.println(k.getMessage());
		}

}
	}
