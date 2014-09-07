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
    	//tokenList.insert(new Token("if", "PR"),true);
    	//tokenList.insert(new Token("else","PR"),true);
    }
     
    /**
     * Muestra la tabla de simbolos.
     */ 
    public void showTable(){
    	//Habilitamos mostrarlos de forma numerada con true
    	tokenList.show(true);
    }
        
    
    /**
     * Inserta un token en la lista de tokens
     * @param t
     * @return La posición en la que se inserto el token
     */
    public void insertToken(Token t){
    	tokenList.insert(t,true);
    }
}
