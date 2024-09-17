
/*
   SwitchVCam.cs manages the transition between a third-person view and an aiming view in a Unity game. 
   It utilizes the Cinemachine Virtual Camera to adjust priority during aiming, enabling/disabling 
   corresponding UI canvases for a seamless visual transition. Player input is used to trigger and 
   cancel aiming, ensuring a responsive and intuitive experience.
*/

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using Cinemachine;

public class SwitchVCam : MonoBehaviour
{
    // Reference to the PlayerInput component
    [SerializeField]
    private PlayerInput playerInput;

    // Priority boost amount for the Cinemachine Virtual Camera
    [SerializeField]
    private int priorityBoostAmount;

    // Canvas for the third-person view
    [SerializeField]
    private Canvas thirdPersonCanvas;

    // Canvas for the aiming view
    [SerializeField]
    private Canvas aimCanvas;

    // Reference to the Cinemachine Virtual Camera component
    private CinemachineVirtualCamera virtualCamera;

    // Input action for aiming
    private InputAction aimAction;

    // Awake is called when the script instance is being loaded
    private void Awake()
    {
        // Get the Cinemachine Virtual Camera component and aim input action
        virtualCamera = GetComponent<CinemachineVirtualCamera>();
        aimAction = playerInput.actions["Aim"];
    }

    // OnEnable is called when the script becomes enabled and active
    private void OnEnable()
    {
        // Subscribe to the aiming input action events
        aimAction.performed += _ => StartAim();
        aimAction.canceled += _ => CancelAim();
    }

    // OnDisable is called when the script becomes disabled or inactive
    private void OnDisable()
    {
        // Unsubscribe from the aiming input action events
        aimAction.performed -= _ => StartAim();
        aimAction.canceled -= _ => CancelAim();
    }

    // StartAim is called when the player starts aiming
    private void StartAim()
    {
        // Increase the priority of the Cinemachine Virtual Camera for aiming
        virtualCamera.Priority += priorityBoostAmount;

        // Enable the aiming canvas and disable the third-person canvas
        aimCanvas.enabled = true;
        thirdPersonCanvas.enabled = false;
    }

    // CancelAim is called when the player stops aiming
    private void CancelAim()
    {
        // Decrease the priority of the Cinemachine Virtual Camera after aiming
        virtualCamera.Priority -= priorityBoostAmount;

        // Disable the aiming canvas and enable the third-person canvas
        aimCanvas.enabled = false;
        thirdPersonCanvas.enabled = true;
    }
}
