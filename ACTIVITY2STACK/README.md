ACTIVITY 2: Advanced Stack Applications

Part A: Application-Based Questions
1.How stack is used in Function Calls (Call Stack)
. Every time a function is called, a new stack frame is created.
. The stack frame stores:
  >Local variables
  >Parameters
  >Return address
. When the function finishes, its stack frame is removed (LIFO).

2. How is stack used in Undo/Redo operations?
Undo/Redo uses two stacks:
   .Undo Stack
   .Redo Stack
When user performs an action:
   .Push action into Undo stack.
When user presses Undo:
   .Pop from Undo stack
   .Push into Redo stack
When user presses Redo:
   .Pop from Redo stack
   .Push back into Undo stack

3.Why stack is useful in Expression Evaluation?
Stack helps because:
  .Expressions follow LIFO logic
  .Operators must wait until operands are available
  .Helps handle precedence and parentheses
Used in:
  .Infix → Postfix conversion
  .Postfix evaluation
  .Compiler parsing

4.Difference Between Infix, Prefix & Postfix
Type	Example	Order
Infix	A + B	Operator between operands
Prefix	+ A B	Operator before operands
Postfix	A B +	Operator after operands

Part B: Coding Activity 1 – Balanced Parentheses
CODE:
package Capgg;
import java.util.Stack;
public class Main2{
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '['){
            stack.push(ch);}
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("(A+B)")); 
        System.out.println(isBalanced("(A+B"));   
    }
}

ALGO:
1.Create an empty stack.
2.Traverse each character of the expression.
3.If opening bracket → push into stack.
4.If closing bracket:
  .If stack is empty → Not Balanced.
  .Pop top element.
  .Check if it matches current closing bracket.
5.After traversal:
  .If stack is empty → Balanced.
  .Else → Not Balanced.

OUTPUT:
<img width="357" height="97" alt="Stack2 1" src="https://github.com/user-attachments/assets/2982cdca-ce91-4903-bfab-8659fa3eb541" />

Part C: Coding Activity 2 – Infix to Postfix Conversion
CODE:
package Capgg;
import java.util.Stack;
public class Main2{
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }
    public static String convert(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() &&
                        precedence(ch) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(convert("A+B*C")); 
    }
}

ALGO:
1.Create empty stack for operators.
2.Create empty string for result.
3.Traverse expression:
  .If operand → add to result.
  .If '(' → push to stack.
  .If ')' → pop until '(' found.
  .If operator:
   >While stack not empty AND precedence(stackTop) ≥ precedence(current):
    .Pop from stack to result.
   >Push current operator.
4.Pop remaining operators from stack to result.
5.Return result.

OUTPUT:
<img width="347" height="109" alt="Satck2" src="https://github.com/user-attachments/assets/8e18dd52-e3e3-4ce5-bdfe-35fb495457ca" />

Part D: Stack Challenge Problem
CODE:
package Capgg;
import java.util.Stack;
import java.util.Arrays;
public class Main2{
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
}

ALGO:
1.Create empty stack.
2.Push all array elements into stack.
3.Pop elements from stack.
4.Insert popped elements back into array.
5.Print reversed array.

OUTPUT:
<img width="355" height="102" alt="Stack2 3" src="https://github.com/user-attachments/assets/7d2903e7-194f-428a-9b72-03371e135c54" />

Part E: Analytical Task
Operation	        Time Complexity	
Push	                O(1)	
Pop                   O(1)	
Peek	                O(1)
Balanced Parentheses	O(n)
