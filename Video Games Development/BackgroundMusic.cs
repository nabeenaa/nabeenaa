/*
   BackgroundMusic.cs ensures a single instance of background music persists across scene changes. 
   This script, attached to the background music game object, uses a Singleton pattern for this purpose.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BackgroundMusic : MonoBehaviour
{
    // Static reference to the BackgroundMusic instance
    private static BackgroundMusic backgroundMusic;

    // Awake is called when the script instance is being loaded
    void Awake()
    {
        // Check if an instance of BackgroundMusic already exists
        if (backgroundMusic == null)
        {
            // If not, mark this instance as the BackgroundMusic and prevent destruction on scene load
            backgroundMusic = this;
            DontDestroyOnLoad(backgroundMusic);
        }
        else
        {
            // If an instance already exists, destroy this instance to maintain only one persistent background music source
            Destroy(gameObject);
        }
    }
}
