/* Realizar programa que muestre los números del 1 al 100 que no
sean múltiplos de 3, utilizando cada una las instrucciones
repetitivas (while, do while, for) */



public class multiplosDeTresNo {
    public static void main(String[] args) throws Exception  {

        //while
        int i = 0;

        while (i <= 100) {

            if((i%3)!=0){
            System.out.println(i);
            }
            i++;
        }
        //do while
        i = 0;

        do {

            if((i%3)!=0){
            System.out.println(i);
            }
            i++;
        }while (i <= 100);

        //for
        for ( i=0; i <= 100; i ++) {
            if((i%3)!=0){
                System.out.println(i);
                }

         }



    }
}
