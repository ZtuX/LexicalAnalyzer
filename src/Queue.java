import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue<T> implements Iterable<T>,Iterator<T>{
	private Node<T> H;
	private Node<T> T;
	
	private Node<T> temp = H;
	public static int noNodes = 0;
	
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
		noNodes++;
	}
	
	public void insert(T data,boolean t){
		Node<T> temp = H;
		Node<T> q = new Node<T>(data,null);
		if(isEmpty()){
			//System.out.println("INICIO DE LA COLA ");
			H=q;
		}
		else{
			while(temp.getNextNode()!=null){
				//Preguntamos si el dato es igual
				if(temp.getData().equals(data)){
					//System.out.println("YA ESTA EN LA COLA, NO SE AGREGA");
					return;
				}
				temp = temp.getNextNode();
			}
			//System.out.println("NO ESTA EN LA COLA, SE VA A INSERTAR");
			T.setNextNode(q);
		}
		T = q;
		noNodes++;
	}

	public T delete(){
		T aux = H.getData();
		if(H==T)
			H=T=null;
		else
			H = H.getNextNode();
		return aux;
	}

	/**
	 * Muesta lo que hay en la cola de forma numerada o sin numerar
	 * @param b True muestra de forma numerada, false no numerada.
	 */
	public void show(boolean b){
		if(b){
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
		}else{
			for(Node<T> q = H ; q !=null ;q=q.getNextNode())
				System.out.println("[*] "+q.getData());
		}

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
	 * @return Regresa la longitud de la cola
	 */
	public int length(){
		return this.noNodes;
	}

}