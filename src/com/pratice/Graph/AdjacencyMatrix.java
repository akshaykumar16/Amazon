package com.pratice.Graph;

import java.util.*;


public class AdjacencyMatrix implements Graph {


    private int[][] adjacencyMatrix;

    private GraphType graphType;

    private int x=0;

    public AdjacencyMatrix(int rowValue, int columnValue, GraphType graphType) {
        this.adjacencyMatrix = new int[rowValue][columnValue];
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {

        if (v1 < 0 || v2 < 0 || v1 > adjacencyMatrix.length - 1 || v2 > adjacencyMatrix.length - 1) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        adjacencyMatrix[v1][v2] = 1;
        if (graphType.equals(GraphType.UN_DIRECTED)) {
            this.adjacencyMatrix[v2][v1] = 1;
        }


    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {

        if (v >= adjacencyMatrix.length || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < adjacencyMatrix[1].length; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                list.add(i);
            }
        }

        return list;

    }


    public void getAllElements() {

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[1].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public List<Integer> topologicalSort() {
        Queue<Integer> zeroDegreeQueue = new LinkedList<>();

        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            int indegree = getInDegree(i);
            indegreeMap.put(i, indegree);
            if (indegree == 0) {
                zeroDegreeQueue.add(i);
            }
        }
        System.out.println(indegreeMap);

        List<Integer> sortedList = new ArrayList<>();

        while (!zeroDegreeQueue.isEmpty()) {
            int res = zeroDegreeQueue.poll();

            sortedList.add(res);

            List<Integer> adjacentVertices = getAdjacentVertices(res);

            for (int i = 0; i < adjacentVertices.size(); i++) {
                int newIndegree = indegreeMap.get(adjacentVertices.get(i)) - 1;
                indegreeMap.put(adjacentVertices.get(i), newIndegree);
                if (newIndegree == 0) {
                    zeroDegreeQueue.add(adjacentVertices.get(i));
                }
            }


        }


        return sortedList;

    }


    public int getInDegree(int v) {
        int indegree = 0;

        for (int j = 0; j < adjacencyMatrix[1].length; j++) {
            if (adjacencyMatrix[j][v] == 1) {
                indegree++;
            }
        }

        return indegree;

    }


    public int getOutDegree(int v) {
        int outDegree = 0;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                outDegree++;
            }
        }

        return outDegree;
    }


    public List<int[][]> getDataCriticalConnections() {

        List<int[][]> criticalList = new ArrayList<>();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            List<Integer> adjacentVertices = getAdjacentVertices(i);

            if (adjacentVertices.size() > 0) {


                if (adjacentVertices.size() == 1 && getInDegree(i) == 0) {
                    criticalList.add(new int[][]{{i + 1, adjacentVertices.get(0) + 1}});
                    //System.out.println((i+1)+" "+(adjacentVertices.get(0)+1));
                } else {

                    for (int j = 0; j < adjacentVertices.size(); j++) {

                        if (getInDegree(adjacentVertices.get(j)) - 1 <= 0 && getOutDegree(adjacentVertices.get(j)) - 1 <= 0) {
                            criticalList.add(new int[][]{{i + 1, adjacentVertices.get(j) + 1}});
                            //System.out.println((i+1)+" "+(adjacentVertices.get(j)+1));
                        }

                    }

                }

            }
        }

        return criticalList;
    }


    public void bfs(int root) {
        Boolean[] visited = new Boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        visited[root] = true;

        while (!bfsQueue.isEmpty()) {
            int res = bfsQueue.poll();
            System.out.println(res);
            List<Integer> adjacentVertices = getAdjacentVertices(res);
            for (int i = 0; i < adjacentVertices.size(); i++) {
                if (visited[adjacentVertices.get(i)] != true) {
                    bfsQueue.add(adjacentVertices.get(i));
                    visited[adjacentVertices.get(i)] = true;
                }
            }

        }

    }


    public void depthFirstSearch() {

        List<List<Integer>>  arrayList=new ArrayList<>();


          for(int i=0;i<adjacencyMatrix.length;i++) {
              boolean[] b = new boolean[adjacencyMatrix.length];
              arrayList.add(dfs1(i, b,arrayList));

          }


           for(int i=0;i<arrayList.size();i++)
           {
               System.out.println(arrayList.get(i).toString());
           }


    }

    private void dfs(int currentNode, boolean[] b) {

        System.out.println(currentNode);
        b[currentNode] = true;

        List<Integer> adjacentVertices = getAdjacentVertices(currentNode);
        for (int i = 0; i < adjacentVertices.size(); i++) {
            if (b[adjacentVertices.get(i)] != true) {
                dfs(adjacentVertices.get(i), b);
            }
        }


    }


    private  List<Integer>  dfs1(int currentNode, boolean[] b,List<List<Integer>> resultList) {
        List<Integer> res = new ArrayList<>();
        List<Integer> adjacentVertices = getAdjacentVertices(currentNode);
        for (int i = 0; i < adjacentVertices.size(); i++) {
            if (b[adjacentVertices.get(i)] != true && checkInResultList(resultList,currentNode,adjacentVertices.get(i))) {
                int nodeCheck = adjacentVertices.get(i);
                if(getAdjacentVertices(nodeCheck).size()>1) {
                    checkCriticalConnection(currentNode, currentNode, nodeCheck, b);
                    if (x == 0) {
                        res.add(currentNode);
                        res.add(nodeCheck);
                    } else {
                        x = 0;
                    }
                }
                else
                {
                    res.add(currentNode);
                    res.add(nodeCheck);
                }
            }
        }
       return res;
    }

    private boolean checkInResultList(List<List<Integer>> resultList, int currentNode, int nodeCheck) {

        if(resultList.size()>0) {

            for (int i = 0; i < resultList.size(); i++) {

                if(resultList.get(i).size()>0) {
                    if ((resultList.get(i).get(0) == currentNode && resultList.get(i).get(1) == nodeCheck) ||
                            resultList.get(i).get(1) == currentNode && resultList.get(i).get(0) == nodeCheck) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    private void checkCriticalConnection(int parent, int currentNode, int nodeCheck, boolean[] b) {

        List<Integer> adjacentVertices = getAdjacentVertices(currentNode);
        b[currentNode] = true;
        for (int i = 0; i < adjacentVertices.size(); i++) {
            if (nodeCheck == adjacentVertices.get(i)) {
                if (parent == currentNode) {
                    continue;
                } else {
                    x=x+1;
                    break;
                }
            } else {
                if (b[adjacentVertices.get(i)] != true) {
                     checkCriticalConnection(parent, adjacentVertices.get(i), nodeCheck, b);
                }
            }
        }


    }



    public void bfs1(int root)
    {

        Queue<Integer> bFS=new LinkedList<>();
        boolean[] b=new boolean[adjacencyMatrix.length];
        bFS.offer(root);
        b[root]=true;
        while(!bFS.isEmpty())
        {
            int currentNode=bFS.poll();
            System.out.println(currentNode);
            List<Integer> adjacentVertices=getAdjacentVertices(currentNode);
            for(int i=0;i<adjacentVertices.size();i++)
            {
                if(b[adjacentVertices.get(i)]!=true)
                {
                    bFS.offer(adjacentVertices.get(i));
                    b[adjacentVertices.get(i)]=true;
                }
            }
        }


    }


    public void dfs(int root)
    {
        boolean b[]=new boolean[adjacencyMatrix.length];
        dfs1(root,b);

    }

    public void dfs1(int currentNode,boolean b[])
    {
        System.out.println(currentNode);
        b[currentNode]=true;
        List<Integer> adjacentVertices=getAdjacentVertices(currentNode);
        for(int i=0;i<adjacentVertices.size();i++)
        {
            if(b[adjacentVertices.get(i)]!=true)
            {
                dfs1(adjacentVertices.get(i),b);
            }
        }


    }



}
