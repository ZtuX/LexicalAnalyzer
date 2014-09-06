/**
 * Clase Node
 * @author ztux
 *
 */
class Node <T>{
	private T data;
	private Node<T> nextNode;
    
    public Node(){}

	public Node(T data, Node<T> nextNode){
		this.data=data;
		this.nextNode=nextNode;
	}

	public Node<T> getNextNode(){
		return nextNode;
	}
	
	public T getData(){
		return data;
	}
	public void setData(T newData){
		data=newData;
	}
	public void setNextNode(Node<T> nextNode){
		this.nextNode = nextNode;
	}

}