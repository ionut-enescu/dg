/**
 * Given an array, print the Next Greater Element (NGE) for every element.

    The Next Greater Element for an element x is the first greater element on the right side of x in the array.

    Elements for which no greater element exist, consider the next greater element as -1.

    Examples
    Example 1:

    Input: [4, 5, 2, 25]
    Output: [5, 25, 25, -1]
    Example 1:

    Input: [13, 7, 6, 12]
    Output: [-1, 12, 12, -1]
    Example 1:

    Input: [1, 2, 3, 4, 5]
    Output: [2, 3, 4, 5, -1]
    Constraints:

    1 <= arr.length <= 10^4
    -10^9 <= arr[i] <= 10^9
 */

 import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NextGreaterElement {

    public List<Integer> nextLargerElement(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        // ToDo: Write Your Code Here.

        Stack<Integer> myStack1 = new Stack<>();
        Stack<Integer> myStack2 = new Stack<>();

        for (int i : arr) {
            myStack1.push(i);
        }

        myStack2.push(-1);
        int curNGE = myStack1.pop();
        int maxNGE = curNGE;
        System.out.println("**********");
        while (!myStack1.isEmpty()) {
            int cur = myStack1.pop();

            if (cur < curNGE) {
                myStack2.push(curNGE); 
            } else if (cur >= maxNGE){
                myStack2.push(-1);
                maxNGE = cur;       
            } else {
                myStack2.push(maxNGE);
              //  maxNGE = cur;                
            }
            System.out.println(maxNGE);
            curNGE = cur;
        }

        while (!myStack2.isEmpty()) {
            res.add(myStack2.pop());
        }

        return res;
    }
}
