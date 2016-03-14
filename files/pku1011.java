import java.util.Scanner;
import java.util.Arrays;
//import java.util.HashMap;
public class Main
{
	public static Scanner in = new Scanner(System.in);
	public static int sum,cLen,cNum;
	public static int[] sticks,sticksDescending;
	static int sticksCount;
	public static boolean[] flags;
	public static int stickslen;
	//public static HashMap map = new HashMap();
	public static void main(String[] args){
		do{
			sticksCount= in.nextInt();
			if(sticksCount==0){
				return;
			}
			// int maxNum = 0;
			sum = 0;
			stickslen = sticksCount -1;
			sticks = new int[sticksCount];
			sticksDescending = new int[sticksCount];
			flags = new boolean[sticksCount];
			for(int i=0;i<sticks.length;++i){
				sticks[i]= in.nextInt();
				flags[i] = false;
				// if(sticks[i]>maxNum){
				// 	maxNum = sticks[i];
				// }
				sum += sticks[i];
			}
//getSumCompile(list,new ArrayList<Integer>(),sums);
			//int _arr[] = deleteDulpicate(sums);
			 long time = System.currentTimeMillis();
			Arrays.sort(sticks);
			boolean isMatch = false;
			for(int i=0;i<sticks.length;i++){
				sticksDescending[i] = sticks[sticks.length-i-1];
			}
			// guess length
			for (cLen = sticksDescending[0];cLen < sum; cLen ++) {
				//len = _arr[i];
				// if(cLen <=maxNum)continue;
				if(sum%cLen !=0)continue;
				cNum = sum/cLen;
				if(Solution3(0,0,0)){
					isMatch = true;
					System.out.println(cLen );
				}
			}
			if(!isMatch){
				System.out.println(sum);
			}

			 System.out.println("times:" + (System.currentTimeMillis() - time));
		}while(true);
		
	}


	
	public static boolean Solution3(int stkNow,int _sum,int pos){
		if (cNum == stkNow ) {
			return true;
		}

		 int skip = -1;

		for (int i=pos; i<flags.length; i++) {
			if (flags[i]
			  || sticksDescending[i]==skip
			 ) {
				continue;
			}
			flags[i] = true;
			if (_sum + sticksDescending[i]<cLen ) {
				if(Solution3(stkNow,_sum + sticksDescending[i],i)){
					return true;
				}else{
					 skip = sticksDescending[i];
				}
//				while(i<sticks.length-1&&sticks[i]==sticks[i+1])
//					i++;
			}else if (_sum + sticksDescending[i] == cLen ){
				if(Solution3(stkNow + 1,0,0)){
					return true;
				}else{
					 skip = sticksDescending[i];
//					return false;	//prune,only one number can make sum equals length once time	
				}
			}
			flags[i] = false;

			if (_sum==0) {
				return false;	//prune,first search need not larger number
			}

//			while(i<sticks.length-1&&sticksDescending[i]==sticksDescending[i+1])
//				i++;
			
			// else 
			// 	flags[i] = false;
			// else
			// 	return false; // my prune. next number will make sum larger
		}
		return false;
	}
	
//	static void quicksort(int p, int r) {
//		if (p < r) {
//			int a = part(p, r);
//			quicksort(p, a - 1);
//			quicksort(a + 1, r);
//		}
//	}
//
//	static int part(int p, int r) {
//		int x = sticks[r];
//		int i = p - 1;
//		int j = p;
//		for (; j < r; j++) {
//			if (sticks[j] > x) {
//				i++;
//				int k = sticks[i];
//				sticks[i] = sticks[j];
//				sticks[j] = k;
//			}
//		}
//		int k = sticks[i + 1];
//		sticks[i + 1] = sticks[j];
//		sticks[j] = k;
//		return i + 1;
//	}
	
}