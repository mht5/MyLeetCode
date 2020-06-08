package other;

public class JosephusProblem {

    public static void main(String[] args) {
        int num = 10;
        solve(num);
    }

    private static void solve(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i + 1;
        }
        int index = 0;
        while (true) {
            int count = 0;
            int indexForLast = 0;
            for (int i = 0; i < num; i++) {
                if (arr[i] > 0) {
                    index++;
                    count++;
                    if (count == 1) {
                        indexForLast = i;
                    }
                }
                if (index > 0 && index % 2 == 0) {
                    System.out.print(arr[i] + " ");
                    arr[i] = 0;
                    index = 0;
                }
                if (i == num - 1 && count == 1 && arr[indexForLast] != 0) {
                    System.out.print(arr[indexForLast] + " ");
                }
            }
            if (count == 1) {
                break;
            }
        }
    }
}
