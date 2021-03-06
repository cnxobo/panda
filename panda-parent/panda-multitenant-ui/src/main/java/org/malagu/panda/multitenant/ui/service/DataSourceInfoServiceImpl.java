package org.malagu.panda.multitenant.ui.service;

import java.util.List;

import org.malagu.multitenant.domain.DataSourceInfo;
import org.malagu.panda.dorado.linq.JpaUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kevin Yang (mailto:kevin.yang@bstek.com)
 * @since 2017年7月3日
 */
@Service("ui.dataSourceInfoService")
@Transactional(readOnly = true)
public class DataSourceInfoServiceImpl implements DataSourceInfoService {
	
	@Override
	public List<DataSourceInfo> load() {
		return JpaUtil.linq(DataSourceInfo.class).list();
	}

	@Override
	@Transactional
	public void save(List<DataSourceInfo> dataSourceInfos) {
		JpaUtil.save(dataSourceInfos);

	}

	@Override
	public boolean isExist(String dataSourceInfoId) {
		return JpaUtil.linq(DataSourceInfo.class).idEqual(dataSourceInfoId).exists();
		
	}

}
