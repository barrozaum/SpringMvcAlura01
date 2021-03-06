package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	private ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/form")
	public String formulario() {
		return "formulario";
	}

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		System.out.println("conta" + conta.toString());
		if(result.hasErrors()) {
			return "formulario";
		}
		
		dao.adiciona(conta);
		return "conta-adicionada";
	}

	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		List<Conta> contas = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		return mv;
	}

	@RequestMapping("/removeConta")
	public String remover(Conta conta) {
		dao.remove(conta);
		return "redirect:listaContas";

//		return "forward:listaContas";
//		return lista();
	}


	@RequestMapping("/pagaConta")
	public void pagaConta(Conta conta, HttpServletResponse response) {
		dao.paga(conta.getId());
		
		response.setStatus(200);
	}

}
