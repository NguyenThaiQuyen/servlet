package packages.position;

import java.util.List;

public class PositionBO {
    PositionDAO positionDAO = new PositionDAO();
    public List<Position> getListPositions() {
        return positionDAO.getListPositions();
    }

    public int getTotalPositions() {
        return positionDAO.getTotalPositions();
    }
}
