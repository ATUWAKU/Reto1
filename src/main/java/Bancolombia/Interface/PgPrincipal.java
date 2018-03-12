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
public class PgPrincipal {

    /*Constructor*/
    public PgPrincipal(WebDriver Driver) {
        
        _objDriver = Driver;

    }
    
    /*Atributos*/
    WebDriver _objDriver;
    
    /*Métodos Públicos*/
    public boolean SelecVisitanos() throws Exception
    {
        try {
            
            WebElement Visitanos = _objDriver.findElement(By.xpath(RepositorioControles.PagInicial.strimgVisitanos));
            Visitanos.click();
            
            return true;
            
        } catch (Exception e) {
            throw e;
        }
    }
}
