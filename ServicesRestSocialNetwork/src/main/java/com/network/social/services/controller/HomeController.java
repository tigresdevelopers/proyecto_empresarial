package com.network.social.services.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.network.social.domain.entities.Etiqueta;
import com.network.social.domain.entities.Usuario;
import com.network.social.domain.util.ResultObject;
import com.network.social.services.service.ActividadService;
import com.network.social.services.service.AlbumService;
import com.network.social.services.service.ComentarioService;
import com.network.social.services.service.ContactoService;
import com.network.social.services.service.EtiquetaService;
import com.network.social.services.service.GrupoService;
import com.network.social.services.service.GrupoUsuarioService;
import com.network.social.services.service.IdiomaService;
import com.network.social.services.service.LikeService;
import com.network.social.services.service.ListaContactoService;
import com.network.social.services.service.MultimediaService;
import com.network.social.services.service.NotificacionService;
import com.network.social.services.service.PublicacionService;
import com.network.social.services.service.SituacionService;
import com.network.social.services.service.SolicitudService;
import com.network.social.services.service.TipoContactoService;
import com.network.social.services.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private ContactoService contactoService;
	
	@Autowired
	private EtiquetaService etiquetaService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private GrupoUsuarioService grupoUsuarioService;
	
	@Autowired
	private IdiomaService idiomaService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private ListaContactoService listaContactoService;
	
	@Autowired
	private MultimediaService multimediaService;
	
	@Autowired
	private NotificacionService notificacionService;
	
	@Autowired
	private PublicacionService publicacionService;
	
	@Autowired
	private SituacionService situacionService;
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private TipoContactoService tipoContactoService;
	
	
	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="etiqueta/list",method=RequestMethod.GET)
	public @ResponseBody List<Etiqueta> getEtiquetas(){
		return etiquetaService.findAll();
	}
	
	@RequestMapping(value="usuario/list",method=RequestMethod.GET)
	public @ResponseBody List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}
	
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public @ResponseBody ResultObject getobject(){
		ResultObject obj=new ResultObject();
		
		List<Map<String, Object>> data=new ArrayList<>();
		Map<String, Object> map=new LinkedHashMap<>();
		map.put("usuario", "Alexander Chavez Simbron");
		map.put("clave", "123");
		data.add(map);
		map=new LinkedHashMap<>();
		map.put("usuario", "Diego Santos Celestino");
		map.put("clave", "123");
		data.add(map);
		map=new LinkedHashMap<>();
		map.put("usuario", "Domenika Chavez Chavez");
		map.put("clave", "123");
		data.add(map);
		
		obj.setData(data);
		
		return obj;
	}
	
	
}
