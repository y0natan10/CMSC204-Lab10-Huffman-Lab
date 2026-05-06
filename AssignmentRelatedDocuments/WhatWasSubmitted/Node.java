//Yonatan Rubin
//M211050576

public class Node implements Comparable<Node> {
	char character;
	int weight;
	Node left;
	Node right;

	public Node() {
		this.weight = 0;
		this.left = this.right = null;
	}

	@Override
	public int compareTo(Node o) {
		if (this.weight == o.weight) {
			return this.character - o.character;
		}
		return this.weight - o.weight; // smaller count = higher priority
	}
}
