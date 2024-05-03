package br.edu.senaisp.SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.SpringDB.model.Banda;
import br.edu.senaisp.SpringDB.repository.BandaRepository;

@RestController
@RequestMapping("/banda")
public class BandaController {

	@Autowired
	private BandaRepository bdRep;
	
	@GetMapping
	public List<Banda> ListaBandas() {
		return bdRep.lista();
	}
	
	@GetMapping("/{id}")
	public Banda BuscarPorId(@PathVariable Integer id) {
		return bdRep.buscarPorId(id);
	}
	
	@PostMapping
	public String inserir(@RequestBody Banda banda) {
		
		System.out.println(banda.getAnoLancamento());
		
		bdRep.insere(banda);
		
		return banda.getNome()+" "+ banda.getAnoLancamento();
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestBody Banda banda) {
		bdRep.altera(banda, id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		bdRep.exclui(id);
	}
	
}
