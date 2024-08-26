package producerconsumer;

public class Produtor implements Runnable {
    private int codigo;
    private int qtdSacasColheita;
    private int intervaloProd;
    private Armazem deposito;
    private int totalProduzido;

    public Produtor(int cod, int qtd_sacas, int intervalo, Armazem dep){
        codigo = cod;
        qtdSacasColheita = qtd_sacas;
        intervaloProd = intervalo;
        deposito = dep;
        totalProduzido = 0;
    }
    public void run(){
        for(int i = 0; i<10;i++) {
            System.out.println("PRODUTOR: "+codigo+" / Iteração: "+ i +" / Produção: " + qtdSacasColheita +"\n");
            deposito.armazenar(qtdSacasColheita, codigo);
            try {
                Thread.sleep(intervaloProd);
            } catch( InterruptedException exception ) {
                System.err.println( exception.toString() );
            }
        }
    }
}

