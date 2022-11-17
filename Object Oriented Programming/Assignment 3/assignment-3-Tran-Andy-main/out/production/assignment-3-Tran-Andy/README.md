# CSE1325 Assignment 3

Assignment 3 includes inheritance, interfaces and ArrayLists

## (20%) Part 1

Create a UML diagram given the following specifications.
`Player`s and `Monster`s inherit from an `abstract Creature class`.

### `public abstract class Creature`

This class represents any creature in the game, whether it is player-controlled or not.

**Instance Fields**

The following instance fields are **required**.
You should use getters and setters to access them.

- `name : String`
- `hp : int`
- `ac : int`
- `str : int`
- `dex : int`
- `con : int`

**Methods**

- `public void takeDamage(int)`

This method lowers the HP of the `Creature` by a value given by the `int` parameter.
The HP must not be allowed to go below 0.
If the damage would reduce the `Creature`'s HP below 0, set it to 0 instead.

- `public abstract void attack(Creature)`

This method will be defined for all subclasses of `Creature`.
See the entries for this subclasses for more information.

- Override `Object.equals(Object)`

This is necessary for determining if the custom objects are equal or not.
You can use the following pattern.

```
public boolean equals(Object o) {
    return o != null
        && getClass() == o.getClass()
        && name.equals(((Creature) o).getName());
}
```

### `public class Player extends Creature`

This class represents a player-controlled creature.

**Instance Fields**

Use accessors and mutators to access the following instance fields.
You may re-use your implementation of the `Weapon class`.

- `weapon : Weapon`

**Methods**

- `private int rollHit()`

Rolls to determine the attack to-hit value.
An attack successfully hits if this value is greater than or equal to the target's AC.
For `Player`s, the total calculation is

```
d20 + DEX modifier + Weapon bonus
```

First roll a d20, then add the DEX modifier and bonus value from the equipped `Weapon`.
As a reminder, the stat modifier is calculated by subtracting 5 from the stat value.
An individual stat cannot exceed 10.

- `public void attack(Creature)`

This is the implementation of the abstract method declared in the `super` class.
For the `Player`, it should first call `rollHit()` to determine if the attack hits.
On a successful hit, roll damage and call `takeDamage(int)` on the target.

For `Player`s, damage is calculated by rolling their `Weapon` damage dice and adding their STR modifier.
The damage cannot be negative.

### `public class Monster extends Creature`

This class represents any non-player character (NPC).

**Instance Fields**

- `Challenge Rating (CR) : int` - A numerical representation of the difficulty of a monster.

**Methods**

- `private int rollHit()`

Rolls to determine the attack to-hit value.
An attack successfully hits if this value is greater than or equal to the target's AC.
For `Monster`s, the total calculation is

```
d20 + DEX modifier
```

First roll a d20 and then add the DEX modifier.
As a reminder, the stat modifier is calculated by subtracting 5 from the stat value and any stat cannot exceed 10.

- `public void attack(Creature)`

This is the implementation of the abstract method declared in the `super` class.
For the `Monster`, it should first call `rollHit()` to determine if the attack hits.
On a successful hit, roll damage and call `takeDamage(int)` on the target.

For `Monster`s, damage is calculated by rolling a d6 damage dice and adding their STR modifier.
The damage cannot be less than 1.

## (50%) Part 2

Using the descriptions from part 1, implement the `Creature`, `Player`, and `Monster` classes.
You do not need to write a program (with `main`) to receive credit for this part.

### Sorting `Creature`s

Additionally, implement the `Comparable` interface in `Creature`.
Override the `compareTo` method to sort each `Creature` by their HP.

## (30%) Part 3

In the last part, you will create a program that will test the classes and methods created in part 2.

Create 2 `Player`s and 3 `Monster`s.
You are free to choose the name and stats for them as well as the `Weapon` for the `Player`s.
Feel free to reference the weapon list from the project.
You do not need to perform any file operations for this assignment.
You can also reference the following list of monsters when creating them.
In `main`, add all of the `Creature`s to an `ArrayList` of `Creature`.

| Name          | HP | AC | STR | DEX | CON |
|---------------|----|----|-----|-----|-----|
| Air Elemental | 90 | 15 | 7   | 10  | 7   |
| Bandit        | 11 | 12 | 5   | 6   | 6   |
| Centaur       | 45 | 12 | 9   | 7   | 7   |
| Ghost         | 45 | 11 | 3   | 6   | 5   |

Create a method `public void testCombat(ArrayList<>)` which iterates through the list and attempts to attack each `Creature`.
Before looping through the list of `Creature`s, sort them so that they are sorted by HP.
Randomly select one of the `Creature`s and have them make an attack against each of the remaining sorted `Creature`s.
The program should print the results of any rolls and damage taken.

**Example Output**

```
Vax'ildan attacks Bandit with Dagger (17 to hit)...HITS!
Bandit takes 3 points of damage.
Ghost attacks Jester (14 to hit)...MISSES!
```
