package com.javadev.guava.collect;

import java.util.Set;

import com.google.common.collect.ImmutableSortedSet;

/**
 * 不可变集合的优点
 * 	1、当对象被不可信的库调用时，不可变形式是安全的；
 * 	2、不可变对象被多个线程调用时，不存在竞态条件问题
 * 	3、不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
 * 	4、不可变对象因为有固定不变，可以作为常量来安全使用。 
 * 
 * 创建方式：
 * 	copyOf方法，如ImmutableSet.copyOf(set);
 * 	of方法，如ImmutableSet.of(“a”, “b”, “c”)或ImmutableMap.of(“a”, 1, “b”, 2);
 * 	Builder工具
 * 		
 * 
 */
public class ImmutableTest {
	
	/*public static final ImmutableSet<Color> GOOGLE_COLORS =
			ImmutableSet.<Color>builder()
			    .addAll(WEBSAFE_COLORS)
			    .add(new Color(0, 191, 255))
			    .build();*/

	public static void main(String[] args) {
		//对有序不可变集合来说，排序是在构造集合的时候完成的
		Set set = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		//会在构造时就把元素排序为a, b, c, d。
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
