# MarvelApp

### Descripción:
Aplicación Android que muestra personajes de Marvel y nos proporciona información sobre los comics, eventos, historias o series en los que aparecen.

### Diagrama:
![Diagrama.jpeg](https://github.com/MorenoCarlos98/MarvelApp/blob/master/Diagrama.jpeg)

### Uso y funcionamiento:
Cuando instalemos la aplicación veremos el icono de Marvel.
Al iniciar la aplicación, se nos mostrará un splashscreen.
La aplicación accede a https://gateway.marvel.com/ haciendo peticiones GET dependiendo de lo que queramos ver. Para poder hacer peticiones a la API he usado Retrofit2, estas peticiones las realizo en un segundo hilo para no sobrecargar al hilo principal.
Las imagenes mostradas se obtienen de la URL (thumbnail) y escribiendo que tamaño quería obtener; para obtenerlas y setearlas en el item imagen he usado Glide y para poder hacerla redondeada he usado CircleImageView.
Si pulsamos sobre un personaje se nos abrirá un diálogo para seleccionar y ver en qué sitio aparece.
