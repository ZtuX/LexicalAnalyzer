import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal del Analizador Léxico.
 * @author Hernández Alarcón Jesús Alfredo
 */
public class LexicalAnalyzerTest {
    
    private File file; //Archivo a abrir
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private LexicalAnalyzer analyzer; //Analizador Léxico
    public static String fileName = "";//Nombre del archivo a analizar
    
    
    /**
     * Constructor del Analizador Lexico Test.
     * @param path Ruta del archivo a analizar.
     * @throws IOException 
     */
    public LexicalAnalyzerTest(String path) throws IOException{
        readFile(path);
        analyzer = new LexicalAnalyzer(bufferedReader);
    }
    
    /**
     * Lee el archivo a analizar.
     * @param path
     * @throws FileNotFoundException 
     */
    private void readFile(String path){
        try {
            file = new File(path);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado...!");
        }
    }
    
    /**
     * Muestra la ayuda del programa.
     */
    public static void showHelp(){
        System.out.println("***********************************");
        System.out.println("Analizador Léxico");
        System.out.println("-h\t\tMuestra esta ayuda");
        System.out.println("-f [programa]\tAnaliza el archivo");
        System.out.println("***********************************");
    }

    public static void showDevelopers(){
        System.out.println("***********************************");
        System.out.println("Hernández Alarcón Jesús Alfredo");
        System.out.println("***********************************");
    }
    
    /**
    * Banderas para saber el estado del programa
    * NO_FLAGS => Se corre el progarama sin banderas
    * HELP => Se solicita la ayuda
    * FILE => Se solicita el analisis de un programa 
    */
    public enum Flag{
        NO_FLAGS,         
        HELP, 
        FILE 
    };
    
    /**
     * Main.
     * @param args Argumentos de la linea de comandos
     */
    public static void main(String... args) {
        Flag flag = Flag.NO_FLAGS;
        
        if(args.length==1){ flag = Flag.HELP; }
        if(args.length==2){
            args[0] = args[0].toLowerCase();
            //Si se usa la bandera de archivo
            if(args[0].equals("-f")){
                //Asignamos el nombre del archivo al analizador lexico
                LexicalAnalyzerTest.fileName = args[1];
                flag = Flag.FILE;
            }
        }
        
        switch(flag){
            case NO_FLAGS:
                LexicalAnalyzerTest.showDevelopers();
                break;
            case HELP:
                LexicalAnalyzerTest.showHelp();
                break;
            case FILE:
                //Se analiza el archivo
            	try{
            		LexicalAnalyzerTest scanner = new LexicalAnalyzerTest(fileName);
	            	//Creamos un Token
	                Token token;
	                while((scanner.analyzer.getEOF_Flag())!=true){
	                	token=scanner.analyzer.nextToken();
	                	//System.out.println("Token encontrado!");
	                }
	                //Mostramos la tabla de Simbolos
	                System.out.println("=============================");
	                System.out.println("[+] Symbol Table");
	                System.out.println("=============================");
	                scanner.analyzer.symbolTable.showTable();
	                System.out.println("=============================");
	                System.out.println("[+] "+scanner.analyzer.getErrorCounter()+" error(s) found");
	                System.out.println("=============================");
	                scanner.analyzer.showErrors(); //Mostramos los errores
            	}catch (IOException e) {
					System.out.println("[!]Error al leer el archivo "+args[1]);
				}
	                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
