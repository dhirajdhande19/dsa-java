public class pattern{

    public static void hollow_rectangle(int totRows, int totCols) {
        // outer loop 
        for(int i = 1; i <= totRows; i++) {
            // inner loop
            for(int j = 1; j <= totCols; j++) {
                if(i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void inverted_triangle(int n) {
        for (int i = 1; i <= n; i++) {
            //space
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();

        }
    }

    public static void inverted_num_triangle(int n) {
        for (int i =1; i <= 5; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n) {
     int num = 1;
        for (int i = 1; i <= n ; i++){
               
            for(int j = 1; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

    public static void binary_triangle(int n) {
        for(int i = 1; i <=5; i++) {
             for(int j = 1; j <= i; j++) {
                if((i+j)%2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
             }
             System.out.println();
        }
    }

    public static void butterfly(int n) {
        // 1st block
        for(int i = 1; i <= n; i ++) {
            //star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            //space
            for(int j = 1; j <= (n-i)*2; j++) {
                System.out.print(" ");
            }

            //star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2nd block
        for(int i = n; i >= 1; i--) {
            //star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            //space
            for(int j = 1; j <= (n-i)*2; j++) {
                System.out.print(" ");
            }

            //star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void rombhus(int n) {
        for(int i = 1; i <= n; i++) {
            //space
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //start
            for(int j = 1; j <= n; j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
    }

    public static void hollow_rohmbus(int n) {
        for(int i = 1; i <= n; i++) {
            // outer space
            for(int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            for(int j = 1; j <= n; j++) {
                if(i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // next line
            System.out.println();

        }
    }

    public static void diamond(int n){
        // 1st block
        for(int i = 1; i <= n; i++) {
            //space
            for(int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            //stars
            for(int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 2nd block
        for(int i = n; i >= 1; i--){
            //space
            for(int j = 1; j <= (n-i); j++) {
                System.out.print(" ");
            }

            //stars
            for(int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        // hollow_rectangle(5,5);
        // inverted_triangle(6);
        //inverted_num_triangle(5);
        //floyd_triangle(5);
        //binary_triangle(5);
        //butterfly(10);
        //rombhus(7);
        //hollow_rohmbus(10);
        //diamond(4);
    }
}
