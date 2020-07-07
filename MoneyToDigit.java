package written_test;

import java.util.HashMap;
import java.util.Map;

public class MoneyToDigit {
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();
	static {
		map.put('��', 0);
		map.put('Ҽ', 1);
		map.put('��', 2);
		map.put('��', 3);
		map.put('��', 4);
		map.put('��', 5);
		map.put('½', 6);
		map.put('��', 7);
		map.put('��', 8);
		map.put('��', 9);
		map.put('ʰ', 10);
		map.put('��', 100);
		map.put('Ǫ', 1000);
		map.put('��', 10000);
	 // map.put('��', 100000000);
	}
	
	
	public static void main(String args[]) {
		String test1 = "Ҽ�ڷ�Ǫ������ʰҼ���㷡ʰҼԪ";
		System.out.println(MoneyStrToNum(test1));
		// 123410021
		
		String test2 = "���۰�ʰԪ";
		System.out.println(MoneyStrToNum(test2));
		// 380
		
		String test3 = "������Ǫ����ڷ�Ǫ������Ҽ���㷡ʰҼԪ";
		System.out.println(MoneyStrToNum(test3));
		// 2400824010021
		
		String test4 = "ҼʰԪ��";
		System.out.println(MoneyStrToNum(test4));
		// 10
	}
	
	// ʰ��Ԫ��
	public static long MoneyStrToNum(String s) {
		if(s == null || s.length() == 0)
			return 0;
		if(s.indexOf('��') > 0) {
			String[] strs = s.split("��");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100000000;
			else
				return MoneyStrToNum(strs[0]) * 100000000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('��') > 0){
			String[] strs = s.split("��");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10000;
			else
				return MoneyStrToNum(strs[0]) * 10000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Ǫ') > 0) {
			String[] strs = s.split("Ǫ");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 1000;
			else
				return MoneyStrToNum(strs[0]) * 1000 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('��') > 0 ) {
			String[] strs = s.split("��");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 100;
			else
				return MoneyStrToNum(strs[0]) * 100 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('ʰ') > 0 ) {
			String[] strs = s.split("ʰ");
			if(strs.length < 2)
				return MoneyStrToNum(strs[0]) * 10;
			else
				return MoneyStrToNum(strs[0]) * 10 +  MoneyStrToNum(strs[1]);
		}
		else if(s.indexOf('Ԫ') > 0 ) {
			int index = s.indexOf('Ԫ');
			if(index == 0)
				return 0;
			int result = map.getOrDefault(s.charAt(index - 1), 0);
			return result;
		}
		else if(s.indexOf('��') >= 0 ) {
				return MoneyStrToNum(s.substring(1));
		}
		else {
			int result = map.getOrDefault(s.charAt(0), 0);
			return result;
		}
	}
}
