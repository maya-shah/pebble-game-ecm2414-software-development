import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PebbleGame {
    public static void main(String[] args) throws IOException {
        // loading the welcome text into the console
        System.out.println("Welcome to the PebbleGame!!\n" +
                "You will be asked to enter the number of players.\n" +
                "and then for the location of three files in turn containing comma separated\n" +
                "integer values for the pebble weights.\n" +
                "The integer values must be strictly positive.\n" +
                "The game will then be simulated, and output written to files in this directory.\n");
        //getting the number of players from the user
        Scanner userInput = new Scanner(System.in);
        Integer playerNumbers = 0;
        Boolean valid = false;
        String playerInput = "=";
        while (!valid) {
            try {
                System.out.println("Please enter the number of players: ");
                    
                playerInput = userInput.nextLine();
            
                playerNumbers = Integer.parseInt(playerInput);
                valid = true;
                
            } catch (NumberFormatException e) {
                System.out.println(playerInput);
                if (playerInput.equalsIgnoreCase("e")) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid input please enter an Integer");    
                }
            }
        }   
        
 
        
        
        //defining the names of the black and white bags
        List<String> blackBags = Arrays.asList("X","Y","Z");
        ArrayList<Bag> BlackBagArr = new ArrayList<>();
        ArrayList<Bag> WhiteBagArr = new ArrayList<>();
        List<String> whiteBags = Arrays.asList("A","B","C");
       

        Integer current_bag_number = 0;
        //asking user for weight files location
        
        for (String bagName : blackBags) {
            String content = "";
            String bagLocation = "";
            Boolean valid1 = false;
            while (!valid1){
                
            try {
                System.out.println("Please enter location of bag number "+ current_bag_number + " to load:");
                
                bagLocation = userInput.nextLine();
                if (bagLocation.equalsIgnoreCase("e")) {
                    System.exit(0);
                }
                //reading the files that the user provided
                File bag_file = new File(bagLocation);
            
                
                
                //Scanner reader = new Scanner(bag_file);
                FileReader fileReader = new FileReader(bagLocation);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((bagLocation = bufferedReader.readLine()) != null){
                    // getting rid of spaces
                    bagLocation = bagLocation.replaceAll(" ","");
                    // converting the file contents into a string
                    content += bagLocation;
                    //System.out.println(bagLocation);
                
                }
                bufferedReader.close();
                //reader.close();
                valid1 = true;
                current_bag_number++;
                 // parsing the weight data into an integer arraylist
                String[] string_weights = content.split(",");
                ArrayList<Integer> result = new ArrayList<>();
                for (int i = 0; i < string_weights.length; i++) {
                    //adding each weight to final arraylist
                    Integer current_number = Integer.parseInt(string_weights[i]);
                    if (current_number>0) {
                        result.add(current_number);
                    }
                    else{
                        throw new IOException();
                    }


                }
                // creating new black bag object with name and weightings
                BlackBagArr.add(new Bag(bagName, result, playerNumbers));
                
            } catch(FileNotFoundException exc) {
                System.out.println("Unable to open file '" + bagLocation + "'");
            } catch (IOException ex){
                System.out.println("Error reading file '" + bagLocation + "'" + "\nPlease ensure that all Pebbles have a strictly positive weight");
            }       
        }
    }
        userInput.close();

        //instantiating the empty white bags
        for (String string : whiteBags) {
            WhiteBagArr.add(new Bag(string));
        }
        // creating the threads required for the program to run
        if (playerNumbers >=8) {
            System.out.println("running thread 8");
            Thread t8 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        play1.play(BlackBagArr, WhiteBagArr,"player8");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t8.start();
        }
        if (playerNumbers >=7) {
            System.out.println("running thread 7");
            Thread t7 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        play1.play(BlackBagArr, WhiteBagArr,"player7");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t7.start();
        }
        if (playerNumbers >=6) {
            System.out.println("running thread 6");
            Thread t6 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        play1.play(BlackBagArr, WhiteBagArr,"player6");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t6.start();
        }
        if (playerNumbers >=5) {
            System.out.println("running thread 4");
            Thread t5 = new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                    play1.play(BlackBagArr, WhiteBagArr,"player5");
                } catch (IOException e) {
                e.printStackTrace();
                }
                }
                });
            t5.start();
        }
        if (playerNumbers >=4) {
            System.out.println("running thread 4");
            Thread t4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        play1.play(BlackBagArr, WhiteBagArr,"player4");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t4.start();
        }
        if (playerNumbers>=3) {
            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        play1.play(BlackBagArr, WhiteBagArr,"player3");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t3.start();
        }

        if (playerNumbers>=2) {
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                    play1.play(BlackBagArr, WhiteBagArr,"player2");
                } catch (IOException e) {
                e.printStackTrace();
                }
                }
                });
            t2.start();
        }
        if (playerNumbers>=1) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                    play1.play(BlackBagArr, WhiteBagArr,"player1");
                } catch (IOException e) {
                e.printStackTrace();
                }
                }
                });
            t1.start();
        }
    



        }

    public static class play1 {
        public static void play(ArrayList<Bag> BlackBagArr, ArrayList<Bag> WhiteBagArr, String name) throws IOException{
            try {
                File myObj = new File(name + "_status.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }
            }
            catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }

            FileWriter myWriter1 = new FileWriter(name + "_status.txt");
            Player player2 = new Player("player2");
                Random rand = new Random(); //instance of random class
                int upperbound = BlackBagArr.size();
                int selected_bag = rand.nextInt(upperbound); 
                //gets the first 10 rocks

                for (int i = 0; i < 10; i++) {
                    Integer drawn_pebble = player2.pebbleAdd(Bag.drawPebble(BlackBagArr.get(selected_bag)));
                    myWriter1.write("\nplayer has drawn a " + drawn_pebble + " from bag " + BlackBagArr.get(selected_bag).getName());
                    myWriter1.write("\nCurrent hand is " + player2.getPebbles());
                }
                double sum = 0;
                boolean finished = false;
                selected_bag = rand.nextInt(upperbound); 
                Bag selectBag;
                while (!finished) {


                    
                    if (sum == 100) {
                        //win condition
                        System.out.println(name + " has won");
                       finished = true;

                    } else {
                        //discarding the pebble from the players hand into a white bag
                        Integer discarded_pebble = WhiteBagArr.get(selected_bag).discardPebble(Player.pebbleDiscard(player2));
                        myWriter1.write("\nplayer has discarded a "+ discarded_pebble +" to bag "+ WhiteBagArr.get(selected_bag).getName());
                        myWriter1.write("\nCurrent hand is " + player2.getPebbles());
    
                        //choosing a new bag to select from by changing random number
                        selected_bag = rand.nextInt(upperbound); 
                        selectBag = BlackBagArr.get(selected_bag);
                        //checking if the selected bag is empty
                        if (selectBag.bagSize() == 0) {
                            for (int i = 0; i < BlackBagArr.size(); i++) {
                                if (BlackBagArr.get(i).bagSize() == 0) {
                                   //refilling the black bag with its corresponding white bag
                                    Bag.bagRefill(WhiteBagArr.get(i), BlackBagArr.get(i));
                                }
                                
                            }
                        }

    
                        try {
                            //draws a pebble from the bag into player hand
                            Integer drawn_pebble = player2.pebbleAdd(Bag.drawPebble(BlackBagArr.get(selected_bag)));
                            myWriter1.write("\nplayer has drawn a " + drawn_pebble + " from bag " + BlackBagArr.get(selected_bag).getName());
                            myWriter1.write("\nCurrent hand is " + player2.getPebbles());
    
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error Occurred");
                            System.out.println(BlackBagArr.get(selected_bag).getPebbles());
                            System.out.println("Number of pebbles in the players hand " + player2.pebbleNumber());
    
                        }
    
    
                        //calculates the total player sum
                        sum = player2.playerTotal();
                    }
                }
                System.exit(0);
                myWriter1.close();



        }
        
    }

}




