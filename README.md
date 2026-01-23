# java-game-combat-system

A small **turn-based combat prototype** written in Java.  
This project focuses on **character state**, **action selection**, and **system structure** (not just simple input-output exercises).

## What this project does

- Console-based **turn-by-turn battle**
- Two characters:
  - `YOU` (player)
  - `Knight` (NPC enemy)
- Both characters have basic state variables:
  - **HP** (health)
  - **MP** (energy for combos)
  - **Power** (builds up during combat)
- Player can type actions to attack (including **combo input**)
- NPC actions are **randomly generated** each turn
- Includes simple battle text / dialogue lines based on HP stage

## How combat works (based on the current code)

### Player actions (input-based)

In your turn, the game will ask:
```
Enter your action:
```

The system checks your input using keyword matching (e.g. `contains("punch")`), so you can type:

- Single actions: `punch`, `kick`, `slash`
- Combo-style input in one line (multiple keywords in one string)

MP will be consumed based on the action / combo you typed.  
If MP is not enough, the system prints a message and asks you to input again.

### NPC actions (random)

The Knight automatically generates 1–3 actions each turn using `Random`,  
and picks from its action list such as:

- `heavy slash`, `bash`, `war cry`
- `iron spike thrust`, `trial blade`, `crushing arc`

### Power & special moves

- When **YOU** reach enough `Power`, the system may ask whether to trigger a powerful skill:
  - `Shock Pulse`
- When the **Knight** reaches enough `Power`, it can trigger:
  - `Rage Charge`

### End conditions

- If your HP drops to 0 → you lose (replay option appears)
- If Knight HP drops to 0 → the game enters a dialogue / ending sequence

## Project structure

- **FightingGame.java**  
  Main entry point. Creates both characters, assigns action lists and dialogue lines, and starts the game loop.

- **Player.java**  
  Character "card" (encapsulated state container): HP / MP / Power / TS, action arrays, and dialogue arrays.

- **FightingSystem.java**  
  Turn loop controller: handles player turn and NPC turn, including input handling and random action generation.

- **Check.java**  
  Core rule system: validates actions, checks MP/HP, applies damage and state changes, and triggers dialogue or special moves.

## How to run

### Eclipse

1. Put all `.java` files under the same package:
   - `package Hey;`
2. Run:
   - `FightingGame.java`

## Notes

- This is a prototype / V1 system built for practicing system design.
- It is intentionally focused on state + turn logic + structure, not UI.
- Balance values are adjustable and can be tuned as the system expands.
