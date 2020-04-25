package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 晨
 */
public class Main {

    public static void main(String[] args) {
        List<String> player =  new ArrayList<>();
        int[] fraction = new int[]{0,0};
        player.add("xwp");
        player.add("xxx");
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("玩家1为" + player.get(0));
        System.out.println("玩家2为" + player.get(1));
        System.out.println("请输入你们要玩几盘");
        int end = sc.nextInt();
        int maxEnd = end/2 + 1;
        System.out.println("双人猜数字小游戏现在开始");
        for (int i = 1; i <= end; i++) {
            int n = random.nextInt(100)+1;
            int max = 100;
            int min = 1;
            int begin = random.nextInt(2);
            if (fraction[0] >= maxEnd || fraction[1] >= maxEnd){
                break;
            }
            if (i < end && i > 1) {
                System.out.println("现在进入第" + i + "回合");
            }
            System.out.println("请" + player.get(begin) + "先输入一个" + min + "--" + max + "的数字:");
            while (true) {
                int x = sc.nextInt();
                boolean result = gameRule(x, max, min);
                if (result) {
                    if (x < n) {
                        min = x + 1;
                        begin = -(begin - 1);
                        System.out.println("你没猜中，请" + player.get(begin) + "再猜一个" + min + "--" + max + "的整数");
                    } else if (x > n) {
                        max = x - 1;
                        begin = -(begin - 1);
                        System.out.println("你没猜中，请" + player.get(begin) + "再猜一个" + min + "--" + max + "的整数");
                    } else {
                        System.out.println("恭喜" + player.get(begin) + "!!!你猜到了");
                        fraction[begin]++;
                        System.out.println("当前比分为" + fraction[0] + ":" + fraction[1]);
                        break;
                    }
                }
            }
        }
        System.out.println("game over");
        String winPlayer = fraction[0]>fraction[1]?player.get(0):player.get(1);
        System.out.println("最后的获胜方为" + winPlayer + "!");
    }
    public static boolean gameRule(int x, int max, int min){
        if (x < min || x > max){
            System.out.println("请输入符合条件的数字！");
            return false;
        }
        return true;
    }
}
