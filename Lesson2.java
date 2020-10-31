public class Lesson2 {
    public static void main(String[] args) {
        System.out.println("Task 1 \nCreate an array and fill it with 2 number.");
        int[] taskOne = new int[5];
        for (int i = 0; i < taskOne.length; i++) {
            taskOne[i] = 2;
        }
        System.out.println("Task 2 \nCreate an array and fill it with numbers from 1:1000.");
        int[] taskTwo = new int[1000];
        for (int i = 0; i < taskTwo.length; i++) {
            taskTwo[i] = i + 1;
        }
        System.out.println("Task 3 \nCreate an array and fill it with odd numbers from -20:20");
        int countOfOddNumbers = 0;
        for (int i = 19; i >= -19; i -= 2) {
            countOfOddNumbers++;
        }
        int[] taskThree = new int[countOfOddNumbers];
        for (int i = -19, j = 0; j < countOfOddNumbers; i += 2, j++) {
            taskThree[j] = i;
        }
        System.out.println("Task 4 \nCreate an array and fill it. Print all elements which can be divided by 5.");
        int[] taskFour = {3, 6, 25, 64, 12, 90, 123, 434, 235, 565, 345, 3444, 233, 22};
        for (int i = 0; i < taskFour.length; i++) {
            if (taskFour[i] % 5 == 0) {
                System.out.println(taskFour[i]);
            }
        }
        System.out.println("Task 5 \nCreate an array and fill it. Print all elements which are between 24.12 and 467.23.");
        double[] taskFive = new double[]{45, 33.4, 654.4, 32.65, 152.6, 52.0, 234.9};
        for (int i = 0; i < taskFive.length; i++) {
            if (taskFive[i] > 24.12 && taskFive[i] < 467.23) {
                System.out.println(taskFive[i]);
            }
        }
        System.out.println("Task 6 \nCreate an array and fill it. Print count of elements which can be divided by 2.");
        int[] taskSix = {3, 6, 25, 64, 12, 90, 123, 434, 235, 565, 345, 3444, 233, 22};
        int countOfEvenNumbers = 0;
        for (int i = 0; i < taskSix.length; i++) {
            if (taskSix[i] % 2 == 0) {
                countOfEvenNumbers++;
            }
        }
        System.out.println(countOfEvenNumbers);
        System.out.println("Task 7 \nGiven an integer, 0< N < 21 , print its first 10 multiples.");
        int N = 10;
        for (int i = 1; i < 11; i++) {
            System.out.println(N + " X " + i + " = " + N * i);
        }
    }
}
