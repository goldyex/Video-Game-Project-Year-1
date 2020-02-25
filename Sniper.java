import java.util.Random;

public class Sniper extends Enemy
{
    // instance variables - replace the example below with your own

    public Sniper()
    {
       super(1050,200,90,5);
    }


    /*public int getHeadshot()
    {
        // damage +200 if 20% chance hit
        int GotorNot=0;
        Random rand = new Random();
        int checkTemp=rand.nextInt(100) + 1;
        if (checkTemp<=20){GotorNot=1;}
        return GotorNot;
    }*/
    
    @Override
    public void specialAttack(){
        System.out.println("Enemy is trying to perform a special attack");
    }
}
