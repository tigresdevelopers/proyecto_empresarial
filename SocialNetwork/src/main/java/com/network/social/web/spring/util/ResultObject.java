package com.network.social.web.spring.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.network.social.web.form.BaseForm;

/**
 * 
 * @author :Alexander Chavez Simbron
 * @date   :11/10/2015
 * @time   :08:32pm
 * @description :Clase para formar un objeto Json con las propeidades que definamos
 * 
 */
public class ResultObject extends BaseForm{
	private static final long serialVersionUID = 1L;

	private List<Map<String, Object>> data;
	private Set<String> keyset;
	private int totalrows;
	
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public Set<String> getKeyset() {
		return keyset;
	}
	public void setKeyset(Set<String> keyset) {
		this.keyset = keyset;
	}
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

}
