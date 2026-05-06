// Yonatan Rubin
// M21105076

import java.util.PriorityQueue;

public class Huffman {
	private Node[] freqArray = new Node[27]; // 0 = space, 1–26 = a–z
	private PriorityQueue<Node> prioQueue = new PriorityQueue<>();

	public void countFreq(String input) {
		this.prioQueue.clear();

		// start at 1 because 0 is reserved for space
		for (int i = 1; i < this.freqArray.length; ++i) {
			this.freqArray[i] = new Node();
			// a+1 = b,a+2 = c
			// need to do -1 because we're starting i=1
			this.freqArray[i].character = (char) ('a' + i - 1);
			this.freqArray[i].weight = 0;
		}

		// initialize the slot for ' '
		this.freqArray[0] = new Node();
		this.freqArray[0].character = ' ';
		this.freqArray[0].weight = 0;

		for (char c : input.toCharArray()) {
			// special case for spaces
			if (c == ' ') {
				++this.freqArray[0].weight;
			} else {
				// not a space, normalize it to lowercase a,
				// then add 1 because first slot is space
				int slot = c - 'a' + 1;
				++this.freqArray[slot].weight;
			}
		}
	}

	public void fillQueue() {
		// for each node in the frequency array
		for (Node n : this.freqArray) {
			// so long as it appears once
			if (n.weight > 0) {
				// add it to the priority queue
				this.prioQueue.add(n);
				// this is why i needed to implement comparable
			}
		}
	}

	public HuffmanTree buildTree() {
		// the end result will have only one element left in the queue
		// this will be the root of the Huffman tree
		while (this.prioQueue.size() > 1) {
			// pop off the first 2 elements,
			// lower priority will be further to the left
			Node left = this.prioQueue.poll();
			Node right = this.prioQueue.poll();

			// we are uniting the left and right under a new node
			Node parent = new Node();
			// filler character
			parent.character = '*';

			// internal node's weight should be the sum of the left and right child's weight
			parent.weight = left.weight + right.weight;

			// assign the children
			parent.left = left;
			parent.right = right;

			// add the united node back in to the queue with the new/larger weight
			this.prioQueue.add(parent);
		}

		// take the first/last element in the queue
		// and send it to the Huffman tree constructor
		return new HuffmanTree(this.prioQueue.poll());
	}
}
