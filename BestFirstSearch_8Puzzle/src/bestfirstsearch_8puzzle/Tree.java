/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestfirstsearch_8puzzle;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 * @author Dosti
 */
public class Tree {

    public Node root; //root of tree
    public static Node goal; //our goal statement
    boolean check;//a check boolean variable for checking if the node already exists or not?
    public ArrayList<Node> all_nodes; //to save all nodes of tree for just to make the code simple

    Tree(int[][] values, Node goal) {
        root = new Node(values);
        this.goal = goal;
        check = false;
        all_nodes = new ArrayList<>();
    }

    public void generate_tree() {
        //non-inteligence based generation of tree
        int level=0;
        
        Deque<Node> queue = new ArrayDeque<>(); //Deque (just like Queue)
        queue.add(root);
        
        root.set_level(level);
        if(Arrays.deepEquals(root.puzzel_box, goal.puzzel_box)){//if root is our goal
            System.out.println("Root is out goal....! We got Success");
            return;
        }
        
        while (!queue.isEmpty()) {
            Node parent = queue.poll(); //poll is just like dequeue()
            String a = parent.get_possible_moves(); //getting possible moves
            level=parent.get_level()+1; //increment in level
            for (int i = 0; i < a.length(); i++) {
                Node newChild = parent.move_queen(a.charAt(i)); //moving queen and getting new child
                newChild.set_level(level);
                if (!is_Exist(newChild)) { //if newChild not exists
                    queue.add(newChild);
                }
                parent.add_child(newChild);
                all_nodes.add(newChild);
                if (Arrays.deepEquals(newChild.puzzel_box, goal.puzzel_box)) {
                    System.out.println("Goal found during Generation of Tree");
                    return;
                }
            }
        }

    }

    public boolean is_Exist(Node key) {
        for (Node temp : all_nodes) {
            if (Arrays.deepEquals(key.puzzel_box, temp.puzzel_box)) {
                return true;
            }
        }
        return false;
    }

    
    public void traverse(Node temp) {
        if (temp == null) {
            return;
        }
        temp.display();
        for (Node temp1 : temp.get_child()) {
            traverse(temp1);
        }
    }

}
