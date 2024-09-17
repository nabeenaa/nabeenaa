<h1>Nabeena Islam - Portfolio</h1>

<p>In this repository, a collection of projects has been included to showcase skills and expertise in coding across various programming languages. Each project reflects the ability to tackle diverse challenges and demonstrates proficiency in technology and problem-solving across various domains.</p>

## Projects:
- [Web Development](#web-development)
- [Video Games Development](#video-games-development)
- [Blockchain](#blockchain)
- [Language-based security](#language-based-security)
- [Algorithm](#algorithm)
- [Artificial Intelligence](#artificial-intelligence)


## Web Development

### [Project 1: jQuery and AJAX 17/11/2022](link-to-project)
- **Description:** This project involved creating a dynamic web page using jQuery and AJAX to display detailed data about countries in the world. Users can select a region of interest, and the web page dynamically loads and displays information about the countries within that region, including flags, names, capitals, populations, and languages.
- **Technologies Used:** HTML, CSS, jQuery, AJAX, Bootstrap.
- **Key Features:**
  - A selection element that retrieves and displays a list of regions using AJAX.
  - Dynamic generation of an HTML table with country details based on the selected region.
  - Calculation and display of the average population, total number of countries, and the most popular language within a region.
  - A search functionality that filters countries by name or capital based on user input.

### [Project 2: HTML, CSS, and JavaScript 11/03/2022](link-to-project)
- **Description:** This project involved creating multiple interactive web pages utilising HTML, CSS, and JavaScript. The tasks included building a user registration form for a gym, generating dynamic boxes with specific styling rules, and partially implementing a Tic-Tac-Toe game.
- **Technologies Used:** HTML, CSS, JavaScript.
- **Key Features:**
  - **Gym Registration Form:** A dynamic form that registers users to a gym, validates user inputs and displays the entries in a table with features like adding, deleting, and resetting entries.
  - **Dynamic Box Generator:** A page that generates a series of boxes with random background colours and specific margin rules, based on user input.
  - **Tic-Tac-Toe Game:** A basic implementation of a Tic-Tac-Toe game board with interactive X and O placement, alternating turns, and reset functionality.

### [Project 3: SQL Gym Management Database Queries 20/02/2022](link-to-project)
- **Description:** This project involves writing SQL queries to retrieve and manage class booking data for a gym system. The tasks focus on listing class details, finding course instructors, and displaying user-specific bookings, demonstrating practical SQL skills in querying relational databases. The project is crucial for developing database querying capabilities, which are essential for managing user interactions in a web-based application.
- **Technologies Used:** SQL
- **Key Features:**
  - **Instructor and Class Timeslot Query:** Retrieves and orders class timeslot information by instructor for a specific course.
  - **Course and Instructor Mapping:** Lists all courses along with their assigned instructors.
  - **User-Specific Bookings:** Displays bookings for a particular user and calculates the total reservations for each class.


## Video Games Development

### [Alien Slayer - Video Game Development 22/12/2023](link-to-project)
- **Description:** "Alien Slayer" is a third-person shooter set in a post-apocalyptic city where the player must survive waves of alien enemies. The game features dynamic gameplay mechanics, including enemy AI, slow-motion effects, and a power-up system.
- **Technologies Used:** Unity, C#, Visual Studio, Adobe Photoshop (for any art assets).
- **Key Features:**
  - **Slow Motion:** Implemented a feature that slows down the game and program cycles, adding a dramatic effect during intense gameplay moments.
  - **Spawning Enemies:** Designed a system where new enemies spawn after the player defeats existing ones, ensuring constant action and challenge.
  - **In-Game Shop:** Created a shop where players can use points earned from defeating enemies to purchase power-ups and enhancements.
  - **Power-ups:** Developed power-ups that players can buy to enhance their stats such as health, speed, jump height, and bullet quantity.
  - **Dynamic 3rd Person Camera:** Implemented a dynamic camera system that follows the player and adjusts based on their movement and actions.
  - **Enemy AI:** Programmed enemies with AI that tracks and follows the player, making the gameplay challenging as they shoot at the player.
- **Gameplay Mechanics:**
  - Players earn points by defeating alien enemies.
  - Points can be used in the shop to buy power-ups, enhancing the player's abilities.
  - The game continues until the player is defeated by the enemies.
- **Code Highlights:**
  - **Enemy Behavior:** Developed a state machine for enemy AI, transitioning between idle and chase states based on the player's proximity.
  - **Player Stats Management:** Created a global static class to manage player stats, making it easy to modify and reset values as needed.
  - **Shop System:** Implemented a shop system that loads items from a file, displays them in a UI panel and handles purchasing logic based on the player's available points.
- **Additional Features:**
  - **UI/UX Enhancements:** Added UI elements to display the player's coin balance and dynamically update the availability of shop items.
  - **Good Coding Practices:** The project follows clean coding principles, with clear documentation, modular code, and proper use of object-oriented programming techniques.


## Blockchain

### [Toychain Blockchain Mining 23/04/2024]()
- **Description:** This assignment involves creating and mining blocks for a toy blockchain system called Toychain. The goal is to add blocks to the chain with increasing difficulty and submit them through a web interface, ensuring each block adheres to specific requirements and contains a unique miner pseudonym.
- **Technologies Used:** Python, SHA-256 Hashing, Web Interface (Toychain), Text File Handling.
- **Key Features:**
  - **Chain Creation:** Implemented a system to create a chain of blocks, each with increasing difficulty based on SHA-256 hashing.
  - **Difficulty Calculation:** Used a custom function to calculate the difficulty of each block by counting the leading zeros in its hash.
  - **Mining Algorithm:** Developed a mining algorithm that iterates through nonce values to find a valid hash with a specified difficulty.
  - **Web Submission:** Integrated with the Toychain web interface to submit newly mined blocks for validation.
  - **Text File Recording:** Recorded mined blocks and pseudonyms in a text file, adhering to the specified format for submission.
  - **Pseudonym Management:** Ensured all blocks used a unique miner pseudonym different from personal identifiers to maintain assignment uniqueness and privacy.
- **Code Highlights:**
  - **`calculate_difficulty` Function:** Determines the difficulty of a block by counting the number of leading zeros in its hash.
  - **`mine_block` Function:** Mines a block by incrementing a nonce value until a valid block is found with the required difficulty.
  - **User Input:** Takes previous block and miner pseudonym as input and outputs the newly mined block, nonce used, and its difficulty.


## Cyber security

### [Project 1: Dynamic Information Flow Control (IFC) Runtime Monitor 30/11/2023](link-to-project)
- **Description:** This project involves implementing a runtime monitor for dynamic information flow control (IFC) within a custom interpreter. The task is to complete a provided template by filling in missing parts to ensure that the interpreter enforces IFC policies correctly. The objective is to validate your understanding of IFC principles and their practical application in a runtime environment.
- **Technologies Used:** Haskell, Dynamic Information Flow Control (IFC), Functional Programming.
- **Key Features:**
  - **IFC Monitoring:** Implemented a runtime monitor that tracks and controls the flow of information between different security levels (e.g., Public and Secret).
  - **Label Joining:** Developed a mechanism to join labels according to IFC rules, ensuring correct security classifications for expressions and values.
  - **Expression Evaluation:** Extended the interpreter to handle expressions with dynamic labels, including boolean operations, arithmetic operations, and conditional branching.
  - **Lambda Calculus Support:** Integrated support for lambda calculus, including function application and abstraction, with proper label management.
  - **Template Completion:** Modified a provided template to fill in missing expressions and ensure the correct functioning of the IFC monitor within the interpreter.

### [Project 2: Static Information Flow Control (IFC) Type-Checker 20/01/2024](link-to-project)
- **Description:** This project focuses on enhancing your understanding of static information flow control (IFC) by implementing a type-checker. Building on a provided base type-checker, your task is to integrate IFC by completing specific cases: lambda expressions, application, if-else statements, and addition. The type-checker ensures that expressions adhere to IFC policies by checking security labels and types statically.
- **Technologies Used:** Haskell, Static Information Flow Control (IFC), Functional Programming.
- **Key Features:**
  - **Type-Checking for Lambda Expressions:** Implemented type-checking for lambda functions, ensuring that function types and their security labels are correctly managed.
  - **Application Case Handling:** Added type-checking for function application, verifying that function arguments and return types are consistent with security labels.
  - **If-Else Case Verification:** Incorporated type-checking for conditional expressions, ensuring that the condition is a boolean and both branches of the if-else construct have compatible types and security labels.
  - **Plus Operation Support:** Enabled type-checking for addition operations, enforcing that operands are natural numbers and properly handling their security labels.
  - **Security Label Management:** Utilised a label system to enforce security policies and ensure that information flows according to predefined rules.


## Algorithm

### [Project 1: Dynamic Array Implementation 15/11/2022](link-to-project)
- **Description:** This project involves implementing a dynamic array in Java as part of an assignment to understand how dynamic arrays function in practice. The goal is to extend a provided `DynamicArray` class by implementing a `MyUoKDynamicArray` class that supports dynamic resising, tracking of operations, and efficient item management. The implementation focuses on methods for adding items, resising the array, calculating amortised complexity, and removing items, all while maintaining accurate performance metrics.
- **Technologies Used:** Java, Object-Oriented Programming.
- **Key Features:**
  - **Dynamic Resising:** Implemented resising of the hidden array to accommodate additional items by a specified factor, with accurate tracking of operations performed during resising.
  - **Amortised Complexity Calculation:** Added functionality to calculate the amortised complexity of the add operation, providing insights into the average cost of operations over the lifetime of the dynamic array.
  - **Efficient Item Removal:** Enabled the removal of items from specific positions, with dynamic resising to reduce the array size when it becomes less than 25% full.
  - **Operation Tracking:** Maintained global counters for the number of operations performed and items added, used to calculate performance metrics.
  - **Testing and Validation:** Included various test cases to validate the functionality of methods and ensure correctness in resising, item management, and performance calculation.

### [Project 2: Mergesort Variants and Digger Control System 13/12/2022](link-to-project)
- **Description:** This project involves implementing and optimising various sorting algorithms and solving a resource collection problem for a digger control system. The Mergesort tasks require implementing several variations of the Mergesort algorithm, including merging two, three, and multiple arrays, as well as a parameterised version. The Digger control system requires developing recursive and memoised solutions to maximise resource collection from a grid map.
- **Technologies Used:** Java
- **Key Features:** 
  - **Mergesort Implementations:** Includes methods for merging two and three sorted arrays, a parameterised mergesort, and a method for merging an arbitrary number of arrays.
  - **Digger Control System:** Features recursive and optimised (memoised) algorithms for determining the maximum resources that can be collected by a digger navigating a grid.

#### Mergesort Variants
1. **Merge:** Implement a method to merge two sorted integer arrays into a single sorted array.
2. **Mergesort:** Implement the classic Mergesort algorithm to sort an integer array by recursively dividing and merging.
3. **Merge3:** Create a method to merge three sorted arrays into one sorted array.
4. **Mergesort3:** Implement a version of Mergesort that divides the array into three parts, sorts each part recursively, and merges them using the `merge3` method.
5. **MergeAll:** Develop a method to merge any number of sorted arrays into one sorted array.
6. **MergesortK:** Implement a parameterised mergesort that divides the array into `K` parts, recursively sorts them, and merges them using the `mergeAll` method.

#### Digger Control System
1. **Recursive maxResources:** Write a recursive method to compute the maximum resources a digger can collect from a grid by moving left-down or right-down.
2. **maxResourcesM:** Enhance the recursive solution with memoisation to optimise performance and reduce computation time for large grids.


## Artificial Intelligence

### [Solving Problems by Searching 21/11/2022](link-to-project)

- **Description:** This project focuses on implementing various search algorithms and game agents as part of an artificial intelligence assignment. The primary tasks involve implementing the A* search algorithm, developing a ghost agent for the Pacman game that uses Uniform Cost Search (UCS), and solving the Tower of Hanoi problem using search algorithms and heuristics. The project provides hands-on experience with search techniques and game AI development.
- **Technologies Used:** Java
- **Key Features:**
  - **A* Search Implementation:** Develop and test the A* search algorithm for pathfinding in a maze using the Manhattan distance heuristic.
  - **Pacman Ghost Agent:** Implement a Blinky Ghost agent that uses UCS to track and chase Pacman within the game.
  - **Tower of Hanoi:** Create a search problem for the Tower of Hanoi and implement both UCS and A* search algorithms, including a custom heuristic for optimisation. 
#### Tasks
1. **A* Search Implementation:** Implement the `aStarSearch` function in `GraphSearch.java` to solve maze pathfinding problems. Compare its performance with UCS by running experiments using `PacmanMain` with specified search strategies.
2. **Blinky Ghost Agent:** Implement a ghost agent (`BlinkyGhostAgent` in `GhostAgent.java`) that uses UCS to chase Pacman. Ensure that the ghost accurately follows Pacman during gameplay.
3. **Tower of Hanoi:** Develop the classes `TowerOfHanoiSearchProblem`, `TowerOfHanoiSearchState`, and `TowerOfHanoiAction` to solve the Tower of Hanoi problem using UCS and A*. Implement a useful heuristic for the A* search.


## Contact:
<p>If you'd like to get in touch, feel free to reach out:</p>

- **Email:** nabeena200203@gmail.com
- **Phone Number:** 07305182948
- **LinkedIn:** [Nabeena Islam](https://www.linkedin.com/in/nabeena-islam-397795283/)
