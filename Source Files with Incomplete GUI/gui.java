import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
		
		stage.setTitle("Quizify");
		stage.setScene(new Scene(root));
  		stage.setResizable(false);
		stage.show();
	}

	public void changeScene(Scene scene) {
		
	}
}
