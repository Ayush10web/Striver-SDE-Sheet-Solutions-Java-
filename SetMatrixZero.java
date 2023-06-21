import java.util.Arrays;

public class SetMatrixZero{
    public static void main(String[] args) {
        // the object creation is not required in leetcode
        int[][]a ={
            {1,1,0,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
        };
        SetMatrixZero obj = new SetMatrixZero();
        obj.setZeroes(a);
    }
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        // Check if the first row has any zeros
        for (int j = 0; j < columns; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if the first column has any zeros
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        // Mark zeros in the first row and column based on zero elements in the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows to zero based on marked zeros in the first column
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns to zero based on marked zeros in the first row
        for (int j = 1; j < columns; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if it had a zero
        if (firstRowHasZero) {
            for (int j = 0; j < columns; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set first column to zero if it had a zero
        if (firstColumnHasZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        // this for loop is not need in the leetcode 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}