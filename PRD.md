📄 PRODUCT REQUIREMENTS DOCUMENT (PRD)
1. 🧭 Product Overview

Product Name: FlipStand Clock (working title)

Product Type: Android utility app

Core Idea:
When the phone is placed in landscape while charging, it turns into a fullscreen flip clock, similar to iPhone StandBy mode.

Primary Goal (MVP):

Auto-launch clock UI in landscape

Flip animation time display

Always-on screen while active

100% free implementation

2. 🎯 Objectives
User Goals

Use old or current phone as bedside / desk clock

See time from distance

Get iPhone-like experience on Android

Product Goals

Lightweight

Offline

No API cost

Play Store publishable

3. 👤 Target Users

Students

Desk setup users

Bedside clock users

Android customization lovers

4. 🧩 Feature Scope
✅ MVP Features (V1)
4.1 Auto Trigger

App activates when:

device is in landscape

AND charging (optional toggle)

4.2 Clock UI

Flip clock animation (HH:MM)

Large centered layout

AMOLED black background

Landscape-only mode

4.3 Screen Behavior

Keep screen awake while active

Fullscreen immersive mode

4.4 Manual Mode

User can:

Open app → use clock without charging

4.5 Basic Settings

12 / 24 hour format

Toggle auto-start on charging

Brightness dim mode

🚀 V2 Features (Not in MVP)

These are future, not to be built now:

Multiple clock styles

Widgets

Notifications display

Always-on while locked (Dream Service mode)

Weather

Custom colors

5. ❌ Out of Scope (for now)

This is important to stay free & shippable:

Internet features

Accounts / login

Ads

Cloud sync

iOS-level system integration

6. 🖥️ User Flow
First Launch

User opens app

Sees intro screen

Grants permissions:

display over lock screen (optional later)

ignore battery optimization (optional)

Lands on clock preview

Daily Use Flow

User plugs phone for charging

Rotates to landscape

Clock screen auto opens

Screen stays on

7. 🧱 Technical Requirements
7.1 Platform

Android (min SDK 26 recommended)

7.2 Tech Stack (free)

Best for Antigravity:

Kotlin

Jetpack Compose

Why?

Less code

AI-friendly

Fast UI building

No paid tools

7.3 Key System Components

Orientation listener

Charging state receiver

Foreground activity launcher

Wake lock / keep screen on

8. 🎨 UI / UX Requirements
Layout

Landscape only.

Structure:

[ Hour Flip ] [ Minute Flip ]

Design Rules

Minimal

High contrast

Edge-to-edge

No buttons on main screen

Night Mode

Red / white dim clock (later feature optional)

9. ⚙️ Settings Screen

Options:

Auto start on charging → ON/OFF

Require charging → ON/OFF

Time format → 12 / 24

Screen brightness dim → ON/OFF

10. 🔋 Performance Requirements

App size < 30MB

RAM usage < 150MB

No background battery drain when inactive

11. 🔐 Permissions

For MVP:

None mandatory

For advanced mode later:

RECEIVE_BOOT_COMPLETED

BATTERY_STATE

WAKE_LOCK

All free.

12. 📊 Success Metrics

MVP is successful if:

Clock launches correctly in landscape

Animation runs smoothly at 60fps

Screen stays awake

Works offline

13. 🛠️ Development Plan (for AI build)
Phase 1

Clock UI

Phase 2

Orientation detection

Phase 3

Charging detection

Phase 4

Settings screen