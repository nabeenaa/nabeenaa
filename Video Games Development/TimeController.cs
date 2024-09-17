/*
   TimeController.cs manages the manipulation of time in a Unity game. 
   It provides functionality for gradually slowing down and returning to normal time scale. 
   The script is designed to be attached to a game object in the scene and can be utilized 
   to create slow-motion effects for specific events triggered in the game.
*/
using UnityEngine;

public class TimeController : MonoBehaviour
{
    // Factors for controlling the slowdown effect
    public float slowdownFactor = 0.05f;
    public float slowdownLength = 2f;

    // Update is called once per frame
    void Update()
    {
        // Gradually return to normal time scale
        Time.timeScale += (1f / slowdownLength) * Time.unscaledDeltaTime;
        Time.timeScale = Mathf.Clamp(Time.timeScale, 0f, 1f);
    }

    // DoSlowmotion is a public method to initiate the slow-motion effect
    public void DoSlowmotion()
    {
        // Set the time scale to achieve slow-motion
        Time.timeScale = slowdownFactor;

        // Adjust the fixed delta time to maintain physics stability during slow-motion
        Time.fixedDeltaTime = Time.timeScale * .02f;
    }
}
