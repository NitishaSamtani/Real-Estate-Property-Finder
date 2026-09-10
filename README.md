# Real Estate Property Finder (Android — Basic Scaffold)

Jetpack Compose + Retrofit skeleton matching the app spec (Splash → Login/Register →
Home → Property Details → Favorites → Profile). It runs standalone with sample data
(`FakeData.kt`) so you can preview every screen before the backend is live.

## How to open

1. Open **Android Studio** (Giraffe/Koala or newer, with Kotlin 1.9+ / AGP 8.5+ support).
2. **File → Open** → select this project's root folder.
3. If prompted to create the Gradle wrapper, click **OK** — Android Studio will
   generate `gradlew`/`gradlew.bat` and download the matching Gradle distribution
   automatically (the wrapper JAR isn't checked in here since it's a binary file).
4. Let Gradle sync, then press **Run ▶** on the `app` configuration.

## Wiring up the real backend

1. Open `data/remote/RetrofitInstance.kt` and set `BASE_URL` to your deployed API
   (see the separate `rest_api_design.md` for the endpoint contracts).
2. Replace the `FakeData.properties` calls in each screen with the matching
   `PropertyRepository` / `AuthRepository` suspend calls, ideally from a
   `ViewModel` (not included yet — this is a "basic" scaffold, screens currently
   hold their own local state).
3. Add a token store (e.g. Jetpack DataStore) and call
   `RetrofitInstance.setAuthToken(token)` after login/register succeeds.

## What's included

- Compose Material3 theme (`ui/theme`)
- Navigation graph wiring all screens (`ui/navigation/AppNavHost.kt`)
- Screens: Splash, Login, Register, Home (feed + search bar), Property Details,
  Favorites, Profile
- Retrofit `ApiService` + `RetrofitInstance` (JWT header interceptor, logging)
- `Property` / `User` data models matching the API design doc
- Repository classes as the seam between UI and network layer

## Not included yet (natural next steps)

- Filter screen, search results screen, image gallery pager, video player (Media3),
  Google Maps screen, GPS "nearby" flow, Agent dashboard / Add Property screens
- ViewModels + StateFlow for loading/error states
- Persisted auth session
