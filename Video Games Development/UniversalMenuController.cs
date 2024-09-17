/*
   UniversalMenuController.cs manages the various menus (Main, Pause, Options, Shop) in a Unity game, 
   including functionalities like transitioning between menus, handling purchases in the shop, updating 
   coin labels, and restarting the game. It also checks if the player is in-game to determine menu visibility.
*/
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;

public class UniversalMenuController : MonoBehaviour
{
    // References to menu game objects and UI elements
    public GameObject MainMenu;
    public GameObject PauseMenu;
    public GameObject OptionsMenu;
    public GameObject ShopMenu;
    public TMP_Text CoinLabel;

    // Update is called once per frame
    public void Update()
    {
        // Update coin label in UI
        CoinLabel.text = "Coins: " + PlayerStats.coins.ToString();
    }

    // Awake is called when the script instance is being loaded
    public void Awake()
    {
        // Check if the player is in-game, adjust menu visibility accordingly
        if (PlayerStats.isPlayerInGame)
        {
            MainMenu.SetActive(false);
            PauseMenu.SetActive(true);
        }
    }

    // MAIN MENU
    public void MainPlay()
    {
        // Load the game scene and set player in-game status
        SceneManager.LoadSceneAsync("Level01", LoadSceneMode.Single);
        PlayerStats.isPlayerInGame = true;
        MainMenu.SetActive(false);
    }

    public void MainOptions()
    {
        // Transition to the Options menu
        MainMenu.SetActive(false);
        OptionsMenu.SetActive(true);
    }

    public void Quit()
    {
        // TO DO: QUIT GAME
    }
    // MAIN MENU END

    // PAUSE MENU
    public void PauseResume()
    {
        // Resume game and hide the pause menu
        PauseMenu.SetActive(false);
        SceneManager.LoadSceneAsync("Level01");
    }

    public void PauseShop()
    {
        // Transition to the Shop menu
        PauseMenu.SetActive(false);
        ShopMenu.SetActive(true);
    }

    public void PauseOptions()
    {
        // Transition to the Options menu
        PauseMenu.SetActive(false);
        OptionsMenu.SetActive(true);
    }
    // PAUSE MENU END

    // OPTIONS MENU
    public void OptionsBack()
    {
        // Return to the previous menu (Main or Pause)
        OptionsMenu.SetActive(false);

        if (PlayerStats.isPlayerInGame)
            PauseMenu.SetActive(true);
        else
            MainMenu.SetActive(true);
    }
    // OPTIONS MENU END

    // SHOP MENU
    void WriteDebug()
        => Debug.Log($"Health: {PlayerStats.health}\nSpeed: {PlayerStats.speed}\nJump: {PlayerStats.jumpHeight}\nCoins: {PlayerStats.coins}\nBullet amount: {PlayerStats.bulletAmount}");

    public void BuyHealth()
    {
        // Purchase health upgrade if player has enough coins
        if (PlayerStats.coins >= 500)
        {
            PlayerStats.health += 100f;
            PlayerStats.coins -= 500;
        }
        WriteDebug();
    }

    public void BuyShoot()
    {
        // Purchase bullet amount upgrade if player has enough coins
        if (PlayerStats.coins >= 300)
        {
            PlayerStats.bulletAmount *= 3;
            PlayerStats.coins -= 300;
        }
        WriteDebug();
    }

    public void BuyJump()
    {
        // Purchase jump height upgrade if player has enough coins
        if (PlayerStats.coins >= 500)
        {
            PlayerStats.jumpHeight += 3;
            PlayerStats.coins -= 500;
        }
        WriteDebug();
    }

    public void BuySpeed()
    {
        // Purchase speed upgrade if player has enough coins
        if (PlayerStats.coins >= 400)
        {
            PlayerStats.speed += 3;
            PlayerStats.coins -= 400;
        }
        WriteDebug();
    }

    public void ShopBack()
    {
        // Return to the Pause menu from the Shop menu
        ShopMenu.SetActive(false);
        PauseMenu.SetActive(true);
        EnemyStats.enemiesAlive = 0;
    }
    // SHOP MENU END

    // Restart the game
    public void Restart()
    {
        PlayerStats.ResetToDefaults();
        SceneManager.LoadSceneAsync("Main Menu");
    }
}
