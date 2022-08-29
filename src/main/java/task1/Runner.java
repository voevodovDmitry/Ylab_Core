package main.java.task1;

import java.util.Random;



public class Runner {


    public class RandomUtil {

        private final static int MULTIPLIER_A = 64517454;
        private final static int INCREMENT_C = 40056584;
        private final static int MODULUS = 1000; // max int

        private static int seed = 3819201;

        public static int randomInt() {
            seed = (seed * MULTIPLIER_A + INCREMENT_C) % MODULUS;
            return seed;
        }

        public static int randomPositiveInt() {
            int tmp = randomInt();
            if (tmp < 0) {
                seed = tmp * -1;
            }
            return seed;
        }
    }


    public static void main(String[] args) {
        int min, max, sum;
        double avg;
        int size = 10;
        int[][] matrix = new int[size][size];
        Random random = new Random();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++ ){
                matrix[i][j] = RandomUtil.randomPositiveInt();
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++ ){
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println();
        }

        max = min = matrix[0][0];
        sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++ ){
                if(max < matrix[i][j]){
                    max = matrix[i][j];
                }
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                }
                sum+=matrix[i][j];
            }
        }
        avg = (double) sum / (size*size);

        System.out.printf("Max = %d, min = %d, sum = %d, avg = %.3f", max, min, sum, avg);
    }
}
