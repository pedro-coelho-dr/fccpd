public class Main {
    public static void main(String[] args) {
        Armazem amz = new Armazem(300);


        Thread p1 = new Thread(new Produtor(101, 50, 400, amz));
        Thread p2 = new Thread(new Produtor(102, 25, 500, amz));
        Thread p3 = new Thread(new Produtor(103, 20, 600, amz));

        Thread c1 = new Thread(new Consumidor(201, 40, 700, amz));
        Thread c2 = new Thread(new Consumidor(202, 30, 800, amz));


        p1.start();
        //p2.start();
        //p3.start();

        c1.start();
        c2.start();


    }

}