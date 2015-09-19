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

    /**
     * Returns the zip code.
     * @return
     */
    public int getZip() {
        return zip;
    }

    /**
     * Returns the amount of injuries and fatalities.
     * @return
     */
    public int getInjuries(){return injuriesFatalities;}

    /**
     * Adds injuries on top of injuries/fatalities.
     * @param injuryCount
     */
    public void addInjuries(int injuryCount){
        injuriesFatalities +=injuryCount;

    }

    /**
     * Adds cyclists injuries + fatalities.
     * @param injured
     */
    public void addCyclistInjury(int injured){
        cyclistsInjured+=injured;
    }

    /**
     * Adds a collision on top of the number of collisions.
     */
    public void addCollision(){
        numCollisions++;
    }

    /**
     * Returns the number of cyclists injured.
     * @return
     */
    public int getCyclistsInjured(){
        return cyclistsInjured;
    }

    /**
     * Returns the number of Collisions associated with this zip code.
     * @return
     */
    public int getNumCollisions(){
        return numCollisions;
    }
}
