/**
 * Clase Token
 * @author Hernández Alarcón Jesús Alfredo
 */
public class Token {
    private String value;
    private String type;
    public static int noTokens=-1; //El numero de tokens (Instancias de token)
    
    /**
     * Constructor del token
     * @param value El valor del Token
     * @param type	El tipo de Token
     */
    public Token(String value, String type){
        this.value = value;
        this.type = type;
        noTokens++;
    }

    /**
     * @return Valor del Token
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value Valor del Token 
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return El tipo de Token
     */
    public String getType() {
        return type;
    }

    /**
     * @param type Tipo de Token a cambiar
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Muestra el token encontrado.
     */
    public void showToken(){
        //System.out.println("Token found: < '" + this.getValue()+ "' , '" + this.getType()+"' >");
    	System.out.println("Token found: "+this);
    }
    
    /**
     * Muestra el token
     */
    public void showToken(int i){
        System.out.println(""+i+": "+this.getValue()+ " => " + this.getType());
    }    
    
    /**
     * Forma de mostrar el token cuando se quiere imprimir
     * en pantalla.
     */
    @Override
    public String toString() {
    	return ("<'"+this.getValue()+"','"+this.getType()+"'>");
    }
    
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()){
			return false;
		}
		Token guest = (Token)obj;
		return (this.getValue().equals(guest.getValue()) && this.getType().equals(guest.getType()));
		
	}
	
}

