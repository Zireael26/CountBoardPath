public class Main {

    public static void main(String[] args) {
        long startReact = System.currentTimeMillis();
        printBoardPathsReactive(0, 18, "");
        long endReact = System.currentTimeMillis();

        long startProact = System.currentTimeMillis();
        printBoardPathsProactive(0, 18, "");
        long endProact = System.currentTimeMillis();


        System.out.println("Time for Reactive: " + (endReact - startReact));
        System.out.println("Time for Proactive: " + (endProact - startProact));
    }

    static int counter = 0;

    public static void printBoardPathsReactive(int src, int dest, String pathSoFar) {
        if (src == dest) {   // when reached, print
            counter++;
            System.out.println(counter + ". " + pathSoFar);
            return;
        }

        //reactive base-case, helps recover from a bad call
        if (src > dest) { // if the call is wrong, return
            return;
        }

        for (int dice = 1; dice <= 6; dice++) {
            int intermediate = src + dice;  // because all ways from intermediate to destination are paths
            printBoardPathsReactive(intermediate, dest, pathSoFar + dice);  // faith that my function already
                                                                                 // works for all intermediate values
        }
    }

    // same function, but Proactive: takes care not to make wrong calls, rather than recovering from them later
    public static void printBoardPathsProactive(int src, int dest, String pathSoFar) {
        if (src == dest) {
            counter++;
            System.out.println(counter + ". " + pathSoFar);
            return;
        }

        for (int dice = 1; dice <= 6; dice++) {
            int intermediate = src + dice;
            if (intermediate <= dest) {
                printBoardPathsProactive(intermediate, dest, pathSoFar + dice);
            }
        }
    }
}
