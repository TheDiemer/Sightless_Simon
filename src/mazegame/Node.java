package mazegame;



public class Node {

	Node top;
	Node bottom;
	Node left;
	Node right;
	Event e;
	String correctDirection;
	boolean endingNode = false;

	public Node(Event ev) {
		e = ev;
		correctDirection = e.getCorrectDirection();
	}

	public Node run(int a) {
		String decision = e.go(a);
		if (decision.equals("top") && !(top == null))
			return top;
		if (decision.equals("bottom") && !(bottom == null))
			return bottom;
		if (decision.equals("left") && !(left == null))
			return left;
		if (decision.equals("right") && !(right == null))
			return right;
		return null;
	}

	public void setTop(Node z) {
		top = z;
	}

	public Node getTop() {
		return top;
	}

	public void setBottom(Node z) {
		bottom = z;
	}

	public Node getBottom() {
		return bottom;
	}

	public void setLeft(Node z) {
		left = z;
	}

	public Node getLeft() {
		return left;
	}

	public void setRight(Node z) {
		right = z;
	}

	public Node getRight() {
		return right;
	}

	public String getCorrectDirection() {
		return correctDirection;
	}

	public void setEndingNode(boolean x) {
		endingNode = x;
	}

	public boolean getEndingNode() {
		return endingNode;
	}

}