import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {

        try {

            //create scanner to read from .txt file
            Scanner scan = new Scanner(new File("inputs.txt"));

            //assume there are no vertices
            int vertices = 0;

            //get the number of vertices from .txt file
            while (scan.hasNextInt()) {

                vertices = scan.nextInt();


            }

            //create a martix that is the size of the number of vertices
            int[][] adj = new int[vertices][vertices];

            //create a matrix that is the size of the vertices
            for (int i = 0; i < vertices; i++) {

                for (int j = 0; j < vertices; j++) {

                    adj[i][j] = 0;

                }

            }

            //convert the characters to integers
            while(scan.hasNext()){

                int v0 = scan.next().charAt(0) - 65;

                int v1 = scan.next().charAt(0) - 65;

                adj[v0][v1] = 1;


            }

            //fill the matrix with values from the .txt file
            createMatrix(vertices);

            //create an array to hold the vertices indegrees
            int[] pred = new int[vertices];

            //find the indegree of each of the vertices
            findIndegree(vertices, adj, pred);

            //create an empty queue to send the vertices to
            Queue<Integer> queue = new LinkedList<>();

            //add vertices to queue if they have an indegree of 0
            addToQueue(vertices, pred, queue);

            //assume the topnum starts at 0
            int topNum = 0;


            int[] topArray = new int[vertices];

            //iterate if the queue is not empty
            while (!queue.isEmpty()) {

                //set variable w to dequeue
                int w = queue.remove();

                //remove the character that has the respective topnum
                topArray[topNum] = w;

                //increment the topnum when a added to queue
                topNum = topNum + 1;

                //iterate through each of the letters and decrement the indegree until it is 0, then add it to the queue with its respective topnum
                for (int i = 0; i < vertices; i++) {

                    if (adj[w][i] == 1) {
                        //degrements the value of the indegree at that repsective index
                        pred[i] = pred[i] - 1;
                        //if the index is equal to 0 then add it to the queue to be printed
                        if (pred[i] == 0) {
                            //add it to the queue
                            queue.add(i);

                        }
                    }

                }
            }
            //once the queue is empty we are ready to print
            printTopnum(vertices, topArray);

        }catch (IOException e){

            e.printStackTrace();

        }

    }

    private static void addToQueue(int vertices, int[] pred, Queue<Integer> queue) {
        //intertate and check if the indegree is 0
        for (int i = 0; i < vertices; i++) {
            //if indegree is 0 then add it to the queue
            if (pred[i] == 0) {
                //add respective index to the queue
                queue.add(i);

            }

        }

    }

    private static void printTopnum(int vertices, int[] topArray) {
        
        System.out.println("TopNum: ");
        //print the top nums
        for (int i = 1; i < vertices + 1; i++) {

            System.out.print(i + " ");

        }


        System.out.println();
        //itereate and find the values for each of the letter from the queue
        for (int i1 : topArray) {
            //convert to integers so we can print
            System.out.print(String.valueOf((char)(i1 + 65)) + " ");

        }

    }

    private static void findIndegree(int vertices, int[][] adj, int[] pred) {

        //check if the indegree
        for (int i = 0; i < vertices; i++) {
            //assume the indegree is 0
            int indegree = 0;

            for (int j = 0; j < vertices; j++) {
                //check if there is a letter going to it
                if (adj[j][i] == 1) {

                    indegree++;

                }

            }
            //return the indegree for ex. [1,2,1,2,0]
            pred[i] = indegree;

        }

    }


    private static void createMatrix(int vertices) {
        //create an empty matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {


            }

        }
    }

}
