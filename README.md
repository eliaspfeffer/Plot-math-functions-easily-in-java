# Function Plotter Template

A simple Java template for plotting mathematical functions using [JFreeChart](https://www.jfree.org/jfreechart/).

## Overview

This template allows you to plot any mathematical function within a specified range. You can plot multiple functions, and they will appear side by side in the same window.

## Features

- **Plot Any Function:** Easily plot any function of the form `y = f(x)`.
- **Multiple Plots:** Display multiple plots in a single window.
- **Customizable Range and Resolution:** Adjust the `xmin`, `xmax`, and `xIncrement` to control the plotting range and detail.
- **Easy to Use:** Simply define your function and call `plotFunction`.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK):** Ensure you have JDK 8 or higher installed.
- **JFreeChart Library:** You need to include JFreeChart in your project.

### Adding JFreeChart to Your Project

#### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.jfree</groupId>
    <artifactId>jfreechart</artifactId>
    <version>1.5.3</version>
</dependency>
