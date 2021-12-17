package com.example.basketballstats;


import com.sun.javafx.scene.text.FontHelper;
import java.io.FilePermission;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.sun.javafx.tk.Toolkit;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lName;
    @FXML
    private RadioButton rbEditModeOn;
    @FXML
    private RadioButton rbEditModeOff;
    @FXML
    private TableView<Players> tvBoxScore;
    @FXML
    private TableColumn<Players, String>colName;
    @FXML
    private TableColumn<Players, String>colSurname;
    @FXML
    private TableColumn<Players, Integer>colNumber;
    @FXML
    private TableColumn<Players, Integer>colPoints;
    @FXML
    private TableColumn<Players, Integer>colRebounds;
    @FXML
    private TableColumn<Players, Integer> colAssists;
    @FXML
    private TableColumn<Players, Integer> colSteals;
    @FXML
    private TableColumn<Players, Integer>colBlocks;
    @FXML
    private TableColumn<Players, Integer>colMissTwo;
    @FXML
    private TableColumn<Players, Integer>colMissThree;
    @FXML
    private TableColumn<Players, Integer>colMissOne;
    @FXML
    private TableColumn<Players, Integer>colTurnovers;
    @FXML
    private TableColumn<Players, Integer>colMadeOne;
    @FXML
    private TableColumn<Players, Integer>colMadeTwo;
    @FXML
    private TableColumn<Players, Integer>colMadeThree;

    @FXML
    private TableView<PlayersAway> tvBoxScoreAway;
    @FXML
    private TableColumn<PlayersAway, String>colNameAway;
    @FXML
    private TableColumn<PlayersAway, String>colSurnameAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colNumberAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colPointsAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colReboundsAway;
    @FXML
    private TableColumn<PlayersAway, Integer> colAssistsAway;
    @FXML
    private TableColumn<PlayersAway, Integer> colStealsAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colBlocksAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMissTwoAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMissThreeAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMissOneAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colTurnoversAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMadeOneAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMadeTwoAway;
    @FXML
    private TableColumn<PlayersAway, Integer>colMadeThreeAway;


    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSurname;
    @FXML
    private TextField tfNumber;
    @FXML
    private TextField tfPoints;
    @FXML
    private TextField tfRebounds;
    @FXML
    private TextField tfAssists;
    @FXML
    private TextField tfSteals;
    @FXML
    private TextField tfBlocks;
    @FXML
    private TextField tfMissTwo;
    @FXML
    private TextField tfMissThree;
    @FXML
    private TextField tfMissOne;
    @FXML
    private TextField tfTurnovers;
    @FXML
    private TextField tfMadeOne;
    @FXML
    private TextField tfMadeTwo;
    @FXML
    private TextField tfMadeThree;
    @FXML
    private TextField tfFreeThrowP;
    @FXML
    private TextField tfFieldGoalP;
    @FXML
    private TextField tfThreePointP;

    private Stage stage;
    private Scene scene;
    private Parent root;

    int playerCounter = 0; //iteration each player from tableview
    int playerCounterAway = 0;
    int save = 0; //doesn't overwrite .txt; create new
    int saveAway = 0;
    int saveCounter = 0; //without it I cannot block user from import as many times as he want.
    // If he would for example import two times, tableview won't delete first save but combine two :/
    int saveCounterAway = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        colName.setCellValueFactory(new PropertyValueFactory<Players, String>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<Players, String>("surname"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Players, Integer>("number"));
        colPoints.setCellValueFactory(new PropertyValueFactory<Players, Integer>("points"));
        colRebounds.setCellValueFactory(new PropertyValueFactory<Players, Integer>("rebounds"));
        colAssists.setCellValueFactory(new PropertyValueFactory<Players, Integer>("assists"));
        colSteals.setCellValueFactory(new PropertyValueFactory<Players, Integer>("steals"));
        colBlocks.setCellValueFactory(new PropertyValueFactory<Players, Integer>("blocks"));
        colMissTwo.setCellValueFactory(new PropertyValueFactory<Players, Integer>("missTwo"));
        colMissThree.setCellValueFactory(new PropertyValueFactory<Players, Integer>("missThree"));
        colMissOne.setCellValueFactory(new PropertyValueFactory<Players, Integer>("missOne"));
        colTurnovers.setCellValueFactory(new PropertyValueFactory<Players, Integer>("turnovers"));
        colMadeOne.setCellValueFactory(new PropertyValueFactory<Players, Integer>("madeOne"));
        colMadeTwo.setCellValueFactory(new PropertyValueFactory<Players, Integer>("madeTwo"));
        colMadeThree.setCellValueFactory(new PropertyValueFactory<Players, Integer>("madeThree"));
        setCellValue();

        colNameAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, String>("name"));
        colSurnameAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, String>("surname"));
        colNumberAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("number"));
        colPointsAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("points"));
        colReboundsAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("rebounds"));
        colAssistsAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("assists"));
        colStealsAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("steals"));
        colBlocksAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("blocks"));
        colMissTwoAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("missTwo"));
        colMissThreeAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("missThree"));
        colMissOneAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("missOne"));
        colTurnoversAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("turnovers"));
        colMadeOneAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("madeOne"));
        colMadeTwoAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("madeTwo"));
        colMadeThreeAway.setCellValueFactory(new PropertyValueFactory<PlayersAway, Integer>("madeThree"));
        setCellValue();
    }


    private void setCellValue()
    {
        tvBoxScore.setOnMouseClicked(e -> {
            Players pl = tvBoxScore.getItems().get(tvBoxScore.getSelectionModel().getSelectedIndex());
            tfName.setText(pl.getName());
            tfSurname.setText(pl.getSurname());
            tfNumber.setText(String.valueOf(pl.getNumber()));
            tfPoints.setText(String.valueOf(pl.getPoints()));
            tfRebounds.setText(String.valueOf(pl.getRebounds()));
            tfAssists.setText(String.valueOf(pl.getAssists()));
            tfSteals.setText(String.valueOf(pl.getSteals()));
            tfBlocks.setText(String.valueOf(pl.getBlocks()));
            tfMissTwo.setText(String.valueOf(pl.getMissTwo()));
            tfMissThree.setText(String.valueOf(pl.getMissThree()));
            tfMissOne.setText(String.valueOf(pl.getMissOne()));
            tfTurnovers.setText(String.valueOf(pl.getTurnovers()));
            tfMadeOne.setText(String.valueOf(pl.getMadeOne()));
            tfMadeTwo.setText(String.valueOf(pl.getMadeTwo()));
            tfMadeThree.setText(String.valueOf(pl.getMadeThree()));
            tvBoxScoreAway.getSelectionModel().clearSelection();

            //free throw
            double fT = Integer.parseInt(tfMadeOne.getText());
            double fTA = Integer.parseInt(tfMissOne.getText());
            double fTP = fT / (fT + fTA);

            //three point
            double tP = Integer.parseInt(tfMadeThree.getText());
            double tPA = Integer.parseInt(tfMissThree.getText());
            double tPP = tP / (tP + tPA);

            //field goal
            double mP = Integer.parseInt(tfMadeTwo.getText());
            double mPA = Integer.parseInt(tfMissTwo.getText());
            double mPP = (mP + tP + fT) / (mP + tP + fT + mPA + tPA + fTA);

            //Free Throw % counter
            if (fT != 0 && fTA != 0)
            {
                tfFreeThrowP.setText((fTP) + "%");
            }
            else if (fTA > 0 && fT == 0)
            {
                tfFreeThrowP.setText("0");
            }
            else if (fT > 0)
            {
                tfFreeThrowP.setText("100");
            }

            //Three Point % counter
            if (tP != 0 && tPA != 0)
            {
                tfThreePointP.setText((tPP) + "%");
            }
            else if (tPA > 0 && tP == 0)
            {
                tfThreePointP.setText("0" + "%");
            }
            else if (tP > 0)
            {
                tfThreePointP.setText("100" + "%");
            }

            // Field Goal % counter
            if (tP != 0 && tPA != 0)
            {
                tfFieldGoalP.setText((mPP) + "%");
            }
            else if (tPA > 0 && tP == 0 && fTA > 0 && fT == 0 && mPA > 0 && mP == 0)
            {
                tfFieldGoalP.setText("0" + "%");
            }
            else if (tP > 0 && fT > 0 && mP > 0)
            {
                tfFieldGoalP.setText("100" + "%");
            }

        });

        tvBoxScoreAway.setOnMouseClicked(e -> {
            PlayersAway pl = tvBoxScoreAway.getItems().get(tvBoxScoreAway.getSelectionModel().getSelectedIndex());
            tfName.setText(pl.getName());
            tfSurname.setText(pl.getSurname());
            tfNumber.setText(String.valueOf(pl.getNumber()));
            tfPoints.setText(String.valueOf(pl.getPoints()));
            tfRebounds.setText(String.valueOf(pl.getRebounds()));
            tfAssists.setText(String.valueOf(pl.getAssists()));
            tfSteals.setText(String.valueOf(pl.getSteals()));
            tfBlocks.setText(String.valueOf(pl.getBlocks()));
            tfMissTwo.setText(String.valueOf(pl.getMissTwo()));
            tfMissThree.setText(String.valueOf(pl.getMissThree()));
            tfMissOne.setText(String.valueOf(pl.getMissOne()));
            tfTurnovers.setText(String.valueOf(pl.getTurnovers()));
            tfMadeOne.setText(String.valueOf(pl.getMadeOne()));
            tfMadeTwo.setText(String.valueOf(pl.getMadeTwo()));
            tfMadeThree.setText(String.valueOf(pl.getMadeThree()));
            tvBoxScore.getSelectionModel().clearSelection();

            //free throw
            double fT = Integer.parseInt(tfMadeOne.getText());
            double fTA = Integer.parseInt(tfMissOne.getText());
            double fTP = fT / (fT + fTA);

            //three point
            double tP = Integer.parseInt(tfMadeThree.getText());
            double tPA = Integer.parseInt(tfMissThree.getText());
            double tPP = tP / (tP + tPA);

            //field goal
            double mP = Integer.parseInt(tfMadeTwo.getText());
            double mPA = Integer.parseInt(tfMissTwo.getText());
            double mPP = (mP + tP + fT) / (mP + tP + fT + mPA + tPA + fTA);

            //Free Throw % counter
            if (fT != 0 && fTA != 0)
            {
                tfFreeThrowP.setText((fTP) + "%");
            }
            else if (fTA > 0 && fT == 0)
            {
                tfFreeThrowP.setText("0");
            }
            else if (fT > 0)
            {
                tfFreeThrowP.setText("100");
            }

            //Three Point % counter
            if (tP != 0 && tPA != 0)
            {
                tfThreePointP.setText((tPP) + "%");
            }
            else if (tPA > 0 && tP == 0)
            {
                tfThreePointP.setText("0" + "%");
            }
            else if (tP > 0)
            {
                tfThreePointP.setText("100" + "%");
            }

            // Field Goal % counter
            if (tP != 0 && tPA != 0)
            {
                tfFieldGoalP.setText((mPP) + "%");
            }
            else if (tPA > 0 && tP == 0 && fTA > 0 && fT == 0 && mPA > 0 && mP == 0)
            {
                tfFieldGoalP.setText("0" + "%");
            }
            else if (tP > 0 && fT > 0 && mP > 0)
            {
                tfFieldGoalP.setText("100" + "%");
            }

        });

        tfName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("[^\\d]"))
                {
                    tfName.setText(t1.replaceAll("\\d*", ""));
                }
            }
        });

        tfSurname.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("[^\\d]"))
                {
                    tfSurname.setText(t1.replaceAll("\\d*", ""));
                }
            }
        });

        tfNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfNumber.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfPoints.setText("0");
        tfPoints.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfPoints.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfRebounds.setText("0");
        tfRebounds.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfRebounds.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfAssists.setText("0");
        tfAssists.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfAssists.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfSteals.setText("0");
        tfSteals.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfSteals.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfBlocks.setText("0");
        tfBlocks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfBlocks.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMissTwo.setText("0");
        tfMissTwo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMissTwo.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMissThree.setText("0");
        tfMissThree.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMissThree.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMissOne.setText("0");
        tfMissOne.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMissOne.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfTurnovers.setText("0");
        tfTurnovers.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfTurnovers.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMadeOne.setText("0");
        tfMadeOne.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMadeOne.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMadeTwo.setText("0");
        tfMadeTwo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMadeTwo.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        tfMadeThree.setText("0");
        tfMadeThree.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                    tfMadeThree.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        rbEditModeOn.setSelected(true);
    }


    public void saveButton(ActionEvent event)
    {
        if (playerCounter == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Box Score is empty!");
            alert.setHeaderText("ERROR");
            alert.setContentText("You need to fill box score with players to save file!");
            alert.showAndWait();
        }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Paweł\\Desktop\\C++\\statsHome" + save + ".txt" , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            int numberOfPlayers = playerCounter;
            int column = 0;
            int row = 0;
            while (column != numberOfPlayers)
            {
                if (row == 15)
                {
                    pw.println();
                    column++;
                    row = 0;
                } else
                {
                    String a = tvBoxScore.getColumns().get(row).getCellObservableValue(column).getValue().toString();
                    pw.print(a +";");
                    row++;
                }
            }
            pw.flush();
            pw.close();
            save++;

        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Box Score is empty!");
            alert.setHeaderText("ERROR");
            alert.setContentText("You need to fill box score with home players to save file!");
            alert.showAndWait();
        }

    }

    public void insertButton(ActionEvent event)
    {

        try {
            Players players = new Players(tfName.getText(), tfSurname.getText(), Integer.parseInt(tfNumber.getText()),
                    Integer.parseInt(tfPoints.getText()), Integer.parseInt(tfRebounds.getText()), Integer.parseInt(tfAssists.getText()), Integer.parseInt(tfSteals.getText()),
                    Integer.parseInt(tfBlocks.getText()), Integer.parseInt(tfMissTwo.getText()), Integer.parseInt(tfMissThree.getText()), Integer.parseInt(tfMissOne.getText()),
                    Integer.parseInt(tfTurnovers.getText()), Integer.parseInt(tfMadeOne.getText()), Integer.parseInt(tfMadeTwo.getText()), Integer.parseInt(tfMadeThree.getText()));
            ObservableList<Players> player = tvBoxScore.getItems();
            player.add(players);
            tvBoxScore.setItems(player);
            tfName.setText("");
            tfSurname.setText("");
            tfNumber.setText("");
            tfPoints.setText("0");
            tfRebounds.setText("0");
            tfAssists.setText("0");
            tfSteals.setText("0");
            tfBlocks.setText("0");
            tfMissTwo.setText("0");
            tfMissThree.setText("0");
            tfMissOne.setText("0");
            tfTurnovers.setText("0");
            tfMadeOne.setText("0");
            tfMadeTwo.setText("0");
            tfMadeThree.setText("0");
            playerCounter++;
            tvBoxScore.getSortOrder().add(colNumber);
        } catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Text Fields are empty!");
            alert.setHeaderText("ERROR");
            alert.setContentText("Check yours text fields! They cannot be empty!");
            alert.showAndWait();
    }

    }

    public void updateButton(ActionEvent event)
    {
        try {
            int selectedPlayer = tvBoxScore.getSelectionModel().getSelectedIndex();
            tvBoxScore.getItems().remove(selectedPlayer);

            int one = Integer.parseInt(tfMadeOne.getText());
            int two = Integer.parseInt(tfMadeTwo.getText());
            int three = Integer.parseInt(tfMadeThree.getText());
            int sum = one + (two * 2) + (three * 3);
            tfPoints.setText(String.valueOf(sum));

            Players players = new Players(tfName.getText(), tfSurname.getText(), Integer.parseInt(tfNumber.getText()),
                    Integer.parseInt(tfPoints.getText()), Integer.parseInt(tfRebounds.getText()), Integer.parseInt(tfAssists.getText()), Integer.parseInt(tfSteals.getText()),
                    Integer.parseInt(tfBlocks.getText()), Integer.parseInt(tfMissTwo.getText()), Integer.parseInt(tfMissThree.getText()), Integer.parseInt(tfMissOne.getText()),
                    Integer.parseInt(tfTurnovers.getText()), Integer.parseInt(tfMadeOne.getText()), Integer.parseInt(tfMadeTwo.getText()), Integer.parseInt(tfMadeThree.getText()));
            ObservableList<Players> player = tvBoxScore.getItems();
            player.add(players);
            tvBoxScore.setItems(player);

            tvBoxScore.getSortOrder().add(colNumber);
            tvBoxScore.getSelectionModel().clearSelection();
        } catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Select player");
            alert.setHeaderText("ERROR");
            alert.setContentText("First you need to select home player to update his stats!");
            alert.showAndWait();
        }
        //free throw
        double fT = Integer.parseInt(tfMadeOne.getText());
        double fTA = Integer.parseInt(tfMissOne.getText());
        double fTP = fT / (fT + fTA);

        //three point
        double tP = Integer.parseInt(tfMadeThree.getText());
        double tPA = Integer.parseInt(tfMissThree.getText());
        double tPP = tP / (tP + tPA);

        //field goal
        double mP = Integer.parseInt(tfMadeTwo.getText());
        double mPA = Integer.parseInt(tfMissTwo.getText());
        double mPP = (mP + tP + fT) / (mP + tP + fT + mPA + tPA + fTA);

        //Free Throw % counter
        if (fT != 0 && fTA != 0)
        {
            tfFreeThrowP.setText((fTP) + "%");
        }
        else if (fTA > 0 && fT == 0)
        {
            tfFreeThrowP.setText("0");
        }
        else if (fT > 0)
        {
            tfFreeThrowP.setText("100");
        }

        //Three Point % counter
        if (tP != 0 && tPA != 0)
        {
            tfThreePointP.setText((tPP) + "%");
        }
        else if (tPA > 0 && tP == 0)
        {
            tfThreePointP.setText("0" + "%");
        }
        else if (tP > 0)
        {
            tfThreePointP.setText("100" + "%");
        }

        // Field Goal % counter
        if (tP != 0 && tPA != 0)
        {
            tfFieldGoalP.setText((mPP) + "%");
        }
        else if (tPA > 0 && tP == 0 && fTA > 0 && fT == 0 && mPA > 0 && mP == 0)
        {
            tfFieldGoalP.setText("0" + "%");
        }
        else if (tP > 0 && fT > 0 && mP > 0)
        {
            tfFieldGoalP.setText("100" + "%");
        }


    }

    public void deleteButton(ActionEvent event)
    {
        try {
            int selectedPlayer = tvBoxScore.getSelectionModel().getSelectedIndex();
            tvBoxScore.getItems().remove(selectedPlayer);
        } catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Select Player!");
            alert.setHeaderText("ERROR");
            alert.setContentText("To delete player, first you need to select it!");
            alert.showAndWait();
        }
    }

    public void importPlayers(ActionEvent event)
    {
        if (saveCounter >= 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Loaded more than once!");
            alert.setHeaderText("ERROR");
            alert.setContentText("You can only load files once! Restart program to do it again!");
            alert.showAndWait();
        } else
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Paweł\\Desktop\\C++"));
            int response = fileChooser.showSaveDialog(null);
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            try {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line = br.readLine();
                String[] array;
                array = line.split(";");
                if (array == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Wrong file type!");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("You can only load files, that was save by this program!");
                    alert.showAndWait();
                } else {
                    while ((br.readLine()) != null) {
                        tvBoxScore.getItems().add(new Players(array[0], array[1],
                                Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]),
                                Integer.parseInt(array[5]), Integer.parseInt(array[6]), Integer.parseInt(array[7]),
                                Integer.parseInt(array[8]), Integer.parseInt(array[9]), Integer.parseInt(array[10]),
                                Integer.parseInt(array[11]), Integer.parseInt(array[12]), Integer.parseInt(array[13]),
                                Integer.parseInt(array[14])));

                    }
                    br.close();
                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Wrong file type!");
                alert.setHeaderText("ERROR");
                alert.setContentText("You can only load files, that was save by this program!");
                alert.showAndWait();
            }
            saveCounter++;
        }
    }

    public void insertButtonAway(ActionEvent event)
    {
        try {
            PlayersAway playersAway = new PlayersAway(tfName.getText(), tfSurname.getText(), Integer.parseInt(tfNumber.getText()),
                    Integer.parseInt(tfPoints.getText()), Integer.parseInt(tfRebounds.getText()), Integer.parseInt(tfAssists.getText()), Integer.parseInt(tfSteals.getText()),
                    Integer.parseInt(tfBlocks.getText()), Integer.parseInt(tfMissTwo.getText()), Integer.parseInt(tfMissThree.getText()), Integer.parseInt(tfMissOne.getText()),
                    Integer.parseInt(tfTurnovers.getText()), Integer.parseInt(tfMadeOne.getText()), Integer.parseInt(tfMadeTwo.getText()), Integer.parseInt(tfMadeThree.getText()));
            ObservableList<PlayersAway> playerAway = tvBoxScoreAway.getItems();
            playerAway.add(playersAway);
            tvBoxScoreAway.setItems(playerAway);
            tfName.setText("");
            tfSurname.setText("");
            tfNumber.setText("");
            tfPoints.setText("0");
            tfRebounds.setText("0");
            tfAssists.setText("0");
            tfSteals.setText("0");
            tfBlocks.setText("0");
            tfMissTwo.setText("0");
            tfMissThree.setText("0");
            tfMissOne.setText("0");
            tfTurnovers.setText("0");
            tfMadeOne.setText("0");
            tfMadeTwo.setText("0");
            tfMadeThree.setText("0");
            tvBoxScoreAway.getSortOrder().add(colNumberAway);
            playerCounterAway++;
        } catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Text Fields are empty!");
            alert.setHeaderText("ERROR");
            alert.setContentText("Check yours text fields! They cannot be empty!");
            alert.showAndWait();
        }
    }

    public void deleteButtonAway(ActionEvent event) {
        try {
            int selectedPlayer = tvBoxScoreAway.getSelectionModel().getSelectedIndex();
            tvBoxScoreAway.getItems().remove(selectedPlayer);
        } catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Select Player!");
            alert.setHeaderText("ERROR");
            alert.setContentText("To delete player, first you need to select it!");
            alert.showAndWait();
        }
    }



    public void updateButtonAway(ActionEvent event)
    {

//        btnUpdateAway.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER)
//            {
//                System.out.println("A key was pressed");
//            }
//        });

        try {
            int selectedPlayer = tvBoxScoreAway.getSelectionModel().getSelectedIndex();
            tvBoxScoreAway.getItems().remove(selectedPlayer);

            int one = Integer.parseInt(tfMadeOne.getText());
            int two = Integer.parseInt(tfMadeTwo.getText());
            int three = Integer.parseInt(tfMadeThree.getText());
            int sum = one + (two * 2) + (three * 3);
            tfPoints.setText(String.valueOf(sum));

            PlayersAway playersAway = new PlayersAway(tfName.getText(), tfSurname.getText(), Integer.parseInt(tfNumber.getText()),
                    Integer.parseInt(tfPoints.getText()), Integer.parseInt(tfRebounds.getText()), Integer.parseInt(tfAssists.getText()), Integer.parseInt(tfSteals.getText()),
                    Integer.parseInt(tfBlocks.getText()), Integer.parseInt(tfMissTwo.getText()), Integer.parseInt(tfMissThree.getText()), Integer.parseInt(tfMissOne.getText()),
                    Integer.parseInt(tfTurnovers.getText()), Integer.parseInt(tfMadeOne.getText()), Integer.parseInt(tfMadeTwo.getText()), Integer.parseInt(tfMadeThree.getText()));
            ObservableList<PlayersAway> playerAway = tvBoxScoreAway.getItems();
            playerAway.add(playersAway);
            tvBoxScoreAway.setItems(playerAway);
            tvBoxScoreAway.getSortOrder().add(colNumberAway);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Select player");
            alert.setHeaderText("ERROR");
            alert.setContentText("First you need to select away player to update his stats!");
            alert.showAndWait();
        }
        //free throw
        double fT = Integer.parseInt(tfMadeOne.getText());
        double fTA = Integer.parseInt(tfMissOne.getText());
        double fTP = fT / (fT + fTA);

        //three point
        double tP = Integer.parseInt(tfMadeThree.getText());
        double tPA = Integer.parseInt(tfMissThree.getText());
        double tPP = tP / (tP + tPA);

        //field goal
        double mP = Integer.parseInt(tfMadeTwo.getText());
        double mPA = Integer.parseInt(tfMissTwo.getText());
        double mPP = (mP + tP + fT) / (mP + tP + fT + mPA + tPA + fTA);

        //Free Throw % counter
        if (fT != 0 && fTA != 0)
        {
            tfFreeThrowP.setText((fTP) + "%");
        }
        else if (fTA > 0 && fT == 0)
        {
            tfFreeThrowP.setText("0");
        }
        else if (fT > 0)
        {
            tfFreeThrowP.setText("100");
        }

        //Three Point % counter
        if (tP != 0 && tPA != 0)
        {
            tfThreePointP.setText((tPP) + "%");
        }
        else if (tPA > 0 && tP == 0)
        {
            tfThreePointP.setText("0" + "%");
        }
        else if (tP > 0)
        {
            tfThreePointP.setText("100" + "%");
        }

        // Field Goal % counter
        if (tP != 0 && tPA != 0)
        {
            tfFieldGoalP.setText((mPP) + "%");
        }
        else if (tPA > 0 && tP == 0 && fTA > 0 && fT == 0 && mPA > 0 && mP == 0)
        {
            tfFieldGoalP.setText("0" + "%");
        }
        else if (tP > 0 && fT > 0 && mP > 0)
        {
            tfFieldGoalP.setText("100" + "%");
        }
    }

    public void saveButtonAway(ActionEvent event)
    {
        if (playerCounterAway == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Box Score is empty!");
            alert.setHeaderText("ERROR");
            alert.setContentText("You need to fill box score with away players to save file!");
            alert.showAndWait();
        }
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Paweł\\Desktop\\C++\\statsAway" + saveAway + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            int numberOfPlayers = playerCounterAway;
            int column = 0;
            int row = 0;
            while (column != numberOfPlayers)
            {
                if (row == 15)
                {
                    pw.println();
                    column++;
                    row = 0;
                } else
                {
                    String a = tvBoxScoreAway.getColumns().get(row).getCellObservableValue(column).getValue().toString();
                    pw.print(a +";");
                    row++;
                }

            }

            pw.println("-------------------------------");

            pw.flush();
            pw.close();
            saveAway++;
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error");
            alert.setHeaderText("ERROR");
            alert.setContentText("message");
            alert.showAndWait();
        }

    }

    public void importPlayersAway(ActionEvent event)
    {

        if (saveCounterAway >= 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Loaded more than once!");
            alert.setHeaderText("ERROR");
            alert.setContentText("You can only load files once! Restart program to do it again!");
            alert.showAndWait();
        } else
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Paweł\\Desktop\\C++"));
            int response = fileChooser.showSaveDialog(null);
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            try {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line = br.readLine();
                String[] array;
                array = line.split(";");
                if (array == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Wrong file type!");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("You can only load files, that was save by this program!");
                    alert.showAndWait();
                } else {
                    while ((br.readLine()) == "-------------------------------")
                    {
                        tvBoxScore.getItems().add(new Players(array[0], array[1],
                                Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]),
                                Integer.parseInt(array[5]), Integer.parseInt(array[6]), Integer.parseInt(array[7]),
                                Integer.parseInt(array[8]), Integer.parseInt(array[9]), Integer.parseInt(array[10]),
                                Integer.parseInt(array[11]), Integer.parseInt(array[12]), Integer.parseInt(array[13]),
                                Integer.parseInt(array[14])));

                    }
                    while ((br.readLine()) != null)
                    {
                        tvBoxScoreAway.getItems().add(new PlayersAway(array[0], array[1],
                                Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]),
                                Integer.parseInt(array[5]), Integer.parseInt(array[6]), Integer.parseInt(array[7]),
                                Integer.parseInt(array[8]), Integer.parseInt(array[9]), Integer.parseInt(array[10]),
                                Integer.parseInt(array[11]), Integer.parseInt(array[12]), Integer.parseInt(array[13]),
                                Integer.parseInt(array[14])));

                    }

                    br.close();
                }
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Wrong file type!");
                alert.setHeaderText("ERROR");
                alert.setContentText("You can only load files, that was save by this program!");
                alert.showAndWait();
            }
            saveCounterAway++;
        }

    }

    public void plusMadeOnePoint(ActionEvent event)
    {

        int plusMadeOneTF = Integer.parseInt(tfMadeOne.getText());
        tfMadeOne.setText(String.valueOf(plusMadeOneTF + 1));
    }
    public void minusMadeOnePoint(ActionEvent event)
    {

        int minusMadeOneTF = Integer.parseInt(tfMadeOne.getText());
        tfMadeOne.setText(String.valueOf(minusMadeOneTF - 1));
    }

    public void plusMadeTwoPoints(ActionEvent event) {
        int plusMadeTwoTF = Integer.parseInt(tfMadeTwo.getText());
        tfMadeTwo.setText(String.valueOf(plusMadeTwoTF + 1));
    }

    public void minusMadeTwoPoints(ActionEvent event) {
        int minusMadeTwoTF = Integer.parseInt(tfMadeTwo.getText());
        tfMadeTwo.setText(String.valueOf(minusMadeTwoTF - 1));
    }

    public void plusMadeThreePoints(ActionEvent event) {
        int plusMadeThreeTF = Integer.parseInt(tfMadeThree.getText());
        tfMadeThree.setText(String.valueOf(plusMadeThreeTF + 1));
    }

    public void minusMadeThreePoints(ActionEvent event) {
        int minusMadeThreeTF = Integer.parseInt(tfMadeThree.getText());
        tfMadeThree.setText(String.valueOf(minusMadeThreeTF - 1));
    }

    public void btnPlusMissOnePoint(ActionEvent event) {
        int plusMissOneTF = Integer.parseInt(tfMissOne.getText());
        tfMissOne.setText(String.valueOf(plusMissOneTF + 1));
    }

    public void btnMinusMissOnePoint(ActionEvent event) {
        int minusMissOneTF = Integer.parseInt(tfMissOne.getText());
        tfMissOne.setText(String.valueOf(minusMissOneTF - 1));
    }

    public void btnPlusMissTwoPoints(ActionEvent event) {
        int plusMissTwoTF = Integer.parseInt(tfMissTwo.getText());
        tfMissTwo.setText(String.valueOf(plusMissTwoTF + 1));
    }

    public void minusMissTwoPoints(ActionEvent event) {
        int minusMissTwoTF = Integer.parseInt(tfMissTwo.getText());
        tfMissTwo.setText(String.valueOf(minusMissTwoTF - 1));
    }

    public void plusMissThreePoints(ActionEvent event) {
        int plusMissThreeTF = Integer.parseInt(tfMissThree.getText());
        tfMissThree.setText(String.valueOf(plusMissThreeTF + 1));
    }

    public void minusMissThreePoints(ActionEvent event) {
        int minusMissThreeTF = Integer.parseInt(tfMissThree.getText());
        tfMissThree.setText(String.valueOf(minusMissThreeTF - 1));
    }

    public void plusTurnover(ActionEvent event) {
        int plusTurnoverTF = Integer.parseInt(tfTurnovers.getText());
        tfTurnovers.setText(String.valueOf(plusTurnoverTF + 1));
    }

    public void minusTurnover(ActionEvent event) {
        int minusTurnoverTF = Integer.parseInt(tfTurnovers.getText());
        tfTurnovers.setText(String.valueOf(minusTurnoverTF - 1));
    }

    public void plusPoint(ActionEvent event) {
        int plusPointTF = Integer.parseInt(tfPoints.getText());
        tfPoints.setText(String.valueOf(plusPointTF + 1));
    }

    public void minusPoint(ActionEvent event) {
        int minusPointTF = Integer.parseInt(tfPoints.getText());
        tfPoints.setText(String.valueOf(minusPointTF - 1));
    }

    public void plusRebound(ActionEvent event) {
        int plusReboundTF = Integer.parseInt(tfRebounds.getText());
        tfRebounds.setText(String.valueOf(plusReboundTF + 1));
    }

    public void minusRebound(ActionEvent event) {
        int minusReboundTF = Integer.parseInt(tfRebounds.getText());
        tfRebounds.setText(String.valueOf(minusReboundTF - 1));
    }

    public void plusAssist(ActionEvent event) {
        int plusAssistTF = Integer.parseInt(tfAssists.getText());
        tfAssists.setText(String.valueOf(plusAssistTF + 1));
    }

    public void minusAssist(ActionEvent event) {
        int minusAssistTF = Integer.parseInt(tfAssists.getText());
        tfAssists.setText(String.valueOf(minusAssistTF - 1));
    }

    public void plusSteal(ActionEvent event)
    {
        int plusStealTF = Integer.parseInt(tfSteals.getText());
        tfSteals.setText(String.valueOf(plusStealTF + 1));
    }

    public void minusSteal(ActionEvent event)
    {
        int minusStealTF = Integer.parseInt(tfSteals.getText());
        tfSteals.setText(String.valueOf(minusStealTF - 1));
    }

    public void plusBlock(ActionEvent event)
    {
        int plusBlockTF = Integer.parseInt(tfBlocks.getText());
        tfBlocks.setText(String.valueOf(plusBlockTF + 1));
    }

    public void minusBlock(ActionEvent event)
    {
        int minusBlockTF = Integer.parseInt(tfBlocks.getText());
        tfBlocks.setText(String.valueOf(minusBlockTF - 1));
    }

    public void addReboundWithMadeTwo(ActionEvent event)
    {
        int addRebound = Integer.parseInt(tfRebounds.getText());
        int addMadeTwo = Integer.parseInt(tfMadeTwo.getText());
        tfRebounds.setText(String.valueOf(addRebound + 1));
        tfMadeTwo.setText(String.valueOf(addMadeTwo + 1));
    }

    public void addReboundWithMissTwo(ActionEvent event)
    {
        int addRebound = Integer.parseInt(tfRebounds.getText());
        int addMissTwo = Integer.parseInt(tfMissTwo.getText());
        tfRebounds.setText(String.valueOf(addRebound + 1));
        tfMissTwo.setText(String.valueOf(addMissTwo + 1));
    }

    public void turnEditModeOn(ActionEvent event)
    {
        rbEditModeOn.setSelected(true);
        rbEditModeOff.setSelected(false);
        tfName.setEditable(true);
        tfName.setVisible(true);
        lName.setVisible(true);
        tfName.setText("");
    }

    public void turnEditModeOff(ActionEvent event)
    {
        rbEditModeOff.setSelected(true);
        rbEditModeOn.setSelected(false);
        tfName.setEditable(false);
        tfName.setVisible(false);
        lName.setVisible(false);
    }
}





