package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed ASC ")
        ) {
            List<String> overpopulatedDinos = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("breed");
                overpopulatedDinos.add(name);
            }

            return overpopulatedDinos;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }
}
