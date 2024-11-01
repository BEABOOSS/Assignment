public class Car {
    String Manufacturer;
    String Model;
    int Year;
    boolean isRunning = false;

    Car(String manufacturer, String model, int year){
        Manufacturer = manufacturer;
        Model = model;
        Year = year;
    }
    public void start(){
        if(isRunning()){
            System.out.printf("Car is already running.%n");
        } else {
            isRunning = true;
        }
    }
    public void stop(){
        if(!isRunning()){
            System.out.printf("Car is already stop.%n");
        } else {
            isRunning = false;
        }
    }
    public boolean isRunning(){
        return isRunning;
    }
    public void displayInfo(){
        System.out.printf("%nManufacturer: %1$s%nModel: %2$s%nYear: %3$d%nIs the car running: %4$s%n", Manufacturer, Model, Year, isRunning());
    }
}