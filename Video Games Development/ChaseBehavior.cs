/*
   ChaseBehavior.cs is a StateMachineBehaviour script for Unity's Animator system. 
   It manages the chasing behavior of an entity towards the player. 
   The script uses Unity's NavMeshAgent for navigation, setting speed and attack range parameters.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class ChaseBehavior : StateMachineBehaviour
{
    // NavMeshAgent for navigation
    NavMeshAgent agent;

    // Player's transform for tracking
    Transform player;

    // Attack range threshold
    float attackRange = 10;

    // OnStateEnter is called when a transition starts and the state machine starts to evaluate this state
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Initialize NavMeshAgent and set speed
        agent = animator.GetComponent<NavMeshAgent>();
        agent.speed = 5;

        // Find and store the player's transform
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    // OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Set destination to the player's position
        agent.SetDestination(player.position);

        // Check distance to player and trigger attack state if within range
        float distance = Vector3.Distance(animator.transform.position, player.position);
        if (distance < attackRange)
            animator.SetBool("isAttacking", true);
    }

    // OnStateExit is called when a transition ends and the state machine finishes evaluating this state
    override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Reset destination and speed when exiting the chase state
        agent.SetDestination(agent.transform.position);
        agent.speed = 3;
    }
}
