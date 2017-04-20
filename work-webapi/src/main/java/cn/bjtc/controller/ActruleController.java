package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IActawardsService;
import cn.bjtc.service.IActruleService;
import cn.bjtc.view.ActawardsView;
import cn.bjtc.view.ActruleView;

@RestController
@RequestMapping("actrule")
public class ActruleController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActrules(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
		int count=actruleService.countAllActrules(view);
		List<?> actrules=actruleService.findAllActrules(view);
		apiReturn.setCount(count);
		apiReturn.setData(actrules);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddActrule(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
		actruleService.saveActrule(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
    public ApiReturn execUpdateActrule(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
		actruleService.updateActrule(view);
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditActrule(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
		List<?> actrules=actruleService.findAllActrules(view);
		apiReturn.setData(actrules);
		return apiReturn;	
	}
    
	@Autowired
	private IActruleService actruleService;
}