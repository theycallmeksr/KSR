package projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projects.CategoryClass.Supplier;
import projects.Categorydaoimp.SupplierDao;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDao supplierdao;

	@RequestMapping(value = "/admin/addsupplier", method = RequestMethod.POST)

	public ModelAndView addSupplier(@RequestParam("sname") String supname, 
			@RequestParam("smobile") String supmobile, @RequestParam("sadd") String supaddress, Model m) {
		Supplier supplier = new Supplier();

		supplier.setSupplierName(supname);
		supplier.setSupplierMobileNumber(supmobile);
		supplier.setSupplierAddress(supaddress);
		
		supplierdao.addSupplier(supplier);

		ModelAndView modelandview = new ModelAndView();
		
		List<Supplier> listsupplier = supplierdao.getAllSupplier();
		modelandview.addObject("getListOfSupplier", listsupplier);
		modelandview.setViewName("supplier");
		return modelandview;

	}


	 
	@RequestMapping(value = "/admin/deleteSupplier/{supplierId}" )          
	public ModelAndView deleteCategory(@PathVariable("supplierId") int supid ,Model m) {	
		Supplier supplier=supplierdao.getSupplierById(supid);
		System.out.println("BEFORE DELETE");
		supplierdao.deleteSupplier(supplier);
		
		System.out.println("AFTER DELETE");
		List<Supplier> supplierList = supplierdao.getAllSupplier();

		//normal type
		//m.addAttribute("getListOfSupplier",supplierList);			
         //return new ModelAndView("redirect:/supplierpage");
		
         //return "supplier";
				//return "redirect:/supplier"; 
		// return new ModelAndView("supplier", m);
		//return new ModelAndView("redirect:/getAllSupplier");
	
		//model and view 
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("getListOfSupplier", supplierList);
		 modelandview.setViewName("supplier"); 
		return modelandview;
		 
   }

	@RequestMapping(value="/admin/editsupplier/{supplierId}")
	public String editSupplier(@PathVariable ("supplierId") int supplierId ,Model model) {
		System.out.println("supp edit");
		Supplier supplier=supplierdao.getSupplierById(supplierId);
		
		
		model.addAttribute(supplier);
		
		List<Supplier> getAllSupplier=supplierdao.getAllSupplier();
		model.addAttribute("getListOfSupplier",getAllSupplier);
		return "supplierupdate";
	}
	
	@RequestMapping(value ="/admin/updateSupplier" ,method = RequestMethod.POST )
	public String updateSupplier(@RequestParam("updatesid") int supplierId,
			@RequestParam("updatesname") String supname, 
			@RequestParam("updatesmobile") String supmobile, 
			@RequestParam("updatesadd") String supaddress, Model model) {
		
		System.out.println("========suplier update start==========");
		Supplier supplier=supplierdao.getSupplierById(supplierId);
		supplier.setSupplierName(supname);
		supplier.setSupplierMobileNumber(supmobile);
		supplier.setSupplierAddress(supaddress);
		
		System.out.println("========suplier update start==========");
		supplierdao.updateSupplier(supplier);
		
		System.out.println("========suplier update start==========");
		List<Supplier> getAllSup=supplierdao.getAllSupplier();
		model.addAttribute("getListOfSupplier", getAllSup);
	    return "supplier";
	}

}
