package jugadorDeBaloncesto;
import java.util.Random;
import deportista.Deportista;

public class JugadorDeBaloncesto extends Deportista {
	// Propiedades 
    private char posicion;
    private int rebotes;
    private int tapones;
    private int asistencias;
    private int faltas;
    private boolean categoriaInferior;
    private int dorsal;
    private static int nextDorsal = 1;

    // Constructores   
    public JugadorDeBaloncesto() {
        this('P', 23, 12, 8, 9, false);
    }
    
    public JugadorDeBaloncesto(char posicion, int rebotes, int tapones, int asistencias, int faltas, boolean categoriaInferior, String nombre, 
            int edad, double peso, double estatura, String equipo, int puntuacionEquipo, long presupuestoEquipo, double anyosJugados) {
        super(nombre, edad, peso, estatura, equipo, puntuacionEquipo, presupuestoEquipo, anyosJugados);
        this.posicion = (posicion == 'B' || posicion == 'E' || posicion == 'A' || posicion == 'P' || posicion == 'C') ? posicion : null; 
        this.rebotes = rebotes < 0 ? 0 : rebotes;
        this.tapones = tapones < 0 ? 0 : tapones;
        this.asistencias = asistencias < 0 ? 0 : asistencias;
        this.faltas = faltas < 0 ? 0 : faltas;
        this.categoriaInferior = categoriaInferior;
        this.dorsal = nextDorsal++;
    }

    public JugadorDeBaloncesto(char posicion, int rebotes, int tapones, int asistencias, int faltas, boolean categoriaInferior) {
        super(null, 18, 0, 0, null, 0, 0, 0);
        this.posicion = (posicion == 'B' || posicion == 'E' || posicion == 'A' || posicion == 'P' || posicion == 'C') ? posicion : null; 
        this.rebotes = rebotes < 0 ? 0 : rebotes;
        this.tapones = tapones < 0 ? 0 : tapones;
        this.asistencias = asistencias < 0 ? 0 : asistencias;
        this.faltas = faltas < 0 ? 0 : faltas;
        this.categoriaInferior = categoriaInferior;
        this.dorsal = nextDorsal++;
    }
    
    public JugadorDeBaloncesto(JugadorDeBaloncesto jb) {
        super(jb.getNombre(), jb.getEdad(), jb.getPeso(), jb.getEstatura(), jb.getEquipo(), (int)jb.getPresupuestoEquipo(), jb.getPuntuacionEquipo(), jb.getAnyosJugados());
        posicion = jb.posicion;
        rebotes = jb.rebotes;
        tapones = jb.tapones;
        asistencias = jb.asistencias;
        faltas = jb.faltas;
        categoriaInferior = jb.categoriaInferior;
        this.dorsal = nextDorsal++;
    }

    // Metodos
    @Override
    public double eficiencia() {
        if(categoriaInferior == true) {
            return ((rebotes + tapones - asistencias) / (faltas + 1)) * ((super.getEdad() + super.getEstatura() + super.getPeso()) / 100) * 10;
        } else {
            return ((tapones + rebotes - asistencias) / (faltas + 1)) * 10;
        }
    }

    @Override
    public String toString() {
        return String.format("%s juega de %s con el dorsal %d, con %d rebotes, %d tapones, %d asistencias y %d faltas%s", super.toString(), posicion == 'B' ? "base" : posicion == 'E' ? "escolta" : 
            posicion == 'A' ? "alero" : posicion == 'P' ? "ala-Pivot" : posicion == 'C' ? "central" : "error", dorsal, rebotes, tapones, asistencias, faltas, "\u001B[0m");
    }
    
    public static String generarDorsal() {
        Random r = new Random();
        int unidades = r.nextInt(9);
        int decenas = r.nextInt(9);
        return String.format("%d%d", decenas, unidades);
    }
    
    @Override
    public boolean renovacion() {
        double valoracionActualTemporada = ((((rebotes * 0.3) + (tapones * 0.3) + (asistencias * 0.3)) - (faltas * 0.1) * 0.1) + 50);
        double valoracionAnteriorTemporada = (Math.random() * 100);
        return valoracionActualTemporada > valoracionAnteriorTemporada; 
    }
    
    @Override
    public void valorDeMercado(String tipoDeCotizacion) {
        int calculoInicial = (rebotes >= 10 && tapones >= 10 && asistencias >= 10 && faltas <= 15) ? 700_000 : 350_000;
        int suplementoDePosicion = ((this.posicion != 'A' || this.posicion != 'C') && super.getAnyosJugados() > 5) ? 50_000 * 70 : 25_000 * 35;
        long reputacionEquipo = super.getPresupuestoEquipo() > 500_000 ? 75_000 : 1_000;
        switch(tipoDeCotizacion) { 
            case "local":
                long calculoLocal = calculoInicial + suplementoDePosicion + reputacionEquipo;
                System.out.printf("Valor en el mercado local: %d euros%n", calculoLocal);
                break;
            case "internacional":
                int factorDeRescision = ((this.posicion != 'A' || this.posicion != 'C') && super.getAnyosJugados() <= 5) ? 600 : 300;
                int clausulaDeRescision = this.sueldo() * factorDeRescision;
                long calculoInternacional = calculoInicial + suplementoDePosicion + reputacionEquipo + clausulaDeRescision;
                System.out.printf("Valor en el mercado internacional: %d euros%n", calculoInternacional);
                break;
            case "online":
                int suplementoDePopularidad = super.getAnyosJugados() >= 5 ? 10_000 : 5_000;
                long calculoOnline = calculoInicial + suplementoDePosicion + reputacionEquipo + suplementoDePopularidad;
                System.out.printf("Valor en el mercado online: %d euros%n", calculoOnline);
                break;
            default:
                System.out.println("Introduzca un tipo de cotización válida");
                break;
        }
    }
    
    @Override
    public double riesgoDeLesion() {
        double probabilidadDeEdad = (super.getEdad() >= 20 && super.getEdad() <= 22) ? 37.5 : (super.getEdad() > 22 && super.getEdad() <= 24) ? 22.5 :
                (super.getEdad() > 24 && super.getEdad() <= 26) ? 37.5 : (super.getEdad() > 26 && super.getEdad() <= 28) ? 52.5 : 40.2;
        double probabilidadDeEstatura = (super.getEstatura() >= 1.6 && super.getEstatura() < 1.7) ? 6.5 : (super.getEstatura() >= 1.7 && super.getEstatura() < 1.8) ?
                5.5 : (super.getEstatura() >= 1.8 && super.getEstatura() <= 1.9) ? 4.5 : (super.getEstatura() >= 1.9 && super.getEstatura() <= 2) ? 3.5 : super.getEstatura() > 2 ? 2.5 : 7.5;
        return probabilidadDeEdad + probabilidadDeEstatura;
    }
    
    @Override
    public int sueldo() {
        int salarioBase = super.getPresupuestoEquipo() >= 500_000 ? 15_000 : super.getPresupuestoEquipo() >= 300_000 ? 10_000 : 5_000;
        int bonusBase = super.getEstatura() > 1.87 ? 3_500 : 0;
        return salarioBase + bonusBase;
    }
    
    public float afinidad(JugadorDeBaloncesto jb) {
        int porcentajeDeEdad = this.getEdad() > jb.getEdad() ? 3 : this.getEdad() < jb.getEdad() ? 5 : this.getEdad() == jb.getEdad() ? 10 : 0;
        short porcentajeDeEstatura = (short)(this.getEstatura() > jb.getEstatura() ? 5 : this.getEstatura() < jb.getEstatura() ? 7 : this.getEstatura() == jb.getEstatura() ? 12 : 0);
        double nivelDelJugador1 = ((((rebotes * 0.15) / 20) + ((tapones * 0.15) / 20) + ((asistencias * 0.15) / 20) + ((faltas * 0.3) / 20) + (((porcentajeDeEdad + porcentajeDeEstatura) * 0.25) / 20)) * 100);
        double nivelDelJugador2 = ((((jb.rebotes * 0.15) / 20) + ((jb.tapones * 0.15) / 20) + ((jb.asistencias * 0.15) / 20) + ((jb.faltas * 0.3) / 20) + (((porcentajeDeEdad + porcentajeDeEstatura) * 0.25) / 20)) * 100);
        if(nivelDelJugador2 >= nivelDelJugador1) {
            return (float)(100 - (nivelDelJugador2 - nivelDelJugador1));               
        } else if (nivelDelJugador2 <= nivelDelJugador1) {
            return (float)(100 - (nivelDelJugador1 - nivelDelJugador2)); 
        }
        return (float)(100 - (nivelDelJugador2 / nivelDelJugador1));
    }
    
    public void tirarCanastas(int tiradas, String tipoDeTiro, int marcador) {
        System.out.printf("Marcador potencial: %d puntos%n", tipoDeTiro.equalsIgnoreCase("tiroLibre") ? (marcador + (tiradas * 2)) : tipoDeTiro.equalsIgnoreCase("personal") ? (marcador + tiradas) : 0);
        for(int i = 0; i < tiradas; i++) {
            int tiro = (int)(Math.random() * 4);
            if(tipoDeTiro.equalsIgnoreCase("tiro libre")) {
                boolean acierto;
                if(asistencias >= 8 && tapones >= 12) {
                    acierto = (tiro == 1 || tiro == 2 || tiro == 4);               
                } else {
                    acierto = (tiro == 1 || tiro == 4);
                }
                marcador += acierto ? 2 : 0;
            } else if(tipoDeTiro.equalsIgnoreCase("Personal")) {
                marcador += (tiro == 1 || tiro == 3 || tiro == 4) ? 1 : 0;
            }
        }
        System.out.printf("Marcador %s: %d puntos%n", this.getEquipo(), marcador);
    }
    
    public char getPosicion() {
        return posicion;
    }
    
    public void setPosicion(char posicion) {
        this.posicion = posicion;
    }
            
    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }
    
    public int getTapones() {
        return tapones;
    }

    public void setTapones(int tapones) {
        this.tapones = tapones;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getFaltas() {
        return faltas;
    }

    public boolean getCategoriaInferior() {
        return categoriaInferior;
    }

    public int getDorsal() {
        return dorsal;
    }
    
}
