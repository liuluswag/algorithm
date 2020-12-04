package offer;

import java.util.ArrayList;

public class LastRemaining {

    /**
     * 模拟链表
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n,int m){
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n ;i++){
            list.add(i);
        }
        int idx = 0;
        while(n > 1){
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining2(int n,int m){
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n ;i++){
            ans = (ans + m) % i;
        }
        return ans;
    }

}
