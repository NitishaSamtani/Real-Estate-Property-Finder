# 🏠 Real Estate Property Finder

An Android-based real estate property finder application developed as a mini project. The application allows users to register and log in, browse available properties, view detailed property information, locate properties using Google Maps, and contact property agents directly through the phone dialer.

## 📱 Features

* User Registration
* User Login
* Property Listing
* Property Details
* Property Location using Google Maps
* Exact Location Marker
* Contact Agent through Phone Dialer
* Simple and User-Friendly Interface

## 🛠️ Technologies Used

* Android Studio
* Android SDK
* Java/Kotlin
* XML
* Google Maps API
* Gradle
* Database/Backend used by the application

## 📂 Project Structure

```text
Real-Estate-Property-Finder/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/ or kotlin/
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   │
│   └── build.gradle
│
├── gradle/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

## 🔑 Main Application Flow

```text
Registration
      ↓
    Login
      ↓
 Property Listing
      ↓
 Property Details
      ↓
 ┌───────────────┐
 ↓               ↓
Google Maps   Contact Agent
 ↓               ↓
Location       Dialer
```

## 🗺️ Google Maps Integration

The application uses Google Maps to display the geographical location of a selected property. The property's latitude and longitude are used to place a marker on the map.

## 📞 Agent Contact

Users can select the contact option from the property details screen. The application opens the Android phone dialer with the corresponding agent's phone number.

## 🎓 Project Type

Android Mini Project

## 👨‍💻 Author

Add your name here.

## 📄 License

This project was developed for academic/educational purposes.
