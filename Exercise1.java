import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) throws FileNotFoundException {

        //create a hashmap to hold the password for the repective username
        HashMap<String, String> Website_Password = new HashMap<>();

        //create a hashmap to hold the fullname for the repctive fullname
        HashMap<String, String> Website_Username = new HashMap<>();

        //user will only have 3 tries to login
        int userTries = 3;

        //initialize a scanner for user to use
        Scanner keyboard = new Scanner(System.in);

        try {

            //read from a .txt file
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));

            //create an array to hold to values for each line i.e. storeLine will hold ["fullname", "username", "password"]
            String[] storeLine;

            while(reader.readLine() != null){
                //store the line up until a "<>" is read from the file
                storeLine = reader.readLine().split("<>");

                //store the username and password repectively
                Website_Username.put(storeLine[1], storeLine[0]);
                //store the username and password respectivley
                Website_Password.put(storeLine[1], storeLine[2]);

            }

        }catch (IOException e){

            e.printStackTrace();

        }
        //once the usernames, passwords and fullnames are stored ask user for their login information
        checkUserLogin(Website_Password, Website_Username, userTries, keyboard);

    }

    private static void checkUserLogin(HashMap<String, String> Website_Password, HashMap<String, String> Website_Username, int userTries, Scanner keyboard) {
        //set variables for username and password respectively
        String username;
        String password;

        //only keep asking the user for username and password if they have more than 0 tries remaining
        while (userTries > 0){
            //each time the while loop iterates take one of the users tries away
            userTries -= 1;
            //ask user for their username and password respectivley
            System.out.println("Enter username: ");
            username = keyboard.nextLine();
            System.out.println("Enter password: ");
            password = keyboard.nextLine();
            //if the username is equal to the respective password from the hashmap for the username then accept user access and goes to that index to chheck
            if(password.equals(Website_Password.get(username))){

                System.out.println("Login successful");

                System.out.println("Welcome " + Website_Username.get(username));
                //break out of the loop one accessed
                break;

            }
            //if user tries equals 0 then end loop
            if(userTries == 0){

                System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
            }
            //else show the user their remaining tries
            else

                System.out.println("Either the username or password is incorrect. You have " + userTries + " more attempts.");


        }
    }

}
