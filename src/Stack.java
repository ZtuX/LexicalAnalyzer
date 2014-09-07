import java.util.Iterator;
import java.util.NoSuchElementException;
//import java.util.Spliterator;
//import java.util.function.Consumer;

/**
 * Clase Stack implementada
 * @author ztux
 *
 */
class Stack <T> implements Iterable<T>,Iterator<T>{
	private Node<T> top;
	private Node<T> temp = top;

	/**
	 * Inicializamos con el nodo del tope
	 * con una referencia a null
	 */
	public Stack(){
		top=null;
	}

	/**
	 * Verifica si esta vacio
	 * Stack
	 * @return True si está vacio, en caso contrario false.
	 */
	public boolean isEmpty(){
		return(top==null);
	}

	/**
	 * Inserta un dato
	 * @param dato
	 */
	public void push(T data){
		Node<T> q = new Node<T>(data,top);
		top = q;
	}

	/**
	 * Extrae un dato de la pila
	 * @return
	 */
	public T pop(){
		T aux = top.getData();
		top = top.getNextNode();
		return aux;
	}
	
	/**
	 * Muestra lo que hay dentro de la pila
	 */
	/*public void show(){
		Node<T> q = top;
		while(q!=null){
			System.out.println(q.getData());
			q=q.getNextNode();
		}
	}*/
	
	/**
	 * Muesta lo que hay en la pila de forma numerada o sin numerar
	 * @param b True muestra de forma numerada, false no numerada.
	 */
	public void show(boolean b){
		Node<T> q = top;
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
	
	

}