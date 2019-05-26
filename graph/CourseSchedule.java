package graph;

import java.util.Stack;

/**
 *
 * visit是多余的，不用也行
 */
public class CourseSchedule {
    int[] visit;
    Stack<Integer> stack;
    public boolean canFinish(int numCourses,int[][] prerequisites){
        visit=new int[numCourses];
        stack=new Stack<Integer>();
        boolean rs=false;
        for(int i=0;i<numCourses;i++){
            rs=dfs(i,prerequisites);
            if(rs){
                break;
            }
        }
        return !rs;

    }
    //dfs判断是否有环
    private boolean dfs(int i,int[][] graph){
        visit[i]=1;
        stack.push(i);
        for(int x=0;x<graph.length;x++){
            if(graph[x][0]==i){
                int j=graph[x][1];
                if(visit[j]==1){
                    if(stack.contains(j)){
                        return true;
                    }
                }
                else{
                    boolean dfs = dfs(j, graph);
                    if(dfs){
                        return true;
                    }
                }
            }
        }
        stack.pop();
        return false;
    }
}
