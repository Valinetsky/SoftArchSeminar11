package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

	@FXML
	private TextArea chat;

	@FXML
	private TextArea clients;

	@FXML
	private Button connect;

	@FXML
	private Button disconnect;

	@FXML
	private Button send;

	@FXML
	private TextField string;

	@FXML
	void connectButton(ActionEvent event) {

	}

	@FXML
	void disconnectButton(ActionEvent event) {

	}

	@FXML
	private void sendButton(ActionEvent event) {
		sendMessage();
	}

	@FXML
	private void sendEnter(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			sendMessage();
		}
	}

	private void sendMessage() {
		String message = chat.getText();
		String probe = string.getText();
		message = message + probe + System.lineSeparator();
		chat.setText(message);
		string.setText("");
	}
}