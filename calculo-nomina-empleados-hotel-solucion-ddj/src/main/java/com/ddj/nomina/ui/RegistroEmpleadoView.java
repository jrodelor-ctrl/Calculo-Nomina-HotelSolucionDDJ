package com.ddj.nomina.ui;

import com.ddj.nomina.model.*;
import com.ddj.nomina.service.EmpleadoRepository;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RegistroEmpleadoView {

    private BorderPane root;

    public RegistroEmpleadoView(AppNavigator nav, Usuario usuario, EmpleadoRepository repo) {
        root = new BorderPane();

        VBox form = new VBox(10);
        form.setPadding(new Insets(20));

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre");

        TextField id = new TextField();
        id.setPromptText("ID");

        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Asalariado", "PorHoras");
        tipo.setValue("Asalariado");

        Button guardar = new Button("Guardar");

        guardar.setOnAction(e -> {
            try {
                Empleado emp;

                if (tipo.getValue().equals("Asalariado")) {
                    emp = new EmpleadoAsalariado(
                            Integer.parseInt(id.getText()),
                            nombre.getText(),
                            "CC",
                            6,
                            3000000
                    );
                } else {
                    emp = new EmpleadoPorHoras(
                            Integer.parseInt(id.getText()),
                            nombre.getText(),
                            "CC",
                            2,
                            20000,
                            45,
                            true
                    );
                }

                repo.guardar(emp);
                new Alert(Alert.AlertType.INFORMATION, "Empleado guardado").show();

            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        });

        form.getChildren().addAll(nombre, id, tipo, guardar);
        root.setCenter(form);
    }

    public Parent getView() {
        return root;
    }
}