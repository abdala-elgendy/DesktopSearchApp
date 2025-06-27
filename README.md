# DesktopSearchApp

This project is inspired by the book **"Java Concurrency in Practice"** and serves as a practical implementation of the concepts discussed within, with a primary focus on the **Producer-Consumer Pattern**.

## Overview

**DesktopSearchApp** is a desktop application designed to search files and their contents on your computer efficiently. The core logic leverages advanced concurrency techniques, especially the Producer-Consumer pattern, to maximize performance, responsiveness, and scalability, as taught in "Java Concurrency in Practice".

## Concurrency Pattern Used

- **Producer-Consumer Pattern:**  
  The application is structured around the producer-consumer pattern. Producer threads are responsible for discovering files to be searched, while consumer threads perform the search operations on those files. This separation allows for efficient parallel processing and optimal utilization of system resources.

## Features

- Fast file and content searching using concurrent programming
- Responsive UI that remains usable even during intensive searches
- Modular and extensible codebase
- Designed as a learning project for Java concurrency patterns, especially producer-consumer


## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/abdala-elgendy/DesktopSearchApp.git
   ```
2. Build the project using your preferred Java IDE or with Maven/Gradle (if applicable).
3. Run the main application class:
   ```bash
   java -jar target/DesktopSearchApp.jar
   ```
   *(Adjust the command according to your build setup.)*

## Learning Goals

- Apply concepts from "Java Concurrency in Practice" in a real-world project
- Gain hands-on experience with the producer-consumer pattern, thread safety, task execution, and synchronization
- Understand challenges and solutions related to concurrent desktop applications

## License
MIT License.

## Acknowledgments

- **Brian Goetz et al.** for authoring "Java Concurrency in Practice"
- The Java community for resources and support
