/*
   PlayerStats.cs defines globally accessible variables related to the player's status in a Unity game. 
   These variables, including health, speed, jump height, coins, bullet amount, and a boolean flag 
   indicating the player's presence in the game, can be changed from any class. The class also provides 
   a method to reset all stats to their default values.
*/
using UnityEngine;

public static class PlayerStats
{
    // Player health
    public static float health = 100f;

    // Player speed
    [SerializeField]
    public static float speed = 8f;

    // Player jump height
    public static float jumpHeight = 1f;

    // Player coins
    public static int coins = 100;

    // Amount of bullets to shoot
    public static int bulletAmount = 1;

    // Bool to check whether the player is in the game
    public static bool isPlayerInGame = false;

    // Method to reset all stats to their default values
    public static void ResetToDefaults()
    {
        health = 100f;
        speed = 8f;
        jumpHeight = 1f;
        coins = 100;
        bulletAmount = 1;
        isPlayerInGame = false;

        // Reset enemy-related stats
        EnemyStats.enemiesAlive = 0;
        EnemyStats.enemiesToSpawn = 3;
    }
}
