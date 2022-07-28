package fr.eql.ai111.project2.abey.business.impl;

import fr.eql.ai111.project2.abey.business.TrafficBusiness;
import fr.eql.ai111.project2.abey.dao.LineDao;
import fr.eql.ai111.project2.abey.dao.StopDao;
import fr.eql.ai111.project2.abey.entity.Line;
import fr.eql.ai111.project2.abey.entity.Stop;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Remote(TrafficBusiness.class)
@Stateless
public class TrafficBusinessImpl implements TrafficBusiness {

    @EJB
    private LineDao lineDao;

    @EJB
    private StopDao stopDao;

    @EJB
    private LineDao newLineDao;

    @Override
    public Line getLineUpdatedWithStops(Line line) {
        line.setStops(stopDao.findByLine(line));
        return line;
    }

    @Override
    public List<Line> findAllLines() {
        return lineDao.findAllLines();
    }

    @Override
    public List<Stop> findAllStops() {
        return stopDao.findAllStops();
    }

    @Override
    public int createLine(Line newLine) {
        return newLineDao.createLine(newLine);
    }

    @Override
    public void addStopsToSaveToDb(List<Stop> stopsToSave, Line newLine, int idLigne) {
        lineDao.addStopsToSaveToDb(stopsToSave, newLine, idLigne);
    }

}
