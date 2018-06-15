package netease;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ����·�Ƹ����͵�·����
 * ����ÿ��·�Ƶ�λ��
 * ÿ��·�������ķ�Χ��ͬ���ҳ�·��������Χ����Сֵ
 * @author mhts
 *
 */
public class Light {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
//		��ȡ����
		System.out.println("input n and l(split by ','):");
		String a=scanner.nextLine();
		System.out.println("input location of lights: ");
		String b=scanner.nextLine();
//		�ָ�����
		String[] strA=a.split(",");
		int n=Integer.parseInt(strA[0]);
		int l=Integer.parseInt(strA[1]);
		String[] strB=b.split(",");
//		�������
		if(strB.length!=n){
			System.out.println("Data error, please input again.");
		}
		else{
			int[] intL=new int[strB.length];
			for(int i=0; i<strB.length; i++){
				intL[i]=Integer.parseInt(strB[i]);
			}
//			����findD()
			findD(n, l ,intL);
		}
	}

	private static void findD(int n, int l, int[] intL) {
//		�ҳ���������·�Ƶľ��룬�Ž�����
		Arrays.sort(intL);
		double[] distance=new double[intL.length-1];
		for(int i=0; i<intL.length-1; i++){
			distance[i]=intL[i+1]-intL[i];
		}
//		��������
		Arrays.sort(distance);
//		�ҳ����������������·�Ƶľ��룬����2���õ�·����С���շ�Χ
		double d=distance[distance.length-1]/2;
		System.out.format("%.2f", d);
	}
}
