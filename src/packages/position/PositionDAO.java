package packages.position;

import init.db.BaseDAO;
import javafx.geometry.Pos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO extends BaseDAO {

    public List<Position> getListPositions() {
        try {
            List<Position> positions = new ArrayList<Position>();
            String query = "select * from position order by id asc";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Position pos = new Position(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                positions.add(pos);
            };
            return positions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTotalPositions() {
        try {
            String query = "select count(*) as total from position";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}