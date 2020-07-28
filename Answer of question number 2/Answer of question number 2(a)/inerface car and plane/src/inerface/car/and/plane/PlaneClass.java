
package inerface.car.and.plane;

public class PlaneClass implements  Vehicle{

    @Override
    public int set_num_of_wheels() {
        
        return 8;
    }

    @Override
    public int set_num_of_passengers() {
        
        return 200;
    }

    @Override
    public boolean has_gas() {
        
        return true;
    }
    
}
