// Yonatan Rubin
// M21105076

public class Main {
	public static void main(String[] args) {
		/*
		 * 1) Create a Huffman Tree and generate the codes for each character of the
		 * following input:
		 * 
		 * create a huffman tree
		 */
		System.out.println("Part 1");
		String input = "create a huffman tree";

		Huffman MrHuffman = new Huffman();
		MrHuffman.countFreq(input);
		MrHuffman.fillQueue();
		HuffmanTree tree = MrHuffman.buildTree();

		String bits = tree.englishToBinary(input);
		String decoded = tree.binaryToEnglish(bits);
		System.out.println("original string\n" + input);
		System.out.println("encoded as 1s and 0s\n" + bits.toString());
		System.out.println("trying to decode from bits back to input\n" + decoded);

		System.out.println("chars and their codes\n");
		tree.printMap();

		System.out.println("\n\nPart 2");
		// 1110011101101111111010001100010001100100
		Huffman MrHuffman2 = new Huffman();
		String input2 = "nrtueeff ahm";
		MrHuffman2.countFreq(input2);
		MrHuffman2.fillQueue();
		HuffmanTree tree2 = MrHuffman2.buildTree();
		String bits2 = tree2.englishToBinary(input2);
		String decoded2 = tree2.binaryToEnglish(bits2);

		System.out.println(bits2);
		System.out.println(decoded2);

		System.out.println("this did not work at all but it was worth a shot");
	}
}
