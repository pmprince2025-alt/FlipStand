📄 TODO DOCUMENT
Product: FlipStand Clock (Android)
🧭 DEVELOPMENT STRATEGY

We build in vertical slices, not feature chunks.

Meaning:

✔ first a working clock
✔ then auto behavior
✔ then settings

At every step → app runs.

If you try to generate everything at once → Antigravity will break the build.

✅ PHASE 0 — PROJECT SETUP
🎯 Goal: App runs with blank screen

 Create new Android project

 Kotlin + Jetpack Compose

 Min SDK 26

 App builds and installs

✅ PHASE 1 — CORE CLOCK UI (MVP HEART)
🎯 Goal: See time updating every second
UI

 Create ClockScreen

 Landscape-only layout

 Black background

 Centered time text

Logic

 Time state in ViewModel

 Update every second

 12/24 hour formatter

Definition of Done

✔ Time updates live
✔ No lag
✔ No extra permissions

✅ PHASE 2 — FULLSCREEN EXPERIENCE
🎯 Goal: Real clock feel

 Hide status bar

 Hide navigation bar

 Enable immersive mode

 Keep screen ON while clock visible

Definition of Done

✔ No system UI visible
✔ Screen doesn’t sleep

✅ PHASE 3 — FLIP ANIMATION
🎯 Goal: Flip only when digit changes

 Split hour & minute into digits

 Animate digit change

 Use Compose animation

 Ensure 60 FPS

⚠️ Do NOT animate every second for full time → only changed digit.

Definition of Done

✔ Smooth animation
✔ No frame drop

✅ PHASE 4 — ORIENTATION DETECTION
🎯 Goal: Auto switch to clock in landscape

 Detect orientation change

 Portrait → normal screen

 Landscape → clock screen

Definition of Done

✔ Rotate phone → clock appears
✔ Rotate back → exit clock

✅ PHASE 5 — CHARGING DETECTION (AUTO MODE)
🎯 Goal: Launch clock when plugged in

 Add charging BroadcastReceiver

 Detect power connected

 Check if landscape

 Auto open clock screen

Definition of Done

✔ Plug charger → clock launches

✅ PHASE 6 — SETTINGS SCREEN
🎯 Goal: User control

Create:

 Settings UI

Options:

 Auto start on charging → ON/OFF

 Require charging → ON/OFF

 12/24 hour toggle

 Dim mode toggle

Storage

 Save using DataStore

 Load on app start

✅ PHASE 7 — DIM / NIGHT MODE
🎯 Goal: Bedside usability

 Reduce brightness (software dim overlay)

 Red / white low-light clock option (optional for V1.1)

✅ PHASE 8 — APP ICON + SPLASH
🎯 Goal: Play Store readiness

 App icon

 Minimal splash screen

 App name & theme

🧪 PHASE 9 — REAL DEVICE TEST CASES

Test these manually:

Core

 Open app normally

 Rotate to landscape

 Rotate back

Charging flow

 Plug in while portrait

 Plug in while landscape

 Unplug while clock running

Edge cases

 Lock screen → unlock

 App in background → plug charger

 Screen timeout disabled correctly

📦 PHASE 10 — RELEASE BUILD

 Generate signed APK

 Test install fresh

 Check app size

🚀 POST-MVP (NOT NOW)

Only after MVP works:

 DreamService (real standby mode)

 Multiple clock styles

 AMOLED burn-in protection (pixel shift)

 Widgets

⏱️ REALISTIC BUILD TIME (WITH AI)

If you follow this order:

Phase 0–2 → 1 day

Phase 3 → 1 day

Phase 4–6 → 1 day

👉 3 days for working MVP

If you try everything together → infinite debugging loop.