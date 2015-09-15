package Project1;

/**
 * This class models a simple Collision object used later in CollisionList to process data.
 */
public class Collision implements Comparable<Collision>{
    private int zipCode;
    private int cyclistsHurt;
    private int injuryAndFatalities;
    private String vehicleType;


    public Collision(int zipcode, int cyclists, int injuryAndFatalities, String vehicle){
        this.zipCode = zipcode;
        this.cyclistsHurt = cyclists;
        this.vehicleType = vehicle;
        this.injuryAndFatalities = injuryAndFatalities;
    }

    public int getZipCode(){
        return zipCode;
    }
    public int getInjuryAndFatalities(){
        return injuryAndFatalities;
    }


    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * Compares to another Collision as to whether or not the number of injuries is greater or less.
     */
    @Override
    public int compareTo(Collision c){
        return Integer.compare(injuryAndFatalities, c.getInjuryAndFatalities());

    }

    public int getCyclistsInjured(){
        return cyclistsHurt;

    }

    public String getVehicleType(){
        return vehicleType;
    }

    public String deathsToString(){
        String result = zipCode+"     "+ injuryAndFatalities +" injuries and fatalities \n";
        return result;

    }

    public String cyclistsToString(){
        String result = zipCode+"     "+ cyclistsHurt +" cyclists hurt \n";
        return result;
    }


}
