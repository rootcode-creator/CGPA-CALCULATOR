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
import javafx.event.Event;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AddCourse extends Application  {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Font font = Font.font("Arial Black", FontWeight.BOLD,30);
		Font font1 = Font.font("Arial Black", FontWeight.BOLD,12);
		Font font2 = Font.font("Arial Black", FontWeight.BOLD,16);	
		//NO OF COURSE CODEING
		 Label courseadd=new Label("NO OF COURSE(INTEGER FORMAT)");
		 courseadd.setFont(font2);
		
		 TextField courseaddTextFeild= new TextField();
		 courseaddTextFeild.setFont(font);
		 courseaddTextFeild.setMaxWidth(300);
		 StackPane pane = new StackPane();  
		 Tooltip utool=new Tooltip();  
		 utool.setText("ENTER NO OF COURSE");  
		 courseaddTextFeild.setTooltip(utool);  
		 pane.getChildren().add(courseaddTextFeild);  
		 
		 Button addcourse=new Button("");
		 //calculate.setStyle("-fx-background-color:#F2F2F2");
		 Image addcourseicon = new Image("Image/addbuttonicon.png");	
		 ImageView addcourseview = new ImageView(addcourseicon );
		 addcourse.setGraphic(addcourseview);
		 addcourse.setFont(font2);
		 
		 //FILE CREATE
		 
		 File gradedetails=new File("STUDENT GRADE INFORMATION.txt");
		 try {
			   if(gradedetails.createNewFile()){
			   System.out.println("File Created");
					
			 }
			  else
			  System.out.println("File Already Created");
		 	}catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 FileWriter fr;
		try {
			fr = new FileWriter("STUDENT GRADE INFORMATION.txt");
			fr.write("");
			fr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
		 //DATA CHECKING OF ADD BUTTON
		 addcourse.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if(courseaddTextFeild.getText().toString().isEmpty()) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("EMPTY FEILD");
						alert.setHeaderText(null);
						ImageView icon = new ImageView("Image/empty.png");
						alert.getDialogPane().setGraphic(icon);
						alert.setContentText("YOU HAVE NOT ENTERED ANY DATA!");
						alert.showAndWait();
						System.out.println("Empty Feild");
					}
					
					else 
					{
						
						
						int No_OF_COURSE=Integer.valueOf(courseaddTextFeild.getText().toString());
					
						CgpaCalculator calculator=new CgpaCalculator(No_OF_COURSE);
						 
						try {
							calculator.start(primaryStage);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						
					
				 
						
						
					}
					
				}
		    	
		    });
		 
		 	
		 
		 VBox addbutton=new VBox(addcourse);
		 addbutton.setAlignment(Pos.CENTER);
		
		 VBox courseaddlevel=new VBox(courseadd);
		 courseaddlevel.setAlignment(Pos.CENTER);
		 
		 VBox courseaddalign=new VBox(25,courseaddlevel, courseaddTextFeild,addbutton);
		 courseaddalign.setAlignment(Pos.CENTER);
		
		 Scene sc=new Scene(courseaddalign,626,417);
			
			//Stage
			
			Image image = new Image("Image/addcoursebackground.jpg");
			BackgroundImage bImg = new BackgroundImage(image,
					BackgroundRepeat.NO_REPEAT, 
	             BackgroundRepeat.NO_REPEAT, 
	             BackgroundPosition.DEFAULT, 
	             BackgroundSize.DEFAULT);
			Background bGround = new Background(bImg);
			courseaddalign.setBackground(bGround);
			primaryStage.getIcons().add(new Image("Image/addcourseicon.png"));
			primaryStage.setTitle("ADD COURSE WINDOW");
			primaryStage.setScene(sc);
			primaryStage.setX(300);
			primaryStage.setY(145);
			primaryStage.setMaxWidth(626);
			primaryStage.setMaxHeight(417);
			primaryStage.setMinWidth(626);
			primaryStage.setMinHeight(417);
			primaryStage.show();
		
		
		
		
	}
	

	
}
