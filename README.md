## About the Project

**Our Game** is an atmospheric 2D platformer built in Java. You play as a pirate navigating dark cave corridors, battling aggressive crabs, and searching for the exit. We focused on retro pixel art, responsive controls, and a flexible codebase to make it easy to add new levels, enemies, and features in the future.

---

## Key Features

* **Three unique pixel-art maps** with different terrains and traps
* **Combat system**: crabs cycle through multiple states (Idle, Running, Attack, Hit, Dead)
* **Intuitive menu** with volume and control settings
* **Clean architecture** following OOP principles and proven design patterns

---

## Project Structure

```
src/
├─ main/             ← Entry point (class Geme)
├─ inputs/           ← Keyboard and mouse handling
├─ gamestates/       ← Game state managers (Menu, Playing, Options)
├─ entities/         ← Game entities (Player, Crabby, EnemyManager)
├─ levels/           ← Level loading and management (LevelManager)
├─ objects/          ← Collectible items (coins, power-ups)
├─ ui/               ← Overlays and UI buttons
└─ utilz/            ← Utilities (LoadSave, GameSettings, constants)

res/                  ← Sprites, sounds, and level files
```

---

## Setup & Running

1. Make sure **Java 11+ (JDK)** is installed.
2. Clone the repository:

   ```bash
   git clone https://github.com/yourname/our-game.git
   cd our-game
   ```
3. Compile and run from the command line:

   ```bash
   javac -d out -sourcepath src src/main/Geme.java
   java -cp out main.Geme
   ```

   Or open the project in **IntelliJ IDEA** / **Eclipse** and run the `main.Geme` class.

---

## Controls

* **Left / Right Arrows** — move the hero
* **Spacebar** — jump
* **Esc** — pause / return to menu

---

## Design Patterns Used

* **Singleton** (`GameSettings`)

  * Centralizes configuration (volume, language) in a single global instance accessible from anywhere in the code.
* **Manager/Controller**

  * `EnemyManager`, `LevelManager`, and `ObjectManager` separate entity-management logic from rendering and coordinate interactions between subsystems.

---

## Team Roles

* **Aisabek Akzhol** — movement mechanics & hero jump physics
* **Faizulla Dinmukhammed** — enemy behavior & AI (`EnemyManager`)
* **Iken Ansar** — UI design & in-game visualization
* **Ilimbaev Islam** — pixel art & overall visual style

---

## Future Plans

* Add new enemy types and boss fights
* Build a level-editor tool
* Implement a character progression system
* Optimize rendering and support multiple resolutions

---

