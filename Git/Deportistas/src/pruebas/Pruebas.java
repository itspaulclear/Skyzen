package pruebas;
import deportista.Deportista;
import jugadorDeBaloncesto.JugadorDeBaloncesto;
import patinador.Patinador;

public class Pruebas {
    public static void main(String[] args) {
        // Prueba de los constructores
        System.out.println("============================================================");
        System.out.println("Prueba de los constructores de la subclase JugadorBaloncesto");
        System.out.println("============================================================");
        JugadorDeBaloncesto jb1 = new JugadorDeBaloncesto();
        JugadorDeBaloncesto jb2 = new JugadorDeBaloncesto('B', 20, 20, 8, 10, false, "Juan", 23, 70, 1.89, "Estudiantes", 45, 6_408_000, 6.2);
        JugadorDeBaloncesto jb3 = new JugadorDeBaloncesto('E', 18, 20, 15, 3, false, "Felipe", 27, 65.5, 2.05, "Unicaja", 47, 13_000_000, 7.3);
        JugadorDeBaloncesto jb4 = new JugadorDeBaloncesto('A', 20, 12, 9, 7, false, "Unai", 31, 73.6, 2.1, "Baskonia", 54, 3_900_000, 2.6);
        JugadorDeBaloncesto jb5 = new JugadorDeBaloncesto('P', 19, 7, 5, 10, false, "Lucas", 19, 66.7, 1.67, "Real Madrid", 60, 30_000_000, 0.6);
        JugadorDeBaloncesto jb6 = new JugadorDeBaloncesto('C', 12, 15, 10, 5, false, "Sergio", 22, 76.5, 1.91, "Breogán", 32, 2_000_000, 3.2);
        JugadorDeBaloncesto jb7 = new JugadorDeBaloncesto('E', 15, 12, 9, 3, true, "Mario", 14, 68.3, 1.76, "Joventut", 35, 300_000, 2.6);
        JugadorDeBaloncesto jb8 = new JugadorDeBaloncesto('P', 18, 11, 6, 7, true);
        JugadorDeBaloncesto jb9 = new JugadorDeBaloncesto(jb6);
        Deportista jb10 = new JugadorDeBaloncesto('C', 15, 17, 14, 10, true, "Omar", 15, 65.5, 1.83, "Estudiantes", 24, 700_000, 1.10);
        JugadorDeBaloncesto jb11 = (JugadorDeBaloncesto)jb10;
        
        System.out.printf("Jugador con posición %s(%c) y los siguientes datos de temporada:%n- Rebotes: %d%n- Tapones: %d%n- Asistencias: %d%n- Faltas: %d%n- Categoría inferior: %b%n",
                "Ala-Pivot", jb1.getPosicion(), jb1.getRebotes(), jb1.getTapones(), jb1.getAsistencias(), jb1.getFaltas(), jb1.getCategoriaInferior());   
        System.out.println("");
        
        System.out.printf("Jugador \"%s\" con posición %s(%c) y los siguientes datos de temporada:%n- Equipo: %s%n- Puntuación del equipo: %d puntos%n- Presupuesto del equipo: %d euros%n- Categoría inferior: %b%n", 
                jb2.getNombre(), "base", jb2.getPosicion(), jb2.getEquipo(), jb2.getPuntuacionEquipo(), jb2.getPresupuestoEquipo(), jb2.getCategoriaInferior());
        System.out.println("");
        
        System.out.printf("Jugador \"%s\" con dorsal %d y los siguientes datos de temporada:%n- %d rebotes%n- %d tapones%n- %d asistencias%n- %d faltas%n", 
                jb3.getNombre(), jb3.getDorsal(), jb3.getRebotes(), jb3.getTapones(), jb3.getAsistencias(), jb3.getFaltas());
        System.out.println("");
        
        System.out.printf("Jugador \"%s\" y los siguientes datos de temporada:%n- Años: %d%n- Peso: %.2f kg.%n- Estatura: %.2f metros%n- Años Jugados: %.1f años%n", 
                jb4.getNombre(), jb4.getEdad(), jb4.getPeso(), jb4.getEstatura(), jb4.getAnyosJugados());
        System.out.println("");     
        
        System.out.printf("Jugador con posición %s(%c) y los siguientes datos de temporada:%n- %d rebotes%n- %d tapones%n- %d asistencias%n- %d faltas%n- Categoría inferior: %b%n",
                jb8.getPosicion() == 'B' ? "base" : jb8.getPosicion() == 'E' ? "escolta" : jb8.getPosicion() == 'A' ? "alero" : jb8.getPosicion() == 'P' ? "ala-pivot" : jb8.getPosicion() == 'C' ? "central" : "Error",
                jb8.getPosicion(), jb8.getRebotes(), jb8.getTapones(), jb8.getAsistencias(), jb8.getFaltas(), jb8.getCategoriaInferior());
        System.out.println("");
        
        System.out.printf("Jugador \"%s\" con posición %s(%c) y los siguientes datos de temporada:%n- Años: %d%n- Peso: %.2f kg.%n- Estatura: %.2f metros%n- Equipo: %s%n- Categoría inferior: %b%n",
                jb9.getNombre(), "central", jb9.getPosicion(), jb9.getEdad(), jb9.getPeso(), jb9.getEstatura(), jb9.getEquipo(), jb9.getCategoriaInferior());
        System.out.println("");
        
        // Prueba de los métodos
        System.out.println("======================================================");
        System.out.println("Prueba de los métodos de la subclase JugadorBaloncesto");
        System.out.println("======================================================");
        System.out.println(jb2.eficiencia());
        System.out.println(jb3.eficiencia());
        System.out.println(jb1.getDorsal());
        jb3.pintar("azul");
        System.out.println(jb3);
        System.out.println(jb3.renovacion());
        jb4.valorDeMercado("local");
        jb4.valorDeMercado("internacional");
        jb4.valorDeMercado("online");
        System.out.println(jb6.riesgoDeLesion());
        System.out.println(jb7.sueldo());
        System.out.println(jb2.afinidad(jb5));
        System.out.println(jb5.afinidad(jb2));
        jb2.tirarCanastas(8, "personal", 23);
        jb4.show();
        jb3.ficharClub("Alicante");
        System.out.println(jb11.renovacion());
        jb11.tirarCanastas(3, "tiro libre", 22);
        System.out.printf("Posición actual del jugador %s: %s(%c)%n", jb2.getNombre(), "base", jb2.getPosicion());
        jb2.setPosicion('A');
        System.out.printf("Posición modificada del jugador %s: %s(%c)%n", jb2.getNombre(), "alero", jb2.getPosicion());
        System.out.printf("Cantidad actual de rebotes del jugador %s: %d%n", jb3.getNombre(), jb3.getRebotes());
        jb3.setRebotes(15);
        System.out.printf("Cantidad modificada de rebotes del jugador %s: %d%n", jb3.getNombre(), jb3.getRebotes());
        System.out.printf("Cantidad actual de tapones del jugador %s: %d%n", jb4.getNombre(), jb4.getTapones());
        jb4.setTapones(15);
        System.out.printf("Cantidad modificada de tapones del jugador %s: %d%n", jb4.getNombre(), jb4.getTapones());
        
        // a. Obtener un listado equitativo de los jugadores de baloncesto que tienen mayor cantidad de rebotes que la media
        Deportista[] jugadoresBaloncesto = {jb2, jb3, jb4, jb5, jb6, jb7, jb9};
        double sumaEficiencia = 0;
        int contadorJugadoresBaloncesto = 0;
        for(Deportista jb : jugadoresBaloncesto) {
            if(jb instanceof Deportista) {
                sumaEficiencia += jb.eficiencia();
                contadorJugadoresBaloncesto++;
            }
        }
        
        double mediaEficiencia = sumaEficiencia / contadorJugadoresBaloncesto;
        System.out.printf("Media de la eficiencia de los jugadores de baloncesto = %.1f%n", mediaEficiencia);
        
        for(Deportista jb : jugadoresBaloncesto) {
            if(jb instanceof Deportista && jb.eficiencia() > mediaEficiencia) {
                System.out.println(jb);
            }
        }
        
        // Prueba de los constructores
        System.out.println("====================================================");
        System.out.println("Prueba de los constructores de la subclase Patinador");
        System.out.println("=====================================================");
        Patinador p1 = new Patinador();
        Patinador p2 = new Patinador('f', 2, 3.5, "línea", (byte)0, "Luis", 25, 67.5, 1.76, "Real Madrid", 10, 5_000, 2.3);
        Patinador p3 = new Patinador('h', 7, 18.2, "hielo", (byte)3, "Laura", 21, 64.2, 1.65, "Granada Grizzlies", 23, 20_000, 4.5);
        Patinador p4 = new Patinador('t', 9, 12.4, "línea", (byte)2, "Izhan", 30, 71.2, 1.8, "Barcelona", 30, 10_000, 2.2);
        Patinador p5 = new Patinador('f', 4, 16.7, "línea", (byte)1);
        Patinador p6 = new Patinador('h', 7, 15.8, "hielo", (byte)2);
        Patinador p7 = new Patinador(p3);
        Patinador p8 = new Patinador('f', 6, 14.4, "hielo", (byte)2, "Marcos", 27, 73.5, 1.73, "Valladolid", 26, 7_000, 1.5);
        Patinador p9 = new Patinador('t', 5, 16.3, "línea", (byte)1, "Manuel", 23, 71.5, 1.77, "Valencia", 31, 8_500, 4.5);
        Patinador p10 = new Patinador('h', 7, 17.5, "hielo", (byte)2, "Juan", 31, 68.7, 1.89, "Murcia", 27, 6_500, 2.9);
        Patinador p11 = new Patinador('t', 4, 19.5, "línea", (byte)1, "Pedro", 32, 69.2, 1.77, "Zaragoza", 36, 7_800, 4.7);
        
        System.out.printf("Has seleccionado al patinador con las siguientes características:%n- Tipo de patín: %s(%c)%n- Elasticidad: %d%n- Coordinación: %.2f%n- Estilo artístico: %s%n- Número de medallas: %d%n",
                p1.getTipoDePatin() == 'f' ? "fitness" : p1.getTipoDePatin() == 'h' ? "hockey" : p1.getTipoDePatin() == 't' ? "todoterreno" : null, p1.getTipoDePatin(), p1.getElasticidad(),p1.getCoordinacion(), p1.getEstiloArtistico(), p1.getNumeroDeMedallas());
        System.out.printf("Has seleccionado al patinador %s con las siguientes características:%n- Edad: %d años%n- Peso: %.1f kg.%n- Estatura: %.2f metros%n- Equipo: %s%n- Tipo de patín: %s(%c)%n- Estilo artístico: %s%n- Número de medallas: %d%n- Puntuación del equipo: %d puntos%n- Presupuesto del equipo: %d euros%n- Años jugados: %.1f%n",
                p2.getNombre(), p2.getEdad(), p2.getPeso(), p2.getEstatura(), p2.getEquipo(), "fitness", p2.getTipoDePatin(), p2.getEstiloArtistico(), p2.getNumeroDeMedallas(), p2.getPuntuacionEquipo(), p2.getPresupuestoEquipo(), p2.getAnyosJugados());
        System.out.printf("Has seleccionado al patinador con las siguientes características:%n- Tipo de patín: %s(%c)%n- Elasticidad: %d%n- Coordinación: %.1f%n- Estilo artístico: %s%n- Número de medallas: %d",
                "fitness", p5.getTipoDePatin(), p5.getElasticidad(), p5.getCoordinacion(), p5.getEstiloArtistico(), p5.getNumeroDeMedallas());
        System.out.printf("Has seleccionado a la patinadora %s con las siguientes características:%n- Edad: %d años%n- Peso: %.1f kg.%n- Estatura: %.2f metros%n- Equipo: %s%n- Tipo de patín: %s(%c)%n- Estilo artístico: %s%n- Número de medallas: %d%n- Puntuación del equipo: %d puntos%n- Presupuesto del equipo: %d euros%n- Años jugados: %.1f%n",
                p7.getNombre(), p7.getEdad(), p7.getPeso(), p7.getEstatura(), p7.getEquipo(), "hockey", p7.getTipoDePatin(), p7.getEstiloArtistico(), p7.getNumeroDeMedallas(), p7.getPuntuacionEquipo(), p7.getPresupuestoEquipo(), p7.getAnyosJugados());
        
        // Prueba de los métodos
        System.out.println("==============================================");
        System.out.println("Prueba de los métodos de la subclase Patinador");
        System.out.println("==============================================");
        System.out.println(p1.eficiencia());
        p2.pintar("morado");
        System.out.println(p2.toString());
        System.out.println(p3.generarHorario());
        System.out.println(p6.generarHorario());
        p3.calcularPuntoDePartida(-1, 12);
        System.out.println(p2.generarDNI());
        System.out.println(p4.generarDNI());
        System.out.println(p2.renovacion());
        System.out.println(p3.renovacion());
        p1.valorDeMercado("exhibición");
        p1.valorDeMercado("competición");
        System.out.println(p4.riesgoDeLesion());
        System.out.println(p3.sueldo());
        System.out.println(p2.sueldo());

        p2.show();
        p3.ficharClub("Girona");
        System.out.printf("Nivel actual de elasticidad del patinador %s: %d%n", p2.getNombre(), p2.getElasticidad());
        p2.setElasticidad(8);
        System.out.printf("Nivel modificado de elasticidad del patinador %s: %d%n", p2.getNombre(), p2.getElasticidad());
        System.out.printf("Nivel actual de coordinación de la patinadora %s: %.1f (%.2f / 10)%n", 
                p3.getNombre(), p3.getCoordinacion(), (p3.getCoordinacion() * 10) / 20);
        p3.setCoordinacion(12.7);
        System.out.printf("Nivel modificado de coordinación de la patinadora %s: %.1f (%.2f / 10)%n", 
                p3.getNombre(), p3.getCoordinacion(), (p3.getCoordinacion() * 10) / 20);     
        p4.setNumeroDeMedallas((byte)1);
        System.out.printf("Nivel modificado de medallas del patinador %s: %d%n", p4.getNombre(), p4.getNumeroDeMedallas());

        // a. Obtener un listado equitativo de los patinadores que tienen un sueldo inferior al patinador p2
        Deportista[] patinadores = {p2, p3, p4};
        
        for(Deportista p : patinadores) {
            if(p instanceof Patinador && p.sueldo() < p2.sueldo()) {
                System.out.println(p);
            }
        }
        
        // b. Obtener un listado equitativo de los deportistas que tienen un sueldo superior a la media 
        Deportista[] deportistas = {jb2, jb3, jb4, jb5, jb6, jb7, jb9,
                                    p2, p3, p4, p8, p9, p10, p11};
        double sumaSueldos = 0;
        int contadorDeportistas = 0;
        for(Deportista d : deportistas) {
            if(d instanceof Deportista) {
                sumaSueldos += d.sueldo();
                contadorDeportistas++;
            }
        }
        
        double mediaSueldos = sumaSueldos / contadorDeportistas;
        
        int indiceSueldo = 0;
        while(indiceSueldo < deportistas.length) {
            if(deportistas[indiceSueldo] instanceof Deportista && deportistas[indiceSueldo].sueldo() > mediaSueldos) {
                System.out.println(deportistas[indiceSueldo].toString());
            }
            indiceSueldo++;
        }

       // c. Obtener un listado equitativo de los deportistas que tienen un riesgo de lesión superior a la media 
       double sumaRiesgoLesion = 0;
       for(Deportista d : deportistas) {
           if(d instanceof Deportista) {
               sumaRiesgoLesion += d.riesgoDeLesion();
           }
       }
       
       double mediaRiesgoLesion = sumaRiesgoLesion / contadorDeportistas;
       int indiceRiesgoLesion = 0;
       do {
           if(deportistas[indiceRiesgoLesion] instanceof Deportista && deportistas[indiceRiesgoLesion].riesgoDeLesion() > mediaRiesgoLesion) {
               System.out.printf("Deportista %s: riesgo de lesión del %.2f%%\n", deportistas[indiceRiesgoLesion].getNombre(), deportistas[indiceRiesgoLesion].riesgoDeLesion());
           }
        indiceRiesgoLesion++;
       } while(indiceRiesgoLesion < deportistas.length);

    }
}
