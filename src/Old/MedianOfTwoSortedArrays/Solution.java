package Old.MedianOfTwoSortedArrays;

/**
 * Authored by GongLi at 22:03 on 7/2/14
 */


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {

        int sizeA = A.length;
        int sizeB = B.length;

        return findMedian(A, 0, sizeA - 1, B, 0, sizeB - 1);
    }



    public double findMedian(int A[], int startA, int endA, int B[], int startB, int endB){

        if(endA < startA){
            int temp = endB - startB + 1;
            int temp1 = (startB + endB)/2;

            if(temp % 2 == 0)
                return (B[temp1] + B[temp1+1])/2.0;
            else
                return B[(startB + endB) / 2];
        }
        if(endB < startB){
            int temp = endA- startA + 1;
            int temp1 = (startA + endA) / 2;

            if(temp % 2 == 0)
                return (A[temp1] + A[temp1+1]) / 2.0;
            else
                return A[(startA + endA) / 2];
        }



        int numOfElementsA = endA - startA + 1;
        int numOfElementsB = endB - startB + 1;

        double middleA, middleB;
        if(numOfElementsA % 2 == 0)
            middleA = (A[(startA + endA) / 2] + A[(startA + endA) / 2 + 1])/2.0;
        else middleA = A[(startA + endA)/2];

        if(numOfElementsB % 2 == 0)
            middleB = (B[(startB + endB) /2 ] + B[(startB + endB) / 2 + 1])/2.0;
        else middleB = B[(startB + endB) / 2];



        if(middleA < middleB)
            return findMedian(A, startA, endA, B, startB, (startB + endB) / 2 );
        else if (middleA > middleB)
            return findMedian(A, startA, (startA + endA) / 2, B, startB, endB);
        else
            return middleA;

    }



    public static void main(String[] args) {
        Solution s = new Solution();

        int[] temp = new int[2];
        temp[0] = 1; temp[1] = 2;

        int[] temp1 = new int[3];
        temp1[0] = 1; temp1[1] = 2;temp1[2] = 3;

        double number =  s.findMedianSortedArrays(temp, temp1);
        System.out.println(number);
    }
}
