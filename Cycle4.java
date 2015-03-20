import java.util.Arrays;
import java.util.Random;

/**
 * Найти в массиве число, которое повторяется наибольшее количество раз.
 * Не использовать коллекции
 * Created by user on 19.03.2015.
 */
public class Cycle4 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int N = 10; // диапазон возможных значений 0..10
        Random rand = new Random();

        // Задание начального массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(N);
        }
        System.out.println("Массив для поиска: " + Arrays.toString(arr));

        // Определение количества повторении каждого элемента массива
        int scoreFreq; // счетчик значений
        int[][] Freq = new int[N][2];

        // Первый столбец массива содержит возможные значения "к поиску"
        for (int i = 0; i < Freq.length; i++) {
            Freq[i][0] = i;
        }

        // Определение частоты повторения каждого числа в исходной матрице
        // на выходе цикла 2мерный массив, где 0-ой столбец - возможные варианты значений,
        // а 1ый - частота повторения соответвующего числа.

        for (int i = 0; i < N; i++) {
            scoreFreq = 0;
            for (int j = 0; j < arr.length; j++) {

                if (arr[j] == i) {
                    scoreFreq = scoreFreq + 1;
                    Freq[i][1] = scoreFreq;
                }
            }
        }

        System.out.print("Общее распределение по повторяемости, [число, частота]: ");
        for (int i = 0; i < Freq.length; i++) {
            System.out.print(" " + Arrays.toString(Freq[i]));
        }
        System.out.println();

        // Поиск максимальной частоты повторения числа

        int[] forSort = new int[Freq.length]; // промежуточный массив для оценки частоты повторений

        for (int i = 0; i < Freq.length; i++) {
            forSort[i] = Freq[i][1];
        }
        Arrays.sort(forSort);


        System.out.print("Наибольшая повторяемость, [число, частота]: ");
        for (int i = 0; i < forSort.length; i++) {
            if (Freq[i][1] == forSort[forSort.length-1]){
                System.out.print(" " + Arrays.toString(Freq[i]));
            }
        }
    }

}