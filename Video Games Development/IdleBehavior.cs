/*
   IdleBehavior.cs is a StateMachineBehaviour script for Unity's Animator system. 
   It defines the behavior of an entity when in an idle state, checking for the player's 
   presence within a specified chase range. If the player is detected, it triggers a 
   transition to the chase state.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class IdleBehavior : StateMachineBehaviour
{
    // Timer for idle state
    float timer;

    // Player's transform for detection
    Transform player;

    // Chase range threshold
    float chaseRange = 100;

    // OnStateEnter is called when a transition starts, and the state machine starts to evaluate this state
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Initialize timer and find player's transform
        timer = 0;
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    // OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Check distance to player and trigger chase state if within range
        float distance = Vector3.Distance(animator.transform.position, player.position);
        if (distance < chaseRange)
            animator.SetBool("isChasing", true);
    }

    // OnStateExit is called when a transition ends, and the state machine finishes evaluating this state
    override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        // Additional actions can be added if needed when exiting the idle state
    }
}
