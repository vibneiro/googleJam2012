import java.io.*;
import java.util.*;

public class GQTask1 {

	public static void main(String[] args) throws Exception {


		//  ejp mysljylc kd kxveddknmc re jsicpdrysi
		//  rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
		//  de kr kd eoya kw aej tysr re ujdr lkgc jv

		// our language is impossible to understand
		// there are twenty six factorial possibilities
		// so it is okay if you want to just give up


///

		char[] strQ = "ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv y e q z".toCharArray();
		char[] strA = "our language is impossible to understand there are twenty six factorial possibilities so it is okay if you want to just give up a o z q".toCharArray();

		//Tongue --> English
		Map<Character, Character> map = new HashMap<Character, Character>();

		for(int i = 0; i < strQ.length; i++) {
			map.put(strQ[i], strA[i]);
		}

		// Open the file
		FileInputStream fstream = new FileInputStream("A-small-practice.in");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		 // Create file
        FileWriter fOutstream = new FileWriter("output.txt", true);
        BufferedWriter out = new BufferedWriter(fOutstream);

		String strLine;

		int count = Integer.valueOf(br.readLine());
		int caseNum = 0;

		while ((strLine = br.readLine()) != null) {
		  String str = translate(map, strLine);
		  str = "Case #" + (++caseNum) + ": " + str;
		  out.write(str);
		  out.newLine();
		}

		in.close();
		out.close();
	}

	public static String translate(Map<Character, Character> map, String s) {

		char[] chArray = s.toCharArray();

		for(int i = 0; i < chArray.length; i++) {
			if(map.containsKey(chArray[i])) {
				chArray[i] = map.get(chArray[i]);
			}
		}

		return new String(chArray);
	}

}