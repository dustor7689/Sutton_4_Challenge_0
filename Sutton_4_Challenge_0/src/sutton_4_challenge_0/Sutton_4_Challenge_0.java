
package sutton_4_challenge_0;

/**
 *
 * @author dustor7689
 */
public class Sutton_4_Challenge_0 {


    
    public static void main(String[] args) {
        
       for (int i = 1;i < 501; i++){
     if(isDivisiblebyFive(i) & isDivisiblebyThree(i) & isDivisiblebyTwo(i)){
        System.out.println("Team Building"+  i);      
    }
    
         else if(isDivisiblebyEleven(i) & isDivisiblebyFive(i)){
        System.out.println("Animate this!" + i);
    }   
    else if(isDivisiblebyEleven(i) & isDivisiblebyThree(i)){
        System.out.println("Herr Direktor" + i);
    } 
    else if(isDivisiblebyEleven(i) & isDivisiblebyTwo(i)){
        System.out.println("Ninja" + i);
    } 
    else if(isDivisiblebyFive(i) & isDivisiblebyThree(i)){
        System.out.println("Old School" + i);
    } 
      else if(isDivisiblebyTwo(i) & isDivisiblebyThree(i)){
        System.out.println("Chisme" + i);
    } 
else if(isDivisiblebyFive(i)){
        System.out.println("Vidal" + i);
    }
    else if(isDivisiblebyThree(i)){
        System.out.println("Claughton" + i);
    }
    else if(isDivisiblebyTwo(i)){
        System.out.println("Davis" + i);
    }
        
    
        
    }
    }
       
    static boolean isDivisiblebyTwo(int a){
         return(a % 2 ==0);
     }
     static boolean isDivisiblebyThree(int a){
         return(a % 3 ==0);
        }
          static boolean isDivisiblebyFive(int a){
         return(a % 5 ==0);
        }
          static boolean isDivisiblebyEleven(int a){
         return(a % 11 ==0);
        }
}
        

    

