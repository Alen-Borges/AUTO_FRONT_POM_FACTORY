package com.automatizacion.steps;

import com.automatizacion.pages.TicketsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class TicketsSteps {

    TicketsPage ticketsPage;

    @Given("que el usuario está en el dashboard de tickets")
    public void queElUsuarioEstaEnElDashboardDeTickets() {
        ticketsPage.open();
    }

    @Then("la tabla debería mostrar al menos un ticket")
    public void laTablaDeberiaMostrarAlMenosUnTicket() {
        assertThat(ticketsPage.tablaContieneTickets()).isTrue();
    }

    @When("filtra los tickets por estado {string}")
    public void filtraLosTicketsPorEstado(String estado) {
        ticketsPage.filtrarPorEstado(estado);
    }

    @Then("solo deberían mostrarse tickets con estado {string}")
    public void soloDeberianMostrarseTicketsConEstado(String estado) {
        assertThat(ticketsPage.todasLasFilasTienenEstado(estado)).isTrue();
    }
}
