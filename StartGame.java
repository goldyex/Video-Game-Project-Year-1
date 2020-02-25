import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class StartGame extends JFrame {
    //Use of global variable to constantly update what happens to the GUI inteerface 
    public static String  APCtxt="";

    public static void main (String args[]) throws IOException{
    System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try{
                List<Double> InfoSheet = new ArrayList<Double>();
                BufferedReader inputStream = new BufferedReader(new FileReader("D:/Downloads_D/InfoSheet.txt"));
                    for(int a=0; a<40; a++)
                    {
                        InfoSheet.add(Double.parseDouble(inputStream.readLine()));
                    }
                Assassins WarriorGUI = new Warrior(InfoSheet.get(0),InfoSheet.get(1),InfoSheet.get(2),InfoSheet.get(3),InfoSheet.get(4),InfoSheet.get(5)); 
                Assassins TechGui = new Tech(InfoSheet.get(6),InfoSheet.get(7),InfoSheet.get(8),InfoSheet.get(9),InfoSheet.get(10),InfoSheet.get(11)); 
                Assassins StealthGUI = new Silent(InfoSheet.get(12),InfoSheet.get(13),InfoSheet.get(14),InfoSheet.get(15),InfoSheet.get(16),InfoSheet.get(17)); 
                new GUI_project(WarriorGUI,TechGui,StealthGUI,"",true);
                
              
            }
            catch(IOException ex){
                System.out.println (ex.toString());
                System.out.println("Could not find character file, PROGRAM SHUTS DOWN");
            }
            
        
            
            }
        });
    
    javax.swing.SwingUtilities.invokeLater(new Runnable(){
        public void run(){new ScenarioDisplay();}
        
    });
    Start();
    }//end of main
    
    public static void Start() throws IOException{
    
    //Create a list with the playable character information    
        List<Double> InfoSheet = new ArrayList<Double>();
        BufferedReader inputStream = new BufferedReader(new FileReader("D:/Downloads_D/InfoSheet.txt"));
    
        for(int a=0; a<40; a++)
        {
            InfoSheet.add(Double.parseDouble(inputStream.readLine()));
        }
        

    int CharacterChoice=0;
    System.out.println("////////////////////START////////////////////");
    System.out.println("\nWelcome to my game, please choose a character:");
    System.out.println("\nPlease look at the pop up screen for the characters and their statistics");
    System.out.println("\nWhen you are ready, type the name of the character you want to play as");
    
    
    Scanner sc = new Scanner (System.in);
    
    String ans = sc.nextLine();
    
    if (ans.equals("Enzo")){
        
        CharacterChoice=1;
        System.out.println("\nYou chose Enzo!");
    }
    else if (ans.equals ("Roberto")){
        
        CharacterChoice=2;
        System.out.println("\nYou chose Roberto!");
    } else if (ans.equals("Hibana")){
        
        CharacterChoice=3;
        System.out.println("\nYou chose Hibana!");
    } else {
    System.out.println("\nYou didnt choose any valid character so I assume you dont want to play");
    System.exit(0);
    }
    System.out.println("\nOk, you start outside an Abstergo facility. It is dark and seems to be lifeless. You have 2 choices: \n 1)Climb to roof \n 2)Go through the main entrance \n Type the number of your choice");
    
    int ansScenario1 = sc.nextInt();
    if (ansScenario1== 1){
        
    //creates a user     
    if (CharacterChoice==1){Assassins User = new Warrior(InfoSheet.get(0),InfoSheet.get(1),InfoSheet.get(2),InfoSheet.get(3),InfoSheet.get(4),InfoSheet.get(5)); Roof(User);}
    else if (CharacterChoice==2){Assassins User = new Tech(InfoSheet.get(6),InfoSheet.get(7),InfoSheet.get(8),InfoSheet.get(9),InfoSheet.get(10),InfoSheet.get(11)); Roof(User);}
    else if (CharacterChoice==3){Assassins User = new Silent(InfoSheet.get(12),InfoSheet.get(13),InfoSheet.get(14),InfoSheet.get(15),InfoSheet.get(16),InfoSheet.get(17)); Roof(User);}
    
    }
     
    else if (ansScenario1==2){
        if (CharacterChoice==1){Assassins User = new Warrior(InfoSheet.get(0),InfoSheet.get(1),InfoSheet.get(2),InfoSheet.get(3),InfoSheet.get(4),InfoSheet.get(5)); Entrance(User);}
    else if (CharacterChoice==2){Assassins User = new Tech(InfoSheet.get(6),InfoSheet.get(7),InfoSheet.get(8),InfoSheet.get(9),InfoSheet.get(10),InfoSheet.get(11)); Entrance(User);}
    else if (CharacterChoice==3){Assassins User = new Silent(InfoSheet.get(12),InfoSheet.get(13),InfoSheet.get(14),InfoSheet.get(15),InfoSheet.get(16),InfoSheet.get(17)); Entrance(User);}
    } 
    else{
    System.out.println("\nYou are trying to break the game, this wont work, bye");
    System.exit(0);}
    
    
    
    
    
    }//end method Start

    
    public static void Roof(Assassins User2){
    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/RoofBig.jpg";
    Enemy enemyGeneric = new Sniper(); //polymorphism (sub principle) is used here. This is beacuase this "scenario" will be copy pasted a few times, just with a different enemy.  
    //I wont have to change anything excpet the Sniper() to a different subclass of enemy! Name of every enemy is just enemyGeneric;
    
    Random rand = new Random();
    int EnemyChoice;
    Scanner sc = new Scanner(System.in);
    int enemyCount=1;
    double HPtempSniper=enemyGeneric.getHP();
    double HPtempUser=User2.getHP();
    int specialAttackUsed=0;
    double SpecialDamage=0;
    
    //SETTING SPECIAL ATTACK VALUES
    List<Double> AssassinSpecialDamageSetter = new ArrayList<Double>(); //a list is used if in the future I want to add characters
    AssassinSpecialDamageSetter.add(1.5);
    AssassinSpecialDamageSetter.add(1.7);
    AssassinSpecialDamageSetter.add(2.2);
    if(User2.getSpcl()==1){SpecialDamage=AssassinSpecialDamageSetter.get(0);} 
    else if(User2.getSpcl()==2){SpecialDamage=AssassinSpecialDamageSetter.get(1);} 
    else if(User2.getSpcl()==3){SpecialDamage=AssassinSpecialDamageSetter.get(2);}
    
    
    //SETTING ITEMS
    int hasHealthPack=0;
    int hasBomb=0;
    
    
    
    
    
    
    
    //start scenario
    StartGame.APCtxt= StartGame.APCtxt+" \nYou climb to the roof";
    System.out.println("\nYou climbed on the roof successfuly. You notice a sniper aiming straight at you!. Prepare to fight!");
    //GuiUpdate("\nYou climbed on the roof successfuly. You notice a sniper aiming straight at you!. Prepare to fight!");
    //GUI_project(User2,User2,User2,"UPDATED",false);
    
    //start fight
    while (User2.getHP() >0 && enemyCount>0){
        
        //User Turn
        
        System.out.println("\nChoose: \n 1)Fight using weapon \n 2)Use Special \n 3)Use Item");
       // stopForText();
        int ans = sc.nextInt();
        if (ans ==1){
            //receieve damage
            HPtempSniper= enemyGeneric.getHP()-User2.getDmg();
            System.out.println("\nYou damaged the enemy with "+ User2.getDmg() + " Health points!");
            enemyGeneric.setHP(HPtempSniper);
            StartGame.APCtxt= StartGame.APCtxt+" \nYou damaged the enemy with "+ User2.getDmg() + " Health points! ";
            
            if (enemyGeneric.getHP() >0){
            System.out.println("\nSniper now has " + enemyGeneric.getHP() + " Health Points!");}
            else {
                System.out.println("\nSniper is DEAD!");
                StartGame.APCtxt= StartGame.APCtxt+" \nSniper is dead";
                enemyCount=0;
                }
            } //end normal attack 
            
            else if (ans ==2){
                    if (specialAttackUsed==0){
                        HPtempSniper= enemyGeneric.getHP()-(User2.getDmg()*SpecialDamage);
                        System.out.println("\nYou used your special attack! \nThis caused the sniper to receive " + User2.getDmg()*SpecialDamage +" Health Points!");
                        specialAttackUsed++; //MAKE SURE A SPECIAL ATTACK HAS ONLY BEEN USED ONCE
                        enemyGeneric.setHP(HPtempSniper);
                        StartGame.APCtxt= StartGame.APCtxt+"\nYou used your special attack! \nThis caused the sniper to receive " + User2.getDmg()*SpecialDamage +" Health Points!";
                        if (enemyGeneric.getHP() >0){
                        System.out.println("\nSniper now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nSniper is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+" \nSniper is dead";
                            enemyCount=0;
                            }
                    } else {System.out.println("\nSorry but you used your special atttack already! \nSniper's Turn!");}
     
            } //end special attack 
            
            
            else if (ans ==3){
                System.out.println("\nYou chose to use an Item! \nWhich Item would you want to use?"); //ITEM IS USED
                User2.printStorage();
                if (User2.getCapacity()==0){System.out.println("Becuase you have nothing, your turn is skipped");}
                else{
                System.out.println("\nType H for HealthPack \nB for Smoke Bomb");
                String specialItemAnswer=sc.nextLine();
                if (specialItemAnswer.equals("H") && hasHealthPack==1){
                    User2.setHP(User2.getHP()+500); //HEALTH PACK USED
                    StartGame.APCtxt= StartGame.APCtxt+" \nUsed Health Pack";
                    System.out.println("\nYou now have " + User2.getHP() + " Health Points!");
                } else if (specialItemAnswer.equals("B") && hasBomb==1){
                    enemyGeneric.setHP(HPtempSniper-500);
                    if (enemyGeneric.getHP() >0){
                        System.out.println("\nSniper now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nSniper is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+" \nSniper is dead!";
                            enemyCount=0;
                            }
                }
                }
            } //end USE ITEM
            
        //Enemy Turn
        if(enemyCount!=0){
            EnemyChoice = rand.nextInt(2) + 1; //ENEMY AI CHOOSES RANDOMLY WHAT TO DO
            if (EnemyChoice ==1){
                //receieve damage
                HPtempUser= User2.getHP()-enemyGeneric.getDmg();
                System.out.println("\nThe sniper damaged you with "+ enemyGeneric.getDmg() + " Health points!");
                StartGame.APCtxt= StartGame.APCtxt+" \nThe sniper damaged you with "+ enemyGeneric.getDmg() + " Health points!";
                User2.setHP(HPtempUser);
                
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+" \nYOU ARE DEAD";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                } //end normal attack 
                else if (EnemyChoice ==2){
                enemyGeneric.specialAttack();
                int Headshot=0;
                Headshot= enemyGeneric.getHeadshot();
                
                if(Headshot==1){
                System.out.println("\nEnemy has succeeded with the headshot!");
                StartGame.APCtxt= StartGame.APCtxt+" \nEnemy headshot you!";
                HPtempUser= User2.getHP()-(enemyGeneric.getDmg()+200);
                System.out.println("\nThe sniper damaged you with "+ (enemyGeneric.getDmg()+200) + " Health points!");
                User2.setHP(HPtempUser);
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+" \nYOU ARE DEAD";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                }
                else{System.out.println("\nEnemy missed! You did not take any damage!");}
                } //end special attack 
                
        }

        
        
    } //end fight sequence 
    specialAttackUsed=0;
    //PICKING UP A HEALTH PACK ITEM
    if(User2.getHP()>0){System.out.println("\nYou survived the fight! \nAfter searching the rooftop you found a healthpack!, Do you want to pick it up? (Y/N)");
    StartGame.APCtxt= StartGame.APCtxt+"\nYOU survived the fight!";
    Scanner sc1 = new Scanner(System.in);
    String ans= sc1.nextLine();
    if (ans.equals("Y") && (User2.getCapacity()<=User2.getMaxCapacity())){
        User2.setCapacity(1,0);
        System.out.println("\nYou picked up the Health Pack!");
        StartGame.APCtxt= StartGame.APCtxt+" \nYou picked up the Health Pack!";
        System.out.println("\nMoving on");
    } else if (ans.equals("Y") && (User2.getCapacity()==User2.getMaxCapacity())){
        System.out.println("\nSorry but you are carrying too many items!");
        System.out.println("\nMoving on");
    } else{
    System.out.println("\nMoving on");
    }}
    

    Lobby(User2); //moves to next level
    }// end method Roof 
    
    
    //***************************************************************************************************************************************************//
    
    //method of room Entrance
    public static void Entrance(Assassins User2){
    Enemy enemyGeneric = new Guard(); //polymorphism (sub principle) is used here. This is beacuase this "scenario" will be copy pasted a few times, just with a different enemy.  
    //This time the enemy is not a sniper but a guard
    
    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/EntranceBig.jpg";
    Random rand = new Random();
    int EnemyChoice;
    Scanner sc = new Scanner(System.in);
    int enemyCount=1;
    double HPtempSniper=enemyGeneric.getHP();
    double HPtempUser=User2.getHP();
    int specialAttackUsed=0;
    double SpecialDamage=0;
    
    //SETTING SPECIAL ATTACK VALUES
    List<Double> AssassinSpecialDamageSetter = new ArrayList<Double>(); //a list is used if in the future I want to add characters
    AssassinSpecialDamageSetter.add(1.5);
    AssassinSpecialDamageSetter.add(1.7);
    AssassinSpecialDamageSetter.add(2.2);
    if(User2.getSpcl()==1){SpecialDamage=AssassinSpecialDamageSetter.get(0);} 
    else if(User2.getSpcl()==2){SpecialDamage=AssassinSpecialDamageSetter.get(1);} 
    else if(User2.getSpcl()==3){SpecialDamage=AssassinSpecialDamageSetter.get(2);}
    
    
    //SETTING ITEMS
    int hasHealthPack=0;
    int hasBomb=0;
    
    
    //start scenario 
    StartGame.APCtxt= StartGame.APCtxt+" \nYou are in the entrance";
    System.out.println("\nYou walked to the entrance and you see a guard patrolling. The guard takes out his flashlight and spots you!. Prepare to fight!");
    
    
    //start fight
    while (User2.getHP() >0 && enemyCount>0){
        
        //User Turn
        
        System.out.println("\nChoose: \n 1)Fight using weapon \n 2)Use Special \n 3)Use Item");
        int ans = sc.nextInt();
        if (ans ==1){
            //receieve damage
            HPtempSniper= enemyGeneric.getHP()-User2.getDmg();
            System.out.println("\nYou damaged the enemy with "+ User2.getDmg() + " Health points!");
            StartGame.APCtxt= StartGame.APCtxt+"\nYou damaged the enemy with "+ User2.getDmg() + " Health points!";
            enemyGeneric.setHP(HPtempSniper);
            
            if (enemyGeneric.getHP() >0){
            System.out.println("\nGuard now has " + enemyGeneric.getHP() + " Health Points!");}
            else {
                System.out.println("\nGuard is DEAD!");
                StartGame.APCtxt= StartGame.APCtxt+"\nGuard is DEAD!";
                enemyCount=0;
                }
            } //end normal attack 
            
            else if (ans ==2){
                    if (specialAttackUsed==0){
                        HPtempSniper= enemyGeneric.getHP()-(User2.getDmg()*SpecialDamage);
                        System.out.println("\nYou used your special attack! \nThis caused the Guard to receive " + User2.getDmg()*SpecialDamage +" Health Points!");
                        StartGame.APCtxt= StartGame.APCtxt+"\nYou used your special attack! \nThis caused the Guard to receive " + User2.getDmg()*SpecialDamage +" Health Points!";
                        specialAttackUsed++; //MAKE SURE A SPECIAL ATTACK HAS ONLY BEEN USED ONCE
                        enemyGeneric.setHP(HPtempSniper);
                        if (enemyGeneric.getHP() >0){
                        System.out.println("\nGuard now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nGuard is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+"\nGuard is DEAD!";
                            enemyCount=0;
                            }
                    } else {System.out.println("\nSorry but you used your special atttack already! \nGuard's Turn!");}
     
            } //end special attack 
            
            
            else if (ans ==3){
                System.out.println("\nYou chose to use an Item! \nWhich Item would you want to use?"); //ITEM IS USED
                User2.printStorage();
                if (User2.getCapacity()==0){System.out.println("Becuase you have nothing, your turn is skipped");}
                else{
                System.out.println("\nType H for HealthPack \nB for Smoke Bomb");
                String specialItemAnswer=sc.nextLine();
                if (specialItemAnswer.equals("H") && hasHealthPack==1){
                    User2.setHP(User2.getHP()+500); //HEALTH PACK USED
                    StartGame.APCtxt= StartGame.APCtxt+"\nUsed Health Pack";
                    System.out.println("\nYou now have " + User2.getHP() + " Health Points!");
                } else if (specialItemAnswer.equals("B") && hasBomb==1){
                    enemyGeneric.setHP(HPtempSniper-500);
                    if (enemyGeneric.getHP() >0){
                        System.out.println("\nGuard now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nGuard is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+"\nGuard is DEAD!";
                            enemyCount=0;
                            }
                }
                }
            } //end USE ITEM
            
        //Enemy Turn
        if(enemyCount!=0){
            EnemyChoice = rand.nextInt(2) + 1; //ENEMY AI CHOOSES RANDOMLY WHAT TO DO
            if (EnemyChoice ==1){
                //receieve damage
                HPtempUser= User2.getHP()-enemyGeneric.getDmg();
                System.out.println("\nThe Guard damaged you with "+ enemyGeneric.getDmg() + " Health points!");
                StartGame.APCtxt= StartGame.APCtxt+"\nThe Guard damaged you with "+ enemyGeneric.getDmg() + " Health points!";
                User2.setHP(HPtempUser);
                
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+"\nYOU ARE DEAD!";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                } //end normal attack 
                else if (EnemyChoice ==2){
                enemyGeneric.specialAttack();
                int Headshot=0;
                Headshot= enemyGeneric.getHeadshot();
                
                if(Headshot==1){
                System.out.println("\nEnemy has succeeded with the headshot!");
                HPtempUser= User2.getHP()-(enemyGeneric.getDmg()+200);
                StartGame.APCtxt= StartGame.APCtxt+"\nEnemy has succeeded with the headshot!";
                System.out.println("\nThe Guard damaged you with "+ (enemyGeneric.getDmg()+200) + " Health points!");
                StartGame.APCtxt= StartGame.APCtxt+"\nThe Guard damaged you with "+ (enemyGeneric.getDmg()+200) + " Health points!";
                User2.setHP(HPtempUser);
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+"\nYOU ARE DEAD!";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                }
                else{System.out.println("\nEnemy missed! You did not take any damage!");}
                } //end special attack 
                
        }

        
        
    } //end fight sequence 
    specialAttackUsed=0;
    //PICKING UP A BOMB
    if(User2.getHP()>0){System.out.println("\nYou survived the fight! \nAfter searching around the entrance you found a smoke bomb next to a dead guard!, Do you want to pick it up? (Y/N)");
    StartGame.APCtxt= StartGame.APCtxt+"\nYOU survived the fight!";
    Scanner sc1 = new Scanner(System.in);
    String ans= sc1.nextLine();
    if (ans.equals("Y") && (User2.getCapacity()<=User2.getMaxCapacity())){
        User2.setCapacity(0,1);
        System.out.println("\nYou picked up the Smoke Bomb!");
        StartGame.APCtxt= StartGame.APCtxt+"\nYou picked up the Smoke Bomb!";
        System.out.println("\nMoving on");
    } else if (ans.equals("Y") && (User2.getCapacity()==User2.getMaxCapacity())){
        System.out.println("\nSorry but you are carrying too many items!");
        System.out.println("\nMoving on");
    } else{
    System.out.println("\nMoving on");
    }}
    Lobby(User2); //moves to next level
    } //end of Entrance
    
    
    //**********************************************************************************************************************************
    public static void Lobby(Assassins User2){
    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Lobby.jpg"; 
    Boss enemyGeneric = new FinalBoss(); //polymorphism (sub principle) is used here. This is beacuase this "scenario" will be copy pasted a few times, just with a different enemy.  
    //I wont have to change anything excpet the Sniper() to a different subclass of enemy! Name of every enemy is just enemyGeneric;
    
    Random rand = new Random();
    int EnemyChoice;
    Scanner sc = new Scanner(System.in);
    int enemyCount=1;
    double HPtempSniper=enemyGeneric.getHP();
    double HPtempUser=User2.getHP();
    int specialAttackUsed=0;
    double SpecialDamage=0;
    
    //SETTING SPECIAL ATTACK VALUES
    List<Double> AssassinSpecialDamageSetter = new ArrayList<Double>(); //a list is used if in the future I want to add characters
    AssassinSpecialDamageSetter.add(1.5);
    AssassinSpecialDamageSetter.add(1.7);
    AssassinSpecialDamageSetter.add(2.2);
    if(User2.getSpcl()==1){SpecialDamage=AssassinSpecialDamageSetter.get(0);} 
    else if(User2.getSpcl()==2){SpecialDamage=AssassinSpecialDamageSetter.get(1);} 
    else if(User2.getSpcl()==3){SpecialDamage=AssassinSpecialDamageSetter.get(2);}
    
    
    //SETTING ITEMS
    int hasHealthPack=User2.getHealthPack();
    int hasBomb=User2.getSmokeBomb();
    
    
    
    
    
    
    
    //start scenario
    StartGame.APCtxt= StartGame.APCtxt+" \nYou entered the lobby";
    StartGame.APCtxt= StartGame.APCtxt+" \nBoss fight started";
    System.out.println("\nYou entered Abstergo's lobby. You notice a huge mercenery!. This is a boss fight!! Prepare to fight!");

    
    //start fight
    while (User2.getHP() >0 && enemyCount>0){
        
        //User Turn
        
        System.out.println("\nChoose: \n 1)Fight using weapon \n 2)Use Special \n 3)Use Item");

        int ans = sc.nextInt();
        if (ans ==1){
            //receieve damage
            HPtempSniper= enemyGeneric.getHP()-User2.getDmg();
            System.out.println("\nYou damaged the enemy with "+ User2.getDmg() + " Health points!");
            enemyGeneric.setHP(HPtempSniper);
            StartGame.APCtxt= StartGame.APCtxt+" \nYou damaged the enemy with "+ User2.getDmg() + " Health points! ";
            
            if (enemyGeneric.getHP() >0){
            System.out.println("\nFinal Boss now has " + enemyGeneric.getHP() + " Health Points!");}
            else {
                System.out.println("\nFinal Boss is DEAD!");
                StartGame.APCtxt= StartGame.APCtxt+" \nFinal Boss is dead";
                enemyCount=0;
                }
            } //end normal attack 
            
            else if (ans ==2){
                    if (specialAttackUsed==0){
                        HPtempSniper= enemyGeneric.getHP()-(User2.getDmg()*SpecialDamage);
                        System.out.println("\nYou used your special attack! \nThis caused the Final Boss to receive " + User2.getDmg()*SpecialDamage +" Health Points!");
                        specialAttackUsed++; //MAKE SURE A SPECIAL ATTACK HAS ONLY BEEN USED ONCE
                        enemyGeneric.setHP(HPtempSniper);
                        StartGame.APCtxt= StartGame.APCtxt+"\nYou used your special attack! \nThis caused the Final Boss to receive " + User2.getDmg()*SpecialDamage +" Health Points!";
                        if (enemyGeneric.getHP() >0){
                        System.out.println("\nFinal Boss now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nFinal Boss is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+" \nFinal Boss is dead";
                            enemyCount=0;
                            }
                    } else {System.out.println("\nSorry but you used your special atttack already! \nFinal Boss's Turn!");}
     
            } //end special attack 
            
            
            else if (ans ==3){
                System.out.println("\nYou chose to use an Item! \nWhich Item would you want to use?"); //ITEM IS USED
                User2.printStorage();
                if (User2.getCapacity()==0){System.out.println("Becuase you have nothing, your turn is skipped");}
                else{
                System.out.println("\nType H for HealthPack \nB for Smoke Bomb");
                Scanner sc1= new Scanner(System.in);
                String ChooseItem=sc1.nextLine();
                String specialItemAnswer=ChooseItem;

                if (specialItemAnswer.equals("H") && hasHealthPack==1){
                    User2.setHP(User2.getHP()+500); //HEALTH PACK USED
                    StartGame.APCtxt= StartGame.APCtxt+" \nUsed Health Pack";
                    System.out.println("\nYou now have " + User2.getHP() + " Health Points!");
                } else if (specialItemAnswer.equals("B") && hasBomb==1){
                    enemyGeneric.setHP(HPtempSniper-500);
                    if (enemyGeneric.getHP() >0){
                        System.out.println("\nFinal Boss now has " + enemyGeneric.getHP() + " Health Points!");}
                        else {
                            System.out.println("\nFinal Boss is DEAD!");
                            StartGame.APCtxt= StartGame.APCtxt+" \nFinal Boss is dead!";
                            enemyCount=0;
                            }
                }
                }
            } //end USE ITEM
            
        //Enemy Turn
        if(enemyCount!=0){
            EnemyChoice = rand.nextInt(2) + 1; //ENEMY AI CHOOSES RANDOMLY WHAT TO DO
            if (EnemyChoice ==1){
                //receieve damage
                HPtempUser= User2.getHP()-enemyGeneric.getDmg();
                System.out.println("\nThe Final Boss damaged you with "+ enemyGeneric.getDmg() + " Health points!");
                StartGame.APCtxt= StartGame.APCtxt+" \nThe Final Boss damaged you with "+ enemyGeneric.getDmg() + " Health points!";
                User2.setHP(HPtempUser);
                
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+" \nYOU ARE DEAD";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                } //end normal attack 
                else if (EnemyChoice ==2){
                enemyGeneric.specialAttack();
                int Headshot=0;
                Headshot= enemyGeneric.getHeadshot();
                
                if(Headshot==1){
                System.out.println("\nEnemy hit you with his spear!");
                StartGame.APCtxt= StartGame.APCtxt+" \nEnemy hit you with his spear!";
                HPtempUser= User2.getHP()-(enemyGeneric.getDmg()+500);
                System.out.println("\nThe Final Boss damaged you with "+ (enemyGeneric.getDmg()+500) + " Health points!");
                User2.setHP(HPtempUser);
                if (User2.getHP() >0){
                System.out.println("\nYou now have " + User2.getHP() + " Health Points!");} //IF USER IS NOT DEAD
                else {
                    System.out.println("\nYOU ARE DEAD!");
                    StartGame.APCtxt= StartGame.APCtxt+" \nYOU ARE DEAD";
                    User2.setHP(0);
                    ScenarioDisplay.imgLocation= "D:/Idan/OOPcodes/Photos/Dead.jpg";
                    }
                }
                else{System.out.println("\nEnemy missed! You did not take any damage!");}
                } //end special attack 
                
        }

        
        
    } //end fight sequence 
    specialAttackUsed=0;
    //PICKING UP A HEALTH PACK ITEM
    if(User2.getHP()>0){System.out.println("\nYou survived the fight! \nAfter searching the lobby you found another healthpack!, Do you want to pick it up? (Y/N)");
    StartGame.APCtxt= StartGame.APCtxt+"\nYOU survived the fight!";
    Scanner sc1 = new Scanner(System.in);
    String ans= sc1.nextLine();
    if (ans.equals("Y") && (User2.getCapacity()<=User2.getMaxCapacity())){
        User2.setCapacity(1,0);
        System.out.println("\nYou picked up the Health Pack!");
        StartGame.APCtxt= StartGame.APCtxt+" \nYou picked up the Health Pack!";
        System.out.println("\nMoving on");
    } else if (ans.equals("Y") && (User2.getCapacity()==User2.getMaxCapacity())){
        System.out.println("\nSorry but you are carrying too many items!");
        System.out.println("\nMoving on");
    } else{
    System.out.println("\nMoving on");
    }}
    
    System.out.println("This is the end of the game, Hope you had fun!");

    }// end method Lobby 
    
    
    //***************************************************************************************************************************************************//
    
    
}
