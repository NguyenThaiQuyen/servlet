package packages.position;

import init.db.BaseDAO;
import javafx.geometry.Pos;
import packages.staff.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO extends BaseDAO {

    public List<Position> getListPositions() {
        try {
            List<Position> positions = new ArrayList<Position>();
            String query = "select position.* , (select count(*) from staff where staff.idPosition = position.id ) as amount from position order by position.id asc";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Position pos = new Position(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        Integer.parseInt(resultSet.getString("amount")));
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

    public Position getByID(String idPos) {
        try {
            String sql = "select * from position where id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, idPos);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Position pos = new Position(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                return pos;
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addPosition(Position p) {
        int result = 0;
        try {
            String sql = "insert into position (name, description) values(?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePosition(Position p) {
        int result = 0;
        try {
            String sql = "update position SET name= ?,description= ? WHERE id= ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}