package com.example.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Compte;
import metier.session.IBanqueLocal;

@WebService
public class BanqueService {

	@EJB
	private IBanqueLocal metier;
	
	@WebMethod
	public void verser(
			@WebParam(name="code") Long cp,
			@WebParam(name="montant") double mt) {
		metier.verser(cp, mt);
	}
	
	@WebMethod
	public void virement(
			@WebParam(name="cpte1") Long cp1,
			@WebParam(name="cpte2") Long cp2,
			@WebParam(name="montant") double mt) {
		metier.virement(cp1, cp2, mt);
	}
	
	@WebMethod
	public Compte addCompte(@WebParam(name="compte")Compte compte) {
		return metier.addCompte(compte);
	}
	
	@WebMethod
	public Compte addCompteBySolde(@WebParam(name="montant") double montant) {
		Compte compte = new Compte();
		compte.setSolde(montant);
		compte.setDateCreation(new Date());
		return metier.addCompte(compte);
	}

	@WebMethod
	public Compte getCompte(@WebParam(name="code")Long code) {
		return metier.getCompte(code);
	}

	@WebMethod
	public List<Compte> listComptes() {
		return metier.listComptes();
	}

	@WebMethod
	public void retirer(@WebParam(name="code")Long code, @WebParam(name="mt") double mt) {
		metier.retirer(code, mt);
	}
}
