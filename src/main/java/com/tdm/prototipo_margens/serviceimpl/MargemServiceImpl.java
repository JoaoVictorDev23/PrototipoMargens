package com.tdm.prototipo_margens.serviceimpl;

import com.tdm.prototipo_margens.main.DTOs.CriarMargemDto;
import com.tdm.prototipo_margens.main.DTOs.MargemDto;
import com.tdm.prototipo_margens.main.DTOs.UsuarioDto;
import com.tdm.prototipo_margens.main.DTOs.ValoresMargemDto;
import com.tdm.prototipo_margens.main.Entidades.Margem;
import com.tdm.prototipo_margens.main.Entidades.ValoresMargem;
import com.tdm.prototipo_margens.repositories.MargemRepository;
import com.tdm.prototipo_margens.repositories.ValoresRepository;
import com.tdm.prototipo_margens.services.MargemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MargemServiceImpl implements MargemService {

    @Autowired
    MargemRepository margemRepository;
    @Autowired
    ValoresRepository valoresRepository;

    @Override
    @Transactional
    public void createMargem(CriarMargemDto margem){
        Margem margemExisting = this.margemRepository.findByLinha(margem.margemDto().linha());
        if(margemExisting != null){
            throw new RuntimeException("Linha já cadastrada anteriormente.!");
        }
        String emailUser = SecurityContextHolder.getContext().getAuthentication().getName();

        Margem newMargem = new Margem(margem.margemDto());
        newMargem.setCadastradoPor(emailUser);
        ValoresMargem newValores = new ValoresMargem(margem.valoresMargemDto());
        margemRepository.save(newMargem);
        // Obter o ID gerado automaticamente
        String idMargem = newMargem.getId();
        newValores.setIdMargem(idMargem);
        valoresRepository.save(newValores);
    }

    public List<CriarMargemDto> listAllMargens() {
        List<Margem> margemList = margemRepository.findAll();
        return margemList.stream()
                .map(margem -> {
                    ValoresMargem valoresMargem = valoresRepository.findByIdMargem(margem.getId());
                    return new CriarMargemDto(new MargemDto(margem), new ValoresMargemDto(valoresMargem));
                })
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void updateMargem(String id, CriarMargemDto margemDto) {
        // Verifique se a margem existe no banco de dados
        Margem margemExistente = margemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Margem não encontrada"));

        // Atualize os dados da margem
        margemExistente.setCliente(margemDto.margemDto().cliente());
         margemExistente.setOrigem(margemDto.margemDto().origem());
        margemExistente.setDestino(margemDto.margemDto().destino());
        margemExistente.setMargem(margemDto.margemDto().margem());
        margemExistente.setMargemAgr(margemDto.margemDto().margemAgr());
        margemExistente.setKilometragem(margemDto.margemDto().kilometragem());
        margemExistente.setPesoTon(margemDto.margemDto().pesoTon());
        margemExistente.setFrete(margemDto.margemDto().frete());
        margemExistente.setIcms(margemDto.margemDto().icms());
        margemExistente.setObservacao(margemDto.margemDto().observacao());

        // Salve a margem atualizada no banco de dados
        margemRepository.save(margemExistente);

        // Atualize os valores da margem
        ValoresMargem valoresMargem = valoresRepository.findByIdMargem(id);
        valoresMargem.setFm(margemDto.valoresMargemDto().fm());
        valoresMargem.setFe(margemDto.valoresMargemDto().fe());
        valoresMargem.setFmTruck(margemDto.valoresMargemDto().fmTruck());
        valoresMargem.setFeTruck(margemDto.valoresMargemDto().feTruck());
        valoresMargem.setFmBitrem(margemDto.valoresMargemDto().fmBitrem());
        valoresMargem.setFeBitrem(margemDto.valoresMargemDto().feBitrem());
        valoresMargem.setFmCarreta(margemDto.valoresMargemDto().fmCarreta());
        valoresMargem.setFeCarreta(margemDto.valoresMargemDto().feCarreta());
        valoresMargem.setFmGranel(margemDto.valoresMargemDto().fmGranel());
        valoresMargem.setFeGranel(margemDto.valoresMargemDto().feGranel());
        valoresMargem.setFmRodotrem(margemDto.valoresMargemDto().fmRodotrem());
        valoresMargem.setFeRodotrem(margemDto.valoresMargemDto().feRodotrem());

        // Salve os valores atualizados no banco de dados
        valoresRepository.save(valoresMargem);
    }

}

