package com.valtech.training.simple;

import junit.framework.TestCase;

public class OperationTest extends TestCase {
	
	
	
	
	
	public void testAdd() {
//		assertEquals(6, add.perform(3, 3));
//		assertEquals(0, sub.perform(3, 3));
//		assertEquals(9, mul.perform(3, 3));
//		assertEquals(1, div.perform(3, 3));
//		
		
		assertEquals(5, Operation.ADD.perform(2,3));
		assertEquals(0, Operation.SUB.perform(3,3));
		assertEquals(6, Operation.MUL.perform(2,3));
		assertEquals(1, Operation.DIV.perform(3,3));
		
	}

}
