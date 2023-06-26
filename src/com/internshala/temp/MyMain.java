package com.internshala.temp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class MyMain extends Application{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("Start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.getIcons().add(new Image("com/internshala/temp/Iconn.png"));
		//primaryStage.setScene(new Scene(rootNode));
		primaryStage.show();


	}
	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu = new Menu("File");
		//MenuItem newMenuItem = new MenuItem("New");
		//newMenuItem.setOnAction(event -> {
		//	System.out.println("New Menu Item Clicked");
		//});
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event-> {
			Platform.exit();
			System.exit(0);

		});

		fileMenu.getItems().addAll(/*newMenuItem,*/separatorMenuItem,quitMenuItem);



		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);


		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;


	}

	private void aboutApp() {
		Alert alertDialog  =new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle(" Temperature Converter Desktop App");
		alertDialog.setHeaderText("About The Developer");

		VBox vBox = new VBox();
		Hyperlink linkedinLink = new Hyperlink("LinkedIn");
		linkedinLink.setOnAction(e->{
			getHostServices().showDocument("https://www.linkedin.com/in/gkarthik17/");

		});
		Hyperlink github = new Hyperlink("GitHub");
		github.setOnAction(e->{
			getHostServices().showDocument("https://github.com/karthik6717");

		});

		vBox.getChildren().addAll(
				new javafx.scene.control.Label("My name is Karthik. " +
						                           "I'm a Data Science Aspirant in VJIT "),
				new javafx.scene.control.Label("My field of interest includes building new Web Technologies and Products, Machine Learning, and " +
						                           "areas related to artificial intelligence, image processing, and data science."),
				new javafx.scene.control.Label("I live in Hyderabad."),
				new javafx.scene.control.Label("I love to drink coffee."),
				new javafx.scene.control.Label("I like swimming.\n"),
				new javafx.scene.control.Label("Reach Me Through"),
				linkedinLink,
				github
		);

	/*	alertDialog.setContentText("My name is Karthik. I'am a B.Tech student at Vidya Jyothi Institute Of Technology in Computer Science Department.\n" +
				"My field of Interest's are building new Web Technologies and Products, Machine Learning and also in areas related to artificial intelligence,Image processing and Data science.\n" +
				"I live in Hyderabad.\n" +
				"I love to drink coffee. \n" +
				"I like swimming"); */
		alertDialog.getDialogPane().setContent(vBox);
		ButtonType okBtn = new ButtonType("OK");
		//ButtonType yesBtn = new ButtonType("Yes");
		//ButtonType noBTn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(/*yesBtn,noBTn*/okBtn);

		Optional<ButtonType> clickBtn =  alertDialog.showAndWait();
	/*	if( clickBtn.isPresent() && clickBtn.get() == yesBtn)
		{
			System.out.println("Yes Button is Clicked !");
		}
		else
		{
			System.out.println("NO Button is Clicked !");

		}*/

	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}

