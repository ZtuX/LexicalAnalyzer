import java.io.BufferedReader;
import java.io.IOException;
import java.security.acl.LastOwnerException;

/**
 * Lexical Analyzer
 * @author ZtuX
 */
public class LexicalAnalyzer {
    protected SymbolTable symbolTable; //Tabla de Simbolos
    protected Automaton automaton;//Automata
    protected BufferedReader bufferedReader; //Buffer
    Character c ;
    /**Inicialmente el estado esta en 0*/
    protected int currentState = 0; //Estado Actual
    protected String lexeme =""; //Lexema
    
    
    //Getters and Setters
    public int getCurrentState() {
        return currentState;
    }
    
    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
       
    /**
     * Constructor LexicalAnalyzer:
     * Se inicializa el analizador con la tabla de símbolos
     * el autómata, el buffer y el caracter.
     * @param bufferedReader 
     * @throws IOException
     */
    public LexicalAnalyzer(BufferedReader bufferedReader) throws IOException{
        //Cargamos la tabla de Simbolos
        symbolTable = new SymbolTable();
        //Cargamos el automata
        automaton = new Automaton();
        //Buffer Reader
        this.bufferedReader = bufferedReader;
        //Obtenemos el primer caracter
        c = getC();
    }
    
    
    public Token nextToken() throws IOException{
        Token token = null;
        String type = "";
        TokenType tokenType=null; //El tipo de token (Enum)
        int nextState = 0; //Siguiente estado
        int priorState = 0; //Estado anterior
        lexeme = ""; //Variable para almacenar el lexema identificado
        /* Repetimos el ciclo mientras no estemos en el estado de aceptación.
         * Recordar que el estado de aceptación por default es 0
         */
        while(currentState!=13){
        	/*En esta parte hacemos que cualquiera de esos casos
        	  se tome como espacio en blanco */
        	if(c==' '||c=='\n'||c=='\t'||c=='\r'){
        		c=' ';
        	}
        	//El estado anterior es igual al estado actual
        	priorState = currentState;
        	//Obtenemos el siguiente estado:
        	nextState = this.automaton.nextState(currentState, c);
            //System.out.println("[*] Caracter leido: '"+c+"'");
            //System.out.println("[+] Estado actual: "+currentState);
        	
        	//Si el automata va a un siguiente estado...
        	if(automaton.go_to(currentState, c)){
        		//TODO: Borras esta linea
        		//System.out.println("Estado actual: "+currentState);        		
        		//Concatenamos lo que hay en el lexema
        		lexeme+=c;
        		//Obtenemos el siguiente caracter
        		c = getC();
        	}        	
        	/*El estado actual será igual a siguiente estado
        	* Nos movemos de estado en el automata
        	*/
        	currentState = nextState;
        	
        	//System.out.println("Lexema: <"+lexeme+">");
        	//System.out.println("Siguiente estado es: "+nextState+"\n");
        	
        	//Si c toma el valor de -1, entonces es EOF
        	if(c=='￿') { 
        		System.out.println("END OF FILE");
        		return null; 
        	}
        	
        	/*Si currentState (estado actual) es un estado de error,
        	 * nos salimos del análisis
        	 */
        	if(currentState==-1){
        		error(); //Mostramos el error
        		return null; 
        	}
        	
        }
        /*Nos movemos al inicio del automata*/
        currentState = 0 ;
        
        /*Identificamos el tipo de token*/
        //tokenType = tokenType(priorState,true);
        type = tokenType(priorState);
        
        /*Si el tipo de token es un error D:
         * regresamos un valor de null
         */
        /*if(tokenType == TokenType.ERROR){
        	return null;
        }*/
        if(type.equals("ERROR")){
        	return null;
        }
        
        /*En esta parte se identifica el token, si es
         * una palabra reservada solo lo muestra en pantalla, en caso
         * de no estar en la tabla de simbolos lo inserta y lo imprime.
         */
        token = new Token(lexeme, type);
        int pos;
        if(type.equals("ID")){
        	if(lexeme.equals("if") || lexeme.equals("else")){
        		token.setType("PR");
        		token.showToken();
        		pos = symbolTable.position(token);
        		token.setValue(Integer.toString(pos));
        	}else{
        		token.showToken();
        		pos = symbolTable.insertToken(token);
        		token = new Token(Integer.toString(pos),"ID");
        	}
        }else{
        	token.showToken();
        }
        
        return token;
    }
    
    /**
     * Obtenemos un caracter del bufferReader
     * @return Un caracter, en caso de EOF -1
     * @throws IOException
     */
    public Character getC() throws IOException{
        return (char)getBufferedReader().read();
    }
        
    /**
     * Obtiene el tipo de token identificado.
     * @param priorState El estado anterior
     * @return El tipo de token identificado
     */
    public String tokenType(int priorState){
    	switch(priorState){
	        case 0:
	        case 13:
	            return "SPACE"; 
	        case 1:
	            return "ID";
	        case 2:
	        	return "ASSIGNMENT_OP";
	        case 3:
	        	return "ARITHMETIC_OP";
	        case 4:
	        	return "INTEGER";
	        case 7:
	        	return "FLOAT";
	        case 8:
	        	return "IF";
	        case 11:
	        	return "ELSE";
	        case 12:
	        	return "SPECIAL_OP";
	        default:
	        	return "ERROR";
    	}
    }
    
    /**
     * Obtiene el tipo de token identificado.
     * @param priorState El estado anterior
     * @return El tipo de token identificado
     */
    public TokenType tokenType(int priorState, boolean ENUM){
        switch(priorState){
            case 0:
            case 13:
                return TokenType.SPACE; 
            case 1:
                return TokenType.ID;
            case 2:
            	return TokenType.ASSIGNMENT_OP;
            case 3:
            	return TokenType.ARITHMETIC_OP;
            case 4:
            	return TokenType.INTEGER;
            case 7:
            	return TokenType.FLOAT;
            case 8:
            	return TokenType.IF;
            case 11:
            	return TokenType.ELSE;
            case 12:
            	return TokenType.SPECIAL_OP;
            default:
            	return TokenType.ERROR;
        }
    }
    
    /**
     * Muestra un mensaje de Error.
     */
    public void error(){
        System.out.println("Error found at line: "+ automaton.getLine() +" on '"+lexeme+"'");
    }
}
