# Chapter 8 Exercises — Java (Classes, Static Members, Enums)

Solutions to the Chapter 8 end-of-chapter exercises (8.4–8.19), each in
its own folder with the class(es) plus a runnable test/driver class.

| Folder | Exercise | Topic |
|---|---|---|
| `8.4-Rectangle` | 8.4 | Class with validated set/get methods |
| `8.5-Time2-SecondsRep` | 8.5 | Changing a class's internal data representation |
| `8.6-SavingsAccount` | 8.6 | Static variables and static methods |
| `8.7-Time2-Tick` | 8.7 | Enhancing a class (tick, incrementMinute, incrementHour) |
| `8.8-Date-NextDay` | 8.8 | Full validation + nextDay rollover logic |
| `8.9-DrawPanel-StaticImports` | 8.9 | Static imports of individual `Math` members |
| `8.10-TrafficLight` | 8.10 | Enum type with a constructor and instance data |
| `8.11-Complex` | 8.11 | Operator-style methods for a value class |
| `8.12-DateAndTime` | 8.12 | Composition of two classes (Date + Time2) |
| `8.13-IntegerSet` | 8.13 | Set operations backed by a boolean array |
| `8.14-Date-MultiFormat` | 8.14 | Overloaded constructors, multiple output formats |
| `8.15-Rational` | 8.15 | Fractions in reduced form, static arithmetic methods |
| `8.16-HugeInteger` | 8.16 | Arbitrary-precision integers via a digit array |
| `8.17-TicTacToe` | 8.17 | Enum-based board game, two human players |
| `8.18-Account-BigDecimal` | 8.18 | Using `BigDecimal` for money instead of `double` |
| `8.19-Emergency-Design` | 8.19 | Design-only exercise (no code) — class attribute list |

## Running any exercise

Each folder is self-contained. From inside a folder:

```bash
javac *.java
java <NameOfTestClass>
```

For example:

```bash
cd 8.4-Rectangle
javac *.java
java RectangleTest
```

`8.9-DrawPanel-StaticImports` opens a Swing window (`TestDraw`) rather
than printing to the console. `8.17-TicTacToe`'s `TicTacToeTest` runs a
scripted, non-interactive demo game; call `TicTacToe.play()` from a
`main` method instead for an interactive two-player console game.

## Requirements

- JDK 11 or later (uses `var`-free, standard modern Java; BigDecimal,
  enums, and Swing are all part of the standard library).
