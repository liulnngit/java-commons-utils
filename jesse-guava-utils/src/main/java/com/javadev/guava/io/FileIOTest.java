package com.javadev.guava.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

/**
 * 通过Guava中的File类，将json转为map
 * dashboard2018-01-30.json数据格式如下：
 * 	{"broker-b:0":["1517305860013,2.59086","1517306160007,2.63537","1517306220007,3.96850"]}
 * 
 */
public class FileIOTest {
	
	 public static void main(String[] args) {
	        File file = new File("E:/tmp/rocketmq-console/data/dashboard2018-01-30.json");
	        Map<String, List<String>> maps = jsonDataFile2map(file);
	        for (String s : maps.keySet()) {
	            System.out.println(s);
	            System.out.println();
	            List<String> ss = maps.get(s);
	            for (String sss : ss) {
	                System.err.println(sss);
	            }
	        }
	        System.out.println("=============");
	        
	    }
	    
	    
	    public static Map<String, List<String>> jsonDataFile2map(File file) {
	        List<String> strings;
	        try {
	            strings = Files.readLines(file, Charsets.UTF_8);
	        }
	        catch (IOException e) {
	            throw Throwables.propagate(e);
	        }
	        StringBuffer sb = new StringBuffer();
	        for (String string : strings) {
	            sb.append(string);
	        }
	        JSONObject json = (JSONObject) JSONObject.parse(sb.toString());
	        Set<Map.Entry<String, Object>> entries = json.entrySet();
	        Map<String, List<String>> map = Maps.newHashMap();
	        for (Map.Entry<String, Object> entry : entries) {
	            JSONArray tpsArray = (JSONArray) entry.getValue();
	            if (tpsArray == null) {
	                continue;
	            }
	            Object[] tpsStrArray = tpsArray.toArray();
	            List<String> tpsList = Lists.newArrayList();
	            for (Object tpsObj : tpsStrArray) {
	                tpsList.add("" + tpsObj);
	            }
	            map.put(entry.getKey(), tpsList);
	        }
	        return map;
	    }
}
