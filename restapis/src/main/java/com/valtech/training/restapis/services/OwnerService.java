package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.services.vos.OwnerVO;
import com.valtech.training.restapis.services.vos.WatchVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO owner);

	OwnerVO getOwner(long id);

	List<OwnerVO> getOwners();

	OwnerVO updateOwner(long id, OwnerVO owner);

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}