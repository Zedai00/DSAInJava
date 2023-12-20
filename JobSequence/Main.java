import java.util.Scanner;

public class JobSeq {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter no of items: ");
    int n = sc.nextInt();
    System.out.print("Enter Weights: ");
    int[] weight = new int[n];
    for (int i = 0; i < n; i++) {
      weight[i] = sc.nextInt();
    }
    System.out.print("Enter Profits: ");
    int[] profits = new int[n];
    for (int i = 0; i < n; i++) {
      profits[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (profits[i] > profits[j]) {
          swap(profits, i, j);
          swap(weight, i, j);
        }
      }
    }
    int[] result = new int[findMax(weight)];
    for (int i = 0; i < weight.length; i++) {
      if (result[weight[i] - 1] == 0) {
        result[weight[i] - 1] = profits[i];
      } else {
        for (int j = weight[i] - 1; j >= 0; j--) {
          if (result[j] == 0) {
            result[j] = profits[i];
          }
        }
      }
    }
    int sum = 0;
    for (int i = 0; i < result.length; i++) {
      sum += result[i];
    }
    System.out.println(sum);
    sc.close();
  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }
}
