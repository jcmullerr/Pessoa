import java.io.IOException;

public class TestaParametros {
	
	public static void main(String[] args) throws IOException {
			
		Parametros prm = Parametros.getInstance();
		
		prm.inicializaComValoresDefault();
	}
}