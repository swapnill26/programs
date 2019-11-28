import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static void sum(ArrayList<Integer> numbers, int target, ArrayList<Integer> arr) {
       int s = 0;
       for (int x: arr) s = s+x;
       if (s == target)
        {
            System.out.println("sum("+Arrays.toString(arr.toArray())+")="+target);
        }
      
       for(int i=0;i<numbers.size();i++) 
       {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) 
             {
                 remaining.add(numbers.get(j));
             }
             ArrayList<Integer> arr_rem = new ArrayList<Integer>(arr);
             arr_rem.add(n);
             sum(remaining,target,arr_rem);
       }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         System.out.println("enter array size");
        int t=sc.nextInt();
        Integer[] numbers=new Integer[t];
         System.out.println("enter array value");
         for(int i=0;i<t;i++) numbers[i]=sc.nextInt();
         System.out.println(Arrays.toString(numbers));
        
        System.out.println("Enter sum for which you want to find combination:");
        
        int target = sc.nextInt();
      
        sum(new ArrayList<Integer>(Arrays.asList(numbers)),target,new ArrayList<Integer>());
        
    }
}
