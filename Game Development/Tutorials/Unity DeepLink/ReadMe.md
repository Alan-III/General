Unity Deep Linking Example
This repository demonstrates how to implement deep linking in a Unity project for both Android and iOS platforms. The project includes scripts and configurations to handle deep links, opening the app if installed or redirecting to the app store if not.

Table of Contents
Features
Setup
Android
iOS
Usage

Features
Deep linking support for Android and iOS.
Opens the app if installed; redirects to the app store if not.
Example scripts and configurations.
Setup
Android
Configure Intent Filter in AndroidManifest.xml:

Add the following intent filter to handle the custom URL scheme for your app:
<activity android:name="com.unity3d.player.UnityPlayerActivity">
    <intent-filter>
        <data android:scheme="unitdl" android:host="mylink" />
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
    </intent-filter>
</activity>

Web Page for Fallback to Google Play Store:

Create a web page (openappGoogle.html)

Web Page for Fallback to App Store:

Create a web page (openappIOS.html)

Usage
Add the DeepLinkManager Script to Your Unity Project
Host the Web Pages:

Upload the openapp.html files to your web server.
Use the URL of the hosted page as the deep link.
Share the Deep Link:

Share the URL (eg. https://yourwebsite.com/openappGoogle.html) with your users. When they click on it, the script will attempt to open the app and redirect to the app store if the app is not installed.