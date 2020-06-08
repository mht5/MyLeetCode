package other;

public class NumberCompression {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        int[] s = new int[count];
//
//        for (int i = 0; i < s.length; i++) {
//            if (scanner.hasNext()) {
//                s[i] = scanner.nextInt();
//            }
//        }
//        ------------------以上为拿到输入数据--------下面的数据为模拟输入-------------------
        int[] s = {1, 3, 4, 5, 6, 3, 4, 5, 7, 8, 9, 10, 7};

//        数据长度小于3就直接输出吧，无论是不是连续的
        if (s.length < 3) {
            for (int l = 0; l < s.length; l++) {
                System.out.print(s[l]);
                if (l < s.length - 1) {
                    System.out.print(",");
                }
            }
            return;
        }
//        如果数据有一定长度，题目说小于7，但是我这里没考虑上限，两个游标，一个是m 一个是n n是比m大一的数
        for (int m = 0; m < s.length; m++) {
            int n = m + 1;
//            首先游标大1的那个 不能超过数组长度 并且连续代表差值为1
            if (n < s.length && s[n] - s[m] == 1) {
//                这里使用递归来判断到底有多少个连续的数
                int times = isContinue(s, n, m, 0);
//                int times=2; 这里是数据{1,3,4,5,7},也就是给定的测试数据的模拟实现，用于测试主框架是否正确 从0开始 3个连续的就只会到2 因为只需要4-3 5-4两组
                if (times >= 2) {
//                    如果有2次，说明就是3个连续的数。这里将m移动到最后一个数 可以看成end
                    m = m + times;
                    System.out.print(s[n - 1] + "-" + s[m]);
                }
            } else {
//                如果当前位置连续的可能性为0 就直接输出吧
                System.out.print(s[m]);
            }
//            逗号的判断，没什么好说的
            if (m != s.length - 1) {
                System.out.print(",");
            }
        }

    }

    /**
     * @s 数组本身
     * @x 需要判断的元素起始位置 也就是前一个数
     * @y x的后一个数
     * @count 如果后面的数-前一位的数=1 则每次+1
     */
    public static int isContinue(int[] s, int y, int x, int count) {
        if (y < s.length && s[y] - s[x] == 1) {
            count++;
            x++;
            y++;
//            递归直到s[y] - s[x] != 1
            return isContinue(s, y, x, count);
        }
        return count;
    }
}