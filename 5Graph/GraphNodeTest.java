import java.util.*;
class GraphNode{
    public int label;
    public boolean visited;
    GraphNode[] neighbors;
    
    public GraphNode (int label){
        this.label=label;
    }
    public GraphNode (int label, GraphNode[] neighbors){
        this.label=label;
        this.neighbors=neighbors;
    }
}

public class GraphNodeTest{
    public static void dfs (GraphNode node){
        if (node.visited) return;
        node.visited=true;
        System.out.println("visit: "+node.label);
        if (node.neighbors!=null){
            for (GraphNode neighbor: node.neighbors){
                dfs(neighbor);
            }   
        }
    }    
    
    public static void bfs (GraphNode node){
        LinkedList<GraphNode> queue=new LinkedList();
        queue.add(node);
        node.visited=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i=0; i<size; i++){
                GraphNode item=queue.remove();
                System.out.println("visit: "+item.label);
                if (item.neighbors!=null){
                    for (GraphNode neighbor: item.neighbors){
                        if (!neighbor.visited) {
                            neighbor.visited=true;
                            queue.add(neighbor);
                        }
                    }
                }             
            }
        }
    }
    
    public static void main(String[] args){
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
        bfs(n1);        
    }
}