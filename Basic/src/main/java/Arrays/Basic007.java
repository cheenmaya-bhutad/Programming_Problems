/*
    Given an array, arr[] of N elements such that every element of the array is an integer in the range 1 to n, the
    task is to find the sum of all the distinct elements of the array.

    Example 1:

    Input: N = 9
    arr[] = {5, 1, 2, 4, 6, 7, 3, 6, 7}
    Output: 28
    Explanation: The distinct elements in
    the array are 1, 2, 3, 4, 5, 6, 7.
    Example 2:

    Input: N = 3, arr[] = {1, 1, 1}
    Output: 1

    Your Task:
    This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You
    just need to complete the function sumOfDistinct() that takes array arr[] and integer N as parameters and returns
    the sum of a distinct elements of the array.

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(1).

    Constraints:
    1 ≤ N ≤ 106
*/
package Arrays;

import java.io.*;

public class Basic007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            String[] input = br.readLine().trim().split(" ");
            for(int i = 0;i < input.length;i++) {
                arr[i] = Long.parseLong(input[i]);
            }
            Basic008 bsc = new Basic008();
            long result = bsc.findSum(arr, N);
        }
        br.close();
    }
}

class Basic008 {
    public long findSum(long[]arr, int N) {
        long sum = 0,temp = arr[0];
        for(long i : arr) {
            if(temp < i)
                temp = i;
        }
        long[] nums = new long[(int)temp];
        for(long i = 0;i < N;i++) {
            nums[(int)arr[(int)i] - 1] = 1;
        }
        for(long i=0;i < temp;i++) {
            if(nums[(int)i] == 1)
                sum += i+1;
        }
        return sum;
    }
}
