package com.javadev.guava.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

/**
 * 字符串的null和空字符串的判断
 *
 */
public class StringTest {
	
	@Test
	public void NullEmptyTest(){
		
		//判断是null或者是空字符串
		System.out.println(Strings.isNullOrEmpty(""));//true
		
		//若值是null，则将null转为空字符串，不是则返回原值
        System.out.println(Strings.nullToEmpty(null));//""
        System.out.println(Strings.nullToEmpty("ay"));//"ay"
        
        //若值是空字符串，则将空字符串转为null，否则返回原值
        System.out.println(Strings.emptyToNull(""));//null
        System.out.println(Strings.emptyToNull("ay"));//"ay"
        
        System.out.println(Strings.commonPrefix("aaay", "aal"));//"aa"否则返回""
        System.out.println(Strings.commonSuffix("aaay", "aal"));//"aa1"否则返回""

        String str1 = "ay.";
        
        //在str1后补'a'补够15个长度
        String strr1 = Strings.padEnd(str1, 15,'l');
        System.out.println(strr1);//ay.llllllllllll
        
        //在str2前补'a'补够10个长度
        String str2 = "welcome";
        String  strr2 = Strings.padStart(str2, 10,  'm');
        System.out.println(strr2);//mmmwelcome
	}
	
	/**
	 * 连接器[Joiner] 和 拆分器[Splitter] 拆分器修饰符
	 * 方法                          				描述
	 * omitEmptyStrings()       从结果中自动忽略空字符串
	 * trimResults()            移除结果字符串的前导空白和尾部空白
	 * trimResults(CharMatcher) 给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
	 * limit(int)               限制拆分出的字符串数量
	 * 
	 * 如果想要拆分器返回List，只要使用Lists.newArrayList(splitter.split(string))或类似方法。
	 * 
	 * splitter实例总是不可变的。用来定义splitter目标语义的配置方法总会返回一个新的splitter实例。
	 * 这使得splitter实例都是线程安全的，你可以将其定义为static final常量。
	 * 
	 * 更多了解https://www.jianshu.com/p/df81fe1409f0
	 * 
	 */
	
	@Test
	public void JoinerSplitterTest(){
		
		Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("ay", null, "al", "love"));//ay; al; love

        List<String> joinListStr = new ArrayList<String>();
        joinListStr.add("ay");
        joinListStr.add(null);
        joinListStr.add("al");
        joinListStr.add("love");
        Joiner joiner2 = Joiner.on("; ").skipNulls();
        System.out.println(joiner2.join(joinListStr));//ay; al; love
        
        //trimResults 和 omitEmptyStrings可以去空，去空白
        Iterable splitterArray =  Splitter.on(',').trimResults().omitEmptyStrings().split("ay,al,,   love");
        System.out.println(splitterArray.toString());//[ay, al, love]
        
        
        //传统的字符串分割
        String[] originArray = "ay,al,,   love".split(",");
        System.out.println(Arrays.toString(originArray));//[ay, al, ,    love]
        System.out.println(originArray.length);// 4(长度为)
        for(int i=0;i<originArray.length;i++){
            System.out.println(originArray[i]);
        }
        
        
	}
	
}
