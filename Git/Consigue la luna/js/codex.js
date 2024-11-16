let botonMenu = document.getElementById('botonMenu')
let astronauta = document.getElementById('astronauta')
let lista = document.querySelectorAll('#lista li')
astronauta.style.transition = 'opacity 0.3s ease'
botonMenu.style.transtion = 'scale 0.3s ease'
botonMenu.addEventListener('click', function() {
    if(astronauta.style.opacity == '1') {
        astronauta.style.opacity = '0.5'
        botonMenu.style.scale = '60%'
        lista.forEach(function(item) {
            item.style.display = 'block'
        })
    } else {
        astronauta.style.opacity = '1'
        botonMenu.style.scale = '70%'
        lista.forEach(function(item) {
            item.style.display = 'none'
        })
    }
})


