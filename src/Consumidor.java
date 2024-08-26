public class Consumidor implements Runnable{
    private int codigo;
    private int consumoColheita;
    private int intervaloConsumo;
    private int totalConsumido;
    private Armazem deposito;

    public Consumidor(int cod, int consumo, int intervalo, Armazem dep){
        codigo = cod;
        consumoColheita = consumo;
        intervaloConsumo = intervalo;
        deposito = dep;
        totalConsumido = 0;
    }

    public void run()   {
        for (int i = 0;i <10;i++) {
            System.out.println("CONSUMIDOR: "+codigo+" / Iteração: "+ i + " / Consumação: " + consumoColheita +"\n");
            deposito.retirar(consumoColheita, codigo);
            try {
                Thread.sleep(intervaloConsumo);
            }catch( InterruptedException exception ) {
                System.err.println( exception.toString() );
            }
        }
    }
}

