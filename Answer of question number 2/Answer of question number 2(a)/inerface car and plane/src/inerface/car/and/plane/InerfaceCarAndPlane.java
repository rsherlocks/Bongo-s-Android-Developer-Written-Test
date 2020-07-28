
package inerface.car.and.plane;



interface  Vehicle{
    int set_num_of_wheels();
    int set_num_of_passengers();
    boolean has_gas();
}


public class InerfaceCarAndPlane{

   
    public static void main(String[] args) {
        // TODO code application logic here
        CarClass carClass=new CarClass();
        PlaneClass planeClass=new PlaneClass();
        
        System.out.println("CarClass Method Return Data which i use Vehicale Interface");
        System.out.println(carClass.set_num_of_wheels());
         System.out.println(carClass.set_num_of_passengers());
         System.out.println(carClass.has_gas());
         System.out.println("PlaneClass Method Return Data which i use Vehicale Interface");
         System.out.println(planeClass.set_num_of_wheels());
         System.out.println(planeClass.set_num_of_passengers());
         System.out.println(planeClass.has_gas());
         

         
    }

    
}
