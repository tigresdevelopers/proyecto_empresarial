package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.ALBUM;
import static com.network.social.services.util.RestURIConstants.ALBUM_LIST_BY_USER;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.network.social.domain.entities.Album;
import com.network.social.domain.util.ResultObject;
import com.network.social.services.service.AlbumService;

@RestController
@RequestMapping(value=ALBUM)
public class ServiceAlbumController {

	
	@Autowired
	private AlbumService albumService;
		
	
	@RequestMapping(value=ALBUM_LIST_BY_USER,method=RequestMethod.GET)
	public @ResponseBody ResultObject list(@PathVariable Integer idusuario){
		
		ResultObject result=new ResultObject();
		List<Map<String,Object>> data=new ArrayList<>();
	
		List<Album> lista=albumService.listAlbumbyUserId(idusuario);
			
			for (Album obj: lista) {
				Map<String, Object> map=new LinkedHashMap<>();
				map.put("id",obj.getIdalbum());
				map.put("nombre",obj.getNombre());
				map.put("descripcion",obj.getDescripcion());
				map.put("likes",obj.getLikes());
				data.add(map);
			}

		result.setData(data);

		return result;
	}
	
//	@RequestMapping(value=ALBUM_LIST_BY_USER,method=RequestMethod.GET)
//	public @ResponseBody List<Album> list(@PathVariable Integer idusuario){
//		
//		List<Album> lista=albumService.listAlbumbyUserId(idusuario);
//		return lista;
//	}
	
//	@RequestMapping(value=ALBUM_LIST_BY_USER,method=RequestMethod.GET)
//	public @ResponseBody ResultObject list(@PathVariable Integer idusuario){
//		
//		ResultObject result=new ResultObject();
//		List<Map<String,Object>> data=new ArrayList<>();
//	
//		List<Map<String, Object>> lista=albumService.return_cursor(DaoUtil.SP_ALBUM_USUARIO,idusuario);
//			
//			for (Map<String, Object> obj: lista) {
//				Map<String, Object> map=new LinkedHashMap<>();
//				map.put("id",obj.get("idalbum"));
//				map.put("nombre",obj.get("nombre"));
//				map.put("descripcion",obj.get("descripcion"));
//				map.put("likes",obj.get("likes"));
//				data.add(map);
//			}
//
//		result.setData(data);
//
//		return result;
//	}
	
}
