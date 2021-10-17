
import java.util.Observable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewStudy3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<Person> lv = new ListView<>();
		
		
		ObservableList<Person> ov = FXCollections.observableArrayList();
	
		Button bt1 = new Button("Add");
		Button bt2 = new Button("Info");
		Button bt3 = new Button("Remove");
		Button bt4 = new Button("Updata");
		
		bt1.setOnAction(e->{
			
			Person preson1 = new Person("kk1",22);
			Person preson2 = new Person("kk2",22);
			Person preson3 = new Person("kk3",22);
			
			ov.addAll(preson1,preson2,preson3);
		});
		bt2.setOnAction(e->{
			Person selected = lv.getSelectionModel().getSelectedItem();
			
			if(selected != null) {
				System.out.println("name : "+ selected.getName() +"\nAge : " + selected.getAge());
			}
		});
		bt3.setOnAction(e->{
			Person selected = lv.getSelectionModel().getSelectedItem();
			
			if(selected != null) {
				ov.remove(selected);
			}
			
		});
		bt4.setOnAction(e->{
			Person selected = lv.getSelectionModel().getSelectedItem();
			int index = lv.getSelectionModel().getSelectedIndex();
			
			if(selected != null) {
				Person updata = new Person("歯紫寓",30);
				
				ov.set(index, updata);
			}
		
		});
		
		
		lv.setItems(ov);
		
		
	
		

		
		
		VBox vb = new VBox(lv,bt1,bt2,bt3,bt4);
		
		Scene scene = new Scene(vb,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ししいけしいけ");
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	class Person{
		private String name;
		private int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
		}
		@Override
		public String toString() {
			return this.name +"," + this.age;
		}
	}
}
