import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue<T> implements Iterable<T>,Iterator<T>{
	private Node<T> H;
	private Node<T> T;
	
	private Node<T> temp = H;
	
	public Queue(){
		H=T=null;
	}

	public boolean isEmpty(){
		return(T==null);
	}

	public void insert(T data){
		Node<T> q = new Node<T>(data,null);
		if(isEmpty())
			H=q;
		else 
			T.setNextNode(q);
		T=q;
	}

	public T delete(){
		T aux = H.getData();
		if(H==T)
			H=T=null;
		else
			H = H.getNextNode();
		return aux;
	}

	public void show(){
		for(Node<T> q = H ; q !=null ;q=q.getNextNode())
			System.out.println("[*] "+q.getData());
	}
	
	/**
	 * Metodos implementados para poder usar 
	 * for each
	 */
	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) this;
	}
	
	public T next(){
		if(temp==null){
			throw new NoSuchElementException();
		}
		temp=temp.getNextNode();
		return (T) temp;
	}
	
	public boolean hasNext(){
		return (temp!=null);
	}
	
	/**
	 * Muesta lo que hay en la cola de forma numerada o sin numerar
	 * @param b True muestra de forma numerada, false no numerada.
	 */
	public void show(boolean b){
		Node<T> q = H;
		int i = 1;
		if(b){
			while(q!=null){
				System.out.println(""+(i++)+": "+q.getData());
				q=q.getNextNode();
			}			
		}else{
			while(q!=null){
				System.out.println(q.getData());
				q=q.getNextNode();
			}
		}

	}
	
}