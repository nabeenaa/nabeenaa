
/*
   BulletController.cs manages the behavior of bullets fired in a Unity game. 
   Each bullet is responsible for moving towards a specified target, triggering destruction 
   after a certain time or upon reaching the target. Upon collision with surfaces or objects, 
   it creates a decal, triggers explosion and smoke particle effects, and self-destructs.
*/
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BulletController : MonoBehaviour
{
    // Reference to the bullet decal prefab
    [SerializeField]
    private GameObject bulletDecal;

    // Particle systems for explosion and smoke effects
    public ParticleSystem explosionParticles;
    public ParticleSystem smokeParticles;

    // Speed and time to destroy for the bullet
    private float speed = 50f;
    private float timeToDestroy = 2f;

    // Properties for the target and hit status of the bullet
    public Vector3 target { get; set; }
    public bool hit { get; set; }

    // Start is called before the first frame update
    private void OnEnable()
    {
        // Destroy the bullet game object after a certain time
        Destroy(gameObject, timeToDestroy);
    }

    // Update is called once per frame
    void Update()
    {
        // Move the bullet towards the target position
        transform.position = Vector3.MoveTowards(transform.position, target, speed * Time.deltaTime);

        // Destroy the bullet if it hasn't hit the target and is very close to it
        if (!hit && Vector3.Distance(transform.position, target) < 0.01f)
        {
            Destroy(gameObject);
        }
    }

    // Handle collision events
    private void OnCollisionEnter(Collision other)
    {
        // Get the contact point of the collision
        ContactPoint contact = other.GetContact(0);

        // Instantiate a bullet decal at the contact point
        GameObject.Instantiate(bulletDecal, contact.point + contact.normal * 0.0001f, Quaternion.LookRotation(contact.normal));

        // Destroy the bullet game object
        Destroy(gameObject);

        // Instantiate explosion particles and smoke particles at the bullet's position
        Instantiate(explosionParticles, transform.position, Quaternion.identity);
        Instantiate(smokeParticles, transform.position, Quaternion.identity);
    }
}
