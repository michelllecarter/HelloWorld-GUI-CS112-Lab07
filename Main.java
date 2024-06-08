//package Main; 
//package name here depending on your IDE 

import javafx.application.Application;
//abstract class used for JavaFX GUI's
import javafx.stage.Stage;
//class for GUI window
import javafx.scene.Scene;
//class for specific view in GUI window
import javafx.scene.layout.VBox;
//class for layout pane, organized top-to-bottom 
import javafx.scene.control.Label;
//class for label component
import javafx.scene.control.Button;
//class for button component 
import javafx.event.EventHandler;
// interface for handling events
import javafx.event.ActionEvent;
//class for type of event for action (like button or key pressed) 
import javafx.scene.control.TextField;
//import javafx.geometry.Pos;
//1. import, 2. declare variable, 3. instantiate, 4. add it

public class Main extends Application implements EventHandler<ActionEvent> {
//inheriting core functionality + this class will handle events 
  /***GUI COMPONENTS***/
  private Button button; //countButton better name
  private Label message; //messageLabel
  private TextField nameTextField;
  private int counter = 0;


  /***DRIVER main***/ 
  public static void Main(String[] args) {
    launch(args);
    //method from Application class, must be called to setup javafx application 
  }

  /***OVERIDDEN Application METHODS ***/ 
  @Override
  public void start(Stage primaryStage) throws Exception {
    //Application automatically calls this method to run (our) main javafx code passes in primary stage (main window)
    
    //SETUP COMPONENTS
      message = new Label("Hi, User!"); 
      button = new Button("Click Me!"); //or can set text using setText method separaetly 
      button.setOnAction(this); //who the event handler is (which object/class should handle the event))
      nameTextField = new TextField("Enter name here"); 

      //ADD COMPONENTS 
      VBox layout = new VBox(); //simple layout, components are stacked on top of each other in added order 
      //layout.getChildren().add(message); 
      //layout.getChildren().add(button);
      layout.getChildren().addAll(message, nameTextField, button); //order matters bc that's how GUI will order it when displayed
      layout.setSpacing(20.0);

      //SETUP SCENE AND SHOW 
      Scene scene = new Scene(layout, 300, 250); //layout, dimensions of window
      primaryStage.setScene(scene);
      primaryStage.setTitle("Group 0 - Solo Running"); //setting title of main window 
      primaryStage.show(); 
    }

    /**
    Label label; 
    TextField tf;
    Button button;
    VBox vbox;
    Scene scene;
    
    tf = new TextField("Text Field!");
    tf.setMaxWidth(200);

    label = new Label("Type text and click the button");
    button = new Button("Click"); 

    button.setOnAction(new EventHandler<ActionEvent>() {
    **/

    /**
      @Override public void handle(ActionEvent e) {
        label.setText(tf.getText());
      }
    });
  
    vbox = new VBox(label, tf, button);
    vbox.setSpacing(20);
    vbox.setAlignment(Pos.CENTER);
    scene = new Scene(vbox, 300, 200);
  
    primaryStage.setTitle("A Simple Scene!");
    primaryStage.setScene(scene);
    primaryStage.show();
    } 
  
    public static void main(String[] args) {
    launch(args);
    **/

/***OVERRIDEN Event Handler METHODS***/ 
 @Override 
    public void handle(ActionEvent actionEvent) { //generic method used to handle when events occur (like handle button click)
    //good practice to identify source, in case you have multiple event types/sources
      if(actionEvent.getSource() == button) {
        System.out.println("Hello, CS112!"); 
        counter++; //event driven programming use counter++ to keep track of how many times button is clicked instead of for loop to count 
        //System.out.println("TEST: Counter = " + counter); //testing counter functionality 
        message.setText("Hi #" + counter + ", " + nameTextField.getText() + "!");
      }
    }
} 
