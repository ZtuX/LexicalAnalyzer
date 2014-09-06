import java.util.ArrayList;

/**
 * Tabla de Simbolos.
 * @author Hernández Alarcón Jesús Alfredo
 */
public class SymbolTable {
    //Lista ligada para la tabla de simbolos
    protected ArrayList<Token> list = new ArrayList<>();
    
    //Getters and Setters
    public ArrayList<Token> getList() {
        return list;
    }

    public void setList(ArrayList<Token> list) {
        this.list = list;
    }
    
    //Constructor
    public SymbolTable(){
        /*Agregamos las palabras reservadas conocidas
        a la lista*/
        list.add(new Token("if", "PR"));
        list.add(new Token("else", "PR"));
    }
    
    /**
     * Muestra la tabla de simbolos.
     */ 
    public void showTable(){
        int i = 0;
        for(Token token:list){
            token.showToken(i++);
        }
    }
    
    /**
     * Regresa la posición en la que se encuentra el token.
     * @param token
     * @return La posición del Token.
     */
    public int position(Token token){
        int i = 0;
        for(Token t:list){
            if(t.equals(token)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    //TODO: Cambiar por un HashSet
    public int insertToken(Token t){
    	int i = 0;
    	for(Token token : list){
    		if(token.getValue().equals(t.getValue()) && token.getType().equals(t.getType())){
    			return i;
    		}
    		i++;
    	}
    	list.add(t);
    	return i;
    }
}
