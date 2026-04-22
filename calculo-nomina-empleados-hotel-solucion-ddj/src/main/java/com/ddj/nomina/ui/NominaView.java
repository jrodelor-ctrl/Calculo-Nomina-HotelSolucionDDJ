package com.ddj.nomina.ui;

import com.ddj.nomina.model.Empleado;
import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.EmpleadoRepository;
import com.ddj.nomina.service.NominaService;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Vista para cálculo de nómina.
 */
public class NominaView {

    private BorderPane root;

    public NominaView(AppNavigator nav, Usuario usuario,
                      EmpleadoRepository repo, NominaService nomina) {

        root = new BorderPane();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        ComboBox<Empleado> combo = new ComboBox<>();
        combo.setItems(FXCollections.observableArrayList(repo.listar()));

        TextArea resultado = new TextArea();

        Button calcular = new Button("Calcular Nómina");

        calcular.setOnAction(e -> {
            Empleado emp = combo.getValue();
            if (emp != null) {
                resultado.setText(nomina.generarResumenNomina(emp));
            } else {
                resultado.setText("Seleccione un empleado.");
            }
        });

        Button volver = new Button("Volver");
        volver.setOnAction(e -> nav.showDashboard(usuario));

        layout.getChildren().addAll(
                new Label("Seleccione empleado:"),
                combo,
                calcular,
                resultado,
                volver
        );

        root.setCenter(layout);
    }

    public Parent getView() {
        return root;
    }
}