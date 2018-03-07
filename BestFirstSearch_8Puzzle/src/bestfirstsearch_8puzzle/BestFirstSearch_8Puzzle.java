/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestfirstsearch_8puzzle;


/**
 *
 * @author Dosti
 */
//This is the main class
public class BestFirstSearch_8Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int values[][] = {{2, 8, 3}, {1, 6, 4}, {7, -1, 5}}; //problem
        int goal_v[][] = {{1,2,3}, {8,-1,4}, {7,6,5}};//goal

        Node goal=new Node(goal_v);//goal node
        Tree puzzle=new Tree(values,goal);
        puzzle.generate_tree();//constructing tree with non-inteligent base
        Heuristic heuristic=new Heuristic();
        heuristic.Best_First_Search(puzzle.root, goal);//passing tree to the heruristic function to find the goal with inteligent search algo (best first search)
        puzzle.traverse(puzzle.root);//to display tree
    }
}
