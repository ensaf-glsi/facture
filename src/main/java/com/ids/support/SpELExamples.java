package com.ids.support;

import java.util.GregorianCalendar;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExamples {

	
	public static void main(String[] args) {
//		ExpressionParser parser = new SpelExpressionParser();
////		Expression exp = parser.parseExpression("'Hello World'.toUpperCase()"); 
//		Expression exp = parser.parseExpression("T(com.ids.support.StringUtils).toUpperCase(null)"); 
////		String message = (String) exp.getValue();
//		String s = null;
////		s.toUpperCase()
//		System.out.println(exp.getValue());
		
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);

		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

		ExpressionParser parser = new SpelExpressionParser();

		Expression exp = parser.parseExpression("name.toUpperCase()"); // Parse name as an expression
		String name = (String) exp.getValue(tesla);
		String name2 = exp.getValue(tesla, String.class);
		// name == "Nikola Tesla"
		System.out.println(name2);

		exp = parser.parseExpression("name == 'Nikola Tesl'");
		boolean result = exp.getValue(tesla, Boolean.class);
		// result == true
		System.out.println(result);
	}
}
