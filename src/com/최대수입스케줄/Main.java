package com.최대수입스케줄;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
	public int pay;
	public int day;
	Lecture(int pay, int day){
		this.pay = pay;
		this.day = day;
	}
	@Override
	public int compareTo(Lecture ob) {
		return ob.day - this.day;
	}
}

public class Main {
	static int n, max=Integer.MIN_VALUE;
	public int solution(ArrayList<Lecture> arr){
		int answer=0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);
		int j=0;
		for(int i=max; i>=1; i--){
			for(; j<n; j++){
				if(arr.get(j).day<i) break;
				pQ.offer(arr.get(j).pay);
			}
			if(!pQ.isEmpty()) answer+=pQ.poll();
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int pay = kb.nextInt();
			int day = kb.nextInt();
			arr.add(new Lecture(pay, day));
			if(day>max) max = day;
		}
		//for(Lecture lt : arr) System.out.println(lt.pay+" "+lt.day);
		System.out.println(t.solution(arr));
	}
}
