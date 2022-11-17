# CSE 1325 Assignment 5

Create a GUI program that allows users to create, view, and edit characters.
The program should be implemented using the Swing API and the MVC design pattern.

## Main Menu

The main screen of the app will show the avatar and name of the character currently
loaded along with 4 buttons for "New Character", "Edit Character", "Save Character",
and "Load Character".
If no character is currently loaded within the app, do not show the character avatar
and name on the main screen.

The app should also show a menu bar at the top with one submenu for "File".
This submenu should have 4 menu items for "New Character", "Load Character", "Save Character",
and "Exit".

## Editing View

Selecting "New Character" or "Edit Character" should switch on the main view
in the frame with an editing view.
This panel will contain all components necessary for creating a character.
This includes, but is not limited to, the name, avatar, stats, and weapon.

The character can have up to 15 stat points to distributed between STR, DEX,
and CON. Your app should not allow the user to distribute more points than
available.

The weapon selection components can be implemented however you see fit
as long as the user is only able to select a single weapon for the character.

At the bottom of this panel should be two buttons for "Confirm" and "Cancel".
Pressing "Confirm" will update the player object currently in memory and switch
back to the main screen.
Pressing cancel will return the user to the main menu without updating any information.
If there is currently no character in memory, the "Edit Character" button should be disabled
on the main screen.

## Saving a Character

If a character is loaded in memory but has no associated file, pressing "Save Character"
should use `JFileChooser` so the user can create a CSV file to
save the character information.
If the character already has a file associated with it, pressing "Save Character" should
overwrite that file with the updated information.

The character data will now include a file name reflecting the avatar image file.
This will also be written to CSV. The order of attributes does not matter as long
as you use the same order for both saving and loading.

If there is no character currently in memory, the "Save Character" button should be disabled
in both the menu bar and main screen.

## Loading a Character

Loading a character should also use `FileChooser` so the user can select
a CSV file with character information. Once the file is selected, attempt to load the character
and catch any associated exceptions. If the character cannot be loaded for any reason,
warn the user with a dialog alert window.

If the character is successfully loaded, update the avatar and name on the main screen.
Additionally, selecting "Edit Character" should populate the fields with the character
data in memory.

## Exiting the Program

If the user selects "Exit" and there is an unsaved character in memory, the app should
show a dialog box to see if the user would like to save the character. Selecting "Yes"
will show the user a `JFileChooser` so that the user can create the file.
If the user selects "No" or there is no unsaved character, the window should be disposed
so that the application can exit.

## Using MVC

This assignment should be implemented using MVC. The view components should not perform any data
operations such as saving or loading. The data to be displayed in the view should be provided by
a controller. The controller is also responsible for handling any interactions from the view components
that requires data to be modified or updated. The controller will also change out views as necessary
when navigating between the main menu and the editing panel.

## UML Diagrams

As part of this assignment, you should create a UML diagram that shows the interaction between your
model class, controller, and view components.