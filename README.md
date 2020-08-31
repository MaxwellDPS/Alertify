# Alertify Android 

## This fork of Gotify Android adds Spoofing of WEA Messages at the API 29 UI level

## Gotify Android 
<img align="right" src="app.gif" width="250" />

Gotify Android connects to [gotify/server](https://github.com/gotify/server) and shows push notifications on new messages.

## Sening an spoofed alert

### Priority
- \>89 - WEA dialog without Audio
- \>99 - WEA dialog with Audio *Note it uses the Alarm channel and sets to full it will override Do not disturb*

### Title options

The title field i9s used to send the message type, Types are as follows:

*Note, if title is absent or dosent match it defaults to "Critical Alert"*
*Title is case insesitive*

#### CMAS Alerts
- President
- Extreme
- Severe
- Amber
- Public
- RMT
- Broadcast
- StateTest

#### ETWS Alerts
- Tsunami
- Earthquake
- ET *(ETWS Earthquake & Tsunami Message)*
- ETWS*(ETWS Other Message)*
- ETWSTest


#### Example Commands

Example CMAS Presidental alert 
> curl "https:/\/\<gotifyURL\>/message?token=_" -F "title=President" -F "message=This is the body" -F "priority=105"

Example CMAS Extreme alert muted
> curl "https:/\/\<gotifyURL\>/message?token=_" -F "title=Extreme" -F "message=This is the body" -F "priority=95"

Example ETWS Tsunami alert 
> curl "https:/\/\<gotifyURL\>/message?token=_" -F "title=Tsunami" -F "message=This is the body" -F "priority=105"

#### CMAS Examples

    > CMAS Presidental Message    

    ![image.png](./image.png)      


    > CMAS Extreme Message

    ![image_1.png](./image_1.png)


    > CMAS Severe Message

    ![image_2.png](./image_2.png)


    > CMAS Amber Alert / Child Abduction Message

    ![image_3.png](./image_3.png)


    > CMAS Public Safety Message

    ![image_5.png](./image_5.png)

    > CMAS Required Monthly Test Message

    ![image_4.png](./image_4.png)

    > CMAS State/Local Test Message 

    ![image_6.png](./image_6.png)

    > Emergency Broadcast Operator Message

    ![image_7.png](./image_7.png)



#### ETWS Examples

     > ETWS Tsunami Message

     ![image_10.png](./image_10.png)

     > ETWS Earthquake Message

     ![image_8.png](./image_8.png)
     
     > ETWS Earthquake & Tsunami Message

     ![image_11.png](./image_11.png)

    > ETWS Other Message

    ![image_12.png](./image_12.png)

    > ETWS Test Message

    ![image_13.png](./image_13.png)


                      
                     


## Features

* show push notifications on new messages
* view and delete messages

## Installation

Download the apk or build via Android studio.

### Disable battery optimization

By default Android kills long running apps as they drain the battery. With enabled battery optimization, Gotify will be killed and you wont receive any notifications.

Here is one way to disable battery optimization for Gotify.

* Open "Settings"
* Search for "Battery Optimization"
* Find "Gotify" and disable battery optimization

### Minimize the Gotify foreground notification

*Only possible for Android version >= 8*

The foreground notification with content like `Listening to https://push.yourdomain.eu` can be manually minimized to be less intrusive:

* Open Settings -> Apps -> Gotify
* Click Notifications
* Click on `Gotify foreground notification`
* Select a different "Behavior" or "Importance" (depends on your android version)
* Restart Gotify

## Message Priorities

| Notification | Gotify Priority|
|- |-|
| - | 0 |
| Icon in notification bar | 1 - 3 |
| Icon in notification bar + Sound | 4 - 7 |
| Icon in notification bar + Sound + Vibration | 8 - 10 |

## Building

Execute the following command to build the apk.
```bash
$ ./gradlew build
```

## Update client

* Run `./gradlew generateSwaggerCode`
* Discard changes to `client/build.gradle` (newer versions of dependencies)
* Fix compile error in `client/src/main/java/com/github/gotify/client/auth/OAuthOkHttpClient.java` (caused by an updated dependency)
* Delete `client/settings.gradle` (client is a gradle sub project and must not have a settings.gradle)
* Commit changes

## Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the
[tags on this repository](https://github.com/gotify/android/tags).

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

