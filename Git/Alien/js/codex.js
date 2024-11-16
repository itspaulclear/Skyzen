class Alien {
    constructor(color, x, y) {
        this.x = x;
        this.y = y;
        this.color = color
        this.alienDiv = this.crearAlien()
        //this.crearAlien()
        this.moverManos()
        this.moverAlien()
    }

    crearAlien() {
        const coloresRandom = ['#ff0', '#0ff', '#f0f', '#f00', '#0f0', '#00f']
        this.color = coloresRandom[Math.floor(Math.random() * coloresRandom.length)]
        let alien = document.createElement('div')
        alien.classList.add('alien')
        alien.innerHTML = '<svg class="cabeza vivo" width="21" height="23" viewBox="0 0 21 23"  xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd"  fill="' + this.color + '" clip-rule="evenodd"  d="M15 0H6V4H3V7H0V13H3V16H6V20H9V23H12V20H15V16H18V13H21V7H18V4H15V0ZM18 7V13H15V7H18ZM3 13V7H6V13H3Z"  class="cambiacolor" /><rect x="6" y="17" width="9" height="3" fill="#fff" /><rect y="20" width="6" height="3" class="cambiacolor" fill="' + this.color + '" /><rect x="15" y="20" width="6" height="3" class="cambiacolor"  fill="' + this.color + '" /></svg><svg  width="27" height="3" viewBox="0 0 27 3"  xmlns="http://www.w3.org/2000/svg" class="manos vivo"><rect width="3" height="3" class="cambiacolor"  fill="' + this.color + '" /><rect x="24" width="3" height="3" class="cambiacolor"  fill="' + this.color + '" /></svg>';
        document.body.appendChild(alien)
        alien.addEventListener('click', () => {
            this.borrarAlien()
        })
        return alien;
    }
    borrarAlien() {
        this.alienDiv.remove()
        this.alienDiv = null;
    }

    moverAlien() {
        this.x = 0;
        this.y = 0;
        let direccion = 1;

        let moverPaso = () => {
            if (this.alienDiv === null) {
                return
            }
            this.x = this.x + 3 * direccion; // velocidad horizontal
            this.y++;
            this.alienDiv.style.left = this.x + "px";
            this.alienDiv.style.top = this.y + "px";
            let anchoVentana = window.innerWidth;
            if (this.x > (anchoVentana - this.alienDiv.offsetWidth)) {
                direccion = -1
            }
            else if (this.x < 0) {
                direccion = 1
            }
            else if (this.y > window.innerHeight) {
                this.borrarAlien()

                // let over = document.createElement('strong')
                // over.innerHTML = 'GAME OVER';
                // document.body.appendChild(over)
            }
            setTimeout(moverPaso, 20);
        }
        moverPaso();
    }
    moverManos() {
        let manos = document.querySelectorAll('.manos')
        for (let mano of manos) {
            let posicion = 0
            setInterval(function () {
                if (posicion === 0) {
                    mano.style.bottom = "6px"
                    posicion = 6;
                } else {
                    mano.style.bottom = "0px"
                    posicion = 0
                }
            }, 200)
        }

    }
}

function sacarAlien(veces) {
    if(veces <= 0) {
        return
    }
    let cosarandom = (Math.random() * 5 + 1) * 1000
    setTimeout(() => {
        new Alien()
        sacarAlien(veces - 1)
    }, cosarandom)
}
sacarAlien(20)
//unAlien.moverManos()

function impacto(o1, o2) {
    const rect1 = o1.getBoundingClientRect()
    const rect2 = o2.getBoundingClientRect()
    return !(
        rect1.top > rect2.bottom ||
        rect1.bottom < rect2.top ||
        rect1.left > rect2.right ||
        rect1.right < rect2.left
    );   
}

class Aguila {
    constructor(color, velocidad, x) {
        this.color = color || '#fff';
        this.velocidad = velocidad || 1000;
        this.nave = this.crearAguila();
        this.x;
        this.realizarDisparo()
        this.disparar();
        this.moverAguila()
    }
    crearAguila() {
        let nave = document.createElement('div')
        nave.setAttribute('id', 'nave');
        nave.innerHTML = '<svg width="45" height="48" viewBox="0 0 45 48"  xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M27 9H24V0H21V9H18V21H15V27H12V30H9V33H6V36H3V30H0V48H3V45H6V42H9V39H12H15V38H18V42H21V48H24V42H27V38H30V39H33H36V42H39V45H42V48H45V30H42V36H39V33H36V30H33V27H30V21H27V9ZM27 33V27H24V24H21V27H18V33H21V30H24V33H27Z" fill="' + this.color + '" />  <path fill-rule="evenodd" clip-rule="evenodd" d="M21 24H24V27H27V33H24V30H21V33H18V27H21V24Z" fill="#FF4637" /><rect x="9" y="15" width="3" height="6" fill="#FF4637" /><rect x="33" y="15" width="3" height="6" fill="#FF4637" /><rect x="42" y="24" width="3" height="6" fill="#FF4637" /><rect y="24" width="3" height="6" fill="#FF4637" /></svg>'
        document.body.appendChild(nave);
        return nave;
    }
    realizarDisparo(){
    document.addEventListener('keydown', (e) => {
        if (e.key === ' ') {
            this.disparar();
        }
    });
    }

    moverAguila() {
        this.x = 0;
        let direccion = 1;

        let moverPaso = () => {
            if (this.nave === null) {
                return
            }
            this.x = this.x + 2 * direccion; // velocidad horizontal
            this.nave.style.left = this.x + "px";
           let anchoVentana = window.innerWidth;
            if (this.x > (anchoVentana - this.nave.offsetWidth)) {
                direccion = -1
            }
            else if (this.x < 0) {
                direccion = 1
            }
            setTimeout(moverPaso, 20);
        }
        moverPaso();
    }


    disparar() {
        let disparo = document.createElement('div')
        disparo.classList.add('disparo');
        disparo.innerHTML = '|';
        disparo.style.left = (this.nave.offsetLeft + this.nave.offsetWidth  / 2 ) + 'px';
        document.body.appendChild(disparo);
        let moverPaso = () => {
            let posY = disparo.offsetTop;
            posY -= 5 ; 
            disparo.style.top = posY + "px";
            setTimeout(moverPaso, 5 );
            if(disparo.offsetTop < 0){
                disparo.remove()
            }
            const aliens = document.querySelectorAll('.alien')
            for(let alien of aliens) {
                if(impacto(disparo, alien)) {
                    disparo.remove()
                    alien.remove()
                }
            }
        }
        moverPaso() 
    }
}
const nave = new Aguila('orange')
