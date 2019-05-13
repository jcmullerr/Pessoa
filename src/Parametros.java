import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Parametros{
	
	private Properties parametros;
	private static Parametros referencia;
	
	private Parametros() throws IOException {
		
		inicializaComValoresDefault();
		
	}
	
	public static Parametros getInstance() throws IOException {
		
		if(referencia == null) {
			
			referencia = new Parametros();
			
		}
		
		return referencia;
		
	}
	
	public void inicializaComValoresDefault() throws IOException{
		
		parametros = new Properties();
		
		parametros.setProperty("driverJdbc", "org.postgresql.Driver");
		parametros.setProperty("urlBanco", "jdbc:postgresql://localhost:5432/ProgIII");
		parametros.setProperty("nomeUsuario", "postgres");
		parametros.setProperty("senha", "norma3006");
		
		FileOutputStream arquivo = new FileOutputStream("Parametros.xml");
		
		try {
			
			parametros.storeToXML(arquivo, "Arquivo de parâmetros");
			
		}
		finally {
			
			arquivo.close();
			
		}
		
	}
	
	private void carregaParametros() {
		
		try {
			
			FileInputStream arquivo = new FileInputStream("Parametros.xml");
			
			parametros = new Properties();
			parametros.loadFromXML(arquivo);
			
		}
		catch(IOException e) {
			
			System.out.println("Houve problemas ao carregar o arquivo!");
			
		}
		
	}
	
	public String getParametro(String chave) {
		
		return parametros.getProperty(chave);
		
	}
	
}
