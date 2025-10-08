# CogniCare

CogniCare is an Android application designed for brain wave analysis and monitoring. The app provides a comprehensive interface to view and analyze brain wave reports including Alpha, Beta, Theta, and Delta wave activities.

## 📋 Overview

CogniCare helps users track and visualize their brain wave activity over time. The application features a secure login system, user profiles, and detailed brain wave analysis reports with graphical representations.

## ✨ Features

- **User Authentication**: Secure login system with username and password
- **User Profiles**: Personalized user profiles with avatar support
- **Brain Wave Reports**: Detailed analysis of four types of brain waves:
  - **Alpha Waves**: Associated with relaxed, alert states
  - **Beta Waves**: Associated with active thinking and concentration
  - **Theta Waves**: Associated with meditation and deep relaxation
  - **Delta Waves**: Associated with deep sleep
- **Visual Representations**: Graphical displays of brain wave activity levels
- **Historical Reports**: Track brain wave activity over time with dated reports
- **Brain Wave Analysis Images**: Visual analysis charts for comprehensive understanding
- **User-Friendly Interface**: Clean, modern UI built with Jetpack Compose

## 🛠️ Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture Components**: 
  - ViewModel
  - StateFlow
  - Navigation Component
- **Minimum SDK**: 31 (Android 12)
- **Target SDK**: 34 (Android 14)
- **Build System**: Gradle (Kotlin DSL)

## 📦 Dependencies

- AndroidX Core KTX
- Lifecycle Runtime KTX
- Activity Compose
- Compose BOM
- Material3
- Navigation Compose
- JUnit (for testing)

## 🚀 Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- JDK 8 or higher
- Android SDK with API level 31 or higher
- Gradle 8.x

### Installation

1. Clone the repository:
```bash
git clone https://github.com/SamriddhVermaSRM/CogniCare.git
```

2. Open the project in Android Studio

3. Wait for Gradle to sync and download dependencies

4. Build the project:
```bash
./gradlew build
```

5. Run the app on an emulator or physical device

## 📱 Usage

### Login Credentials

The application comes with three demo users. Use the following credentials to log in:

| Username | Password | User Name |
|----------|----------|-----------|
| gracy04  | 0411     | Gracy Saxena |
| aditi22  | 2203     | Aditi Jaiswal |
| gargi09  | 0908     | Gargi |

### Navigation Flow

1. **Login Screen**: Enter username and password to access the application
2. **Home Screen**: View user profile and list of available brain wave reports
3. **Report Screen**: Select a report to view detailed brain wave analysis

## 📁 Project Structure

```
app/src/main/java/com/example/cognicare/
├── MainActivity.kt                 # Main activity and navigation setup
├── data/
│   ├── DataSource.kt              # Data models and sample data
│   └── DataUiState.kt             # UI state management
└── ui/
    ├── DataUiModel.kt             # ViewModel for data management
    ├── LoginScreen.kt             # Login screen composable
    ├── HomeScreen.kt              # Home screen with report list
    ├── ReportScreen.kt            # Detailed report view
    └── theme/
        ├── Color.kt               # App color scheme
        ├── Theme.kt               # Material theme configuration
        └── Type.kt                # Typography definitions
```

## 🧪 Testing

Run unit tests:
```bash
./gradlew test
```

Run instrumented tests:
```bash
./gradlew connectedAndroidTest
```

## 🏗️ Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Data classes (`user`, `report`) and `DataSource` for data management
- **View**: Jetpack Compose UI components (LoginScreen, HomeScreen, ReportScreen)
- **ViewModel**: `DataUiModel` manages UI state and business logic

## 📊 Brain Wave Types

- **Alpha (8-13 Hz)**: Relaxed but alert state
- **Beta (13-30 Hz)**: Active thinking, focus, and concentration
- **Theta (4-8 Hz)**: Deep meditation and light sleep
- **Delta (0.5-4 Hz)**: Deep sleep and unconscious state

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is available for educational and demonstration purposes.

## 👥 Authors

- **Samriddh Verma** - [SamriddhVermaSRM](https://github.com/SamriddhVermaSRM)

## 📧 Contact

For any queries or suggestions, please open an issue on GitHub.

## 🙏 Acknowledgments

- Sample brain wave data is for demonstration purposes only
- Brain wave analysis images and data are illustrative
- This app is designed as an educational tool for understanding brain wave patterns

---

**Note**: This application uses mock data for demonstration purposes. For actual brain wave monitoring, please consult with medical professionals and use certified medical devices.
