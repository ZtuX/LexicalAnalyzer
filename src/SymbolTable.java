/**
 * Tabla de Simbolos.
 * @author Hernández Alarcón Jesús Alfredo
 */
public class SymbolTable { 
    protected Queue<Token> tokenList = new Queue<>(); //Cola de tokens
    
    public Queue<Token> getQueue(){
    	return tokenList;
    }
    
    public void setStack(Queue<Token> queue){
    	tokenList=queue;
    }
    
    //Constructor
    public SymbolTable(){
    	tokenList.insert(new Token("if", "PR"));
    	tokenList.insert(new Token("else","PR"));
    }
    

    /*public void showTable(){
        int i = 0;
        for(Token token:list){
            token.showToken(i++);
        }
    }*/
    
    /**
     * Muestra la tabla de simbolos.
     */ 
    public void showTable(){
    	tokenList.show(true);
    }
    
    
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
    	tokenList.insert(t);
    	return i;
    }
}
