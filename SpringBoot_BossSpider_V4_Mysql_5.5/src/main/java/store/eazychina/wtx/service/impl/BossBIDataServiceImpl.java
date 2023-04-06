package store.eazychina.wtx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import store.eazychina.wtx.mapper.BossBISpiderMapper;
import store.eazychina.wtx.mapper.BossSpiderMapper;
import store.eazychina.wtx.pojo.BossBiPojo;
import store.eazychina.wtx.pojo.BossBiPojoFromAddr;
import store.eazychina.wtx.pojo.bossPojo;
import store.eazychina.wtx.service.BossBIDataService;
import store.eazychina.wtx.service.BossDataService;
//@Component
@Service
public class BossBIDataServiceImpl implements BossBIDataService{


	@Autowired(required=false)
	BossBISpiderMapper boss;

	public List<BossBiPojo> findByAddr() {
		return boss.findByAddr();
	}

	public List<BossBiPojo> findByJobName() {
		return boss.findByJobName();
	}
						   
	public List<BossBiPojo> findByAddrJobName() {
		return boss.findByAddrJobName();
	}

	public List<BossBiPojo> findByAddrJobNameBeiJing() {
		return boss.findByAddrJobNameBeiJing();
	}

	public List<BossBiPojo> findByAddrJobNameBeiJing_deelplearning() {
		// TODO Auto-generated method stub
		return boss.findByAddrJobNameBeiJing_deelplearning();
	}
}
