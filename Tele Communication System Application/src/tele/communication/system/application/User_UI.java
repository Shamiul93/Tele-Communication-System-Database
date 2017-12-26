/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tele.communication.system.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static tele.communication.system.application.TeleCommunicationSystemApplication.BackSceneOnly;
import static tele.communication.system.application.TeleCommunicationSystemApplication.InvalidLogInMsg;
import static tele.communication.system.application.TeleCommunicationSystemApplication.StageShow;
import static tele.communication.system.application.TeleCommunicationSystemApplication.SuccessMsg;
import static tele.communication.system.application.TeleCommunicationSystemApplication.root;
import static tele.communication.system.application.TeleCommunicationSystemApplication.scene;
import static tele.communication.system.application.TeleCommunicationSystemApplication.stage;

/**
 *
 * @author HEISENBERG
 */
public class User_UI extends Application {

    public static Stage stage;
    public static Group root;
    public static Scene scene;
    public static String name;
    public static String passcode;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        InitialScene();
    }

    public static void BackSceneOnly() {
        root = new Group();
        //Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds(); 
        scene = new Scene(root, 1800, 900);
        scene.setFill(Color.rgb(255, 255, 255));//rgb(red, green, blue)
    }

    public static void StageShow() {
        stage.setTitle("USER UI");
        stage.setScene(scene);
        stage.show();
    }

    private void InitialScene() {
        BackSceneOnly();
        ImageView welcomebackscreen = new ImageView("file:Back2.jpg");
        ImageView Welcome = new ImageView("file:WelcomeMSG.png");
        Rectangle GetStartedBox = new Rectangle(500, 200);
        GetStartedBox.setFill(Color.rgb(0, 0, 0, 0));
        ImageView Get_Started = new ImageView("file:Get Started.png");
        Get_Started.setX(630);
        Get_Started.setY(400);
        Welcome.setX(100);
        Welcome.setY(100);
        welcomebackscreen.setFitHeight(900);
        welcomebackscreen.setFitWidth(1800);
        GetStartedBox.setX(630);
        GetStartedBox.setY(400);

        GetStartedBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> firstScene());

        root.getChildren().add(welcomebackscreen);
        root.getChildren().add(Welcome);
        root.getChildren().add(Get_Started);
        root.getChildren().add(GetStartedBox);
        StageShow();
    }

    private void firstScene() {
        int posX = 600, posY = 250;
        BackSceneOnly();
        Button loginBtn = new Button("Log In");
        loginBtn.setLayoutX(posX);
        loginBtn.setLayoutY(posY);

        loginBtn.setOnAction(e -> LoginScene());

        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setLayoutX(posX);
        signUpBtn.setLayoutY(posY + 100);

        signUpBtn.setOnAction(e -> SignUPScene());

        root.getChildren().add(loginBtn);
        root.getChildren().add(signUpBtn);

        StageShow();

    }

    private void SignUPScene() {

        int posX = 300, posY = 120;
        int textFieldPosX = posX + 200, textFieldPosY = posY - 15;
        int buttonPosX = textFieldPosX + 300, buttonPosY = 200;

        BackSceneOnly();
        name = new String();
        passcode = new String();

        Text Name = new Text("USER NAME : ");
        Name.setX(posX);
        Name.setY(posY);
        Name.setFill(Color.rgb(0, 0, 0));

        Text nid = new Text("NID NO : ");
        nid.setX(posX);
        nid.setY(posY + 50);
        nid.setFill(Color.rgb(0, 0, 0));

        Text sim = new Text("SIM NO : ");
        sim.setX(posX);
        sim.setY(posY + 100);
        sim.setFill(Color.rgb(0, 0, 0));

        Text db = new Text("DATE OF BIRTH (MMM DD, YYYY) : ");

        db.setX(posX);
        db.setY(posY + 150);
        db.setFill(Color.rgb(0, 0, 0));

        Text fn = new Text("FATHER'S NAME : ");
        fn.setX(posX);
        fn.setY(posY + 200);
        fn.setFill(Color.rgb(0, 0, 0));

        Text mn = new Text("MOTHER'S NAME : ");
        mn.setX(posX);
        mn.setY(posY + 250);
        mn.setFill(Color.rgb(0, 0, 0));

        Text add = new Text("ADRESS : ");
        add.setX(posX);
        add.setY(posY + 300);
        add.setFill(Color.rgb(0, 0, 0));

        Text ct = new Text("CITY : ");
        ct.setX(posX);
        ct.setY(posY + 350);
        ct.setFill(Color.rgb(0, 0, 0));
///********************Text Field************************************//

        TextField userName = new TextField();
        userName.setLayoutX(textFieldPosX);
        userName.setLayoutY(textFieldPosY);
        root.getChildren().add(userName);

        TextField NID = new TextField();
        NID.setLayoutX(textFieldPosX);
        NID.setLayoutY(textFieldPosY + 50);
        root.getChildren().add(NID);

        TextField SIM = new TextField();
        SIM.setLayoutX(textFieldPosX);
        SIM.setLayoutY(textFieldPosY + 100);
        root.getChildren().add(SIM);

        TextField bDay = new TextField();
        bDay.setLayoutX(textFieldPosX);
        bDay.setLayoutY(textFieldPosY + 150);
        root.getChildren().add(bDay);

        TextField Father = new TextField();
        Father.setLayoutX(textFieldPosX);
        Father.setLayoutY(textFieldPosY + 200);
        root.getChildren().add(Father);

        TextField Mother = new TextField();
        Mother.setLayoutX(textFieldPosX);
        Mother.setLayoutY(textFieldPosY + 250);
        root.getChildren().add(Mother);

        TextField Address = new TextField();
        Address.setLayoutX(textFieldPosX);
        Address.setLayoutY(textFieldPosY + 300);
        root.getChildren().add(Address);

        TextField City = new TextField();
        City.setLayoutX(textFieldPosX);
        City.setLayoutY(textFieldPosY + 350);
        root.getChildren().add(City);

        //********************button works********************//
        Button signUpBtn = new Button("COMPLETE SIGN UP");
        signUpBtn.setLayoutX(buttonPosX);
        signUpBtn.setLayoutY(buttonPosY);
        root.getChildren().add(signUpBtn);

        Button backToHomeBtn = new Button("Back");
        backToHomeBtn.setLayoutX(buttonPosX);
        backToHomeBtn.setLayoutY(buttonPosY + 100);
        root.getChildren().add(backToHomeBtn);

        backToHomeBtn.setOnAction(e -> firstScene());

        signUpBtn.setOnAction(e -> {
            String s1 = userName.getText();
            String s2 = NID.getText();
            String s3 = bDay.getText();
            String s4 = Father.getText();
            String s5 = Mother.getText();
            String s6 = Address.getText();
            String s7 = City.getText();

            String s8 = SIM.getText();
            boolean success = true;

            try {
                Connection con = new DataBase("TELECOM", "hr").getConnection();

                String check = "SELECT * FROM USER_DATA WHERE NID_NO = ?";
                PreparedStatement pst1 = con.prepareStatement(check);
                pst1.setString(1, s2);
                ResultSet r = pst1.executeQuery();

                if (r.next()) {
                    System.out.println("Already in database");
                    InvalidLogInMsg("Failed", "Invalid Sign Up");

                    success = false;
                    firstScene();
                }

                pst1.close();
                con.close();

                if (success == true) {

                    con = new DataBase("TELECOM", "hr").getConnection();
                    String sql = "INSERT INTO USER_DATA (USER_NAME,NID_NO,DATE_OF_BIRTH,NAME_OF_FATHER,NAME_OF_MOTHER,STREET_ADDRESS,CITY, IS_EMPLOYEE) VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, s1);
                    pst.setString(2, s2);
                    pst.setString(3, s3);
                    pst.setString(4, s4);
                    pst.setString(5, s5);
                    pst.setString(6, s6);
                    pst.setString(7, s7);
                    pst.setString(8, "NO");

                    System.out.println("baaaaaaaaaaal");
                    pst.executeQuery();

                    SuccessMsg("Success", "Sign Up Successful");

                    pst.close();
                    con.close();
                }

            } catch (Exception ex) {
                System.out.println("Data insert doesn't work");
            }

        });

        root.getChildren().add(Name);
        root.getChildren().add(nid);
        root.getChildren().add(sim);
        root.getChildren().add(db);
        root.getChildren().add(fn);
        root.getChildren().add(mn);
        root.getChildren().add(add);
        root.getChildren().add(ct);
//        root.getChildren().add(signUpBtn);

        StageShow();
    }

    private void LoginScene() {
        int posX = 350, posY = 300;
        int textFieldPosX = posX + 200, textFieldPosY = posY - 15;
        int buttonPosX = textFieldPosX + 300, buttonPosY = 260;

        BackSceneOnly();
        name = new String();
        passcode = new String();

        Text user = new Text("USERNAME : ");
        user.setX(posX);
        user.setY(posY);
        user.setFill(Color.rgb(0, 0, 0));

        Text pass = new Text("PASSWORD : ");
        pass.setX(posX);
        pass.setY(posY + 50);
        pass.setFill(Color.rgb(0, 0, 0));

        TextField username = new TextField();
        username.setLayoutX(textFieldPosX);
        username.setLayoutY(textFieldPosY);

        PasswordField password = new PasswordField();
        password.setLayoutX(textFieldPosX);
        password.setLayoutY(textFieldPosY + 50);

        Button loginbtn = new Button("Log In");
        loginbtn.setLayoutX(buttonPosX);
        loginbtn.setLayoutY(buttonPosY);

        Button backToHomeBtn = new Button("Back");
        backToHomeBtn.setLayoutX(buttonPosX);
        backToHomeBtn.setLayoutY(buttonPosY + 100);

        backToHomeBtn.setOnAction(e -> firstScene());

        loginbtn.setOnAction(e -> {
            name = username.getText();
            passcode = password.getText();

            boolean success = false;

            String sql = "SELECT * FROM USER_DATA WHERE USER_NAME = ? AND NID_NO = ?";
            try {
                Connection con = new DataBase("TELECOM", "hr").getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, passcode);
//                System.out.println("aaisi");
                ResultSet rs = pst.executeQuery();
                System.out.println("success");

                if (rs.next()) {
                    success = true;
                    System.out.println("success");

                    SuccessMsg("Success", "LogIn Successful");

                    pst.close();
                    con.close();

                    LogIn(name, passcode);

//                    System.out.println(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3));
//
//                    while (rs.next()) {
//                        System.out.println(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3));
//                    }
                } else {
                    System.out.println("hoy nai");
                    InvalidLogInMsg("Failed", "Invalid Log In");
                }
                //System.out.println("failed");

            } catch (Exception ex) {
                InvalidLogInMsg("Failed", "Invalid Log In");
                System.out.println("doesn,t work");
            }
        });
        root.getChildren().add(username);
        root.getChildren().add(password);
        root.getChildren().add(pass);
        root.getChildren().add(user);
        root.getChildren().add(loginbtn);
        root.getChildren().add(backToHomeBtn);
        StageShow();
    }

    public void LogIn(String User_Name, String NID_No) {
        BackSceneOnly();

        int posX = 300, posY = 170;
        int textFieldPosX = posX + 200, textFieldPosY = posY - 15;
        int buttonPosX = textFieldPosX + 300, buttonPosY = 50;

        Profile(User_Name, NID_No); // HomePage of User = User Profile

        Button profileBtn = new Button("Profile");
        SetThisButton(profileBtn, buttonPosX, buttonPosY + 50);
        profileBtn.setOnAction(e -> Profile(User_Name, NID_No));

        Button dialListBtn = new Button("Dialled Call List");
        SetThisButton(dialListBtn, buttonPosX, buttonPosY + 100);

        dialListBtn.setOnAction(e -> {
            ShowDialledCallList(NID_No);
        });

        Button receiveListBtn = new Button("Received Call List");
        SetThisButton(receiveListBtn, buttonPosX, buttonPosY + 150);

        receiveListBtn.setOnAction(e -> {
            ShowReceivedCallList(NID_No);
        });

        Button SMSListBtn = new Button("SMS List");
        SetThisButton(SMSListBtn, buttonPosX, buttonPosY + 200);

        SMSListBtn.setOnAction(e -> {
            ShowSMSList(NID_No);
        });

        Button netDataBtn = new Button("Net Usage");
        SetThisButton(netDataBtn, buttonPosX, buttonPosY + 250);

        Button makeCallBtn = new Button("Make A Call");
        SetThisButton(makeCallBtn, buttonPosX, buttonPosY + 300);

        Button sendSMSBtn = new Button("Send An SMS");
        SetThisButton(sendSMSBtn, buttonPosX, buttonPosY + 350);

        Button useNetBtn = new Button("Use Internet");
        SetThisButton(useNetBtn, buttonPosX, buttonPosY + 400);

        Button BalanceBtn = new Button("Check Balance");
        SetThisButton(BalanceBtn, buttonPosX, buttonPosY + 450);

        Button backToHomeBtn = new Button("Log Out");
        SetThisButton(backToHomeBtn, buttonPosX, buttonPosY + 500);
        backToHomeBtn.setOnAction(e -> LogOut());

        StageShow();
    }

    void LogOut() {
        firstScene();
        SuccessMsg("Success", "Log Out Successful");
    }

    public void SetThisButton(Button b, double x, double y) {
        b.setLayoutX(x);
        b.setLayoutY(y);
        root.getChildren().add(b);
    }

    public void ShowSMSList(String NID_No) {
        try {
            String sql = "SELECT C.SMS_ID , C.SENDER_NO , C.RECEIVER_NO , C.SENDING_TIME , T.TYPE_NAME\n"
                    + "FROM USER_DATA U \n"
                    + "JOIN SIM S\n"
                    + "ON(U.NID_NO = ? AND U.NID_NO = S.NID_NO)\n"
                    + "JOIN SMS_DATABASE C\n"
                    + "ON(S.PHONE_NO = C.SENDER_NO)\n"
                    + "JOIN SIM_TYPE T \n"
                    + "ON(S.TYPE_ID = T.TYPE_ID)";

            Connection con = new DataBase("TELECOM", "hr").getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, NID_No);
            ResultSet rs = pst.executeQuery();

            ObservableList<SMSData> dialList = FXCollections.observableArrayList();
            while (rs.next()) {
                dialList.add(new SMSData(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            TableColumn<SMSData, String> CallerNoColm = new TableColumn<>("SMS ID");
            CallerNoColm.setMinWidth(200);
            CallerNoColm.setCellValueFactory(new PropertyValueFactory<>("SMS_ID"));

            TableColumn<SMSData, String> ReceiverNoColm = new TableColumn<>("Sender No");
            ReceiverNoColm.setMinWidth(200);
            ReceiverNoColm.setCellValueFactory(new PropertyValueFactory<>("SenderNo"));

            TableColumn<SMSData, String> StartingTimeColm = new TableColumn<>("Receiver No");
            StartingTimeColm.setMinWidth(200);
            StartingTimeColm.setCellValueFactory(new PropertyValueFactory<>("ReceiverNo"));

            TableColumn<SMSData, String> EndingTimeColm = new TableColumn<>("Sending Time");
            EndingTimeColm.setMinWidth(200);
            EndingTimeColm.setCellValueFactory(new PropertyValueFactory<>("SendingTime"));

            TableColumn<SMSData, String> typenameColm = new TableColumn<>("SIM Type");
            typenameColm.setMinWidth(200);
            typenameColm.setCellValueFactory(new PropertyValueFactory<>("typeName"));

            TableView<SMSData> DialTable;
            DialTable = new TableView<>();
            DialTable.getColumns().addAll(CallerNoColm, ReceiverNoColm, StartingTimeColm, EndingTimeColm, typenameColm);

            DialTable.setItems(dialList);

            VBox vb = new VBox();
            vb.getChildren().addAll(DialTable);

            Scene sc = new Scene(vb);
            Stage window = new Stage();
            window.setTitle("SMS List");
            window.setScene(sc);
            window.show();

            pst.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("SMS list show error!!!");
        }
    }

    public void ShowDialledCallList(String NID_No) {
        try {
            String sql = "SELECT C.CALLER_NO , C.RECEIVER_NO, C.STARTING_TIME , "
                    + "C.ENDING_TIME , TO_CHAR(C.ENDING_TIME-C.STARTING_TIME),"
                    + "T.TYPE_NAME FROM USER_DATA U "
                    + "JOIN SIM S ON(U.NID_NO = ? AND "
                    + "U.NID_NO = S.NID_NO) JOIN CALL_DATABASE C "
                    + "ON(S.PHONE_NO = C.CALLER_NO) "
                    + "JOIN SIM_TYPE T ON(S.TYPE_ID = T.TYPE_ID)";

            Connection con = new DataBase("TELECOM", "hr").getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, NID_No);
            ResultSet rs = pst.executeQuery();

            ObservableList<DialledListData> dialList = FXCollections.observableArrayList();
            while (rs.next()) {
                System.out.println(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));

                dialList.add(new DialledListData(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6)));

            }

            TableColumn<DialledListData, String> CallerNoColm = new TableColumn<>("Caller SIM No");
            CallerNoColm.setMinWidth(200);
            CallerNoColm.setCellValueFactory(new PropertyValueFactory<>("callerNo"));

            TableColumn<DialledListData, String> ReceiverNoColm = new TableColumn<>("Receiver SIM No");
            ReceiverNoColm.setMinWidth(200);
            ReceiverNoColm.setCellValueFactory(new PropertyValueFactory<>("receiverNo"));

            TableColumn<DialledListData, String> StartingTimeColm = new TableColumn<>("Starting Time");
            StartingTimeColm.setMinWidth(200);
            StartingTimeColm.setCellValueFactory(new PropertyValueFactory<>("startingTime"));

            TableColumn<DialledListData, String> EndingTimeColm = new TableColumn<>("Ending Time");
            EndingTimeColm.setMinWidth(200);
            EndingTimeColm.setCellValueFactory(new PropertyValueFactory<>("endingTime"));

            TableColumn<DialledListData, String> DurationColm = new TableColumn<>("Call Duration");
            DurationColm.setMinWidth(200);
            DurationColm.setCellValueFactory(new PropertyValueFactory<>("callDuration"));

            TableColumn<DialledListData, String> typenameColm = new TableColumn<>("SIM Type");
            typenameColm.setMinWidth(200);
            typenameColm.setCellValueFactory(new PropertyValueFactory<>("typeName"));

            TableView<DialledListData> DialTable;
            DialTable = new TableView<>();
            DialTable.getColumns().addAll(CallerNoColm, ReceiverNoColm, StartingTimeColm, EndingTimeColm, DurationColm, typenameColm);

            DialTable.setItems(dialList);

            VBox vb = new VBox();
            vb.getChildren().addAll(DialTable);

            Scene sc = new Scene(vb);
            Stage window = new Stage();
            window.setTitle("Dialled Call List");
            window.setScene(sc);
            window.show();

            pst.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("Diall Call list show error!!!");
        }
    }

    public void ShowReceivedCallList(String NID_No) {
        try {
            String sql = "SELECT C.RECEIVER_NO, C.CALLER_NO ,  C.STARTING_TIME , "
                    + "C.ENDING_TIME , TO_CHAR(C.ENDING_TIME-C.STARTING_TIME),T.TYPE_NAME\n"
                    + "FROM USER_DATA U \n"
                    + "JOIN SIM S\n"
                    + "ON(U.NID_NO = ? AND	U.NID_NO = S.NID_NO)\n"
                    + "JOIN CALL_DATABASE C\n"
                    + "ON(S.PHONE_NO = C.RECEIVER_NO)\n"
                    + "JOIN SIM_TYPE T\n"
                    + "ON(S.TYPE_ID = T.TYPE_ID)";

            Connection con = new DataBase("TELECOM", "hr").getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, NID_No);
            ResultSet rs = pst.executeQuery();

            ObservableList<ReceivedListData> receiveList = FXCollections.observableArrayList();
            while (rs.next()) {
//                System.out.println(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));

                receiveList.add(new ReceivedListData(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6)));

            }

            TableColumn<ReceivedListData, String> ReceiverNoColm = new TableColumn<>("Receiver SIM No");
            ReceiverNoColm.setMinWidth(200);
            ReceiverNoColm.setCellValueFactory(new PropertyValueFactory<>("receiverNo"));

            TableColumn<ReceivedListData, String> CallerNoColm = new TableColumn<>("Caller SIM No");
            CallerNoColm.setMinWidth(200);
            CallerNoColm.setCellValueFactory(new PropertyValueFactory<>("callerNo"));

            TableColumn<ReceivedListData, String> StartingTimeColm = new TableColumn<>("Starting Time");
            StartingTimeColm.setMinWidth(200);
            StartingTimeColm.setCellValueFactory(new PropertyValueFactory<>("startingTime"));

            TableColumn<ReceivedListData, String> EndingTimeColm = new TableColumn<>("Ending Time");
            EndingTimeColm.setMinWidth(200);
            EndingTimeColm.setCellValueFactory(new PropertyValueFactory<>("endingTime"));

            TableColumn<ReceivedListData, String> DurationColm = new TableColumn<>("Call Duration");
            DurationColm.setMinWidth(200);
            DurationColm.setCellValueFactory(new PropertyValueFactory<>("callDuration"));

            TableColumn<ReceivedListData, String> typenameColm = new TableColumn<>("SIM Type");
            typenameColm.setMinWidth(200);
            typenameColm.setCellValueFactory(new PropertyValueFactory<>("typeName"));

            TableView<ReceivedListData> receiveTable;
            receiveTable = new TableView<>();
            receiveTable.getColumns().addAll(ReceiverNoColm, CallerNoColm, StartingTimeColm, EndingTimeColm, DurationColm, typenameColm);

            receiveTable.setItems(receiveList);

            VBox vb = new VBox();

            vb.getChildren().addAll(receiveTable);

            Scene sc = new Scene(vb);
            Stage window = new Stage();
            window.setTitle("Received Call List");
            window.setScene(sc);
            window.show();

            pst.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("Received  Call list show error!!!");
        }
    }

    public void Profile(String User_Name, String NID_No) {
        try {
            String sql = "SELECT * FROM USER_DATA WHERE USER_NAME = ? AND NID_NO = ?";

            int posX = 300, posY = 170;
            int textFieldPosX = posX + 200, textFieldPosY = posY - 15;
            int buttonPosX = textFieldPosX + 300, buttonPosY = 50;

            Connection con = new DataBase("TELECOM", "hr").getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, User_Name);
            pst.setString(2, NID_No);
            ResultSet rs = pst.executeQuery();

//            System.out.println("agdfkasbhkc");
            rs.next();

            Text Name = new Text("USER NAME : " + rs.getString(1));
            Name.setX(posX);
            Name.setY(posY);
            Name.setFill(Color.rgb(0, 0, 0));
            Text nid = new Text("NID NO : " + rs.getString(2));
            nid.setX(posX);
            nid.setY(posY + 50);
            nid.setFill(Color.rgb(0, 0, 0));

            Text db = new Text("DATE OF BIRTH (MMM DD, YYYY) : " + rs.getString(3));

            db.setX(posX);
            db.setY(posY + 100);
            db.setFill(Color.rgb(0, 0, 0));

            Text fn = new Text("FATHER'S NAME : " + rs.getString(4));
            fn.setX(posX);
            fn.setY(posY + 150);
            fn.setFill(Color.rgb(0, 0, 0));

            Text mn = new Text("MOTHER'S NAME : " + rs.getString(5));
            mn.setX(posX);
            mn.setY(posY + 200);
            mn.setFill(Color.rgb(0, 0, 0));

            Text add = new Text("ADRESS : " + rs.getString(6));
            add.setX(posX);
            add.setY(posY + 250);
            add.setFill(Color.rgb(0, 0, 0));

            Text ct = new Text("CITY : " + rs.getString(7));
            ct.setX(posX);
            ct.setY(posY + 300);
            ct.setFill(Color.rgb(0, 0, 0));

            Text type = new Text("hi");

            if (rs.getString(8).equals("NO")) {
                type = new Text("User Type: " + "Not Employee");
            } else {
                type = new Text("User Type: " + "Employee");
            }

            type.setX(posX);
            type.setY(posY + 350);
            type.setFill(Color.rgb(0, 0, 0));

            root.getChildren().add(Name);
            root.getChildren().add(nid);
            root.getChildren().add(db);
            root.getChildren().add(fn);
            root.getChildren().add(mn);
            root.getChildren().add(add);
            root.getChildren().add(ct);
            root.getChildren().add(type);

            pst.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Log In Error!!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
