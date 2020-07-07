package written_test;

import java.util.HashMap;
import java.util.Map;

public class MoneyToDigit {
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('Áã', 0);
		map.put('Ò¼', 1);
		map.put('·¡', 2);
		map.put('Èş', 3);
		map.put('ËÁ', 4);
		map.put('Îé', 5);
		map.put('Â½', 6);
		map.put('Æâ', 7);
		map.put('°Æ', 8);
		map.put('¾Á', 9);
		map.put('Ê°', 10);
		map.put('°Û', 100);
		map.put('Çª', 1000);
		map.put('Íò', 10000);
	 // map.put('ÒÚ', 100000000);
	}
	
	
	public static void main(String args[]) {
		String test1 = "Ò¼ÒÚ·¡ÇªÈş°ÛËÁÊ°Ò¼ÍòÁã·¡Ê°Ò¼Ôª";
		System.out.println(MoneyStrToNum(test1));
		// 123410021
		
		String test2 = "Èş°Û°ÆÊ°Ôª";
		System.out.println(MoneyStrToNum(test2));
		// 380
		
		String test3 = "·¡ÍòËÁÇªÁã°ÆÒÚ·¡ÇªËÁ°ÛÁãÒ¼ÍòÁã·¡Ê°Ò¼Ôª";
		System.out.println(MoneyStrToNum(test3));
		// 2400824010021
		
		String test4 = "Ò¼Ê°ÔªÕû";
		System.out.println(MoneyStrToNum(test4));
		// 10
	}
	
	// Ê°ÍòÔªÕû
	public static long MoneyStrToNum(String s) {
		if(s == null || s.length() == 0)
			return 0;
		if(s.indexOf('ÒÚ') > 0) {
			String[] strs = s.split("ÒÚ");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100000000;
			else
				return MoneyStrToNum(strs[0]) * 100000000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Íò') > 0){
			String[] strs = s.split("Íò");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10000;
			else
				return MoneyStrToNum(strs[0]) * 10000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Çª') > 0) {
			String[] strs = s.split("Çª");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 1000;
			else
				return MoneyStrToNum(strs[0]) * 1000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('°Û') > 0 ) {
			String[] strs = s.split("°Û");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100;
			else
				return MoneyStrToNum(strs[0]) * 100 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Ê°') > 0 ) {
			String[] strs = s.split("Ê°");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10;
			else
				return MoneyStrToNum(strs[0]) * 10 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Ôª') > 0 ) {
			int index = s.indexOf('Ôª');
			if(index == 0)
				return 0;
			int result = map.getOrDefault(s.charAt(index - 1), 0);
			return result;
		}
		else if(s.indexOf('Áã') >= 0 ) {
				return MoneyStrToNum(s.substring(1));
		}
		else {
			int result = map.getOrDefault(s.charAt(0), 0);
			return result;
		}
	}
}
