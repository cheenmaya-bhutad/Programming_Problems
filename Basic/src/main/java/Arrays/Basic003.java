/*
    Given a list of integers, rearrange the list such that it consists of alternating minimum-maximum elements using
    only list operations.The first element of the list should be the minimum of all elements and the second element
    should be a maximum of all elements present in the list. Similarly, the third element will be the next minimum
    element and the fourth element is the next maximum element, and so on. Use of extra space is not permitted. Store
    the answer in the answer[] array. You don't need to print that.

    Note : All the elements in the array are unique.

    Example 1:

    Input
    5
    4 5 1 2 3
    Output
    1 5 2 4 3
    Explanation:
    In the first example minimum element is 1,
    maximum element is 5, second minimum is
    2 and so on, thus the rearranged array is
    [1, 5, 2, 4, 3]

    Example 2:

    Input
    4
    1 2 3 4
    Output
    1 4 2 3

    Your Task:
    You don't need to read input or print anything.
    Your task is to complete the function Rearrange() which takes the array A[] and its size N as inputs and stores the
    final modified list in the answer[].

    Expected Time Complexity: O(N.log(N))
    Expected Auxiliary Space: O(1)

    Constraints:
    1 ≤ N ≤ 105
    1 ≤ A[i] ≤ 106
 */

package Arrays;

import java.io.*;

public class Basic003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] input = br.readLine().trim().split(" ");
            int[] a = new int[input.length];
            int[] answer = new int[input.length];
            for(int i = 0;i<input.length;i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            Basic004.rearrange(a,a.length,answer);
        }
        br.close();
    }
}

class Basic004 {
    public static void rearrange(int[] a,int n,int[] answer) {
        sort(a,0,n-1);
        if(n%2 != 0)
            answer[n-1] = a[n/2];
        for(int i = 0;i<n/2;i++) {
            answer[i*2] = a[i];
            answer[i*2 - 1] = a[n-1-i];
        }
    }

    public static void sort(int[] a,int l,int r) {
        if(l < r) {
            int m = (l+r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    public static void merge(int[] a,int l,int m,int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0;i < n1;i++)
            L[i] = a[l+i];
        for(int j = 0;j < n2;j++)
            L[j] = a[m+1+j];
        int i = 0,j = 0,k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
}
