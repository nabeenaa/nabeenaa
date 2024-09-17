
/*
   PlayerController.cs manages the behavior of the player character in a Unity game. 
   It handles character movement, shooting, jumping, time manipulation, and damage. 
   The script includes functionality for shooting bullets, applying damage to enemies on hit, 
   managing player health, initiating a slow-motion effect, and updating the player's animations. 
   Additionally, it incorporates Unity Input System for player input handling.
*/

using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.SceneManagement;

[RequireComponent(typeof(CharacterController), typeof(PlayerInput))]
public class PlayerController : MonoBehaviour
{
    // Serialized fields for inspector visibility
    [SerializeField]
    private float gravityValue = -9.81f;
    [SerializeField]
    private float rotationSpeed = 0.8f;
    [SerializeField]
    private GameObject bulletPrefab;
    [SerializeField]
    private Transform barrelTransform;
    [SerializeField]
    private Transform bulletParent;
    [SerializeField]
    private float animationSmoothTime = 0.1f;
    [SerializeField]
    private float animationPlayTransition = 0.15f;

    // Public variables for slow motion effect
    public float slowdownFactor = 0.05f;
    public float slowdownLength = 2f;

    // Private variables for player control
    private CharacterController controller;
    private Vector3 playerVelocity;
    private bool groundedPlayer;
    private PlayerInput playerInput;
    private Transform cameraTransform;

    // Input actions
    private InputAction moveAction;
    private InputAction shootAction;
    private InputAction jumpAction;
    private InputAction timeAction;

    // Animator and animation-related variables
    private Animator animator;
    int jumpAnimation;
    int moveXAnimationParameterId;
    int moveZAnimationParameterId;
    Vector2 currentAnimationBlendVector;
    Vector2 animationVelocity;

    // References to UI and audio
    public GameObject deathScreen;
    private AudioSource source;

    private void Awake()
    {
        // Initialize components and references
        controller = GetComponent<CharacterController>();
        playerInput = GetComponent<PlayerInput>();
        moveAction = playerInput.actions["Move"];
        cameraTransform = Camera.main.transform;
        jumpAction = playerInput.actions["Jump"];
        shootAction = playerInput.actions["Shoot"];
        timeAction = playerInput.actions["Time"];
        Cursor.lockState = CursorLockMode.Locked;

        animator = GetComponent<Animator>();
        jumpAnimation = Animator.StringToHash("Pistol Jump");
        moveXAnimationParameterId = Animator.StringToHash("MoveX");
        moveZAnimationParameterId = Animator.StringToHash("MoveZ");

        source = GetComponent<AudioSource>();
    }

    private void OnEnable()
    {
        // Subscribe to the shoot action event
        shootAction.performed += _ => StartCoroutine(ShootGun());
    }

    private void OnDisable()
    {
        // Unsubscribe from the shoot action event
        shootAction.performed -= _ => StartCoroutine(ShootGun());
    }

    // DAMAGE FUNCTION
    public void TakeDamage(float health)
    {
        // Reduce player health
        PlayerStats.health -= health;

        // Log the damage taken
        Debug.Log("Damage taken: " + PlayerStats.health.ToString());

        // Check if player health is zero or less, then reset and load the main menu
        if (PlayerStats.health <= 0)
        {
            Cursor.visible = true;
            Cursor.lockState = CursorLockMode.None;
            PlayerStats.ResetToDefaults();
            SceneManager.LoadSceneAsync("Main Menu");
        }
    }

    IEnumerator ShootGun()
    {
        // Iterate for the specified bullet amount
        for (int i = 1; i <= PlayerStats.bulletAmount; i++)
        {
            source.Play();
            RaycastHit hit;

            // Instantiate a bullet and get its controller component
            GameObject bullet = GameObject.Instantiate(bulletPrefab, barrelTransform.position, Quaternion.identity, bulletParent);
            BulletController bulletController = bullet.GetComponent<BulletController>();

            // Shoot a raycast to determine the bullet's target and apply damage to enemies if hit
            if (Physics.Raycast(cameraTransform.position, cameraTransform.forward, out hit, Mathf.Infinity))
            {
                bulletController.target = hit.point;
                bulletController.hit = true;

                if (hit.transform.tag == "Enemy")
                {
                    var enemyAIComponent = hit.transform.GetComponent<Enemy>();
                    enemyAIComponent.TakeDamage(20);
                }
            }
            else
            {
                bulletController.target = cameraTransform.position + cameraTransform.forward * 25;
                bulletController.hit = false;
            }

            // Wait for a short interval before shooting the next bullet
            yield return new WaitForSeconds(.1f);
        }

        yield return null;
    }

    void Update()
    {
        // Update the time scale for slow motion effect
        Time.timeScale += (1f / slowdownLength) * Time.unscaledDeltaTime;
        Time.timeScale = Mathf.Clamp(Time.timeScale, 0f, 1f);

        groundedPlayer = controller.isGrounded;

        // Adjust player velocity if grounded
        if (groundedPlayer && playerVelocity.y < 0)
        {
            playerVelocity.y = 0f;
        }

        // Read input for movement
        Vector2 input = moveAction.ReadValue<Vector2>();
        currentAnimationBlendVector = Vector2.SmoothDamp(currentAnimationBlendVector, input, ref animationVelocity, animationSmoothTime);
        Vector3 move = new Vector3(currentAnimationBlendVector.x, 0, currentAnimationBlendVector.y);

        // Adjust movement based on camera direction
        move = move.x * cameraTransform.right.normalized + move.z * cameraTransform.forward.normalized;
        move.y = 0f;

        // Move the player using the CharacterController
        controller.Move(move * Time.deltaTime * PlayerStats.speed);

        // Update animator parameters for movement
        animator.SetFloat(moveXAnimationParameterId, currentAnimationBlendVector.x);
        animator.SetFloat(moveZAnimationParameterId, currentAnimationBlendVector.y);

        // Check for jump input and apply jump animation
        if (jumpAction.triggered && groundedPlayer)
        {
            playerVelocity.y += Mathf.Sqrt(PlayerStats.jumpHeight * -3.0f * gravityValue);
            animator.CrossFade(jumpAnimation, animationPlayTransition);
        }

        // Check for time control input and initiate slow motion
        if (timeAction.triggered)
        {
            DoSlowmotion();
        }

        // Apply gravity and move the player
        playerVelocity.y += gravityValue * Time.deltaTime;
        controller.Move(playerVelocity * Time.deltaTime);

        // Rotate player towards camera direction
        float targetAngle = cameraTransform.eulerAngles.y;
        Quaternion targetRotation = Quaternion.Euler(0, targetAngle, 0);
        transform.rotation = Quaternion.Lerp(transform.rotation, targetRotation, rotationSpeed * Time.deltaTime);
    }

    private void DoSlowmotion()
    {
        // Initiate slow motion effect
        Time.timeScale = slowdownFactor;
        Time.fixedDeltaTime = Time.timeScale * .02f;
    }
}
