package com.javadev.guava.base;

import java.util.List;
import java.util.Map;

import com.google.common.base.Splitter;

/**
 * 
 * @author ll-t150
 * Splitter 字符串拆分
 * 更多了解http://ifeve.com/guava-base-2/
 */
public class SplitterTest {
	
	public static void main(String[] args) {
		
		//使用 Splitter#on 指定分隔符，使用 Splitter#split 完成拆分
		Iterable<String> res = Splitter.on(' ').split("1 2 3");
		System.out.println(res); //[1, 2, 3]
		
		//Splitter 还支持使用正则表达式来描述分隔符
		res = Splitter.onPattern("\\s+").split("1 \t 2 3");
		System.out.println(res); //[1, 2, 3]
		
		//Splitter 还支持根据长度来拆分字符串
		res = Splitter.fixedLength(3).split("1 2 3");
		System.out.println(res); //[1 2,  3]
		
		//Splitter.MapSplitter 用来拆分被拼接了的 Map 对象，返回 Map<String, String>
		Map<String, String> rs= Splitter.on("#").withKeyValueSeparator(":").split("1:2#3:4");
		System.out.println(rs); //{1=2, 3=4}
		
		//将固定格式的字符串拆分为一个List,很有用处
		List<String> ips =Splitter.on(";").splitToList("192.168.46.151:9876;192.168.46.153:9876;192.168.46.154:9876;192.168.46.155:9876");
		for (String ip : ips) {
			System.out.println("ip:"+ip);
		}
	}
}
