/*
Coded by Pouya Mohammadi
CE@AUT - Uni ID: 9829039
oldFiles.Main Class to run the application
 */

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public  static ArrayList<Person> voters = new ArrayList<Person>();

    public static void addVoter(String ID,String firstname, String lastname){
        for(Person person : voters){
            if(person.getID().equals(ID)){
                System.out.println("This ID already exists!");
                return;
            }
        }
        Person newPerson = new Person(firstname, lastname, ID);
        voters.add(newPerson);
    }

    public static Person getVoter(String ID){
        for(Person person : voters){
            if(person.getID().equals(ID)){
                return person;
            }
        }
        System.out.println("This ID does not exist!");
        return null;
    }

    public static void main(String[] args) {

        VotingSystem votingSystem = new VotingSystem();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        String input;

        while (true){
            System.out.println(menu.mainMenu);
            input = scanner.nextLine();
            if(input.equals("1")){
                System.out.println(menu.createVotingMenu[0]);
                String question = scanner.nextLine();
                System.out.println(menu.createVotingMenu[1]);
                input = scanner.nextLine();
                Voting newVoting = null;
                if(input.toLowerCase(Locale.ROOT).equals("y") || input.toLowerCase(Locale.ROOT).equals("yes"))
                    newVoting = new Voting(question, true);
                else
                    newVoting = new Voting(question, false);
                System.out.println(menu.createVotingMenu[2]);
                int numberOfChoices = 0;
                while (true){
                    input = scanner.nextLine();
                    if(input.equals("*#DONE")){
                        if(numberOfChoices >= 2)
                            break;
                        else {
                            System.out.println("You must have at lease 2 choices! \n currently you have: " + numberOfChoices);
                            continue;
                        }
                    }
                    newVoting.createChoice(input);
                    numberOfChoices++;
                }
                votingSystem.createVoting(newVoting);
            }
            else if(input.equals("2")){
                System.out.println(menu.addVoterMenu[0]);
                String fName = scanner.nextLine();
                System.out.println(menu.addVoterMenu[1]);
                String lName = scanner.nextLine();
                System.out.println(menu.addVoterMenu[2]);
                String ID = scanner.nextLine();
                addVoter(ID, fName, lName);
            }
            else if(input.equals("3")){
                votingSystem.printListOfVoting();
                System.out.println(menu.voteMenu[0]);
                input = scanner.nextLine();
                int index = Integer.parseInt(input);
                System.out.println(menu.voteMenu[1]);
                input = scanner.nextLine();
                Person voter = getVoter(input);
                if(voter == null){
                    System.out.println("Please sign up as a voter before attending to any voting");
                    continue;
                }
                if(!votingSystem.printVoting(index))
                    continue;
                String[] listOfChoices;
                System.out.println(menu.voteMenu[2]);
                input = scanner.nextLine();
                listOfChoices = input.split("#");
                votingSystem.vote(voter, index, listOfChoices);
                System.out.println("Done!");
            }
            else if(input.equals("4")){
                votingSystem.printListOfVoting();
            }
            else if(input.equals("5")){
                votingSystem.printListOfVoting();
                System.out.println("*** Please enter index of your voting: ");
                input = scanner.nextLine();
                votingSystem.printResult(Integer.parseInt(input));
            }
            else if(input.equals("6")){
                break;
            }
        }
    }
}
