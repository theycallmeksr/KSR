package ksr.com.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ksr.com.Supplier.*;
import ksr.com.SupplierDAO.*;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/supplier")
	public String showCategory(Model m)
	{
		List<supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		return "Supplier";
	}
	
	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	public String saveCategoryDetail(@RequestParam("supName")String supplierName,@RequestParam("supDesc") String supplierDesc,Model m)
	{
		supplier Supplier=new supplier();
		Supplier.setSupplierName(supplierName);
		Supplier.setSupplierDesc(supplierDesc);
		supplierDAO.addSupplier(Supplier);
		List<supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		supplier Supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(Supplier);
		List<supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("supplierList", listSuppliers);
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		supplier Supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute(Supplier);
		return "updatesupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	 public String updateCategory(Model m,@RequestParam("supId")int supplierID,@RequestParam("supName")String supplierName,@RequestParam("supDesc")String supplierDesc)
	 {
		 supplier Supplier=supplierDAO.getSupplier(supplierID);
		 Supplier.setSupplierName(supplierName);
		 Supplier.setSupplierDesc(supplierDesc);
		 supplierDAO.updateSupplier(Supplier);
		 List<supplier> listSuppliers=supplierDAO.listSuppliers();
		 m.addAttribute("supplierList",listSuppliers);
		 return "Supplier";
	 }	
}