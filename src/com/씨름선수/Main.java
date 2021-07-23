package com.씨름선수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
	public int h, w;
	Body(int h, int w){
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Body o) {
		return o.h-this.h;
	}
}

public class Main {
	public int solution(ArrayList<Body> arr, int n) {
		int cnt = 0;
		Collections.sort(arr);
		int max = Integer.MIN_VALUE;
		for(Body b: arr) {
			if(b.w > max) {
				max = b.w;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Body> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int h = kb.nextInt();
			int w = kb.nextInt();
			arr.add(new Body(h,w));
		}
		System.out.println(t.solution(arr, n));
	}
}
