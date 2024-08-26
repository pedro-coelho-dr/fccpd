public class Consumidor implements Runnable{
    private  int codigo;
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
            int y = deposito.retirar(consumoColheita);
            if(y != 0) {
                totalConsumido+=consumoColheita;
                System.out.println("Consumidor (codigo) : "+codigo+", Total Consumido: "+totalConsumido+"\n");
            }
            try {
                Thread.sleep(intervaloConsumo);
            }catch( InterruptedException exception ) {
                System.err.println( exception.toString() );
            }
        }
    }
}

