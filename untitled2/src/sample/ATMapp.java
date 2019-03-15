package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATMapp extends Application {

    public static void main(String[]args){

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ATM");

        LoginForm login = new LoginForm(primaryStage);
        HomeScreen homescreen = new HomeScreen(primaryStage);


        login.prepareScene();
        homescreen.prepareScene();

        login.setHomescreen(homescreen);
        homescreen.setLoginForm(login);

        primaryStage.setScene(login.getScene());
        primaryStage.show();



    }
}
