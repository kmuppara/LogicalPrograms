package com.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMay19 {

	/*
	input: size : 5
		1 1
		1 10
		1 3
		1 2
		2
	output: list: [10 3 2 1]
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		System.out.println("Enter size ");
		int N = Integer.parseInt(sc.nextLine());
		String [] s_arr = new String[N];
		for(int i=0; i<N; i++) {
			System.out.println("Enter tasks.. ");
			s_arr[i] = sc.nextLine(); 
		}
		for(String s : s_arr) {
			String [] temp = s.split(" ");
			int firstElement = Integer.parseInt(temp[0]);
			if(firstElement==1) {
				int element = Integer.parseInt(temp[1]);
				int index = binarySearch(list, 0, list.size()-1, element );
				list.add(index, element);
			}
			else {
				if(list.size()<3) System.out.println("Not enough enemies");
				else {
					System.out.println(list.get((list.size()/3)-1));
				}
			}
		}
		System.out.println(list);
	}
	
	public static int binarySearch(List<Integer> list, int l, int r, int x)
	{
		if (r>=l)
		{
			int mid = l + (r - l)/2;

			if (list.get(mid) == x)
			return mid;
			
			if (list.get(mid) > x)
			return binarySearch(list, mid+1, r, x);
			
			return binarySearch(list, l, mid-1, x);
		}
		return l;
	}
	
	public static void add(List<Integer> list, int element) {
			int index = list.size();
			if( index==0) list.add(element);
			else
			{
				for(int i: list) {
					if(element >= i ) {
						index = list.indexOf(i);
						break;
					}
				}
				list.add(index, element);
			}
		}
}
