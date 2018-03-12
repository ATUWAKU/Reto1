/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controles.RepositorioControles;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jesmuner
 */
public class PgVisitanos {

    /*CONSTRUCTOR*/
    public PgVisitanos(WebDriver Driver) {
        strDireccion = "";
        strCiudad = "";
        _objDriver = Driver;
    }
    
    /*Atributos*/
    private String strDireccion;
    private String strCiudad;
    WebDriver _objDriver;

    /*PROPIEDADES*/
    public void setDirección(String strDirección) {
        this.strDireccion = strDirección;
    }

    public void setCiudad(String strCiudad) {
        this.strCiudad = strCiudad;
    }
    
    /*Métodos Publicos*/
    public boolean IingresarDireccion() throws Exception
    {
        try {
            WebElement Direccion = _objDriver.findElement(By.id(RepositorioControles.PagVisitanos.strtxtDireccion));
            Direccion.sendKeys(strDireccion + " " + strCiudad);
            return true;
            
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean PresionarBotonBuscar() throws Exception
    {
        try {
            
             WebElement BotonBuscar = _objDriver.findElement(By.xpath(RepositorioControles.PagVisitanos.strbtnBuscar));
            BotonBuscar.click();
            
              return true;
            
        } catch (Exception e) {
            throw e;
        }
    }
    public boolean SelecSucursal() throws Exception
    {
        try {            
            WebElement PrimeraSuc = _objDriver.findElement(By.xpath(RepositorioControles.PagVisitanos.strPrimSuc));
            PrimeraSuc.click();
            
            return true;
            
        } catch (Exception e) {
            throw e;
        }
    }
}
