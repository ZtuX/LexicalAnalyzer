/**
 * Clase Stack implementada
 * @author ztux
 *
 */
class Stack <T>{
	private Node<T> top;

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
	public boolean vacio(){
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

	public void listar(){
		Node<T> q = top;
		while(q!=null){
			System.out.println("[*] "+q.getData());
			q=q.getNextNode();
		}
	}
}