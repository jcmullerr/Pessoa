import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Pool{
	
	private ArrayList<Conexao> conexoes = new ArrayList<Conexao>();
	private static int totalCnx = 10;
	private static Pool ref;
	
	private Pool() throws DBAccessException, IOException {
		
		for(int i = 0; i < totalCnx; i++) {
			Conexao c = new Conexao();
			c.libera();
			conexoes.add(c);
			
		}
		
	}
	
	public static Pool getInstance() throws DBAccessException, IOException {
		
		if(ref == null) {
			
			ref = new Pool();
			
		}
		
		return ref;
		
	}
	
	public Conexao getConexao() throws DBAccessException {
		
		for(int i = 0; i < conexoes.size()-1; i++) {
			
			if(conexoes.get(i).isLivre()) {
				
				conexoes.get(i).reserva();
				return conexoes.get(i);
				
			}
			
		}
		
		return null;
		
	}
	
	
	
}