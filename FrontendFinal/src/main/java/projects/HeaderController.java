package projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projects.Categorydaoimp.ProductDao;


@Controller
public class HeaderController {
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping(value="/all/searchByCategory")
	public String searchByCategory(@RequestParam String searchCondition ,Model model){
		
		if(searchCondition.equals("All"))
			model.addAttribute("searchCondition","");
		
		else
		model.addAttribute("searchCondition",searchCondition);
		
		model.addAttribute("productsList",productDao.ListProduct());
		return "listofproducts";

}
	
}