// Yonatan Rubin
// M21105076

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
public class Huffman {
	private class Node {
		// whatever character is stored in this node
		private char character;

		// however many times it has appeared
		private int count;
	}

	private static final String inputString1 = "create a huffman tree";
	private int[] freqArray = new int[27]; // a-z + space

	private Queue<Node> prioQueue = new LinkedList<Node>();

	public void countFreq(String input) {
		// initialize all counts to 0
		for (int i = 0; i < this.freqArray.length; ++i) {
			this.freqArray[i] = 0;
		}

		// 'a' has an ascii value of 97
		// so i could do an subtraction of 97 from each character as i put it in
		// or i could just do mod by the number of options (freqArray.length())

		char c;
		int slot;
		// for each character of the string
		for (int i = 0; i < input.length(); ++i) {
			// get the letter/character that we are currently at
			c = input.charAt(i);
			if (c == ' ') {

			}
			// int slot = (int) c % input.length();
			slot = (int) c - 97;
			++this.freqArray[slot];
		}
	}
}
