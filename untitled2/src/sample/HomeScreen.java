package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jetbrains.debugger.values.StringValue;

public class HomeScreen {

    Stage stage;
    User user = new User(0);
    Scene scene;
    LoginForm loginForm;
    History h = new History();
    Scene scene2;
    Scene scene3;
    boolean Flag = true;

        public HomeScreen(Stage stage){
            this.stage = stage;
        }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public Scene getScene(){
        return scene;
    }
    public void prepareScene(){


        //homescreen objects
        Button logout = new Button("Logout");
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        Label history = new Label();
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Button balance = new Button(("Balance Inquiry"));

        //grids
        GridPane grid =  new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        scene2 = new Scene(grid2,500,500);
        scene3 = new Scene(grid3,500,500);

        //homescreen layout
        grid.setHgap(60);
        grid.setVgap(40);
        grid.add(logout,3,2);
        grid.add(deposit,0,0);
        grid.add(withdraw,1,0);
        grid.add(history,0,2);
        grid.add(previous,0,1);
        grid.add(next,1,1);
        grid.add(balance,2,0);

        //scene 2/3 objects
        Button goBack = new Button("Go Back to menu");
        Button goBack2 = new Button("go Back to menu");
        //deposit then withdraw
        Button zero = new Button("0");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero1 = new Button("0");
        Button one1 = new Button("1");
        Button two1 = new Button("2");
        Button three1 = new Button("3");
        Button four1 = new Button("4");
        Button five1 = new Button("5");
        Button six1 = new Button("6");
        Button seven1 = new Button("7");
        Button eight1 = new Button("8");
        Button nine1 = new Button("9");
        Button submitDeposit = new Button("submit your Deposit");
        Button submitWithdraw = new Button("submit your Withdrawl");
        Label number = new Label();
        Label number2 = new Label();
        Label alert = new Label();
        Label alert2 = new Label();

        //scene 2 layout dep

        grid2.add(goBack,3,5);
        grid2.add(one,0,0);
        grid2.add(two,1,0);
        grid2.add(three,2,0);
        grid2.add(four,0,1);
        grid2.add(five,1,1);
        grid2.add(six,2,1);
        grid2.add(seven,0,2);
        grid2.add(eight,1,2);
        grid2.add(nine,2,2);
        grid2.add(zero,1,3);
        grid2.add(submitDeposit,3,4);
        grid2.add(number,3,0);
        grid2.add(alert,0,5);
        //scene 3 layout with
        grid3.add(goBack2,3,5);
        grid3.add(one1,0,0);
        grid3.add(two1,1,0);
        grid3.add(three1,2,0);
        grid3.add(four1,0,1);
        grid3.add(five1,1,1);
        grid3.add(six1,2,1);
        grid3.add(seven1,0,2);
        grid3.add(eight1,1,2);
        grid3.add(nine1,2,2);
        grid3.add(zero1,1,3);
        grid3.add(submitWithdraw,3,4);
        grid3.add(number2,3,0);
        grid3.add(alert2,3,6);

        //Handling buttons scene 1
        balance.setOnAction(e -> history.setText(String.valueOf(user.getBalance())));
        next.setOnAction(e ->history.setText(h.historyNext()));
        previous.setOnAction(e ->history.setText(h.historyPrevious()));
        deposit.setOnAction(e ->stage.setScene(scene2));
        withdraw.setOnAction(e->{
            stage.setScene(scene3);
            alert2.setText("");
        });

        //Handling buttons scene 2
        goBack.setOnAction(e ->{
            stage.setScene(scene);});
        submitDeposit.setOnAction(e->{
            if(number.getText().equals(null) || number.getText().isEmpty()){
                number.setText("0");
            }
            User.deposit(Double.valueOf(number.getText()));    //parsing
            number.setText("");

        });
        one.setOnAction(e->number.setText(number.getText()+"1"));
        two.setOnAction(e->number.setText(number.getText()+"2"));
        three.setOnAction(e->number.setText(number.getText()+"3"));
        four.setOnAction(e->number.setText(number.getText()+"4"));
        five.setOnAction(e->number.setText(number.getText()+"5"));
        six.setOnAction(e->number.setText(number.getText()+"6"));
        seven.setOnAction(e->number.setText(number.getText()+"7"));
        eight.setOnAction(e->number.setText(number.getText()+"8"));
        nine.setOnAction(e->number.setText(number.getText()+"9"));
        zero.setOnAction(e->number.setText(number.getText()+"0"));
        //Handling buttons scene 3
        goBack2.setOnAction(e -> {
            stage.setScene(scene);});
        submitWithdraw.setOnAction(e->{
            if(number2.getText().equals(null) || number2.getText().isEmpty()){
                number2.setText("0");
            }
            if (Double.valueOf(number2.getText()) > user.getBalance()) {
                    alert2.setText("Insufficient funds");
                    number2.setText("");
                }
            else{
                user.withdrawl(Double.valueOf(number2.getText()));    //parsing
                number2.setText("");
            }

        });
        one1.setOnAction(e->number2.setText(number2.getText()+"1"));
        two1.setOnAction(e->number2.setText(number2.getText()+"2"));
        three1.setOnAction(e->number2.setText(number2.getText()+"3"));
        four1.setOnAction(e->number2.setText(number2.getText()+"4"));
        five1.setOnAction(e->number2.setText(number2.getText()+"5"));
        six1.setOnAction(e->number2.setText(number2.getText()+"6"));
        seven1.setOnAction(e->number2.setText(number2.getText()+"7"));
        eight1.setOnAction(e->number2.setText(number2.getText()+"8"));
        nine1.setOnAction(e->number2.setText(number2.getText()+"9"));
        zero1.setOnAction(e->number2.setText(number2.getText()+"0"));

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginForm.getScene());
            }
        });

        scene = new Scene(grid,500,300);
    }

}
