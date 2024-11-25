import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Queue_GUI extends Application {
    Queue liste = new Queue();
    boolean active = false;
    // WarteSchlange/Queue FIFO

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btnInsert = new Button("Insert");
        btnInsert.getStyleClass().add("insert-button");
        RadioButton activePosition1 = new RadioButton();
        Button btnRemove = new Button("Remove");
        btnRemove.getStyleClass().add("remove-button");
        RadioButton activePosition2 = new RadioButton();
//        activePosition2.setDisable(true);
        Spinner<Integer> spiPosition = new Spinner<>(1, liste.getAnzahl() + 1, liste.getAnzahl() + 1);
        spiPosition.getStyleClass().add("position-spinner");
        spiPosition.setEditable(true);
        Button btnCount = new Button("Count");
        btnCount.getStyleClass().add("count-button");
        Button btnClose = new Button("Close");
        btnClose.getStyleClass().add("close-button");

        TextField eingabeZeile = new TextField();
        eingabeZeile.getStyleClass().add("input-field");
        TextArea ausgabeListe = new TextArea();
        ausgabeListe.getStyleClass().add("output-list");
        Label ausgabeZeile = new Label("waiting...");
        ausgabeZeile.getStyleClass().add("output-field");
        ausgabeListe.setPrefSize(200, 200);
        ausgabeListe.setEditable(false);
        TextField searchBar = new TextField();
        searchBar.getStyleClass().add("search-bar");
        searchBar.setDisable(true);
        searchBar.setVisible(false);

        HBox insert = new HBox(btnInsert, activePosition1);
        HBox extract = new HBox(btnRemove, activePosition2);
        VBox buttons = new VBox(insert, extract, spiPosition, btnCount, btnClose);
        VBox list = new VBox(ausgabeListe);
        HBox horizontalBox = new HBox(buttons, list);
        VBox root = new VBox(eingabeZeile, horizontalBox, ausgabeZeile);
        root.getStyleClass().add("everything");

        StackPane stackPane = new StackPane(root, searchBar);
        StackPane.setAlignment(searchBar, javafx.geometry.Pos.CENTER);

        Scene sc = new Scene(stackPane, 400, 400);
        sc.getStylesheets().add("style.css");

        stage.setScene(sc);
        stage.setTitle("WarteSchlange (FirstList/FIFO)");
        stage.show();

        btnInsert.setOnAction(e -> {
            einfuegen(activePosition1, spiPosition, eingabeZeile, ausgabeListe);
            System.out.println(spiPosition.getValue() + " | " + liste.getAnzahl());

        });
        eingabeZeile.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                einfuegen(activePosition1, spiPosition, eingabeZeile, ausgabeListe);
                System.out.println(spiPosition.getValue() + " | " + liste.getAnzahl());
            }
        });
        btnRemove.setOnAction(e -> {
            entnehmen(activePosition2, ausgabeZeile, spiPosition, eingabeZeile, ausgabeListe);
            System.out.println(spiPosition.getValue() + " | " + liste.getAnzahl());

        });
        btnCount.setOnAction(e -> {
            if (!liste.listeLeer()) {
                ausgabeZeile.setText(""+liste.getAnzahl());
            }
        });
        btnClose.setOnAction(e -> stage.close());
        sc.setOnKeyPressed(e -> {
            if (e.isControlDown() && e.getCode().toString().equals("SPACE")) {
                if (!active) {
                    searchBar.setDisable(false);
                    searchBar.setVisible(true);
                    root.setDisable(true);
                    searchBar.requestFocus();
                    active = true;
                } else {
                    searchBar.setDisable(true);
                    searchBar.setVisible(false);
                    root.setDisable(false);
                    eingabeZeile.requestFocus();
                    active = false;
                }
            }
            if (active) if (!searchBar.getText().equals("")) if (e.getCode().toString().equals("ENTER")) {
                String input = searchBar.getText();
                searchBar.setDisable(true);
                searchBar.setVisible(false);
                root.setDisable(false);
                eingabeZeile.requestFocus();
                active = false;
                ausgabeZeile.setText((liste.suche(input) == null) ? "Patient nicht gefunden!" : liste.suche(input).getInfo() + " gefunden!");
            }
        });
    }

    private void entnehmen(RadioButton activePosition2, Label ausgabeZeile, Spinner<Integer> spiPosition, TextField eingabeZeile, TextArea ausgabeListe) {
        if (activePosition2.isSelected()) {
            if (!liste.listeLeer()) {
                ausgabeZeile.setText(liste.entnehmen(liste.suche(eingabeZeile.getText())));
                ausgabeListe.setText(liste.anzeigen());
                spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, liste.getAnzahl() +1, liste.getAnzahl() + 1));
            } else ausgabeZeile.setText("Liste ist leer!");
        } else {
            if (!liste.listeLeer()) {
                ausgabeZeile.setText(liste.entnehmen());
                ausgabeListe.setText(liste.anzeigen());
                spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, liste.getAnzahl() +1, liste.getAnzahl() + 1));
            } else ausgabeZeile.setText("Liste ist leer!");
        }
    }

    private void einfuegen(RadioButton activePosition1, Spinner<Integer> spiPosition, TextField eingabeZeile, TextArea ausgabeListe) {
        if (activePosition1.isSelected()) {
            liste.einfuegen(new Patient(eingabeZeile.getText(), (int) (Math.random()*100)), spiPosition.getValue());
            ausgabeListe.setText(liste.anzeigen());
            eingabeZeile.clear();
            spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, liste.getAnzahl() + 1, liste.getAnzahl() + 1));
        } else {
            liste.einfuegen(new Patient(eingabeZeile.getText(), (int) (Math.random()*100)));
            ausgabeListe.setText(liste.anzeigen());
            eingabeZeile.clear();
            spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, liste.getAnzahl() + 1, liste.getAnzahl() + 1));
        }
    }
}