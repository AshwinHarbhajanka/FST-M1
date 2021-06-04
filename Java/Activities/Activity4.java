package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		
		int[] numList = {4,3,2,10,12,1,5,6};
		System.out.println(Arrays.toString(numList));
		
		int k = 0;
		while(k<numList.length) {
		for(int i=k+1; i<numList.length; i++) {
			if(numList[k]>numList[i]) {
				int key = numList[i];
				for(int j=i;j>=k+1;j--) {
					numList[j] = numList[j-1];
				}
			numList[k] = key;
			}}
		k++;
		}
		System.out.println(Arrays.toString(numList));
	}}
