package com.network.social.services.controller;

import static com.network.social.services.util.RestURIConstants.ALBUM;
import static com.network.social.services.util.RestURIConstants.ALBUM_LIST_BY_USER;
import static com.network.social.services.util.RestURIConstants.GET_ALL;

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
		
	
	@RequestMapping(value=GET_ALL,method=RequestMethod.GET)
	private @ResponseBody List<Album> getAll(){
		return albumService.findAll();
	}
	
	
	@RequestMapping(value=ALBUM_LIST_BY_USER,method=RequestMethod.GET)
	private @ResponseBody ResultObject list(@PathVariable Integer idusuario){
		
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
	
	
}
