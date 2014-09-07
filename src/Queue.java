
/**
 * @author Hernández Alarcón Jesús Alfredo
 * Estructura de datos implementada (Cola)
 * @param <T> El tipo de dato 
 */
class Queue<T>{
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

	/**
	 * Inserta un nuevo nodo
	 * @param data
	 * @param t Si es True, no se insertan repetidos, en otro caso false
	 */
	public void insert(T data,boolean t){
		if(t){
			Node<T> temp = H;
			Node<T> q = new Node<T>(data,null);
			if(isEmpty()){
				//System.out.println("INICIO DE LA COLA ");
				H=q;
			}
			else{
				while(temp!=null){
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
		}else{
			Node<T> q = new Node<T>(data,null);
			if(isEmpty())
				H=q;
			else 
				T.setNextNode(q);
			T=q;
			noNodes++;
		}
	}
	
	/**
	 * Elimina la cola
	 */
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
	 * @return Regresa la longitud de la cola
	 */
	public int length(){
		return this.noNodes;
	}

}