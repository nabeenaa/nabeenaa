
/*
   Enemy.cs defines the behavior of enemy entities in a Unity game. 
   Each enemy has health points, the ability to shoot projectiles at the player, 
   and handles its destruction, triggering death particles and contributing to player stats.
*/

using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    // References to other game objects and components
    public ParticleSystem deathParticles;    // Particle system for death effect
    public int enemyHP = 100;                 // Initial health points of the enemy
    public GameObject projectile;            // Projectile prefab to be shot
    public Transform projectilePoint;        // Point where the projectile is instantiated
    public Transform playerTransform;        // Reference to the player's transform
    public Animator animator;                // Animator for enemy animations

    // Method to make the enemy shoot projectiles
    public void Shoot()
    {
        // Calculate the direction from the enemy to the player
        Vector3 directionToPlayer = (playerTransform.position - transform.position).normalized;

        // Instantiate the projectile prefab at the adjusted position
        GameObject spawnedProjectile = Instantiate(projectile, projectilePoint.position, Quaternion.identity);

        // Shoot a raycast in the direction of the player to check if the player is hit
        RaycastHit hit;
        if (Physics.Raycast(transform.position, directionToPlayer, out hit, Mathf.Infinity))
        {
            if (hit.transform.CompareTag("Player"))
            {
                // If the player is hit, reduce player's health using TakeDamage method
                playerTransform.GetComponent<PlayerController>().TakeDamage(2);
            }
        }

        // Destroy the projectile after a delay
        Destroy(spawnedProjectile, 3);
    }

    // Method to reduce enemy health when it takes damage
    public void TakeDamage(int damageAmount)
    {
        enemyHP -= damageAmount;
        if (enemyHP <= 0)
        {
            // If enemy health is zero or less, destroy the enemy
            DestroyEnemy();
        }
    }

    // Method to handle destruction of the enemy
    private void DestroyEnemy()
    {
        // Decrement the count of alive enemies and increment player's coins
        EnemyStats.enemiesAlive -= 1;
        PlayerStats.coins += 50;

        // Destroy the enemy game object and instantiate death particles
        Destroy(gameObject);
        Instantiate(deathParticles, transform.position, Quaternion.identity);
    }
}
