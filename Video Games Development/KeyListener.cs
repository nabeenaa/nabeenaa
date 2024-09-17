/*
   KeyListener.cs listens for a specific key press (P) to trigger a scene transition in a Unity game. 
   Upon pressing the key, it asynchronously loads the "Main Menu" scene and adjusts the cursor visibility 
   and lock state accordingly.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.SceneManagement;

public class KeyListener : MonoBehaviour
{
    // Update is called once per frame
    void Update()
    {
        // Check for the 'P' key press
        if (Input.GetKeyDown(KeyCode.P))
        {
            // Load the "Main Menu" scene asynchronously
            SceneManager.LoadSceneAsync("Main Menu");

            // Adjust cursor visibility and lock state
            Cursor.visible = true;
            Cursor.lockState = CursorLockMode.None;
        }
    }
}
