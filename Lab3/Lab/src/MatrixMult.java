/**
     This class tests the code for Exercise 2. It calls a method to
     multiply two square matrices of size n x n, and prints information about
     running time.
     It expands upon a framework provided by Srini.
     */
import java.util.*;
    public class MatrixMult{
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int sizeOfMatrix = in.nextInt();
            int numberFiller = in.nextInt();
            long startTime, endTime, executionTime;
            double[][] mat1 = new double[sizeOfMatrix][sizeOfMatrix];
            double[][] mat2 = new double[sizeOfMatrix][sizeOfMatrix];

            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix ; j++) {
                    mat1[i][j] = numberFiller;
                    mat2[i][j] = numberFiller;
                }
            }

            startTime = System.currentTimeMillis();

            multiplyMatrix(mat1,mat2,sizeOfMatrix);

            endTime = System.currentTimeMillis();

            executionTime = endTime - startTime;
            System.out.println("Size " + sizeOfMatrix + " Time " + executionTime);
        }
        /* The method for multiplying two matrices */
        public static double[][] multiplyMatrix(double[][] mat1, double[][] mat2, int sizeOfMatrix){
            double[][] res = new double[sizeOfMatrix][sizeOfMatrix];
            int i, j, k;
            for (i = 0; i < sizeOfMatrix; i++) {
                for (j = 0; j < sizeOfMatrix; j++) {
                    res[i][j] = 0;
                    for (k = 0; k < sizeOfMatrix; k++){
                        res[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return res;
        }
    }

