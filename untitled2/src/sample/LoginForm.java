package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginForm  {

    Stage stage;
    //User user ;
    HomeScreen homescreen;
    Scene scene;


    public LoginForm(Stage stage){
        this.stage = stage;
    }


    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }

    public void prepareScene(){
        //user = new User(0);
        LoginAuthentication login = new LoginAuthentication();


        Label usernameLabel = new Label("username");
        Label passwordLabel = new Label("number pin");
        Label validationLabel = new Label();

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button submit = new Button("submit");

        GridPane grid = new GridPane();
        grid.setHgap(50);
        grid.setVgap(10);
        grid.add(usernameLabel, 0,0);
        grid.add(passwordLabel, 0,1);
        grid.add(usernameField, 1,0);
        grid.add(passwordField, 1,1);
        grid.add(submit, 1,2);
        grid.add(validationLabel, 1,3);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean valid = login.compareUsername(username);
            boolean validd =  login.comparePassword(password);
            if(valid){
               if(validd){
                 stage.setScene(homescreen.getScene());
               }else
                   validationLabel.setText("Wrong pin");
            }
            else
                validationLabel.setText("Wrong username");
            }
        });

        scene = new Scene(grid,600,400) ;
    }
    public Scene getScene() {
        return this.scene;
    }
}
