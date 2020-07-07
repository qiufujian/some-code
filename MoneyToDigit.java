package written_test;

import java.util.HashMap;
import java.util.Map;

public class MoneyToDigit {
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('零', 0);
		map.put('壹', 1);
		map.put('贰', 2);
		map.put('叁', 3);
		map.put('肆', 4);
		map.put('伍', 5);
		map.put('陆', 6);
		map.put('柒', 7);
		map.put('捌', 8);
		map.put('玖', 9);
		map.put('拾', 10);
		map.put('佰', 100);
		map.put('仟', 1000);
		map.put('万', 10000);
	    map.put('亿', 100000000);
	}
	
	
	public static void main(String args[]) {
		String test1 = "壹亿贰仟叁佰肆拾壹万零贰拾壹元";
		System.out.println(MoneyStrToNum(test1));
		// 123410021
		
		String test2 = "叁佰捌拾元";
		System.out.println(MoneyStrToNum(test2));
		// 380
		
		String test3 = "贰万肆仟零捌亿贰仟肆佰零壹万零贰拾壹元";
		System.out.println(MoneyStrToNum(test3));
		// 2400824010021
		
		String test4 = "壹拾元整";
		System.out.println(MoneyStrToNum(test4));
		// 10
	}
	
	// 拾万元整
	public static long MoneyStrToNum(String s) {
		if(s == null || s.length() == 0)
			return 0;
		if(s.indexOf('亿') > 0) {
			String[] strs = s.split("亿");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100000000;
			else
				return MoneyStrToNum(strs[0]) * 100000000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('万') > 0){
			String[] strs = s.split("万");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10000;
			else
				return MoneyStrToNum(strs[0]) * 10000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('仟') > 0) {
			String[] strs = s.split("仟");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 1000;
			else
				return MoneyStrToNum(strs[0]) * 1000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('佰') > 0 ) {
			String[] strs = s.split("佰");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100;
			else
				return MoneyStrToNum(strs[0]) * 100 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('拾') > 0 ) {
			String[] strs = s.split("拾");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10;
			else
				return MoneyStrToNum(strs[0]) * 10 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('元') > 0 ) {
			int index = s.indexOf('元');
			if(index == 0)
				return 0;
			int result = map.getOrDefault(s.charAt(index - 1), 0);
			return result;
		}
		else if(s.indexOf('零') >= 0 ) {
				return MoneyStrToNum(s.substring(1));
		}
		else {
			int result = map.getOrDefault(s.charAt(0), 0);
			return result;
		}
	}
}
