public class BinNode<T>
{
	private BinNode<T> left;
	private T value;
	private BinNode<T> right;

	public BinNode(BinNode<T> left, T value, BinNode<T> right)
	{
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public BinNode<T> getLeft()
	{
		return this.left;
	}

	public T getValue()
	{
		return this.value;
	}

	public BinNode<T> getRight()
	{
		return this.right;
	}

	public void setLeft(BinNode<T> left)
	{
		this.left = left;
	}

	public void setValue(T value)
	{
		this.value = value;
	}

	public void setRight(BinNode<T> right)
	{
		this.right = right;
	}
}
