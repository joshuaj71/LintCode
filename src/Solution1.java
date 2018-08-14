import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
//        long result = trailingZeros(15);
//        int result = digitCounts(0, 10);
        int result = nthUglyNumber(9);




        System.out.print(result);
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
        int i,j,num=0;
        if(k==0)
            num=1;
        for(i=0;i<=n;i++){
            j=i;
            while (j!=0){
                if(j%10==k)
                    num++;
                j/=10;
            }
        }
        return num;
    }


    //    4. 丑数 II
//    设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
//    符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
    static int nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }

        return uglys.get(n - 1);
    }

}
