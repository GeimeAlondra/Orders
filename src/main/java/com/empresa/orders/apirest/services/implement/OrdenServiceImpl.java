package com.empresa.orders.apirest.services.implement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.orders.apirest.models.dao.IDetalleOrdenDAO;
import com.empresa.orders.apirest.models.dao.IOrdenDAO;
import com.empresa.orders.apirest.models.entities.DetalleOrden;
import com.empresa.orders.apirest.models.entities.Orden;
import com.empresa.orders.apirest.services.interfaces.IOrdenService;

@Service
public class OrdenServiceImpl implements IOrdenService{
	
	@Autowired 
	private IOrdenDAO ordenDAO;
	
	@Autowired 
	private IDetalleOrdenDAO detalleOrdenDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAll(Date fechaInicio) {
		Date fechaFin = null;
		if(fechaInicio != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(fechaInicio);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaFin = c.getTime();
			return ordenDAO.findAllRecibidasWithRangoFechas(fechaInicio, fechaFin);
		}
		return ordenDAO.findAllRecibidas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAllDespachadas(Date fechaInicio) {
		Date fechaFin = null;
		if(fechaInicio != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(fechaInicio);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaFin = c.getTime();
			return ordenDAO.findAllDespachadasWithRangoFechas(fechaInicio, fechaFin);
		}
		return ordenDAO.findAllDespachadas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAllAnuladas(Date fechaInicio) {
		Date fechaFin = null;
		if(fechaInicio != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(fechaInicio);
			c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaFin = c.getTime();
			return ordenDAO.findAllAnuladasWithRangoFechas(fechaInicio, fechaFin);
		}
		return ordenDAO.findAllAnuladas();
	}

	@Transactional
	@Override
	public Orden saveOrUpdate(Orden orden) {
		Orden ordenPersisted = null;
		try {
			if(orden.getId() == null) {
				List<DetalleOrden> detalleOrden = orden.getDetalleOrden();
				orden.setDetalleOrden(new ArrayList<DetalleOrden>());
				ordenPersisted = ordenDAO.save(orden);
				
				//Recorriendo la coleccion de detalle
				for(DetalleOrden detalle: detalleOrden) {
					detalle.setOrden(ordenPersisted);
				}
				//Guardando el detalle
				detalleOrdenDAO.saveAll(detalleOrden);
				
			}else {
				for(DetalleOrden detalle: orden.getDetalleOrden()) {
					detalle.setOrden(orden);
				}
				ordenDAO.save(orden);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ordenPersisted;
	}

	@Override
	public Orden changeState(Orden orden) {
		return ordenDAO.save(orden);
	}

	@Override
	public Orden findById(Long id) {
		return ordenDAO.findById(id).orElse(null);
	}

	@Override
	public List<Orden> findAllRecibidasByUser(Long id) {
		return ordenDAO.findAllRecibidasByUser(id);
	}


}
