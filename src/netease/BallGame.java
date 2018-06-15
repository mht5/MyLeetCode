package netease;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入进球数，每次进球位置
 * 找到一个合适的三分线(d)使scoreA-scoreB有最大值
 * @author mhts
 *
 */
public class BallGame {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
//		获取数据
		System.out.println("A队进球数，每次进球投篮位置(用逗号隔开)：");
		String a=scanner.nextLine();
		System.out.println("B队进球数，每次进球投篮位置(用逗号隔开)：");
		String b=scanner.nextLine();
		drawLine(a, b);
	}
	
	public static void drawLine(String a, String b){
//		分割数据
		String[] strA=a.split(",");
		String[] strB=b.split(",");
		int countA=Integer.parseInt(strA[0]);
		int countB=Integer.parseInt(strB[0]);
		List<Integer> win=new ArrayList<Integer>();
//		检查数据
		if((strA.length!=countA+1)||(strB.length!=countB+1)){
			System.out.println("数据错误，请检查输入的数据！");
		}
		else{
//			转换类型
			int[] intA=new int[strA.length-1];
			int[] intB=new int[strB.length-1];
			for(int i=1; i<strA.length;i++){
				intA[i-1]=Integer.parseInt(strA[i]);
			}
			for(int i=1; i<strB.length;i++){
				intB[i-1]=Integer.parseInt(strB[i]);
			}
			for(int i=0; i<intA.length; i++){
				System.out.println(intA[i]);
			}
			for(int i=0; i<intB.length; i++){
				System.out.println(intB[i]);
			}
//			循环找出A队得分比B对得分多的数据，将多出的比分放到List
			for(int d=0; d<100; d++){
				int scoreA=0;
				int scoreB=0;
				for(int i=0; i<intA.length;i++){
					if(intA[i]<d){
						scoreA+=3;
						System.out.println(d+"           "+intA[i]+": scoreA+3="+scoreA);
					}
					else{
						scoreA+=2;
						System.out.println(d+"           "+intA[i]+": scoreA+2="+scoreA);
					}
				}
				for(int i=0; i<intB.length;i++){
					if(intB[i]<d){
						scoreB+=3;
						System.out.println(d+"           "+intB[i]+": scoreB+3="+scoreB);
					}
					else{
						scoreB+=2;
						System.out.println(d+"           "+intB[i]+": scoreB+2="+scoreB);
					}
				}
				if(scoreA>scoreB){
					System.out.println("**********************************");
					System.out.println(d+"     "+(scoreA-scoreB));
					System.out.println("**********************************");
					win.add(scoreA-scoreB);
				}
			}
			Object[] scoreArray=win.toArray();
			Arrays.sort(scoreArray);
//			for(int i=0; i<scoreArray.length; i++){
//				System.out.println(scoreArray[i]);
//			}
			System.out.println("**************");
			System.out.println(scoreArray[scoreArray.length-1]);
		}
	}
}
