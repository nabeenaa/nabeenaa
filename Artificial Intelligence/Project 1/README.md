

# AI Search Algorithms and Game Implementations

## Overview

This repository contains various implementations and solutions for search algorithms and game-based AI problems. The primary focus is on implementing search strategies and agents to solve problems such as maze navigation and game playing. The project includes the following components:

1. **Search Algorithms**: Implementation of different search algorithms such as A*, UCS (Uniform Cost Search), DFS (Depth-First Search), BFS (Breadth-First Search), and Greedy Search.
2. **Pacman Game**: A simple implementation of the Pacman game where agents are implemented to interact with the game environment.
3. **Tower of Hanoi**: Implementation of the Tower of Hanoi puzzle as a search problem and solving it using various search strategies.

## Project Structure

### 1. Search Algorithms

**File**: `GraphSearch.java`

**Overview**:
The `GraphSearch` class provides various search algorithms to find solutions for search problems. It includes implementations for:

- **Depth-First Search (DFS)**
- **Breadth-First Search (BFS)**
- **Uniform Cost Search (UCS)**
- **Greedy Search**
- **A* Search**

**Key Methods**:
- `search(String function, SearchProblem<S, A> problem, SearchHeuristic<S, A> heuristic, boolean print)`: Executes the search based on the provided strategy.
- `depthFirstSearch(SearchProblem<S, A> problem)`: Implements DFS.
- `breadthFirstSearch(SearchProblem<S, A> problem)`: Implements BFS.
- `uniformCostSearch(SearchProblem<S, A> problem)`: Implements UCS.
- `greedySearch(SearchProblem<S, A> problem, SearchHeuristic<S, A> heuristic)`: Implements Greedy Search.
- `aStarSearch(SearchProblem<S, A> problem, SearchHeuristic<S, A> heuristic)`: Implements A* Search.
- `printSearchInfo(SearchProblem<S, A> searchProblem, Solution<S, A> solution, long runtime)`: Prints search statistics.

### 2. Pacman Game

**File**: `PacmanMain.java`

**Overview**:
The `PacmanMain` class runs a simple implementation of the Pacman game. It allows testing different search strategies and agents in a game environment.

**Key Features**:
- Run the game with various search strategies for Pacman to navigate mazes.
- Test agent behaviors such as chasing Pacman using different algorithms.

**Run Commands**:
- To run the game: `java -cp ./out PacmanMain`
- To use A* with Manhattan distance heuristic: `java -cp ./out PacmanMain -a PacmanSearchAgent -l bigMaze -f astar -h ManhattanDistanceHeuristic`
- To use UCS: `java -cp ./out PacmanMain -a PacmanSearchAgent -l bigMaze -f ucs`

### 3. Tower of Hanoi

**Files**:
- `TowerOfHanoiSearchProblem.java`
- `TowerOfHanoiSearchState.java`
- `TowerOfHanoiAction.java`
- `TowerOfHanoiHeuristic.java`

**Overview**:
This component includes the implementation of the Tower of Hanoi puzzle as a search problem. It involves defining search states, actions, and heuristics for solving the puzzle.

**Key Components**:
- `TowerOfHanoiSearchProblem`: Defines the search problem for Tower of Hanoi.
- `TowerOfHanoiSearchState`: Represents the state of the Tower of Hanoi puzzle.
- `TowerOfHanoiAction`: Enum for possible actions in the Tower of Hanoi puzzle.
- `TowerOfHanoiHeuristic`: Implements a heuristic function to guide the search.

**Run Commands**:
- To solve using UCS: `java -cp ./out TowerOfHanoiMain -f ucs`
- To solve using A* with a heuristic: `java -cp ./out TowerOfHanoiMain -f astar -h TowerOfHanoiHeuristic`


3. **Implementations**:
   - Explore the classes and methods implemented in the project to understand the search strategies and agent behaviors.


