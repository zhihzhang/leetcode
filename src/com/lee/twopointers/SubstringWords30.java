package com.lee.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWords30 {

	public static void main(String[] args) {
		SubstringWords30 obj = new SubstringWords30();
//		String s = "cxksvbkmmlkwviteqccjhsedjmoyimskmeehhovubiszsodiqhtyaxdlktmuiggukldubzqdjiebyjkpqfpqdsepmqluwrqictcguslddphdyrsowjhbcnsqddmbvclzvqhsksxnhethvnyuxfxzsqpxvdasflscbzumssbbwuluijqhqngkfxhdahvhunjwpgkjylmwixssgizyyhifepigyenttyriebtcogbwftqmcpmcwvhcmsklyxgryxccyvhodiljbbxftjhrerurleejekacheehclvfviqxmnefzowdhswsxcbdmdfvilekzcrukityxyfwmcctwanvdoyptfnbtrnsthoepieoiklwmppkpegssgknmxpfoezilnocxsrfcebqtsdkwjfqppedmvkczjmnzcpwxiebofujyxuwgzpxotdcqnerzteyvwwseauvgoeglyctzrspmvrcjyuiraimwehdfbalretcfxxeppwdnniwnegeeotdsaixdikuodytbxasmwxzlfxzldfstaxmcflfpybdbzzewzylxwmidkjrprjjtgxwnideifjkeiqdjpogncrsmcjetsnnamlpwotftdranhdxytfnvwgkzroukdjmpucnjxscajcqtfptaujwtrguiwouzyhqulddiygjjkbesqyskjofawzisqdrqkjkvnodlwowgrbyhzruihzkezsyrvshhbreqhkbfaymsbmzaftkpvutwotnklutnnydxihcihqcidckkxwzssuogodszzmopmumwbogkhjukleukcufuqvcezxgylunxobvrsbbzkvlxbhiddnzuieyhbeimbxlpzghthksugdrjkznoomkzsiitpqhqquhraqkkbcgjhxstzhjpwtoocxirprjfmqwmhgyikgtrellftwupqldsinlzfwfrmdfvmgfwmyqsmdxhzuwpfbjprwowsvphzuelckjrkbjwejdgdbxkdhzwfnsaljjkdnxixizikigqrmwwnugsdhokxikirtuxjtfibgslozeilagywptbwhmvqwdjszgbsnjutchkdluooaompjooraljypusobvjohdklmuqyogoquaigqwxsjiryclpfjywsdgdpctpqzdivgqbwoapykiypvpuepswsybkcwzsxfbvntylibcglmeciuzojrnesqounppmwshjlgxtjzzumgzwcymlpbrjsfehxtttldfwlcsudrqpzpnbnapfbgovoucnnygadnzqrrkvkckkuanjaeodnfzbzdqpdypgmoydhiysnlehnrsnwjsloropxeeacwjomhuusuohhsqulihjrcuhvixsmdvpbefqnbmhwaodueafnjpellmhulbiqwzscfiqiuxgwomqsmxfvmmhyaqunrcdocvqjfirbiyzwmpoypwtdkcdksxzkacaeasnhbgjlgkhsaxqrvmufoyrjxqvztxdvpscszndfymaamqrhelnvleejxbiqyonpgpihdnpbcpbohuvmfkhtrncoqmgqatfjkpqnffqjutxenuqvhzoyosogeuwhpdqzvipaofjkbiooeejlfzjvrzbytxhidxkyfzavglghtuyzbhlgjwcawdardhcigmgonijvtpdokdnlmatvzxyvdymggqqmcyargmnbbqpnveahhudgtbdwzrehiuwmsyeykrbojqbexelgaomtrrqtiucspyfhxjijajxjcbpbfahfrvyimodwjgpyewhdfrphbmsfnhguhpzakalyoowzunzbjhgqyvxbkrgzyouidtinttnkkkjezjhjsqbslzuvqcvrrrzwkjkgdzsnldtlmdwgtxzewvcpxzgqqhncqzkvackmgexujtbcqcipxmgwlopdvcgndqjdvtpbzoxijamacvrzjxyvnnykpgxuxixucpvddumpvapxxizhhxeukcebjdvimucqjztpvheqivqfdpokosgyxkbipwsbqurcvltquzjcwzkzqyletteqffaubswtonxjasbvrkznljodkbhfunvzsxwvpsrdhqokjpfcceqnqgrckaheoegibceqwvvdljnwyuzcbrsrxlthlcobgwkhyqzwlubyfrvflwimnafknauacickeoteeucrodrvuobikjwxlckyeeyjoctusnawhcpyfhtcvukifgfskpspvrylvtfogfmqhcqpjlrgidopjwiunalltjwpccflhrdrvtgegznocdgnzohposakdwbgagtkxwbtrjzxkoomuuzvkjkadkkhjlpjtittewoxfpwpemdygftsqgttqfcbtrlmbefhbteijbapnfpwkkqcslwjramkuxyveeffzlpkopbevsahdskveigvivhesfcwlhdnstxhkblhtnpyfbwljegrzpysxaqihwxzrxibyvjriasqbobmskfsbdmydejkagmrdutdqevagpsjduvxgarhefihkrukzgcdcxguddvlsnuxjrxrrozvuhfgazqzhuejtlgyqdllsfiewhvqwunsdsydtqfanjmiwujpxuapcktysrqoleirwiwsabupngajcjyzdarflmgddwtradizletninfvwfgyohathrbsdhxjfsaivkjiqcyypdvniemylmrufspkbmthhvpcfanwclwtouhwavunjnhogwyhluqsphwxhjvjutfkpoipjecusmiaiijvcapujmrrxocshhexxnmgrraldklntxlxzarimkzkyceglkfjxtrrkucpeqfznqxmqqufbwrbaxhnhoyfiqwumakqsrsfhrtzhqekoxmouvdckchsufmghyyarqhyhbartebhenxylaavcjnwobeycdytthudiuudavkeljdwkdtopindjrdnudjqlftvznzbklgxvlthqmvfuklgcovysgodlhakwzmjnugifcpvqmbnzovdcqbwzsbkbcvydjhqdpakrphkeixdwuibmjxlbzwddtdgcmxhbxtvpafvleajyikkrkyvluaondwrptastvnivufiafsanengqldbfdrugonxjnqckfkfcrocwiflosufdxikbaejqthzgzcqeoxggnlexqqmkktpjbzkbfwtydtgcvyilxrrlewkwowgapvjruwubsozxjhzgfjrcalpejaazyizodihzedaytbveiwkpgesgphnajpziyyybihdpkfnghlkrhvhnzbwqkjquareyrcczjfqvkebtpmnyjwmkxkajvsfvljucnwbybsunyxjplwnusbgrlicgaieltynjwrhzlbmlzvamtphntngeyjnytrmorbxnufmfiasjwswrkdfdsljqwwrppfgggdtdkhktidcgxyxhdcmyqwqosjekomqxpmaatkvbpxhnyhwdljdbfuszfwjukctzovbjhwnxwwkwdgzppdswzkweihasjtuzoxjywwvsuhoynppfujdvwzaghcbsyxsoubmqzhitoyteqklmwoisqkaxmbpkyhztklllvwhjuapmnazjrhbhrbgffvqdfryrckdzgkjcmapzdqiuzldspjxugpxlgydliikouvsgyjgbzqxacasrjslphkdqiidsqniklbsjkymmpjmtlfkuxxlghowsyzkopvaawtlitzukijdtqppnoavyrsqptcgixgkvbxgxwcjglpzbeqqvrmtigjzbnfknowkrwqostybgnaktraokohuwstyibkvpihgeyxztvabkcldvosfcbbbuxzcajzptgxygwzbrzddbohzcbgheiiyhhchsdylmvlsukuljxrnnymqbsxfchgjoksiqqtcohwirqvdpmsfmevpyuxbbdmrpfzfvujldgtvypaqdsvqwsfwoczrhmiztjgqfqcjyvewmeoqwjiudnqrssizesazdhpjxrsxpytdektctbwzroslgbmmvnlzubitucqjalnevigrmeqfuiqblcnhrbilcqgyuwiukxafhgwtmoagxqhkvxtmabaetgcnfkjpjjurrtmdhnkgfttasmpuqpyjxbzcnirxsoojjcpspbbvuuxpimjydikbjjdwrxvlnlvwokqflrchlaywokussetdnybhxzsmkpkybbgosiwgiwcxgwradmfsmhzkguwsjhtlizbchziswmrcjifowkgitisbcrunanakocmxbxpxjicushiotpxnxrobikoixpunrhlsgcsrlwmdfusylplkgclrmcbkrwzkfkelnyeyuqdznvyamllvnymacnmvllfqymdlkilfaognmgqysbvfbjhextbkhhdftgsfqdmrttgfbwgtzdbdnijmekwntzsoikuypiridaqfyyaybbdommasyxfsyxggjchylyiqayvzywxazcolordookgmhpvstcqgcbxdzseaqbaqfqdvhjjvtqkbhhtajmhnneqoyuopxqhehkzotjmnbyqiflkoztdmzwdaqtpqkyuriwhefvtgtjqywcowyskxonxghoytovmxrtdypwgihyjdazzytkyjzxqioqbcnnbgheeyakihitnltmlmyjwyjogxeizuxbaghfeirprcienbtyqrkmrvaasgktchwdoekuobjffsmsvftlyfxqazquiankjkpxozucddjixxdtcweddevffnznpoayypyopssuxecxbfqgdwjgaglgtmvibvibngseakyaqaxuipalllsorfwksrutpcuelminzgnriklqzlcnwwbpbxzvqvohylllztyaboskadccrgppcsfgrgbhcsrcfcngynhbbbncgqexyvpbnujeamneeegljtsjhbkkcamissiqnxrarcetpsyvyehhabqjcbtgdiovawlqtfqmhxgwrgupmdxoepxistovdeqfdcvyhmloltnczhrnkqcqgzayuquxumfzoayxolozeddfkxswnuovwowqeqqaevctxasmlgnpjrwvootdjhzhxvzdnpgrmimmifavnnkxgiuwwoahxbovwqalhgcworiwyitlxdkenfakvatsbkpzaqkhwpdnillgvfrtkexyjzigcdydnqfpgrxegcroqduliogssfqdfalhglmtbrjjjiormhgckcqsswnmcfrhgcqoochrusbfcrwpyerjjhdbgsqiyhrgmhucjdtfwwmanjpopjxasceyvugvdzbpgvtsapxwlkzbvopmxonqsrqplxkqwlgfibxjquheggfdxwqwmfoewfujegzcuhhclenbbxfjfmncifbumpbiuxtadudxekcprrquqyfwksatzbpltsvnpqovltspdwgwqysgwyehsfcsitfbmdrdthygatxfrdchcuoysshlzlfifmltpcyljxrlsprjuttwpjxkbexdsenzqysidqtopmajbrvwmoudxrpaymdqsspjtjtwbomtameefzctpwxoqmpobugtnxeiizelnqeofjskkugasdoirfyucgqpfuznudzjvfxaqrnbntdiyrqrzrmbxcsdyrsuwterzdurxjskcvscpltqchrbjlgkczgyumrtqlnnufzyduauhwklddmpotbsuhsoulkmxxbtcauhwwbdsnqysdniyoasvugrgqdfneashubftdjnsblneyvcoyumsddatjhjnidueeaxjllemyrtxmxnkszfxfhqopbbxeydladunoybopwlcubooavlfddvsfxrlxuwzxrmnrpchmpliqbwtxhyckuuptldshzrfsfukwwtiogqehoxgvyigucxppahzcygwfaibzbmnjetrttzoriwnmucewldaljxqjfrkjdxsitldmlrfvoshkwnghqhszgilnbvwhvrroeuaplhmbzulxhueabybjimwjkvqhmjvqdxireuufqgcaaiadgbmoqkzafshtbemhduahquohasjcajfimryccxejpndtrpcwlcdbwtkzltbnchxpavtevyqmltffkjbvlhwkajjocmdhvbywyrctpsidnpixzlsksrwvaflcuojprhlqbqlqivtwldtkpowjftefaphugtkxcxpdndwyyrujvpvmdsxklcpntzibusbwpqcdvybupxfmobautyegcwtxvbzpvanlspqoptkhspviswclwjtafnxcqytmaiztarjpmtygkuodstqockqjznnpmgdmqehqxqgjlgrwagbuzrkdbaocobscjxqzeyqbqynegechmddnuosyogaejuiuuzuyzmzrmovutxbfchvzvnzjuzqfwyaqxwqykrqygnsznwgpddoyrnjnpzsnysdxqvyamqysdttqpcgsfwswkbjzdemdyrcpoaraqstulomcquuwroudrgcumqzkjcbxctzvlsryhdazawxrksubayy";
//		String[] words = {"otftdranhdxytfnvwgkzroukdj","iflkoztdmzwdaqtpqkyuriwhef","lbsjkymmpjmtlfkuxxlghowsyz","cddjixxdtcweddevffnznpoayy","snjutchkdluooaompjooraljyp","fuszfwjukctzovbjhwnxwwkwdg","frmdfvmgfwmyqsmdxhzuwpfbjp","ukityxyfwmcctwanvdoyptfnbt","mhnneqoyuopxqhehkzotjmnbyq","vtgtjqywcowyskxonxghoytovm","wouzyhqulddiygjjkbesqyskjo","mfiasjwswrkdfdsljqwwrppfgg","zruihzkezsyrvshhbreqhkbfay","rsxpytdektctbwzroslgbmmvnl","jdwrxvlnlvwokqflrchlaywoku","xhnhoyfiqwumakqsrsfhrtzhqe","gtbdwzrehiuwmsyeykrbojqbex","tpcyljxrlsprjuttwpjxkbexds","tsjhbkkcamissiqnxrarcetpsy","keiqdjpogncrsmcjetsnnamlpw","rquqyfwksatzbpltsvnpqovlts","tdgcmxhbxtvpafvleajyikkrky","qvrmtigjzbnfknowkrwqostybg","vluaondwrptastvnivufiafsan","rnsthoepieoiklwmppkpegssgk","cyypdvniemylmrufspkbmthhvp","ihcihqcidckkxwzssuogodszzm","chrusbfcrwpyerjjhdbgsqiyhr","wmeoqwjiudnqrssizesazdhpjx","ommasyxfsyxggjchylyiqayvzy","kwntzsoikuypiridaqfyyaybbd","cwjomhuusuohhsqulihjrcuhvi","wxazcolordookgmhpvstcqgcbx","nusbgrlicgaieltynjwrhzlbml","xrtdypwgihyjdazzytkyjzxqio","xfvmmhyaqunrcdocvqjfirbiyz","fuklgcovysgodlhakwzmjnugif","hzhxvzdnpgrmimmifavnnkxgiu","xsmdvpbefqnbmhwaodueafnjpe","xfbvntylibcglmeciuzojrnesq","cnhrbilcqgyuwiukxafhgwtmoa","xkajvsfvljucnwbybsunyxjplw","zuieyhbeimbxlpzghthksugdrj","gbzqxacasrjslphkdqiidsqnik","jxtrrkucpeqfznqxmqqufbwrba","chziswmrcjifowkgitisbcruna","jyzdarflmgddwtradizletninf","pcktysrqoleirwiwsabupngajc","dkenfakvatsbkpzaqkhwpdnill","kbiooeejlfzjvrzbytxhidxkyf","wlopdvcgndqjdvtpbzoxijamac","xsoojjcpspbbvuuxpimjydikbj","faubswtonxjasbvrkznljodkbh","uqsphwxhjvjutfkpoipjecusmi","nawhcpyfhtcvukifgfskpspvry","xkdhzwfnsaljjkdnxixizikigq","zxgylunxobvrsbbzkvlxbhiddn","alltjwpccflhrdrvtgegznocdg","gffvqdfryrckdzgkjcmapzdqiu","hzedaytbveiwkpgesgphnajpzi","wmpoypwtdkcdksxzkacaeasnhb","hsdylmvlsukuljxrnnymqbsxfc","bbbncgqexyvpbnujeamneeeglj","bjhgqyvxbkrgzyouidtinttnkk","pyuxbbdmrpfzfvujldgtvypaqd","cfanwclwtouhwavunjnhogwyhl","plkgclrmcbkrwzkfkelnyeyuqd","ugvdzbpgvtsapxwlkzbvopmxon","msbmzaftkpvutwotnklutnnydx","pdwgwqysgwyehsfcsitfbmdrdt","elgaomtrrqtiucspyfhxjijajx","biqyonpgpihdnpbcpbohuvmfkh","llmhulbiqwzscfiqiuxgwomqsm","mpucnjxscajcqtfptaujwtrgui","gdzsnldtlmdwgtxzewvcpxzgqq","gdtdkhktidcgxyxhdcmyqwqosj","zubitucqjalnevigrmeqfuiqbl","aymdqsspjtjtwbomtameefzctp","kjezjhjsqbslzuvqcvrrrzwkjk","zavglghtuyzbhlgjwcawdardhc","fawzisqdrqkjkvnodlwowgrbyh","vrzjxyvnnykpgxuxixucpvddum","rdutdqevagpsjduvxgarhefihk","ydhiysnlehnrsnwjsloropxeea","hgjoksiqqtcohwirqvdpmsfmev","jyxuwgzpxotdcqnerzteyvwwse","sozxjhzgfjrcalpejaazyizodi","usobvjohdklmuqyogoquaigqwx","tmdhnkgfttasmpuqpyjxbzcnir","quareyrcczjfqvkebtpmnyjwmk","rmwwnugsdhokxikirtuxjtfibg","qsrqplxkqwlgfibxjquheggfdx","rukzgcdcxguddvlsnuxjrxrroz","oomuuzvkjkadkkhjlpjtittewo","wqwmfoewfujegzcuhhclenbbxf","yjogxeizuxbaghfeirprcienbt","qbwoapykiypvpuepswsybkcwzs","lvtfogfmqhcqpjlrgidopjwiun","rwowsvphzuelckjrkbjwejdgdb","jfqppedmvkczjmnzcpwxiebofu","hygatxfrdchcuoysshlzlfifml","gxqhkvxtmabaetgcnfkjpjjurr","zppdswzkweihasjtuzoxjywwvs","hgyikgtrellftwupqldsinlzfw","kckkuanjaeodnfzbzdqpdypgmo","aiijvcapujmrrxocshhexxnmgr","sjiryclpfjywsdgdpctpqzdivg","kuxyveeffzlpkopbevsahdskve","uqvhzoyosogeuwhpdqzvipaofj","gjhxstzhjpwtoocxirprjfmqwm","cwiflosufdxikbaejqthzgzcqe","qeqqaevctxasmlgnpjrwvootdj","ymggqqmcyargmnbbqpnveahhud","ekomqxpmaatkvbpxhnyhwdljdb","zvamtphntngeyjnytrmorbxnuf","uhoynppfujdvwzaghcbsyxsoub","efhbteijbapnfpwkkqcslwjram","koxmouvdckchsufmghyyarqhyh","tthudiuudavkeljdwkdtopindj","nwwbpbxzvqvohylllztyaboska","dccrgppcsfgrgbhcsrcfcngynh","qdpakrphkeixdwuibmjxlbzwdd","ftgsfqdmrttgfbwgtzdbdnijme","ounppmwshjlgxtjzzumgzwcyml","cpvqmbnzovdcqbwzsbkbcvydjh","pbrjsfehxtttldfwlcsudrqpzp","qbcnnbgheeyakihitnltmlmyjw","ztvabkcldvosfcbbbuxzcajzpt","xfpwpemdygftsqgttqfcbtrlmb","hncqzkvackmgexujtbcqcipxmg","ilfaognmgqysbvfbjhextbkhhd","hvqwunsdsydtqfanjmiwujpxua","yqrkmrvaasgktchwdoekuobjff","egeeotdsaixdikuodytbxasmwx","jfmncifbumpbiuxtadudxekcpr","slozeilagywptbwhmvqwdjszgb","kkugasdoirfyucgqpfuznudzjv","pvapxxizhhxeukcebjdvimucqj","bqurcvltquzjcwzkzqyletteqf","cbrsrxlthlcobgwkhyqzwlubyf","mqzhitoyteqklmwoisqkaxmbpk","nbnapfbgovoucnnygadnzqrrkv","ztpvheqivqfdpokosgyxkbipws","auvgoeglyctzrspmvrcjyuirai","yhmloltnczhrnkqcqgzayuquxu","funvzsxwvpsrdhqokjpfcceqnq","vuhfgazqzhuejtlgyqdllsfiew","gmhucjdtfwwmanjpopjxasceyv","vpscszndfymaamqrhelnvleejx","dzseaqbaqfqdvhjjvtqkbhhtaj","zylxwmidkjrprjjtgxwnideifj","nzohposakdwbgagtkxwbtrjzxk","igvivhesfcwlhdnstxhkblhtnp","trncoqmgqatfjkpqnffqjutxen","vwfgyohathrbsdhxjfsaivkjiq","rdnudjqlftvznzbklgxvlthqmv","kopvaawtlitzukijdtqppnoavy","raldklntxlxzarimkzkyceglkf","nakocmxbxpxjicushiotpxnxro","wxoqmpobugtnxeiizelnqeofjs","smsvftlyfxqazquiankjkpxozu","fwksrutpcuelminzgnriklqzlc","nefzowdhswsxcbdmdfvilekzcr","ibvibngseakyaqaxuipalllsor","znvyamllvnymacnmvllfqymdlk","gcvyilxrrlewkwowgapvjruwub","mwehdfbalretcfxxeppwdnniwn","wwoahxbovwqalhgcworiwyitlx","nmxpfoezilnocxsrfcebqtsdkw","engqldbfdrugonxjnqckfkfcro","grckaheoegibceqwvvdljnwyuz","jcbpbfahfrvyimodwjgpyewhdf","rvflwimnafknauacickeoteeuc","gxygwzbrzddbohzcbgheiiyhhc","wcxgwradmfsmhzkguwsjhtlizb","bikoixpunrhlsgcsrlwmdfusyl","ssetdnybhxzsmkpkybbgosiwgi","vyehhabqjcbtgdiovawlqtfqmh","opmumwbogkhjukleukcufuqvce","vjriasqbobmskfsbdmydejkagm","gjlgkhsaxqrvmufoyrjxqvztxd","yyybihdpkfnghlkrhvhnzbwqkj","kznoomkzsiitpqhqquhraqkkbc","yhztklllvwhjuapmnazjrhbhrb","jjiormhgckcqsswnmcfrhgcqoo","rphbmsfnhguhpzakalyoowzunz","igmgonijvtpdokdnlmatvzxyvd","rsqptcgixgkvbxgxwcjglpzbeq","zldspjxugpxlgydliikouvsgyj","enzqysidqtopmajbrvwmoudxrp","naktraokohuwstyibkvpihgeyx","zlfxzldfstaxmcflfpybdbzzew","mfzoayxolozeddfkxswnuovwow","rodrvuobikjwxlckyeeyjoctus","yfbwljegrzpysxaqihwxzrxiby","croqduliogssfqdfalhglmtbrj","gvfrtkexyjzigcdydnqfpgrxeg","xgwrgupmdxoepxistovdeqfdcv","oxggnlexqqmkktpjbzkbfwtydt","pyopssuxecxbfqgdwjgaglgtmv","svqwsfwoczrhmiztjgqfqcjyve","bartebhenxylaavcjnwobeycdy"};
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> resultList = obj.findSubstring(s, words);
		System.out.println(Arrays.toString(resultList.toArray()));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> resultList = new ArrayList<Integer>();
		List<String> wordList = Arrays.asList(words);
		
		
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (String word : words) {
			max = Math.max(max, word.length());
			set.add(word.length());
		}
		
//		Set<String> set = new HashSet<String>();
//		long start = System.currentTimeMillis();
//		for (String word : words) {
//			if (word.length() == 1) {
//				continue;
//			}
//			char[] x = word.toCharArray();
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < x.length - 1; i++) {
//				sb.append(x[i]);
//				set.add(sb.toString());
//			}
//		}
//		System.out.println("..." + (System.currentTimeMillis() - start));
		
//		Set<String> memSet = new HashSet<String>();

		
		long start = System.currentTimeMillis();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			List<String> tempList = new ArrayList<String>();
			tempList.addAll(wordList);

			StringBuilder sb = new StringBuilder();			
			int j = i;
			int k = i;
			while (j < array.length) {
				sb.append(array[j]);
				
				
				
//				String t = sb.toString();
//				if (!set.contains(t) && !tempList.contains(t)) {
//					j = array.length + 1;
//					continue;
//				}
				if (!set.contains(j - k)) {
					if (j - k > max) {
						j = array.length + 1;
					}
					j++;
					continue;
				}
				String t = sb.toString();
				
				if (tempList.contains(t)) {
					tempList.remove(t);
					if (tempList.size() == 0) {
						resultList.add(i);
						k = j;
						j = array.length + 1;
						continue;
					} else {
						sb = new StringBuilder();
					}
				}
				j++;
			}
		}
		System.out.println("..." + (System.currentTimeMillis() - start));

		return resultList;
	}

}
