import controller.MenuInicialController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MenuInicialController menuInicialController = new MenuInicialController();
        menuInicialController.inicia();
    }
}