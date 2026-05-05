// Yonatan Rubin
// M21105076

import java.util.PriorityQueue;

/**
 * 
 */
public class Huffman {
	private class HuffmanTree {
		Node root;
		int weight;

		public char navigateToChar(String sequence) {
			// filler to prevent errors
			char res = ' ';
			return res;
		}

		public HuffmanTree() {
			this.root = null;
			this.weight = 0;
		}
	}

	private class Node implements Comparable<Node> {
		// whatever character is stored in this node
		private char character;

		// however many times it has appeared
		private int count;

		// left and right child of the node
		Node left;
		Node right;

		public Node() {
			this.count = 0;
			this.left = this.right = null;
		}

		@Override
		public int compareTo(Huffman.Node o) {
			// if they have the same count, go by alphabetical order
			if (this.count == o.count) {
				// if the left char is bigger than the right, give the right higher priority
				return this.character - o.character;
			}

			// smaller count means higher priority
			// when the result is positive,
			// that means the calling object has a larder count,
			// meaning the parameter object has less priority
			return this.count - o.count;
		}
	}

	private static final String inputString1 = "create a huffman tree";
	private Node[] freqArray = new Node[27]; // a-z + space
	private PriorityQueue<Node> prioQueue = new PriorityQueue<Node>();

	public void countFreq(String input) {
		// make sure the queue is empty
		this.prioQueue.clear();

		// initialize all letter Nodes
		for (int i = 1; i < this.freqArray.length; ++i) {
			this.freqArray[i] = new Node();
			this.freqArray[i].character = (char) ('a' + i - 1); // need to do a -1 because i'm starting at 1
			this.freqArray[i].count = 0;
		}

		// handle the space Node separately
		this.freqArray[0] = new Node();
		this.freqArray[0].character = ' ';
		this.freqArray[0].count = 0;

		char c;
		int slot;
		// for each character of the string
		for (int i = 0; i < input.length(); ++i) {
			// get the letter/character that we are currently at
			c = input.charAt(i);
			// spaces go at slot 0,
			if (c == ' ') {
				++this.freqArray[0].count;
			} else {
				// a-z go to slots 1-26
				slot = (int) c - 'a' + 1;
				++this.freqArray[slot].count;
			}
		}
	}

	public void fillQueue() {
		for (Node n : this.freqArray) {
			if (n.count > 0) {
				this.prioQueue.add(n);
			}
		}
	}

	public HuffmanTree buildTree() {
		HuffmanTree res = new HuffmanTree();

		Node first = new Node();
		Node second = new Node();

		while (this.prioQueue.size() > 1) {
			// this needs to be inside the loop,
			// because we are making a new node each time to continue building the tree
			Node parent = new Node();

			first = this.prioQueue.poll();
			second = this.prioQueue.poll();
			// make the weight the total of the 2 nodes' weight below it
			parent.count = first.count + second.count;
			// filler character
			parent.character = '*';

			// add the left and right nodes to actually build the tree
			parent.left = first;
			parent.right = second;
			this.prioQueue.add(parent);
		}

		res.root = this.prioQueue.poll();
		return res;
	}

}
