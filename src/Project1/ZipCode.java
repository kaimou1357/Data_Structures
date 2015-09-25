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
    private int fatalities;
    private int cInjury;
    private int cFatality;

    public ZipCode(int zip,int injury, int fatality,  int cyclistInjury, int cyclistFatality ){
        this.zip = zip;
        injuriesFatalities = injury + fatality;
        cyclistsInjured = cyclistFatality + cyclistInjury;
        cInjury = cyclistInjury;
        cFatality = cyclistFatality;
        this.fatalities = fatality;
        numCollisions = 1;



    }

    /**
     * Return injury for cyclists
     * @return
     */
    public int  getCyclistInjury(){
        return cInjury;
    }

    /**
     * Used to break ties.
     * @return
     */
    public int getCyclistFatality(){
        return cFatality;
    }

    public ZipCode(int zip){
        this.zip = zip;
        numCollisions = 1;
    }

    /**
     * Return fatality for cyclist
     * @return
     */
    public int getFatality(){
        return fatalities;
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
