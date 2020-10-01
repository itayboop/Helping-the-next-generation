public class Stack<T>
{
	private Node<T> head;

	public Stack()
	{
		this.head = null;
	}

	public void push(T value)
	{
		this.head = new Node<T>(value, head);
	}

	public T pop()
	{
		T value = this.head.getValue();
		this.head = this.head.getNext();
		return value;
	}

	public T top()
	{
		return this.head.getValue();
	}

	public boolean isEmpty()
	{
		return this.head == null;
	}
}
