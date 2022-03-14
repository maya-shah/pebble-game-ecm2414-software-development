import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player{

    List<Integer> playerPebbles = new ArrayList<>();
    String name;

    public Player(String name){
        this.name = name;
    }

    // returns the pebbles in the players hand
    public List<Integer> getPebbles(){
        return playerPebbles;
    }
    // getter methods
    public String getName() {return name;}
    // adds a specified pebble into the players hand
    /**
     * Increment a value by delta and return the new value.
     *
     * @param  pebble   the value of the pebble that is being added to the player's hand
     * @return         the value of the pebble that is being added.
     */
    public Integer pebbleAdd(int pebble){
        playerPebbles.add(pebble);
        return pebble;
    }
    // randomly chooses a pebble from the players hand before discarding it
    /**
     * randomly selects a pebble from the players hand before discarding it
     *
     * @param  player   the player that is having a pebble discarded
     * @return         the pebble that is being discarded from the players hand
     */
    public static int pebbleDiscard(Player player){
        Random rand = new Random(); //instance of random class
        int upperbound = player.playerPebbles.size();
        int int_random = rand.nextInt(upperbound); 
        int chosen_pebble = player.playerPebbles.get(int_random);
        player.playerPebbles.remove(int_random);
        return chosen_pebble;
    }
    /**
     * returns the number of pebbles in the players hand
     *
     * @return         the number of pebbles in the players hand
     */
    //returns the number of pebbles in the players hand
    public int pebbleNumber(){
        return playerPebbles.size();
    }
    // returns the total value of all the pebbles in the players hand
    /**
     * loops through all the pebbles in the players hand and adds them all together.
     *
     * @return         the total sum of all of the pebbles in the players hand
     */
    public int playerTotal(){
        int sum = 0;
        for(int j = 0; j < playerPebbles.size(); j++){
            sum += playerPebbles.get(j);
        }
        return sum;
    }
    @Override
    public String toString() {
        return "Pebbles" + playerPebbles;
    }
}