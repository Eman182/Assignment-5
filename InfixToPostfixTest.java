package eg.edu.alexu.csd.datastructure.stack.csX22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InfixToPostfixTest {
	Evaluator e=new Evaluator();
	@Test
	void test() {
	assertEquals("13 20 5 2 3 * + * + 2 -", e.infixToPostfix("13+20*(5+2*3)-2"+"."));
	//note that in my function when i enter string without '.' it will give error 
	// we can handle this in the function or tell the user to enter '.' after 
	//the expression or we can do what i did now if he enters string we will get the
	//result by concatinating it with '.' I prefered this method
	
	
	assertEquals("13 20 5 2 + 3 * * + 2 -",e.infixToPostfix("13+20*((5+2)*3)-2"+"."));
	//to get postfix I put spaces before and after each operation except if it is in
	//the end of the string
	
	try {
		e.infixToPostfix("2*3/5");//there is no . at the end of string in this case i throw exception every expression should end with . in my progrm
	}catch(RuntimeException e){
		System.out.println(e.getMessage());
	}
	try {
		e.infixToPostfix("(2*3"+".");
	}catch(RuntimeException e){
		System.out.println(e.getMessage());
	}try {
		e.infixToPostfix("(2*3+4/--5)"+".");

	}catch(RuntimeException e){
		System.out.println(e.getMessage());
	}try {
		e.infixToPostfix("2**8564"+".");

	}catch(RuntimeException e){
		System.out.println(e.getMessage());
	}try {
		e.infixToPostfix("a*5hg"+".");

	}catch(RuntimeException e){
		System.out.println(e.getMessage());
	}

	
	assertEquals("5",e.infixToPostfix("5"+"."));
	assertEquals("0 5 -",e.infixToPostfix("-5"+"."));
	assertEquals("5 4 + 0 3 - 0 2 - * - 0 4 - 0 5 - * +", e.infixToPostfix("5+4--3*-2+(-4*-5)"+"."));
	assertEquals("5",e.infixToPostfix("(5)"+"."));
	assertEquals("5 0 5 2 + - * 0 2 - /",e.infixToPostfix("5*-(5+2)/-2"+"."));
	assertEquals("0 5 - 3 *",e.infixToPostfix("-(((5)))*3"+"."));
	assertEquals("0 0 5 - - 3 *",e.infixToPostfix("-(((-5)))*3"+"."));
	assertEquals("5 0 3 4 * - 0 5 - * - 0 3 - +",e.infixToPostfix("5--(3*4)*-5+-3"+"."));
	assertEquals("5 3 * 0 2 4 * - 0 8 - / -",e.infixToPostfix("(5*3)--(2*4)/-8"+"."));
	assertEquals("7",e.infixToPostfix("7 "+"."));
	assertEquals("7",e.infixToPostfix("(7) "+"."));
	assertEquals("0 7 -",e.infixToPostfix("-(7) "+"."));
	assertEquals("0 7 -",e.infixToPostfix("(-7) "+"."));
	assertEquals("0 7 - 5 *",e.infixToPostfix("((-(7)))*5"+"."));
	assertEquals("",e.infixToPostfix(""+"."));
	assertEquals("",e.infixToPostfix(" "+"."));
	assertEquals("0 0 5 - - 0 3 - * 0 5 - *",e.infixToPostfix("(-((-(5))))*-3*-(5)"+"."));
	assertEquals("0 0 0 5 - - - 0 3 - * 0 5 0 3 - * - *", e.infixToPostfix("(-(-(-(5))))*-3*-(5*(-(3)))"+"."));
	assertEquals("0 6 - 0 0 0 5 - - - *", e.infixToPostfix("-(6)*(-(-(-(5))))"+"."));
	assertEquals("0 4 0 5 3 * - * 0 3 - + -", e.infixToPostfix("-(4*-(5*3)+-(3))"+"."));
	}

}
