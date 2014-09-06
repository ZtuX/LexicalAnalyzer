/**
 * Clase del Automata.
 * @author Hernández Alarcón Jesús Alfredo
 */
public class Automaton {
    public int line = 1;
    
    /**
     * Obtiene la linea actual que se lee;
     * @return El numero de linea que se lee.
     */
    public int getLine() {
        return line;
    }
    
    /**
     * Cambia el atributo line
     * @param line
     */
    public void setLine(int line){
    	this.line=line;
    }
    
    
    /**
     * Tabla de transicion de 14 estados.
     * Empieza desde el estado q0 hasta el estado q13.
     */
    int transitions[][]=
    /**
     * [letras] = [a-dghjkm-rt-zA-Z_]
     * 0: [letras]
     * 1: punto(.)
     * 2: (
     * 3: )
     * 4: ;
     * 5: ,
     * 6: EPSILON
     * 7: e
     * 8: l
     * 9: s
     * 10: i
     * 11: f
     * 12: +
     * 13: -
     * 14: *
     * 15: /
     * 16: =
     * 17: Digito
     */
    {//  [letras]   .       (       )       ;       ,    EPSILON    e       l       s       i       f       +       -       *       /       =    DIGITO        
        {   1   ,    7  ,   12  ,   12  ,   12  ,   12  ,   13  ,   6   ,   1   ,   1   ,   5   ,   1   ,   3   ,   3   ,   3   ,   3   ,   2   ,   4   }, //q0
        {   1   ,   -1  ,   13  ,   13  ,   13  ,  13   ,   13  ,   1   ,   1   ,   1   ,   1   ,   1   ,  13   ,   13  ,   13  ,   13  ,   13  ,   1   }, //q1
        {   13  ,  13   ,   13  ,   13  ,   -1  ,   -1  ,   13  ,   13  ,  13   ,  13   ,  13   ,  13   ,  -1   ,  -1   ,  -1   ,  -1   ,  -1   ,   13  }, //q2
        {   13  ,   -1  ,   13  ,   -1  ,   -1  ,  -1   ,   13  ,  13   ,   13  ,  13   ,  13   ,  13   ,  -1   ,  -1   ,  -1   ,  -1   ,  -1   ,   13  }, //q3
        {   -1  ,    7  ,   -1  ,   13  ,   13  ,  13   ,   13  ,  -1   ,  -1   ,   -1  ,  -1   ,   -1  ,  13   ,  -1   ,  -1   ,  -1   ,  -1   ,   4   }, //q4
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,   13  ,   1   ,   1   ,   1   ,   1   ,   8   ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   }, //q5
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,   13  ,   1   ,   9   ,   1   ,   1   ,   1   ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   }, //q6
        {   -1  ,   -1  ,  13   ,  13   ,  13   ,  13   ,  13   ,  -1   ,  -1   ,   -1  ,  -1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,  13   ,   7   }, //q7
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,   13  ,   1   ,   1   ,   1   ,   1   ,   1   ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   }, //q8
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   ,   1   ,   10  ,   1   ,   1   ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   }, //q9
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,  13   ,   11  ,   1   ,   1   ,   1   ,   1   ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   }, //q10
        {   1   ,   -1  ,  13   ,  13   ,  13   ,  13   ,  13   ,   1   ,   1   ,   1   ,   1   ,   1   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   }, //q11
        {   13  ,   13  ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   ,  13   }, //q12
        {   0   ,    0  ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   ,   0   } //ESTADO DE ACEPTACION DE TOKEN VALIDO
    };
    
    //TODO: Agregar tabla de acciones
    boolean go[][]={
	 //  [letras]   .       (       )       ;       ,    EPSILON    e       l       s       i       f       +       -       *       /       =    DIGITO   
    	{true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	,true	}, //q0
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,true	}, //q1
    	{false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	}, //q2
    	{false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	}, //q3
    	{false	,true	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,true	}, //q4
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,true	}, //q5
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,true	}, //q6
    	{false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,true	}, //q7
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,true	}, //q8
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,false	}, //q9
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,false	}, //q10
    	{true	,false	,false	,false	,false	,false	,false	,true	,true	,true	,true	,true	,false	,false	,false	,false	,false	,false	}, //q11
    	{false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	}, // q12
    	{false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	,false	}, // q13
    };
    
    /**
     * Avanza al siguiente estado dependiendo del estado
     * en el que se encuentre el automata y el valor
     * que se lea. 
     * 
     * @param state Estado en el que se encuentra
     * @param c     Caracter que se lee
     * @return      El siguiente estado. Regresa -1 en caso de existir un error.
     * 
     */
    public int nextState(int state, Character c){
        int value = codificaC(state,c);
        return (value==-1) ? -1 : transitions[state][value];
    }
    
    public int codificaC(int state, Character c){
        switch(state){
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
                if(c=='.') {
                    return 1; //Se leyó un punto
                }else if(c=='e'){
                	return 7;
                }
                else if(c=='l'){
                	return 8;
                }
                else if(c=='s'){
                	return 9;
                }
                else if(c=='f'){
                    return 11;
                }else if(Character.isDigit(c)){
                    return 17;
                }else if(Character.isLetter(c) || c=='_'){
                    return 0;
                }
   
            default:
                if(c=='e'){
                    return 7;
                }else if(c=='i'){
                    return 10;
                }else if(Character.isLetter(c) || c=='_'){
                    return 0;
                }/*else if(c=='.'){
                    return 1;
                }*/else if(c=='('){
                    return 2;
                }else if(c==')'){
                    return 3;
                }
                else if(c==';'){
                    return 4;
                }else if(c==','){
                    return 5;
                }else if(c==' '||c=='\n'||c=='\t'||c=='\r'){
                    return 6;
                }/*else if(c=='e'){
                    return 7;
                }else if(c=='l'){
                    return 8;
                }else if(c=='s'){
                    return 9;
                }else if(c=='i'){
                    return 10;
                }/*else if(c=='f'){
                    return 11;
                }*/else if(c=='+'){
                    return 12;
                }else if(c=='-'){
                    return 13;
                }else if(c=='*'){
                    return 14;
                }else if(c=='/'){
                    return 15;
                }else if(c=='='){
                    return 16;
                }else if(Character.isDigit(c)){
                    return 17;
                }else
                    return -1;
        }
    }
    
    public boolean go_to(int state,Character c){
        int value = codificaC(state, c); 
        if(c=='\n')
            this.line++;
        if (value==-1){            
            return false;
        }   
        return go[state][value];
    }
    
    public void error(Character c){
        System.out.println("Símbolo de entrada no reconocido: "+c+ " en línea: "+ this.line);
    }
    
}
