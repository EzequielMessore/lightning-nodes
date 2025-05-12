# Lightning Nodes
---

## Build tools & versions used

- **Kotlin**: 2.1.0
- **Gradle**: 8.9.2
- **Jetpack Compose**: Material 3
- **Android Studio**: Meerkat | 2024.3.1 Patch 2

### Main libraries used in the project

| Library                | Purpose                                      |
|------------------------|----------------------------------------------|
| **Jetpack Compose**    | Declarative UI building                     |
| **Ktor**               | Network calls and API handling              |
| **Koin**               | Dependency injection                        |
| **Kotlinx Serialization** | JSON serialization/deserialization       |
| **JUnit** and **MockK**| Unit and integration testing                |
| **Turbine**            | Testing asynchronous flows (coroutines)     |
| **Detekt**             | Static code analysis                        |
---

## Steps to run the app
1. Clone the repository
    ```bash
      git clone https://github.com/EzequielMessore/lightning-nodes.git
    ```
2. Open the project in Android Studio.
3. Synchronize the Gradle files.
4. Run the app on an emulator or physical device.

---

## What areas of the app did you focus on?

- **Clean Architecture**: Designed the project with a robust and scalable Clean Architecture, leveraging the MVI (Model-View-Intent) pattern to ensure unidirectional data flow and maintainability.
- **UI Development**: Developed a dynamic and responsive `NodesScreen` using Jetpack Compose, focusing on modern UI principles and user experience.
- **Data Mapping**: Engineered a comprehensive data mapping layer to transform remote data models (`NodeRemote`) into domain entities (`Node`), ensuring data consistency and separation of concerns.
- **Best Practices**: Applied advanced Kotlin features, dependency injection with Koin, and static code analysis with Detekt to maintain high code quality and readability.

---

## What was the reason for your focus? What problems were you trying to solve?

The focus was to create a clean, sustainable, and testable architecture, ensuring the interface was responsive and functional.

---

## How long did you spend on this project?

Approximately **10 hours**.

---

## Did you make any trade-offs for this project? What would you have done differently with more time?

Yes, I prioritized core features and testing over advanced features like pagination or additional UI enhancements. With more time, I would have:
- Implemented infinite scroll pagination and added caching using a Use Case. This way, even with the overhead of making the request, we would reduce the load on the View by avoiding the need to load all items at once.
- Enhanced UI testing by incorporating Espresso for interaction tests or Paparazzi for screenshot-based testing to ensure visual consistency across different states and devices.
---

## What do you think is the weakest part of your project?

- The weakest part is the lack of plugin creation for future modules and feature-based modularization. However, since we currently have only one module, I opted for a simpler approach given the project's complexity.
---

## Is there any other information you’d like us to know?

- This project demonstrates my ability to work with modern Android development tools and practices, focusing on clean architecture, Jetpack Compose, and testing. It was designed to be easily extensible for future improvements.
- Additionally, the project highlights the use of MVI for predictable state management, ensuring a clear separation of concerns and unidirectional data flow. The integration of tools like Detekt and Koin reinforces the commitment to maintainable and scalable code. Future enhancements, such as feature-based modularization and plugin support, are already considered to facilitate the addition of new functionalities with minimal impact on the existing codebase.