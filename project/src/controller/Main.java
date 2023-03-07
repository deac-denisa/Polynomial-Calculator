package controller;
import view.View;

public class Main {

    public static void main(String[] args) throws Exception {
        View view = new View();
        view.setVisible(true);
        Controller c = new Controller(view);
    }

}

