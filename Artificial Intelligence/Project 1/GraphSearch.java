

import java.util.*;

import static java.lang.System.out;

public class GraphSearch<S,A> {
    /**
     *
     * @param function string describing search strategy: dfs, bfs, greedy and astar
     * @param problem search problem instance, for instance, PacmanPositionSearchProblem, PacmanCornersProblem etc
     * @param heuristic can be null, not used for dfs and bfs
     * @param <S> states
     * @param <A> actions
     * @return
     */
    public static <S, A> Solution<S, A> search(String function,
                                               SearchProblem<S, A> problem,
                                               SearchHeuristic<S, A> heuristic,
                                               boolean print) {
        Solution<S, A> solution;
        long start = System.currentTimeMillis();
        switch (function) {
            case "dfs":
                if (print)
                    out.println("Search using DFS algorithm");
                solution = depthFirstSearch(problem);
                break;
            case "bfs":
                if (print)
                    out.println("Search using BFS algorithm");
                solution = breadthFirstSearch(problem);
                break;
            case "ucs":
                if (print)
                    out.println("Search using UCS algorithm");
                solution = uniformCostSearch(problem);
                break;
            case "greedy":
                if (print)
                    out.println("Search using Greedy algorithm and heuristic " + heuristic);
                solution = greedySearch(problem, heuristic);
                break;
            case "astar":
                if (print)
                    out.println("Search using A* algorithm and heuristic " + heuristic);
                solution = aStarSearch(problem, heuristic);
                break;
            default:
                throw new RuntimeException("Unknown search strategy: " + function);
        }

        long end = System.currentTimeMillis();
        if (print)
            printSearchInfo(problem, solution, end - start);
        return solution;
    }

    private static <S, A> Solution<S, A> depthFirstSearch(SearchProblem<S, A> problem) {

        Util.Frontier<Node<S,A>> frontier = new Util.Stack<>();
        return graphSearch(problem, frontier);
    }

    private static <S, A> Solution<S, A> breadthFirstSearch(SearchProblem<S, A> problem) {
       Util.Frontier<Node<S,A>> frontier = new Util.Queue<>();
        return graphSearch(problem, frontier);
    }

    private static <S, A> Solution<S, A> uniformCostSearch(SearchProblem<S, A> problem) {
        Util.Frontier<Node<S,A>> frontier = new Util.PriorityQueue<>(
                Comparator.comparingDouble(node -> node.pathCost)
        );
        return graphSearch(problem, frontier);
    }

    private static <S, A> Solution<S, A> greedySearch(SearchProblem<S, A> problem, SearchHeuristic<S, A> heuristic) {
       Util.Frontier<Node<S,A>> frontier = new Util.PriorityQueue<>(
                Comparator.comparingDouble(node -> heuristic.value(node.state, problem))
        );
        return graphSearch(problem, frontier);
    }

    private static <S, A> Solution<S, A> aStarSearch(SearchProblem<S, A> problem, SearchHeuristic<S, A> heuristic) {
          Util.Frontier<Node<S,A>> frontier = new Util.PriorityQueue<>(
                Comparator.comparingDouble(node -> node.pathCost + (heuristic.value(node.state, problem)))
        );
        return graphSearch(problem, frontier);
    }


    private static <S, A> Solution<S, A> graphSearch(SearchProblem<S, A> problem, Util.Frontier<Node<S,A>> frontier) {
        // Create the starting node
        Node<S, A> startNode = new Node<>(problem.getStartState(), new ArrayList<>(), 0);
        // Add it to the frontier
        frontier.push(startNode);

        // We will keep track of the states that have been already expanded
        Set<S> expanded = new HashSet<>();

        while(!frontier.isEmpty()) {
            // Get a node from the frontier (according to the strategy implemented by it)
            Node<S, A> currentNode = frontier.pop();

            // If the state in the current node is a goal state,
            // then we are finished!
            if(problem.isGoalState(currentNode.state)) {
                // Return the solution
                return new Solution<>(currentNode.state, currentNode.actions, currentNode.pathCost);
            }

            // If the state in the current node has not been expanded before
            if (!expanded.contains(currentNode.state)) {
                expanded.add(currentNode.state);

                // Expand the current state
                Collection<SuccessorInfo<S, A>> successors = problem.expand(currentNode.state);
                // For each of the possible successors of the state
                for(SuccessorInfo<S, A> successor : successors) {

                    S childState = successor.nextState;

                    // Make sure to create a deep copy of the sequence of actions
                    // to get (from the start state) to the child state
                    List<A> childActions = new ArrayList<>();
                    childActions.addAll(currentNode.actions);
                    childActions.add(successor.action);

                    // Calculate the cost of the above sequence of actions
                    double childPathCost = currentNode.pathCost + successor.cost;

                    // Create a new node
                    Node<S, A> child = new Node<>(childState, childActions, childPathCost);
                    // And add it to the frontier
                    frontier.push(child);
                }
            }
        }

        // No solution has been found. Return null.
        return null;
    }

    public static <S, A> void printSearchInfo(SearchProblem<S, A> searchProblem,
                                Solution<S, A> solution,
                                long runtime) {
        out.println("Search Problem: " + searchProblem.getClass().getName());
        if (solution != null) {
            out.println("Solution found in " + (double) runtime / 1000 + "s");
            out.println("Solution cost " + solution.pathCost);
        } else {
            out.println("No solution found in " + (double) runtime / 1000 + "s");
        }
        out.println("Expanded count " + searchProblem.getExpandedCount());
        out.println("");
    }
}



