import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        mergeSort(arr) - method that sort
        merge(arr, leftArr, rightArr)
         */

        int[] arr = new int[] {1, 34, 2, 3, 45, 34, 23, 45, 32, 2, 7, 8};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr) {
        int lenghtArr = arr.length; //длинна массива
        if(lenghtArr == 1) return; //условие выхода
        int mid = lenghtArr/2;
        int[] l = new int[mid];
        int[] r = new int[lenghtArr - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = 0; i < lenghtArr - mid; i++) {
            r[i] = arr[i + mid];                     // исправлено
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr,l,r);
    }

    private static void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right)
            if(l[i] < r[j]) {
                arr[idx] = l[i];
                i++;
                idx++;
            } else {
                arr[idx] = r[j];
                j++;
                idx++;
            }
        for(int ll = i; ll < left; ll++ )
            arr[idx++] = l[ll];
        for(int rr = j; rr < right; rr++ )
            arr[idx++] = r[rr];
    }
}
