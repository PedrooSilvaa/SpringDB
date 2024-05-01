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
	
	@GetMapping("/lista")
	public List<Banda> ListaBandas() {
		return bdRep.lista();
	}
	
	@PostMapping
	public String inserir(@RequestBody Banda banda) {
		
		System.out.println(banda.getAnoLancamento());
		
		bdRep.insere(banda.getNome(), banda.getAnoLancamento());
		
		return banda.getNome()+" "+ banda.getAnoLancamento();
	}
	
	@PutMapping("update/{id}")
	public void update(@PathVariable Integer id, @RequestBody Banda banda) {
		bdRep.altera(banda.getNome(), banda.getAnoLancamento(), id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		bdRep.exclui(id);
	}
	
}
