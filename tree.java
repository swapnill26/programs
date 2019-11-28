package array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// Data structure to store a Binary Tree node
class Node
{
    String key;
	Node left = null;
	Node right = null;
    
	Node(String key) {
		this.key = key;
	}
}

public class Main
{
	// Function to print reverse level order traversal of given binary tree
	public static void reverseLevelOrderTraversal(Node root)
	{
		if (root == null) {
			return;
		}

		// create an empty queue and enqueue root node
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// create an stack to reverse level order nodes
		Deque<String> stack = new ArrayDeque<>();

		// pointer to store current node
		Node curr;

		// run till queue is not empty
		while (!queue.isEmpty())
		{
			// process each node in queue and enqueue their children
			curr = queue.poll();

			// push current node to stack
			stack.push(curr.key);

			// important - process right node before left node
			if (curr.left != null) {
				queue.add(curr.left);
			}

			if (curr.right != null) {
				queue.add(curr.right);
			}
		}

		// pop all nodes from the stack and print them
		while (!stack.isEmpty()) {
			System.out.print(stack.poll() + " ");
		}
	}

	// main function
	public static void main(String[] args)
	{
		Node root = new Node("A");
		root.left = new Node("B");
		root.right = new Node("E");
		root.left.left = new Node("C");
		root.left.right = new Node("D");
		root.right.left = new Node("F");
		root.right.right = new Node("G");
        root.right.right.right = new Node("H");
        
        
		reverseLevelOrderTraversal(root);
	}
}
