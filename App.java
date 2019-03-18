public class App{
    public static void imprimeDados(String titulo,Cliente clientes[]){
        System.out.println(titulo+":");
        for(int i=0;i<clientes.length;i++){
            System.out.println(clientes[i].toString());
        }
        System.out.println("----------\n");
    }

    public static void main(String args[]) {
        CadastroClientes cc = new CadastroClientes();

        cc.carregaDados("Clientes.csv");
        imprimeDados("Todos clientes",cc.getTodosClientes());
        imprimeDados("Clientes homens",cc.getClientesPorSexoV1("Male"));
        imprimeDados("Clientes mulheres",cc.getClientesPorSexoV2("Female"));
    }
}