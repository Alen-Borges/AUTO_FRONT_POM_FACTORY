package com.automatizacion.steps;

import com.automatizacion.pages.FormularioPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class FormularioSteps {

    FormularioPage formulario;

    @Given("que el usuario está en la pantalla de reporte de incidentes")
    public void elUsuarioEstaEnLaPantallaDeReporteDeIncidentes() {
        formulario.open();
    }

    @When("envía un reporte con los siguientes datos:")
    public void elUsuarioEnviaUnReporteConLosSiguientesDatos(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        formulario.ingresarEmail(row.get("email"));
        formulario.ingresarNumeroLinea(row.get("linea"));
        formulario.seleccionarTipoIncidente(row.get("tipo"));
        formulario.ingresarDescripcion(row.get("descripcion"));
        formulario.enviarFormulario();
    }

    @Then("el sistema debería confirmar que el reporte fue enviado exitosamente")
    public void elSistemaDeberiaConfirmarQueElReporteFueEnviadoExitosamente() {
        assertThat(formulario.esVisibleMensajeExito()).isTrue();
        assertThat(formulario.obtenerTextoMensajeExito()).contains("¡Reporte Enviado!");
    }
}
