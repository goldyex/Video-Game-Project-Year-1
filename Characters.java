import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Characters
{
    // instance variables - replace the example below with your own
    private double HP; //characters health
    private double initialHP; //characters health
    private double damage; //how much damage the character does
    private double accuracy; //how likely is the character is to inflict damage
    private double special; //special bonus/moves of the character
    
    
    
    
    /**
     * Constructor for objects of class Characters
     */
    public Characters(double hp, double dmg, double acc, double spcl) 
    {
        // initialise instance variables
        HP = hp;
        initialHP = hp;
        damage= dmg;
        accuracy= acc;
        special= spcl;
        
    }

    //behaviors
    
        public void DamageTaken(int damagetaken)
    {
        HP= HP-damagetaken;
    }
    
    
    
      public void ArmorGain()
    {
        HP= HP+200; //armor has fixed HP bonus
    }
    
     public void HPwaitGain()
    {
        HP= initialHP*1.25; //Adds 25% health to existing health
    }
    
    /*special list: 
     * 1)Warrior
     * 2)Tech
     * 3)Stealth
     * 4)Guard
     * 5)Sniper
     * 6)Elite
     * 7)Isu
     * 8)FinalBoss
     */
     
    //setters
    
    public void setHP(double newHP)
    {
        HP= newHP;
    }
    
    //getters
    public double getHP()
    {
        return HP;
    }
    
        public double getDmg()
    {
        return damage;
    }
    
        public double getAcc()
    {
        return accuracy;
    }
    
     public double getSpcl()
    {
        return special;
    }
}