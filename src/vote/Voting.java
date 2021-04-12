/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
Voting Class
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {

    /**
     * multi choice option
     */
    private boolean multiChoice;
    private ArrayList<String> choicesText;
    /**
     * List of choices and their gathered votes
     */
    private HashMap<String, HashSet<Vote>> choices;
    /**
     * is the question of voting
     */
    private String question;

    /**
     * Setup a new voting
     * @param question is the question
     * @param multiChoice is the permission of multi choice
     */
    public Voting(String question, boolean multiChoice){
        this.question = question;
        this.multiChoice = multiChoice;
        choices = new HashMap<String, HashSet<Vote>>();
        choicesText = new ArrayList<String>();
    }

    /**
     * add a choice to the list of choices
     * @param choice will be added as new one
     */
    public void createChoice(String choice){
        HashSet<Vote> newVoteList = new HashSet<Vote>();
        choices.put(choice, newVoteList);
        choicesText.add(choice);
    }

    /**
     * With this method you can vote :)
     * @param voter is the vote which goes to the choosed choices
     * @param choices are the choosed one
     */
    public void vote(Vote voter, ArrayList<String> choices){
        int index = 0;
        boolean isRepeatedVoter = false;
        for(String choice : choicesText){
            HashSet<Vote> votersList = this.choices.get(choice);
            for(Vote previousVoter : votersList){
                if(previousVoter.getPerson().getID().equals(voter.getPerson().getID())){
                    System.out.println("You cannot vote again!");
                    System.out.println("You have participated in this voting once!");
                    return;
                }
            }
        }
        for(String choice : choices) {
            isRepeatedVoter = false;
            if(index > 0){
                if(!multiChoice){
                    System.out.println("Only your first vote is assigned!");
                    System.out.println("Multi choice is off");
                    break;
                }
            }
            for(Vote previousVoter : this.choices.get(choice)){
                if(previousVoter.getPerson().getID().equals(voter.getPerson().getID())){
                    isRepeatedVoter = true;
                    break;
                }
            }
            if(isRepeatedVoter){
                index++;
                continue;
            }
            this.choices.get(choice).add(voter);
            index++;
        }
    }

    /**
     * Prints the result
     */
    public void printResult(){
        System.out.println(" *** Result of voting:");
        System.out.println("Question: " + question);
        System.out.println();
        int number = 1;
        for(String choice : choicesText){
            String message = number + " - " + choice + " - Result of choice is: " + choices.get(choice).size();
            System.out.println(message);
            number++;
        }
    }

    /**
     * It prints the choices list
     */
    public void printChoicesList(){
        int index = 0;
        System.out.println();
        for(String text : choicesText){
            String message = index + " - " + text;
            System.out.println(message);
            index++;
        }
        System.out.println();
    }

    // Getters
    public String getQuestion() {
        return question;
    }
    public ArrayList<String> getChoicesText() {
        return choicesText;
    }
    public boolean isMultiChoice() {
        return multiChoice;
    }
}
