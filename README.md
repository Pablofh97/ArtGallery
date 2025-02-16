# Android App
This is a basic app I've made for learning about Android Studio with Jetpack Compose.
It's mission is showing the players of a football team (F.C Barcelona). I've upload 14 players with their names 
and positions.

I've work with buttons, two in this case, one with the functionality of going to the previous image and the other button for going to the next image.
## 🛠️ Languages and Tools

 ![Kotlin](https://img.shields.io/badge/-Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white) ![Jetpack Compose](https://img.shields.io/badge/Jetpack-Compose-blue) ![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=flat&logo=AndroidStudio&logoColor=white)
  
  **Training Course**: <a href="https://developer.android.com/courses/android-basics-compose/course" target="_blank">https://developer.android.com/courses/android-basics-compose/course</a>

  ## Next button functionality
  ```Kotlin
internal fun nextImage(result : Int) : Int {
    var resultImage: Int = result
    if (resultImage == 14) {
        resultImage = 1
    }else {
        resultImage++
    }
    return resultImage
}
````
 ## Previous button functionality
```Kotlin
internal fun previousImage(result : Int) : Int {
    var resultImage: Int = result
    if (resultImage == 1) {
        resultImage = 14
    }else {
        resultImage--
    }
    return resultImage
}
```
This two functions have been used on the [Tests](#tests) directories
## First look of the app
![Initial Layoyt](app/src/main/res/drawable-nodpi/inicioapp.png)

## Tests

