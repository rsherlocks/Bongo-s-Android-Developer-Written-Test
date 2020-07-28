
package pkgabstract.car.and.plane;


public class CarClass extends Vehicle{

    @Override
    int set_num_of_wheels() {
        return 4;
    }

    @Override
    int set_num_of_passengers() {
        return 10;
    }

    @Override
    boolean has_gas() {
        return true;
    }
    
}
