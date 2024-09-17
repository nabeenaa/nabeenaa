

import java.util.*;

/**
 * Abstraction of a generic search problem (does not have to be a search problem for Pacman).
 * Implemented for you.
 *
 * @param <S> class for states
 * @param <A> class for actions
 */
public abstract class SearchProblem<S, A> {

    /**
     * Auxiliary variables for keeping track about the visited and expanded nodes
     */
    long expandedCount;
    List<S> visitedList;
    Set<S> visitedSet;

    public SearchProblem() {
        /**
         *
         */
        expandedCount = 0;
        visitedList = new ArrayList<>();
        visitedSet = new HashSet<>();
    }

    /**********************************************************
     * The methods that every search problem has to implement *
     **********************************************************/

    /**
     * @return the start state
     */
    public abstract S getStartState();

    /**
     * @param state
     * @return whether state is a goal state or not
     */
    public abstract boolean isGoalState(S state);

    /**
     * @param state
     * @return Actions available in the state
     */
    public abstract List<A> getActions(S state);

    /**
     * @param state
     * @param action
     * @return successor of state via action
     */
    public abstract S getSuccessor(S state, A action);

    /**
     * @param state
     * @param action
     * @return the cost of action from state
     */
    public abstract double getCost(S state, A action);

    /*******************************************************
     * The expand method (implemented) used by graphSearch *
     *******************************************************/

    /**
     * Expands a state and returns for each valid action a triple of:
     * (next state, action, cost)
     * @param state
     * @return
     */
    public Collection<SuccessorInfo<S, A>> expand(S state) {

        Collection<SuccessorInfo<S, A>> successors = new ArrayList<>();
        for (A action : getActions(state)) {
            successors.add(new SuccessorInfo<S, A>(getSuccessor(state, action), action, getCost(state, action)));
        }

        doBookKeeping(state); // do not remove

        return successors;
    }

    /***********************************************************
     * Below are some auxiliary methods for book keeping:
     * getting the statistics about the visited nodes,
     * the number of expanded nodes, etc
     ***********************************************************/
    public void doBookKeeping(S state) {
        expandedCount++;
        if (!visitedSet.contains(state)) {
            visitedSet.add(state);
            visitedList.add(state);
        }
    }

    /**
     * This method is useful for printing statistics once solution has been found.
     *
     * @return the number of expanded nodes
     */
    public long getExpandedCount() {
        return expandedCount;
    }

    /**
     * Used in the GUI version.
     * @return
     */
    public List<S> getVisitedList() { return visitedList; }
}


/**************************************************************
 ************            Search states            *************
 **************************************************************/

interface SearchState {
}

/**************************************************************
 ************           Search actions            *************
 **************************************************************/

interface Action {
}

/**************************************************************
 ************          Search heuristics          *************
 **************************************************************/

/**
 * Interface for search heuristics.
 * @param <S>
 * @param <A>
 */
interface SearchHeuristic<S, A> {
    Double value(S state, SearchProblem<S,A > problem);
}

/**
 * Null heuristic, i.e., the one that always returns 0.
 * A* with null heuristic is equivalent to uniform-cost search.
 * Implemented for you.
 * You should not need to modify this class.
 *
 * @param <S>
 * @param <A>
 */
class NullHeuristic<S,A> implements SearchHeuristic<S,A> {
    public NullHeuristic() {}

    @Override
    public Double value(S state, SearchProblem<S, A> problem) {
        return 0.0;
    }

    public String toString() { return this.getClass().getName(); }
}

