package net.iouhase.haarmonika;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TimesViewController {
    @FXML
    private WebView webView;

    @FXML
    private void initialize(){
        String content = "nicklas er en nob";
        WebEngine webEngine = webView.getEngine();

        webEngine.loadContent(content, "text/html");
    }
}
