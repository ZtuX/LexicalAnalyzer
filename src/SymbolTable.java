/**
 * Tabla de Simbolos.
 * @author Hernández Alarcón Jesús Alfredo
 */
public class SymbolTable {
    /*Lista ligada para la tabla de simbolos
    protected ArrayList<Token> list = new ArrayList<>();
    */
    
    protected Stack<Token> tokenList = new Stack<>(); //Stack de tokens
    
    /*Getters and Setters
    public ArrayList<Token> getList() {
        return list;
    }

    public void setList(ArrayList<Token> list) {
        this.list = list;
    }*/
    
    public Stack<Token> getStack(){
    	return tokenList;
    }
    
    public void setStack(Stack<Token> stack){
    	tokenList=stack;
    }
    
    //Constructor
    public SymbolTable(){
        /*Agregamos las palabras reservadas conocidas
        a la lista*/
        //list.add(new Token("if", "PR"));
        //list.add(new Token("else", "PR"));
    	tokenList.push(new Token("if", "PR"));
    	tokenList.push(new Token("else","PR"));
    }
    
    /**
     * Muestra la tabla de simbolos.
     */ 
    /*public void showTable(){
        int i = 0;
        for(Token token:list){
            token.showToken(i++);
        }
    }*/
    
    /**
     * Muestra la tabla de tokens
     */
    public void showTable(){
    	tokenList.show(true);
    }
    
    
    /**
     * Regresa la posición en la que se encuentra el token.
     * @param token
     * @return La posición del Token.
     */
    /*public int position(Token token){
        int i = 0;
        for(Token t:list){
            if(t.equals(token)){
                return i;
            }
            i++;
        }
        return -1;
    }*/
    
    /**
     * Regresa la posición del token que se busca
     * @param token
     * @return -1 en caso de no exstir el token, en otro caso un valor distinto de -1
     */
    public int position(Token token){
    	int i = 0;
    	for(Token t:tokenList){
            if(t.equals(token)){
                return i;
            }
            i++;
    	}
    	return -1;
    }
    
    
    /*public int insertToken(Token t){
    	int i = 0;
    	for(Token token : list){
    		if(token.getValue().equals(t.getValue()) && token.getType().equals(t.getType())){
    			return i;
    		}
    		i++;
    	}
    	list.add(t);
    	return i;
    }*/
    
    /**
     * Inserta un token en la lista de tokens
     * @param t
     * @return La posición en la que se inserto el token
     */
    public int insertToken(Token t){
    	int i = 0;
    	for(Token token : tokenList){
    		if(token.getValue().equals(t.getValue()) && token.getType().equals(t.getType())){
    			return i;
    		}
    		i++;
    	}
    	tokenList.push(t);
    	return i;
    }
}
