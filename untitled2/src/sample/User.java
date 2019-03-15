package sample;

import java.util.Scanner;



    public class User {
        static History h = new History();
        //public static int hindex;
        static Scanner read = new Scanner(System.in);
        private static double currentBalance;
        public static int index = 0;

        //public static int count=0;
        User(double currentBalance) {
            this.currentBalance = currentBalance;
        }

        public void withdrawl(double amount) {
            if (amount > 0) {

                currentBalance = currentBalance - amount;
                User.index = User.index + 1;
                if (User.index > 4) {
                    h.shift();
                    index = 4;
                    h.setHindex();

                    h.history[index] = "withdraw " + amount;
                } else {
                    h.setHindex();
                    h.history[index] = "withdraw " + amount;
                }
            }
        }


        public static void deposit(double amount) {
            if (amount > 0) {
                currentBalance = currentBalance + amount;
                User.index = User.index + 1;
                if (User.index > 4) {
                    h.shift();
                    h.history[4]=null;
                    index = 4;
                    h.setHindex();
                    h.history[index] = "deposit " + String.valueOf(amount);
                } else {
                    h.setHindex();
                    h.history[index] = "deposit " + String.valueOf(amount);
                }
            }
        }

        public double getBalance() {
            return currentBalance;
        }

        public static boolean compareUsername(String s) {
            while (!s.contentEquals("omar")) {
                System.out.println("please reenter username");
                s = read.nextLine();
            }
            return true;
        }

        public static boolean comparePassword(String s) {
            while (!s.contentEquals("5845")) {
                System.out.println("please reenter password");
                s = read.nextLine();
            }
            return true;
        }
    }
        /*public static void main(String[]args) {
            System.out.println("Enter your username");
            String id = read.nextLine();
            compareUsername(id);
            System.out.println("please enter password");
            String pass = read.nextLine();
            comparePassword(pass);
            int initialBalance=0;
            User user1 = new User(initialBalance);
            while(true) {
                System.out.println("1 = deposit, 2 = withdraw, 3 = current balance, 4 = next, 5= previous, 6= show all, 7 = exit");
                int menu = read.nextInt();
                switch(menu) {
                    case 1 : System.out.println("Enter the amount you want to deposit"); double amount = read.nextDouble(); user1.deposit(amount);break;
                    case 2 : System.out.println("Enter the amount you want to withdraw");  amount = read.nextDouble(); user1.withdrawl(amount);break;
                    case 3 : System.out.println("Your current balance is "+ user1.getBalance());break;
                    case 4 : System.out.println(user1.h.historyNext());break;
                    case 5 : System.out.println(user1.h.historyPrevious());break;
                    case 6 : user1.h.show();break;
                    case 7 : System.exit(0);break;
                }


            }
        }
    }

*/