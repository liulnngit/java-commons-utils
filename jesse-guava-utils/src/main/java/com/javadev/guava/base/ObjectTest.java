package com.javadev.guava.base;

import com.google.common.base.Objects;

/**
 * 好用的Object方法
 * 判断两个对象是否相等
 *
 */
public class ObjectTest {
	
	public static void main(String[] args) {
		
		System.out.println(Objects.equal("a","a"));//true
		System.out.println(Objects.equal(null, "a"));//false
		System.out.println(Objects.equal("a", null));//false
		System.out.println(Objects.equal(null, null));//false
		
	}
}
