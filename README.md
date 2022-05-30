# Wordle Solver

A simple program to solve 5-letter Wordle.

## Building

Requires Java and Leinigen installed.

lein uberjar

## Usage

    $ java -jar target/uberjar/wordle-solver-0.1.0-standalone.jar

The program will prompt for the 5-character pattern:

* a letter means a letter in that position (green box)
* an asterisk means any letter in that position
* an exclamation mark followed by a letter means the letter is not in that position but it's in the word (yellow box)
* letters within square brackets mean those letters are not in the word

## Examples

a!l*l!t[ivedu]

* an a in the first position
* an l but not in the second position
* an unknown (any) letter in the third position
* an l in the fourth position
* a t but not in the fifth position
* the letters i, v, e, d, u are not in the word

### Bugs

Issues when there's no match in the word or in the list of excluded letters.

### TODO

* UI or Chrome plugin to simplify UX

## License

Copyright © 2022 João Paulo Leonidas Fernandes Dias da Silva

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
