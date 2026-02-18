📄 TECH STACK DOCUMENT
Product: FlipStand Clock (Android)
1️⃣ Platform

Target OS: Android
Minimum SDK: 26 (Android 8)

Why not lower?

DreamService & modern APIs become painful

Most active devices are already ≥ 26

AI-generated code works better

2️⃣ Core Language

Kotlin

Why Kotlin (not Java / not Flutter for this project)

Because your app needs:

system event handling

broadcast receivers

power management

immersive mode

Kotlin + Android SDK is:

smaller

faster

zero extra engine

easier for Antigravity to generate correctly

3️⃣ UI Framework
Jetpack Compose
Why this is critical for AI build

AI struggles with XML layouts.

Compose gives:

single language UI

less boilerplate

easier animations

faster iteration

Also required for:

smooth flip clock animation

fullscreen reactive layout

4️⃣ Architecture Pattern
MVVM (lightweight)

We are NOT doing full enterprise architecture.

Just:

UI → ViewModel → State

No repository layer for MVP.

5️⃣ Core Android Components
Activities

MainActivity

Responsible for:

launching clock screen

permission flow

orientation detection

Broadcast Receivers
Charging State Receiver

Detect:

ACTION_POWER_CONNECTED

ACTION_POWER_DISCONNECTED

Used for:

auto-launch clock

Orientation Listener

Using:

LocalConfiguration.current.orientation

Triggers UI switch.

ViewModel

Holds:

current time state

user settings

12/24 format

6️⃣ Time Engine

Use:

java.time (built into Android)

Update via:

LaunchedEffect + delay(1000)

No external libraries.

7️⃣ Animation Engine

Jetpack Compose animation APIs:

AnimatedContent

updateTransition

graphicsLayer (for flip effect)

No Lottie.
No paid libraries.

8️⃣ Data Storage
DataStore (Preferences)

Used for:

time format

auto start toggle

dim mode

Why not SharedPreferences?

Because:

modern

async

AI generates correctly

9️⃣ Power Management

To keep screen on:

window.addFlags(FLAG_KEEP_SCREEN_ON)

Optional later:

WakeLock (not needed for MVP)

🔟 Fullscreen Mode

Use:

WindowInsetsController

For:

hide status bar

hide navigation bar

1️⃣1️⃣ Dependency Management

Gradle (KTS)

No external paid dependencies.

1️⃣2️⃣ Free Libraries Used

Only official Android:

androidx.compose

lifecycle.viewmodel

datastore

That’s it.

1️⃣3️⃣ Build Tools
IDE

Android Studio (free)

JDK

17 (required for modern Android builds)

1️⃣4️⃣ Testing Strategy (MVP level)

Manual testing:

Test cases:

rotate while charging

rotate without charging

app in background → plug charger

No automated testing in V1.

1️⃣5️⃣ Performance Targets

60 FPS animation

<150MB RAM

cold start < 2 sec

1️⃣6️⃣ Future Upgrade Compatibility

This stack supports later:

DreamService (real standby mode)

widgets

themes

weather module

without rewrite.

