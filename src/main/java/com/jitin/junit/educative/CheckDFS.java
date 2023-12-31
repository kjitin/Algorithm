package com.jitin.junit.educative;

public class CheckDFS {

  public static void main(String args[]) {
    Graph g = new Graph(5);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(1,4);
    System.out.println("Graph1:");
    g.printGraph();
    System.out.println("DFS traversal of Graph1 : " + dfs(g));
    System.out.println();

    Graph g2 = new Graph(5);
    g2.addEdge(0,1);
    g2.addEdge(0,4);
    g2.addEdge(1,2);
    g2.addEdge(3,4);
    System.out.println("Graph2:");
    g2.printGraph();
    System.out.println("DFS traversal of Graph2 : " + dfs(g2));
  }
  public static String dfs(Graph g){
    String result = "";
    //Checking if the graph has no vertices
    if (g.getVertices() < 1){
      return result;
    }

    //Boolean Array to hold the history of visited nodes (by default-false)
    boolean[] visited = new boolean[g.getVertices()];

    for(int i=0; i<g.getVertices(); i++)
    {
      //Checking whether the node is visited or not
      if(!visited[i])
      {
        result = result + dfsVisit(g, i, visited);
      }
    }
    return result;
  }
  public static String dfsVisit(Graph g, int source, boolean[] visited) {

    String result = "";


    //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
    Stack<Integer> stack = new Stack<Integer>(g.getVertices());

    stack.push(source);

    //Traverse while stack is not empty
    while (!stack.isEmpty()) {

      //Pop a vertex/node from stack and add it to the result
      int current_node = stack.pop();
      result += String.valueOf(current_node);

      //Get adjacent vertices to the current_node from the array,
      //and if they are not already visited then push them in the stack
      DoublyLinkedList<Integer>.Node temp = null;
      if(g.adjacencyList[current_node] !=null)
        temp = g.adjacencyList[current_node].headNode;

      while (temp != null) {

        if (!visited[temp.data]) {
          stack.push(temp.data);

        }
        temp = temp.nextNode;
      }
      //Visit the node
      visited[current_node] = true;
    }//end of while
    return result;
  }
}
