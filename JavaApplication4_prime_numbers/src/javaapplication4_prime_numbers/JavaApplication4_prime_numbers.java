
package javaapplication4_prime_numbers;

/**
 *
 * @author dustor7689
 */
public class JavaApplication4_prime_numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        static boolean isEven (int somenumber) {
     return (somenumber % 2 != 0);
     }
     static boolean isOdd (int somenumber) {
     return (somenumber % 2 != 0);
     }
     static boolean isPrime (int somenumber){
     int divisor = 0;
     for (int i = 2; i < somenumber; i++){
     if (somenumber % i ==0){
     divisor +=1;
     }
     }
     if(divisor > 0){
     return false;
     } else {
     return true;
     }
//     for(int i = 1;i < 100; i++){
//         if(i % 2 != 0){
//             if(i % 3 != 0){
//                 if(i % 5 != 0){
//                     if(i % 7 != 0){
//                 }
//             }
//         }
//         }
//         System.out.println(i);
//             
//     }
    
    }
    
}
