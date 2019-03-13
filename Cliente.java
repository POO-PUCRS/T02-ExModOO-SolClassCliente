public class Cliente{
    private int id;
    private String nome;
    private String email;
    private String sexo;
    private String telefone;
    private String cep;
    private String cidade;
    private String pais;
    private String profissao;

    public Cliente(int id,String nome,String email,String sexo,String telefone,String cep,String cidade,String pais,String profissao){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.pais = pais;
        this.profissao = profissao;
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getProfissao() {
        return profissao;
    }

    public String toString(){
        return "["+getId()+", "
                  +getNome()+", "
                  +getEmail()+", "
                  +getSexo()+", "
                  +getTelefone()+", "
                  +getCep()+", "
                  +getCidade()+", "
                  +getPais()+", "
                  +getProfissao()+"]";
    }
}