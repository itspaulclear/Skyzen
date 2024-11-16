package skyzen;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OceanicCountries {
    private static final Random RANDOM = new Random();
    private final Set<String> usedDestinations = new HashSet<>(); 
    private final List<OceanicCountriesActivities> destinations = new ArrayList<>();
    private int currentIndex = 0;

    public void start(Stage primaryStage, LocalDate entry, LocalDate departure) {
        Font customFont = Font.loadFont(getClass().getResourceAsStream("/Fonts/soulwayfont-demo.otf"), 36);
        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/Fonts/futura light bt.ttf"), 20);

        Image image = new Image(getClass().getResourceAsStream("/OceanicImages/Cover.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth() * 0.6);
        imageView.setFitHeight(image.getHeight() * 0.6);
        imageView.setPreserveRatio(true);

        Text text = new Text("Sumérgete en las aguas de Oceanía");
        text.setFill(Color.WHITE);
        text.setFont(customFont);
		text.setTextAlignment(TextAlignment.CENTER);
        text.setTranslateY(-120);

        Text subText = new Text("La mezcla de montañas, desiertos, arrecifes, bosques, playas y ciudades multiculturales\n de Australia y Nueva Zelanda es una atracción eterna para los viajeros. Remotas, bellas\n y acogedoras, las arenas blancas de las playas del Pacífico y sus aguas cerúleas\n son tan perfectas que parecen un sueño.");
        subText.setFill(Color.WHITE);
        subText.setFont(customFont2);
		subText.setTextAlignment(TextAlignment.CENTER);

        StackPane imageStack = new StackPane(imageView, text, subText);
        imageStack.setAlignment(Pos.CENTER);
        
        Text itinerario = new Text("Itinerario");
        itinerario.setFont(customFont2);
        itinerario.setTranslateY(30);

        VBox content = new VBox(40, imageStack, itinerario, createActivitiesGrid(entry, departure));
        content.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        StackPane root = new StackPane(scrollPane);
        root.setStyle("-fx-background-color: #F5EFED; -fx-padding: 10px; -fx-border-color: white; -fx-border-width: 10px; -fx-border-radius: 10px;");
        root.setPadding(new Insets(0));
        
        Scene scene = new Scene(root, 900, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Países Oceánicos");
        primaryStage.show();
    }

    private VBox createActivitiesGrid(LocalDate entry, LocalDate departure) {
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        LocalDate currentDate = entry;
        int day = 1;
        while (!currentDate.isAfter(departure)) {
        	Text dayText = new Text("Día " + day++);
            VBox dayActivities = new VBox();
            dayActivities.setAlignment(Pos.CENTER);
            dayActivities.getChildren().add(dayText);
            HBox imagesContainer = new HBox(10);
            imagesContainer.setAlignment(Pos.CENTER);

            for (int i = 0; i < 3; i++) {
                OceanicCountriesActivities activity = getRandomActivity();
                destinations.add(activity);
                Image image = new Image(activity.getImagenes());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                
                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    showActivityDetailsPopup(activity);
                });
                
                Text description = new Text(activity.getLugar());
                description.setFont(Font.font(14));
                
                VBox imageWithDescription = new VBox(5);
                imageWithDescription.getChildren().addAll(imageView, description);
                imageWithDescription.setAlignment(Pos.CENTER);
                
                imagesContainer.getChildren().add(imageWithDescription);
            }

            dayActivities.getChildren().add(imagesContainer);
            vBox.getChildren().add(dayActivities);
            currentDate = currentDate.plusDays(1);
        }

        return vBox;
    }

    private void showActivityDetailsPopup(OceanicCountriesActivities activity) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Detalles de la Actividad");
        popupStage.initModality(Modality.APPLICATION_MODAL);

        VBox popupContent = new VBox(10);
        popupContent.setAlignment(Pos.CENTER);
        popupContent.setStyle("-fx-padding: 20px; -fx-background-color: #F5EFED;");
        popupStage.setWidth(450);
        popupStage.setHeight(500);

        Text title = new Text(activity.getLugar());
        title.setFont(Font.font(20));
        title.setFill(Color.BLACK);

        ImageView imageView = new ImageView(new Image(activity.getImagenes()));
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        Text description = new Text(activity.getDescripcion());
        description.setFont(Font.font(14));
        description.setWrappingWidth(250);
        description.setFill(Color.BLACK);
        
        Text duration = new Text("Duración: " + convertirMinutosAHoras(activity.getDuracion()));
        duration.setFont(Font.font(14));
        duration.setFill(Color.BLACK);

        Hyperlink closeLink = new Hyperlink("Cerrar");
        closeLink.setOnAction(event -> popupStage.close());

        popupContent.getChildren().addAll(title, imageView, description, duration, closeLink);

        ScrollPane scrollPane = new ScrollPane(popupContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        ImageView leftArrow = loadArrowImage("/AdditionalAssets/left_arrow.png");
        ImageView rightArrow = loadArrowImage("/AdditionalAssets/right_arrow.png");

        if (leftArrow != null) {
            leftArrow.setOnMouseClicked(event -> navigateToPreviousActivity(popupStage));
            leftArrow.setStyle("-fx-cursor: hand;");
        } else {
            System.out.println("No se ha podido cargar la imagen");
        }
        
        if (rightArrow != null) {
            rightArrow.setOnMouseClicked(event -> navigateToNextActivity(popupStage));
            rightArrow.setStyle("-fx-cursor: hand;");
        } else {
            System.out.println("No se ha podido cargar la imagen");
        }

        StackPane stackPane = new StackPane(scrollPane);

        if (leftArrow != null) {
            stackPane.getChildren().add(leftArrow);
            StackPane.setAlignment(leftArrow, Pos.CENTER_LEFT);
            StackPane.setMargin(leftArrow, new Insets(0, 0, 0, 10));
        }

        if (rightArrow != null) {
            stackPane.getChildren().add(rightArrow);
            StackPane.setAlignment(rightArrow, Pos.CENTER_RIGHT);
            StackPane.setMargin(rightArrow, new Insets(0, 10, 0, 0));
        }

        Scene popupScene = new Scene(stackPane);
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    private ImageView loadArrowImage(String path) {
        try {
            Image image = new Image(getClass().getResourceAsStream(path));
            if (image.isError()) {
                System.out.println("Error cargando la imagen: " + path);
                return null;
            }
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            return imageView;
        } catch (Exception e) {
            System.out.println("Exception cargando la imagen: " + e.getMessage());
            return null;
        }
    }

    private void navigateToPreviousActivity(Stage currentStage) {
        currentIndex = (currentIndex - 1 + destinations.size()) % destinations.size();
        currentStage.close();
        showActivityDetailsPopup(destinations.get(currentIndex));
    }

    private void navigateToNextActivity(Stage currentStage) {
        currentIndex = (currentIndex + 1) % destinations.size();
        currentStage.close();
        showActivityDetailsPopup(destinations.get(currentIndex));
    }

    private OceanicCountriesActivities getRandomActivity() {
        OceanicCountriesActivities[] activities = OceanicCountriesActivities.values();
        OceanicCountriesActivities randomActivity;
        do {
            randomActivity = activities[RANDOM.nextInt(activities.length)];
        } while (usedDestinations.contains(randomActivity.getLugar()));

        usedDestinations.add(randomActivity.getLugar());
        return randomActivity;
    }

    public int calculateVisitDuration(LocalDate inDate, LocalDate outDate) {
        return (int) ChronoUnit.DAYS.between(inDate, outDate.plusDays(1));
    }
    
    private String convertirMinutosAHoras(int minutos) {
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        return horas + " h " + minutosRestantes + " min";
    }
}
