Read me file for:

         _________ _        _          _______  _______   _________          _______    _______  _        _______ _________ _______  _       _________ _______  _
|\     /|\__   __/( \      ( \        (  ___  )(  ____ \  \__   __/|\     /|(  ____ \  (  ___  )( (    /|(  ____ \\__   __/(  ____ \( (    /|\__   __/(  ____ \( )
| )   ( |   ) (   | (      | (        | (   ) || (    \/     ) (   | )   ( || (    \/  | (   ) ||  \  ( || (    \/   ) (   | (    \/|  \  ( |   ) (   | (    \/| |
| | _ | |   | |   | |      | |        | |   | || (__         | |   | (___) || (__      | (___) ||   \ | || |         | |   | (__    |   \ | |   | |   | (_____ | |
| |( )| |   | |   | |      | |        | |   | ||  __)        | |   |  ___  ||  __)     |  ___  || (\ \) || |         | |   |  __)   | (\ \) |   | |   (_____  )| |
| || || |   | |   | |      | |        | |   | || (           | |   | (   ) || (        | (   ) || | \   || |         | |   | (      | | \   |   | |         ) |(_)
| () () |___) (___| (____/\| (____/\  | (___) || )           | |   | )   ( || (____/\  | )   ( || )  \  || (____/\___) (___| (____/\| )  \  |   | |   /\____) | _
(_______)\_______/(_______/(_______/  (_______)|/            )_(   |/     \|(_______/  |/     \||/    )_)(_______/\_______/(_______/|/    )_)   )_(   \_______)(_)

->Link To Github: https://github.com/MeekTheAbominable-Clemson/Will-of-the-Ancients

->Compile And Run:
   -Compile: make
   -Run: make run
   -Clean: make clean

->Features:
   -Fully Navigable Map
   -Interactive items and enemies
      *items can be inspected
      *enemies can be fought
   -Persistent state
      *When enemy health drops to
       zero they are removed from
       map
   -Outputs a log file of game events
      *when program starts
      *when an area is added to map
      *when an exit is added to area
      *when an object is added to area
      *when an enemy is added to area
      *when gameplay starts
      *when player moves to new area
      *when player attacks battles are logged
      *when player attacks battles are logged

->Future Updates:
   -Extend persistent state
      *adding objects to inventory
      *dropping objects from inventory
      *destroying objects
   -Extend logging
      *log all errors
      *log all game events
      *create better log formatting
   -Add Save and Load

      *For list of exits: exits"
      *For list of enemies: enemies"
      *For list of objects: objects"
      *To move to a new area: move <exit>"
      *To attack enemy: attack <enemy_name>"
      *To exit game: exit");

->Controls:
   -Over World:
      * "exits" - prints current room exits
      * "enemies" - prints current room enemies
      * "objects" - prints current room objects
      * "inspect" - inspects specified object in room
      * "move" - travels to specified exit in same room
      * "attack" - attacks specified enemy in same room
      * "leave" - exits game
      * "help" - prints help screen with commands and command format
         -> Help Command Output
            *For list of exits: exits
            *For list of enemies: enemies
            *For list of objects: objects
            *To inspect an object: inspect <object_name>
            *To move to a new area: move <exit>
            *To attack enemy: attack <enemy_name>
            *To exit game: leave
   -Battle:
      * 'a' - to attack enemy
      * 'r' - to run from battle
