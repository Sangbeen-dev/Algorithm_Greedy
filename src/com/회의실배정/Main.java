package com.회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
	public int s, e;
	Time(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Time o) {
		if(this.e==o.e) return this.s - o.s;
		else return this.e - o.e;
	}
}

public class Main {
	public int solution(ArrayList<Time> arr) {
		int cnt = 0;
		int endTime = Integer.MIN_VALUE;
		for(Time t: arr) {
			if(t.s>= endTime) {
				cnt++;
				endTime = t.e;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Time> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			arr.add(new Time(s,e));
		}
		Collections.sort(arr);
		//for(Time tt : arr) System.out.println(tt.s+" "+tt.e);
		System.out.println(t.solution(arr));
	}
}
