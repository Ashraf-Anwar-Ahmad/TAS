package com.icg.dao;

import com.icg.dto.GetSearchDTO;
import com.icg.dto.ViewPDFBean;

public interface SearchThreatDAO {

	public String getSearchThreatList(String... varArg);

	public ViewPDFBean getViewPdfList(String... varArg);

	public String getThreatHistoryList(String... varArg);

	public String getViewList(String... varArg);

	public String getSearchThreatList(GetSearchDTO getSearchDTO);
}
