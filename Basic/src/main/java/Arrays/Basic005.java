/*
    Given a sorted array A[] having 10 elements which contain 6 different numbers in which only 1 number is repeated
    five times. Your task is to find the duplicate number using two comparisons only.

    Example 1:

    Input:
    A[] = {1, 1, 1, 1, 1, 5, 7, 10, 20, 30}
    Output: 1
    Example 2:

    Input:
    A[] = {1, 2, 3, 3, 3, 3, 3, 5, 9, 10}
    Output: 3

    Your Task:
    You don't need to read input or print anything. Your task is to complete the function findDuplicate() which takes
    the array A[], as inputs and returns the required duplicate element.

    Expected Time Complexity: O(1)
    Expected Auxiliary Space: O(1)

    Constraints:

    Size of the array A[] = 10
    1 ≤ A[] ≤ 105
*/
package Arrays;

import java.io.*;

public class Basic005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int[] A = new int[10];
            String[] input = br.readLine().trim().split(" ");
            for(int i = 0;i<10;i++) {
                A[i] = Integer.parseInt(input[i]);
            }
            Basic006 bsc = new Basic006();
            int result = bsc.findDup(A);
        }
        br.close();
    }
}

class Basic006 {
    int findDup(int[] A) {
        int temp = 0;
        int n = A.length;
        if(A[n/2] >= A[n/2 - 1]) {
            if(A[n/2] == A[n/2 + 1]) {
                temp = A[n/2];
            } else {
                temp = A[n/2 - 1];
            }
        }
        return temp;
    }
}
