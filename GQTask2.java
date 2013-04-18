import java.io.*;
import java.util.*;

public class GQTask2 {

	public static void main(String[] args) throws Exception {
		// Open the file
		FileInputStream fstream = new FileInputStream("B-large-practice.in");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		 // Create file
        FileWriter fOutstream = new FileWriter("output.txt", false);
        BufferedWriter out = new BufferedWriter(fOutstream);

		String strLine;

		int count = Integer.valueOf(br.readLine());
		int caseNum = 0;

		while ((strLine = br.readLine()) != null) {
		  String values[] = strLine.split(" ");
		  String str = "Case #" + (++caseNum) + ": " + calcMax(values);
		  out.write(str);
		  out.newLine();
		}

		in.close();
		out.close();
	}

	public static int calcMax(String[] values) {

		int surpTotal = Integer.valueOf(values[1]);
		int p = Integer.valueOf(values[2]);

		int[] sums = new int[values.length-3];

		for (int i = 3; i < values.length; i++) {
    		try {
        		sums[i-3] = Integer.parseInt(values[i]);
    		} catch (NumberFormatException nfe) {};
		}

		int cnt = 0;

		for (int i = 0; i < sums.length; i++) {

			int sum = sums[i];
			int max = 0;

			if(sum == 0) {
				max = 0;
				if(max >= p) {
					cnt++;
				}
			}
			 else
			if(sum == 1) {
				max = 1;
				if(max >= p) {
					cnt++;
				}
			}
			 else
			if (sum % 3 == 0) {
				// e.g. 21 => 
				// 21 / 3 = 7 7 7 --> return 7.
				// 21 / 3 = 6 7 8 --> return 8.

				if((sum / 3) >= p) {
					cnt++;
				} else
				if(surpTotal > 0 && (((sum / 3) + 1) >= p)) {
					cnt++;
					surpTotal--;
				}

			} else
			if (sum % 3 == 1) {
				// e.g. 22 => 
				// 22 / 3 = 7 7 8 --> return 8.
				// 22 / 3 = 6 8 8 --> return 8.

				if((sum / 3) >= p || ((sum / 3) + 1) >= p) {
					cnt++;
				} else
				if(surpTotal > 0 && (((sum / 3) + 1) >= p)) {
					cnt++;
					surpTotal--;
				}

			} else
			if (sum % 3 == 2) {
				// e.g. 23 => 
				// 23 / 3 = 7 8 8 --> return 8.
				// 23 / 3 = 7 7 9 --> return 9.

				if((sum / 3) >= p || ((sum / 3) + 1) >= p) {
					cnt++;
				} else
				if(surpTotal > 0 && (((sum / 3) + 2) >= p)) {
					cnt++;
					surpTotal--;
				}

			}
		}
		return cnt;
	}


}