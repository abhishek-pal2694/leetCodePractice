package leetCode75;

class SetMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = {{7,1,6,8,3},{4,0,2,0,1},{6,9,0,7,8},{3,1,2,4,5}};
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("-------After setting Zero--------");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("|");
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
                if(col< matrix[0].length-1) System.out.print(",");
            }
            System.out.println("|");
        }
    }
    public static void setZeroes(int[][] matrix) {
        boolean firstrow = false, firstcol = false;

        // setting 0 or 1 in the first row and col for marking which row or col has 0
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    if(row==0) firstrow = true;
                    if(col==0) firstcol = true;
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Iterating on the inner matrix to check for 0
        for(int row=1; row<matrix.length; row++){
            for(int col=1; col<matrix[0].length; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }

        // Now updating the first row and first column with 0's
        if(firstrow){
            for(int col=0; col<matrix[0].length; col++){
                matrix[0][col] = 0;
            }
        }
        if(firstcol){
            for(int row = 0; row<matrix.length; row++){
                matrix[row][0] = 0;
            }
        }
    }
}