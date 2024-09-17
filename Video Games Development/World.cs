/*
   EnemyStats.cs defines globally accessible variables related to enemy statistics in a Unity game. 
   It includes the number of enemies to spawn and the number of enemies currently alive.
*/

using System.Collections;
using System.Collections.Generic;
using TMPro;
using Unity.VisualScripting;
using UnityEngine;

public static class EnemyStats
{
    // Number of enemies to spawn
    public static int enemiesToSpawn = 3;

    // Number of enemies currently alive
    public static int enemiesAlive = 0;
}

/*
   World.cs manages the game world, including enemy spawning and UI updates for player stats (coins and health).
   The script uses a coroutine to continuously check the number of enemies alive and spawns new enemies when needed.
*/
public class World : MonoBehaviour
{
    // References to game objects and UI elements
    public GameObject enemyPrefab;
    public Transform player;
    public TMP_Text coinslabel;
    public TMP_Text healthlabel;

    // Update is called once per frame
    private void Update()
    {
        // Update UI labels for coins and health
        coinslabel.text = "Coins: " + PlayerStats.coins.ToString();
        healthlabel.text = "Health: " + PlayerStats.health.ToString();
    }

    // Start is called at the beginning of the execution
    void Start()
    {
        // Begin the coroutine for checking and spawning enemies
        StartCoroutine(CheckAndSpawnEnemies());
    }

    // Coroutine to check for the number of enemies alive and spawn new ones when necessary
    IEnumerator CheckAndSpawnEnemies()
    {
        while (true)
        {
            // Check if all enemies have been defeated
            if (EnemyStats.enemiesAlive == 0)
            {
                EnemyStats.enemiesAlive = 1; // Change value to prevent extra enemies from spawning
                yield return new WaitForSeconds(3); // Pause for 3 seconds

                // Loop for the amount of enemies to spawn
                for (EnemyStats.enemiesAlive = 0; EnemyStats.enemiesAlive <= EnemyStats.enemiesToSpawn; EnemyStats.enemiesAlive++)
                {
                    var X = Random.Range(290, 310);
                    var Z = Random.Range(240, 250);

                    // Spawn an enemy
                    var enemy = Instantiate(enemyPrefab, new Vector3(X, 1, Z), new Quaternion());
                    enemy.GetComponent<Enemy>().playerTransform = player;
                    yield return new WaitForSeconds(1); // Wait one second
                }

                // Increase the amount of enemies to spawn for the next round randomly
                EnemyStats.enemiesToSpawn += Random.Range(3, 5);
            }

            yield return new WaitForSeconds(3); // Check every three seconds
        }
    }
}
