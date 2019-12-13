package packages.position;

import packages.staff.Staff;

import java.util.List;

public class PositionBO {
    PositionDAO positionDAO = new PositionDAO();

    public List<Position> getListPositions() {
        return positionDAO.getListPositions();
    }

    public int getTotalPositions() {
        return positionDAO.getTotalPositions();
    }

    public Position getByID(String idPos) {
        return positionDAO.getByID(idPos);
    }

    public int addPosition(Position p) {
        return positionDAO.addPosition(p);
    }

    public int updatePosition(Position p, String id) {
        Position oldPosition = positionDAO.getByID(id);
        if (oldPosition != null) {
            String idPos = (!p.getID().equals("")) ?  p.getID() :  oldPosition.getID();
            String name = (!p.getName().equals("")) ? p.getName() :  oldPosition.getName();
            String description = (!p.getDescription().equals("")) ? p.getDescription() : oldPosition.getDescription();
            Position data = new Position(id, name, description);
            return positionDAO.updatePosition(data);
        }
        return -1;
    }
}
