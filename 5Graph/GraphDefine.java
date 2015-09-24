import java.util.*;
class GraphNode{ 
	int val;
	GraphNode next;
	GraphNode[] neighbors;
	boolean visited=false;
	GraphNode(int x){  val = x;}
	GraphNode(int x, GraphNode[] n){
		val = x;
		neighbors = n;
	}
    public void print(){
        //System.out.println("value: "+val);
        System.out.print("\t"+val);
    }
    public void printNeighbors(){
        for(GraphNode node : neighbors){
            System.out.print(node.val+"\t");        
        }
        System.out.println();
    }
}

public class GraphDefine{
    public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1); 
		GraphNode n2 = new GraphNode(2); 
		GraphNode n3 = new GraphNode(3); 
		GraphNode n4 = new GraphNode(4); 
		GraphNode n5 = new GraphNode(5); 
		GraphNode n6 = new GraphNode(6); 
		GraphNode n7 = new GraphNode(7); 
		n1.neighbors = new GraphNode[]{n2,n3,n5};
		n2.neighbors = new GraphNode[]{n1,n4};
		n3.neighbors = new GraphNode[]{n1,n4,n5};
		n4.neighbors = new GraphNode[]{n2,n3,n5};
		n5.neighbors = new GraphNode[]{n1,n3,n4,n6};
		n6.neighbors = new GraphNode[]{n4,n5,n7};
		n7.neighbors = new GraphNode[]{n4,n6};
		//BFS
        //bfs(n1);
        dfs(n1);
	}
	
	
	public static void bfs(GraphNode root){
	    LinkedList<GraphNode> queue=new LinkedList();
	    queue.add(root);
	    int count=0;
	    while (queue.size()!=0){
	        count++;
            GraphNode node = queue.remove();
            if (!node.visited) {
                node.print();
                node.visited=true;
                GraphNode[] neighbors=node.neighbors;
                for (GraphNode neighbor: neighbors){
                    if(!neighbor.visited) queue.add(neighbor);
                }
            }
	    }
	    System.out.println("\ncount: "+count);
	}
	
	public static void dfs(GraphNode node){
		if (node.visited) return;
		node.print();
		node.visited=true;
        GraphNode[] neighbors=node.neighbors;
        for (GraphNode neighbor: neighbors){
            if(!neighbor.visited) dfs(neighbor);
        }
	}
}