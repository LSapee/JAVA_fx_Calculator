
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldStudy extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		TextField tf = new TextField();
		
		tf.setPromptText("Search");

		Button bt = new Button("�ؽ�Ʈ ��������");
		Button bt2 = new Button("�ؽ�Ʈ ��������");
		
		bt.setOnAction(e ->{
			String a =tf.getText().trim();
			System.out.println(a);
		});
		
		bt2.setOnAction(e ->{
			tf.setText("���̴�");
			
		});
		
		tf.setOnAction(e ->{
//			System.out.println("dsadsads");
			// ��ư�� �Լ� ��������
			bt2.fire();
		});
		
		VBox vb = new VBox(tf,bt,bt2);
		
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("�ؽ�Ʈ�ʵ�");
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
