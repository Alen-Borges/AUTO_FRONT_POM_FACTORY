package com.automatizacion.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

@DefaultUrl("http://localhost/dashboard")
public class TicketsPage extends PageObject {

    @FindBy(css = "table tbody tr")
    private List<WebElement> filasTickets;

    @FindBy(id = "filter-status")
    private WebElement filtroEstado;

    @FindBy(id = "filter-priority")
    private WebElement filtroPrioridad;

    @FindBy(css = "td:nth-child(6) span")
    private List<WebElement> etiquetasEstado;

    public int obtenerCantidadTickets() {
        return filasTickets.size();
    }

    public boolean tablaContieneTickets() {
        return !filasTickets.isEmpty();
    }

    public void filtrarPorEstado(String estado) {
        Select select = new Select(filtroEstado);
        select.selectByVisibleText(estado);
    }

    public boolean todasLasFilasTienenEstado(String estado) {
        for (WebElement etiqueta : etiquetasEstado) {
            if (!etiqueta.getText().equalsIgnoreCase(estado)) {
                return false;
            }
        }
        return true;
    }
}
