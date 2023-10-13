package AlgoExpert.Arrays;

import java.util.*;

// Transpose Matrix
// Difficulty: easy     Category: Arrays

// You're given a 2D array of integers matrix. Write a function
// that returns the transpose of the matrix. The transpose of a
// matrix is a flipped version of the original matrix across
// its main diagonal (which runs from top-left to bottom-right);
// it switches the row and column indices of the original matrix.

// You can assume the input matrix always has at least 1 value;
// however its width and height are not necessarily the same.

public class TransposeMatrix {

    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0][0];

        int maxCols = 0;
        for(int[] row : matrix) {
            maxCols = Math.max(maxCols, row.length);
        }

        int[][] newMatrix = new int[maxCols][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transposed = transposeMatrix(matrix);
        for(int[] row : transposed) {
            System.out.println(Arrays.toString(row));
        }
    }
}

