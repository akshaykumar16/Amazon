package com.pratice.amazon;

import java.util.*;

public class UniquePaths {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        Queue<Map<int[],boolean[][]>> trackRoute=new LinkedList<>();
        Map<int[],boolean[][]> firstEntry=new HashMap<>();
        boolean[][] firstVisited=new boolean[obstacleGrid.length][obstacleGrid[0].length];
        firstEntry.put(new int[]{0,0},firstVisited);
        trackRoute.offer(firstEntry);
        int[][] directions=new int[][]{{0,1},{1,0}};
        int destination=0;
        while(!trackRoute.isEmpty())
        {
            int size=trackRoute.size();
            while(size>0)
            {
                Map.Entry<int[],boolean[][]> entry=trackRoute.poll().entrySet().iterator().next();
                int[] coords=entry.getKey();
                boolean[][] visited=entry.getValue();
                size--;
                int x=coords[0],y=coords[1];
                visited[x][y]=true;
                for(int i=0;i<directions.length;i++)
                {
                    int dx=x+directions[i][0];
                    int dy=y+directions[i][1];

                    if(dx>=0 && dx< obstacleGrid.length && dy >=0 && dy<obstacleGrid[1].length && obstacleGrid[dx][dy]!=1)
                    {
                        if(dx==obstacleGrid.length-1 && dy==obstacleGrid[0].length-1)
                        {
                         destination++;
                        }
                        else if(!visited[dx][dy])
                         {
                            Map<int[], boolean[][]> entry1 = new HashMap<>();
                            entry1.put(new int[]{dx, dy},visited);
                            trackRoute.offer(entry1);
                        }

                    }

                }
            }
        }

        return destination;


    }



    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }

        for(int i=0;i<dp.length;i++)
        {
            System.out.println(dp[i]);
        }
        return dp[width - 1];
    }


    public int[] getCellStateAfterNdays(int[] cells,int N)
    {

        int temp=0;
        while(N>0) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    temp = cells[i];
                    cells[i] = cells[i + 1];
                } else if (i == cells.length - 1) {
                    cells[i] = temp;
                } else {
                    if (temp - cells[i + 1] == 0) {
                        temp = cells[i];
                        cells[i] = 0;
                    } else {
                        temp = cells[i];
                        cells[i] = 1;
                    }
                }
            }
            System.out.println();
            for(int i:cells)
            {
                System.out.print(i+"  ");
            }

            N--;

        }

        return cells;
    }

}



