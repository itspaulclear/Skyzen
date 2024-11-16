package patinador;
import java.util.Random;
import deportista.Deportista;

public class Patinador extends Deportista{
    // Propiedades 
    private char tipoDePatin;
    private int elasticidad;
    private double coordinacion;
    private String estiloArtistico;
    private byte numeroDeMedallas;
    private char asignacionHoraria;
    private static char nextAsignacionHoraria = 'Z';
    
    // Constructores
    public Patinador() {
        this('h', 8, 16.5, "línea", (byte)2);
    }
    
    public Patinador(char tipoPatin, int elasticidad, double coordinacion, String estiloArtistico, byte numeroDeMedallas, String nombre, 
            int edad, double peso, double estatura, String equipo, int puntuacionEquipo, long presupuestoEquipo, double anyosJugados) {
        super(nombre, edad, peso, estatura, equipo, puntuacionEquipo, presupuestoEquipo, anyosJugados);
        this.tipoDePatin = (tipoPatin == 'f' || tipoPatin == 'h' || tipoPatin == 't') ? tipoPatin : null;
        this.elasticidad = elasticidad >= 1 && elasticidad <= 10 ? elasticidad : 0;
        this.coordinacion = coordinacion >= 1 && coordinacion <= 20 ? coordinacion : 0;
        this.estiloArtistico = estiloArtistico.equalsIgnoreCase("línea") || estiloArtistico.equalsIgnoreCase("hielo") ? estiloArtistico : null;
        this.numeroDeMedallas = numeroDeMedallas;
        this.asignacionHoraria = nextAsignacionHoraria--;
    }
    
    public Patinador(char tipoPatin, int elasticidad, double coordinacion, String estiloArtistico, byte numeroDeMedallas) {
        super(null, 0, 0, 0, null, 0, 0, 0);
        this.tipoDePatin = (tipoPatin == 'f' || tipoPatin == 'h' || tipoPatin == 't') ? tipoPatin : null;
        this.elasticidad = elasticidad >= 1 && elasticidad <= 10 ? elasticidad : 0;
        this.coordinacion = coordinacion >= 1 && coordinacion <= 20 ? coordinacion : 0;
        this.estiloArtistico = estiloArtistico.equalsIgnoreCase("línea") || estiloArtistico.equalsIgnoreCase("hielo") ? estiloArtistico : null; 
        this.numeroDeMedallas = numeroDeMedallas;
        this.asignacionHoraria = nextAsignacionHoraria--;
    }
    
    public Patinador(Patinador p) {
        super(p.getNombre(), p.getEdad(), p.getPeso(), p.getEstatura(), p.getEquipo(), p.getPuntuacionEquipo(), p.getPresupuestoEquipo(), p.getAnyosJugados());
        tipoDePatin = p.tipoDePatin;
        elasticidad = p.elasticidad;
        coordinacion = p.coordinacion;
        estiloArtistico = p.estiloArtistico;
        numeroDeMedallas = p.numeroDeMedallas;
        this.asignacionHoraria = nextAsignacionHoraria--;
    }
    
    // Métodos
    @Override
    public double eficiencia() {
        int experienciaAcumulada = super.getAnyosJugados() < 2 ? 4 : super.getAnyosJugados() >= 2 ? 7 : 1;
        int puntuacionDePeso = super.getPeso() < 63 ? 2 : super.getPeso() < 64.5 ? 5 : super.getPeso() >= 66.5 ? 8 : 1;
        byte puntuacionDeEstatura = (byte)(super.getEstatura() < 1.65 ? 2 : super.getEstatura() < 1.70 ? 8 : super.getEstatura() >= 1.78 ? 3 : 1);
        return ((((elasticidad * 0.25) / 10) + ((coordinacion * 0.25) / 20) + (((puntuacionDePeso + puntuacionDeEstatura * 0.25) / 16) + ((experienciaAcumulada * 0.25) / 7))) * 100);
    }
    
    @Override
    public String toString() {
       return String.format("%s, deportista de %s con patines de tipo %s, con un nivel de elasticidad de %d, coordinacion de %.2f y %d medallas%s", 
               super.toString(), estiloArtistico.equalsIgnoreCase("línea") ? "patinaje en línea" : estiloArtistico.equalsIgnoreCase("hielo") ? "patinaje sobre hielo" : null, 
               tipoDePatin == 'f' ? "fitness" : tipoDePatin == 'h' ? "hockey" : tipoDePatin == 't' ? "todoterreno" : null, elasticidad, coordinacion, (int)numeroDeMedallas, "\u001B[0m");
    }
    
    public String generarHorario() {
        if (asignacionHoraria <= 'Z' && asignacionHoraria >= 'V') {
            return String.format("Estás en el turno de %d:%d - %d:%d", 8, 55, 9, 55);
        } else if (asignacionHoraria <= 'U' && asignacionHoraria >= 'Q') {
            return String.format("Estás en el turno de %d:%d - %d:%d", 9, 55, 10, 55);
        } else if (asignacionHoraria <= 'P' && asignacionHoraria >= 'L') {
            return String.format("Estás en el turno de %d:%d - %d:%d", 10, 55, 12, 55);
        } else if (asignacionHoraria <= 'K' && asignacionHoraria >= 'G') {
            return String.format("Estás en el turno de %d:%d - %d:%d", 12, 55, 13, 55);
        } else if (asignacionHoraria <= 'F' && asignacionHoraria >= 'A') {
            return String.format("Estás en el turno de %d:%d - %d:%d", 13, 55, 14, 55);
        } else {
            return "No se te ha asignado un horario";
        }
    }

    public void calcularPuntoDePartida(int x, int y) {
    	x = (x <= 10 && x >= 0) ? x : x > 10 ? 10 : 0;
    	y = (y <= 10 && y >= 0) ? y : y > 10 ? 10 : 0;
    	for(int i = 0; i < 11; i++) {
			for(int k = 0; k <= 10; k++) {
				if(k == 0) {
					System.out.printf("%d%s %s--", (10 - i), i == 0 ? "" : " ", ((10 - i) == y && k == x) ? "*" : "+");
				} else if(k > 0 && k <= 9) {
					System.out.printf("%s--", ((10 - i) == y && k == x) ? "*" : "+");
				} else if(k == 10) {
					System.out.printf("%s", ((10 - i) == y && k == x) ? "*" : "+");
				}
			}
			System.out.println();
		}
		
		for(int l = 0; l <= 10; l++) {
			if(l == 0) {
				System.out.printf("   %d  ", l);
			} else {
				System.out.printf("%d  ", l);								
			}
		}
		System.out.println();
    }
    
    public static String generarDNI() {
        String DNI = "";
        Random r = new Random();
        for(int i = 0; i < 9; i++) {
            if(i < 8) {
                DNI += r.nextInt(10);
            } else {
                char letra = (char)(r.nextInt(26) + 65);
                DNI += letra;        
            }
        }
        return String.format("El DNI es: %s", DNI);
    }
    
    
    @Override
    public boolean renovacion() {
        int valoracionEquipo = (super.getPuntuacionEquipo() >= 20 && super.getPuntuacionEquipo() <= 30) ? 15 : (super.getPuntuacionEquipo() >= 31 && super.getPuntuacionEquipo() <= 40) ? 20 : 10;
        int valoracionPresupuesto = (super.getPresupuestoEquipo() <= 20_000 && super.getPresupuestoEquipo() >= 10_000) ? 10 : super.getPresupuestoEquipo() >= 20_000 ? 20 : 5;
        int valoracionAnyosJugados = (super.getAnyosJugados() >= 1 && super.getAnyosJugados() >= 0.5) ? 5 : super.getAnyosJugados() >= 2 ? 10 : super.getAnyosJugados() >= 3 ? 15 : 2;
        double valoracionGeneral = (((valoracionEquipo * 0.2) / 20) + ((valoracionPresupuesto * 0.2) / 20) + ((valoracionAnyosJugados * 0.2) / 15) + ((coordinacion * 0.2) / 20) + ((elasticidad * 0.2) / 10)) * 100;
        return valoracionGeneral >= 45.5; 
    }
    
    @Override
    public void valorDeMercado(String tipoCotizacion) {
        switch(tipoCotizacion) {
            case "exhibición":
                double puntuacionEdad = (super.getEdad() >= 18 && super.getEdad() <= 20) ? 666.5 : (super.getEdad() >= 21 && super.getEdad() <= 25) ? 1_000 : (super.getEdad() >= 26 && super.getEdad() <= 33) ? 4_000 : 335.5;
                double puntuacionPeso = super.getPeso() <= 64.5 ? 500.5 : 666.5;
                double puntuacionEstatura = (super.getEstatura() >= 1.62 && super.getEstatura() <= 1.85) ? 333.5 : 666.5;
                int puntuacionElasticidad;
                int puntuacionCoordinacion = puntuacionElasticidad = (this.getCoordinacion() >= 1 && this.getCoordinacion() <= 7) ? 666 : 1_166;  
                double valoracionFinal = puntuacionEdad + puntuacionPeso + puntuacionEstatura + puntuacionCoordinacion + puntuacionElasticidad;
                System.out.printf("Ha recibido un salario de %.2f euros por su participación en la exhibición%n", valoracionFinal);
                break;
            case "competición":
                short tarifaBaseCompeticion = (short)(super.getAnyosJugados() <= 1 ? 1_000 : super.getAnyosJugados() <= 3 ? 2_000 : 500);
                int tarifaMedallas = (elasticidad <= 5 && coordinacion <= 7) ? 400 : (elasticidad <= 7 && coordinacion <= 14) ? 800 : (elasticidad == 10 && coordinacion == 20) ? 1600 : 0;
                int tarifaExperiencia = numeroDeMedallas < 1 ? 1_200 : numeroDeMedallas == 2 ? 2_400 : numeroDeMedallas > 2 ? 4_800 : 1_000;
                int posicionCompeticion = (int)(numeroDeMedallas >= 1 ? Math.random() * 4 : 0);
                int salarioPosicion = posicionCompeticion == 1 ? 3_000 : posicionCompeticion == 2 ? 2_000 : posicionCompeticion == 3 ? 1000 : 500;
                double calculoCompeticion = tarifaBaseCompeticion + (tarifaMedallas * numeroDeMedallas) + (tarifaExperiencia + salarioPosicion);
                System.out.printf("Ha recibido un salario de %.2f euros por su participación en la competición habiendo quedado %s%n", 
                		calculoCompeticion, posicionCompeticion == 1 ? "en primera posición" : posicionCompeticion == 2 ? "en segunda posición" : posicionCompeticion == 3 ? "en tercera posición" : "descalificado");
                break;
            default: 
                System.out.printf("Introduzca un tipo de cotización válida%n");
                break;
        }     
    }
    
    @Override
    public double riesgoDeLesion() {
        double probabilidadLesion = (coordinacion >= 5.5 && coordinacion <= 11.5) ? 52.5 : (coordinacion > 11.5 && coordinacion <= 13.5) ? 37.5 : 
                (coordinacion > 13.5 && coordinacion <= 15.5) ? 22.5 : (coordinacion > 15.5 && coordinacion <= 17.5) ? 7.5 : coordinacion > 17.5 ? 5.5 : 2;
        double probabilidadElasticidad = (elasticidad >= 2 && elasticidad <= 4) ? 5.5 : (elasticidad > 4 && elasticidad <= 6) ? 4.5 : 
                (elasticidad > 6 && elasticidad <= 8) ? 3.5 : elasticidad > 8 ? 2.5 : 1;
        double suplementoEstiloArtistico = estiloArtistico.equalsIgnoreCase("línea") ? 5 : 10;
        return probabilidadLesion + probabilidadElasticidad + suplementoEstiloArtistico; 
    }
    
    @Override
    public int sueldo() {
        double presupuestoDePublicidad = super.getPresupuestoEquipo() >= 20_000 ? (super.getPresupuestoEquipo() - 15_000) : 2_000;
        double salarioBase = (super.getPresupuestoEquipo() - presupuestoDePublicidad) / 3;
        int salarioDietas = (this.coordinacion >= 12 && this.elasticidad >= 6) ? 2_000 : (this.coordinacion >= 15 && this.elasticidad >= 7) ? 4_000 : 3_500; 
        return (int)((salarioBase + salarioDietas) * super.getAnyosJugados()); 
    }
    

    public char getTipoDePatin() {
        return tipoDePatin;
    }

    public int getElasticidad() {
        return elasticidad;
    }

    public void setElasticidad(int elasticidad) {
        this.elasticidad = elasticidad;
    }
 
    public double getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(double coordinacion) {
        this.coordinacion = coordinacion;
    }
    
    public String getEstiloArtistico() {
        return estiloArtistico;
    }
    
    public byte getNumeroDeMedallas() {
    	return numeroDeMedallas;
    }
    
    public void setNumeroDeMedallas(byte numeroDeMedallas) {
    	this.numeroDeMedallas = numeroDeMedallas;
    }
    
}
