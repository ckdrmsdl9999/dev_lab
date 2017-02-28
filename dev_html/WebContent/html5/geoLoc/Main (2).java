package slidepuzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch();

	} 

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("slidepuzzle.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("start.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
