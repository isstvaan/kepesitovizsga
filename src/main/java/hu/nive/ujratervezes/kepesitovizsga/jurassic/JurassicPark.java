package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

//    DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JurassicPark(DataSource dataSource) {
       // this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> checkOverpopulation() {
        return jdbcTemplate.query("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed ASC",
                (resultSet, i) -> resultSet.getString("breed")
        );
    }

//    public List<String> checkOverpopulation() {
//        try (
//                Connection conn = dataSource.getConnection();
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed ASC")
//        ) {
//            List<String> overpopulatedDinos = new ArrayList<>();
//
//            while (rs.next()) {
//                String name = rs.getString("breed");
//                overpopulatedDinos.add(name);
//            }
//
//            return overpopulatedDinos;
//        } catch (SQLException se) {
//            throw new IllegalStateException("Cannot select dinosaur", se);
//        }
//    }

}
