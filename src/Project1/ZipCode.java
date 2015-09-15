package Project1;

/**
 * Created by kaimou on 9/15/15.
 */

/**
 * This class is a helper class to act as a Hashmap for Zipcode and cyclistInjuries and Injuries.
 *
 */
public class ZipCode {
    private int zip;
    private int numCollisions;
    private int injuriesFatalities;
    private int cyclistsInjured;

    public ZipCode(int zip,int injuries, int cyclists ){
        this.zip = zip;
        injuriesFatalities = injuries;
        cyclistsInjured = cyclists;

    }

    public ZipCode(int zip){
        this.zip = zip;
        numCollisions = 1;
    }

    public int getZip() {
        return zip;
    }

    public int getInjuries(){return injuriesFatalities;}

    public void addCollision(){
        numCollisions++;
    }

    public int getCyclistInjured(){
        return cyclistsInjured;
    }
    public int getNumCollisions(){
        return numCollisions;
    }
}
