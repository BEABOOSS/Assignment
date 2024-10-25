public class Main{
    public static void main(String[] args){
        Car toyota = new Car("Toyota", "Yaris", 2008);
        Car volvo = new Car("Volvo", "C40", 2023);
        Car chevrolet = new Car("Chevrolet", "Bolt", 2020);

        toyota.start();
        toyota.stop();
        toyota.displayInfo();

        volvo.stop();
        volvo.start();
        volvo.stop();
        volvo.stop();
        volvo.displayInfo();

        chevrolet.stop();
        chevrolet.start();
        chevrolet.start();
        chevrolet.displayInfo();
    }
}