import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;

public class idk {
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//array
	public static <T> boolean isIn(T[] array, T value)
	{
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(value)) {
				return true;
			}
		}

		return false;
	}

	public static boolean binarySearch(int[] arr, int value, int left, int right)
	{
		if (right >= left) {
			int middleIndex = left + (right - left) / 2;

			if (arr[middleIndex] == value)
				return true;

			if (arr[middleIndex] > value)
				return binarySearch(arr, left, middleIndex - 1, value);

			return binarySearch(arr, middleIndex + 1, right, value);
		}

		return false;
	}

	public static boolean binarySearch(int[] arr, int value)
	{
		return binarySearch(arr, value, 0, arr.length - 1);
	}

	public static <T> void reverseArray(T[] arr) {
		for(int i = 0; i < arr.length / 2; i++){
			T temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	public static int sumOfEvens(int[] arr) {
		int sum = 0;

		for(int i = 0; i < arr.length; i += 2) {
			sum += arr[i];
		}

		return sum;
	}

	//arr.length > 0
	public static double arrMultiplied(int[] arr) {
		double sum = 1;

		for(int i = 0; i < arr.length; i++) {
			sum *= arr[i];
		}

		return sum;
	}

	public static <T> int count(T[] array, T value) {
		int counter = 0;

		for(int i = 0; i < array.length; i++) {
			if(value.equals(array)) {
				counter++;
			}
		}

		return counter;
	}

	public static <T> void sortArray(int[] arr) {
		int temp = 0;

		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = i + 1; j < arr.length - i - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//list

	public static boolean isSorted(Node<Integer> list)
	{
		while (list != null && list.getNext() != null)
		{
			if(list.getValue().intValue() > list.getNext().getValue().intValue()) {
				return false;
			}

			list = list.getNext();
		}

		return true;
	}

	public static Node<Integer> sortLinkedList(Node<Integer> list) {
		Node<Integer> head = list;
		Node<Integer> headPtr = list;

		while (!isSorted(head.getNext())) {
			while (list != null && list.getNext() != null && list.getNext().getNext() != null) {
				if (list.getNext().getValue().intValue() > list.getNext().getNext().getValue().intValue()) {
					Node<Integer> temp = list.getNext().getNext();
					Node<Integer> temp2 = list.getNext();

					list.getNext().setNext(temp.getNext());
					list.setNext(temp);
					temp.setNext(temp2);
				}

				list = list.getNext();
			}

			list = head;
		}

		if (head != null && head.getNext() != null && head.getValue() > head.getNext().getValue()) {
			while (list != null && list.getNext() != null) {
				if (list.getNext().getValue() > head.getValue()) {
					headPtr = head.getNext();
					head.setNext(list.getNext());

					list.setNext(head);
					list = null;
				} else {
					list = list.getNext();
				}
			}
		}

		return headPtr;
	}

	public static <T> boolean isIn(Node<T> list, T value) {
		while(list != null) {
			if(value.equals(list.getValue())) {
				return true;
			}

			list = list.getNext();
		}

		return false;
	}

	public static boolean isInSorted(Node<Integer> list, int value) {
		while (list != null) {
			if(list.getValue().equals(value)) {
				return true;
			}

			if(value < list.getValue()) {
				return false;
			}

			list = list.getNext();
		}

		return false;
	}

	public static int[] parseArray(Node<Integer> list) {
		Node<Integer> head = list;
		int arraySize = 0;

		while (list != null) {
			arraySize++;
			list = list.getNext();
		}

		int[] arr = new int[arraySize];

		for(int i = 0; i < arr.length; i++){
			arr[i] = head.getValue();
			head = head.getNext();
		}

		return arr;
	}

	//gets sorted linked list and value to insert - returns head of linked-list with inserted value
	public static Node<Integer> insertToSortedLinkedList(Node<Integer> list, int value) {
		Node<Integer> head = list;

		if(list == null || list.getValue() > value) {
			return new Node<Integer>(value, head);
		}

		while (list.getNext() != null) {
			if(list.getNext().getValue() > value) {
				list.setNext(new Node<Integer>(value, list.getNext()));
				return head;
			}

			list = list.getNext();
		}

		list.setNext(new Node<Integer>(value));
		return head;
	}

	public static <T> Node<T> reverseLinkedList(Node<T> list) {
		Node<T> prev = null;
		Node<T> current = list;
		Node<T> next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(prev);

			prev = current;
			current = next;
		}

		return prev;
	}

	public static <T> Node<T> removeValue(Node<T> list, T value) {
		Node<T> newList = list; // save head

		while (list != null && list.getValue().equals(value)) {
			list = list.getNext();
		}

		newList = list;

		while (list != null) {
			while (list.getNext() != null && list.getNext().getValue().equals(value)) {
				list.setNext(list.getNext().getNext());
			}

			list = list.getNext();
		}

		return newList;
	}

	public static <T> int count(Node<T> list, T value) {
		if(list == null) {
			return 0;
		}

		if(list.getValue().equals(value)) {
			return 1 + count(list.getNext(), value);
		}

		return count(list.getNext(), value);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//bin tree

	public static <T> int getSize(BinNode<T> root) {
		if(root == null) {
			return 0;
		}

		return 1 + getSize(root.getLeft()) + getSize(root.getRight());
	}


	public static <T> int count(BinNode<T> bt, T value) {
		if(bt != null) {
			if(bt.getValue().equals(value)) {
				return 1 + count(bt.getLeft(), value) + count(bt.getRight(), value);
			}

			return count(bt.getLeft(), value) + count(bt.getRight(), value);
		}

		return 0;
	}

	//insert to BinSearchTree
	public static BinNode<Integer> insert(BinNode<Integer> root, int value)
	{
		if (root == null)
			return new BinNode<Integer>(null, value, null);

		if (value < root.getValue())
			root.setLeft(insert(root.getLeft(), value));
		else
			root.setRight(insert(root.getRight(), value));

		return root;
	}

	//uses insert method
	public static BinNode<Integer> integerToBst(int[] values) {
		BinNode<Integer> root = new BinNode<Integer>(null, values[0], null);

		for(int i = 1; i < values.length; i++) {
			insert(root, values[i]);
		}

		return root;
	}

	//Converts bst to array of integers
	public static void bstToIntegerArr(BinNode<Integer> root, int[] integers, int[] pIndex) {
		if(root != null) {
			if (root.getLeft() != null) {
				bstToIntegerArr(root.getLeft(), integers, pIndex);
			}

			integers[pIndex[0]] = root.getValue();
			pIndex[0]++;

			if (root.getRight() != null) {
				bstToIntegerArr(root.getRight(), integers, pIndex);
			}
		}
	}

	public static int[] bstToIntegerArr(BinNode<Integer> root) {
		int[] integers = new int[getSize(root)];
		int[] pIndex = new int[1];

		pIndex[0] = 0;
		bstToIntegerArr(root, integers, pIndex);

		return integers;
	}

	public static <T> void printPreorder(BinNode<T> bt) {
		if(bt != null) {
			System.out.println(bt.getValue());
			printPreorder(bt.getLeft());
			printPreorder(bt.getRight());
		}
	}

	public static <T> void printInorder(BinNode<T> bt) {
		if(bt != null) {
			printInorder(bt.getLeft());
			System.out.println(bt.getValue());
			printInorder(bt.getRight());
		}
	}

	public static <T> void printPostorder(BinNode<T> bt) {
		if(bt != null) {
			printPostorder(bt.getLeft());
			printPostorder(bt.getRight());
			System.out.println(bt.getValue());
		}
	}

	//BinarySearchTree to Sorted linked list
	public static <T> Node<T> getSortedLinkedList(BinNode<T> bst) {
		Node<T> list = null;
		Node<T> head = null;

		if (bst != null) {
			list = getSortedLinkedList(bst.getLeft());
			head = list;

			if(list == null) {
				return new Node<T>(bst.getValue(), getSortedLinkedList(bst.getRight()));
			}

			while (list != null && list.getNext() != null) {
				list = list.getNext();
			}

			list.setNext(new Node<T>(bst.getValue(), getSortedLinkedList(bst.getRight())));
			return head;
		} else {
			return null;
		}
	}

	public static boolean isLeaf(BinNode<Double> bt) {
		return bt != null && bt.getRight() == null && bt.getLeft() == null;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static <T> void moveTo(Queue<T> src, Queue<T> dst)
	{
		while (!src.isEmpty())
			dst.insert(src.remove());
	}

	public static <T> int sizeOfQueue(Queue<T> queue) {
		Queue<T> temp = new Queue<T>();
		int size = 0;

		while (!queue.isEmpty()) {
			temp.insert(queue.remove());
			size++;
		}

		while (!temp.isEmpty()) {
			queue.insert(temp.remove());
		}

		return size;
	}

	public static <T> void printQueue(Queue<T> queue) {
		Queue<T> temp = new Queue<T>();

		while(!queue.isEmpty()) {
			System.out.println(queue.head());
			temp.insert(queue.remove());
		}

		while (!temp.isEmpty()) {
			queue.insert(temp.remove());
		}
	}

	public static int[] queueToArr(Queue<Integer> queue) {
		Queue<Integer> temp = new Queue<Integer>();

		while(!queue.isEmpty()) {
			temp.insert(queue.remove());
		}

		int[] arr = new int[sizeOfQueue(temp)];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp.remove();
			 queue.insert(arr[i]);
		}

		return arr;
	}

	public static <T> boolean IsIn(Queue<T> queue, T value) {
		Queue<T> tmp = new Queue<T>();
		boolean found = false;

		while(!queue.isEmpty() && !found) {
			if(queue.head().equals(value)) {
				found = true;
			}

			tmp.insert(queue.remove());
		}

		while(!tmp.isEmpty()) {
			queue.insert(tmp.remove());
		}

		return found;
	}

	public static int removeSmallest(Queue<Integer> queue) {
		int smallest = queue.remove();
		Queue<Integer> temp = new Queue<Integer>();

		while(!queue.isEmpty()) {
			if(queue.head().intValue() < smallest) {
				temp.insert(smallest);
				smallest = queue.remove();
			}
		}

		while(!temp.isEmpty()) {
			queue.insert(temp.remove());
		}

		return smallest;
	}

	public static void sortQueue(Queue<Integer> queue) {
		Queue<Integer> temp = new Queue<Integer>();

		while (!queue.isEmpty()) {
			temp.insert(removeSmallest(queue));
		}

		while (!temp.isEmpty()) {
			queue.insert(temp.remove());
		}
	}

	public static <T> Queue<T> clone(Queue<T> queue) {
		Queue<T> tmp = new Queue<T>();
		Queue<T> tmp2 = new Queue<T>();

		while(!queue.isEmpty()) {
			tmp.insert(queue.head());
			tmp2.insert(queue.remove());
		}

		while(!tmp.isEmpty()) {
			queue.insert(tmp.remove());
		}

		return tmp2;
	}

	public static <T> void reverseQueue(Queue<T> queue)
	{
		T data = null;

		if(!queue.isEmpty())
		{
			data = queue.remove();
			reverseQueue(queue);
			queue.insert(data);
		}
	}

	//////////////////////////////////////////////////////////////
	//stack:

	public static <T> boolean isIn(Stack<T> stack, T value) {
		Stack<T> temp = new Stack<T>();
		boolean found = false;

		while(!stack.isEmpty() && !found) {
			if(stack.top().equals(value)) {
				found = true;
			} else {
				temp.push(stack.pop());
			}
		}

		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}

		return found;
	}

	public static <T> int count(Stack<T> stack, T value) {
		Stack<T> temp = new Stack<T>();
		int counter = 0;

		while(!stack.isEmpty()) {
			if(stack.top().equals(value)) {
				counter++;
			} else {
				temp.push(stack.pop());
			}
		}

		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}

		return counter;
	}

	public static <T> int stackLength(Stack<T> stack) {
		Stack<T> temp = new Stack<T>();
		int counter = 0;

		while(!stack.isEmpty()) {
			counter++;
			temp.push(stack.pop());
		}

		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}

		return counter;
	}

	public static int[] stackToArray(Stack<Integer> stack) {
		int[] arr = new int[stackLength(stack)];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();
		}

		for(int i = arr.length - 1; i >= 0; i--) {
			stack.push(arr[i]);
		}

		return arr;
	}

	public static <T> Queue<T> stackToQueue(Stack<T> stack) {
		Queue<T> queue = new Queue<T>();
		Stack<T> temp = new Stack<T>();

		while(!stack.isEmpty()) {
			queue.insert(stack.top());
			temp.push(stack.pop());
		}

		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}

		return queue;
	}

	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();

		while (!stack.isEmpty()) {
			int val = stack.pop();

			while ((!temp.isEmpty() && temp.top() > val)) {
				stack.push(temp.pop());
			}

			temp.push(val);
		}

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
	}

	public static <T> void reverseStack(Stack<T> stack) {
		Stack<T> tmp1 = new Stack<T>();
		Stack<T> tmp2 = new Stack<T>();

		while(!stack.isEmpty()) {
			tmp1.push(stack.pop());
		}

		while(!tmp1.isEmpty()) {
			tmp2.push(tmp1.pop());
		}

		while(!tmp2.isEmpty()) {
			stack.push(tmp2.pop());
		}
	}

	public static <T> Stack<T> cloneStack(Stack<T> stack) {
		Stack<T> temp = new Stack<T>();
		Stack<T> clone = new Stack<T>();

		while(!stack.isEmpty()) {
			temp.push(stack.pop());
			clone.push(temp.top());
		}

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}

		reverseStack(clone);
		return clone;
	}

	public static void main(String[] args) {

	}
}
