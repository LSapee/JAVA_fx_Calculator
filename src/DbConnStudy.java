
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DbConnStudy extends Application {

	private Connection conn;

	
	
	@Override
	public void start(Stage primaryStage) {
		//����
		conn = dbConnector();
		MyDb db = new MyDb();
		
		//��ư ����
		Button loadBt = new Button("load");
		Button addBt = new Button("Add");
		Button updateBt = new Button("update");
		Button removeBt = new Button("Remove");
		
		//��ư �̺�Ʈ
		loadBt.setOnAction(e->{
		
			
			
			ObservableList<String> ov = db.loadData();
			
			int size = ov.size();
			
			for(int i =0; i<size; i++) {
				String data = ov.get(i);
				System.out.println(data);
			
			}
		});
		addBt.setOnAction(e->{
			db.insertData("Good");
		});
		removeBt.setOnAction(e->{
			db.deleteData("Good");
		});
		
		updateBt.setOnAction(e->{
			db.updateData("Good","Great");
		});
		
		VBox vb = new VBox(loadBt,addBt,updateBt,removeBt);
		
		Scene scene = new Scene(vb,300,300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("�����ͺ��̽�");
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public Connection dbConnector() {
		try {
			
			if (conn == null) {
				
			
		Class.forName("org.sqlite.JDBC");
			
		conn = DriverManager.getConnection("jdbc:sqlite:sql/MyData.sqlite");
		
		System.out.println("DB���� ����");
		return conn;
			}else {
			return conn;
		}
			
			
		}catch(Exception e){
			
			
			System.out.println("DB���� ����");
			return null;
		}
		
	}
	
	
	public class MyDb{
		
		private PreparedStatement pst; //���� ��û
		private ResultSet rs; // �� ��������
		
		
		public void insertData(String data) {
			String query = "Insert or Replace into Datas (Text) values (?)";
			try {
			pst = conn.prepareStatement(query);
			pst.setString(1, data);
			pst.execute();
			pst.close();
			}catch(SQLException e) {
				System.out.println("������ ���Խ���");
			}
			
			
			}
		public void deleteData(String data) {
			String query = "Delete from Datas where Text = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, data);
				pst.execute();
				pst.close();
			}catch(SQLException e) {
				System.out.println("������ ��������");
			}
			
		}
		public void updateData(String oldValue,String newValue) {
			String query = "update Datas set Text =? where Text = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, newValue);
				pst.setString(2, oldValue);
				pst.execute();
				pst.close();
			}catch(SQLException e) {
				System.out.println("������Ʈ ����");
			}
		}
		public ObservableList<String> loadData(){
			
			ObservableList<String> tempOv = FXCollections.observableArrayList();
			
			String query = "select * from Datas";
			try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				String text = rs.getString("Text");
				tempOv.add(text);
			}
			rs.close();
			pst.close();
			}catch(SQLException e) {
				System.out.println("������ �ε� ����");
			}
			
			return tempOv;
			
		}
		
	}
	
	

}
