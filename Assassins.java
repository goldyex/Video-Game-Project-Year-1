
public class Assassins extends Characters
{
    // instance variables - replace the example below with your own
    private double MaxstorageCapacity;
    private double storageCapacity;
    private double CanEvade;
    int hasHealthPack=0;
    int hasBomb=0;
    /**
     * Constructor for objects of class Assassins
     */
    public Assassins(double hp, double dmg, double acc, double spcl, double strg, double evade)
    {
        super(hp,dmg,acc,spcl);
        MaxstorageCapacity=strg; 
        storageCapacity=0;
        CanEvade= evade; 
    }
    
    public void printStorage(){
        if (hasHealthPack==1 && hasBomb==0){System.out.println("You have a health pack (+500 Health points)");}
        else if (hasHealthPack==0 && hasBomb==1){System.out.println("You have a smoke bomb (500 damage to enemy)");}
        else if (hasHealthPack==1 && hasBomb==1){System.out.println("You have a health pack (+500 Health points) or a smoke bomb (500 damage to enemy)");}
        else {System.out.println("You have nothing!");}
    }

    
    public void setCapacity(int healthpack, int bomb)
    {
        if(getCapacity()<=getMaxCapacity()){
            storageCapacity++;
            if(healthpack==1){hasHealthPack++;}
            else{hasBomb++;}

        }
    }
    
    
    //getters
    public double getMaxCapacity()
    {
        return MaxstorageCapacity;
    }
    
    public double getCapacity()
    {
        return storageCapacity;
    }
    
    public double getEvadeChance()
    {
        return CanEvade;
    }
    
    public int getHealthPack()
    {
        return hasHealthPack;
    }
    
    public int getSmokeBomb()
    {
        return hasBomb;
    }
}