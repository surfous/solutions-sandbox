# SmartDoor APIs

## Intents

DialogSmartDoorIntent
> Skill was invoked with no information or partial information.
We need to ask for what's missing

> - _Alexa, SmartDoor_


OneshotLockIntent
> User has asked to lock a specific door or all doors

> - _Alexa, tell SmartDoor lock the front door_
> - _Alexa, tell SmartDoor to lock all doors_

OneshotUnlockIntent
> User has asked to unlock a specific door

> - _Alexa, tell SmartDoor to unlock the front door_

- Polite message informing user that unlocking is not supported
- Unlocking all doors with a single command doesn't seem wise at any time

OneshotStatusIntent
SupportedDoorsIntent
AMAZON.YesIntent
AMAZON.NoIntent
AMAZON.HelpIntent
AMAZON.StopIntent
AMAZON.CancelIntent

## SmartApp
