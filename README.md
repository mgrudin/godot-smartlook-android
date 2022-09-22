# Godot Smartlook Android Plugin
Godot Android plugin for Smartlook SDK

# Getting Started

## Dependencies
- Android build template

## Installing
1. Set up [custom build for Android](https://docs.godotengine.org/en/stable/tutorials/export/android_custom_build.html). After that you should have android/build directory in your Godot project.
2. Create a folder into the android directory.
3. Copy plugin files to the new folder.
4. Edit `SmartlookPlugin.java` and insert your APP_KEY.

```
  private String SDK_KEY = "YOUR_KEY";
```

5. In Godot under Project Settings add the plugin to Modules
6. Add IronSource.gd as autoloadable singleton.
7. Then anywhere in code:
```
  Smartlook.init()
  Smartlook.startRecord()
```