import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DayTradeSoftware extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Day Trade Software");

        // Layout principal
        BorderPane root = new BorderPane();

        // Menu principal
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));
        menuFile.getItems().add(exitItem);
        menuBar.getMenus().add(menuFile);
        root.setTop(menuBar);

        // Gráfico inicial
        LineChart<Number, Number> lineChart = createLineChart();
        root.setCenter(lineChart);

        // Barra lateral
        VBox sideBar = createSidebar();
        root.setRight(sideBar);

        // Configuração da cena
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private LineChart<Number, Number> createLineChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Price");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Market Data");

        // Dados iniciais fictícios
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Sample Asset");
        for (int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data<>(i, Math.random() * 100));
        }

        lineChart.getData().add(series);
        return lineChart;
    }

    private VBox createSidebar() {
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-padding: 10; -fx-background-color: #f4f4f4;");

        Label label = new Label("Tools");

        Button btnBacktest = new Button("Run Backtest");
        btnBacktest.setOnAction(e -> {
            System.out.println("Running backtest...");
        });

        Button btnAlert = new Button("Set Alerts");
        btnAlert.setOnAction(e -> {
            System.out.println("Setting alerts...");
        });

        vbox.getChildren().addAll(label, btnBacktest, btnAlert);
        return vbox;
    }
}

