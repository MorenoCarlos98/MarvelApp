# MarvelApp

### Descripción de la aplicación:
Aplicación Android que muestra personajes de Marvel y nos proporciona información sobre los comics, eventos, historias o series en los que aparecen.

### Diagrama de la aplicación:
![Diagrama.jpeg](https://github.com/MorenoCarlos98/MarvelApp/blob/master/Diagrama.jpeg)

### Lenguaje y framework usado:
Para el desarrollo de la aplicación he usado Kotlin y para poder hacer uso del API de Marvel he usado Retrofit2, así cómo para la obtención de imágenes he usado Glide y para poder usarlas en modo redondo he usado CircleImageView.

### Explicación del funcionamiento:
Antes de empezar a desarrollar la aplicación he tenido que añadir las dependencias:

* Retrofit
    ´implementation 'com.squareup.retrofit2:retrofit:2.9.0'´
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
* Coroutinas
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'
    
* CircleImageView
    implementation 'de.hdodenhof:circleimageview:3.1.0'
    
* Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
