
# HTML, CSS, and JavaScript (Nabeena Islam 11/03/2022)

## Project Overview

This project consists of three distinct web development tasks that showcase proficiency in HTML, CSS, and JavaScript. The tasks range from creating dynamic forms and interactive tables to generating random elements and building a basic Tic-Tac-Toe game. Each task emphasises different aspects of web development, including form validation, DOM manipulation, and event handling.

## Task 1: Gym Membership Registration Form

### Overview

The first task involves creating a web page with a form to register users for a gym membership. The form collects user information such as full name, age, height, and planned start date. The data from the form is dynamically added to a table upon submission, with additional functionality for validation, deletion, and form resetting.

### Features

- **Form Elements**: The form includes fields for full name, age (18–65), height (using feet and inches dropdowns), and planned start date (restricted to 2022).
- **Dynamic Table Creation**: Upon clicking the "Add Member" button, the form data is validated and then appended as a new row in a table. The table includes columns corresponding to each form input.
- **Alternating Row Colors**: Rows in the table have alternating background colors for better readability.
- **Delete Functionality**: Each row includes a "Delete Member" button that removes the row when clicked.
- **Form Reset**: A "Reset Form" button clears all form inputs.
- **Row Counter**: The table includes a caption that displays the total number of data rows, which updates dynamically as rows are added or deleted.

### Methods

- **JavaScript Validation**: Custom functions are implemented to ensure that the age is within the specified range (18-65) and that the start date is within the year 2022.
- **DOM Manipulation**: JavaScript is used to dynamically add rows to the table, delete rows, reset the form, and update the row counter.
- **Event Handling**: The project handles various user interactions, such as button clicks for form submission, row deletion, and form resetting.

### Components

- **HTML Form**: Contains input fields for user registration.
- **JavaScript Functions**: Validate form inputs, manipulate the DOM to add or remove rows, and update the row counter.
- **CSS Styling**: Includes alternating row colors, form styling, and responsive design considerations.

### Testing

The form and table functionalities were tested across different browsers to ensure consistent behavior. Edge cases, such as invalid ages or dates outside of 2022, were tested to confirm proper validation.

## Task 2: Dynamic Box Generation

### Overview

The second task focuses on creating a dynamic web page where users can generate a series of boxes with specific properties. The number of boxes is determined by user input, and each box is styled with a random background color and a left margin that increases progressively.

### Features

- **Random Box Color**: Each generated box has a unique random background color.
- **Progressive Margins**: The left margin of each subsequent box is double that of the previous one, starting from 5px.
- **Dynamic Content**: Previous boxes are cleared when the user inputs a new number.

### Methods

- **Random Color Generation**: JavaScript generates a random color for each box.
- **Dynamic Styling**: JavaScript calculates and applies the appropriate left margin to each box.
- **DOM Manipulation**: Boxes are created or cleared based on user input.

### Components

- **Input Field**: Allows users to specify the number of boxes to generate.
- **JavaScript Functions**: Handle the generation of boxes, application of styles, and clearing of previous boxes.
- **CSS Styling**: Ensures that the boxes are properly displayed and aligned.

### Testing

The functionality was tested to ensure that boxes are generated correctly with the specified properties and that the old boxes are removed when new ones are generated.

## Task 3: Tic-Tac-Toe Game

### Overview

The final task involves creating a simplified version of the Tic-Tac-Toe game. The game board is a 3x3 grid where players can take turns placing "X" and "O" markers. The game includes functionality for resetting the board and ensuring that once a marker is placed, it cannot be changed.

### Features

- **Interactive Game Board**: A 3x3 grid where players can click to place "X" or "O" markers.
- **Player Switch**: Alternates between "X" and "O" after each turn.
- **Reset Functionality**: A "Reset" button clears the board and resets the game.
- **Styling**: The game board is styled with CSS to differentiate "X" and "O" markers by color and to center the markers within the grid cells.

### Methods

- **DOM Manipulation**: JavaScript handles the creation of the game board, placement of markers, and resetting of the board.
- **Event Handling**: Click events are managed to place markers and switch players, as well as to reset the board.
- **Optional Winning Condition**: A function checks for possible winning conditions and prevents further moves once a player wins.

### Components

- **Game Board**: A 3x3 grid where players place their markers.
- **JavaScript Functions**: Manage the game logic, including player turns, marker placement, and game resetting.
- **CSS Styling**: Ensures the game board is visually appealing and markers are clearly distinguished.

### Testing

The Tic-Tac-Toe game was tested for functionality, including correct marker placement, player switching, and board resetting. The optional winning condition was also tested to ensure accuracy.

## Conclusion

This project showcases various aspects of web development using HTML, CSS, and JavaScript. Each task highlights different techniques, from form validation and DOM manipulation to dynamic content generation and game logic implementation. The code is well-organised, with a focus on readability, maintainability, and user experience.

Feel free to explore the project files to see how these features were implemented and to test the interactive functionalities.
