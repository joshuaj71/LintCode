import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        long result = trailingZeros(15);
//        int result = digitCounts(0, 10);
        //0  1  2  3  4  5  6  7  8   9   10
        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
        int result = nthUglyNumber(10);
        long endTime = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("gap millie = " + (endTime - startTime));
    }

    /*2. 尾部的零
    设计一个算法，计算出n阶乘中尾部零的个数*/
    static long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
//        return n == 0 ? 0 : n / 5 + trailingZeros(n / 5);
    }

//    3. 统计数字
//    计算数字k在0到n中的出现的次数，k可能是0~9的一个值
//    例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)

    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    static int digitCounts(int k, int n) {
        // write your code here
        int i, j, num = 0;
        if (k == 0)
            num = 1;
        for (i = 0; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % 10 == k)
                    num++;
                j /= 10;
            }
        }
        return num;
    }


    //    4. ugly number II
    static int nthUglyNumber(int n) {
/*
     index  0   1   2   3   4   5   6
      1     1*2 2*2 3*2 4*2 5*2 6*2 8*2
            1*3 2*3 3*3 4*3 5*3 6*3 8*3
            1*5 2*5 3*5 4*5 5*5 6*5 8*5
*/
        //0  1  2  3  4  5  6  7  8   9   10
        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
        int[] ugly = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        int item2 = 2, item3 = 3, item5 = 5;
        ugly[0]=1;
        for (int i = 1; i < n; i++) {
            int min=Math.min(Math.min(item2, item3), item5);
            ugly[i]=min;
            if (min == item2)
                item2 = 2 * ugly[++index2];
            if(min==item3)
                item3 = 3 * ugly[++index3];
            if(min==item5)
                item5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }

}
