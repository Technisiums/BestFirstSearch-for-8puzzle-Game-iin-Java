Verision: 1.0
This project solves the 8-Puzzle Problem.
Flow of working. (BestFirstSearch_8Puzzle is the main class of the project)
*Create Problem and Goal states
*Generate Tree (with non-inteligence) of problem untill goal state is not achieved.
*Pass Tree to Best_First_Search it will find your Goal possition with shortest path.
*Display All the nodes

***************************_Format of Display_***************************
*Every Node Assigned with an ID
*In the first line of the output. There is Node ID, next there are Child IDs of that node after that there is Level number and at the end there is Heuristic value.
*on next three lines there is Puzzle box. where -1 indicates the queen.
*If child IDs=Leaf Node thats means it has no children and it is considered to be the leaf node.

*NOTE####
"The Node with the Highest Node value is your solution."

****Example::

Node ID:2 Child IDs:3 4 5  Level:0 HV:-1 (This is the node number 2, Node#2 has three children i.e Node# 3,4 and 5 are the children of Node#2)
2 8 3 
1 6 4 
7 -1 5 

Node ID:3 Child IDs:6 7 8 9  Level:1 HV:4
2 8 3 
1 -1 4 
7 6 5 

Node ID:6 Child IDs:14 15 16  Level:2 HV:6
2 -1 3 
1 8 4 
7 6 5 

Node ID:14 Child IDs:Leaf Node Level:3 HV:-1
2 8 3 
1 -1 4 
7 6 5 

**********************************************************************************************************************************************************************
All the code on GitHub is totally free. You can use this code in your projects. You can also modify. 
This code is published by Technisiums.(07-03-2018)
**********************************************************************************************************************************************************************