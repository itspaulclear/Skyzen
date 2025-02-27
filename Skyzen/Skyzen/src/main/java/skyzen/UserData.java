package skyzen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserData {
    private String origin;
    private String distance;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private List<AllowedBooks> readBooks;
    private List<String> additionalBooks;

    public UserData(String origin, String distance, LocalDate entryDate, LocalDate departureDate, List<AllowedBooks> readBooks, List<String> additionalBooks, String genre) {
        this.origin = origin;
        this.distance = distance;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.readBooks = readBooks;
        this.additionalBooks = additionalBooks;
    }

    public UserData() {
        this.readBooks = new ArrayList<>();
        this.additionalBooks = new ArrayList<>();
    }

    public String getOrigin() {
		return origin;
	}

	public String getDistance() {
		return distance;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public List<AllowedBooks> getReadBooks() {
		return readBooks;
	}

	public List<String> getAdditionalBooks() {
		return additionalBooks;
	}

	public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReadBooks(List<AllowedBooks> readBooks) {
        this.readBooks = readBooks;
    }

    public void setAdditionalBooks(List<String> additionalBooks) {
        this.additionalBooks = additionalBooks;
    }
    
    public Map<String, Integer> calculaValoraciones() {
        Map<String, Integer> valoracionesPorPais = new HashMap<>();
        
        valoracionesPorPais.put("Norte", 0);
        valoracionesPorPais.put("Asia", 0);
        valoracionesPorPais.put("Oceanía", 0);
        valoracionesPorPais.put("América", 0);
        valoracionesPorPais.put("África", 0);

        int valoracionPorLibro = calculaValoracionPorLibro(readBooks.size());
        
        for (AllowedBooks allowedBook : readBooks) {
            String country = allowedBook.getBook().getCountry();
            if (valoracionesPorPais.containsKey(country)) {
                valoracionesPorPais.put(country, valoracionPorLibro);
            }
        }
        
        return valoracionesPorPais;
    }

    private int calculaValoracionPorLibro(int cantidadLibros) {
        if (cantidadLibros == 1) {
            return 100;
        } else if (cantidadLibros >= 2 && cantidadLibros <= 5) {
            return 20;
        } else {
            return 10;
        }
    }
    
    public Optional<Map.Entry<String, Integer>> calculaValoracionMaxima() {
        Map<String, Integer> valoraciones = calculaValoraciones();

        return valoraciones.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
    }
    
}
