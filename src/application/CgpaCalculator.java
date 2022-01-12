package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CgpaCalculator extends Application {
	int NO_OF_COURSE;
	public CgpaCalculator() {
		
		}
	
	public CgpaCalculator(int NO_OF_COURSE) {
		
		this.NO_OF_COURSE = NO_OF_COURSE;
		}


public void start(Stage primaryStage) throws Exception {
		
		
	
		//UI element
		
		 Font font = Font.font("Arial Black", FontWeight.BOLD,30);
		 Font font1 = Font.font("Arial Black", FontWeight.BOLD,12);
		 Font font2 = Font.font("Arial Black", FontWeight.BOLD,16);
		  
		
	     
	     
		 
		 
		 Label calculatorlevel=new Label("CGPA CALCULATOR");
	     calculatorlevel.setFont(font);
	     
	     //result
	    
	     
	     
	     //Flowplane 
	     
	     //Array
	     
	     String [] course={"ENG102","ENG103","ENG111","PHI101","PHI104","LBA101","LBA102","POL101","POL104","ECO101","ECO104","SOC101","ENV203/GEO205","ANT101","BIO103","MAT116","MAT120","MAT125","MAT130","MAT250","MAT350","MAT361","PHY107","PHY108","CHE101","EEE452","CEE110","CSE115","CSE115L","CSE173","CSE215","CSE215L","CSE225","CSE225L","CSE231","CSE231L","CSE299","EEE141","EEE141L","EEE111","EEE111L","CSE311","CSE311L","CSE323","CSE327","CSE331","CSE331L","CSE332","CSE373","CSE325/CSE425","CSE498","CSE499A","CSE499B","CSE417","CSE401","CSE418","CSE426","CSE473","CSE491","CSE411","CSE424","CSE427","CSE428","CSE429","CSE492","CSE422","CSE438","CSE482","CSE485","CSE486","CSE493","CSE494","CSE433","CSE435","CSE413","CSE414","CSE419","CSE440","CSE445","CSE465","CSE467","CSE468","CSE470","CSE495","CSE446","CSE447","CSE448","CSE449","CSE496"};
	     String [] credit= {"0","1","1.5","3","4","4.5","6"};
	     String [] grades= {"A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
	     
	     //Pane 
	     GridPane root=new GridPane(); 
	     
	     
	     //File Create
	     
		 	
			try { 
		 	for (int i=0; i < NO_OF_COURSE; i++)  {
	    	 ComboBox coursedata;
	    	 ComboBox creditdata;
	    	 ComboBox gradedata;
	    	 
	    	 
	    	 root.addRow(i, new Button("COURSE " + (int)(i + 1)),coursedata=new ComboBox(FXCollections.observableArrayList(course)),creditdata=new ComboBox(FXCollections.observableArrayList(credit)),gradedata=new ComboBox(FXCollections.observableArrayList(grades)));  
	    	 
	    	 
	    	 
	    	 coursedata.setPromptText("SELECT COURSE");
	    	 
	    	 
	    	 creditdata.setPromptText("SELECT CREDIT");
	    	 
	    	 gradedata.setPromptText("SELECT GRADE");
	    	 
	    
	    	 
	    	 
	    	 coursedata.setOnAction((event) -> {
	    	 
		     int selectedIndex = coursedata.getSelectionModel().getSelectedIndex();
		     Object selectedItem = coursedata.getSelectionModel().getSelectedItem();
		     System.out.println(selectedItem);
		     System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
		     System.out.println("   ComboBox.getValue(): " +coursedata.getValue());
		     
		   
		     FileWriter fr;
		     BufferedWriter bf;
		     
			 try {
				 
				fr = new FileWriter("STUDENT GRADE INFORMATION.txt",true);
			    bf=new BufferedWriter(fr);
			    bf.write(String.valueOf(selectedItem)+" ");
			    bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     
	    	 });
	    	 
	    	 
	    	 
	    	
	    	 creditdata.setOnAction((event) -> {
	    		
	    		 int selectedIndex = creditdata.getSelectionModel().getSelectedIndex();
			     Object selectedItem = creditdata.getSelectionModel().getSelectedItem();
			     System.out.println(selectedItem);
			     System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
			     System.out.println("   ComboBox.getValue(): " +creditdata.getValue());
	    		 
			     FileWriter fr;
			     BufferedWriter bf;
			     
				 try {
					
					fr = new FileWriter("STUDENT GRADE INFORMATION.txt",true);
				    bf=new BufferedWriter(fr);
				    bf.write(String.valueOf(selectedItem)+" ");
				    bf.close();
				    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }
			     
		    	 });
	    	 
	    	 
	    	 
	    	 
	    	
	    	 gradedata.setOnAction((event) -> {
			     int selectedIndex = gradedata.getSelectionModel().getSelectedIndex();
			     Object selectedItem = gradedata.getSelectionModel().getSelectedItem();
			     System.out.println(selectedItem);
			     System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
			     System.out.println("   ComboBox.getValue(): " +gradedata.getValue());
			     
			     FileWriter fr;
			     BufferedWriter bf;
				 try {
					
					fr = new FileWriter("STUDENT GRADE INFORMATION.txt",true);
				    bf=new BufferedWriter(fr);
				    bf.write(String.valueOf(selectedItem)+"\n");
				    bf.close();
				    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }
			     
			    
		    	 });
	    	 	
	    	
		 	
	    	 	 
	     }
		 	//for loop end
		 }catch(Exception e) {
			 
		 }
			
			//MANUAL DATA INPUT
			
			Label manual=new Label("MANUAL");
			manual.setFont(font2);
			
			TextField creditTextFeild= new TextField();
			creditTextFeild.setFont(font1);
			creditTextFeild.setPromptText("CREDIT");
			StackPane crpane = new StackPane();  
			Tooltip crtool=new Tooltip();  
			crtool.setText("ENTER MANUAL CREDIT");  
			creditTextFeild.setTooltip(crtool);  
			crpane.getChildren().add(creditTextFeild);  
			
			
			
			TextField cgpaTextFeild= new TextField();
			cgpaTextFeild.setFont(font1);
			cgpaTextFeild.setPromptText("CGPA");
			StackPane cgpane = new StackPane();  
			Tooltip cgtool=new Tooltip();  
			cgtool.setText("ENTER MANUAL CGPA");  
			cgpaTextFeild.setTooltip(cgtool);  
			cgpane.getChildren().add(cgpaTextFeild);
			
			HBox manualcgcralignment=new HBox(15,manual,creditTextFeild,cgpaTextFeild);
			manualcgcralignment.setAlignment(Pos.CENTER);
			
			
			
			//Button
			
			  
			
			 Button calculate=new Button("CALCULATE");
			 //calculate.setStyle("-fx-background-color:#F2F2F2");
			 Image sceenlogo = new Image("Image/calculateIcon.png");	
			 ImageView lview = new ImageView(sceenlogo );
			 calculate.setGraphic(lview);
			 calculate.setFont(font1);
		     
			 
			 calculate.setOnAction(new EventHandler<ActionEvent>() {
				 	
				 	ArrayList<String> course=new ArrayList<String>();
				 	ArrayList<Double> credit=new ArrayList<Double>();
				 	ArrayList<String> grade=new ArrayList<String>();
					@Override
					public void handle(ActionEvent event) {
						double creditmanual;
						double cgpamanual;
						if(creditTextFeild.getText().toString().isEmpty()||cgpaTextFeild.getText().toString().isEmpty()) {
							creditmanual=0;
							cgpamanual=0;
							System.out.println("Empty Feild");
						}
						
						else {
							
							creditmanual=Double.valueOf(creditTextFeild.getText().toString());
							cgpamanual=Double.valueOf(cgpaTextFeild.getText().toString());
						}
						try {
							FileReader calculatedata=new FileReader("STUDENT GRADE INFORMATION.txt");
							Scanner sc=new Scanner(calculatedata);
							while(sc.hasNext()) {
								
								course.add(String.valueOf(sc.next()));
								credit.add(Double.valueOf(sc.next()));
								grade.add(String.valueOf(sc.next()));
							}
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						for(int testgrade=0;testgrade<grade.size();testgrade++) {
							System.out.println(grade.get(testgrade));
						}
						double totalcredit=0;
						double coursegradepoint=0;
						double totalgradepoint=0;
						double cgpa=0;
						for(int count=0;count<credit.size();count++) {
							
							totalcredit+=credit.get(count);
							String b=grade.get(count);
							
							switch(b) {
							
							case "A":
								coursegradepoint=4;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							case "A-":
								coursegradepoint=3.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "B+":
								coursegradepoint=3.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
								
							case "B":
								coursegradepoint=3.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "B-":
								coursegradepoint=2.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "C+":
								coursegradepoint=2.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
								
							case "C":
								coursegradepoint=2.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "C-":
								coursegradepoint=1.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							case "D+":
								coursegradepoint=1.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "D":
								coursegradepoint=1.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							
							case "F":
								coursegradepoint=0.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
								break;
							}
							
							/*if(grade.get(count).matches("A")) {
								coursegradepoint=4;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							else if(grade.get(count).matches("A-")) {
								coursegradepoint=3.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("B+")) {
								coursegradepoint=3.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("B")) {
								coursegradepoint=3.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("B-")) {
								coursegradepoint=2.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("C+")) {
								coursegradepoint=2.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("C")) {
								coursegradepoint=2.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("C-")) {
								coursegradepoint=1.7;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							else if(grade.get(count).matches("D+")) {
								coursegradepoint=1.3;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							
							else if(grade.get(count).matches("D")) {
								coursegradepoint=1.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}
							
							
							else if(grade.get(count).matches("F")) {
								coursegradepoint=0.0;
								totalgradepoint+=(credit.get(count)*coursegradepoint);
							}*/
						}
						System.out.println("GradePoint:"+totalgradepoint);
						System.out.println("Credits:"+totalcredit);
						
						double manualgradepoint=cgpamanual*creditmanual;
						
						totalgradepoint+=manualgradepoint;
						totalcredit+=creditmanual;
						
						cgpa=totalgradepoint/totalcredit;
						DecimalFormat d=new DecimalFormat("0.00");
		        		

						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("CGPA CONFIRMATION BOX");
						alert.setHeaderText(null);
						ImageView icon = new ImageView("Image/confirmation.png");
						alert.getDialogPane().setGraphic(icon);
						alert.setContentText("CREDIT: "+totalcredit+" CGPA:"+d.format(cgpa));
						alert.showAndWait();
						
						
						File newf=new File("STUDENT GRADE INFORMATION.txt");
						try {
							 newf.createNewFile();
							 FileWriter fr=new FileWriter(newf);
							 fr.write("");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						primaryStage.close();
						
					}
			    	
			    });
			 
			
	     
	     //HBox halign=new HBox(25,coursenumberflowpane,courseflowpane,creditflowpane,gradeflowpane);
	     //halign.setAlignment(Pos.CENTER);
	     //HBox halign=new HBox(root);
	     //halign.setAlignment(Pos.CENTER);
		 
		 root.setAlignment(Pos.CENTER);
		 ScrollPane pane=new ScrollPane(root);
		 pane.setMaxHeight(350);
		 pane.setMaxWidth(479);
		 pane.setStyle( "-fx-background: #D5D5D5;");
		 pane.fitToHeightProperty().set(true);
		 pane.fitToWidthProperty().set(true);
		 pane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
		 pane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	     VBox valign=new VBox(20,calculatorlevel,manualcgcralignment,pane,calculate);
	     valign.setAlignment(Pos.CENTER);
	     
	     //Get Data
	     
	     
	     
	    
	    
	   
	    //Layout
		
		
		//Scene
		
		Scene sc=new Scene(valign,850,650);
		
		//Stage
		
		Image image = new Image("Image/Calculator_Background.jpg");
		BackgroundImage bImg = new BackgroundImage(image,
				BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		valign.setBackground(bGround);
		primaryStage.getIcons().add(new Image("Image/calculator.png"));
		primaryStage.setTitle("CGPA CALCULATOR");
		primaryStage.setScene(sc);
		primaryStage.setX(250);
		primaryStage.setY(20);
		primaryStage.setMaxWidth(850);
		primaryStage.setMaxHeight(650);
		primaryStage.setMinWidth(850);
		primaryStage.setMinHeight(650);
		primaryStage.show();
		
			
	}
	

	


}
