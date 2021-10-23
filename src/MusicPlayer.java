
import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

	
	MediaPlayer mediaPlayer;
	
	Connection conn;
		
	@Override
	public void start(Stage primaryStage) {
		
		//�÷��� ����Ʈ �����
		ListView<MusicData> lv = new ListView<MusicData>();
		ObservableList<MusicData> ov = FXCollections.observableArrayList();
		lv.setItems(ov);
		
		
//		//���ϰ��
//		String filePath = "D:/javaStudy/MusicPlayer/src/Englishman in New York  Ouro Kronii Sings  HoloLive EN Songs.mp3";
//		//���� Ȯ���� ���� Ŭ����
//		File file = new File(filePath);
		
		//������ �����ϴ��� Ȯ��
//		if(file.exists()) {
//			System.out.println("���� ����");
//		}else {
//			System.out.println("���� ����X");
//			
//		}

		
		//��ư ��ư
		Button playBt = new Button("play");
		Button stopBt = new Button("Stop");
		Button addBt = new Button("Add");
		Button removeBt = new Button("Remove");
		//textField
		TextField addTf = new TextField();
		addTf.setPromptText("Music Path");
		addTf.setPrefWidth(250);
		
		
		//db
		conn = dbConnector();
		ov.addAll(new MusicPlayerDB().loadData());
		
		
//		Media media = new Media(file.toURI().toString());
//		
//		MediaPlayer mediaPlayer = new MediaPlayer(media);

		//��ư �̺�Ʈ
		addBt.setOnAction(e->{
			
			String filePath = addTf.getText().trim();
			File file = new File(filePath);
			if(file.exists()) {
				String name = file.getName();
				String path = file.getAbsolutePath();
				
				MusicData data = new MusicData(name,path);
				
				ov.add(data);
				
				addTf.clear();
				
				//db
				
				new MusicPlayerDB().insertData(path);
			}else {
				
			}
			
		});
		removeBt.setOnAction(e->{
			MusicData selected = lv.getSelectionModel().getSelectedItem();
			
			if(selected != null) {
				ov.remove(selected);
			
	//db
				
				new MusicPlayerDB().deleteData(selected.getPath());
			}
			
		});
		
		
		
		
		playBt.setOnAction(e->{
			MusicData selected = lv.getSelectionModel().getSelectedItem();
			
			if(selected != null) {
				File file = new File(selected.getPath());
				
				if(file.exists()) {
					if(mediaPlayer != null) {
						mediaPlayer.stop();						
					}
					Media media = new Media(file.toURI().toString());
					
					mediaPlayer = new MediaPlayer(media);
					
					mediaPlayer.play();
				}
			}
		});
		stopBt.setOnAction(e->{
			if(mediaPlayer != null) {
			mediaPlayer.stop();
			}
		});
	
		
		//textField �̺�Ʈ
		addTf.setOnAction(e->{
			addBt.fire();
		});

		
		HBox hb = new HBox(addTf,addBt,removeBt);
		HBox hb2 = new HBox(playBt,stopBt);
		hb.setSpacing(2);
		hb2.setSpacing(2);
		
		
		VBox vb = new VBox(hb,hb2,lv);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));
		Scene scene = new Scene(vb);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("musicPlayer");
		primaryStage.setOnCloseRequest(e->{
			if(mediaPlayer != null) {
				mediaPlayer.stop();
				}
		});
		
		
		
	
	

		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public Connection dbConnector() {
		try {
			if(conn ==null) {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:sql/MusicData.sqlite");
				return conn;
			}else {
				return conn;
			}
		}catch(Exception e) {
		System.out.println("db���� ����");
		return null;
		}
		
	}

	
	class MusicData{
		private String name;
		private String path;
		
		public MusicData(String name, String path) {
			this.name = name;
			this.path = path;
		}
		public String getName() {
			return this.name;
		}
		public String getPath() {
			return this.path;
		}
		@Override
		public String toString() {
			return this.name;
		}
	}
	
	
	class MusicPlayerDB{
		private PreparedStatement pst;
		private ResultSet rs;
		
		
		public ObservableList<MusicData> loadData(){
			ObservableList<MusicData> tempOv = FXCollections.observableArrayList();
			
			String query = "Select * from Music";
			
			try {
				pst = conn.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					String path = rs.getString("Path");
					File file = new File(path);
					
					MusicData data = new MusicData(file.getName(),path);
					
					tempOv.add(data);
			
				}
				rs.close();
				pst.close();
				
				
			}catch(Exception e) {
				System.out.println("������ ���� ����");
				System.out.println(e);
			}
			
			
			
			
			return tempOv;
		}
		
		public void insertData(String path) {
			String query = "Insert or Replace into Music (Path) Values (?)";
			
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, path);
				pst.execute();
				pst.close();
				
				
			}catch(Exception e) {
				System.out.println("������ �߰� ����");
			}
		}
		
		
		public void deleteData(String path) {
		String query = "delete from Music where Path = ?";
			
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, path);
				pst.execute();
				pst.close();
				
				
			}catch(Exception e) {
				System.out.println("������ ����");
			}
		}
		
		
		
		
	}
}
