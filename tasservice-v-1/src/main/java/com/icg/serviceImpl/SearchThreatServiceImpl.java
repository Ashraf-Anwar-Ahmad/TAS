package com.icg.serviceImpl;

import com.icg.dao.SearchThreatDAO;
import com.icg.daoImpl.SearchThreatDAOImpl;
import com.icg.dto.GetSearchDTO;
import com.icg.dto.ViewPDFBean;
import com.icg.service.SearchThreatService;

public class SearchThreatServiceImpl implements SearchThreatService {

	SearchThreatDAO searchThreatDAO = new SearchThreatDAOImpl();

	public String getSearchThreatList(String... varArg)

	{
		return searchThreatDAO.getSearchThreatList(varArg);
	}

	public ViewPDFBean getViewPdfList(String... varArg)

	{
		return searchThreatDAO.getViewPdfList(varArg);
	}

	public String getThreatHistoryList(String... varArg)

	{
		return searchThreatDAO.getThreatHistoryList(varArg);
	}

	public String getViewList(String... varArg)

	{
		return searchThreatDAO.getViewList(varArg);
	}

	@Override
	public String getSearchThreatList(GetSearchDTO getSearchDTO) {
		// TODO Auto-generated method stub
		return searchThreatDAO.getSearchThreatList(getSearchDTO);
	}
}
