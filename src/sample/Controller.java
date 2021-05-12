package sample;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    private Stage myStage;

    public MenuItem ImportBtn;
    public MenuItem SaveBtn;

    public Accordion myAccordion;
    public TitledPane DotComPane;

    public TableView<DotCom> DotComBubble;
    public TableColumn<DotCom, Integer> RankCol;
    public TableColumn<DotCom, String> NameCol;
    public TableColumn<DotCom, Float> RevenueCol;
    public TableColumn<DotCom, Integer> EmployeesCol;
    public TableColumn<DotCom, String> HQCol;
    public TableColumn<DotCom, Float> MCapCol;
    public TableColumn<DotCom, Integer> FoundingCol;

    public void initialize(){
        Business.setlistController(this);

        DotComBubble.setEditable(true);
        RankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        RevenueCol.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        EmployeesCol.setCellValueFactory(new PropertyValueFactory<>("EmployeeCt"));
        HQCol.setCellValueFactory(new PropertyValueFactory<>("HQLocation"));
        MCapCol.setCellValueFactory(new PropertyValueFactory<>("MarketCap"));
        FoundingCol.setCellValueFactory(new PropertyValueFactory<>("FoundingYear"));

        RankCol.setCellFactory(TextFieldTableCell.<DotCom,Integer>forTableColumn(new IntegerStringConverter()));
        NameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        RevenueCol.setCellFactory(TextFieldTableCell.<DotCom,Float>forTableColumn(new FloatStringConverter()));
        EmployeesCol.setCellFactory(TextFieldTableCell.<DotCom,Integer>forTableColumn(new IntegerStringConverter()));
        HQCol.setCellFactory(TextFieldTableCell.forTableColumn());
        MCapCol.setCellFactory(TextFieldTableCell.<DotCom,Float>forTableColumn(new FloatStringConverter()));
        FoundingCol.setCellFactory(TextFieldTableCell.<DotCom,Integer>forTableColumn(new IntegerStringConverter()));

        RankCol.setOnEditCommit(editEvent ->{
            int newValue = editEvent.getNewValue();
            DotCom editedRowObject = editEvent.getRowValue();
            editedRowObject.setRank(newValue);
        });

        NameCol.setOnEditCommit(editEvent ->{
            String newValue = editEvent.getNewValue();
            DotCom editedRowObject = editEvent.getRowValue();
            editedRowObject.setName(newValue);
        });

        


        //DotCom.initialize();
        boolean DataExists = loadData();
        if (DataExists) {
            updateDotComs();
            myAccordion.setExpandedPane(DotComPane);
        }
    }

    public void saveData() {
        DotCom.save();
    }

    public boolean loadData() {
        boolean DotComRestored = DotCom.load();
        if (DotComRestored) {
            return true;
        }

        return false;
    }

    public void importDotComs() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile != null && selectedFile.exists()) {
            DotCom.read(selectedFile.getPath());
            updateDotComs();
        }
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
