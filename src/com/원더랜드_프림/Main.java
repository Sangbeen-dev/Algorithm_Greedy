package com.원더랜드_프림;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	public int vex;
	public int cost;	
	public Edge(int vex, int cost){
		this.vex = vex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] ch = new int[n+1];
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++) graph.add(new ArrayList<Edge>());
		
		for(int i=0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			graph.get(a).add(new Edge(b,c));
			graph.get(b).add(new Edge(a,c));
		}
		int answer = 0;
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1,0));
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int v = tmp.vex;
			if(ch[v]==0) {
				ch[v]=1;
				answer += tmp.cost;
				for(Edge ob: graph.get(v)) {
					if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex,ob.cost));
				}
			}
		}
		System.out.println(answer);
	}
}
