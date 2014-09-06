/**
 * Clase Token
 * @author Hernández Alarcón Jesús Alfredo
 */
public class Token {
    private String value;
    private String type;
    
    
    public Token(String value, String type){
        this.value = value;
        this.type = type;
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
    
    /*
     * Muestra el token encontrado.
     */
    public void showToken(){
        System.out.println("Token found: < '" + this.getValue()+ "' , '" + this.getType()+"' >");
    }
    
    /*
     * Muestra el token
     */
    public void showToken(int i){
        System.out.println(""+i+": "+this.getValue()+ " => " + this.getType());
    }    
}

