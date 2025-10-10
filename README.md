# AndroidKotlinTestApp

An Android application built in **Kotlin**, structured following **Clean Architecture** + **MVVM**, and utilizing modern Android libraries.  
This project contains modules (`app`, `data`, `domain`, `presentation`) and demonstrates API integration, caching, dependency injection, UI with Jetpack Compose, and more.

---

## 📖 Table of Contents

- [Overview](#overview)  
- [Features](#features)  
- [Architecture & Modules](#architecture--modules)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [Setup & Installation](#setup--installation)  
- [Configuration](#configuration)  
- [Build & Run](#build--run)  
- [Testing](#testing)  

---

## 🧱 Overview

**AndroidKotlinTestApp** is a structured Android app showcasing how to maintain a scalable, modular architecture using Clean Architecture and MVVM.  
It includes separation into `data`, `domain`, and `presentation` modules, uses Retrofit, Hilt, Coil, coroutines, and supports unit tests and UI tests.

---

## ✨ Features

- Clean modular architecture (multi-module: app, data, domain, presentation)  
- API calls via Retrofit + Coroutines  
- Local caching / persistence with Room  
- Dependency injection via Hilt  
- UI built with Jetpack Compose and state management via ViewModel  
- Image loading via Coil  
- Animation, paging / load more  
- Unit tests and UI / integration tests  

---

## 🏗 Architecture & Modules

This app follows **Clean Architecture** and is divided into modules:

| Module | Responsibility |
|--------|----------------|
| `domain` | Defines business logic, use cases, and repository interfaces |
| `data` | Provides repository implementations including API service and database |
| `presentation` | UI layer: Composables, ViewModels, navigation |
| `app` | Application module that ties everything together, contains DI setup, Android manifest, etc. |

### 📊 Data Flow Diagram

```mermaid
flowchart LR
  UI --> VM[ViewModel]
  VM --> UC[UseCase]
  UC --> Repo[Repository Interface]
  Repo --> Impl[Repository Implementation]
  Impl --> RemoteAPI / LocalDB
  LocalDB <--> Impl
  RemoteAPI <--> Impl
  Impl --> Repo --> UC --> VM --> UI
```

---

## 🛠 Tech Stack

| Concern | Library / Tool |
|--------|----------------|
| Language | Kotlin |
| UI | Jetpack Compose |
| DI | Hilt (Dagger) |
| Networking | Retrofit, OkHttp |
| Database | Room |
| Image Loading | Coil |
| Async / Reactive | Kotlin Coroutines, Flow |
| Navigation | Navigation Compose |
| Testing | JUnit, Espresso, Compose UI Test |

---

## 📂 Project Structure

Here’s a high-level layout of modules and directories:

```
AndroidKotlinTestApp/
├── app/
│   ├── src/main/
│   ├── AndroidManifest.xml
│   └── DI setup, Application class
├── presentation/
│   ├── ui/
│   ├── viewmodel/
│   └── navigation/
├── data/
│   ├── remote/
│   ├── local/
│   └── repository impl
├── domain/
│   ├── model/
│   ├── usecase/
│   └── repository interfaces
├── settings.gradle
├── build.gradle (root)
├── dependencies.gradle
└── gradle.properties
```

---

## ⚙️ Setup & Installation

1. Clone the repo:
   ```bash
   git clone https://github.com/duongpill/AndroidKotlinTestApp.git
   cd AndroidKotlinTestApp
   ```

2. Import into Android Studio and sync Gradle.

3. Ensure any API keys or configuration are set (see Configuration section).

---

## 🔐 Configuration

If your project requires external API URLs or keys, add them in `gradle.properties` or `local.properties`:

```properties
BASE_URL=https://api.example.com/
API_KEY=your_api_key_here
```

You may expose these in code via `BuildConfig` using `buildConfigField`.

---

## ▶️ Build & Run

Build a debug APK:
```bash
./gradlew assembleDebug
```

Install on connected device/emulator:
```bash
./gradlew installDebug
```

Or run from Android Studio by pressing Run ▶️.

---

## 🧪 Testing

Run unit tests:
```bash
./gradlew testDebugUnitTest
```

Run instrumented / UI tests:
```bash
./gradlew connectedDebugAndroidTest
```

---

*Happy coding with Kotlin! 🚀*
