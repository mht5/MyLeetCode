package leetcode.string;

/**
 * https://leetcode.com/problems/judge-route-circle/description/
 * @author mhts
 * @date 2018Äê7ÔÂ26ÈÕ
 */
public class JudgeRouteCircle {

	public static void main(String[] args) {
		String str = "UDRLURDLRL";
		System.out.println(judgeCircle1(str));
	}
	
	public static boolean judgeCircle1(String moves) {
		int[] array = new int[18];
		for (char ch : moves.toCharArray()) {
			array[ch - 'D']++;
		}
		return array[0] == array[17] && array[8] == array[14];
	}
	
	public static boolean judgeCircle(String moves) {
		int[] array = new int[2];
		for (char ch : moves.toCharArray()) {
			if (ch == 'U') {
				array[0] += 1;
			} else if (ch == 'D') {
				array[0] -= 1;
			} else if (ch == 'L') {
				array[1] += 1;
			} else {
				array[1] -= 1;
			}
		}
		return array[0] == 0 && array[1] ==0;
	}
}
