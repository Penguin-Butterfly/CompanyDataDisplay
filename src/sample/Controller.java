package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    public TableView DotComBubble;
    public TableColumn<DotCom, String> Rank;
    public TableColumn<DotCom, String> Name;
    public TableColumn<DotCom, Double> Revenue;
    public TableColumn<DotCom, Integer> Employees;
    public TableColumn<DotCom, String> HQ;
    public TableColumn<DotCom, Double> MCap;
    public TableColumn<DotCom, Integer> FY;
    public TableColumn<DotCom, Integer> Founding;

    public void initialize(){
        Business.setlistController(this);
        Rank.setCellValueFactory(new PropertyValueFactory<>("Rank"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Revenue.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        Employees.setCellValueFactory(new PropertyValueFactory<>("Emp Ct."));
        HQ.setCellValueFactory(new PropertyValueFactory<>("HQ Location"));
        MCap.setCellValueFactory(new PropertyValueFactory<>("Market Cap"));
        FY.setCellValueFactory(new PropertyValueFactory<>("FY"));
        Founding.setCellValueFactory(new PropertyValueFactory<>("Founded"));
        DotCom.initialize();
        updateDotComs();
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
