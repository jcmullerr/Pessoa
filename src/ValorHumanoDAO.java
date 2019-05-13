import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class ValorHumanoDAO {
	
	public static ValorHumano buscaValorHumanoPorId( Integer idHumano ) throws SQLException, IOException {
		
		Conexao cnx = Pool.getInstance().getConexao();
		System.out.println("-> "+cnx);
		
		try {
			String cmd = "select * from ValoresHumanos where idValorHumano = ?";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setInt( 1, idHumano );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				return carregaInformacoesDoUsuario( rs );
			} else {
				return null;
			}
		} finally {
			cnx.libera();
		}
	}

	public static ValorHumano buscaValorHumanoPorEmail( String dsEmail ) throws SQLException, IOException {
		
		Conexao cnx = Pool.getInstance().getConexao();
		
		try {
			String cmd = "select * from ValoresHumanos where dsEmail = ?";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, dsEmail );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				return carregaInformacoesDoUsuario( rs );
			} else {
				return null;
			}
		} finally {
			cnx.libera();
		}
	}
	
	public static ArrayList<ValorHumano> getValorHumanoComNome( String dsNome ) throws SQLException, IOException {

		Conexao cnx = Pool.getInstance().getConexao();
		
		try {
			String cmd = "select * from ValoresHumanos where dsNome like ?";
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, "%"+ dsNome );
			
			ResultSet rs = ps.executeQuery();

			ArrayList<ValorHumano> result = new ArrayList<>();
			
			while( rs.next() ) {
				result.add( carregaInformacoesDoUsuario( rs ) );
			}
			
			return result;
		} finally {
			cnx.libera();
		}
	}

	private static ValorHumano carregaInformacoesDoUsuario(ResultSet rs) throws SQLException {

		ValorHumano usuario = new ValorHumano();
		
		usuario.setIdValorHumano( rs.getInt( "idValorHumano" ) );
		usuario.setDsNome( rs.getString( "dsNome" ) );
		usuario.setDsEmail( rs.getString( "dsEmail" ) );
		usuario.setDtInclusao( rs.getTimestamp( "dtInclusao" ) );
		usuario.setDtNascimento( rs.getTimestamp( "dtNascimento" ) );
		usuario.setTpSexo( rs.getString( "tpSexo" ) );
		usuario.setDsAreaDeInteresse(rs.getString("dsAreasDeInteresse"));
		usuario.setDsCEP(rs.getString("DsCEP"));
		usuario.setDsCidade(rs.getString("DsCidade"));
		usuario.setDsCPF(rs.getString("cdCPF"));
		usuario.setDsEscolaridade(rs.getString("dsEscolaridade"));
		usuario.setDsLogradouro(rs.getString("dsLogradouro"));
		usuario.setVlPretencaoSalarial(rs.getDouble("vlPretensaoSalarial"));
		usuario.setDsTelefone(rs.getString("dsTelefones"));
		
		
		return usuario;
	}

	public static void insere( ValorHumano usuario ) throws SQLException, IOException {
		
		Conexao cnx = Pool.getInstance().getConexao();
		System.out.println("-> "+cnx);
		
		try {
			String cmd = "insert into ValoresHumanos \r\n" + 
					"( dsNome,dsLogradouro,dsCidade,dsCEP,cdCPF,dsTelefones, dsEmail, dtNascimento, dtInclusao,tpSexo,dsEscolaridade,dsFormacaoAdicional,dsAreasDeInteresse,vlPretensaoSalarial )\r\n" + 
					"values\r\n" + 
					"( ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ? )";
			
			testaRegrasDeNegocio( usuario );
			
			usuario.setDtInclusao( new Timestamp( System.currentTimeMillis() ) );
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			ps.setString( 1, usuario.getDsNome() );
			ps.setString( 2, usuario.getDsLogradouro());
			ps.setString( 3, usuario.getDsCidade() );
			ps.setString( 4, usuario.getDsCEP() );
			ps.setString( 5, usuario.getDsCPF() );
			ps.setString( 6, usuario.getDsTelefone());
			ps.setString( 7, usuario.getDsEmail() );
			ps.setTimestamp( 8, usuario.getDtNascimento());
			ps.setString(9, usuario.getTpSexo());
			ps.setString(10, usuario.getDsEscolaridade());
			ps.setString(11, usuario.getFormacaoAdicional());
			ps.setString(12, usuario.getDsAreaDeInteresse());
			ps.setDouble(13, usuario.getVlPretencaoSalarial());
			
			ps.execute();
		} finally {
			cnx.libera();
		}
	}
	
	public static void altera( ValorHumano usuario ) {
		// preencher com o código da alteração no DB (update)
		// não esquecer de testar as regras de negócio
	}
	
	public static void exclui( ValorHumano usuario ) {
		// preencher com o código da exclusão
	}

	private static void testaRegrasDeNegocio(ValorHumano usuario) throws DBAccessException {

		if( !usuario.getTpSexo().matches( "M|F|O|N" ) ) {
			throw new DBAccessException( "O sexo do usuário precisa ser: M - Masculino; F - Feminino; O - Outros; N - Não desejo informar." );
		}
	}
	
}