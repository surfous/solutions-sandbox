# Test Utterances to try in the service simulator

## LaunchIntent (4a. Alexa Start)
* Alexa, ask smart things
* Alexa, launch smart things

## LockSupportedIntent (no story)
* Alexa, ask smart things which locks it knows about
* Alexa, ask smart things what locks do you know

## LockLockIntent (4b. Single Door Lock and 4c. Multiple Door Lock)
* Alexa, ask smart things to lock the entry lock
* Alexa, ask Smart things to lock all locks

### special cases
* Door lock issue (4d.)
 * Alexa, ask Smart things to lock __<physical lock name>__ (one lock configured, it is jammed, called by name)
 * Alexa, ask smart things to lock all locks (_Setup: cause jam one lock. Set other locks to unlocked_)
 * Alexa, ask smart things to lock all locks (_Setup: only one lock configured and jammed_)
 * Alexa, ask smart things to lock all locks (_Setup: multiple jammed, but not all_)
 * Alexa, ask smart things to lock all locks (_Setup: multiple locks, all jammed_)

* With only one lock configured (4bi.)
 * Alexa, ask Smart things to lock the mumblefoo lock

## LockUnlockIntent (4e. Unlock Fail)
* Alexa, ask smart things to unlock the entry door

## LockStatusIntent (4f. Lock Status)
for all locks
* ALexa, ask smart things are my doors locked
* Alexa, tell smart things to check my locks
* Alexa, ask smart things about the status of my locks

## LockQueryIntent (4f. Lock Status)
for a single, named lock
* Alexa, ask smart things if my front lock is locked (lock is locked)
* Alexa, ask smart things if my front lock is locked (lock is unlocked)
* Alexa, ask smart things if my front lock is unlocked (lock is unlocked)
* Alexa, ask smart things if my front lock is unlocked (lock is locked)
* Alexa, ask smart things if my front lock is locked (lock is jammed)
* Alexa, ask smart things if my front lock is unlocked (lock is jammed)

## DoorStatusIntent (4g. Door Status)
for all locks
* Alexa, ask smart things are my doors closed
* Alexa, ask smart things are my doors open
* Alexa, tell smart things to check my doors
* Alexa, ask smart things about the status of my doors

## DoorQueryIntent (4g. Door Status)
for a single, named door
* Alexa, ask smart things if my front door is open (door is open)
* Alexa, ask smart things if my front door is open (door is closed)
* Alexa, ask smart things if my front door is closed (door is open)
* Alexa, ask smart things if my front door is closed (door is closed)


## BatteryStatusIntent (4h. Battery Status)
*  Alexa ask SmartThings for the battery status of the entry lock
*  Alexa ask SmartThings for the battery status of the entry door


## HelpIntent (4i. Help intent)
* Alexa, ask smart things for help
* Alexa, tell smart things to help me
