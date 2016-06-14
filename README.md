# Alexa SmartDoor Skill for SmartThings

### Notes
* This skill cannot unlock a connected lock at this time for security reasons. Mainly, Alexa can't know who's speaking at the time. The skill will tell you as much if you ask.
* "Lock" and "door" currently both reference a connected lock. We may modify this in the future, allowing you to specify a contact sensor that monitors the open/close state of the door itself.
 * For example, we could allow you to choose not to lock a door that isn't closed. For a deadbolt, this doesn't make sense at worst, and makes a bad doorstop at best.
 * No, this skill doesn't actually operate the door itself.
