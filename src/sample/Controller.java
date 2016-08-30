package sample;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ListView todoList;

    @FXML
    TextField todoText;

    ObservableList<ToDoItem> todoItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoList.setItems(todoItems);
    }

    public void addItem() {
        System.out.println("Adding item ...");
        todoItems.add(new ToDoItem(todoText.getText()));/*todoItems object of type observable list*/
        todoText.setText("");
    }

    public void removeItem() {
        ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();/*returns the actual object of the item, not just the text*/
        System.out.println("Removing " + todoItem.text + " ...");
        todoItems.remove(todoItem);/*"remove()" works on any list object in Java*/
    }

    public void toggleItem() {
        System.out.println("Toggling item ...");
        ToDoItem todoItem = (ToDoItem) todoList.getSelectionModel().getSelectedItem();
        if (todoItem != null) {
            todoItem.isDone = !todoItem.isDone;
            todoList.setItems(null);
            todoList.setItems(todoItems);
        }
    }

    public void addItemOnEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("Enter Key pressed");
            todoItems.add(new ToDoItem(todoText.getText()));
            todoText.setText("");
        }
    }

    public void toggleAll() {
        for (ToDoItem item : todoItems) {
                item.isDone = !item.isDone;
                todoList.setItems(null);
                todoList.setItems(todoItems);
        }
    }

    public void markAllAsDone() {
        for (ToDoItem item : todoItems) {
            item.isDone = true;
            todoList.setItems(null);
            todoList.setItems(todoItems);
        }
    }

    public void markAllAsNotDone() {
        for (ToDoItem item : todoItems) {
            item.isDone = false;
            todoList.setItems(null);
            todoList.setItems(todoItems);
        }
    }
}
