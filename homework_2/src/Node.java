
public class Node
{
	private int num;

	public Node previous;
	public Node next;
	
	public Node(int number)
	{
		num = number;
	}

	// accessors and mutators
	public int getNumber(int number){return num;} 
	public void setNumber(int number){num = number;}
	
}