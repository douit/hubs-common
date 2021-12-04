package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class ShipmentDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Shipment.class)
    public interface ShipmentDao {
        @SqlQuery("select * from shipment")
        List<Shipment> listShipment();
        @SqlQuery("select * from shipment where shipment_id=:id")
        Shipment getShipment(@Bind("id") String id);

        @SqlQuery("select count(*) from shipment")
        int countShipment();
    }

    
    
    
}
