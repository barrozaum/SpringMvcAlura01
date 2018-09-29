package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {
	private UsuarioDAO dao;

	@Autowired
	public UsuarioController(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/loginForm")
	public String formulario() {
		return "usuario/login";
	}

	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session) {
		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";

		}
		return "redirect:loginForm";
	}
}
