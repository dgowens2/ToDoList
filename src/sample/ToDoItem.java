package sample;

/**
 * Created by DTG2 on 08/30/16.
 */
public class ToDoItem {

    String text;
    boolean isDone;

    public ToDoItem(String text) {
        this.text = text;
        this.isDone = false;
    }

    @Override/*overrides regular toString() method so that we can return custom text*/
    public String toString() {
        if (isDone) {
            return text + " (done)";
        } else {
            return text;
        }
        // A one-line version of the logic above:
        // return text + (isDone ? " (done)" : "");
    }

}
