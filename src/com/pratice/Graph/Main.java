package com.pratice.Graph;


import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) {

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(7, 7, Graph.GraphType.UN_DIRECTED);

        adjacencyMatrix.addEdge(1, 4);
        adjacencyMatrix.addEdge(4, 5);
        adjacencyMatrix.addEdge(2,3);
        adjacencyMatrix.addEdge(1,6);
        adjacencyMatrix.addEdge(1,2);
        System.out.println();

        adjacencyMatrix.dfs(1);
    }




//    private static int getShortestPathFromMultipleStart(char[][] grid)
//    {
//
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<grid.length;i++)
//        {
//            for(int j=0;j<grid[0].length;j++)
//            {
//                if(grid[i][j]=='S')
//                {
//                    min=Math.min(min,getMinimumPath(grid,i,j));
//                }
//            }
//        }
//
//        return min;
//    }


    private static int getMinimumPath(char[][] grid)
    {

        Queue<int[]>  trackRoute=new LinkedList<>();
        trackRoute.offer(new int[]{0,0});
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        visited[0][0]=true;
        int steps=0;
        int directions[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!trackRoute.isEmpty())
        {
            int size=trackRoute.size();
            while(size>0)
            {
                int[] coords=trackRoute.poll();
                int x=coords[0],y=coords[1];
                visited[x][y]=true;
                if(grid[x][y]=='X')
                {
                    return steps;
                }
                for(int i=0;i<directions.length;i++)
                {
                      int dx=x+directions[i][0];
                      int dy=y+directions[i][1];

                      if(dx>=0 && dx< grid.length && dy>=0 &&  dy < grid[0].length && !visited[dx][dy] && grid[dx][dy]!='D')
                      {
                           trackRoute.offer(new int[]{dx,dy});
                      }

                }
                size--;

            }
            steps++;

        }

     return steps;



    }



}

