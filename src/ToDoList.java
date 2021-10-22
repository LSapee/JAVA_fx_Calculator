
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoList extends Application {

	
	private Connection conn;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		conn =dbConnector();
		
		
		ListView<String> lv = new ListView<>();
		ObservableList<String> ov = FXCollections.observableArrayList();
		lv.setItems(ov);
		
		//텍스트 필드 생성
		TextField addTf = new TextField();
		addTf.setPromptText("Add Todo List");
		
		TextField updateTf = new TextField();
		updateTf.setPromptText("Update Todo List");
		
	
		
		//버튼 생성
		
		Button addBt = new Button("add");
		Button upBt = new Button("update");
		Button delBt = new Button("delete");
		
		//db
		
		
		ObservableList<String> dbOv = new TodoListDb().loadData();
		ov.addAll(dbOv);
		
		lv.getSelectionModel().selectedItemProperty().addListener((a,oldValue,newValue)->{
			
			
			updateTf.setText("newValue");
		});
		
		//텍스트필드 이벤트
		
		addTf.setOnAction(e->{
			addBt.fire();
		});
		updateTf.setOnAction(e->{
			upBt.fire();
		});
		//버튼 이벤트
		addBt.setOnAction(e->{
			
			String todo = addTf.getText().trim();
			if(!todo.isEmpty() && !ov.contains(todo)) {
				ov.add(todo);
				addTf.clear();
			}
			
			//db
			
			new TodoListDb().insertData(todo);
			
			
		});
		
		
		upBt.setOnAction(e->{
			String upDateTodo = lv.getSelectionModel().getSelectedItem();
			int index = lv.getSelectionModel().getSelectedIndex();
			String updated = updateTf.getText().trim();
			
			if(upDateTodo != null && !updated.isEmpty()) {
				
				
				ov.set(index, updated);
				
				//db
				
				new TodoListDb().upDateData(upDateTodo, updated);
			}
			
		});
		
		
		
		delBt.setOnAction(e->{
			String delTodo = lv.getSelectionModel().getSelectedItem();
			if(delTodo != null) {
				ov.remove(delTodo);
				
				//db
				new TodoListDb().deleteData(delTodo);
			}
		});
		
		HBox hb = new HBox(addBt,upBt,delBt);
		hb.setSpacing(2);
		
		
		VBox vb = new VBox(addTf,hb,updateTf,lv);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
		
		
		Scene scene = new Scene(vb,500,500);
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("ToDo List");
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public Connection dbConnector() {
		try {
			
			if(conn == null) {
				
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:sql/TodoList.sqlite");
				
				System.out.println("DB접속 완료");
				return conn;
			}else {
		
				return conn;
			}
			
			
			
		}catch(Exception e) {
			System.out.println("DB접속 실패");
			System.out.println(e);
			return null;
		}
	}
	
	public class TodoListDb{
		
		private PreparedStatement pst;
		private ResultSet rs;
		
		public ObservableList<String> loadData(){
			
			ObservableList<String> tempOv = FXCollections.observableArrayList();
			
			String query = "select * from Todo";
			try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String data = rs.getString("Text");
				
				tempOv.add(data);
			}
			
			
			}catch(Exception e) {
				System.out.println("db 로드 실패");
			}
			
			return tempOv;
		}
		
		public void insertData(String data) {
			String query = "insert or Replace into Todo (Text) Values (?)";
			
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, data);
				pst.execute();
				pst.close();
				
				
				
			}catch(Exception e) {
				System.out.println("데이터 삽입 실패");
			}
		}
		public void deleteData(String data) {
		String query = "delete from Todo where Text = ?";
			
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, data);
				pst.execute();
				pst.close();
				
				
				
			}catch(Exception e) {
				System.out.println("데이터 삭제 실패");
			}
		}
	
		public void upDateData(String oldValue,String newValue) {
				String query = "update Todo set Text = ? where Text =?";
			
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, newValue);
				pst.setString(2, oldValue);
				pst.execute();
				pst.close();
				
				
				
			}catch(Exception e) {
				System.out.println("데이터 업데이트 실패");
		}
	}
	}
}
