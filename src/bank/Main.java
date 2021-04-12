/*
Coded by Pouya Mohammadi
CE@AUT Uni ID: 9829039
This is the Main Class where I run the application
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();
        Menu menu = new Menu();
        String input = "";
        while(true){
            System.out.println(menu.mainMenu);
            input = scanner.nextLine();
            if(1 == Integer.parseInt(input)){
                String[] signupInput = new String[4];
                System.out.println("");
                System.out.println(menu.singUpMenu[0]);
                System.out.println(menu.singUpMenu[1]);
                signupInput[0] = scanner.nextLine();
                if(bankingSystem.findUser(signupInput[0]) != null){
                    System.out.println("This ID already exists!");
                    continue;
                }
                System.out.println(menu.singUpMenu[2]);
                signupInput[1] = scanner.nextLine();
                System.out.println(menu.singUpMenu[3]);
                signupInput[2] = scanner.nextLine();
                System.out.println(menu.singUpMenu[4]);
                signupInput[3] = scanner.nextLine();
                User newUser = new User(signupInput[1], signupInput[2], signupInput[0], signupInput[3]);
                bankingSystem.register(newUser);
            }
            else if(2 == Integer.parseInt(input)){
                String[] loginInput = new String[2];
                System.out.println("");
                System.out.println(menu.logInMenu[0]);
                System.out.println(menu.logInMenu[1]);
                loginInput[0] = scanner.nextLine();
                System.out.println(menu.logInMenu[2]);
                loginInput[1] = scanner.nextLine();
                User lodgedIn = bankingSystem.login(loginInput[0], loginInput[1]);
                if (lodgedIn == null)
                    continue;
                while (true){
                    System.out.println("");
                    System.out.println(menu.logInMenu[3]);
                    input = scanner.nextLine();
                    if(1 == Integer.parseInt(input)){
                        lodgedIn.printAllAvailableAccounts();
                        System.out.println("\n\n Please enter the account serial of yours");
                        input = scanner.nextLine();
                        Account myAccount = bankingSystem.findAccount(input);
                        if(lodgedIn.accountExist(myAccount)){
                            System.out.println("");
                            while (true){
                                System.out.println(menu.accountOptionsMenu);
                                input = scanner.nextLine();
                                if(1 == Integer.parseInt(input)){
                                    System.out.println("Please enter amount of withdrawal:");
                                    input = scanner.nextLine();
                                    double withdrawal = Double.parseDouble(input);
                                    lodgedIn.withdrawal(myAccount, withdrawal);
                                }
                                else if(2 == Integer.parseInt(input)){
                                    System.out.println("Please enter amount of deposit:");
                                    input = scanner.nextLine();
                                    double depositMoney = Double.parseDouble(input);
                                    lodgedIn.deposit(myAccount, depositMoney);
                                }
                                else if(3 == Integer.parseInt(input)){
                                    System.out.println("Please enter destAccount serial:");
                                    input = scanner.nextLine();
                                    Account destAccount = bankingSystem.findAccount(input);
                                    if(destAccount != null) {
                                        System.out.println("Please enter amount of transfer:");
                                        input = scanner.nextLine();
                                        double transferMoney = Double.parseDouble(input);
                                        lodgedIn.transfer(myAccount, destAccount, transferMoney);
                                    }
                                }
                                else if(4 == Integer.parseInt(input)){
                                        lodgedIn.checkBalance(myAccount);
                                }
                                else if(5 == Integer.parseInt(input)){
                                    myAccount.printTransactions();
                                }
                                else if(6 == Integer.parseInt(input)){
                                    break;
                                }
                            }
                        }
                    }
                    else if(2 == Integer.parseInt(input)){
                        System.out.println("To confirm adding account please enter your ID:");
                        System.out.println("It must be as the same as user !");
                        input = scanner.nextLine();
                        if(input.equals(lodgedIn.getID())){
                            System.out.println("Please enter your account type:");
                            input = scanner.nextLine();
                            System.out.println("Please enter the initial balance:");
                            System.out.println("Or just enter. the defult is 0.0");
                            double initialBalance = Double.parseDouble(scanner.nextLine());
                            Account newAccount;
                            if(initialBalance > 0)
                                newAccount = new Account(lodgedIn.getFirstName(), lodgedIn.getLastName(), lodgedIn.getID(), input, initialBalance);
                            else
                                newAccount = new Account(lodgedIn.getFirstName(), lodgedIn.getLastName(), lodgedIn.getID(), input, 0);
                            lodgedIn.addAccount(newAccount);
                            bankingSystem.addAccount(newAccount);
                            System.out.println("\n Complete.");
                            newAccount.printAccountData();
                        }
                        else
                            System.out.println("Your ID does not match!");
                    }
                    else if(3 == Integer.parseInt(input)){
                        lodgedIn.printUserData();
                    }
                    else if(4 == Integer.parseInt(input)){
                        break;
                    }
                }
            }
            else if(3 == Integer.parseInt(input)){
                System.out.println("Please enter system admin user:");
                input = scanner.nextLine();
                if(input.equals(bankingSystem.getAdminUser())){
                    System.out.println("Please enter system admin password:");
                    input = scanner.nextLine();
                    if(input.equals(bankingSystem.getAdminPassword())){
                        System.out.println("");
                        while (true){
                            System.out.println(menu.sysAdminMenu);
                            input = scanner.nextLine();
                            if(1 == Integer.parseInt(input)){
                                bankingSystem.displayUsers();
                            }
                            else if(2 == Integer.parseInt(input)){
                                bankingSystem.displayAccounts();
                            }
                            else if(3 == Integer.parseInt(input)){
                                System.out.println("Please enter user ID:");
                                input = scanner.nextLine();
                                User user = bankingSystem.findUser(input);
                                if(user != null)
                                    bankingSystem.removeUser(user);
                            }
                            else if(4 == Integer.parseInt(input)){
                                System.out.println("Please enter account serial:");
                                input = scanner.nextLine();
                                Account account = bankingSystem.findAccount(input);
                                if(account != null)
                                    bankingSystem.removeAccount(account);
                            }
                            else if(5 == Integer.parseInt(input)){
                                break;
                            }
                        }
                    }
                    else
                        System.out.println("Wrong password!");
                }
                else
                    System.out.println("Wrong user!");
            }
            else if(4 == Integer.parseInt(input)){
                break;
            }
        }
    }
}
