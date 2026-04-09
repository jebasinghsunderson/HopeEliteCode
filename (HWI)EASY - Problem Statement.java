/*
EASY - Problem Statement: Minimum Array LengthYou are given an array A of N positive integers.
  You can perform the following operation any number of times:
  Find two adjacent elements in the array that have the same parity (i.e., both are even or both are odd). •
• Remove both elements and insert their sum in their exact place. Find the minimum possible length of the array after performing this operation optimally.
Input Format • The first line contains an integer, N, denoting the size of the array.
Each line i of the N subsequent lines (where $0 \le i < N$) contains an integer describing A[i]. • Constraints
• $1 \le N \le 10^5$
• $1 \le A[i] \le 10^5$

Sample Test Cases
Case 1
Input:
Plaintext
3
1
2
3
Output:
3
Explanation: • Array: [1, 2, 3]
Check adjacent pairs:
○ 1 (odd) & 2 (even)
○ 2 (even) & 3 (odd) •
• No valid operation possible. • Final length = 3
Case 2
Input:
Plaintext
5
2
4
1
3
5
Output:
2
Explanation:
Step 1:
○ 2 and 4 are both even
○ Merge: $2 + 4 = 6$
○ New array: [6, 1, 3, 5] • Step 2:
○ 1 and 3 are both odd
○ Merge: $1 + 3 = 4$
○ New array: [6, 4, 5] • Step 3:
○ 6 and 4 are both even
○ Merge: $6 + 4 = 10$
○ New array: [10, 5] • Now:
○ 10 (even) & 5 (odd) cannot merge
•
• Final length = 2
  */

// Answer (can be done in stack or find count of segments of same parity)
//Stack implementation
import java.util.*;
public class Main{
   public static void main(String[] arg) {
       Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
       int []  arr=new int[n];
       for(int i=0;i<n;i++)
           arr[i]=sc.nextInt();

       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<n;i++){
           if(stack.isEmpty() || ((stack.peek() ^ arr[i])&1) == 1){
               stack.push(arr[i]);
           }
           else {
               while(!stack.isEmpty() && (stack.peek()^arr[i])==0){
                   int num=stack.pop();
                   stack.push(num+arr[i]);
               }
           }
       }
       System.out.println(stack.size());
   }
   
}
