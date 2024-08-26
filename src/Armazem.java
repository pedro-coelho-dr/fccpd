public class Armazem {
    private int estoque;
    private int capMax;

    public Armazem(int cap) {
        estoque = 0;
        capMax = cap;
    }

    public synchronized int retirar(int consumo, int codigo) {
        while (estoque < consumo) {
            try {
                System.out.println("   *** Armazem sem estoque! CONSUMIDOR " + codigo + " aguardando... ***");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        estoque -= consumo;
        System.out.println("   ARMAZEM(saida) -> CONSUMIDOR " + codigo + " consumiu " + consumo + " Estoque Atual: " + estoque + " sacas");
        notifyAll();
        return 1;
    }

    public synchronized int armazenar (int qtd, int codigo) {
        while (estoque + qtd > capMax) {
            try {
                System.out.println("   *** Armazem em capacidade máxima! PRODUTOR " + codigo + " aguardando... ***");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        estoque += qtd;
        System.out.println("   ARMAZEM(entrada) -> PRODUTOR " + codigo + " depositou " + qtd + " Estoque Atual: " + estoque + " sacas");
        notifyAll();
        return 1;
    }
}
