public class TwoDArrays{

    public static void finMaxMin(int matrix[][]) { 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(matrix[i][j], max); 
                min = Math.min(matrix[i][j], min);
            }
        }

        System.out.println("max: "+ max + " & min: "+ min );
    }

    public static boolean findKey(int matrix[][], int key) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == key) {
                    System.out.println("Found key at: [" + i + ", " + j + "]");
                    return true;
                }
            }
        }
        System.out.println("Could not find key!");
        return false;
    }


    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while(startCol <= endCol && startRow <= endRow) {
            // row = i & col = j
            //top
            for(int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            //right
            for(int i = startRow+1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for(int j = endCol-1; j >= startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            //left
            for(int i = endRow-1; i >= startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            //updation
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // int matrix[][] = new int[3][3];
        // int n = 3;
        // int m = 3;
        // int key = 51;

        //Scanner sc = new Scanner(System.in);

        // input
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        //print
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(matrix[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        //findKey(matrix, key);
        //finMaxMin(matrix);

        // Spiral Matrix
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printSpiral(matrix);
    }
}