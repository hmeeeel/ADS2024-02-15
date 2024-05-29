package by.it.group351005.egorov.lesson08;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача на программирование: рюкзак без повторов

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        число золотых слитков
                    (каждый можно использовать только один раз).
Следующая строка содержит n целых чисел, задающих веса каждого из слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.

Sample Input:
10 3
1 4 8
Sample Output:
9

*/

public class B_Knapsack {

    int getMaxWeight(InputStream stream ) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner scanner = new Scanner(stream);
        int w=scanner.nextInt();
        int n=scanner.nextInt();
        int gold[]=new int[n];
        for (int i = 0; i < n; i++) {
            gold[i]=scanner.nextInt();
        }
        int[][] temp = new int[n+1][w];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w; j++) {
                if (i==0) {
                    temp[i][j] = 0;
                }
                else if (gold[i-1] <= j){
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-gold[i-1]]+gold[i-1]);
                }
                else
                    temp[i][j] = temp[i-1][j];
            }
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return temp[n][w-1];
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream stream = B_Knapsack.class.getResourceAsStream("dataB.txt");
        B_Knapsack instance = new B_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }

}