package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




import com.network.social.domain.entities.Idioma;
import com.network.social.domain.util.BResult;
import com.network.social.services.service.IdiomaService;
import com.network.social.services.util.UtilEnum.ESTADO_OPERACION;
/**
 * @author :Alexander Chavez Simbron
 * @date   :21/10/2015
 * @time   :16:21:07
 */
@RestController
@RequestMapping(value=IDIOMA)
public class ServiceIdiomaController {
	Logger LOGGER=LoggerFactory.getLogger(ServiceIdiomaController.class);

	@Autowired
	private IdiomaService idiomaService;
	
	@RequestMapping(value=GET,method=RequestMethod.GET)
	private @ResponseBody Idioma get(@PathVariable Integer id){
		return idiomaService.findById(id);
	}
	
	@RequestMapping(value=GET_FILTERING,method=RequestMethod.GET)
	private @ResponseBody List<Idioma> getAllbyUser(@PathVariable Integer filter){
		return idiomaService.getAllbyUser(filter);
	}
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Idioma> getAll(){
		return idiomaService.findAll();
	}
	
	@RequestMapping(value=POST,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult post(@RequestBody Idioma idioma){
		 
			LOGGER.info("## ServiceIdiomaController -->post");
			BResult bResult =null;
			try{
				if(idioma!=null){
					bResult=new BResult();
					bResult.setEstado(idiomaService.save(idioma));
					LOGGER.info("## idioma registrado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Registrar idioma -->"+idioma.getIdidioma());
						bResult = new BResult();
						bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
					}
				}	
			}catch(Exception ex){
				LOGGER.info("EXCEPTION SERVICE", ex);
				bResult = new BResult();
				bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
				bResult.setMensaje("exception proceso");
			}
			LOGGER.info("## response :"+bResult.getCodigo());
			return bResult;
	    }
	
	@RequestMapping(value=PUT,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult put(@RequestBody Idioma idioma){
		 
			LOGGER.info("## ServiceIdiomaController -->put");
			BResult bResult =null;
			try{
				if(idioma!=null){
					bResult=new BResult();
					idiomaService.update(idioma);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## idioma actualizado ->"+idioma.getIdidioma());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al Actualizar idioma -->"+idioma.getIdidioma());
						bResult = new BResult();
						bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
					}
				}	
			}catch(Exception ex){
				LOGGER.info("EXCEPTION SERVICE", ex);
				bResult = new BResult();
				bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
				bResult.setMensaje("exception proceso");
			}
			LOGGER.info("## response :"+bResult.getCodigo());
			return bResult;
	    }
	
	@RequestMapping(value=DELETE,method=RequestMethod.POST,consumes="application/json") 
	   private @ResponseBody BResult delete(@PathVariable Integer id){
		 
			LOGGER.info("## ServiceIdiomaController -->delete");
			BResult bResult =null;
			try{
				if(id>0){
					bResult=new BResult();
					Idioma idioma=new Idioma();
					idioma.setIdidioma(id);
					idiomaService.delete(idioma);
					bResult.setEstado(ESTADO_OPERACION.CORRECTO.getCodigo());
					LOGGER.info("## idioma eliminado ->"+bResult.getEstado());
					if (bResult.getEstado()>0) {
						bResult.setEstado(ESTADO_OPERACION.EXITO.getCodigo());
					}else{
						LOGGER.info("Error al eliminar idioma -->"+idioma.getIdidioma());
						bResult = new BResult();
						bResult.setEstado(ESTADO_OPERACION.TRANSACCION_NO_PROCESADO.getCodigo());
					}
				}	
			}catch(Exception ex){
				LOGGER.info("EXCEPTION SERVICE", ex);
				bResult = new BResult();
				bResult.setEstado(ESTADO_OPERACION.EXCEPTION.getCodigo());
				bResult.setMensaje("exception proceso");
			}
			LOGGER.info("## response :"+bResult.getCodigo());
			return bResult;
	    }
}
