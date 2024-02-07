package controller;

import bo.BoFactory;
import bo.custom.ItemBo;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.ItemDto;
import dto.tm.ItemTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import static controller.LogInFormController.stillUser;

public class ItemAddingFormController {

    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colEmail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public Label lblCustomerId;
    public TableView tblItem;
    @FXML
    private TableColumn colItemCategory;

    @FXML
    private TableColumn colItemId;

    @FXML
    private TableColumn colItemName;

    @FXML
    private TableColumn colOption;

    @FXML
    private Label lblItemId;

    @FXML
    private TableView tblCustomer;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtSearch;

    private ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);

    public void initialize(){
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        setItemId();
        loadItemTable();

        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((ItemTm) newValue);
        });
    }

    private void setItemId() {
        try {
            lblItemId.setText(itemBo.generateId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setData(ItemTm newValue) {
        if (newValue != null) {
            lblItemId.setText(newValue.getItemCode());
            txtItemName.setText(newValue.getItemName());
            txtCategory.setText(String.valueOf(newValue.getCategory()));
        }
    }

    private void loadItemTable() {
        ObservableList<ItemTm> tmList = FXCollections.observableArrayList();

        try {
            List<ItemDto> dtoList  =itemBo.allItems();
            for (ItemDto dto:dtoList) {
                Button btn = new Button("Delete");
                ItemTm c = new ItemTm(
                        dto.getItemCode(),
                        dto.getItemName(),
                        dto.getCategory(),
                        btn
                );

                btn.setOnAction(actionEvent -> {
                    deleteItem(c.getItemCode());
                });

                tmList.add(c);
            }
            tblItem.setItems(tmList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteItem(String code) {

        try {
            boolean isDeleted = itemBo.deleteItem(code);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Item Deleted!").show();
                loadItemTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void btnSearchOnAction(ActionEvent actionEvent) {

    }

    @FXML
    void backToHomeBtnOnAction(ActionEvent event) {
        if(checkUser(stillUser)) {
            Stage stage = (Stage) lblItemId.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForEmployeeForm.fxml"))));
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Stage stage = (Stage) lblItemId.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForAdminForm.fxml"))));
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkUser(String jobRole){
        if (jobRole.equals("Employee")){
            return true;
        }
        return false;
    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(lblItemId.getText(),
                txtItemName.getText(),
                txtCategory.getText()
        );

        try {
            boolean isSaved = itemBo.saveItem(dto);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Saved!").show();
                loadItemTable();
                tblItem.refresh();
                clearFields();
                setItemId();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        tblItem.refresh();
        txtCategory.clear();
        txtItemName.clear();
        lblItemId.setText("");
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(lblItemId.getText(),
                txtItemName.getText(),
                txtCategory.getText()
        );

        try {
            boolean isUpdated = itemBo.updateItem(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Item "+dto.getItemCode()+" Updated!").show();
                loadItemTable();
                clearFields();
                setItemId();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
