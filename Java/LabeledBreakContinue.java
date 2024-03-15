//WAP to illustrate labelled break and continue working with suitable example
public class LabeledBreakContinue {
    public static void main(String[] args) {
        // Labeled break example
        outerLoop:
        for (int i = 0; i < 2; i++) {
            System.out.println("Outer loop iteration: " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("Breaking from outer loop");
                    break outerLoop; // Breaks out of the outer loop
                }
                System.out.println("Inner loop iteration: " + j);
            }
        }

        // Labeled continue example
        firstLoop:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 1 && j == 1) {
                    System.out.println("Continuing to next iteration of outer loop");
                    continue firstLoop; // Continues with the next iteration of the outer loop
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }
}