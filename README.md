# Zip Code Ranges

* Java Challenge*

## Background

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes.

For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

## Problem

Given a collection of 5 digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the **minimum** number of ranges required to represent **the same restrictions as the input**.

## Test

For the input = [94133,94133] [94200,94299] [94600,94699], the output should be [94133,94133] [94200,94299] [94600,94699].

## Installation

Download and install the latest **Java SE** (Java Platform, Standard Edition) [here](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

Java SE is the Java Development Kit (JDK) to develop and run Java applications and programs.

## Instructions

1. Fork and clone this repository to your local computer using `git clone https://github.com/Your-Username/Zip-Code-Ranges.git`.
2. Move into the root directory: `cd Zip-Code-Ranges`.
3. Compile `Range.java`: `javac -d . Range.java`.
4. Move `Range.java` into the `range` directory: `mv Range.java range`.
5. Compile `ZipCodeRanges.java`: `javac ZipCodeRanges.java`.
6. Execute `ZipCodeRanges`: `java ZipCodeRanges`.
7. If you're using **Visual Studio Code**, you can find and install the `Java Extension Pack` extension within VSC itself using the Extensions panel (⌘⇧X or the square icon in the left sidebar).
8. Open an integrated terminal using the `` ⌃` `` keyboard shortcut or choose `Integrated Terminal` under the View menu at the top of the screen.
9. Repeat the third to sixth point in the prompt.




## Documentation

The [Java™ Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/index.html) contains the complete listing for all packages, interfaces, classes, fields, and methods supplied by the Java SE platform. Load the page in your browser and bookmark it. As a programmer, it will become your single most important piece of reference documentation.
