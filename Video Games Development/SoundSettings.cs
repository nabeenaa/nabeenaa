/*
   SoundSettings.cs manages the sound settings in a Unity game, particularly the music volume. 
   The script is typically attached to a game object and uses a Slider to control the volume level. 
   It checks PlayerPrefs for the stored music volume on start and provides methods to change, save, 
   and load the volume setting.
*/
using UnityEngine;
using UnityEngine.Audio;
using UnityEngine.UI;
using System.Collections;
using System.Collections.Generic;

public class SoundSettings : MonoBehaviour
{
    // Reference to the sound volume slider
    [SerializeField] Slider soundSlider;

    // Start is called before the first frame update
    void Start()
    {
        // Check if music volume key exists in PlayerPrefs
        if (!PlayerPrefs.HasKey("musicVolume"))
        {
            // If not, set default volume and load
            PlayerPrefs.SetFloat("musicVolume", 1);
            Load();
        }
        else
        {
            // If key exists, load the volume setting
            Load();
        }
    }

    // Method to change the volume based on the slider value
    public void ChangeVolume()
    {
        AudioListener.volume = soundSlider.value;
    }

    // Method to load the saved volume setting
    private void Load()
    {
        // Additional loading functionality can be added if needed
    }

    // Method to save the current volume setting
    private void Save()
    {
        PlayerPrefs.SetFloat("musicVolume", soundSlider.value);
    }
}
