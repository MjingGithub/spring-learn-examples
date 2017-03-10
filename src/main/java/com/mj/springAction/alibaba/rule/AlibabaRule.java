package com.mj.springAction.alibaba.rule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * 
 * @author jing.ming
 *
 */
public class AlibabaRule {

	public static void main(String[] args) {
		String anObject = null;
		//推荐使用JDK7的java.util.Objects#equals.会防止抛出空指针
		System.out.println(Objects.equals("test",anObject)); //false
		
		//使用索引访问用String的split方法得到的数组时，
		//需做最后一个分隔符后有无内容的检查，否则会有抛IndexOutOfBoundsException的风险。
		String str = "a,b,c,, ";
		String[] ary = str.split(",");
		//预期大于3，结果是3
		System.out.println(ary.length); //5
		
		//会抛异常ConcurrentModificationException
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3") ;
		a.add("4") ;
		a.add("5") ;
		a.add("1") ;
		/*for (String temp : a) {
		if ("4".equals(temp)) {
			a.remove(temp);
			}
		}*/
		//正例
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {	
			String temp = it.next();
			if ("4".equals(temp)) {
				it.remove();
			}
		}
		//利用Set元素唯一的特性，可以快速对一个集合进行去重操作
		Set<String> set = new HashSet<String>(a) ; 
		for(String stri:set){
			System.out.println("set:"+stri); //1,2,3,5
		}
		//使用entrySet遍历Map类集合KV，而不是keySet方式进行遍历
		//效率更高
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("one", 1) ;
		map.put("two", 2) ;
		map.put("three", 3) ;
		map.put("four", 4) ;
		Iterator <Entry<String, Object>> ite = map.entrySet().iterator() ;
		while(ite.hasNext()){
			Map.Entry<String, Object> entry= (Entry<String, Object>) ite.next() ;
			String key = entry.getKey() ;
			Object value = entry.getValue() ;
			System.out.println("key:"+key+",value:"+value);
		}
		
		//对于JDK8使用Map.foreach()
		map.forEach((k,v)->System.out.println("key:"+k+",value:"+v));
	}
}
