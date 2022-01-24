module me.voitlj190037.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens net.htlgkr.groupK.chess to javafx.fxml;
    exports net.htlgkr.groupK.chess;
    exports net.htlgkr.groupK.chess.Figures;
    opens net.htlgkr.groupK.chess.Figures to javafx.fxml;
}