package astar;
import java.util.*;
class pair implements Comparator<pair>
{
	int vertex;
	int hn;
	int gn;//heuristic value of each node
	int fn;								//fn=hn+gn
	pair(int v,int h,int g)
	{
		vertex=v;
		hn=h;
		gn=g;
		fn=hn+gn;
	}
	pair()
	{
		
	}
	@Override
	public int compare(pair arg0, pair arg1) {
		// TODO Auto-generated method stub
		if(arg0.fn>arg1.fn)
		{
			return 1;
		}
		else
		{
			return -1;
		}
		
	}
	
}

class astar
{
	int n,e;
	int graph[][];
	int start;
	int end;
	PriorityQueue<pair> pq;
	int[] heuristics;
	Scanner sc=new Scanner(System.in);
	void accept()
	{
		System.out.println("Enter number of vertices:-");
		n=sc.nextInt();
		graph=new int[n][n];
		pq=new PriorityQueue<>(n,new pair());
		System.out.println("Enter number of edges:-");
		e=sc.nextInt();
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter start:-");
			int start=sc.nextInt();
			System.out.println("Enter end:-");
			int end=sc.nextInt();
			System.out.println("Enter edge value:-");
			graph[start][end]=sc.nextInt();
		}
		heuristics=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter heuristics for vertex "+(i+1));
			heuristics[i]=sc.nextInt();
		}
		System.out.println("Enter start vertex:-");
		start=sc.nextInt();
		System.out.println("Enter end vertex:-");
		end=sc.nextInt();
	}
	void implement()
	{
	pair starting=new pair(start,heuristics[start],0);
	pq.add(starting);
	int visited[]=new int[n];
	int cost=0;
	ArrayList<Integer> al=new ArrayList<>();
	while(!pq.isEmpty()) {
		pair temp=pq.remove();
		al.add(temp.vertex);
		if(temp.vertex==end) {System.out.println("\n\ncost="+temp.gn);break;}
		for(int i=0;i<n;i++)
		{
			if(graph[temp.vertex][i]!=0)
			{
				pair h=new pair(i,heuristics[i],(graph[temp.vertex][i]+temp.gn));
				pq.add(h);
			}
		}
	}
	System.out.print("\n\npath          :  ");
	int j=0;
	j=al.size()-2;
	for(int i=al.size()-1;i>=0;i--)
	{
		if(al.get(j)==start)break;
		while(graph[al.get(j)][al.get(i)]==0)
		{
			j=j-1;
		}
		if(graph[al.get(j)][al.get(i)]!=0)
		{
			cost=cost+graph[al.get(j)][al.get(i)];
			System.out.print(al.get(i)+"  ");
		}
		
	}
	System.out.print(al.get(start));
	}
}

public class astarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		astar a=new astar();
		a.accept();
		a.implement();
	}

}
/*
 * 
 * OUTPUT:-
 * 
 * Enter number of vertices:-
5
Enter number of edges:-
7
Enter start:-
0
Enter end:-
1
Enter edge value:-
1
Enter start:-
0
Enter end:-
2
Enter edge value:-
4
Enter start:-
1
Enter end:-
2
Enter edge value:-
2
Enter start:-
1
Enter end:-
3
Enter edge value:-
5
Enter start:-
1
Enter end:-
4
Enter edge value:-
12
Enter start:-
2
Enter end:-
3
Enter edge value:-
2
Enter start:-
3
Enter end:-
4
Enter edge value:-
3
Enter heuristics for vertex 1
7
Enter heuristics for vertex 2
6
Enter heuristics for vertex 3
2
Enter heuristics for vertex 4
1
Enter heuristics for vertex 5
0
Enter start vertex:-
0
Enter end vertex:-
4

cost=8

path          :  4  3  2  1  0
 * 
 * 
 */


