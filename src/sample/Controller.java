package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    public TableView<DotCom> DotComBubble;
    public TableColumn<DotCom, Integer> RankCol;
    public TableColumn<DotCom, String> NameCol;
    public TableColumn<DotCom, Double> RevenueCol;
    public TableColumn<DotCom, Integer> EmployeesCol;
    public TableColumn<DotCom, String> HQCol;
    public TableColumn<DotCom, Double> MCapCol;
    public TableColumn<DotCom, Integer> FoundingCol;

    public void initialize(){
        Business.setlistController(this);

        RankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        RevenueCol.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        EmployeesCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeCt"));
        HQCol.setCellValueFactory(new PropertyValueFactory<>("HQLocation"));
        MCapCol.setCellValueFactory(new PropertyValueFactory<>("MarketCap"));
        FoundingCol.setCellValueFactory(new PropertyValueFactory<>("FoundingYear"));

        DotCom.initialize();
    }


    void updateDotComs() {
        DotComBubble.getItems().clear();
        ArrayList<DotCom> DotComData = DotCom.getDotComData();
        if (DotComData != null) {
            DotComData.forEach(DotCom -> {
                DotComBubble.getItems().add(DotCom);
            });
        }
    }


}
