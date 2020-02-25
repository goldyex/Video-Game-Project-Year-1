public class Silent extends Assassins
{
    // instance variables - replace the example below with your own
  
    /**
     * Constructor for objects of class Silent
     */
    public Silent()
    {
        super(400,100,70,3,1,40);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }
    
    /**
     * Imported data file Constructor for objects of class Silent
     */
    public Silent(double hp, double dmg, double acc, double spcl, double storage, double evadechance)
    {
        super(hp,dmg,acc,spcl,storage,evadechance);
        //ouble hp, double dmg, double acc, int spcl, int strg, int evade
    }
    
}