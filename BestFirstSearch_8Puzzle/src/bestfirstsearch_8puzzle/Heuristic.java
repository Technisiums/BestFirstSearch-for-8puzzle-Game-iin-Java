/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestfirstsearch_8puzzle;

import static bestfirstsearch_8puzzle.Tree.goal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;
import java.util.Deque;

/**
 *
 * @author Dosti
 */
public class Heuristic {

    private Deque<Node> open = new ArrayDeque<>();
    private Deque<Node> close = new ArrayDeque<>();

    public static int get_huristic_value(Node temp) {//static method
        int hv = 0;
        for (int i = 0; i < temp.puzzel_box.length; i++) {
            for (int j = 0; j < temp.puzzel_box.length; j++) {
                if (temp.puzzel_box[i][j] != goal.puzzel_box[i][j]) {
                    hv++;
                }
            }
        }
        hv += temp.get_level();
        temp.set_heuristic_value(hv);
        return hv;
    }
    
    public void Best_First_Search(Node root, Node goal) {
        //open and close are two Deques
        open.add(root);
        while (!open.isEmpty()) {
            Node x = open.poll();
            if (Arrays.deepEquals(x.puzzel_box, goal.puzzel_box)) {
                System.out.println("Goal Found...! While Searching by Best First Search");
                return;
            } else {
                for (Node child : x.get_child()) {
                    Node op = is_inOpen(child);
                    Node cl = is_inClose(child);
                    if ((op == null) && (cl == null)) {
                        //assign HV hena? ha or list mai add
                        get_huristic_value(child);
                        open.add(child);
                    }

                    if (op != null) {
                        if (op.get_heuristic_value() >= child.get_heuristic_value()) {
                            open.add(child);
                        }
                    }
                    if (cl != null) {
                        if (cl.get_heuristic_value() >= child.get_heuristic_value()) {
                            open.add(child);
                        }
                    }

                }
            }
            close.add(x);
            open=sort(open); //re-arrange Open

        }
        System.out.println("Goal not Found");
    }

    public Deque<Node> sort(Deque<Node> queue) {
        //Soring of Deque is difficult so here i convert Deque to ArrayList and then i sort ArrayList and again i covert ArrayList to Deque and returned it.
        ArrayList<Node> nodes = new ArrayList<>(queue); //Deque to ArrayList
        //Sorting..
        for (int i = 0; i < nodes.size(); i++) {

            for (int j = nodes.size() - 1; j > i; j--) {
                if (nodes.get(i).heuristic_value > nodes.get(j).heuristic_value) {

                    Node tmp = nodes.get(i);//fr sort kiya
                    nodes.set(i,nodes.get(j));
                    nodes.set(j,tmp);
                }
            }

        }
        //Arraylist to Deque
        Deque<Node> sorted=new ArrayDeque<>(nodes);
        return sorted;
    }
    
    //helping methods
    //if node exists they return the node (which already exists) if node not exists they returns null
    public Node is_inOpen(Node key) {
        for (Node temp : open) {
            if (Arrays.deepEquals(temp.puzzel_box, key.puzzel_box)) {
                return temp;
            }

        }
        return null;
    }

    public Node is_inClose(Node key) {
        for (Node temp : close) {
            if (Arrays.deepEquals(temp.puzzel_box, key.puzzel_box)) {
                return temp;
            }

        }
        return null;
    }

}
