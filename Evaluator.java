package eg.edu.alexu.csd.datastructure.stack.csX22;


public class Evaluator implements IExpressionEvaluator {
	public float getValue(String s) throws NumberFormatException {
		/**
		 * Takes a string and convert it to its float value
		 * 
		 * @param s 
		 * 
		 * @return float value of the string if it can has float value else throws exception
		 */
		return Float.valueOf(s);
	}
	
	
	public boolean validatePostfix(String s) {
		/**
		 * Takes the postfix and validate it it is called in the evaluate method
		 * it validates that before each operation there is space and after eack operation 
		 * there is space except if the operation at the end of the string in this 
		 * case it is valid if there is no space after it and also to be valid 
		 * postfix the number of operations should be less the number of terms 
		 * 
		 * 
		 * 
		 * @param s
		 * @return true if the posfix is valid else false
		 */
		int i=0;int c1=0;int c2=0;
		if(s.length()==1) {
			s=s.concat(" ");
		}
		if(s.length()==0) {
			s=s.concat(" ");
			s=s.concat(" ");
		}
		for(i=1;i<s.length()-1;i++) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||
					s.charAt(i)=='/') {
				if(s.charAt(i+1)==' '&&s.charAt(i-1)==' ') {
					continue;//before each operation should be ' '
				}
				else {
					return false;
				}
			}
		}
		if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||
				s.charAt(i)=='/') {
			if(s.charAt(i-1)!=' ') {
				return false;
			}
		}//we can check number of spaces too but I don't need to do that
		for(i=0;i<s.length()-1;i++) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||
					s.charAt(i)=='/') {
				c1++;
			}
			else if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
				while(s.charAt(i)>='0'&&s.charAt(i)<='9'
						&&i<s.length()-1) {
				i++;
				}
				c2++;
			}
			else {
				continue;
			}
		}
		if(s.charAt(s.length()-1)=='+'||
				s.charAt(s.length()-1)=='-'||
				s.charAt(s.length()-1)=='*'||
				s.charAt(s.length()-1)=='/') {
			c1++;
		}
		if((s.charAt(s.length()-1)>='0'&&s.charAt(s.length()-1)<='9')&&
				(s.charAt(s.length()-2)<'0'||s.charAt(s.length()-2)>'9')){
			c2++;
		}
		if(s.charAt(0)=='+'||s.charAt(0)=='-'||
				s.charAt(0)=='*'||
				s.charAt(0)=='/') {
			return false;
		}
		if(c1==0&&c2>1) {
			return false;
		}
		if(c1>=c2) {
			return false;
		}
		return true;
	}
	
	
	
	public String checkNegBrackets(String myString) {
		/**
		 * It takes the string (infix) and validate if there are negative brackets
		 * it solves this problem using dummy zeros
		 * 
		 * 
		 * @param myString
		 * @return the string after solving the problem of negative brackets if found
		 */
		int i=0;
		StringBuilder d=new StringBuilder();StackMethods sss=new StackMethods();
		StringBuilder news=new StringBuilder(myString);
		int y=0;
    	StackMethods ss=new StackMethods();int xx=0;int x=0; int counter=0;
    	for(i=0;i<news.length()&&(news.toString().contains("(-(")==true);i++) {
    		//we want now to check this shape (-(-((5))))
    		if(i>0) {
    			if(news.charAt(i)=='-'&&news.charAt(i+1)=='('&&
    					news.charAt(i-1)=='(') {
    				d.append("(0-");
    				int start=i;i++;while(i<news.length()) {
    					if(news.charAt(i)==')') {
    						d.append(news.charAt(i));
    						if(sss.size()==1) {
    							sss.pop();
    							break;
    						}else {
    							sss.pop();
    						}
    					}else if(news.charAt(i)=='(') {
    						sss.push(news.charAt(i));d.append(news.charAt(i));
    					}else {
    						d.append(news.charAt(i));
    					}i++;
    				}
    				news.replace(start, i, d.toString());
    			}
    		}else {
    			//i=0
    			continue;
    			
    		}d.delete(0, d.length());
    		if(i==news.length()-1&&news.toString().contains("(-(")==true) {
    			y++;i=y;
    		}else {
    			if(i==news.length()-1&&news.toString().contains("(-(")==false) {
    				break;
    			}
    		}
    	}
    	if(d.length()>0) {d.delete(0,d.length());}
    	StringBuilder myNewString=new StringBuilder(news);
		for(i=0;i<myNewString.length();i++) {
    		if(i>0) {
    			if(myNewString.charAt(i)=='-'
    					&&myNewString.charAt(i+1)=='('&&
    					(myNewString.charAt(i-1)=='+'||
    					myNewString.charAt(i-1)=='-'||
    					myNewString.charAt(i-1)=='*'||
    					myNewString.charAt(i-1)=='/')) {
    				d.append('(');d.append('0');d.append('-');int sta=i;
    				i++;
    				
    				while(i<myNewString.length()) {
    					if(myNewString.charAt(i)==')') {
    						d.append(myNewString.charAt(i));
    						if(ss.size()==1) {
    							ss.pop();break;
    						}else {
    							ss.pop();
    						}
    					}else if(myNewString.charAt(i)=='(') {
    						d.append(myNewString.charAt(i));
    						ss.push(myNewString.charAt(i));
    					}
    					else {
    						d.append(myNewString.charAt(i));
    					}i++;
    				}myNewString=myNewString.replace(sta, i, d.toString());
    				
    			}
    		}else {
    			//i=0
    			if(myNewString.charAt(i)=='-'&&myNewString.charAt(i+1)=='(') {
    				d.append("(0-");
    				int start=i;i++;while(i<myNewString.length()) {
    					if(myNewString.charAt(i)==')') {
    						d.append(myNewString.charAt(i));
    						if(ss.size()==1) {
    							ss.pop();
    							break;
    						}else {
    							ss.pop();
    						}
    					}else if(myNewString.charAt(i)=='(') {
    						ss.push(myNewString.charAt(i));d.append(myNewString.charAt(i));
    					}else {
    						d.append(myNewString.charAt(i));
    					}i++;
    				}
    				myNewString=myNewString.replace(start, i, d.toString());
    			}
    		}
    		d.delete(0, d.length());
    	}
		return myNewString.toString();
	}
	
	
	
	public boolean validateString(String s) {//without spaces
		/**
		 * Takes the string after we removed spaces in the infix form and validate it 
		 *after we have solved problem of negative numbers and negative brackets
		 *using dummy zeros 
		 * 
		 * 
		 *@param s
		 *@return true if the infix is valid else false
		 */
		int i,j;
		int flag=0;
		if((s.contains("+")==false)&&
				(s.contains("-")==false)&&
				(s.contains("*")==false)
				&&(s.contains("/")==false)) {
			for(i=0;i<s.length()-1;i++) {
				if((s.charAt(i)<='9'&&s.charAt(i)>='0')||
						(s.charAt(i)<='z'&&s.charAt(i)>='a')||
						(s.charAt(i)<='Z'&&s.charAt(i)>='A')) {
					continue;
				}
				else if(s.charAt(i)=='('||s.charAt(i)==')') {
					continue;
				}
				else {
					return false;
				}
			}
			if(s.length()==2) {
				if((s.charAt(0)<='9'&&s.charAt(0)>='0')||
						(s.charAt(0)<='z'&&s.charAt(0)>='a')||
						(s.charAt(0)<='Z'&&s.charAt(0)>='A')) {
					return true;
				}
				else {return false;}
			}
		}
		if(s.length()==3) {
			if(s.charAt(0)<='9'&&s.charAt(0)>='0') {
				if(s.charAt(1)>'9'||s.charAt(1)<'0') {
					return false;
				}else {return true;}
			}
			if((s.charAt(0)<='z'&&s.charAt(0)>='a')||
					s.charAt(0)<='Z'&&s.charAt(0)>='A') {
				if(s.charAt(1)!=' ') {
					return false;
				}
			}
		}
		for(i=0;i<s.length()-2;i++) {
			if(i>0) {
			if(s.charAt(i)=='-'||s.charAt(i)=='+'||s.charAt(i)=='/'
					||s.charAt(i)=='*') {
				if(s.charAt(i+1)=='-'||s.charAt(i+1)=='+'||s.charAt(i+1)=='/'
						||s.charAt(i+1)=='*'||s.charAt(i+1)==')'
						||s.charAt(i-1)=='('||
						s.charAt(i-1)=='-'||
						s.charAt(i-1)=='+'
						||s.charAt(i-1)=='/'
						||s.charAt(i-1)=='*') {
					return false;
				}
				else {
					continue;
				}
			}
			
			
			else if(s.charAt(i)=='(') {
				if(s.charAt(i+1)=='-'||s.charAt(i+1)=='+'||s.charAt(i+1)=='/'
						||s.charAt(i+1)=='*'||s.charAt(i+1)==')'||
						s.charAt(i-1)==')') {
					return false;
				}
				else if((s.charAt(i-1)<='9'&&s.charAt(i-1)>='0')||
						(s.charAt(i-1)<='z'&&s.charAt(i-1)>='a')||
						(s.charAt(i-1)<='Z'&&s.charAt(i-1)>='A')&&
						((s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')||
								(s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')||
								(s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A'))) {
					return false;
				}
				else {
					continue;
				}
			}
			
			
			else if(s.charAt(i)==')') {
				if(s.charAt(i+1)=='('||s.charAt(i-1)=='-'||
						s.charAt(i-1)=='+'||s.charAt(i-1)=='/'
						||s.charAt(i-1)=='*'||s.charAt(i-1)=='(') {
					return false;
				}
				else if(((s.charAt(i-1)<='9'&&s.charAt(i-1)>='0')||
						(s.charAt(i-1)<='z'&&s.charAt(i-1)>='a')||
						(s.charAt(i-1)<='Z'&&s.charAt(i-1)>='A'))&&
						((s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')||
								(s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')||
								(s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A'))) {
					return false;
				}
				else {
					continue;
				}
			}
			
			
			else if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				if((s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')||
						(s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A')) {
					return false;
				}else {
				continue;
				}
			}
			else if((s.charAt(i)<='z'&&s.charAt(i)>='a')||
					(s.charAt(i)<='Z'&&s.charAt(i)>='A')) {
				if((s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')||
						(s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A')) {
					return false;
				}
				else if(s.charAt(i+1)<='9'&&s.charAt(i+1)>='0') {
					return false;
				}
				else {
					continue;
				}
			}
			
			else {
				return false;
			}
			}
			else {
				//i==0
				if((s.charAt(i)<='9'&&s.charAt(i)>='0')||
						(s.charAt(i)<='z'&&s.charAt(i)>='a')||
						(s.charAt(i)<='Z'&&s.charAt(i)>='A')) {
					if((s.charAt(i+1)<='z'&&s.charAt(i+1)>='a')||
							(s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A')) {
						return false;
					}
					else {
						continue;
					}
				}
				else if(s.charAt(i)=='(') {
					continue;
				}
				else {
					return false;
				}
			}
		}
		flag=0;
		if(i==(s.length()-2)) {
			if((s.charAt(i)<='9'&&s.charAt(i)>='0')||
						(s.charAt(i)<='z'&&s.charAt(i)>='a')||
						(s.charAt(i)<='Z'&&s.charAt(i)>='A')) {
				if((s.charAt(s.length()-3)<='z'
						&&s.charAt(s.length()-3)>='a')||
						(s.charAt(s.length()-3)<='Z'
						&&s.charAt(s.length()-3)>='A')) {
					return false;
				}
				else {
					flag=1;
				}
			}
			else if(s.charAt(i)==')') {
				flag=1;
			}
			else {
				return false;
			}
		}
		//check number of brackets
		int c1=0;int c2=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				c1++;
			}
			else if(s.charAt(i)==')') {
				c2++;
			}
		}
		if(c1!=c2) {
			return false;
		}
		StackMethods ss=new StackMethods();
		for(i=0;i<s.length()-1;i++) {
			if(s.charAt(i)=='(') {
				ss.push(s.charAt(i));
			}
			if(s.charAt(i)==')') {
				if(ss.peek().equals('(')) {
					ss.pop();
					
				}
				else {
					return false;
				}
			}
			
		}
		if(ss.size()==0) {
			if(s.charAt(s.length()-1)=='.') {
				return true;
			}else {return false;}
		}else {return false;}
	}
	
	
	public String infixToPostfix(String expression) {
		/**
		 * Takes a symbolic/numeric infix expression as input and converts it to
		 * postfix notation.there is no assumption on spaces between terms or the 
		 * length of the term(e.g.,two digits symbolic or numeric term)
		 * 
		 * 
		 *@param  expression
		 *infix expression
		 * @return postfix expression 
		 */
		if(expression.charAt(expression.length()-1)=='.') {
		StackMethods s=new StackMethods();
		//we will loop in this String
		int i;
		int cc=0;
		int start=0;
		int end=0;
		StringBuilder d = new StringBuilder("");
		String newExpression=new String();
		StringBuilder strin=new StringBuilder(expression);
		strin.deleteCharAt(strin.length()-1);
		newExpression=strin.toString();
		newExpression=newExpression.replaceAll("\\s","");
		//we can remove the spaces first 
		Evaluator t=new Evaluator();
		newExpression=t.checkNegBrackets(newExpression);newExpression=newExpression.concat(".");
	    StringBuilder myString = new StringBuilder(newExpression);
	    if(newExpression.length()==1) {
	    	return "";
	    }
	    if(newExpression.length()>2){
		for(i=0;i<newExpression.length();) {
			d.append('(');
			d.append('0');
			d.append('-');
			if(i>0&&i<newExpression.length()-1&&newExpression.length()>2) {
			if(newExpression.charAt(i)=='-'&&
				((newExpression.charAt(i+1)<='9'&&newExpression.charAt(i+1)>='0')
						||(newExpression.charAt(i+1)>='a'&&newExpression.charAt(i+1)<='z')
						||(newExpression.charAt(i+1)>='A'&&newExpression.charAt(i+1)<='Z')||newExpression.charAt(i+1)=='(')&&
				((newExpression.charAt(i-1)=='*')||
						(newExpression.charAt(i-1)=='/')||
						(newExpression.charAt(i-1)=='-')||
						(newExpression.charAt(i-1)=='+')||
						(newExpression.charAt(i-1)=='('))
				&&i<newExpression.length()-1) {
				//replace it to operation on zero
				start=i;
				i++;
				while(((newExpression.charAt(i)<='9'
						&&newExpression.charAt(i)>='0')||
						(newExpression.charAt(i)>='a'&&
						newExpression.charAt(i)<='z')||
						(newExpression.charAt(i)>='A'
						&&newExpression.charAt(i)<='Z'))
						&&i<newExpression.length()
						&&(newExpression.charAt(i)!='-'
						&&newExpression.charAt(i)!='+'
						&&newExpression.charAt(i)!='/'
						&&newExpression.charAt(i)!='*'
						&&newExpression.charAt(i)!='('
						&&newExpression.charAt(i)!=')')) {
					d.append(newExpression.charAt(i));
					i++;
				}
				end=i;
				//we increased len every time by 3
				if(end<myString.length()) {
				d.append(')');
				 myString.replace(start+cc, end+cc, d.toString());
				}else {
					myString.replace(start+cc,myString.length(), d.toString());
					myString.append(')');
				}
				 cc=cc+3;
			}
			
			else {
				i++;
			}
			}
			
			else {
				if(i==0&&i<newExpression.length()) {
				if(newExpression.charAt(i)=='-') {
				start=i;
				i++;
				while(((newExpression.charAt(i)<='9'&&
						newExpression.charAt(i)>='0')
						||(newExpression.charAt(i)>='a'
						&&newExpression.charAt(i)<='z')
						||(newExpression.charAt(i)>='A'
						&&newExpression.charAt(i)<='Z'))
						&&i<newExpression.length()
						&&(newExpression.charAt(i)!='-'
						&&newExpression.charAt(i)!='+'
						&&newExpression.charAt(i)!='/'
						&&newExpression.charAt(i)!='*')) {
					d.append(newExpression.charAt(i));
					i++;
				}
				end=i;
				if(end<myString.length()) {
					d.append(')');
					 myString.replace(start+cc, end+cc, d.toString());
					}else {
						//end==expression.length()
						myString.replace(start+cc,myString.length(), d.toString());
						myString.append(')');
					}
					 cc=cc+3;
				}
				else {
					i++;
				}
			}
			else {
				i++;	
			}
			}
			d.delete(0, d.length());
		}
		}
	    	if(newExpression.length()==2) {
	    	if(newExpression.charAt(0)=='-') {
	    		d.append(newExpression.charAt(1));
	    		d.append(')');
	    		myString.replace(0, 2, d.toString());
	    	}
	    	}
	    //now let put spaces to make it easier
	    	String news;
	    	news=myString.toString();
	    	news=news.replace('('+"", " ( ");
	    	news=news.replace(')'+"", " ) ");
	    	news=news.replace('*'+"", " * ");
	    	news=news.replace('+'+"", " + ");
	    	news=news.replace('/'+"", " / ");
	    	news=news.replace('-'+"", " - ");
	    	//let's get the postfix now
	    	Evaluator x=new Evaluator();
	    	if(x.validateString(myString.toString())==true) {
	    	StringBuilder str=new StringBuilder("");
	    	if(news.length()==1) {
	    		str.append(news.charAt(0));
	    	}
	    	else if(news.length()>1&&(news.contains('*'+"")==false)
	    			&&(news.contains('+'+"")==false)&&(news.contains('-'+"")==false)
	    			&&(news.contains('/'+"")==false)) {
	    		if((news.contains('('+"")==true)&&(news.contains(')'+"")==true)) {
	    			str.append(news);
	    			str.deleteCharAt(0);
	    			str.deleteCharAt(str.length()-1);
	    		}
	    		else {
	    		str.append(news);
	    		}
	    	}
	    	else {
	    	for(i=0;i<news.length()-1;) {
	    		if(news.charAt(i)=='+'||news.charAt(i)=='-'||
	    				news.charAt(i)=='*'||news.charAt(i)=='/') {
	    			if(s.size()==0&&i<news.length()) {
	    				s.push(news.charAt(i));
	    				i++;
	    			}
	    			
	    			
	    			else {
	    				if(s.peek().equals('(')) {
	    					s.push(news.charAt(i));
	    					i++;
	    				}
	    				
	    				else {
	    					if(news.charAt(i)=='*'||news.charAt(i)=='/') {
	    						if(s.peek().equals('+')==true||s.peek().equals('-')==true) {
	    							s.push(news.charAt(i));
	    							i++;
	    						}
	    						else {
	    							while(s.size()>0&&
	    									(s.peek().equals('(')==false)) {
	    								str.append(' ');
	    								str.append(s.pop());
	    								str.append(' ');
	    							}
	    						}
	    					}
	    					
	    					
	    					else if(news.charAt(i)=='+'||news.charAt(i)=='-'){
	    						while(s.size()>0&&(s.peek().equals('(')==false)) {
	    							str.append(' ');
    								str.append(s.pop());
    								str.append(' ');
	    						}
	    						
	    					}
	    					
	    					
	    				}
	    			}
	    		}
	    		else if(news.charAt(i)=='(') {
	    			s.push(news.charAt(i));
	    			i++;
	    		}
	    		///////////////////
	    		else if(news.charAt(i)==')') {
	    			//we are sure that size>0
	    			while(s.peek().equals('(')==false) {
	    				str.append(' ');
	    				str.append(s.pop());
	    				str.append(' ');
	    			}
	    			i++;
	    			s.pop();
	    		}
	    		else if((news.charAt(i)<='9'&&news.charAt(i)>='0')||
						(news.charAt(i)<='z'&&news.charAt(i)>='a')||
						(news.charAt(i)<='Z'&&news.charAt(i)>='A')) {
	    			str.append(' ');
	    			while(((news.charAt(i)<='9'&&news.charAt(i)>='0')||
							(news.charAt(i)<='z'&&news.charAt(i)>='a')||
							(news.charAt(i)<='Z'&&news.charAt(i)>='A'))&&
	    					i<news.length()) {
	    				str.append(news.charAt(i));
		    			i++;
	    			}
	    			str.append(' ');
	    		}
	    		else {
	    			//it is space 
	    			i++;
	    		}
	    	}
	    	if(news.charAt(i)==')') {
	    		while(s.size()>0&&s.peek().equals('(')==false) {
	    			str.append(' ');
	    			str.append(s.pop());
	    			str.append(' ');
	    		}
	    		s.pop();
	    	}
	    	else if((news.charAt(i)<='9'&&news.charAt(i)>='0')||
							(news.charAt(i)<='z'&&news.charAt(i)>='a')||
							(news.charAt(i)<='Z'&&news.charAt(i)>='A')){
	    		if((news.charAt(i-1)<='9'&&news.charAt(i-1)>='0')||
						(news.charAt(i-1)<='z'&&news.charAt(i-1)>='a')||
						(news.charAt(i-1)<='Z'&&news.charAt(i-1)>='A')) {
	    			str.deleteCharAt(i-1);
	    			str.append(news.charAt(i));
	    			str.append(' ');
	    		}
	    		else {
	    			str.append(' ');
	    			str.append(news.charAt(i));
	    		}
	    		
	    	}
	    	if(s.size()>0) {
	    		str.append(' '); 
	    		while(s.size()>0) {
	    		str.append(s.pop());
	    		str.append(' ');
	    		}
	    	}
	    	}	
	    	if(str.toString().contains("  ")||str.toString().contains(")")
	    			||str.toString().contains("(")||str.toString().contains(".")) {
	    		String sd=str.toString();
	    		sd=sd.replace("(","");
	    		sd=sd.replace(")","");
	    		sd=sd.replace(".","");
	    		sd=sd.replace("  "," ");
	    		if(sd.charAt(0)==' ') {
	    		sd=sd.replaceFirst(" ", "");}
	    		StringBuilder a=new StringBuilder(sd);
	    		if(sd.charAt(sd.length()-1)==' ') {
	    			a=a.deleteCharAt(a.length()-1);
	    		}
	    		return a.toString();
	    	}
	    	else {
	    		return str.toString();
	    	}
	    	}else {
	    		throw new RuntimeException("Invalid Expression");
	    	}
	}else {
		throw new RuntimeException("Invalid Expression");
	}
		}
	
	
	
	
	public int evaluate(String expression) {
		//we will loop in this string till we reach operators
		/**
		 * Evaluate a postfix numeric expression,with a single space separator
		 * it throws exception if the method validatePostfix is false and in case 
		 * of division by zero 
		 * 
		 * @param expression
		 * 				postfix expression
		 * 
		 * @return the expression evaluated value
		 */
		Evaluator j=new Evaluator(); 
		if(((expression.contains('*'+"")==true)
    			||(expression.contains('+'+"")==true)||
    			(expression.contains('-'+"")==true)
    			||(expression.contains('/'+"")==true))&&
				(j.validatePostfix(expression)==true)) {
		float r1;
		float r2;
		float result1;
		String n;
		StackMethods k=new StackMethods();
		int i=0;
		while(i<expression.length()) {
		switch (expression.charAt(i)) {
		case '+':
			r1=j.getValue((k.pop()).toString());
			r2= j.getValue(k.pop().toString());
			result1=r1+r2;
			k.push(result1);
			i++;
			break;
		
		case '*':
			r1= j.getValue(k.pop().toString());
			r2= j.getValue(k.pop().toString());

			result1=r1*r2;
			k.push(result1);
			i++;
			break;
		case '/':
			r1=j.getValue(k.pop().toString());
			r2= j.getValue(k.pop().toString());
			
			if(r1!=0) {
			result1=r2/r1;
			k.push(result1);
			i++;
			}
			else {
				i++;
				throw new RuntimeException("Invalid division operation");
			}
			break;
		case' ':
			i++;
			break;
		case '-':
			r1= j.getValue(k.pop().toString());
			r2= j.getValue(k.pop().toString());
			result1=r2-r1;
			i++;
			k.push(result1);
			break;
		default ://it must be number
			if(expression.charAt(i)<='9'&&expression.charAt(i)>='0'){
			n=""+expression.charAt(i);
			i++;
			while(expression.charAt(i)!=' '&&i<expression.length()) {
				n=n+expression.charAt(i);
				i++;
			}
			k.push(n);
			i++;
			}
			else {
				throw new RuntimeException("you can evaluate numbers only");
			}
			
		}
		}
	int z= (int)(j.getValue(k.peek().toString()));
	return  z;
	}
	else {
		if(j.validatePostfix(expression)==false) {
			throw new RuntimeException("Invalid postfix Expression");
		}
		else {
		int i=0;int flag=0;
		if(expression.length()==1) {
			
		    if(expression.charAt(0)>='0'&&expression.charAt(i)<='9') {
				flag=0;
			}
		    else {
		    	throw new RuntimeException("you can evaluate numbers only");
		    }
		}
		while(i<expression.length()) {
			if((expression.charAt(i)<='9'&&expression.charAt(i)>='0')||
					expression.charAt(i)==' ') {
				i++;
				continue;
			}
			else {
				flag=1;break;
			}
		}
		if(flag==0) {
			StringBuilder s=new StringBuilder(expression);
			s.toString().replaceAll(" ", "");
		int x;
		Evaluator e=new Evaluator();
        x=(int)e.getValue(s.toString());
		return x ;}
		else {
			throw new RuntimeException("you can evaluate numbers only");
		}}
	}
	}}