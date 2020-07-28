
package pkgabstract.car.and.plane;


public class PlaneClass extends Vehicle {

    @Override
    int set_num_of_wheels() {
       return 8;
    }

    @Override
    int set_num_of_passengers() {
        
        return 40;
    }

    @Override
    boolean has_gas() {
        return true;
    }
    
}
