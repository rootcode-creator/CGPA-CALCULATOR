package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Register extends Application{
	
public void start(Stage primaryStage) throws Exception {
		
		//UI element
		
		Font font = Font.font("Arial Black", FontWeight.BOLD,12);
		Label usernameLabel=new Label("USERNAME");
		usernameLabel.setFont(font);
		TextField usernameTextFeildr= new TextField();
		usernameTextFeildr.setFont(font);
		StackPane pane = new StackPane();  
		Tooltip utool=new Tooltip();  
		utool.setText("Enter the username between 6 to 8 character ");  
		usernameTextFeildr.setTooltip(utool);  
		pane.getChildren().add(usernameTextFeildr);  
		
		Label passwordLabel=new Label("PASSWORD");
		passwordLabel.setFont(font);
		PasswordField passwordTextFeild = new  PasswordField();
		passwordTextFeild.setFont(font);
		Tooltip ptool=new Tooltip();  
		ptool.setText("Enter the password between 8 to 15 character");  
		passwordTextFeild.setTooltip(ptool);  
		pane.getChildren().add(passwordTextFeild);
		
		//clock
		
		
				final Label clock = new Label();
				clock.setFont(font);
				HBox clockh=new HBox(20,clock);
				clockh.setAlignment(Pos.CENTER_LEFT);
				final DateFormat format = DateFormat.getInstance();
				final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
				     @Override
				     public void handle(ActionEvent event) {
				          final Calendar cal = Calendar.getInstance();
				          clock.setText("Current Date and Time:"+format.format(cal.getTime()));
				     }
				}));
				timeline.setCycleCount(Animation.INDEFINITE);
				timeline.play();
		
		
		
		//Button
		
		Button logo= new Button();
		logo.setStyle("-fx-background-color:#F2F2F2");
		Image sceenlogo = new Image("Image/registrationLogo.png");
		
	    ImageView lview = new ImageView(sceenlogo );
	    logo.setGraphic(lview);
	    
		
		Button submit= new Button("LOGIN");
		//submit.setAlignment(Pos.BASELINE_LEFT);
		submit.setFont(font);
		Image simg = new Image("Image/loginn.png");
	    ImageView sview = new ImageView(simg);
	    submit.setGraphic(sview);
		Button register=new Button("REGISTER");
		Image rimg = new Image("Image/register.png");
	    ImageView rview = new ImageView(rimg);
	    register.setFont(font);
	    register.setGraphic(rview);
		//register.setAlignment(Pos.BASELINE_RIGHT);
		
	    
	    //Get Data From Field 
	    
	    
	    
	    
	    //Button Action
	    
	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Login l= new Login();
				try {
					l.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	    	
	    });
	    
	    register.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	ArrayList<String>usernamecheck=new ArrayList<String>();
	    	
			@Override
			public void handle(ActionEvent event) {
				
				
				String usernameget=usernameTextFeildr.getText().toString();
			    String passwordget=passwordTextFeild.getText().toString();
			    
				File registerfile=new File("USER.txt");
				try {
					if(registerfile.createNewFile()){
						System.out.println("File Created");
						
					}
					else
						System.out.println("File Already Created");
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String usernamestore;
				String passwordstore;
				try {
					FileReader loginreader=new FileReader("USER.txt");
					Scanner sc=new Scanner(loginreader);
					
					
					while(sc.hasNext()) {
						usernamestore =sc.next();
						passwordstore=sc.next();
						usernamecheck.add(String.valueOf(usernamestore));
						
					}
				}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
	    	
				try {	
					if(usernamecheck.contains(usernameTextFeildr.getText().toString())){
								
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("DUPLICATE USER");
						alert.setHeaderText(null);
						ImageView icon = new ImageView("Image/duplicate.png");
						alert.getDialogPane().setGraphic(icon);
						alert.setContentText("THRE IS ALREADY A USER WITH SAME NAME!");
						alert.showAndWait();
						System.out.println("Duplicated Feild");
					
					
						}
					
					
					else if(usernameTextFeildr.getText().toString().isEmpty()||passwordTextFeild.getText().toString().isEmpty()) {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("EMPTY FEILD");
							alert.setHeaderText(null);
							ImageView icon = new ImageView("Image/empty.png");
							alert.getDialogPane().setGraphic(icon);
							alert.setContentText("USERNAME OR PASSWORD IS EMPTY!");
							alert.showAndWait();
							System.out.println("Empty Feild");
							
							}
				
							else if(passwordget.length()<8||usernameget.length()<6){ 
							Alert palert = new Alert(AlertType.INFORMATION);
							palert.setTitle("USERNAME AND PASSWORD LENGTH");
							ImageView picon = new ImageView("Image/PASSWORD ERROR.png");
							palert.getDialogPane().setGraphic(picon);
							palert.setHeaderText(null);
							palert.setContentText("USERNAME AND PASSWORD SHOULD BE GREATER THAN 5,8 CHARACTERS, RESPECTIVELY!");
							palert.showAndWait();
					
							}
						
					
					else {
					System.out.println(usernameget+" "+passwordget +"\n");
					FileWriter registerfilewrite=new FileWriter("USER.txt",true);
					BufferedWriter registerwrite=new BufferedWriter(registerfilewrite);
					registerwrite.write(usernameget+" "+passwordget +"\n");
					registerwrite.close();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("CONFIRMATION");
					ImageView icon = new ImageView("Image/success.png");
					alert.getDialogPane().setGraphic(icon);
					alert.setHeaderText(null);
					alert.setContentText("REGISTRATION SUSSESSFUL!");
					alert.showAndWait();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Login l= new Login();
				try {
					l.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	    	
	    });
	    
	    
	    //Layout
		
		HBox username=new HBox(10,usernameLabel,usernameTextFeildr);
		username.setAlignment(Pos.CENTER);
		HBox password=new HBox(10,passwordLabel,passwordTextFeild);
		password.setAlignment(Pos.CENTER);
		HBox submitregister=new HBox(10,clockh,submit,register);
		submitregister.setAlignment(Pos.CENTER_RIGHT);
		VBox login=new VBox(35,logo,username,password,submitregister);
		login.setAlignment(Pos.CENTER);
		
		//Scene
		
		Scene sc=new Scene(login,685,420);
		
		//Stage
		
		Image image = new Image("Image/Registration_Background.jpg");
		BackgroundImage bImg = new BackgroundImage(image,
				BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		login.setBackground(bGround);
		primaryStage.getIcons().add(new Image("Image/registrationIcon.png"));
		primaryStage.setTitle("Registration Window");
		primaryStage.setScene(sc);
		primaryStage.setX(350);
		primaryStage.setY(145);
		primaryStage.setMaxWidth(685);
		primaryStage.setMaxHeight(420);
		primaryStage.setMinWidth(685);
		primaryStage.setMinHeight(420);
		primaryStage.show();
		
		
		
	}
	


	
}
