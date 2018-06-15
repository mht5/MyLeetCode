package netease;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入路灯个数和道路长度
 * 输入每个路灯的位置
 * 每个路灯照亮的范围相同，找出路灯照亮范围的最小值
 * @author mhts
 *
 */
public class Light {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
//		获取数据
		System.out.println("input n and l(split by ','):");
		String a=scanner.nextLine();
		System.out.println("input location of lights: ");
		String b=scanner.nextLine();
//		分割数据
		String[] strA=a.split(",");
		int n=Integer.parseInt(strA[0]);
		int l=Integer.parseInt(strA[1]);
		String[] strB=b.split(",");
//		检查数据
		if(strB.length!=n){
			System.out.println("Data error, please input again.");
		}
		else{
			int[] intL=new int[strB.length];
			for(int i=0; i<strB.length; i++){
				intL[i]=Integer.parseInt(strB[i]);
			}
//			调用findD()
			findD(n, l ,intL);
		}
	}

	private static void findD(int n, int l, int[] intL) {
//		找出相邻两个路灯的距离，放进数组
		Arrays.sort(intL);
		double[] distance=new double[intL.length-1];
		for(int i=0; i<intL.length-1; i++){
			distance[i]=intL[i+1]-intL[i];
		}
//		数组排序
		Arrays.sort(distance);
//		找出距离最长的两个相邻路灯的距离，除以2，得到路灯最小光照范围
		double d=distance[distance.length-1]/2;
		System.out.format("%.2f", d);
	}
}
