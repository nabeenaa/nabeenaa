
# Alien Slayer - Video Game Project 22/12/2023

## Project Overview

**Alien Slayer** is a third-person shooter game developed in Unity where players battle waves of alien enemies. The player must defeat enemies, collect coins, and buy power-ups from the in-game shop to survive longer. The game ends when the player's health reaches zero, and they can start again. The player is equipped with several gameplay mechanics like shooting, slow motion, dynamic camera movement, and AI-controlled enemies that follow and shoot the player.

## Key Features

1. **Slow Motion**: A slow-motion effect where the game speed is reduced for a brief period.
2. **Spawning Enemies**: Enemies spawn randomly after each wave of defeated enemies, ensuring continuous action.
3. **Shop System**: Players can buy power-ups like health, speed, triple bullets, and increased jump height with points earned from killing enemies.
4. **Power-ups**: Enhances player abilities by increasing stats such as speed, health, and bullet count.
5. **Dynamic Camera**: The game utilises dynamic third-person camera controls with an option to aim using a virtual camera.
6. **Enemy AI**: Enemies track and attack the player, adding challenge to the game.

## Components

### 1. **Bullet Controller (BulletController.cs)**
   The bullet controller handles the behavior of bullets shot by the player. Each bullet is responsible for moving towards a target and self-destruction either on impact or after a set duration.

   - **Attributes**: 
     - `bulletDecal`: The visual effect when a bullet hits an object.
     - `explosionParticles` & `smokeParticles`: Effects when bullets hit a target.
     - `speed`: The bullet's speed.
     - `timeToDestroy`: Duration before the bullet self-destructs.

   - **Methods**:
     - `OnCollisionEnter`: Detects collisions and spawns particle effects on impact.
     - `Update`: Moves the bullet towards its target.
  
### 2. **Player Controller (PlayerController.cs)**
   The player controller manages player movement, health, and interactions. The script incorporates shooting, jumping, time manipulation (slow motion), and damage mechanics.

   - **Attributes**: 
     - Movement speed, jump height, and gravity settings.
     - Player health, bullet stats, and slow motion parameters.
     - Controls: Supports input actions for movement, jumping, shooting, and triggering slow motion.

   - **Key Methods**:
     - `ShootGun`: Fires bullets towards enemies.
     - `TakeDamage`: Reduces player health and resets the game when health reaches zero.
     - `DoSlowmotion`: Triggers a slow-motion effect during gameplay.
     - `Update`: Handles player movement, jumping, shooting, and applying gravity.

### 3. **Virtual Camera Switching (SwitchVCam.cs)**
   Manages transitions between the third-person view and aiming mode. It adjusts camera priority and displays appropriate UI components for the selected view.

   - **Attributes**: 
     - `playerInput`: Handles player inputs.
     - `priorityBoostAmount`: Controls the priority of the aiming camera.
     - UI elements for third-person and aiming views.

   - **Methods**:
     - `StartAim`: Activates aiming mode, switching to a zoomed-in camera view.
     - `CancelAim`: Switches back to the third-person camera view.

### 4. Time Manipulation
- **Script**: `TimeController.cs`
- **Description**: This script manages the slow-motion effect by reducing the game's time scale and then gradually restoring it to normal.
- **Key Methods**:
  - `DoSlowmotion()`: Initiates the slow-motion effect by reducing the time scale and adjusting the fixed delta time to maintain physics accuracy.
  - `Update()`: Gradually returns the time scale to normal after a slowdown.

### 5. Enemy AI Behavior
- **Scripts**:
  - `AttackBehavior.cs`: Manages the attack phase of the enemy AI.
  - `ChaseBehavior.cs`: Handles enemy movement towards the player when they are detected.
  - `IdleBehavior.cs`: Defines enemy behavior while idle, checking for the player’s presence within a chase range.
  
- **Description**: These scripts manage the enemy's AI using Unity’s Animator State Machine. The AI can switch between different behaviors (idle, chasing, attacking) depending on the player's proximity and other conditions.
  
- **Key Methods**:
  - `OnStateEnter()`, `OnStateUpdate()`, `OnStateExit()`: These methods manage transitions between different states (idle, chase, attack) and implement actions within each state.

### 6. Game World Management
- **Script**: `World.cs`
- **Description**: This script manages the game world, including enemy spawning and updating player stats in the UI (coins, health).
- **Key Methods**:
  - `CheckAndSpawnEnemies()`: Continuously checks the number of enemies alive and spawns new ones when necessary.
  - `Update()`: Updates UI elements like the player's health and coins in real time.

### 7. Player Stats and Power-ups
- **Script**: `PlayerStats.cs`
- **Description**: Defines globally accessible variables for player stats (health, speed, jump height, etc.) that can be modified from various game components.
- **Key Methods**:
  - `ResetToDefaults()`: Resets all player stats to their default values at the start of a new game.
  
### 8. Shop System
- **Script**: `UniversalMenuController.cs`
- **Description**: Manages the in-game menus, including the shop, where players can purchase power-ups using coins. The script handles transitions between different menus (Main Menu, Pause, Shop).
- **Key Methods**:
  - `BuyHealth()`, `BuySpeed()`, `BuyJump()`, `BuyShoot()`: These methods handle player purchases from the shop, modifying the relevant player stats (health, speed, etc.) and deducting coins.
  - `Update()`: Updates the displayed coin count in the UI during gameplay.

### 9. Menu Navigation
- **Script**: `KeyListener.cs`
- **Description**: Listens for key inputs (e.g., the `P` key) to transition between different game scenes, such as going back to the Main Menu.
  
### 10. Enemy Stats
- **Script**: `EnemyStats.cs`
- **Description**: Defines enemy-related stats such as the number of enemies to spawn and the number currently alive. This script helps manage the game's dynamic enemy spawning system.

### 11. Player-Enemy Interaction
- **Script**: `UniversalMenuController.cs`
- **Description**: Handles UI and gameplay features, such as restarting the game, managing the pause and options menu, and interacting with the shop.

## Power-ups and Shop System
- **Health Power-up**: Increases the player’s health by 100 points for 500 coins.
- **Speed Power-up**: Increases the player’s movement speed for 400 coins.
- **Jump Height Power-up**: Increases the player’s jump height for 500 coins.
- **Triple Bullet Power-up**: Increases the number of bullets fired per shot for 300 coins.

These upgrades play a crucial role in surviving against the waves of enemies.

## Game Mechanics
- **AI Navigation**: Enemies use Unity’s NavMesh system to navigate the game world and chase the player.
- **State Machine**: Enemy behavior is controlled through a finite state machine (FSM) built into Unity’s Animator. The enemies transition between idle, chase, and attack states depending on the player’s position.

## Tests
- **Enemy AI Testing**: Verified that enemies transition correctly between idle, chase, and attack states and that they engage the player when in range.
- **Shop Functionality**: Tested all purchasing options to ensure proper deduction of coins and updating of player stats.
- **Slow-Motion Mechanic**: Ensured that the time manipulation worked without affecting other game systems (e.g., physics).
- **UI Updates**: Confirmed that the UI elements for health and coins update in real time and reflect player actions (e.g., purchases in the shop).
- **Enemy Spawning**: Tested the correct number of enemies spawning after each wave and increasing difficulty over time.

## How to Play
1. Start the game from the Main Menu.
2. Defeat waves of alien enemies.
3. Collect coins from fallen enemies and visit the shop to purchase power-ups.
4. Use the slow-motion feature for more precise combat.
5. Survive as long as possible—game ends when your health reaches zero.

## Future Enhancements
- **New Power-ups**: Additional power-ups could be introduced to give the player more strategic options.
- **Multiplayer Mode**: Adding a multiplayer option for cooperative gameplay.
- **New Enemy Types**: Introducing different types of enemies with varied behaviors and attack patterns.

## Conclusion
Alien Slayer is a comprehensive third-person shooter game that incorporates key Unity development techniques such as state machines, AI navigation, dynamic UI updates, and slow-motion mechanics. It’s a fun and engaging game that challenges players to strategise and survive against increasingly difficult waves of alien enemies.




