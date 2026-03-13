package com.automatizacion.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost")
public class FormularioPage extends PageObject {

    @FindBy(id = "email")
    private WebElement campoEmail;

    @FindBy(id = "lineNumber")
    private WebElement campoNumeroLinea;

    @FindBy(id = "incidentType")
    private WebElement selectTipoIncidente;

    @FindBy(id = "description")
    private WebElement campoDescripcion;

    @FindBy(css = "button[type='submit']")
    private WebElement botonEnviar;

    @FindBy(xpath = "//h2[contains(text(), '¡Reporte Enviado!')]")
    private WebElement mensajeExito;

    public void ingresarEmail(String email) {
        campoEmail.clear();
        campoEmail.sendKeys(email);
    }

    public void ingresarNumeroLinea(String numero) {
        campoNumeroLinea.clear();
        campoNumeroLinea.sendKeys(numero);
    }

    public void seleccionarTipoIncidente(String tipo) {
        selectTipoIncidente.sendKeys(tipo);
    }

    public void ingresarDescripcion(String descripcion) {
        campoDescripcion.clear();
        campoDescripcion.sendKeys(descripcion);
    }

    public void enviarFormulario() {
        botonEnviar.click();
    }

    public boolean esVisibleMensajeExito() {
        return mensajeExito.isDisplayed();
    }

    public String obtenerTextoMensajeExito() {
        return mensajeExito.getText();
    }
}