package com.javadev.guava.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 集合实例化过程
 *
 */
public class CollectionTest {
	
	public static void main(String[] args) {
		
		//传统方式创建列表
		List<String> list = new ArrayList<String>();
		
		//Guava写法
		List<String> list2 = Lists.newArrayList();
		Map<String,String> map = Maps.newLinkedHashMap();
		
		//这个构造方法非常实用
		List<String> list3 = Lists.newArrayList("ay","and","ab");
		System.out.println(Joiner.on(",").join(list3));//ay,and,ab
		
		List<String> exactly100 = Lists.newArrayListWithCapacity(100);
		List<String> approx100 = Lists.newArrayListWithExpectedSize(100);
		Set<String> apprxo100set = Sets.newHashSetWithExpectedSize(100);
		
	}
	
}
