package com.javadev.guava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

/**
 * 字符串的一系列操作
 * Joiner
 * 	:将几个字符串，或者字符串数组、列表之类的东西，拼接成一个以指定符号分隔各个元素的字符串
 * 	1、字符串拼接
 * 	2、判空
 * 
 * Joiner.MapJoiner
 * 	:MapJoiner是Joiner的内部静态类，用于帮助将Map对象拼接成字符串
 * 
 * 更详细了解http://ifeve.com/guava-base-1/
 * 
 * 
 * 
 * 
 *
 */
public class JoinerTest {
	public static void main(String[] args) {
		
		//1、拼接字符串
		StringBuilder sb = new StringBuilder("result:");
		Joiner.on(" ").appendTo(sb, 1,2,3);
		System.out.println(sb);//result:1 2 3
		
		//2、判断空
		String res = Joiner.on(' ').skipNulls().join(1,null,3);
		System.out.println(res);//1 3
		res = Joiner.on(' ').useForNull("None").join(1,null,3);
		System.out.println(res);//1 None 3
		
		//MapJoiner
		/*withKeyValueSeparator 方法指定了键与值的分隔符，同时返回一个 MapJoiner 实例。
		 * 往 Map 里插入键或值为空指针的键值对，如果我们要拼接这种 Map，千万记得要用 useForNull 对 MapJoiner 做保护，不然 NPE 妥妥的。
		 */
		res = Joiner.on("#").withKeyValueSeparator("=").join(ImmutableMap.of(1,2,3,4));
		System.out.println(res);//1=2#3=4
		
		
		
	}
	
}
