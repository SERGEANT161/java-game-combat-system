# Java Game Combat System

A Java console-based RPG project featuring turn-based combat, LLM-driven NPC interactions, dynamic character relationships, and an evolving game environment.

The project focuses on object-oriented programming, character simulation, game logic, and the integration of local large language models into traditional game systems.

## Features

- Turn-based combat with basic attacks, combos, and powerful skills.
- Boss phase transitions and branching storylines.
- Weighted enemy combat decisions based on battle conditions.
- AI-generated NPC dialogue based on character profiles and current game states.
- Independent AI evaluation of NPC relationship and emotional changes.
- Dynamic NPC attributes: trust, respect, attachment, loyalty, fatigue, and mood.
- NPC daily activities influenced by fatigue and mood.
- Game time progression and campsite interactions.
- Developer mode for direct access to specific game stages.
- Debug logging for combat logic and system behavior.

## AI Integration

The project uses a local LLM through LM Studio's OpenAI-compatible API.

NPC dialogue generation and attribute evaluation are handled through separate API requests. The model generates responses and evaluates player interactions, while Java controls game logic, attribute modifications, and state management.

Structured JSON outputs are processed using Gson.

## Requirements

- Java: JDK 21 (Amazon Corretto)
- Gson: 2.14.0
- LM Studio: Latest version
- LLM: Gemma 3 12B IT QAT (4-bit)
- Model ID: `gemma-3-12b-it-qat`

## Setup

1. Download or clone this repository.
2. Import the Java source files into your IDE.
3. Download Gson 2.14.0 and add its JAR file to the project's build path.
4. Install [LM Studio](https://lmstudio.ai/) and load the required model.
5. Start the local API server on port `1234`.
6. Run `FightingGame.java`.

The default API endpoint is:

`http://localhost:1234/v1/chat/completions`

## Planned Features

- Configurable NPC memory system.
- Adjustable memory capacity and memory-based interactions.
- LLM-driven combat decision mode.
- Further expansion of NPC behavior and game environments.

## Development Status

This is an ongoing personal development project. New systems and features are gradually integrated into the existing game framework. does not focus on graphics or UI. The main goal is to practice Java class design, inheritance, encapsulation, combat logic, input parsing, and basic AI-style decision making.
