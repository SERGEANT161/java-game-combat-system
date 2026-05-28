# Java Game Combat System

This is a Java console-based turn-based fighting game project.

The project focuses on object-oriented programming, character combat logic, combo attacks, boss phase transition, and a rule-based enemy decision system.

## Features

- Turn-based combat between the player and a Knight enemy
- Object-oriented structure with Character, Player, and Knight classes
- Private character stats with getter and setter methods
- Text-based player input
- Combo attack system
- Two-phase boss battle
- Story dialogue between phase 1 and phase 2
- Debug logging system for testing
- Rule-based weighted enemy move evaluator

## Main Advanced Feature

The main advanced feature is the MoveEvaluator class.

Instead of making the Knight choose moves randomly, the system evaluates the current battle state and gives different moves different weights. The decision is based on factors such as:

- Player HP
- Knight HP
- Knight MP
- Current battle phase
- Available single attacks and combo attacks

The final move is selected through weighted probability. This makes the enemy behavior less predictable than pure random selection and works as a prototype for future AI integration.

## Project Structure

- FightingGame.java  
  Main entry point of the program.

- Character.java  
  Parent class for shared character stats and basic methods.

- Player.java  
  Player character class with player skills and combo attacks.

- Knight.java  
  Enemy class with Knight skills, dialogue, and phase transformation.

- FightingSystem.java  
  Controls player turns and Knight turns.

- Check.java  
  Handles action recognition, HP checks, MP checks, and battle result checks.

- MoveEvaluator.java  
  Handles the Knight's rule-based weighted move decision.

- DebugLog.java  
  Records useful debug information during testing.

- Plot.java  
  Handles story dialogue and phase transition text.

## How to Run

Run the program from:

java FightingGame.java 

All Java files should be placed under the same package:

java package fightingGame21; 

## Notes

This project is a console-based prototype. It does not focus on graphics or UI. The main goal is to practice Java class design, inheritance, encapsulation, combat logic, input parsing, and basic AI-style decision making.
