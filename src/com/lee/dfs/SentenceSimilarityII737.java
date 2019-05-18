package com.lee.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarityII737 {

	public static void main(String[] args) {
		SentenceSimilarityII737 obj = new SentenceSimilarityII737();
		String[] a = { "jrocadcojmybpxmuj", "livgsrfvgtovcurzq", "mnrdscqkycodx", "wgcjlntupylayse",
				"tglnshmqlmkqqfbpf", "uzlxmaoro", "narvuaqmmkqhd", "xozoyaqxtbustrymo", "jrocadcojmybpxmuj",
				"ainlwrwabqcwq", "qnjidlmwmxxjgntez", "bbchthovla", "vaufbmwdrupcxpg", "zwwgloilddclufwze", "tyxrlpmcy",
				"wtjtdrlm", "edurtetzseifez", "yzxogkunvohdmro", "livgsrfvgtovcurzq", "wmpvjvzljhnaxvp", "rqbswlkw",
				"umlzibkkpsyvpdol", "jkcmceinlyhi", "wlvmfxbleuot", "aeloeauxmc", "ooyllkxg", "wlvmfxbleuot",
				"cuewcvuy", "vaufbmwdrupcxpg", "bbchthovla", "arigdtezmyz", "yzxogkunvohdmro", "wrszraxxdum",
				"dhmiuqhqlsprxy", "xpmxtfyvjrnujyxjh", "bfxbncez", "cjjkmybleu", "mnrdscqkycodx", "mzfpofjn",
				"livgsrfvgtovcurzq", "shfzcyboj", "xozoyaqxtbustrymo", "xozoyaqxtbustrymo", "orlzzpytpzazxr",
				"filnwifbukdqijgr", "fllqjtnxwmfoou", "mkmawbogphdttd", "rthpxoxyyiy", "dkhfozltuckwog",
				"wmpvjvzljhnaxvp", "dhmiuqhqlsprxy", "yltljjairlkrmdq", "cuewcvuy", "subzoyxjkfiwmfb", "mzvbgcizeeth",
				"narvuaqmmkqhd", "tglnshmqlmkqqfbpf", "rpesfkhfjucj", "xrgfejybbkezgor", "vaufbmwdrupcxpg",
				"czlgbqzffodsoxng", "suvvqdiceuogcmv", "fllqjtnxwmfoou", "yltljjairlkrmdq", "bubwouozgs",
				"mnrdscqkycodx", "rqbswlkw", "ooyllkxg", "livgsrfvgtovcurzq", "rthpxoxyyiy", "pyzcbpjhntpefbq",
				"wtjtdrlm", "rztcppnmud", "inuzvkgolupxelcal", "pdxsxjop", "wmpvjvzljhnaxvp", "xydwvemqvtgvzl",
				"hqpnoczciajvkbdy", "rvihrzzkt", "jzquemjzpvfbka", "gkqrglav", "qyaxqaqxiwr", "mzvbgcizeeth",
				"umlzibkkpsyvpdol", "vaufbmwdrupcxpg", "ooyllkxg", "arigdtezmyz", "bubwouozgs", "wtjtdrlm",
				"xozoyaqxtbustrymo", "jrocadcojmybpxmuj", "rnlryins", "fllqjtnxwmfoou", "livgsrfvgtovcurzq",
				"czlgbqzffodsoxng", "hlcsiukaroscfg", "bfxbncez", "ainlwrwabqcwq", "vaufbmwdrupcxpg",
				"vaufbmwdrupcxpg" };
		String[] b = { "jrocadcojmybpxmuj", "livgsrfvgtovcurzq", "mnrdscqkycodx", "wgcjlntupylayse", "bbchthovla",
				"bfxbncez", "ztisufueqzequ", "yutahdply", "suvvqdiceuogcmv", "ainlwrwabqcwq", "fquzrlhdsnuwhhu",
				"tglnshmqlmkqqfbpf", "vaufbmwdrupcxpg", "zwwgloilddclufwze", "livgsrfvgtovcurzq", "wtjtdrlm",
				"edurtetzseifez", "ecqfdkebnamkfglk", "livgsrfvgtovcurzq", "wmpvjvzljhnaxvp", "ryubcgbzmxc",
				"pzlmeboecybxmetz", "hqpnoczciajvkbdy", "xpmxtfyvjrnujyxjh", "zwwgloilddclufwze", "khcyhttaaxp",
				"wlvmfxbleuot", "jzquemjzpvfbka", "vaufbmwdrupcxpg", "tglnshmqlmkqqfbpf", "mzvbgcizeeth", "cjjkmybleu",
				"orlzzpytpzazxr", "dhmiuqhqlsprxy", "mzfpofjn", "bfxbncez", "inuzvkgolupxelcal", "inhzsspqltvl",
				"wlvmfxbleuot", "livgsrfvgtovcurzq", "orlzzpytpzazxr", "yutahdply", "yutahdply", "orlzzpytpzazxr",
				"gdziaihbagl", "yltljjairlkrmdq", "mkmawbogphdttd", "aotjpvanljxe", "aeloeauxmc", "wmpvjvzljhnaxvp",
				"dhmiuqhqlsprxy", "yltljjairlkrmdq", "dnaaehrekqms", "khcyhttaaxp", "mzvbgcizeeth", "narvuaqmmkqhd",
				"rvihrzzkt", "bfufqsusp", "xrgfejybbkezgor", "vaufbmwdrupcxpg", "czlgbqzffodsoxng", "jrocadcojmybpxmuj",
				"yltljjairlkrmdq", "yltljjairlkrmdq", "bubwouozgs", "inhzsspqltvl", "bsybvehdny", "subzoyxjkfiwmfb",
				"livgsrfvgtovcurzq", "stkglpqdjzxmnlito", "evepphnzuw", "xrgfejybbkezgor", "rztcppnmud", "cjjkmybleu",
				"qyaxqaqxiwr", "ibwfxvxswjbecab", "xydwvemqvtgvzl", "hqpnoczciajvkbdy", "tglnshmqlmkqqfbpf",
				"dnaaehrekqms", "gkqrglav", "bfxbncez", "qvwvgzxqihvk", "umlzibkkpsyvpdol", "vaufbmwdrupcxpg",
				"khcyhttaaxp", "arigdtezmyz", "bubwouozgs", "fllqjtnxwmfoou", "xozoyaqxtbustrymo", "jrocadcojmybpxmuj",
				"rnlryins", "wtjtdrlm", "livgsrfvgtovcurzq", "gkqrglav", "orileazg", "uzlxmaoro", "ainlwrwabqcwq",
				"vaufbmwdrupcxpg", "vaufbmwdrupcxpg" };
		String[][] x = new String[][] { { "yutahdply", "yutahdply" }, { "xozoyaqxtbustrymo", "xozoyaqxtbustrymo" },
				{ "xozoyaqxtbustrymo", "xozoyaqxtbustrymo" }, { "yutahdply", "yutahdply" },
				{ "bsybvehdny", "bsybvehdny" }, { "pzlmeboecybxmetz", "pzlmeboecybxmetz" }, { "rqbswlkw", "rqbswlkw" },
				{ "ryubcgbzmxc", "ryubcgbzmxc" }, { "umlzibkkpsyvpdol", "umlzibkkpsyvpdol" },
				{ "bsybvehdny", "bsybvehdny" }, { "rqbswlkw", "bsybvehdny" }, { "pzlmeboecybxmetz", "bsybvehdny" },
				{ "ryubcgbzmxc", "ryubcgbzmxc" }, { "umlzibkkpsyvpdol", "ryubcgbzmxc" },
				{ "hqpnoczciajvkbdy", "hqpnoczciajvkbdy" }, { "vdjccijgqk", "vdjccijgqk" },
				{ "rztcppnmud", "rztcppnmud" }, { "jkcmceinlyhi", "hqpnoczciajvkbdy" }, { "vdjccijgqk", "vdjccijgqk" },
				{ "rztcppnmud", "vdjccijgqk" }, { "hqpnoczciajvkbdy", "hqpnoczciajvkbdy" },
				{ "jkcmceinlyhi", "hqpnoczciajvkbdy" }, { "suvvqdiceuogcmv", "llrzqdnoxbscnkqy" },
				{ "jrocadcojmybpxmuj", "jrocadcojmybpxmuj" }, { "suvvqdiceuogcmv", "suvvqdiceuogcmv" },
				{ "llrzqdnoxbscnkqy", "suvvqdiceuogcmv" }, { "jrocadcojmybpxmuj", "jrocadcojmybpxmuj" },
				{ "dnaaehrekqms", "dnaaehrekqms" }, { "jzquemjzpvfbka", "muaskefecskjghzn" },
				{ "muaskefecskjghzn", "iziepzqne" }, { "cuewcvuy", "dnaaehrekqms" }, { "iziepzqne", "iziepzqne" },
				{ "muaskefecskjghzn", "iziepzqne" }, { "jzquemjzpvfbka", "iziepzqne" },
				{ "dnaaehrekqms", "dnaaehrekqms" }, { "cuewcvuy", "dnaaehrekqms" },
				{ "rpesfkhfjucj", "xpmxtfyvjrnujyxjh" }, { "wlvmfxbleuot", "bfufqsusp" },
				{ "xpmxtfyvjrnujyxjh", "mzfpofjn" }, { "rpesfkhfjucj", "rpesfkhfjucj" }, { "mzfpofjn", "rpesfkhfjucj" },
				{ "xpmxtfyvjrnujyxjh", "rpesfkhfjucj" }, { "bfufqsusp", "bfufqsusp" }, { "wlvmfxbleuot", "bfufqsusp" },
				{ "lkopigreodypvude", "lkopigreodypvude" }, { "hjogoueazw", "hjogoueazw" },
				{ "qvwvgzxqihvk", "qvwvgzxqihvk" }, { "mzvbgcizeeth", "mzvbgcizeeth" },
				{ "mzvbgcizeeth", "arigdtezmyz" }, { "arigdtezmyz", "arigdtezmyz" }, { "qvwvgzxqihvk", "arigdtezmyz" },
				{ "mzvbgcizeeth", "arigdtezmyz" }, { "lkopigreodypvude", "lkopigreodypvude" },
				{ "hjogoueazw", "lkopigreodypvude" }, { "tglnshmqlmkqqfbpf", "tglnshmqlmkqqfbpf" },
				{ "bbchthovla", "bbchthovla" }, { "rvihrzzkt", "tglnshmqlmkqqfbpf" },
				{ "tglnshmqlmkqqfbpf", "tglnshmqlmkqqfbpf" }, { "rvihrzzkt", "tglnshmqlmkqqfbpf" },
				{ "bbchthovla", "bbchthovla" }, { "filnwifbukdqijgr", "pkirimjwvyxs" },
				{ "gdziaihbagl", "gdziaihbagl" }, { "hlcsiukaroscfg", "hlcsiukaroscfg" }, { "gdziaihbagl", "orileazg" },
				{ "orileazg", "orileazg" }, { "gdziaihbagl", "orileazg" }, { "hlcsiukaroscfg", "orileazg" },
				{ "pkirimjwvyxs", "pkirimjwvyxs" }, { "filnwifbukdqijgr", "pkirimjwvyxs" },
				{ "xrgfejybbkezgor", "wtjtdrlm" }, { "yltljjairlkrmdq", "fllqjtnxwmfoou" }, { "wtjtdrlm", "wtjtdrlm" },
				{ "xrgfejybbkezgor", "wtjtdrlm" }, { "fllqjtnxwmfoou", "fllqjtnxwmfoou" },
				{ "yltljjairlkrmdq", "fllqjtnxwmfoou" }, { "ecqfdkebnamkfglk", "gwkkpxuvgp" },
				{ "inuzvkgolupxelcal", "inuzvkgolupxelcal" }, { "hgxrhkanzvzmsjpzl", "gwkkpxuvgp" },
				{ "cjjkmybleu", "cjjkmybleu" }, { "yzxogkunvohdmro", "yzxogkunvohdmro" },
				{ "inuzvkgolupxelcal", "yzxogkunvohdmro" }, { "yzxogkunvohdmro", "yzxogkunvohdmro" },
				{ "cjjkmybleu", "yzxogkunvohdmro" }, { "ecqfdkebnamkfglk", "ecqfdkebnamkfglk" },
				{ "gwkkpxuvgp", "ecqfdkebnamkfglk" }, { "hgxrhkanzvzmsjpzl", "ecqfdkebnamkfglk" },
				{ "qnjidlmwmxxjgntez", "hhrllhedyy" }, { "vyrvelteblnqaabc", "qnjidlmwmxxjgntez" },
				{ "wzflhbbgtc", "wzflhbbgtc" }, { "rnlryins", "rnlryins" }, { "fquzrlhdsnuwhhu", "zzdvolqtndzfjvqqr" },
				{ "zzdvolqtndzfjvqqr", "bvxiilsnsarhsyl" }, { "qnjidlmwmxxjgntez", "vyrvelteblnqaabc" },
				{ "vyrvelteblnqaabc", "vyrvelteblnqaabc" }, { "hhrllhedyy", "vyrvelteblnqaabc" },
				{ "rnlryins", "vyrvelteblnqaabc" }, { "fquzrlhdsnuwhhu", "zzdvolqtndzfjvqqr" },
				{ "zzdvolqtndzfjvqqr", "zzdvolqtndzfjvqqr" }, { "bvxiilsnsarhsyl", "zzdvolqtndzfjvqqr" },
				{ "wzflhbbgtc", "zzdvolqtndzfjvqqr" }, { "wgcjlntupylayse", "wgcjlntupylayse" },
				{ "hgtyntdmrgjh", "hgtyntdmrgjh" }, { "cemnayjhlnj", "cemnayjhlnj" },
				{ "wgcjlntupylayse", "wgcjlntupylayse" }, { "hgtyntdmrgjh", "wgcjlntupylayse" },
				{ "cemnayjhlnj", "cemnayjhlnj" }, { "aeloeauxmc", "aeloeauxmc" }, { "zwwgloilddclufwze", "aeloeauxmc" },
				{ "dkhfozltuckwog", "dwojnswr" }, { "dkhfozltuckwog", "dkhfozltuckwog" },
				{ "dwojnswr", "dkhfozltuckwog" }, { "aeloeauxmc", "aeloeauxmc" }, { "zwwgloilddclufwze", "aeloeauxmc" },
				{ "aotjpvanljxe", "aotjpvanljxe" }, { "stkglpqdjzxmnlito", "aotjpvanljxe" },
				{ "zfmpxgrevxp", "aotjpvanljxe" }, { "evepphnzuw", "evepphnzuw" }, { "rthpxoxyyiy", "pyzcbpjhntpefbq" },
				{ "aotjpvanljxe", "stkglpqdjzxmnlito" }, { "stkglpqdjzxmnlito", "stkglpqdjzxmnlito" },
				{ "zfmpxgrevxp", "stkglpqdjzxmnlito" }, { "rthpxoxyyiy", "rthpxoxyyiy" },
				{ "evepphnzuw", "rthpxoxyyiy" }, { "pyzcbpjhntpefbq", "rthpxoxyyiy" },
				{ "czlgbqzffodsoxng", "czlgbqzffodsoxng" }, { "gkqrglav", "gkqrglav" }, { "gkqrglav", "gkqrglav" },
				{ "czlgbqzffodsoxng", "czlgbqzffodsoxng" }, { "tyxrlpmcy", "tyxrlpmcy" },
				{ "livgsrfvgtovcurzq", "livgsrfvgtovcurzq" }, { "tyxrlpmcy", "tyxrlpmcy" },
				{ "livgsrfvgtovcurzq", "livgsrfvgtovcurzq" }, { "cufxsgbpjgqvk", "cufxsgbpjgqvk" },
				{ "cufxsgbpjgqvk", "inhzsspqltvl" }, { "shsgrqol", "shsgrqol" }, { "mnrdscqkycodx", "mnrdscqkycodx" },
				{ "inhzsspqltvl", "inhzsspqltvl" }, { "cufxsgbpjgqvk", "inhzsspqltvl" }, { "shsgrqol", "shsgrqol" },
				{ "mnrdscqkycodx", "shsgrqol" }, { "rphnhtvnihyfkrgv", "rphnhtvnihyfkrgv" },
				{ "edurtetzseifez", "edurtetzseifez" }, { "yykdqtkkdacpbwtbq", "yykdqtkkdacpbwtbq" },
				{ "rphnhtvnihyfkrgv", "rphnhtvnihyfkrgv" }, { "edurtetzseifez", "rphnhtvnihyfkrgv" },
				{ "yykdqtkkdacpbwtbq", "yykdqtkkdacpbwtbq" }, { "dhmiuqhqlsprxy", "dhmiuqhqlsprxy" },
				{ "ztisufueqzequ", "ztisufueqzequ" }, { "narvuaqmmkqhd", "narvuaqmmkqhd" },
				{ "narvuaqmmkqhd", "narvuaqmmkqhd" }, { "ztisufueqzequ", "narvuaqmmkqhd" },
				{ "dhmiuqhqlsprxy", "dhmiuqhqlsprxy" }, { "wmpvjvzljhnaxvp", "wmpvjvzljhnaxvp" },
				{ "ibwfxvxswjbecab", "ibwfxvxswjbecab" }, { "xydwvemqvtgvzl", "wmpvjvzljhnaxvp" },
				{ "wmpvjvzljhnaxvp", "wmpvjvzljhnaxvp" }, { "xydwvemqvtgvzl", "wmpvjvzljhnaxvp" },
				{ "ibwfxvxswjbecab", "ibwfxvxswjbecab" }, { "mkmawbogphdttd", "mkmawbogphdttd" },
				{ "bubwouozgs", "mkmawbogphdttd" }, { "ainlwrwabqcwq", "ainlwrwabqcwq" },
				{ "mkmawbogphdttd", "mkmawbogphdttd" }, { "bubwouozgs", "mkmawbogphdttd" },
				{ "ainlwrwabqcwq", "ainlwrwabqcwq" }, { "uzlxmaoro", "bfxbncez" }, { "qyaxqaqxiwr", "qyaxqaqxiwr" },
				{ "pdxsxjop", "pdxsxjop" }, { "pdxsxjop", "pdxsxjop" }, { "qyaxqaqxiwr", "pdxsxjop" },
				{ "bfxbncez", "bfxbncez" }, { "uzlxmaoro", "bfxbncez" }, { "subzoyxjkfiwmfb", "subzoyxjkfiwmfb" },
				{ "ooyllkxg", "ooyllkxg" }, { "subzoyxjkfiwmfb", "khcyhttaaxp" },
				{ "subzoyxjkfiwmfb", "subzoyxjkfiwmfb" }, { "khcyhttaaxp", "subzoyxjkfiwmfb" },
				{ "ooyllkxg", "ooyllkxg" }, { "orlzzpytpzazxr", "orlzzpytpzazxr" }, { "oufzmjgplt", "oufzmjgplt" },
				{ "wrszraxxdum", "wrszraxxdum" }, { "shfzcyboj", "shfzcyboj" }, { "oufzmjgplt", "oufzmjgplt" },
				{ "orlzzpytpzazxr", "oufzmjgplt" }, { "wrszraxxdum", "wrszraxxdum" }, { "shfzcyboj", "wrszraxxdum" },
				{ "yutahdply", "xozoyaqxtbustrymo" }, { "umlzibkkpsyvpdol", "pzlmeboecybxmetz" },
				{ "hqpnoczciajvkbdy", "rztcppnmud" }, { "llrzqdnoxbscnkqy", "jrocadcojmybpxmuj" },
				{ "cuewcvuy", "jzquemjzpvfbka" }, { "rpesfkhfjucj", "wlvmfxbleuot" },
				{ "lkopigreodypvude", "mzvbgcizeeth" }, { "tglnshmqlmkqqfbpf", "bbchthovla" },
				{ "orileazg", "filnwifbukdqijgr" }, { "yltljjairlkrmdq", "xrgfejybbkezgor" },
				{ "inuzvkgolupxelcal", "hgxrhkanzvzmsjpzl" }, { "hhrllhedyy", "wzflhbbgtc" },
				{ "cemnayjhlnj", "hgtyntdmrgjh" }, { "dkhfozltuckwog", "zwwgloilddclufwze" },
				{ "zfmpxgrevxp", "pyzcbpjhntpefbq" }, { "gkqrglav", "czlgbqzffodsoxng" },
				{ "tyxrlpmcy", "livgsrfvgtovcurzq" }, { "shsgrqol", "cufxsgbpjgqvk" },
				{ "rphnhtvnihyfkrgv", "yykdqtkkdacpbwtbq" }, { "dhmiuqhqlsprxy", "ztisufueqzequ" },
				{ "ibwfxvxswjbecab", "xydwvemqvtgvzl" }, { "mkmawbogphdttd", "ainlwrwabqcwq" },
				{ "pdxsxjop", "uzlxmaoro" }, { "ooyllkxg", "khcyhttaaxp" }, { "shfzcyboj", "orlzzpytpzazxr" } };
		System.out.println(obj.areSentencesSimilarTwo(a, b, x));
//		
//		System.out.println(obj.find("great") + "..." + obj.find("fine"));
//		System.out.println(obj.find("acting") + "..." + obj.find("drama"));
//		System.out.println(obj.find("skills") + "..." + obj.find("talent"));
	}
	
	
	
	Map<String, String> map = new HashMap<>();
	Map<String, Integer> height = new HashMap<>();
	
	public void add(String s){
		if(!map.containsKey(s)){
			map.put(s, s);
			height.put(s, 1);
		}
	}
	
	public String find(String s){
//    	while (p != parent[p]) {
//            parent[p] = parent[parent[p]];    // path compression by halving
//            p = parent[p];
//        }
		
		if(!map.containsKey(s)){
			add(s);
		}
//		
//		while(!map.get(s).equals(s)){
//			s = map.get(s);
//		}
    	
		while(!map.get(s).equals(s)){
			String t = map.get(s);
			String x = map.get(t);
			map.put(s, x);
			s = x;
		}
		return s;
	}
	
	public void join(String a, String b){
//		if(map.get(a).equals(map.get(b))){
//			return;
//		}
		String ra = find(a);
		String rb = find(b);
		if (ra.equals(rb)) {
			return;
		}
		if(height.get(ra)>height.get(rb)){
			map.put(rb, ra);
			height.put(ra, height.get(rb));
		}else{
			map.put(ra, rb);
			if (height.get(ra) == height.get(rb)) {
				height.put(ra, height.get(rb) + 1);
			} else {
				height.put(rb, height.get(ra));
			}
		}
	}
	
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}
        
		for (String[] p : pairs) {
			add(p[0]);
			add(p[1]);
			join(p[0], p[1]);
		}
        
		for (int i = 0; i < words1.length; i++) {
//			if(words1[i].equals(words2[i])){
//				continue;
//			}
			if (!find(words1[i]).equals(find(words2[i]))) {
				System.out.println(words1[i] + "..." + words2[i] + "..." + find(words1[i]) + "..." + find(words2[i]));
				return false;
			}
		}
		return true;
    }

}
