package es.uah.trabajo.juegodelavida.VentanaPrincipal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPrincipalControler implements Initializable {
    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/

    @FXML
    private Slider sliderVelocidad;
    @FXML
    private Slider sliderVida;
    @FXML
    private TextField textfieldNombre;
    @FXML
    private TextField textfieldApellido;


    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    private VentanaPrincipalDataProperties model;
    private Stage scene;


    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */


    @FXML
    protected void onBotonGuardarClick() {
        model.commit();
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
    }

    @FXML protected void onBotonCerrarClick(){
        scene.close();
    }

    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");

        if (model != null) {
            this.updateGUIwithModel();
        }
    }

    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        sliderVelocidad.valueProperty().bindBidirectional(model.velocidadProperty());
        sliderVida.valueProperty().bindBidirectional(model.vidaProperty());
        textfieldNombre.textProperty().bindBidirectional(model.nombreProperty());
        textfieldApellido.textProperty().bindBidirectional(model.appelidoProperty());
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(VentanaPrincipalDataProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s){
        this.scene = s;
    }
}


