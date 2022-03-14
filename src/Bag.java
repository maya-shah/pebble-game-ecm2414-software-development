import java.util.ArrayList;
import java.util.Random;

public class Bag {
    private String name;
    private ArrayList<Integer> pebbles = new ArrayList<>();
    
    // getter methods
    public ArrayList<Integer> getPebbles() {
        return pebbles;
    }
    public String getName() {
        return name;
    }

    //bag constructor for white bag
    public Bag(String name){
        this.name = name;
    }
    /**
     *overloaded constructor for black bag,
     *takes the possible weights from input file and randomly selects the required amount
     * constructs a new bag object and randomly selects a certain number of pebbles from the possible pebble weights
     *
     * @param  name   the name of the bag
     * @param weights the arraylist of the possible weights of the pebbles
     * @param playerNum the number of players in the game, decided the number of pebbles in each bag
     * @return         the pebble that is being discarded from the players hand
     */
    public Bag(String name,ArrayList<Integer> weights,Integer playerNum){
        this.name = name;
        int pebbleNum = playerNum * 20;
        Random rand = new Random(); //instance of random class
        int upperbound = weights.size();
        for (int i = 0; i < pebbleNum; i++) {
            int int_random = rand.nextInt(upperbound); 
            this.pebbles.add(weights.get(int_random));
        }
        
    }
    // draws a random pebble from the bag and returns the value of the pebble
    public synchronized static Integer drawPebble(Bag selected_bag){
        Random rand = new Random(); //instance of random class
        int upperbound = selected_bag.pebbles.size();
        int int_random = rand.nextInt(upperbound); 
        int chosen_pebble = selected_bag.pebbles.get(int_random);
        selected_bag.pebbles.remove(int_random);
        return chosen_pebble;
    }
    // adds a discarded pebble into a white bag
    public synchronized Integer discardPebble(Integer pebble){
        pebbles.add(pebble);
        return pebble;
    }
    //returns the number of pebbles in the bag
    public int bagSize(){
        return pebbles.size();
    }
    //
    /**
     * refills a black bag with the contents of a white bag
     *
     * @param whiteBag   the bag that is currently full and is being emptied
     * @param blackBag   the bag that is being refilled with the white bag, was empty
     */
    public static void bagRefill(Bag whiteBag, Bag blackBag){
        blackBag.pebbles.addAll(whiteBag.pebbles);
        whiteBag.pebbles.clear();
    }
    @Override
    public String toString() {
        return "\nBag Name: " + name + " "+ pebbles;
    }
}
