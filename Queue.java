public class Queue<T>
{
	private Node<T> first;
	private Node<T> last;

	public Queue()
	{
		this.first = null;
		this.last = null;
	}

	public void insert(T value)
	{
		Node<T> temp = new Node<T>(value);

		if (this.first == null)
			this.first = temp;
		else
			this.last.setNext(temp);

		this.last = temp;
	}

	public T remove()
	{
		T x = this.first.getValue();
		this.first = this.first.getNext();

		if (this.first == null)
			this.last = null;

		return x;
	}

	public T head()
	{
		return this.first.getValue();
	}

	public boolean isEmpty()
	{
		return this.first == null;
	}
}
