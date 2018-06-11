import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class guiController {
	@FXML private Text hid1, hid2, hid3;
	@FXML private TextField marks, marksTotal, marks2, marks2Total, entry, entryTotal;

	//university, academic background, marks 
	String uni, acd;
	int marksM, marksMT, marksF, marksFT, marksE, marksET;

	@FXML private ChoiceBox acdChoice, uniChoice;

	@FXML protected void testClicked(ActionEvent event) {
		changeScene(event, "test.fxml", "Test - Quizify"); 
	}

	@FXML protected void aggregateClicked(ActionEvent event) {
		changeScene(event, "aggregate.fxml", "Aggregate - Quizify"); 
	}

	@FXML protected void performanceClicked(ActionEvent event) {
		System.out.println("performance!");
	}

	@FXML protected void backClicked(ActionEvent event) {
		changeScene(event, "welcome.fxml", "Aggregate"); 
	}

	@FXML protected void agrCalc(ActionEvent event) {
		
		//some necessary checks and then calculating aggregate if everything's alright
		//

		uni = (String)uniChoice.getValue();
		acd = (String)acdChoice.getValue();

		try {
			marksM = Integer.parseInt(marks.getText());
			marksMT = Integer.parseInt(marksTotal.getText());
			marksF = Integer.parseInt(marks2.getText());
			marksFT = Integer.parseInt(marks2Total.getText());
			marksE = Integer.parseInt(entry.getText());
			marksET = Integer.parseInt(entryTotal.getText());
		}
		catch (Exception e) {
			hid1.setText("");
			hid2.setText("");
			hid3.setText("Error!  Fields can't be empty or numbers.");
			return;
		}

		if (marksM > marksMT || marksMT == 0 || marksF > marksFT || marksFT == 0 || marksE > marksET || marksET == 0) {
			hid1.setText("");
			hid2.setText("");
			hid3.setText("Error!  Total marks zero or less than obtained.");
			return;
		}
			
		if (uni.equals("COMSATS")) 
			hid3.setText("Deduct 2% for each gap year as per COMSATS policy.");
		else
			hid3.setText("");

			AggregateCalculator agCalc = new AggregateCalculator(marksM, marksMT, marksF, marksFT, marksE, marksET, acd);

			double aggr;

			switch (uni) {
				case "NUST":
					aggr = agCalc.AggregateNUST(); break;
				case "FAST":
					aggr = agCalc.AggregateFAST(); break;
				case "UET":
					aggr = agCalc.AggregateUET(); break;
				case "COMSATS":
					aggr = agCalc.AggregateCOMSATS(); break;
				default:
					return;
		}

			
			//todo: call aggregate calculator

			hid1.setText("Aggregate:");
			hid2.setText(aggr + "%");
	}
	
	
	
	private void changeScene(ActionEvent event, String scene, String title) {
		
		//using info about the calling function
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(scene));
		} 
		catch (IOException e) {
			e.printStackTrace();
			return;		//no change in scene
		}
		
		Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

		stage.setTitle(title);
		stage.setScene(new Scene(root));
		stage.show();
	}
	
}
