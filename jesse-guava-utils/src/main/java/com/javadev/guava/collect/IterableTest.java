package com.javadev.guava.collect;

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Iterables
 */

public class IterableTest {
	
	public static void main(String[] args) {
		
		List<String> list = Lists.newArrayList("ab","abd","and");
		//好用的
		Iterable<String> concatenated = Iterables.concat(list);
		String lastAdded = Iterables.getLast(concatenated);
		System.out.println(lastAdded);//and
		
	}
}
