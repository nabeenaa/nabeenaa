/*
   AttackBehavior.cs is a StateMachineBehaviour script designed for use with Unity's Animator system. 
   It controls the behavior of an animation state where an entity is attacking. The script makes 
   the character look at the player during the attack animation and checks if the player is within a 
   certain distance. If the player is too far away, it sets a boolean parameter to transition out of 
   the attacking state. This script is typically used in conjunction with a Finite State Machine (FSM) 
   to manage enemy behaviors in a game.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AttackBehavior : StateMachineBehaviour
{
    // Reference to the player's transform
    Transform player;

    // OnStateEnter is called when a transition starts and the state machine starts to evaluate this state
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Find and store the player's transform on entering the attack state
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    // OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Make the character look at the player during the attack animation
        animator.transform.LookAt(player);

        // Calculate the distance between the character and the player
        float distance = Vector3.Distance(animator.transform.position, player.position);

        // If the player is too far away, set a boolean parameter to exit the attacking state
        if (distance > 20)
            animator.SetBool("isAttacking", false);
    }

    // OnStateExit is called when a transition ends and the state machine finishes evaluating this state
    override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Additional actions can be added if needed when exiting the attack state
    }
}
