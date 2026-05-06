//Yonatan Rubin
//M21105076

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class HuffmanTree {
	private Node root;
	private HashMap<Character, String> codes = new HashMap<>();

	public HuffmanTree(Node root) {
		this.root = root;
		// fill out the map
		this.buildCodeMap(root, "");
	}

	// convert an string of english in to 1s and 0s
	public String englishToBinary(String text) {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			// this.codes is the map of characters and their codes,
			// created and filled when the tree is made
			sb.append(this.codes.get(c));
		}
		return sb.toString();
	}

	public String binaryToEnglish(String bits) {
		StringBuilder sb = new StringBuilder();
		Node current = this.root;

		for (int i = 0; i < bits.length(); i++) {
			current = (bits.charAt(i) == '0') ? current.left : current.right;

			if (current.left == null && current.right == null) {
				sb.append(current.character);
				current = root;
			}
		}

		return sb.toString();
	}

	private void buildCodeMap(Node node, String path) {
		// nothing to do at a null node
		if (node == null)
			return;

		// if we reached a leaf node
		if (node.left == null && node.right == null) {
			// add the character to the map with its respective path to get there
			this.codes.put(node.character, path);
			// skedaddle
			return;
		}

		// call it again for the left and right since we're not at a leaf node
		buildCodeMap(node.left, path + "0");
		buildCodeMap(node.right, path + "1");
		// no need to worry about going to a lead node,
		// handled in the base case section
	}

	// helper method for the assignment
	public void printMap() {
		String codesAsString = this.codes.toString();

		// remove the { } that comes as a result of HashMap.toString()
		codesAsString = codesAsString.substring(1, codesAsString.length() - 1);

		// split up each section by the commas
		String[] resSplit = codesAsString.split(",");

		// get it in a list so we can use the Collections sort method
		LinkedList<String> myList = new LinkedList<String>();
		for (String s : resSplit) {
			myList.add(s);
		}
		Collections.sort(myList);

		System.out.println(myList.toString());
	}
}
