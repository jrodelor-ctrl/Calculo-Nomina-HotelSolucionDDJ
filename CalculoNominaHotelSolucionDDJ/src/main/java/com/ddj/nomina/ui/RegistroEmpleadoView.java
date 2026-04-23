/**
 * Vista encargada del registro de empleados.
 * Permite crear empleados de distintos tipos a partir de los datos ingresados.
 */
package com.ddj.nomina.ui;

import com.ddj.nomina.model.Empleado;
import com.ddj.nomina.model.EmpleadoAsalariado;
import com.ddj.nomina.model.EmpleadoPorComision;
import com.ddj.nomina.model.EmpleadoPorHoras;
import com.ddj.nomina.model.EmpleadoTemporal;
import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.EmpleadoRepository;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RegistroEmpleadoView {

    private final AppNavigator navigator;
    private final Usuario usuario;
    private final EmpleadoRepository empleadoRepository;
    private final BorderPane root;

    public RegistroEmpleadoView(AppNavigator navigator, Usuario usuario, EmpleadoRepository empleadoRepository) {
        this.navigator = navigator;
        this.usuario = usuario;
        this.empleadoRepository = empleadoRepository;
        this.root = construirVista();
    }

    public Parent getView() {
        return root;
    }

    private BorderPane construirVista() {
        BorderPane pane = new BorderPane();
        pane.setBackground(new Background(new BackgroundFill(
                Color.web("#e2e8f0"), CornerRadii.EMPTY, Insets.EMPTY
        )));

        Label titulo = new Label("Registro de Empleados - Hotel Solución DDJ");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setTextFill(Color.web("#0f172a"));

        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> navigator.showDashboard(usuario));

        HBox top = new HBox(20, titulo, btnVolver);
        top.setAlignment(Pos.CENTER_LEFT);
        top.setPadding(new Insets(20));
        pane.setTop(top);

        GridPane form = new GridPane();
        form.setHgap(12);
        form.setVgap(12);
        form.setPadding(new Insets(20));

        TextField txtId = new TextField();
        TextField txtNombre = new TextField();
        TextField txtIdentificacion = new TextField();
        TextField txtAnios = new TextField();
        TextField txtSalarioBase = new TextField();
        TextField txtHoras = new TextField();
        TextField txtTarifaHora = new TextField();
        TextField txtVentas = new TextField();
        TextField txtPorcentajeComision = new TextField();
        CheckBox chkFondo = new CheckBox("Acepta fondo de ahorro");

        ComboBox<String> cmbTipo = new ComboBox<>(FXCollections.observableArrayList(
                "Asalariado", "PorHoras", "PorComision", "Temporal"
        ));
        cmbTipo.setValue("Asalariado");

        Label mensaje = new Label();

        form.add(new Label("ID:"), 0, 0);
        form.add(txtId, 1, 0);

        form.add(new Label("Nombre:"), 0, 1);
        form.add(txtNombre, 1, 1);

        form.add(new Label("Identificación:"), 0, 2);
        form.add(txtIdentificacion, 1, 2);

        form.add(new Label("Años en la empresa:"), 0, 3);
        form.add(txtAnios, 1, 3);

        form.add(new Label("Tipo de empleado:"), 0, 4);
        form.add(cmbTipo, 1, 4);

        form.add(new Label("Salario base:"), 0, 5);
        form.add(txtSalarioBase, 1, 5);

        form.add(new Label("Horas trabajadas:"), 0, 6);
        form.add(txtHoras, 1, 6);

        form.add(new Label("Tarifa por hora:"), 0, 7);
        form.add(txtTarifaHora, 1, 7);

        form.add(new Label("Ventas:"), 0, 8);
        form.add(txtVentas, 1, 8);

        form.add(new Label("Porcentaje comisión:"), 0, 9);
        form.add(txtPorcentajeComision, 1, 9);

        form.add(chkFondo, 1, 10);

        Button btnGuardar = new Button("Guardar empleado");
        btnGuardar.setStyle(
                "-fx-background-color: #1d4ed8;"
                + "-fx-text-fill: white;"
                + "-fx-font-weight: bold;"
                + "-fx-background-radius: 12;"
        );

        btnGuardar.setOnAction(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                String identificacion = txtIdentificacion.getText().trim();
                int anios = Integer.parseInt(txtAnios.getText().trim());

                String tipo = cmbTipo.getValue();
                Empleado empleado;

                switch (tipo) {
                    case "Asalariado":
                        empleado = new EmpleadoAsalariado(
                                id, nombre, identificacion, anios,
                                Double.parseDouble(txtSalarioBase.getText().trim())
                        );
                        break;
                    case "PorHoras":
                        empleado = new EmpleadoPorHoras(
                                id, nombre, identificacion, anios,
                                Double.parseDouble(txtTarifaHora.getText().trim()),
                                Double.parseDouble(txtHoras.getText().trim()),
                                chkFondo.isSelected()
                        );
                        break;
                    case "PorComision":
                        empleado = new EmpleadoPorComision(
                                id, nombre, identificacion, anios,
                                Double.parseDouble(txtSalarioBase.getText().trim()),
                                Double.parseDouble(txtVentas.getText().trim()),
                                Double.parseDouble(txtPorcentajeComision.getText().trim())
                        );
                        break;
                    case "Temporal":
                        empleado = new EmpleadoTemporal(
                                id, nombre, identificacion, anios,
                                Double.parseDouble(txtSalarioBase.getText().trim())
                        );
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de empleado no válido.");
                }

                empleadoRepository.guardar(empleado);
                mensaje.setTextFill(Color.GREEN);
                mensaje.setText("Empleado registrado correctamente.");

                txtId.clear();
                txtNombre.clear();
                txtIdentificacion.clear();
                txtAnios.clear();
                txtSalarioBase.clear();
                txtHoras.clear();
                txtTarifaHora.clear();
                txtVentas.clear();
                txtPorcentajeComision.clear();
                chkFondo.setSelected(false);

            } catch (Exception ex) {
                mensaje.setTextFill(Color.RED);
                mensaje.setText("Error: " + ex.getMessage());
            }
        });

        VBox center = new VBox(15, form, btnGuardar, mensaje);
        center.setPadding(new Insets(20));
        pane.setCenter(center);

        return pane;
    }
}