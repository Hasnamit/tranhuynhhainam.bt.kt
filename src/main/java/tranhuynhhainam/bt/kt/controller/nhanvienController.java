package tranhuynhhainam.bt.kt.controller;

import tranhuynhhainam.bt.kt.entity.*;
import tranhuynhhainam.bt.kt.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResultUtils;

import java.util.*;

@Controller
@RequestMapping("nhanvien")
public class nhanvienController {

	@Autowired
	private nhanvienService nhanvienService;

	@Autowired
	private phongbanService phongbanService;

	@GetMapping("/index")
	public String showAllnhanvien(Model model) {
		List<nhanvien> nhanviens = nhanvienService.getAllnhanvien();
		model.addAttribute("nhanviens", nhanviens);
		return "nhanvien/index";
	}

	@GetMapping("/add")
	public String addNVForm(Model model) {
		model.addAttribute("nhanvien", new nhanvien());
		return "nhanvien/add";
	}

	@PostMapping("/add")
	public String addNV(@Valid nhanvien nhanvien, Model model) {
		nhanvienService.add(nhanvien);
		return "redirect:/nhanvien/index";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		nhanvienService.deletenhanvien(id);
		return "redirect:/nhanvien/index";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") String id,Model model) {
		nhanvien nhanvienupdate = nhanvienService.getById(id);
		model.addAttribute("nhanvien", nhanvienupdate);

		return "nhanvien/edit";
	}
  	@PostMapping("/update")
	public String update (@Valid nhanvien nhanvien, Model model)
	{
		nhanvienService.add(nhanvien);
		return "redirect:/nhanvien/index";
	}
}
