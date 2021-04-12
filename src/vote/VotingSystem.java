/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
VotingSystem Class
 */


import java.util.ArrayList;

public class VotingSystem {

    /**
     * list of voting
     */
    private ArrayList<Voting> votingList;

    /**
     * Constructor of voting system
     */
    public VotingSystem(){
        votingList = new ArrayList<Voting>();
        System.out.println(" *** ");
        System.out.println("Voting system initialized");
        System.out.println(" *** ");
    }

    /**
     * creates a voting
     * @param newVoting will be added to the list
     */
    public void createVoting(Voting newVoting){
        votingList.add(newVoting);
    }

    /**
     * prints list of all votings
     */
    public void printListOfVoting(){
        System.out.println(" *** List of Voting");
        int index = 0;
        for(Voting temp : votingList){
            String message = index + " - " + temp.getQuestion() + " - multi choice is " ;
            if(temp.isMultiChoice())
                message += "on";
            else
                message += "off";
            System.out.println(message);
            index++;
        }
        System.out.println("");
    }

    /**
     * prints a voting information
     * @param index index of that voting
     * @return true if the voting exists, else false
     */
    public boolean printVoting(int index){
        if(index >= votingList.size()) {
            System.out.println("This index does not exists");
            return false;
        }
        Voting temp = votingList.get(index);
        System.out.println(" **** ");
        System.out.println("Question: " + temp.getQuestion());
        temp.printChoicesList();
        return true;
    }

    /**
     * add a vote to a specific voting
     * @param person is the voter
     * @param index of voting
     * @param indexOfChoices is list of choices
     */
    public void vote(Person person, int index, String[] indexOfChoices){
        Voting currentVoting = null;
        currentVoting = votingList.get(index);
        if(currentVoting == null){
            System.out.println("This voting does not exist");
            return;
        }
        ArrayList<String> listOfChoices = new ArrayList<String>();
        for(String indexOfChoice : indexOfChoices){
            if(Integer.parseInt(indexOfChoice) < currentVoting.getChoicesText().size())
                listOfChoices.add(currentVoting.getChoicesText().get(Integer.parseInt(indexOfChoice)));
        }
        Vote newVoter = new Vote(person);
        currentVoting.vote(newVoter, listOfChoices);
    }

    /**
     * prints the result of a voting
     * @param index of voting
     */
    public void printResult(int index){
        if (votingList.size() <= index){
            System.out.println("No such a voting exists!");
            return;
        }
        Voting currentVoting = null;
        currentVoting = votingList.get(index);
        if(currentVoting == null){
            System.out.println("No such a voting exists!");
            return;
        }
        currentVoting.printResult();
    }

}
