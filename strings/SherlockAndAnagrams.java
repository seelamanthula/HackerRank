package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);		
		int t = scan.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();		
		while (t > 0)
		{
			map.clear();
			String s;
			s = scan.next();
			int len = (int)s.length();
			for (int i = 0; i < len; i++)
			{
				for (int k = 1; i + k - 1 < len; k++)
				{
					String ta = s.substring(i, i+k);
					Arrays.sort(ta.toCharArray());
					if(map.containsKey(ta)) {
						int j = map.get(ta);
						map.put(ta, j + 1);
					} else {
						map.put(ta, 1);
					}
				}
			}
			long ans = 0;
			for (Map.Entry<String, Integer> entry : map.entrySet())
			{
				System.out.println(entry.getKey()+" "+(entry.getValue()));
				ans += (entry.getValue()) * ((entry.getValue() - 1)) / 2;
			//	ans += (entry.getValue() - 1) * 2;
			}
//			    System.out.println(entry.getKey() + "/" + entry.getValue());
	//		}
	//		for (map<string, int>::iterator it = m.begin(); it != m.end(); ++it)
		//		ans += (long long)(it->second) * (it->second - 1) / 2;
			//cout << ans << endl;
			
			System.out.println(ans);
			t--;
	}
	}
}
