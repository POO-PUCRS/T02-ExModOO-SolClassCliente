import java.util.Scanner;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.Arrays;

public class CadastroClientes{
    public final int MAX_DADOS = 1000;
    private boolean dadosOK;
    private Cliente clientes[];
 

    public CadastroClientes(){
        clientes = new Cliente[MAX_DADOS];
        dadosOK = false;
    }

    public boolean getDadosOk(){
        return dadosOK;
    }

    public void carregaDados(String nomeArquivo){
        // Monta string com nome absoluto do arquivo
        String dirCorrente = Paths.get("").toAbsolutePath().toString();
        String nomeCompleto = dirCorrente+"\\"+nomeArquivo;

        // Define caminho até o arquivo físico a partir do nome absoluto
        Path path = Paths.get(nomeCompleto);

        // Usa a classe Scanner para ler o arquivo 
        int ind = 0;
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("UTF-8")))){
            // Consome a linha do cabecalho
            sc.nextLine();
            // Le as demais linhas
            while(sc.hasNext()){
                String line = sc.nextLine();
                String campos[] = line.split("[,\n]");
                Cliente cliente = new Cliente(Integer.parseInt(campos[0].trim()),
                                            campos[1].trim(),
                                            campos[2].trim(),
                                            campos[3].trim(),
                                            campos[4].trim(),
                                            campos[5].trim(),
                                            campos[6].trim(),
                                            campos[7].trim(),
                                            campos[8].trim());
                clientes[ind] = cliente;
                ind++;
            }
            dadosOK = true;
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
            dadosOK = false;
        }
    }

    public Cliente get(int indice){
        if (!dadosOK || indice<0 || indice >= MAX_DADOS){
            return null;
        }else{
            return clientes[indice];
        }
     }

    public Cliente[] getTodosClientes(){
        if (!dadosOK){ // dadosOk == false
            return null;
        }
        return Arrays.copyOf(clientes,MAX_DADOS);
    }

    // Retorna um arranjo com os clientes de um determinado sexo
    // Solucao 1: algoritmo de duas passadas; economiza memória e perde performance
    public Cliente[] getClientesPorSexoV1(String sexo){
        if (!dadosOK){
            return null;
        }
        // Conta quantos são
        int cont = 0;
        for(int i=0;i<clientes.length;i++){
            if (clientes[i].getSexo().equals(sexo)){
                cont++;
            }
        }
        // Monta o vetor resposta
        Cliente[] resp = new Cliente[cont];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (clientes[i].getSexo().equals(sexo)){
                resp[pos] = clientes[i];
                pos++;
            }
        }
        return resp;
    }

    // Retorna um arranjo com os clientes de um determinado sexo
    // Solucao 2: algoritmo de uma passada; Gasta memória em troca de performance
    public Cliente[] getClientesPorSexoV2(String sexo){
        if (!dadosOK){
            return null;
        }
        // Monta o vetor resposta
        Cliente[] resp = new Cliente[MAX_DADOS];
        int pos = 0;
        for(int i=0;i<MAX_DADOS;i++){
            if (clientes[i].getSexo().equals(sexo)){
                resp[pos] = clientes[i];
                pos++;
            }
        }
        return Arrays.copyOf(resp,pos);
    }
    /* Exercícios: (alterne os tipos de solucao)
     1) Clientes por cidade
     2) Clientes por pais
     3) Clientes por pais e profissão
     */
}