# Test Utterances to try in the service simulator

## LaunchIntent
* Alexa, ask smart things
* Alexa, launch smart things

## HelpIntent
* Alexa, ask smart things for help
* Alexa, tell smart things to help me

## LockSupportedIntent
* Alexa, ask smart things which locks it knows about
* Alexa, ask smart things what doors do you know
* Alexa, ask smart things what locks do you know

## LockLockIntent
* Alexa, ask smart things to lock the entry door
* Alexa, ask Smart things to lock all doors

### special cases
* cause jam in physical lock
 * Alexa, ask Smart things to lock __<physical lock name>__


* cause jam in physical lock. Set other locks to unlocked
 * Alexa, ask Smart things to lock all doors

## LockUnlockIntent
* Alexa, ask smart things to unlock the entry door

## LockStatusIntent
for all locks
* ALexa, ask smart things are my doors locked
* Alexa, tell smart things to check my doors
* Alexa, ask smart things about the status of my doors

## LockQueryIntent
for a single, named lock
* Alexa, ask smartthings if my front door is locked
* Alexa, ask smartthings if my front door is unlocked
