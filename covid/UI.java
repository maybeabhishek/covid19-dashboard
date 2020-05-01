import java.util.ArrayList;

// SQL imports
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

// JavaFX Imports
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UI extends Application {

   private TableView<Covid> table = new TableView<Covid>();

   private ObservableList<Covid> data;

   private void add(ArrayList<Covid> lis) {
      data = FXCollections.observableArrayList(lis);
   }

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) {
      ArrayList<Covid> lis = Database.getData();
      add(lis);
      Scene scene = new Scene(new Group());
      stage.setTitle("COVID India Dashboard");
      stage.setWidth(880);
      stage.setHeight(900);

      final Label label = new Label("COVID 19 Cases");
      final Label label1 = new Label("Total Cases in India: " + Database.totalCases);

      label.setFont(new Font("Lato", 40));
      label1.setFont(new Font("Lato", 15));
      label.setTextFill(Color.web("#0076a3"));
      label1.setTextFill(Color.web("#a01623"));

      Button andaman = new Button("Andaman and Nicobar Islands");
      andaman.setMaxWidth(Double.MAX_VALUE);
      Button andhra = new Button("Andhra Pradesh");
      andhra.setMaxWidth(Double.MAX_VALUE);
      Button arunachal = new Button("Arunachal Pradesh");
      arunachal.setMaxWidth(Double.MAX_VALUE);
      Button assam = new Button("Assam");
      assam.setMaxWidth(Double.MAX_VALUE);
      Button bihar = new Button("Bihar");
      bihar.setMaxWidth(Double.MAX_VALUE);
      Button chattisgarh = new Button("Chhattisgarh");
      chattisgarh.setMaxWidth(Double.MAX_VALUE);
      Button chandigarh = new Button("Chandigarh");
      chandigarh.setMaxWidth(Double.MAX_VALUE);
      Button delhi = new Button("Delhi");
      delhi.setMaxWidth(Double.MAX_VALUE);
      Button goa = new Button("Goa");
      goa.setMaxWidth(Double.MAX_VALUE);
      Button gujrat = new Button("Gujarat");
      gujrat.setMaxWidth(Double.MAX_VALUE);
      Button haryana = new Button("Haryana");
      haryana.setMaxWidth(Double.MAX_VALUE);
      Button himachal = new Button("Himachal Pradesh");
      himachal.setMaxWidth(Double.MAX_VALUE);
      Button jammu = new Button("Jammu and Kashmir");
      jammu.setMaxWidth(Double.MAX_VALUE);
      Button jharkhand = new Button("Jharkhand");
      jharkhand.setMaxWidth(Double.MAX_VALUE);
      Button karnataka = new Button("Karnataka");
      karnataka.setMaxWidth(Double.MAX_VALUE);
      Button kerala = new Button("Kerala");
      kerala.setMaxWidth(Double.MAX_VALUE);
      Button ladakh = new Button("Ladakh");
      ladakh.setMaxWidth(Double.MAX_VALUE);
      Button madhya = new Button("Madhya Pradesh");
      madhya.setMaxWidth(Double.MAX_VALUE);
      Button maharashtra = new Button("Maharashtra");
      maharashtra.setMaxWidth(Double.MAX_VALUE);
      Button manipur = new Button("Manipur");
      manipur.setMaxWidth(Double.MAX_VALUE);
      Button meghalaya = new Button("Meghalaya");
      meghalaya.setMaxWidth(Double.MAX_VALUE);
      Button mizoram = new Button("Mizoram");
      mizoram.setMaxWidth(Double.MAX_VALUE);
      Button nagaland = new Button("Nagaland");
      nagaland.setMaxWidth(Double.MAX_VALUE);
      Button odisha = new Button("Odisha");
      odisha.setMaxWidth(Double.MAX_VALUE);
      Button punducherry = new Button("Puducherry");
      punducherry.setMaxWidth(Double.MAX_VALUE);
      Button punjab = new Button("Punjab");
      punjab.setMaxWidth(Double.MAX_VALUE);
      Button rajasthan = new Button("Rajasthan");
      rajasthan.setMaxWidth(Double.MAX_VALUE);
      Button tamil = new Button("Tamil Nadu");
      tamil.setMaxWidth(Double.MAX_VALUE);
      Button telengana = new Button("Telengana");
      telengana.setMaxWidth(Double.MAX_VALUE);
      Button tripura = new Button("Tripura");
      tripura.setMaxWidth(Double.MAX_VALUE);
      Button uttar = new Button("Uttar Pradesh");
      uttar.setMaxWidth(Double.MAX_VALUE);
      Button uttrakhand = new Button("Uttarakhand");
      uttrakhand.setMaxWidth(Double.MAX_VALUE);
      Button west = new Button("West Bengal");
      west.setMaxWidth(Double.MAX_VALUE);

      Button allCase = new Button("All India Cases");

      // ArrayList<Button> buttons = new ArrayList<Button>();
      Button[] buttons = { andaman, andhra, arunachal, assam, bihar, chandigarh, chattisgarh, delhi, goa, gujrat,
            haryana, himachal, jammu, jharkhand, karnataka, kerala, ladakh, madhya, maharashtra, manipur, meghalaya,
            mizoram, nagaland, odisha, punducherry, punjab, rajasthan, tamil, telengana, tripura, uttar, uttrakhand,
            west };

      GridPane gridPane = new GridPane();
      gridPane.setMinSize(400, 200);

      // Setting the padding
      gridPane.setPadding(new Insets(10, 10, 10, 10));

      // Setting the vertical and horizontal gaps between the columns
      gridPane.setVgap(5);
      gridPane.setHgap(5);

      // Setting the Grid alignment
      gridPane.setAlignment(Pos.CENTER);

      gridPane.add(andaman, 0, 0);
      gridPane.add(andhra, 1, 0);
      gridPane.add(arunachal, 2, 0);
      gridPane.add(assam, 3, 0);
      gridPane.add(bihar, 4, 0);
      gridPane.add(chandigarh, 5, 0);
      gridPane.add(chattisgarh, 0, 1);
      gridPane.add(west, 1, 1);
      gridPane.add(delhi, 2, 1);
      gridPane.add(goa, 3, 1);
      gridPane.add(gujrat, 4, 1);
      gridPane.add(haryana, 5, 1);
      gridPane.add(himachal, 0, 2);
      gridPane.add(jammu, 1, 2);
      gridPane.add(jharkhand, 2, 2);
      gridPane.add(karnataka, 3, 2);
      gridPane.add(kerala, 4, 2);
      gridPane.add(ladakh, 5, 2);
      gridPane.add(madhya, 0, 3);
      gridPane.add(maharashtra, 1, 3);
      gridPane.add(manipur, 2, 3);
      gridPane.add(meghalaya, 3, 3);
      gridPane.add(mizoram, 4, 3);
      gridPane.add(nagaland, 5, 3);
      gridPane.add(odisha, 0, 4);
      gridPane.add(punducherry, 1, 4);
      gridPane.add(punjab, 2, 4);
      gridPane.add(rajasthan, 3, 4);
      gridPane.add(tamil, 4, 4);
      gridPane.add(telengana, 5, 4);
      gridPane.add(tripura, 0, 5);
      gridPane.add(uttar, 1, 5);
      gridPane.add(uttrakhand, 2, 5);
      gridPane.add(allCase, 3, 5);

      final Label head = new Label("");
      final Label total = new Label("");
      final Label active = new Label("");
      final Label death = new Label("");
      final Label recovered = new Label("");

      head.setFont(new Font("Lato", 30));
      total.setFont(new Font("Lato", 15));
      active.setFont(new Font("Lato", 15));
      death.setFont(new Font("Lato", 15));
      recovered.setFont(new Font("Lato", 15));
      

      total.setStyle("-fx-font-weight: bold;");
      death.setStyle("-fx-font-weight: bold;");
      active.setStyle("-fx-font-weight: bold;");
      recovered.setStyle("-fx-font-weight: bold;");

      head.setTextFill(Color.web("#0076a3"));
      total.setTextFill(Color.web("#7b1fa2"));
      death.setTextFill(Color.web("#9e9e9e"));
      active.setTextFill(Color.web("#ef5350"));
      recovered.setTextFill(Color.web("#43a047"));

      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            Object node = e.getSource();

            Button b = (Button) node;
            ArrayList<String> res = Database.getData(b.getText());
            head.setText("Cases in " + b.getText());
            int t = Integer.parseInt(res.get(0)) - Integer.parseInt(res.get(1)) - Integer.parseInt(res.get(2));
            total.setText("Total Cases: " + res.get(0));
            active.setText("Active:         " + t + "");
            death.setText("Death:         " + res.get(1));
            recovered.setText("Recovered:  " + res.get(2));
            // System.out.println(b.getText());//prints out Click M
         }
      };

      

      for (Button b : buttons) {
         b.setOnAction(event);
      }
      final VBox labelBox = new VBox();
      labelBox.getChildren().addAll(head, total, active, death, recovered);

      Image image = new Image(getClass().getResourceAsStream("a.jpg"));
      Label labelImg = new Label("");
      labelImg.setGraphic(new ImageView(image));

      table.setEditable(true);

      TableColumn stateCol = new TableColumn("state");
      stateCol.setMinWidth(100);
      stateCol.setCellValueFactory(new PropertyValueFactory<Covid, String>("state"));

      TableColumn activeCol = new TableColumn("Active");
      activeCol.setMinWidth(100);
      activeCol.setCellValueFactory(new PropertyValueFactory<Covid, String>("active"));

      TableColumn confirmedCol = new TableColumn("Confirmed");
      confirmedCol.setMinWidth(200);
      confirmedCol.setCellValueFactory(new PropertyValueFactory<Covid, String>("confirmed"));

      TableColumn deathsCol = new TableColumn("Deaths");
      deathsCol.setMinWidth(200);
      deathsCol.setCellValueFactory(new PropertyValueFactory<Covid, String>("deaths"));

      TableColumn recoveredCol = new TableColumn("Recovered");
      recoveredCol.setMinWidth(200);
      recoveredCol.setCellValueFactory(new PropertyValueFactory<Covid, String>("recovered"));

      table.setItems(data);
      table.getColumns().addAll(stateCol, activeCol, confirmedCol, deathsCol, recoveredCol);

      final CategoryAxis xAxis = new CategoryAxis();
      final NumberAxis yAxis = new NumberAxis();
      xAxis.setLabel("Month");

      final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

      lineChart.setTitle("COVID Pandemic, 2020");

      XYChart.Series series = new XYChart.Series();
      series.setName("Number of Cases");

      series.getData().add(new XYChart.Data("Feb 15", 2));
      series.getData().add(new XYChart.Data("Feb 17", 1));
      series.getData().add(new XYChart.Data("Feb 19", 1));
      series.getData().add(new XYChart.Data("Feb 21", 2));
      series.getData().add(new XYChart.Data("Feb 23", 3));
      series.getData().add(new XYChart.Data("Feb 25", 6));
      series.getData().add(new XYChart.Data("Feb 27", 6));
      series.getData().add(new XYChart.Data("Feb 29", 8));
      series.getData().add(new XYChart.Data("Mar 2", 10));
      series.getData().add(new XYChart.Data("Mar 4", 14));
      series.getData().add(new XYChart.Data("Mar 6", 20));
      series.getData().add(new XYChart.Data("Mar 8", 31));
      series.getData().add(new XYChart.Data("Mar 10", 45));
      series.getData().add(new XYChart.Data("Mar 12", 69));
      series.getData().add(new XYChart.Data("Mar 14", 120));
      series.getData().add(new XYChart.Data("Mar 16", 180));
      series.getData().add(new XYChart.Data("Mar 18", 240));
      series.getData().add(new XYChart.Data("Mar 20", 370));
      series.getData().add(new XYChart.Data("Mar 22", 590));
      series.getData().add(new XYChart.Data("Mar 24", 719));
      series.getData().add(new XYChart.Data("Mar 26", 870));
      series.getData().add(new XYChart.Data("Mar 28", 1043));
      lineChart.getData().add(series);
      lineChart.setVisible(false);
      EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            lineChart.setVisible(!lineChart.isVisible());

         }
      };
      allCase.setOnAction(event1);
      BackgroundFill background_fill = new BackgroundFill(Color.web("#cfd8dc"), CornerRadii.EMPTY, Insets.EMPTY);

      // create Background
      Background background = new Background(background_fill);

      final VBox vbox = new VBox();
      vbox.setSpacing(10);
      vbox.setPadding(new Insets(20, 20, 20, 20));
      vbox.getChildren().addAll(label, label1, gridPane, labelBox,lineChart, table);
      vbox.setBackground(background);

     

      ((Group) scene.getRoot()).getChildren().addAll(vbox);

      stage.setScene(scene);
      stage.show();
   }

   public static class Covid {

      private final SimpleStringProperty state;
      private final SimpleStringProperty active;
      private final SimpleStringProperty confirmed;
      private final SimpleStringProperty deaths;
      private final SimpleStringProperty recovered;

      private Covid(String state, String active, String confirmed, String deaths, String recovered) {
         this.state = new SimpleStringProperty(state);
         this.active = new SimpleStringProperty(active);
         this.confirmed = new SimpleStringProperty(confirmed);
         this.deaths = new SimpleStringProperty(deaths);
         this.recovered = new SimpleStringProperty(recovered);
      }

      public String getState() {
         return state.get();
      }

      public void setState(String fName) {
         state.set(fName);
      }

      public String getActive() {
         return active.get();
      }

      public void setActive(String fName) {
         active.set(fName);
      }

      public String getConfirmed() {
         return confirmed.get();
      }

      public void setConfirmed(String fName) {
         confirmed.set(fName);
      }

      public String getDeaths() {
         return deaths.get();
      }

      public void setDeaths(String fName) {
         deaths.set(fName);
      }

      public String getRecovered() {
         return recovered.get();
      }

      public void setRecovered(String fName) {
         recovered.set(fName);
      }
   }

   public static class Database {
      private static final String url = "jdbc:mysql://localhost/mydb?";
      private static final String user = "abhishek";
      private static final String password = "password";
      static int totalCases;

      public static ArrayList<Covid> getData() {
         ArrayList<Covid> cases = new ArrayList<Covid>();
         String query = "select StateUnionTerritory, MAX(Confirmed), MAX(Deaths), MAX(Cured) from mytable Group by StateUnionTerritory;";
         try (Connection con = DriverManager.getConnection(url, user, password);
               PreparedStatement pst = con.prepareStatement(query);
               ResultSet rs = pst.executeQuery()) {
            // ResultSetMetaData rsmd = rs.getMetaData();
            // int colcount = rsmd.getColumnCount();
            String a;
            totalCases = 0;
            int b, c, d, e;
            while (rs.next()) {
               Covid p;
               a = rs.getString(1);
               b = rs.getInt(2);
               c = rs.getInt(3);
               d = rs.getInt(4);
               e = b - c - d;
               totalCases += e;
               p = new Covid(a, b + "", e + "", c + "", d + "");
               cases.add(p);
              
            }
            return cases;

         } catch (SQLException ex) {
            System.out.print(ex);
         }
         return cases;

      }

      public static ArrayList<String> getData(String state) {
         String query = "select MAX(Confirmed), MAX(Deaths), MAX(Cured) from mytable where StateUnionTerritory = '"
               + state + "';";
         ArrayList<String> res = new ArrayList<String>();
         try (Connection con = DriverManager.getConnection(url, user, password);
               PreparedStatement pst = con.prepareStatement(query);
               ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colcount = rsmd.getColumnCount();

            while (rs.next()) {
               for (int i = 1; i <= colcount; i++) {
                  res.add(rs.getString(i));
               }
               // System.out.print(rs.getString(i) + " ");
               // System.out.println();
            }

         } catch (SQLException ex) {
            System.out.print(ex);
         }
         return res;
      }
   }
}
