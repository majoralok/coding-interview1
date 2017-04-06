/*A sequence of n > 0 integers is called a jolly jumper if the absolute values of the difference between
successive elements take on all the values 1 through n − 1. For instance,
1 4 2 3
is a jolly jumper, because the absolutes differences are 3, 2, and 1 respectively. The definition implies
that any sequence of a single integer is a jolly jumper. You are to write a program to determine whether
or not each of a number of sequences is a jolly jumper.
Input
Each line of input contains an integer n ≤ 3000 followed by n integers representing the sequence.
Output
For each line of input, generate a line of output saying ‘Jolly’ or ‘Not jolly’.
Sample Input
4 1 4 2 3
5 1 4 2 -1 6
Sample Output
Jolly
Not jolly*/
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=979


import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class JollyJumper {

	static void solve() throws Exception {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			Set<Integer> numbersAlreadyAdded = new HashSet<Integer>();
			int numberOfElements = input.nextInt();
			int[] numbers = new int[numberOfElements];
			for (int i = 0; i < numberOfElements; i++) {
				numbers[i] = input.nextInt();
			}
			for (int i = 0; i < numberOfElements - 1; i++) {
				int difference = Math.abs(numbers[i] - numbers[i + 1]);
				if (difference > 0 && difference < numberOfElements) {
					numbersAlreadyAdded.add(difference);
				}
			}
			if (numbersAlreadyAdded.size() == (numberOfElements - 1)) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}
		input.close();
	}

	static int findMaximalElement(int[] numbers) {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
	}

	static int nextInt() throws IOException {
		return parseInt(next());
	}

	static String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(0);
		}
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
}