
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.show();
		
		Button bt = new Button("��ư");
		Button bt2 = new Button("��ư2");
		
		VBox vb = new VBox(bt,bt2);
		
		Scene scene = new Scene(vb,500,500);
		//��üâ = Stage
		
		//����ȭ�� = Scene
		
		// ��ư�� ���ƃ��� ���� VBox
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("��ư�� ���ִ�");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
