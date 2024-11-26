import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Queue_GUI extends Application {
    Queue list = new Queue();
    boolean active = false;
    // Queue FIFO

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button btnInsert = new Button("Insert");
        btnInsert.getStyleClass().add("insert-button");
        RadioButton activePosition1 = new RadioButton();
        Button btnRemove = new Button("Remove");
        btnRemove.getStyleClass().add("remove-button");
        RadioButton activePosition2 = new RadioButton();
//        activePosition2.setDisable(true);
        Spinner<Integer> spiPosition = new Spinner<>(1, list.count() + 1, list.count() + 1);
        spiPosition.getStyleClass().add("position-spinner");
        spiPosition.setEditable(true);
        Button btnCount = new Button("Count");
        btnCount.getStyleClass().add("count-button");
        Button btnClose = new Button("Close");
        btnClose.getStyleClass().add("close-button");

        TextField inputField = new TextField();
        inputField.getStyleClass().add("input-field");
        TextArea outputList = new TextArea();
        outputList.getStyleClass().add("output-list");
        Label outputField = new Label("waiting...");
        outputField.getStyleClass().add("output-field");
        outputList.setPrefSize(200, 200);
        outputList.setEditable(false);
        TextField searchBar = new TextField();
        searchBar.getStyleClass().add("search-bar");
        searchBar.setDisable(true);
        searchBar.setVisible(false);

        HBox insert = new HBox(btnInsert, activePosition1);
        HBox extract = new HBox(btnRemove, activePosition2);
        VBox buttons = new VBox(insert, extract, spiPosition, btnCount, btnClose);
        VBox list = new VBox(outputList);
        HBox horizontalBox = new HBox(buttons, list);
        VBox root = new VBox(inputField, horizontalBox, outputField);
        root.getStyleClass().add("everything");

        StackPane stackPane = new StackPane(root, searchBar);
        StackPane.setAlignment(searchBar, javafx.geometry.Pos.CENTER);

        Scene sc = new Scene(stackPane, 400, 400);
        sc.getStylesheets().add("style.css");

        stage.setScene(sc);
        stage.setTitle("Queue (FirstList/FIFO)");
        stage.show();

        btnInsert.setOnAction(e -> {
            insert(activePosition1, spiPosition, inputField, outputList);
            System.out.println(spiPosition.getValue() + " | " + this.list.count());

        });
        inputField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                insert(activePosition1, spiPosition, inputField, outputList);
                System.out.println(spiPosition.getValue() + " | " + this.list.count());
            }
        });
        btnRemove.setOnAction(e -> {
            remove(activePosition2, outputField, spiPosition, inputField, outputList);
            System.out.println(spiPosition.getValue() + " | " + this.list.count());

        });
        btnCount.setOnAction(e -> {
            if (this.list.nonEmptyList()) {
                outputField.setText(""+ this.list.count());
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
                    inputField.requestFocus();
                    active = false;
                }
            }
            if (active) if (!searchBar.getText().isEmpty()) if (e.getCode().toString().equals("ENTER")) {
                String input = searchBar.getText();
                searchBar.setDisable(true);
                searchBar.setVisible(false);
                root.setDisable(false);
                inputField.requestFocus();
                active = false;
                outputField.setText((this.list.search(input) == null) ? "Patient not found!" : this.list.search(input).getInfo() + " found!");
            }
        });
    }

    private void remove(RadioButton activePosition2, Label outputField, Spinner<Integer> spiPosition, TextField inputField, TextArea outputList) {
        if (activePosition2.isSelected()) {
            if (list.nonEmptyList()) {
                outputField.setText(list.removeSpecified(list.search(inputField.getText())).getInfo());
                outputList.setText(list.display());
                spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, list.count() +1, list.count() + 1));
            } else outputField.setText("List empty!");
        } else {
            if (list.nonEmptyList()) {
                outputField.setText(list.removeFirst().getInfo());
                outputList.setText(list.display());
                spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, list.count() +1, list.count() + 1));
            } else outputField.setText("List empty!");
        }
    }

    private void insert(RadioButton activePosition1, Spinner<Integer> spiPosition, TextField inputField, TextArea outputList) {
        if (activePosition1.isSelected()) {
            list.insertAtNumber(new Patient(inputField.getText(), (int) (Math.random()*100)), spiPosition.getValue());
        } else {
            list.insertInBack(new Patient(inputField.getText(), (int) (Math.random()*100)));
        }
        outputList.setText(list.display());
        inputField.clear();
        spiPosition.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, list.count() + 1, list.count() + 1));
    }
}