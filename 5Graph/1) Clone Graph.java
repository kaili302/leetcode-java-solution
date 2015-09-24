/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
public class Solution {
    //bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root==null) return null;
        LinkedList<UndirectedGraphNode> queue=new LinkedList();
        UndirectedGraphNode copy=new UndirectedGraphNode(root.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap();
        map.put(root, copy);
        queue.add(root);
        while (queue.size()!=0){
            UndirectedGraphNode node=queue.remove();
            UndirectedGraphNode nodeNew=map.get(node);
            ArrayList<UndirectedGraphNode> neighbors=(ArrayList<UndirectedGraphNode>)node.neighbors;
            for (UndirectedGraphNode neighbor: neighbors){
                if (!map.containsKey(neighbor)){
                    queue.add(neighbor);
                    UndirectedGraphNode tmp=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, tmp);
                    nodeNew.neighbors.add(tmp);
                }
                else
                    nodeNew.neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }

    //dfs 
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root==null) return null;
        Stack<UndirectedGraphNode> stack=new Stack();
        UndirectedGraphNode copy=new UndirectedGraphNode(root.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap();
        map.put(root, copy);
        stack.push(root);
        while (!stack.isEmpty()){
            UndirectedGraphNode node=stack.pop();
            UndirectedGraphNode nodeNew=map.get(node);
            ArrayList<UndirectedGraphNode> neighbors=(ArrayList<UndirectedGraphNode>)node.neighbors;
            for (UndirectedGraphNode neighbor: neighbors){
                if (!map.containsKey(neighbor)){
                    stack.push(neighbor);
                    UndirectedGraphNode tmp=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, tmp);
                    nodeNew.neighbors.add(tmp);
                }
                else
                    nodeNew.neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }
}


public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root==null) return null;
        LinkedList<UndirectedGraphNode> queue=new LinkedList();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap();
        queue.add(root);
        map.put(root, new UndirectedGraphNode(root.label));
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0; i<size; i++){
                UndirectedGraphNode node=queue.remove();
                ArrayList<UndirectedGraphNode> neighbors=(ArrayList<UndirectedGraphNode>)node.neighbors;
                if (neighbors.size()==0) continue;
                UndirectedGraphNode newNode=map.get(node);
                for (UndirectedGraphNode neighbor: neighbors){
                    if (!map.containsKey(neighbor)){
                        UndirectedGraphNode tmp=new UndirectedGraphNode(neighbor.label);
                        map.put(neighbor, tmp);
                        queue.add(neighbor);
                    }
                    newNode.neighbors.add(map.get(neighbor));
                }
            }
        }
        return map.get(root);
    }
}