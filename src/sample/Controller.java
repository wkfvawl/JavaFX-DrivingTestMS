package sample;

import dao.ChoiceQuestionDao;
import dao.TFQuestionDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pojo.ChoiceQuestion;
import pojo.TrueFalseQuestion;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {

	private ChoiceQuestionDao cqd;// 数据存取对象DAO
	private TFQuestionDao tfqd;
	@FXML
	private TextField number;// 题目编号
	@FXML
	private TextField content;// 题目内容
	@FXML
	private TextField imageName;// 图片名称
	@FXML
	private TextField answer;// 正确答案
	@FXML
	private TextField optionA;// 选项
	@FXML
	private TextField optionB;// 选项
	@FXML
	private TextField optionC;// 选项
	@FXML
	private TextField optionD;// 选项
	@FXML
	private TextField deleteNumber;// 需要删除题目的编号
	// 更新单选题
	@FXML
	private TextField number2;// 题目编号
	@FXML
	private TextField content2;// 题目内容
	@FXML
	private TextField imageName2;// 图片名称
	@FXML
	private TextField answer2;// 正确答案
	@FXML
	private TextField optionA2;// 选项
	@FXML
	private TextField optionB2;// 选项
	@FXML
	private TextField optionC2;// 选项
	@FXML
	private TextField optionD2;// 选项
	@FXML
	private TextField updateNumber;// 更新中的查询框
	// 判断题
	@FXML
	private TextField number3;// 题目编号
	@FXML
	private TextField content3;// 题目内容
	@FXML
	private TextField imageName3;// 图片名称
	@FXML
	private TextField answer3;// 正确答案
	@FXML
	private TextField optionA3;// 选项
	@FXML
	private TextField optionB3;// 选项
	// 更新判断题
	@FXML
	private TextField number4;
	@FXML
	private TextField content4;
	@FXML
	private TextField imageName4;
	@FXML
	private TextField answer4;
	@FXML
	private TextField optionA4;
	@FXML
	private TextField optionB4;
	@FXML
	private TextField updateNumber2;// 更新中的查询框
	@FXML
	private TextField deleteNumber2;// 需要删除题目的编号

	public TextField getNumber() {
		return number;
	}

	public TextField getContent() {
		return content;
	}

	public TextField getImageName() {
		return imageName;
	}

	public TextField getAnswer() {
		return answer;
	}

	public TextField getOptionA() {
		return optionA;
	}

	public TextField getOptionB() {
		return optionB;
	}

	public TextField getOptionC() {
		return optionC;
	}

	public TextField getOptionD() {
		return optionD;
	}

	public TextField getDeleteNumber() {
		return deleteNumber;
	}

	public TextField getNumber2() {
		return number2;
	}

	public TextField getContent2() {
		return content2;
	}

	public TextField getImageName2() {
		return imageName2;
	}

	public TextField getAnswer2() {
		return answer2;
	}

	public TextField getOptionA2() {
		return optionA2;
	}

	public TextField getOptionB2() {
		return optionB2;
	}

	public TextField getOptionC2() {
		return optionC2;
	}

	public TextField getOptionD2() {
		return optionD2;
	}

	public TextField getUpdateNumber() {
		return updateNumber;
	}

	public TextField getNumber3() {
		return number3;
	}

	public TextField getContent3() {
		return content3;
	}

	public TextField getImageName3() {
		return imageName3;
	}

	public TextField getAnswer3() {
		return answer3;
	}

	public TextField getOptionA3() {
		return optionA3;
	}

	public TextField getOptionB3() {
		return optionB3;
	}

	public TextField getNumber4() {
		return number4;
	}

	public TextField getContent4() {
		return content4;
	}

	public TextField getImageName4() {
		return imageName4;
	}

	public TextField getAnswer4() {
		return answer4;
	}

	public TextField getOptionA4() {
		return optionA4;
	}

	public TextField getOptionB4() {
		return optionB4;
	}

	public TextField getUpdateNumber2() {
		return updateNumber2;
	}

	public TextField getDeleteNumber2() {
		return deleteNumber2;
	}

	public boolean isEmpty() {
		boolean flag = false;
		String number = getNumber().getText();
		String content = getContent().getText();
		String imageName = getImageName().getText();
		String optionA = getOptionA().getText();
		String optionB = getOptionB().getText();
		String optionC = getOptionC().getText();
		String optionD = getOptionD().getText();
		String answer = getAnswer().getText();
		if (number.isEmpty() || content.isEmpty() || imageName.isEmpty() || optionA.isEmpty() || optionB.isEmpty()
				|| optionC.isEmpty() || optionD.isEmpty() || answer.isEmpty()) {
			flag = true;
		}
		return flag;
	}

	// 提示信息窗口
	public void promptWindow(String promptInfon) throws IOException {
		System.out.println(promptInfon);
		Stage stage = new Stage();
		stage.setTitle("信息提示");
		Text text = new Text(40, 40, promptInfon);
		Pane pane = new Pane(text);
		Button ok = new Button("OK");
		HBox hBox = new HBox(ok);
		hBox.setAlignment(Pos.CENTER);
		BorderPane borderPane = new BorderPane(pane);
		borderPane.setBottom(hBox);
		ok.setOnAction(e -> {
			stage.close();
		});// lambda表达式
		Scene scene = new Scene(borderPane, 200, 100);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public void queryStage() throws IOException {
		Stage stage = new Stage();
		TableView<ChoiceQuestion> table = new TableView<>();
		// 数据源
		ObservableList<ChoiceQuestion> data = FXCollections
				.observableArrayList(new ChoiceQuestionDao().ChoiceItemQuery());
		Scene scene = new Scene(new Group());
		stage.setTitle("数据库查询");
		stage.setWidth(850);
		stage.setHeight(500);
		final Label label = new Label("数据库查询结果");
		label.setFont(new Font("Arial", 20));
		table.setEditable(true);
		// 每个Table的列
		TableColumn numberCol = new TableColumn("number");
		// 设置宽度
		numberCol.setMinWidth(100);
		// 设置分箱的类下面的属性名
		numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
		TableColumn contentCol = new TableColumn("content");
		contentCol.setMinWidth(100);
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));

		TableColumn imageNameCol = new TableColumn("pic");
		imageNameCol.setMinWidth(100);
		imageNameCol.setCellValueFactory(new PropertyValueFactory<>("pic"));

		TableColumn optionACol = new TableColumn("optionA");
		optionACol.setMinWidth(100);
		optionACol.setCellValueFactory(new PropertyValueFactory<>("optionA"));
		TableColumn optionBCol = new TableColumn("optionB");
		optionBCol.setMinWidth(100);
		optionBCol.setCellValueFactory(new PropertyValueFactory<>("optionB"));
		TableColumn optionCCol = new TableColumn("optionC");
		optionCCol.setMinWidth(100);
		optionCCol.setCellValueFactory(new PropertyValueFactory<>("optionC"));
		TableColumn optionDCol = new TableColumn("optionD");
		optionDCol.setMinWidth(100);
		optionDCol.setCellValueFactory(new PropertyValueFactory<>("optionD"));
		TableColumn answerCol = new TableColumn("answer");
		answerCol.setMinWidth(100);
		answerCol.setCellValueFactory(new PropertyValueFactory<>("answer"));
		// 设置数据源
		table.setItems(data);
		// 一次添加列进TableView
		table.getColumns().addAll(numberCol, contentCol, imageNameCol, optionACol, optionBCol, optionCCol, optionDCol,
				answerCol);
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
		stage.setResizable(false);// 关闭放大
		stage.show();
	}

	public void addChoiceItem(MouseEvent mouseEvent) throws IOException {
		String number = getNumber().getText();
		String content = getContent().getText();
		String imageName = getImageName().getText();
		String optionA = getOptionA().getText();
		String optionB = getOptionB().getText();
		String optionC = getOptionC().getText();
		String optionD = getOptionD().getText();
		String answer = getAnswer().getText();
		ChoiceQuestion cq = new ChoiceQuestion(number, content, imageName, optionA, optionB, optionC, optionD, answer);
		System.out.println(cq.toString());
		if (!isEmpty()) {
			cqd.ChoiceItemInsert(cq);// 插入选择题
			promptWindow("添加题目成功！！");
		} else {
			promptWindow("信息输入不完整,请重新输入");
		}
	}

	// 更新前先查找显示
	public void QueryUpdate(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getUpdateNumber().getText();
		ChoiceQuestion cq = new ChoiceQuestion();
		cq = cqd.ChoiceItemQuerySingle(number);// 更新前的查找
		if(cq.getNumber()==null)
		{
			promptWindow("未找到该题目,请重新输入");
		}
		else
		{// 将查找到的需要更新的题目写回
			number2.setText(cq.getNumber());
			content2.setText(cq.getContent());
			imageName2.setText(cq.getPic());
			answer2.setText(cq.getAnswer());
			optionA2.setText(cq.getOptionA());
			optionB2.setText(cq.getOptionB());
			optionC2.setText(cq.getOptionC());
			optionD2.setText(cq.getOptionD());
		}
	}
	// 跟新修改后的单选题目
	public void updateChoiceItem(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getNumber2().getText();
		String content = getContent2().getText();
		String imageName = getImageName2().getText();
		String optionA = getOptionA2().getText();
		String optionB = getOptionB2().getText();
		String optionC = getOptionC2().getText();
		String optionD = getOptionD2().getText();
		String answer = getAnswer2().getText();
		ChoiceQuestion cq = new ChoiceQuestion(number, content, imageName, optionA, optionB, optionC, optionD, answer);
		System.out.println(cq.toString());
		cqd.ChoiceItemDelete(number);// 先删除
		cqd.ChoiceItemInsert(cq);// 后重新插入
		promptWindow("更新题目成功！！");
	}

	public void deleteChoiceItem(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getDeleteNumber().getText();
		System.out.println(number);
		if (cqd.ChoiceItemDelete(number)) {
			// 删除给定编号的选择题
			promptWindow("删除题目成功！！");
		} else {
			promptWindow("未找到该题目，删除失败！！");
		}

	}

	public void selectChoiceItem(MouseEvent mouseEvent) throws IOException {
		queryStage();
	}

	public void queryStageTF() throws IOException {
		Stage stage = new Stage();
		TableView<TrueFalseQuestion> table = new TableView<>();
		// 数据源
		ObservableList<TrueFalseQuestion> data = FXCollections.observableArrayList(new TFQuestionDao().TFItemQuery());
		Scene scene = new Scene(new Group());
		stage.setTitle("数据库查询");
		stage.setWidth(850);
		stage.setHeight(500);
		final Label label = new Label("数据库查询结果");
		label.setFont(new Font("Arial", 20));
		table.setEditable(true);
		// 每个Table的列
		TableColumn numberCol = new TableColumn("number");
		// 设置宽度
		numberCol.setMinWidth(100);
		// 设置分箱的类下面的属性名
		numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
		TableColumn contentCol = new TableColumn("content");
		contentCol.setMinWidth(300);
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
		TableColumn picCol = new TableColumn("pic");
		picCol.setMinWidth(100);
		picCol.setCellValueFactory(new PropertyValueFactory<>("pic"));
		TableColumn optionACol = new TableColumn("optionT");
		optionACol.setMinWidth(100);
		optionACol.setCellValueFactory(new PropertyValueFactory<>("optionT"));
		TableColumn optionBCol = new TableColumn("optionF");
		optionBCol.setMinWidth(100);
		optionBCol.setCellValueFactory(new PropertyValueFactory<>("optionF"));
		TableColumn answerCol = new TableColumn("answer");
		answerCol.setMinWidth(100);
		answerCol.setCellValueFactory(new PropertyValueFactory<>("answer"));
		// 设置数据源
		table.setItems(data);
		// 一次添加列进TableView
		table.getColumns().addAll(numberCol, contentCol, picCol, optionACol, optionBCol, answerCol);
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		stage.setScene(scene);
		stage.setResizable(false);// 关闭放大
		stage.show();
	}

	// 插入判断题
	public void addTFItem(MouseEvent mouseEvent) throws IOException {
		String number = getNumber3().getText();
		String content = getContent3().getText();
		String imageName = getImageName3().getText();
		String optionA = getOptionA3().getText();
		String optionB = getOptionB3().getText();
		String answer = getAnswer3().getText();
		TrueFalseQuestion tfq = new TrueFalseQuestion(number, content, imageName, optionA, optionB, answer);
		// System.out.println("插入测试"+tfq.toString());
		if (tfqd.TFItemInsert(tfq)) {// 插入选择题
			promptWindow("添加题目成功！！");
		} else {
			promptWindow("添加题目失败！！");
		}
	}

	// 更新前先查找
	public void QueryUpdateTF(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getUpdateNumber2().getText();
		TrueFalseQuestion tfq = tfqd.TFItemQuerySingle(number);// 更新前的查找
		if(tfq.getNumber()==null)
		{
			promptWindow("未找到该题目,请重新输入");
		}
		else {
		// 将查找到的需要更新的题目写回
		number4.setText(tfq.getNumber());
		content4.setText(tfq.getContent());
		imageName4.setText(tfq.getPic());
		answer4.setText(tfq.getAnswer());
		optionA4.setText(tfq.getOptionT());
		optionB4.setText(tfq.getOptionF());
		}
	}

	// 更新修改后的判断题目
	public void updateTFItem(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getNumber4().getText();
		String content = getContent4().getText();
		String imageName = getImageName4().getText();
		String optionA = getOptionA4().getText();
		String optionB = getOptionB4().getText();
		String answer = getAnswer4().getText();
		TrueFalseQuestion tfq = new TrueFalseQuestion(number, content, imageName, optionA, optionB, answer);
		System.out.println(tfq.toString());
		tfqd.TFItemDelete(number);// 先删除
		if (tfqd.TFItemInsert(tfq)) {// 后重新插入
			promptWindow("更新题目成功！！");
		} else {
			promptWindow("更新题目失败！！");
		}
	}

	public void deleteTFItem(MouseEvent mouseEvent) throws SQLException, IOException {
		String number = getDeleteNumber2().getText();
		System.out.println(number);
		if (tfqd.TFItemDelete(number)) {
			// 删除给定编号的选择题
			promptWindow("删除成功题目！！");
		} else {
			promptWindow("未找到该题目，删除失败！！");
		}

	}

	public void selectTFItem(MouseEvent mouseEvent) throws IOException {
		queryStageTF();
	}

}
