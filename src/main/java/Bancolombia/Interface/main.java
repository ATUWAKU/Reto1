package Bancolombia.Interface;

import Controles.RepositorioControles;
import Interfaces.PgPrincipal;
import Interfaces.PgVisitanos;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main {

    /*VARIABLES GLOBALES*/
    static String strDireccion = "";
    static String strCiudad = "";
    static WebDriver objDriver;

    /*Controles*/
    /*MÉTODOS PRIVADOS*/
    private static boolean Validar() {
        try {
            if (strDireccion == null) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la dirección");
                return false;
            }
            if (strCiudad == null && !strDireccion.contains(strCiudad)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la ciudad");
                return false;
            }
            return true;

        } catch (Exception e) {

            System.out.println("EXCEPCIÓN: " + e.getMessage());
            return false;
        }
    }

    private static boolean AbrirNavegador(String URL) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Users\\jesmuner\\Documents\\NetBeansProjects/chromedriver.exe");
            objDriver = new ChromeDriver();
            objDriver.get(URL);

            return true;

        } catch (Exception e) {
            System.out.println("EXCEPCIÓN: " + e.getMessage());
            return false;

        }
    }

    private static void BuscarOficina() {
        try {

            do {
                strDireccion = JOptionPane.showInputDialog("Ingrese la dirección");
                strCiudad = JOptionPane.showInputDialog("En qué ciudad estás");
            } while (!Validar());

            if (!AbrirNavegador("https://www.grupobancolombia.com")) {
                return;
            }

            PgPrincipal _objPgPpal = new PgPrincipal(objDriver);

            if (!_objPgPpal.SelecVisitanos()) {
                return;
            }

            PgVisitanos _objPgVisi = new PgVisitanos(objDriver);

            _objPgVisi.setDirección(strDireccion);
            _objPgVisi.setCiudad(strCiudad);

            if (!_objPgVisi.IingresarDireccion()) {
                return;
            }
            if (!_objPgVisi.PresionarBotonBuscar()) {
                return;
            }
            Thread.sleep(10000);
            if (!_objPgVisi.SelecSucursal()) {
                return;
            }

        } catch (Exception e) {

            System.out.println("EXCEPCIÓN: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BuscarOficina();
    }
}
