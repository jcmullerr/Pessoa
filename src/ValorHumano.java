import java.sql.Date;
import java.sql.Timestamp;

public class ValorHumano {

	private Integer idValorHumano;
	private String dsNome;
	private String dsLogradouro;
	private String dsCidade;
	private String dsCEP;
	private String dsCPF;
	private String dsTelefone;
	private String dsEmail;
	private Timestamp dtInclusao;
	private Timestamp dtNascimento;
	private String dsEscolaridade;
	private String FormacaoAdicional;
	private String dsAreaDeInteresse;
	private String tpSexo;
	private Double vlPretencaoSalarial;


	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome( String dsNome ) {
		this.dsNome = dsNome;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail( String dsEmail ) {
		this.dsEmail = dsEmail;
	}

	public Timestamp getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao( Timestamp dtInclusao ) {
		this.dtInclusao = dtInclusao;
	}

	public Timestamp getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento( Timestamp timestamp ) {
		this.dtNascimento = timestamp;
	}

	public String getTpSexo() {
		return tpSexo;
	}

	public void setTpSexo( String tpSexo ) {
		this.tpSexo = tpSexo;
	}

	public Integer getIdValorHumano() {
		return idValorHumano;
	}

	public void setIdValorHumano(Integer idValorHumano) {
		this.idValorHumano = idValorHumano;
	}

	public String getDsLogradouro() {
		return dsLogradouro;
	}

	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getDsCEP() {
		return dsCEP;
	}

	public void setDsCEP(String dsCEP) {
		this.dsCEP = dsCEP;
	}

	public String getDsCPF() {
		return dsCPF;
	}

	public void setDsCPF(String dsCPF) {
		this.dsCPF = dsCPF;
	}

	public String getDsTelefone() {
		return dsTelefone;
	}

	public void setDsTelefone(String dsTelefone) {
		this.dsTelefone = dsTelefone;
	}

	public String getDsEscolaridade() {
		return dsEscolaridade;
	}

	public void setDsEscolaridade(String dsEscolaridade) {
		this.dsEscolaridade = dsEscolaridade;
	}

	public String getFormacaoAdicional() {
		return FormacaoAdicional;
	}

	public void setFormacaoAdicional(String formacaoAdicional) {
		FormacaoAdicional = formacaoAdicional;
	}

	public String getDsAreaDeInteresse() {
		return dsAreaDeInteresse;
	}

	public void setDsAreaDeInteresse(String dsAreaDeInteresse) {
		this.dsAreaDeInteresse = dsAreaDeInteresse;
	}

	public Double getVlPretencaoSalarial() {
		return vlPretencaoSalarial;
	}

	public void setVlPretencaoSalarial(Double dsPretencaoSalarial) {
		this.vlPretencaoSalarial = dsPretencaoSalarial;
	}
	@Override
	public String toString() {
		String retorno;
		retorno = "Identificador: "+idValorHumano.toString()+"\nNome: "+dsNome+"\nRua: "+dsLogradouro+
		"\nCidade: "+dsCidade+"\nCepÇ "+dsCEP+"\nCPF: "+dsCPF+"\nTelefone: "+dsTelefone+"\nEmail: "+dsEmail+
		"\nData de Inclusão: "+dtInclusao+"\nData de nascimento: "+dtNascimento.toString()+"\nEscolaridade: "+
		dsEscolaridade.toString()+"\nFormação adicinal: "+FormacaoAdicional+"\nArea de interesse: "
		+dsAreaDeInteresse+"\nSexo: "+tpSexo+"\nPretensão Salarial: "+vlPretencaoSalarial.toString();
		return retorno;
	}

	
}