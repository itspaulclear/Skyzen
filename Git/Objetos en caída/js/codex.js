class Caida {
    constructor(y) {
        this.y = parseInt(y) || -30; 
        this.cosa = this.crearCosa();
        this.moverCosa();
    }

    crearCosa() {
        let entrada = document.getElementById('entrada');
        let cosa = document.createElement('div');
        cosa.classList.add('cosa');
        cosa.innerHTML = entrada.value;
        cosa.style.position = 'absolute'; 
        cosa.style.top = this.y + 'px';  
        document.body.appendChild(cosa);
        return cosa;
    }

    moverCosa() {
        this.y = 0;
        let moverPaso = () => {
            if (this.cosa === null) {
                return;
            }
            this.y++;
            this.cosa.style.top = this.y + 'px';
            this.cosa.style.rotate = this.y + 'deg'
            this.cosa.style.marginLeft = '75%'
            let altoElemento = this.cosa.offsetHeight
            if (this.y > window.innerHeight - altoElemento) {
                this.cosa.remove();
                this.cosa = null; 
            }
            document.body.style.overflow = 'hidden'
            setTimeout(moverPaso, 5);
        };
        moverPaso();
    }
}

let boton = document.getElementById('boton');
boton.addEventListener('click', () => {
    new Caida();
});
